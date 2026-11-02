package sol_rdp.rpc;

import sol_rdp.cpn.Arco;
import sol_rdp.cpn.Lugar;
import sol_rdp.cpn.Transicao;
import sol_rdp.solidity.*;

import java.util.*;

public class RPCBuilder {

    private List<Lugar> lugares;
    private List<Transicao> transicoes;
    private List<Arco> arcos;
    private Map<String, Lugar> lugaresVariaveis;
    private Map<String, Transicao> transicoesFunc;
    private int idCounter;
    private Map<String, GerenciadorVariaveis> gerenciadoresLocais;

    // Metadados das variáveis indexadas para o lugar consolidado chaves_init (Opção
    // A)
    private List<VariavelGlobal> variaveisIndexadas;
    private Map<String, Integer> indiceVariavelNaTupla; // nomeVar -> i (0..k-1)
    private Map<String, String> variavelListaPorVar; // nomeVar -> "L1", "L2", ...
    private Map<String, String> tipoListaPorVar; // nomeVar -> "ADDRESS_LIST", "UINT_LIST", ...
    private Lugar lugarChavesInit;

    public RPCBuilder() {
        this.lugares = new ArrayList<>();
        this.transicoes = new ArrayList<>();
        this.arcos = new ArrayList<>();
        this.lugaresVariaveis = new LinkedHashMap<>();
        this.transicoesFunc = new LinkedHashMap<>();
        this.idCounter = 0;
        this.gerenciadoresLocais = new LinkedHashMap<>();
        this.variaveisIndexadas = new ArrayList<>();
        this.indiceVariavelNaTupla = new LinkedHashMap<>();
        this.variavelListaPorVar = new LinkedHashMap<>();
        this.tipoListaPorVar = new LinkedHashMap<>();
    }

    private String proximoId(String prefixo) {
        return prefixo + (++idCounter);
    }

    private boolean ehVariavelEspecialMsg(String nomeVar) {
        if (nomeVar == null)
            return false;
        String n = nomeVar.trim();
        return n.equalsIgnoreCase("msg.sender")
                || n.equalsIgnoreCase("msg.send")
                || n.equalsIgnoreCase("msg.value");
    }

    private boolean ehFuncaoConstrutora(FuncaoSolidity func) {
        if (func == null)
            return false;
        return func.isConstructor()
                || func.getNome().equalsIgnoreCase("constructor")
                || func.getNome().equalsIgnoreCase("construtor");
    }

    public void construirRPC(ListasInfo info) {
        normalizarVariaveisGlobais(info);
        garantirExistenciaConstrutor(info);
        criarLugaresVariaveis(info);
        criarLugaresOraculos(info);
        criarTransicoesFuncoes(info);
        criarArcosFluxoDados(info);
        criarArcosDeChamadas(info);
        criarSubredeInicializacaoSobDemanda(info);
    }

    private void normalizarVariaveisGlobais(ListasInfo info) {
        for (VariavelGlobal var : info.getVariaveisGlobais()) {
            if (ehVariavelEspecialMsg(var.getNome()))
                continue;

            String tipo = (var.getTipo() != null) ? var.getTipo().trim() : "";
            String nome = (var.getNome() != null) ? var.getNome().trim() : "";
            String tipoIndice = (var.getTipoIndice() != null) ? var.getTipoIndice().trim() : "";

            if (tipo.contains("[")) {
                String tipoBase = tipo.substring(0, tipo.indexOf('[')).trim();
                var.setTipo(tipoBase);
                if (tipoIndice.isEmpty()) {
                    var.setTipoIndice("uint");
                }
            }

            if (nome.contains("[")) {
                String nomeBase = nome.substring(0, nome.indexOf('[')).trim();
                var.setNome(nomeBase);
                if (var.getTipoIndice() == null || var.getTipoIndice().trim().isEmpty()) {
                    var.setTipoIndice("uint");
                }
            }

            if (var.getTipoIndice() == null || var.getTipoIndice().trim().isEmpty()) {
                if (variavelAcessadaComColchetesNoContrato(var.getNome(), info)) {
                    var.setTipoIndice("uint");
                }
            }
        }
    }

    private boolean variavelAcessadaComColchetesNoContrato(String nomeVar, ListasInfo info) {
        String padrao = nomeVar + "[";
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (op.getVariavelDestino().contains(padrao))
                return true;
            for (String oper : op.getOperandos()) {
                if (oper.contains(padrao))
                    return true;
            }
        }
        for (Condicional cond : info.getCondicionais()) {
            if (cond.getExpressao().contains(padrao))
                return true;
        }
        return false;
    }

    private void garantirExistenciaConstrutor(ListasInfo info) {
        boolean temConstrutor = false;
        for (FuncaoSolidity f : info.getFuncoes()) {
            if (ehFuncaoConstrutora(f)) {
                temConstrutor = true;
                break;
            }
        }

        if (!temConstrutor) {
            FuncaoSolidity construtorPadrao = new FuncaoSolidity(
                    "construtor",
                    new ArrayList<>(),
                    new ArrayList<>(),
                    "public",
                    new LinkedHashMap<>(),
                    0,
                    1,
                    new ArrayList<>(),
                    true);
            info.adicionarFuncao(construtorPadrao);
        }
    }

    public void criarLugaresVariaveis(ListasInfo info) {
        int idxLista = 1;
        for (VariavelGlobal var : info.getVariaveisGlobais()) {
            if (ehVariavelEspecialMsg(var.getNome())) {
                continue;
            }

            String colorSet = obterColorSetVariavel(var);
            Lugar lugar = new Lugar(proximoId("P"), var.getNome(), colorSet, "", false);
            this.lugares.add(lugar);
            this.lugaresVariaveis.put(var.getNome(), lugar);

            if (ehVariavelIndexada(var)) {
                int pos = variaveisIndexadas.size();
                variaveisIndexadas.add(var);
                indiceVariavelNaTupla.put(var.getNome(), pos);

                String varLista = "L" + idxLista++;
                String tipoIndiceSML = mapearTipoPrimitivoSML(var.getTipoIndice());
                String tipoListaSML = tipoIndiceSML + "_LIST";

                variavelListaPorVar.put(var.getNome(), varLista);
                tipoListaPorVar.put(var.getNome(), tipoListaSML);
            }
        }

        if (!variaveisIndexadas.isEmpty()) {
            String colorSetChavesInit;
            if (variaveisIndexadas.size() == 1) {
                colorSetChavesInit = tipoListaPorVar.get(variaveisIndexadas.get(0).getNome());
            } else {
                colorSetChavesInit = String.join("x", tipoListaPorVar.values());
            }
            this.lugarChavesInit = new Lugar(proximoId("P"), "chaves_init", colorSetChavesInit, "", false);
            this.lugares.add(this.lugarChavesInit);
            this.lugaresVariaveis.put("chaves_init", this.lugarChavesInit);
        }
    }

    /**
     * Passo 1b: Cria os lugares de parâmetros das funções, parconstrutor e lugares
     * oráculo (msg.send e msg.value).
     */
    public void criarLugaresOraculos(ListasInfo info) {
        boolean usaMsgSender = false;
        boolean usaMsgValue = false;

        for (OperacaoSolidity op : info.getOperacoes()) {
            String textoOp = op.getVariavelDestino() + " " + op.getOperador() + " " + op.getOperandos().toString();
            if (textoOp.contains("msg.sender"))
                usaMsgSender = true;
            if (textoOp.contains("msg.value"))
                usaMsgValue = true;
        }
        for (Condicional cond : info.getCondicionais()) {
            if (cond.getExpressao().contains("msg.sender"))
                usaMsgSender = true;
            if (cond.getExpressao().contains("msg.value"))
                usaMsgValue = true;
        }

        if (usaMsgSender && !lugaresVariaveis.containsKey("msg.send")) {
            Lugar msgSend = new Lugar(proximoId("P"), "msg.send", "ADDRESS", "", true);
            this.lugares.add(msgSend);
            this.lugaresVariaveis.put("msg.send", msgSend);
        }

        if (usaMsgValue && !lugaresVariaveis.containsKey("msg.value")) {
            Lugar msgVal = new Lugar(proximoId("P"), "msg.value", "UINT", "", true);
            this.lugares.add(msgVal);
            this.lugaresVariaveis.put("msg.value", msgVal);
        }

        for (FuncaoSolidity func : info.getFuncoes()) {
            if (ehFuncaoConstrutora(func)) {
                String nomeLugar = "parconstrutor";
                if (!func.getParametros().isEmpty()) {
                    String corParam = obterColorSetParametros(func.getParametros());
                    Lugar parConst = new Lugar(proximoId("P"), nomeLugar, corParam, "", false);
                    this.lugares.add(parConst);
                    this.lugaresVariaveis.put(nomeLugar, parConst);
                } else {
                    Lugar parConst = new Lugar(proximoId("P"), nomeLugar, "BOOL", "1`true", false);
                    this.lugares.add(parConst);
                    this.lugaresVariaveis.put(nomeLugar, parConst);
                }
            } else if (!func.getParametros().isEmpty()) {
                String nomeLugar = "par" + func.getNome();
                String corParam = obterColorSetParametros(func.getParametros());
                boolean isOraculo = func.getVisibilidade().equalsIgnoreCase("public")
                        || func.getVisibilidade().equalsIgnoreCase("external");
                Lugar lugarParam = new Lugar(proximoId("P"), nomeLugar, corParam, "", isOraculo);
                this.lugares.add(lugarParam);
                this.lugaresVariaveis.put(nomeLugar, lugarParam);
            }
        }
    }

    public void criarTransicoesFuncoes(ListasInfo info) {
        for (FuncaoSolidity func : info.getFuncoes()) {
            String nomeTrans = ehFuncaoConstrutora(func) ? "construtor" : func.getNome();
            Transicao trans = new Transicao(proximoId("T"), nomeTrans, "");
            this.transicoes.add(trans);
            this.transicoesFunc.put(func.getNome(), trans);
            this.gerenciadoresLocais.put(func.getNome(), new GerenciadorVariaveis());
        }
    }

    public void criarArcosFluxoDados(ListasInfo info) {
        for (FuncaoSolidity func : info.getFuncoes()) {
            Transicao trans = this.transicoesFunc.get(func.getNome());
            GerenciadorVariaveis gv = this.gerenciadoresLocais.get(func.getNome());

            // 1. Conecta lugar de parâmetros à transição
            if (ehFuncaoConstrutora(func)) {
                Lugar parConst = this.lugaresVariaveis.get("parconstrutor");
                if (parConst != null) {
                    String exprParam = mapearParametrosEntrada(func, parConst, gv);
                    this.arcos.add(new Arco(proximoId("A"), parConst.getId(), trans.getId(), exprParam));
                }
            } else if (!func.getParametros().isEmpty()) {
                Lugar lugarParam = this.lugaresVariaveis.get("par" + func.getNome());
                if (lugarParam != null) {
                    String exprParam = mapearParametrosEntrada(func, lugarParam, gv);
                    this.arcos.add(new Arco(proximoId("A"), lugarParam.getId(), trans.getId(), exprParam));
                }
            }

            // 2a. Conecta msg.send se a função utilizar msg.sender
            if (funcaoUsaMsgSender(func.getNome(), info)) {
                Lugar lugarMsg = this.lugaresVariaveis.get("msg.send");
                if (lugarMsg != null) {
                    String varMsg = gv.obterOuAlocarVariavel("msg.sender", "ADDRESS");
                    this.arcos.add(new Arco(proximoId("A"), lugarMsg.getId(), trans.getId(), "1`" + varMsg));
                }
            }

            // 2b. Conecta msg.value se a função utilizar msg.value
            if (funcaoUsaMsgValue(func.getNome(), info)) {
                Lugar lugarVal = this.lugaresVariaveis.get("msg.value");
                if (lugarVal != null) {
                    String varVal = gv.obterOuAlocarVariavel("msg.value", "UINT");
                    this.arcos.add(new Arco(proximoId("A"), lugarVal.getId(), trans.getId(), "1`" + varVal));
                }
            }

            // 3. Tratamento do Construtor vs. Funções de Negócio
            if (ehFuncaoConstrutora(func)) {
                criarArcosInicializacaoConstrutor(func, trans, gv, info);
            } else {
                criarArcosDuplosFuncao(func, trans, gv, info);
            }
        }
    }

    private void criarArcosInicializacaoConstrutor(
            FuncaoSolidity func, Transicao transConst, GerenciadorVariaveis gv, ListasInfo info) {

        List<String> listasIniciais = new ArrayList<>();
        Map<String, String> expressoesLocais = construirMapaVariaveisLocais(func.getNome(), gv, info);

        for (VariavelGlobal var : info.getVariaveisGlobais()) {
            if (ehVariavelEspecialMsg(var.getNome())) {
                continue;
            }
            Lugar lugarVar = this.lugaresVariaveis.get(var.getNome());
            if (lugarVar == null) {
                continue;
            }

            OperacaoSolidity opAtrib = buscarOperacaoVariavelNaFuncao(func.getNome(), var.getNome(), info);

            if (ehVariavelIndexada(var)) {
                if (opAtrib != null && opAtrib.getVariavelDestino().contains("[")) {
                    String chaveSol = extrairIndiceAcesso(opAtrib.getVariavelDestino());
                    String tipoIndiceSML = mapearTipoPrimitivoSML(var.getTipoIndice());
                    String varChaveSML = resolverOperandoParaSML(chaveSol, tipoIndiceSML, gv, expressoesLocais, info);
                    String valSML = traduzirExpressaoDireitaSML(opAtrib, var, null, gv, expressoesLocais, info);

                    this.arcos.add(new Arco(
                            proximoId("A"), transConst.getId(), lugarVar.getId(),
                            "1`(" + varChaveSML + ", " + valSML + ")"));
                    listasIniciais.add("[" + varChaveSML + "]");
                } else {
                    listasIniciais.add("[]");
                }
            } else {
                String valorSaida;
                if (opAtrib != null) {
                    valorSaida = traduzirExpressaoDireitaSML(opAtrib, var, null, gv, expressoesLocais, info);
                } else if (var.getValorInicial() != null && !var.getValorInicial().trim().isEmpty()) {
                    valorSaida = formatarLiteralSML(var.getValorInicial(), var.getTipo(), info);
                } else {
                    valorSaida = obterValorPadraoPrimitivo(var.getTipo(), info);
                }
                this.arcos.add(new Arco(
                        proximoId("A"), transConst.getId(), lugarVar.getId(), "1`" + valorSaida));
            }
        }

        if (this.lugarChavesInit != null && !listasIniciais.isEmpty()) {
            String exprChavesInit;
            if (listasIniciais.size() == 1) {
                exprChavesInit = "1`" + listasIniciais.get(0);
            } else {
                exprChavesInit = "1`(" + String.join(", ", listasIniciais) + ")";
            }
            this.arcos.add(new Arco(
                    proximoId("A"), transConst.getId(), this.lugarChavesInit.getId(), exprChavesInit));
        }
    }

    private void criarArcosDuplosFuncao(
            FuncaoSolidity func, Transicao trans, GerenciadorVariaveis gv, ListasInfo info) {

        List<VariavelGlobal> varsUsadas = new ArrayList<>();
        Map<String, String> chavesSMLPorVar = new LinkedHashMap<>();
        Map<String, String> valoresAntigosSMLPorVar = new LinkedHashMap<>();

        // 1ª Passada: Arcos de Entrada (LugarVar -> Transicao)
        for (VariavelGlobal var : info.getVariaveisGlobais()) {
            if (ehVariavelEspecialMsg(var.getNome()))
                continue;
            if (!variavelUsadaNaFuncao(var.getNome(), func.getNome(), info))
                continue;

            Lugar lugarVar = this.lugaresVariaveis.get(var.getNome());
            if (lugarVar == null)
                continue;

            varsUsadas.add(var);
            String exprEntrada;

            if (ehVariavelIndexada(var)) {
                String chaveSol = descobrirExpressaoIndiceUsada(var.getNome(), func.getNome(), info);
                String tipoIndiceSML = mapearTipoPrimitivoSML(var.getTipoIndice());
                String varChaveSML = resolverOperandoParaSML(chaveSol, tipoIndiceSML, gv, Collections.emptyMap(), info);

                String tipoValorSML = mapearTipoPrimitivoSML(var.getTipo());
                String varValorAntigoSML = gv.obterOuAlocarVariavel(
                        var.getNome() + "[" + chaveSol + "]", tipoValorSML);

                chavesSMLPorVar.put(var.getNome(), varChaveSML);
                valoresAntigosSMLPorVar.put(var.getNome(), varValorAntigoSML);
                exprEntrada = "1`(" + varChaveSML + ", " + varValorAntigoSML + ")";
            } else {
                String tipoSML = mapearTipoPrimitivoSML(var.getTipo());
                String varValorAntigoSML = gv.obterOuAlocarVariavel(var.getNome(), tipoSML);
                valoresAntigosSMLPorVar.put(var.getNome(), varValorAntigoSML);
                exprEntrada = "1`" + varValorAntigoSML;
            }

            this.arcos.add(new Arco(proximoId("A"), lugarVar.getId(), trans.getId(), exprEntrada));
        }

        // Resolve variáveis locais declaradas dentro da função como expressões
        // matemáticas SML
        Map<String, String> expressoesLocais = construirMapaVariaveisLocais(func.getNome(), gv, info);

        // 2ª Passada: Arcos de Saída (Transicao -> LugarVar)
        for (VariavelGlobal var : varsUsadas) {
            Lugar lugarVar = this.lugaresVariaveis.get(var.getNome());
            OperacaoSolidity op = buscarOperacaoVariavelNaFuncao(func.getNome(), var.getNome(), info);
            String varChaveSML = chavesSMLPorVar.get(var.getNome());
            String varValorAntigoSML = valoresAntigosSMLPorVar.get(var.getNome());

            String exprSaida = construirExpressaoSaidaVariavel(
                    func, var, op, varChaveSML, varValorAntigoSML, gv, expressoesLocais, info);
            this.arcos.add(new Arco(proximoId("A"), trans.getId(), lugarVar.getId(), exprSaida));
        }
    }

    /**
     * Constrói um mapa de variáveis locais da função para suas respectivas
     * expressões matemáticas em SML
     * (ex: "half" -> "(E div 2)", "remainder" -> "(E - (E div 2))").
     */
    private Map<String, String> construirMapaVariaveisLocais(
            String nomeFuncao, GerenciadorVariaveis gv, ListasInfo info) {

        Map<String, String> expressoesLocais = new LinkedHashMap<>();
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (!op.getNomeFuncao().equals(nomeFuncao))
                continue;

            String destBruto = op.getVariavelDestino().trim();
            String destLimpo = limparPrefixoTipoLocal(destBruto, info);

            if (ehVariavelGlobalDoContrato(destLimpo, info) || ehVariavelEspecialMsg(destLimpo)) {
                continue;
            }

            String rhsSol = op.getOperandos().isEmpty()
                    ? op.getOperador()
                    : op.getOperandos().get(op.getOperandos().size() - 1);

            String exprSML = traduzirExpressaoMatematicaSML(rhsSol, "UINT", gv, expressoesLocais, info);
            if (exprSML.contains("+") || exprSML.contains("-") || exprSML.contains("*")
                    || exprSML.contains("div") || exprSML.contains("mod")) {
                exprSML = "(" + exprSML + ")";
            }
            expressoesLocais.put(destLimpo, exprSML);
            if (!destBruto.equals(destLimpo)) {
                expressoesLocais.put(destBruto, exprSML);
            }
        }
        return expressoesLocais;
    }

    private boolean ehVariavelGlobalDoContrato(String expr, ListasInfo info) {
        String e = expr.trim();
        for (VariavelGlobal var : info.getVariaveisGlobais()) {
            if (e.equals(var.getNome()) || e.startsWith(var.getNome() + "[")) {
                return true;
            }
        }
        return false;
    }

    private String limparPrefixoTipoLocal(String ident, ListasInfo info) {
        if (ident == null || ident.isEmpty())
            return "";
        String s = ident.trim();
        if (ehVariavelGlobalDoContrato(s, info))
            return s;

        String limpo = s.replaceFirst(
                "^(u?int(8|16|24|32|40|48|56|64|72|80|88|96|104|112|120|128|136|144|152|160|168|176|184|192|200|208|216|224|232|240|248|256)?|bool|address(payable)?|string|bytes(1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32)?)(memory|storage|calldata)?",
                "").trim();
        return limpo.isEmpty() ? s : limpo;
    }

    public void criarArcosDeChamadas(ListasInfo info) {
        for (ChamadaFuncao call : info.getChamadas()) {
            String nomeA = call.getNomeFuncaoChamadora();
            String nomeB = call.getNomeFuncaoAlvo();

            Transicao transChamadora = this.transicoesFunc.get(nomeA);
            Lugar lugarDestino = this.lugaresVariaveis.get("par" + nomeB);
            String funcEscopo = nomeA;

            if (lugarDestino == null && this.lugaresVariaveis.containsKey("par" + nomeA)
                    && this.transicoesFunc.containsKey(nomeB)) {
                transChamadora = this.transicoesFunc.get(nomeB);
                lugarDestino = this.lugaresVariaveis.get("par" + nomeA);
                funcEscopo = nomeB;
            }

            if (transChamadora == null || lugarDestino == null
                    || transChamadora.getName().equals("par" + lugarDestino.getName())) {
                continue;
            }
            if (lugarDestino.getName().equals("par" + transChamadora.getName())) {
                continue;
            }

            GerenciadorVariaveis gv = this.gerenciadoresLocais.get(funcEscopo);
            Map<String, String> expressoesLocais = construirMapaVariaveisLocais(funcEscopo, gv, info);
            List<String> argsSML = new ArrayList<>();
            for (String argSol : call.getArgumentos()) {
                String varSML = gv.buscarVariavelSML(argSol.trim());
                if (varSML == null) {
                    varSML = traduzirExpressaoMatematicaSML(argSol.trim(), "UINT", gv, expressoesLocais, info);
                }
                argsSML.add(varSML);
            }

            String tokenChamada = argsSML.size() == 1
                    ? "1`" + argsSML.get(0)
                    : "1`(" + String.join(", ", argsSML) + ")";

            List<Condicional> conds = buscarCondicionaisDaFuncao(funcEscopo, info);
            String exprArcoChamada = aplicarCondicionaisEmChamada(tokenChamada, conds, gv, expressoesLocais, info);

            this.arcos.add(new Arco(
                    proximoId("A"), transChamadora.getId(), lugarDestino.getId(), exprArcoChamada));
        }
    }

    public void criarSubredeInicializacaoSobDemanda(ListasInfo info) {
        if (this.lugarChavesInit == null || this.variaveisIndexadas.isEmpty()) {
            return;
        }

        Set<String> initsCriados = new HashSet<>();
        int totalIndexadas = this.variaveisIndexadas.size();
        List<Arco> arcosAtuais = new ArrayList<>(this.arcos);

        for (VariavelGlobal varIndexada : this.variaveisIndexadas) {
            Lugar lugarMap = this.lugaresVariaveis.get(varIndexada.getNome());
            if (lugarMap == null)
                continue;

            int posNaTupla = this.indiceVariavelNaTupla.get(varIndexada.getNome());
            String varListaAlvo = this.variavelListaPorVar.get(varIndexada.getNome());
            String tipoListaAlvo = this.tipoListaPorVar.get(varIndexada.getNome());
            String valorPadraoElem = obterValorPadraoPrimitivo(varIndexada.getTipo(), info);

            for (Arco arcoLeitura : arcosAtuais) {
                if (!arcoLeitura.getSourceId().equals(lugarMap.getId()))
                    continue;

                String idTransicao = arcoLeitura.getTargetId();
                String varChaveK = extrairPrimeiroElementoTuplaSML(arcoLeitura.getExpression());
                if (varChaveK == null || varChaveK.isEmpty())
                    continue;

                Arco arcoFornecedor = buscarArcoFornecedorDaChave(
                        idTransicao, lugarMap.getId(), varChaveK, arcosAtuais);
                if (arcoFornecedor == null)
                    continue;

                String idLugarOrigem = arcoFornecedor.getSourceId();
                String exprOrigem = arcoFornecedor.getExpression();

                String chaveUnicaInit = varIndexada.getNome() + ":" + idLugarOrigem + ":" + varChaveK;
                if (initsCriados.contains(chaveUnicaInit))
                    continue;
                initsCriados.add(chaveUnicaInit);

                String nomeTransInit = "init_" + varIndexada.getNome() + "_" + varChaveK;
                String guardaSML = "[not (mem " + varListaAlvo + " " + varChaveK + ")]";
                Transicao transInit = new Transicao(proximoId("T"), nomeTransInit, guardaSML);
                this.transicoes.add(transInit);

                GerenciadorVariaveis gvInit = new GerenciadorVariaveis();
                gvInit.registrarVariavelExplicita(varListaAlvo, varListaAlvo, tipoListaAlvo);
                this.gerenciadoresLocais.put(nomeTransInit, gvInit);

                this.arcos.add(new Arco(proximoId("A"), idLugarOrigem, transInit.getId(), exprOrigem));
                this.arcos.add(new Arco(proximoId("A"), transInit.getId(), idLugarOrigem, exprOrigem));

                String exprConsumoChaves = construirTuplaListasConsumo(totalIndexadas);
                String exprProducaoChaves = construirTuplaListasAtualizada(
                        totalIndexadas, posNaTupla, varChaveK);
                this.arcos.add(new Arco(
                        proximoId("A"), this.lugarChavesInit.getId(), transInit.getId(), exprConsumoChaves));
                this.arcos.add(new Arco(
                        proximoId("A"), transInit.getId(), this.lugarChavesInit.getId(), exprProducaoChaves));

                String exprNovoElemento = "1`(" + varChaveK + ", " + valorPadraoElem + ")";
                this.arcos.add(new Arco(
                        proximoId("A"), transInit.getId(), lugarMap.getId(), exprNovoElemento));
            }
        }
    }

    private String construirTuplaListasConsumo(int k) {
        if (k == 1) {
            return "1`L1";
        }
        List<String> elems = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            elems.add("L" + i);
        }
        return "1`(" + String.join(", ", elems) + ")";
    }

    private String construirTuplaListasAtualizada(int k, int indiceAlvo, String varChaveK) {
        if (k == 1) {
            return "1`(" + varChaveK + " :: L1)";
        }
        List<String> elems = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String nomeLista = "L" + (i + 1);
            if (i == indiceAlvo) {
                elems.add(varChaveK + " :: " + nomeLista);
            } else {
                elems.add(nomeLista);
            }
        }
        return "1`(" + String.join(", ", elems) + ")";
    }

    private Arco buscarArcoFornecedorDaChave(
            String idTransicao, String idLugarMap, String varChaveK, List<Arco> todosArcos) {
        for (Arco a : todosArcos) {
            if (a.getTargetId().equals(idTransicao) && !a.getSourceId().equals(idLugarMap)) {
                if (expressaoContemVariavelSML(a.getExpression(), varChaveK)) {
                    return a;
                }
            }
        }
        return null;
    }

    private boolean expressaoContemVariavelSML(String expr, String varSML) {
        String limpa = expr.replace("1`", "").replace("(", "").replace(")", "");
        String[] partes = limpa.split(",");
        for (String p : partes) {
            if (p.trim().equals(varSML))
                return true;
        }
        return false;
    }

    private String extrairPrimeiroElementoTuplaSML(String expr) {
        int abre = expr.indexOf('(');
        int virgula = expr.indexOf(',');
        if (abre != -1 && virgula != -1 && virgula > abre) {
            return expr.substring(abre + 1, virgula).trim();
        }
        return null;
    }

    private String mapearParametrosEntrada(FuncaoSolidity func, Lugar lugarParam, GerenciadorVariaveis gv) {
        if (func.getParametros().isEmpty()) {
            String varBool = gv.obterOuAlocarVariavel("parconstrutor", "BOOL");
            return "1`" + varBool;
        }
        List<String> vars = new ArrayList<>();
        for (Map.Entry<String, String> entry : func.getParametros().entrySet()) {
            String nomeParam = entry.getKey();
            String tipoSML = mapearTipoPrimitivoSML(entry.getValue());
            vars.add(gv.obterOuAlocarVariavel(nomeParam, tipoSML));
        }
        if (vars.size() == 1) {
            return "1`" + vars.get(0);
        }
        return "1`(" + String.join(", ", vars) + ")";
    }

    private String construirExpressaoSaidaVariavel(
            FuncaoSolidity func,
            VariavelGlobal var,
            OperacaoSolidity op,
            String varChaveSML,
            String varValorAntigoSML,
            GerenciadorVariaveis gv,
            Map<String, String> expressoesLocais,
            ListasInfo info) {

        String tokenOriginal = ehVariavelIndexada(var)
                ? "1`(" + varChaveSML + ", " + varValorAntigoSML + ")"
                : "1`" + varValorAntigoSML;

        if (op == null) {
            return tokenOriginal;
        }

        String novoValorSML = traduzirExpressaoDireitaSML(op, var, varValorAntigoSML, gv, expressoesLocais, info);
        String tokenModificado;
        if (ehVariavelIndexada(var)) {
            tokenModificado = "1`(" + varChaveSML + ", " + novoValorSML + ")";
        } else {
            if (novoValorSML.contains("+") || novoValorSML.contains("-")
                    || novoValorSML.contains("*") || novoValorSML.contains("div")
                    || novoValorSML.contains("mod")) {
                tokenModificado = "1`(" + novoValorSML + ")";
            } else {
                tokenModificado = "1`" + novoValorSML;
            }
        }

        List<Condicional> conds = buscarCondicionaisDaFuncao(func.getNome(), info);
        if (conds.isEmpty()) {
            return tokenModificado;
        }

        Condicional c = conds.get(0);
        String condSML = traduzirCondicaoParaSML(c.getExpressao(), gv, expressoesLocais, info);
        if (c.getTipo().equalsIgnoreCase("if_revert") || c.getTipo().equalsIgnoreCase("if")) {
            return "if " + condSML + " then " + tokenOriginal + " else " + tokenModificado;
        } else {
            return "if " + condSML + " then " + tokenModificado + " else " + tokenOriginal;
        }
    }

    private String aplicarCondicionaisEmChamada(
            String tokenChamada,
            List<Condicional> conds,
            GerenciadorVariaveis gv,
            Map<String, String> expressoesLocais,
            ListasInfo info) {
        if (conds.isEmpty()) {
            return tokenChamada;
        }
        Condicional c = conds.get(0);
        String condSML = traduzirCondicaoParaSML(c.getExpressao(), gv, expressoesLocais, info);
        if (c.getTipo().equalsIgnoreCase("if_revert") || c.getTipo().equalsIgnoreCase("if")) {
            return "if " + condSML + " then empty else " + tokenChamada;
        } else {
            return "if " + condSML + " then " + tokenChamada + " else empty";
        }
    }

    private String traduzirExpressaoDireitaSML(
            OperacaoSolidity op,
            VariavelGlobal var,
            String varValorAntigoSML,
            GerenciadorVariaveis gv,
            Map<String, String> expressoesLocais,
            ListasInfo info) {

        String opStr = op.getOperador().trim();
        String tipoAlvoSML = mapearTipoPrimitivoSML(var.getTipo());

        if (opStr.equals("+=")) {
            String rhs = op.getOperandos().isEmpty() ? "0" : op.getOperandos().get(op.getOperandos().size() - 1);
            String rhsSML = traduzirExpressaoMatematicaSML(rhs, tipoAlvoSML, gv, expressoesLocais, info);
            return varValorAntigoSML + "+" + rhsSML;
        } else if (opStr.equals("-=")) {
            String rhs = op.getOperandos().isEmpty() ? "0" : op.getOperandos().get(op.getOperandos().size() - 1);
            String rhsSML = traduzirExpressaoMatematicaSML(rhs, tipoAlvoSML, gv, expressoesLocais, info);
            return varValorAntigoSML + "-" + rhsSML;
        } else {
            if (!op.getOperandos().isEmpty()) {
                String rhs = op.getOperandos().get(op.getOperandos().size() - 1);
                return traduzirExpressaoMatematicaSML(rhs, tipoAlvoSML, gv, expressoesLocais, info);
            }
            return traduzirExpressaoMatematicaSML(opStr, tipoAlvoSML, gv, expressoesLocais, info);
        }
    }

    /**
     * Tokeniza e traduz expressões matemáticas do Solidity (ex: "balanceA + half",
     * "amount / 2")
     * para Standard ML do CPN Tools, substituindo variáveis locais e convertendo
     * "/" para "div" e "%" para "mod".
     */
    private String traduzirExpressaoMatematicaSML(
            String exprSol,
            String tipoPadraoSML,
            GerenciadorVariaveis gv,
            Map<String, String> expressoesLocais,
            ListasInfo info) {

        if (exprSol == null || exprSol.trim().isEmpty())
            return "0";
        String limpa = exprSol.trim();

        // Se a expressão inteira já for uma variável conhecida ou local, retorna direto
        if (expressoesLocais != null && expressoesLocais.containsKey(limpa)) {
            return expressoesLocais.get(limpa);
        }
        if (gv.buscarVariavelSML(limpa) != null) {
            return gv.buscarVariavelSML(limpa);
        }

        List<String> tokens = tokenizarExpressaoMatematica(limpa);
        if (tokens.size() == 1) {
            return resolverOperandoParaSML(tokens.get(0), tipoPadraoSML, gv, expressoesLocais, info);
        }

        StringBuilder sb = new StringBuilder();
        for (String tk : tokens) {
            String t = tk.trim();
            if (t.isEmpty())
                continue;

            switch (t) {
                case "+":
                case "-":
                case "*":
                    sb.append(" ").append(t).append(" ");
                    break;
                case "/":
                    sb.append(" div ");
                    break;
                case "%":
                    sb.append(" mod ");
                    break;
                case "(":
                case ")":
                    sb.append(t);
                    break;
                default:
                    sb.append(resolverOperandoParaSML(t, tipoPadraoSML, gv, expressoesLocais, info));
                    break;
            }
        }
        return sb.toString().trim();
    }

    /**
     * Divide uma expressão matemática nos operadores (+, -, *, /, %, (, )),
     * preservando intactos acessos indexados entre colchetes como
     * "pesoEleitor[msg.sender]".
     */
    private List<String> tokenizarExpressaoMatematica(String expr) {
        List<String> tokens = new ArrayList<>();
        StringBuilder atual = new StringBuilder();
        int nivelColchetes = 0;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '[') {
                nivelColchetes++;
                atual.append(c);
            } else if (c == ']') {
                if (nivelColchetes > 0)
                    nivelColchetes--;
                atual.append(c);
            } else if (nivelColchetes == 0
                    && (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '(' || c == ')')) {
                if (atual.length() > 0) {
                    tokens.add(atual.toString().trim());
                    atual.setLength(0);
                }
                tokens.add(String.valueOf(c));
            } else {
                atual.append(c);
            }
        }
        if (atual.length() > 0) {
            tokens.add(atual.toString().trim());
        }
        return tokens;
    }

    private String traduzirCondicaoParaSML(
            String exprSol,
            GerenciadorVariaveis gv,
            Map<String, String> expressoesLocais,
            ListasInfo info) {

        String s = exprSol.trim();
        s = s.replace("==", "=").replace("!=", "<>");

        // 1. Substitui variáveis locais caso estejam presentes na condição
        if (expressoesLocais != null) {
            List<Map.Entry<String, String>> locaisOrd = new ArrayList<>(expressoesLocais.entrySet());
            locaisOrd.sort((a, b) -> Integer.compare(b.getKey().length(), a.getKey().length()));
            for (Map.Entry<String, String> entry : locaisOrd) {
                if (s.contains(entry.getKey())) {
                    s = s.replace(entry.getKey(), entry.getValue());
                }
            }
        }

        // 2. Substitui variáveis do GerenciadorVariaveis ordenadas da maior para a
        // menor
        List<Map.Entry<String, String>> entradas = new ArrayList<>(gv.getMapaSolidityParaSML().entrySet());
        entradas.sort((a, b) -> Integer.compare(b.getKey().length(), a.getKey().length()));

        for (Map.Entry<String, String> entry : entradas) {
            String solVar = entry.getKey();
            String smlVar = entry.getValue();
            if (s.contains(solVar)) {
                s = s.replace(solVar, smlVar);
            }
        }
        return s;
    }

    private String resolverOperandoParaSML(
            String operando,
            String tipoPadraoSML,
            GerenciadorVariaveis gv,
            Map<String, String> expressoesLocais,
            ListasInfo info) {

        String limpo = operando.trim();
        if (expressoesLocais != null && expressoesLocais.containsKey(limpo)) {
            return expressoesLocais.get(limpo);
        }
        if (gv.buscarVariavelSML(limpo) != null) {
            return gv.buscarVariavelSML(limpo);
        }
        if (limpo.matches("\\d+") || limpo.equals("true") || limpo.equals("false")) {
            return limpo;
        }
        if (limpo.contains(".")) {
            String[] partes = limpo.split("\\.");
            if (partes.length == 2 && !limpo.startsWith("msg.")) {
                for (EnumSolidity en : info.getEnums()) {
                    if (en.getNome().equals(partes[0])) {
                        return partes[1];
                    }
                }
            }
        }
        return gv.obterOuAlocarVariavel(limpo, tipoPadraoSML);
    }

    private boolean ehVariavelIndexada(VariavelGlobal var) {
        return var.getTipoIndice() != null && !var.getTipoIndice().trim().isEmpty();
    }

    private String obterColorSetVariavel(VariavelGlobal var) {
        String tipoBase = mapearTipoPrimitivoSML(var.getTipo());
        if (ehVariavelIndexada(var)) {
            String tipoIndice = mapearTipoPrimitivoSML(var.getTipoIndice());
            return tipoIndice + "x" + tipoBase;
        }
        return tipoBase;
    }

    private String obterColorSetParametros(Map<String, String> parametros) {
        List<String> tipos = new ArrayList<>();
        for (String t : parametros.values()) {
            tipos.add(mapearTipoPrimitivoSML(t));
        }
        return String.join("x", tipos);
    }

    public static String mapearTipoPrimitivoSML(String tipoSolidity) {
        if (tipoSolidity == null)
            return "UINT";
        String t = tipoSolidity.trim().toLowerCase();
        if (t.contains("[")) {
            t = t.substring(0, t.indexOf('[')).trim();
        }
        if (t.startsWith("uint") || t.startsWith("int"))
            return "UINT";
        if (t.startsWith("address"))
            return "ADDRESS";
        if (t.equals("bool"))
            return "BOOL";
        if (t.equals("string") || t.startsWith("bytes"))
            return "STRING";
        return t.toUpperCase();
    }

    private String obterValorPadraoPrimitivo(String tipoSolidity, ListasInfo info) {
        String t = tipoSolidity.trim();
        if (t.contains("[")) {
            t = t.substring(0, t.indexOf('[')).trim();
        }
        if (t.startsWith("uint") || t.startsWith("int"))
            return "0";
        if (t.equals("bool"))
            return "false";
        if (t.startsWith("address"))
            return "\"0x0\"";
        if (t.equals("string") || t.startsWith("bytes"))
            return "\"\"";
        for (EnumSolidity en : info.getEnums()) {
            if (en.getNome().equals(t) && !en.getValores().isEmpty()) {
                return en.getValores().get(0);
            }
        }
        return "0";
    }

    private String formatarLiteralSML(String valor, String tipo, ListasInfo info) {
        String v = valor.trim();
        if (v.contains(".")) {
            String[] partes = v.split("\\.");
            if (partes.length == 2)
                return partes[1];
        }
        if (tipo.startsWith("address") && !v.startsWith("\"")) {
            return "\"" + v + "\"";
        }
        return v;
    }

    private boolean funcaoUsaMsgSender(String nomeFuncao, ListasInfo info) {
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (op.getNomeFuncao().equals(nomeFuncao)) {
                if (op.getVariavelDestino().contains("msg.sender")
                        || op.getOperador().contains("msg.sender")
                        || op.getOperandos().toString().contains("msg.sender")) {
                    return true;
                }
            }
        }
        for (Condicional cond : info.getCondicionais()) {
            if (cond.getNomeFuncao().equals(nomeFuncao) && cond.getExpressao().contains("msg.sender")) {
                return true;
            }
        }
        return false;
    }

    private boolean funcaoUsaMsgValue(String nomeFuncao, ListasInfo info) {
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (op.getNomeFuncao().equals(nomeFuncao)) {
                if (op.getVariavelDestino().contains("msg.value")
                        || op.getOperador().contains("msg.value")
                        || op.getOperandos().toString().contains("msg.value")) {
                    return true;
                }
            }
        }
        for (Condicional cond : info.getCondicionais()) {
            if (cond.getNomeFuncao().equals(nomeFuncao) && cond.getExpressao().contains("msg.value")) {
                return true;
            }
        }
        return false;
    }

    private boolean variavelUsadaNaFuncao(String nomeVar, String nomeFuncao, ListasInfo info) {
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (op.getNomeFuncao().equals(nomeFuncao)) {
                if (pertenceAVariavel(op.getVariavelDestino(), nomeVar))
                    return true;
                for (String oper : op.getOperandos()) {
                    if (pertenceAVariavel(oper, nomeVar))
                        return true;
                }
            }
        }
        for (Condicional cond : info.getCondicionais()) {
            if (cond.getNomeFuncao().equals(nomeFuncao) && cond.getExpressao().contains(nomeVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean pertenceAVariavel(String expressao, String nomeVar) {
        String e = expressao.trim();
        if (e.equals(nomeVar) || e.startsWith(nomeVar + "["))
            return true;
        // Verifica se nomeVar aparece como token dentro de uma expressão aritmética
        // (ex: "balanceA+half")
        for (String tk : tokenizarExpressaoMatematica(e)) {
            if (tk.equals(nomeVar) || tk.startsWith(nomeVar + "[")) {
                return true;
            }
        }
        return false;
    }

    private OperacaoSolidity buscarOperacaoVariavelNaFuncao(
            String nomeFuncao, String nomeVar, ListasInfo info) {
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (op.getNomeFuncao().equals(nomeFuncao)) {
                String dest = op.getVariavelDestino().trim();
                if (dest.equals(nomeVar) || dest.startsWith(nomeVar + "[")) {
                    return op;
                }
            }
        }
        return null;
    }

    private String descobrirExpressaoIndiceUsada(String nomeVar, String nomeFuncao, ListasInfo info) {
        String padrao = nomeVar + "[";
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (op.getNomeFuncao().equals(nomeFuncao)) {
                if (op.getVariavelDestino().contains(padrao)) {
                    int idx = op.getVariavelDestino().indexOf(padrao);
                    return extrairIndiceAcesso(op.getVariavelDestino().substring(idx));
                }
                for (String oper : op.getOperandos()) {
                    if (oper.contains(padrao)) {
                        int idx = oper.indexOf(padrao);
                        return extrairIndiceAcesso(oper.substring(idx));
                    }
                }
            }
        }
        for (Condicional cond : info.getCondicionais()) {
            if (cond.getNomeFuncao().equals(nomeFuncao) && cond.getExpressao().contains(padrao)) {
                int idx = cond.getExpressao().indexOf(padrao);
                return extrairIndiceAcesso(cond.getExpressao().substring(idx));
            }
        }
        return "msg.sender";
    }

    private String extrairIndiceAcesso(String exprComColchetes) {
        int abre = exprComColchetes.indexOf('[');
        int fecha = exprComColchetes.indexOf(']', abre);
        if (abre != -1 && fecha != -1) {
            return exprComColchetes.substring(abre + 1, fecha).trim();
        }
        return exprComColchetes;
    }

    private List<Condicional> buscarCondicionaisDaFuncao(String nomeFuncao, ListasInfo info) {
        List<Condicional> lista = new ArrayList<>();
        for (Condicional c : info.getCondicionais()) {
            if (c.getNomeFuncao().equals(nomeFuncao)) {
                lista.add(c);
            }
        }
        return lista;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public List<Transicao> getTransicoes() {
        return transicoes;
    }

    public List<Arco> getArcos() {
        return arcos;
    }

    public Map<String, GerenciadorVariaveis> getGerenciadoresLocais() {
        return gerenciadoresLocais;
    }

    public Map<String, String> getVariavelListaPorVar() {
        return variavelListaPorVar;
    }

    public Map<String, String> getTipoListaPorVar() {
        return tipoListaPorVar;
    }

    public void exibirResultados() {
        Map<String, String> nomesElementos = new HashMap<>();
        for (Lugar l : this.lugares) {
            nomesElementos.put(l.getId(), l.getName());
        }
        for (Transicao t : this.transicoes) {
            nomesElementos.put(t.getId(), t.getName());
        }

        System.out.println("==========================================================");
        System.out.println("         RESULTADO DA TRANSFORMACAO (RPC GERADA)          ");
        System.out.println("==========================================================");

        System.out.println("\n--- LUGARES (P) [" + this.lugares.size() + "] ---");
        for (Lugar l : this.lugares) {
            String marcacao = (l.getInitialMarking() == null || l.getInitialMarking().isEmpty())
                    ? "vazio"
                    : l.getInitialMarking();
            String tipoLugar = l.isOracle() ? " [ORACULO]" : "";
            System.out.printf("  %-4s | Nome: %-20s | Cor: %-24s | Init: %-10s%s%n",
                    l.getId(), l.getName(), l.getColorSet(), marcacao, tipoLugar);
        }

        System.out.println("\n--- TRANSICOES (T) [" + this.transicoes.size() + "] ---");
        for (Transicao t : this.transicoes) {
            String guarda = (t.getGuard() == null || t.getGuard().isEmpty())
                    ? "true"
                    : t.getGuard();
            System.out.printf("  %-4s | Nome: %-22s | Guarda: %s%n",
                    t.getId(), t.getName(), guarda);
        }

        System.out.println("\n--- ARCOS (A) [" + this.arcos.size() + "] ---");
        for (Arco a : this.arcos) {
            String nomeOrigem = nomesElementos.getOrDefault(a.getSourceId(), a.getSourceId());
            String nomeDestino = nomesElementos.getOrDefault(a.getTargetId(), a.getTargetId());
            String origemFormatada = a.getSourceId() + " (" + nomeOrigem + ")";
            String destinoFormatada = a.getTargetId() + " (" + nomeDestino + ")";

            System.out.printf("  %-4s | %-26s ---> %-26s | Expr: %s%n",
                    a.getId(), origemFormatada, destinoFormatada, a.getExpression());
        }

        if (this.variavelListaPorVar != null && !this.variavelListaPorVar.isEmpty()) {
            System.out.println("\n--- MAPEAMENTO DO LUGAR CONSOLIDADO (chaves_init) ---");
            for (Map.Entry<String, String> entry : this.variavelListaPorVar.entrySet()) {
                String nomeVar = entry.getKey();
                String varLista = entry.getValue();
                String tipoLista = this.tipoListaPorVar.get(nomeVar);
                System.out.printf("  Variavel Indexada: %-15s -> Lista SML: %-4s (%s)%n",
                        nomeVar, varLista, tipoLista);
            }
        }
        System.out.println("==========================================================\n");
    }

    public void mostrarResultado() {
        exibirResultados();
    }
}