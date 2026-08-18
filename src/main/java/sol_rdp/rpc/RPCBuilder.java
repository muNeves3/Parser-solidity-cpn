package sol_rdp.rpc;

import sol_rdp.solidity.*;
import sol_rdp.cpn.Lugar;
import sol_rdp.cpn.Transicao;
import sol_rdp.cpn.Arco;
import java.util.*;

public class RPCBuilder {
    private List<Lugar> lugares;
    private List<Transicao> transicoes;
    private List<Arco> arcos;
    private Map<String, Lugar> lugaresVariaveis;
    private Map<String, Transicao> transicoesFunc;
    private int idCounter;
    private Map<String, GerenciadorVariaveis> gerenciadoresLocais;

    public RPCBuilder() {
        this.lugares = new ArrayList<>();
        this.transicoes = new ArrayList<>();
        this.arcos = new ArrayList<>();
        this.lugaresVariaveis = new HashMap<>();
        this.transicoesFunc = new HashMap<>();
        this.idCounter = 0;
        this.gerenciadoresLocais = new HashMap<>();
    }

    // responsável por construir a RPC a partir das informações extraídas do
    // contrato Solidity
    public void construirRPC(ListasInfo info) {
        System.out.println("\nIniciando construção da RPC...");

        criarLugaresVariaveis(info);
        criarLugaresOraculos(info);
        criarTransicoesFuncoes(info);
        criarArcosFluxoDados(info);
        criarArcosDeChamadas(info);

        System.out.println("RPC construída com sucesso!");
    }

    // cria os lugares oráculos para os parâmetros das funções public ou external,
    // incluindo o construtor
    private void criarLugaresOraculos(ListasInfo info) {
        System.out.println("\n--- Criando Lugares para Parâmetros ---");
        // Exceção: apenas public e external são oráculos. Construtor NUNCA é oráculo.
        for (FuncaoSolidity func : info.getFuncoes()) {
            boolean temParametros = !func.getParametros().isEmpty();
            boolean isOracle = (func.getVisibilidade().equals("public") || func.getVisibilidade().equals("external"))
                    && !func.isConstructor();

            if (temParametros || func.isConstructor() || !isOracle) {
                String lugarId = gerarId("lugar_param");
                String nomeLugar = "par-" + func.getNome();
                String tiposColorSet;

                if (func.isConstructor() && !temParametros) {
                    tiposColorSet = "BOOL";
                } else {
                    StringBuilder tipos = new StringBuilder();
                    for (String tipo : func.getParametros().values()) {
                        if (tipos.length() > 0)
                            tipos.append("x"); // Produto cartesiano de cores
                        tipos.append(mapearTipoParaColorSet(tipo, ""));
                    }
                    tiposColorSet = tipos.toString();
                }

                String marcacaoInicial;
                if (func.isConstructor() && !temParametros) {
                    marcacaoInicial = "1`true";
                } else if (isOracle) {
                    marcacaoInicial = "1`" + gerarMarcacaoInicialOracle(tiposColorSet);
                } else {
                    marcacaoInicial = "empty";
                }

                Lugar lugar = new Lugar(lugarId, nomeLugar, tiposColorSet, marcacaoInicial, isOracle);
                lugares.add(lugar);
                lugaresVariaveis.put(nomeLugar, lugar);

                System.out.println(String.format("  Lugar Parâmetro: %s (colorSet: %s, isOracle: %s, marcacao: %s)",
                        nomeLugar, tiposColorSet, isOracle, marcacaoInicial));
            }
        }
    }

    // responsável por criar os lugares para as variáveis de estado do contrato,
    // mapeando seus tipos para color sets
    // Caso a variável possua um valor de inicialização na AST, este é definido como
    // a marcação inicial
    private void criarLugaresVariaveis(ListasInfo info) {
        System.out.println("\n--- Criando Lugares para Variáveis de Estado ---");

        for (VariavelGlobal var : info.getVariaveisGlobais()) {
            String lugarId = gerarId("lugar_var");
            String colorSet = mapearTipoParaColorSet(var.getTipo(), var.getTipoIndice());

            Lugar lugar = new Lugar(
                    lugarId,
                    var.getNome(),
                    colorSet,
                    var.getValorInicial().isEmpty() ? "empty" : var.getValorInicial(),
                    false);

            lugares.add(lugar);
            lugaresVariaveis.put(var.getNome(), lugar);

            System.out.println(
                    String.format("  Lugar: %s (tipo: %s, colorSet: %s)", var.getNome(), var.getTipo(), colorSet));
        }
    }

    // responsável por mapear os tipos de variáveis do Solidity para os color sets
    // da CPN, considerando também os tipos de índices para arrays e mappings
    private String mapearTipoParaColorSet(String tipoValor, String tipoIndice) {
        String corValor = mapearTipoSimples(tipoValor);
        if (tipoIndice != null && !tipoIndice.isEmpty()) {
            String corIndice = mapearTipoSimples(tipoIndice);
            return corIndice + "x" + corValor;
        }
        return corValor;
    }

    // responsável por mapear os tipos simples do Solidity para os color sets da CPN
    private String mapearTipoSimples(String tipo) {
        if (tipo == null || tipo.isEmpty())
            return "ANY";
        tipo = tipo.toLowerCase();

        if (tipo.startsWith("uint"))
            return "UINT";
        if (tipo.startsWith("int"))
            return "INT";
        if (tipo.equals("address"))
            return "ADDRESS";
        if (tipo.equals("bool"))
            return "BOOL";
        if (tipo.equals("string"))
            return "STRING";

        return tipo.toUpperCase();
    }

    // cria as transições para cada função do contrato, incluindo o construtor, e
    // define os guards baseados em require, assert e modifiers
    private void criarTransicoesFuncoes(ListasInfo info) {
        System.out.println("\n--- Criando Transições para Funções ---");

        for (FuncaoSolidity func : info.getFuncoes()) {
            String transId = gerarId("trans");
            String guardExpressao = construirGuardExpressao(func, info);

            Transicao trans = new Transicao(transId, func.getNome(), guardExpressao);

            transicoes.add(trans);
            transicoesFunc.put(func.getNome(), trans);

            System.out.println(String.format("  Transição: %s%s", func.getNome(),
                    !guardExpressao.isEmpty() ? " [Guard: " + guardExpressao + "]" : ""));
        }
    }

    // cria os arcos baseados nas chamadas de funções internas, conectando a
    // transição chamadora ao lugar do parâmetro da função alvo, repassando as
    // variáveis locais condicionadas ao fluxo de sucesso da transição original.
    private void criarArcosDeChamadas(ListasInfo info) {
        for (ChamadaFuncao chamada : info.getChamadas()) {
            Transicao transChamadora = transicoesFunc.get(chamada.getNomeFuncaoChamadora());
            Lugar lugarAlvo = lugaresVariaveis.get("par-" + chamada.getNomeFuncaoAlvo());

            if (transChamadora != null && lugarAlvo != null) {
                GerenciadorVariaveis gerLocal = gerenciadoresLocais.get(chamada.getNomeFuncaoChamadora());
                // Mapeia dinamicamente os argumentos passados na chamada (ex: receiver, amount
                // -> A, B)
                List<String> argsMapeados = new ArrayList<>();
                for (String arg : chamada.getArgumentos()) {
                    String argLimpo = extrairNomeVariavel(arg.replaceAll("\\[.*?\\]", "").trim());
                    // Busca a variável fortemente tipada (usa default caso não seja identificada no
                    // escopo)
                    argsMapeados.add(gerLocal.getVariavel(argLimpo, "default"));
                }

                String expressaoArco = argsMapeados.size() > 1 ? "(" + String.join(", ", argsMapeados) + ")"
                        : argsMapeados.get(0);

                String expressaoFinal = aplicarCondicionaisRPC(expressaoArco, expressaoArco, transChamadora.getName(),
                        info, gerLocal, true);

                arcos.add(new Arco(gerarId("arco_chamada"), transChamadora.getId(), lugarAlvo.getId(), expressaoFinal));
            }
        }
    }

    // Filtro localizador que encontra se uma variável específica sofreu mutação
    // dentro de uma função específica, servindo de gatilho para o acionamento do
    // tradutor
    private OperacaoSolidity buscarOperacaoDaVariavel(String nomeVariavel, String nomeFuncao, ListasInfo info) {
        OperacaoSolidity opEncontrada = null;
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (op.getNomeFuncao().equals(nomeFuncao) && op.getVariavelDestino().startsWith(nomeVariavel)) {
                if (op.getOperador().equals("POP") || op.getOperador().equals("PUSH")) {
                    return op;
                }
                if (opEncontrada == null) {
                    opEncontrada = op;
                }
            }
        }
        return opEncontrada;
    }

    // Recebe operações de atribuição (+=, -=, =) e as transforma em equações de
    // transição de estado. Substitui os identificadores do Solidity pelas letras da
    // RPC. Por exemplo, a operação balances += amount é desmembrada da tupla
    // original (Z, F) e traduzida para (Z, F + E).
    private String traduzirOperacaoParaRPC(OperacaoSolidity op, String expressaoEntrada, GerenciadorVariaveis ger) {
        String operador = op.getOperador();
        String ladoDireito = String.join(" ", op.getOperandos());

        // Acesso ao mapa de variáveis do escopo atual do gerenciador
        List<String> keys = new ArrayList<>(ger.getMapaVariaveis().keySet());
        keys.sort((a, b) -> b.length() - a.length());

        for (String key : keys) {
            if (key.endsWith("_val")) {
                String arrayName = key.replace("_val", "");
                ladoDireito = ladoDireito.replaceAll(arrayName + "(?:\\[[^\\]]*\\])+", ger.getMapaVariaveis().get(key));
            } else {
                ladoDireito = ladoDireito.replaceAll("\\b" + key + "\\b", ger.getMapaVariaveis().get(key));
            }
        }

        ladoDireito = ladoDireito.replaceAll("\\[.*?\\]", "").trim();
        ladoDireito = ladoDireito.replace("type(uint256).max", "2**256 - 1");

        if (expressaoEntrada.startsWith("(")) {
            String[] partes = expressaoEntrada.replace("(", "").replace(")", "").split(",");
            if (partes.length >= 2) {
                String indice = partes[0].trim();
                String valorAtual = partes[1].trim();

                if (operador.equals("+="))
                    return "(" + indice + ", " + valorAtual + "+" + ladoDireito + ")";
                if (operador.equals("-="))
                    return "(" + indice + ", " + valorAtual + "-" + ladoDireito + ")";
                if (operador.equals("="))
                    return "(" + indice + ", " + ladoDireito + ")";
                if (operador.equals("PUSH")) {
                    String limpo = ladoDireito.replaceAll("^[a-zA-Z_][a-zA-Z0-9_]*\\(", "(");
                    if (expressaoEntrada.startsWith("("))
                        return "(novo_idx, " + limpo + ")";
                    return limpo;
                }
                if (operador.equals("POP"))
                    return expressaoEntrada;
            }
        } else {
            if (operador.equals("="))
                return ladoDireito;
            if (operador.equals("+="))
                return expressaoEntrada + "+" + ladoDireito;
            if (operador.equals("-="))
                return expressaoEntrada + "-" + ladoDireito;
            if (operador.equals("PUSH")) {
                String limpo = ladoDireito.replaceAll("^[a-zA-Z_][a-zA-Z0-9_]*\\(", "(");
                if (expressaoEntrada.startsWith("("))
                    return "(novo_idx, " + limpo + ")";
                return limpo;
            }
            if (operador.equals("POP"))
                return expressaoEntrada;
        }
        return expressaoEntrada;
    }

    // Avalia se uma mutação de estado está protegida por um if, require ou assert.
    // se sim retorna a expressão condicionalmente, caso contrário retorna a
    // expressão mutada.
    private String aplicarCondicionaisRPC(String expressaoMutada, String expressaoOriginal, String nomeFuncao,
            ListasInfo info, GerenciadorVariaveis ger, boolean isChamadaInterna) {
        if (expressaoMutada.equals(expressaoOriginal) && !isChamadaInterna) {
            return expressaoOriginal;
        }

        List<String> condicoesCombinadas = new ArrayList<>();
        boolean temRevert = false;

        for (Condicional cond : info.getCondicionais()) {
            if (cond.getNomeFuncao().equals(nomeFuncao)) {
                String logica = cond.getExpressao();

                List<String> keys = new ArrayList<>(ger.getMapaVariaveis().keySet());
                keys.sort((a, b) -> b.length() - a.length());

                for (String key : keys) {
                    if (key.endsWith("_val")) {
                        String arrayName = key.replace("_val", "");
                        logica = logica.replaceAll(arrayName + "(?:\\[[^\\]]*\\])+", ger.getMapaVariaveis().get(key));
                    } else {
                        logica = logica.replaceAll("\\b" + key + "\\b", ger.getMapaVariaveis().get(key));
                    }
                }

                logica = logica.replaceAll("\\[.*?\\]", "").trim();
                logica = logica.replace("type(uint256).max", "2**256 - 1");

                if (cond.getTipo().equals("if_revert"))
                    temRevert = true;
                condicoesCombinadas.add(logica);
            }
        }

        if (condicoesCombinadas.isEmpty())
            return expressaoMutada;

        String logicaFinal = String.join(" AND ", condicoesCombinadas);
        String opostoFinal = "!(" + logicaFinal + ")";

        if (temRevert) {
            if (isChamadaInterna)
                return logicaFinal + " -> NULL; " + opostoFinal + " -> " + expressaoOriginal;
            return logicaFinal + " -> NULL; " + opostoFinal + " -> " + expressaoMutada;
        } else {
            if (isChamadaInterna)
                return opostoFinal + " -> NULL; " + logicaFinal + " -> " + expressaoOriginal;
            return opostoFinal + " -> NULL; " + logicaFinal + " -> " + expressaoMutada;
        }
    }

    // Conecta os Lugares-Oráculo de entrada à sua respectiva transição
    // Para funções com parâmetros, cria arcos de entrada com as letras
    // correspondentes (E, Z) e para o construtor cria um arco de entrada com a
    // letra A.
    private void criarArcosParametros(FuncaoSolidity func, Transicao trans, GerenciadorVariaveis ger) {
        String nomeLugarOracle = "par-" + func.getNome();
        for (Lugar lugar : lugares) {
            if (lugar.getName().equals(nomeLugarOracle)) {
                String arcoId = gerarId("arco");
                String expressao;

                if (func.isConstructor()) {
                    expressao = ger.getVariavel("param_constructor", "bool");
                } else {
                    List<String> varsParametros = new ArrayList<>();
                    for (String nomeParam : func.getParametros().keySet()) {
                        String tipoParam = func.getParametros().get(nomeParam);
                        varsParametros.add(ger.getVariavel(nomeParam, tipoParam));
                    }
                    expressao = "(" + String.join(", ", varsParametros) + ")";
                }

                arcos.add(new Arco(arcoId, lugar.getId(), trans.getId(), expressao));
                break;
            }
        }
    }

    // itera sobre todas as listas de metadados extraídas pelo Visitor (Operações,
    // Condicionais e Chamadas). Seu objetivo é descobrir todas as instâncias de
    // estado (state variables e variáveis de EVM) tocadas por uma função
    // específica, criando a matriz de adjacência utilizada na construção
    // da rede.
    private Map<String, Set<String>> mapearVariaveisAFuncoes(ListasInfo info) {
        Map<String, Set<String>> resultado = new HashMap<>();

        for (OperacaoSolidity op : info.getOperacoes()) {
            String funcao = op.getNomeFuncao();
            resultado.putIfAbsent(funcao, new LinkedHashSet<>());
            resultado.get(funcao).add(extrairNomeBase(op.getVariavelDestino()));

            // Filtra a string bruta para achar apenas os nomes (ignorando números)
            for (String operandoBruto : op.getOperandos()) {
                java.util.regex.Matcher m = java.util.regex.Pattern.compile("[a-zA-Z_][a-zA-Z0-9_.]*")
                        .matcher(operandoBruto);
                while (m.find()) {
                    String varName = m.group();
                    if (!varName.matches("^[0-9]+$") && !varName.equals("msg") && !varName.equals("block")) {
                        resultado.get(funcao).add(extrairNomeBase(varName));
                    }
                }
            }
        }

        for (Condicional cond : info.getCondicionais()) {
            String funcao = cond.getNomeFuncao();
            resultado.putIfAbsent(funcao, new HashSet<>());

            java.util.regex.Matcher m = java.util.regex.Pattern.compile("[a-zA-Z_][a-zA-Z0-9_.]*")
                    .matcher(cond.getExpressao());
            while (m.find()) {
                String varName = m.group();
                if (!varName.equals("msg") && !varName.equals("block")) {
                    resultado.get(funcao).add(extrairNomeBase(varName));
                }
            }
        }

        for (ChamadaFuncao chamada : info.getChamadas()) {
            String funcao = chamada.getNomeFuncaoChamadora();
            resultado.putIfAbsent(funcao, new HashSet<>());
            for (String arg : chamada.getArgumentos()) {
                resultado.get(funcao).add(extrairNomeBase(arg));
            }
        }

        if (resultado.containsKey("constructor")) {
            resultado.get("constructor").add("msg.sender");
        }

        return resultado;
    }

    private String extrairNomeBase(String expr) {
        expr = expr.trim();
        int idx = expr.indexOf('[');
        if (idx > 0)
            return expr.substring(0, idx).trim();
        return expr;
    }

    // responsável por conectar os Lugares às Transições.
    // utiliza a matriz de adjacência construída para descobrir quais variáveis de
    // estado são tocadas por cada função, criando arcos de entrada e saída com as
    // expressões correspondentes.
    private void criarArcosFluxoDados(ListasInfo info) {
        System.out.println("\n--- Criando Arcos de Fluxo de Dados ---");

        Map<String, Set<String>> variaveisPorFuncao = mapearVariaveisAFuncoes(info);

        for (FuncaoSolidity func : info.getFuncoes()) {
            Transicao trans = transicoesFunc.get(func.getNome());
            if (trans == null)
                continue;

            // Inicia o escopo novo e limpo para essa transição
            GerenciadorVariaveis gerLocal = new GerenciadorVariaveis();
            gerenciadoresLocais.put(func.getNome(), gerLocal);

            if (func.getParametros() != null) {
                for (String paramNome : func.getParametros().keySet()) {
                    // Pega o tipo real da AST para gerar a letra correta
                    String tipoReal = func.getParametros().get(paramNome);
                    gerLocal.getVariavel(paramNome, tipoReal);
                }
            }

            criarArcosParametros(func, trans, gerLocal);
            gerLocal.getVariavel("msg.sender", "address");

            Set<String> variaveisUsadas = variaveisPorFuncao.getOrDefault(func.getNome(), new HashSet<>());

            // 1º PASSO : Pré-carregar todas as variáveis no dicionário
            for (String nomeVar : variaveisUsadas) {
                Lugar lugarVar = lugaresVariaveis.get(nomeVar);
                if (lugarVar != null) {
                    gerLocal.getVariavel(lugarVar.getName(), lugarVar.getColorSet());

                    if (lugarVar.getColorSet().contains("x")) {
                        gerLocal.getVariavel(lugarVar.getName() + "_val", "uint");
                    }
                }
            }

            // Traduzir a guarda da transição para eliminar unbound variables
            String guardOriginal = trans.getGuard();
            if (guardOriginal != null && !guardOriginal.isEmpty() && !guardOriginal.equals("true")) {
                String guardTraduzida = guardOriginal;
                List<String> keys = new ArrayList<>(gerLocal.getMapaVariaveis().keySet());
                keys.sort((a, b) -> b.length() - a.length());

                for (String key : keys) {
                    if (key.endsWith("_val")) {
                        String arrayName = key.replace("_val", "");
                        guardTraduzida = guardTraduzida.replaceAll(arrayName + "(?:\\[[^\\]]*\\])+",
                                gerLocal.getMapaVariaveis().get(key));
                    } else {
                        guardTraduzida = guardTraduzida.replaceAll("\\b" + key + "\\b",
                                gerLocal.getMapaVariaveis().get(key));
                    }
                }
                guardTraduzida = guardTraduzida.replaceAll("\\[.*?\\]", "").trim();
                guardTraduzida = guardTraduzida.replace("type(uint256).max", "2**256 - 1");

                trans.setGuard(guardTraduzida);
            }

            // 2º PASSO: gerar os arcos com o dicionário completo
            for (String nomeVar : variaveisUsadas) {
                Lugar lugarVar = lugaresVariaveis.get(nomeVar);
                if (lugarVar != null) {
                    criarArcoDuplo(lugarVar, trans, gerLocal, func, info);
                }
            }
        }
    }

    // responsável por criar arcos de entrada e saída entre um lugar e uma
    // transição, considerando a mutação de estado e as condicionais aplicáveis.
    private void criarArcoDuplo(Lugar lugar, Transicao transicao, GerenciadorVariaveis ger, FuncaoSolidity func,
            ListasInfo info) {
        String arcoId1 = gerarId("arco");
        String arcoId2 = gerarId("arco");

        OperacaoSolidity operacao = buscarOperacaoDaVariavel(lugar.getName(), func.getNome(), info);
        boolean isPush = operacao != null && operacao.getOperador().equals("PUSH");
        boolean isPop = operacao != null && operacao.getOperador().equals("POP");

        String indiceVar = "Z";
        if (lugar.getColorSet().contains("x") && operacao != null) {
            String dest = operacao.getVariavelDestino();
            int idx1 = dest.indexOf('[');
            int idx2 = dest.indexOf(']');
            if (idx1 > 0 && idx2 > idx1) {
                String indexOriginal = dest.substring(idx1 + 1, idx2).trim();
                indiceVar = ger.getVariavel(indexOriginal, "default");
            } else if (!isPush) {
                indiceVar = ger.getVariavel("idx", "default");
            }
        }

        String expressaoEntrada;
        if (lugar.getColorSet().contains("x")) {
            expressaoEntrada = "(" + indiceVar + ", " + ger.getVariavel(lugar.getName() + "_val", "default") + ")";
        } else {
            expressaoEntrada = ger.getVariavel(lugar.getName(), lugar.getColorSet());
        }

        if (isPop && lugar.getColorSet().contains("x")) {
            List<String> varsParametros = new ArrayList<>();
            for (String nomeParam : func.getParametros().keySet()) {
                varsParametros.add(ger.getVariavel(nomeParam, "default"));
            }
            if (!varsParametros.isEmpty()) {
                expressaoEntrada = "(idx, (" + String.join(", ", varsParametros) + "))";
            }
        }

        String expressaoSaida = expressaoEntrada;
        if (operacao != null) {
            expressaoSaida = traduzirOperacaoParaRPC(operacao, expressaoEntrada, ger);
        }

        String expressaoFinalSaida;
        if (isPush || isPop) {
            expressaoFinalSaida = expressaoSaida;
        } else {
            expressaoFinalSaida = aplicarCondicionaisRPC(expressaoSaida, expressaoEntrada, func.getNome(), info, ger,
                    false);
        }

        boolean criaEntrada = (!func.isConstructor() || lugar.getName().equals("msg.sender")) && !isPush;

        // CORREÇÃO: Oráculos como msg.sender DEVEM ter arco de saída para evitar
        // deadlock consumindo o token global
        boolean criaSaida = !isPop;

        if (criaEntrada) {
            arcos.add(new Arco(arcoId1, lugar.getId(), transicao.getId(), expressaoEntrada));
        }

        if (criaSaida) {
            arcos.add(new Arco(arcoId2, transicao.getId(), lugar.getId(), expressaoFinalSaida));
        }
    }

    // responsável por avaliar se a transição possui regras de guarda
    // Ele concatena modifiers e condições primárias globais à assinatura da
    // transição. Para o construtor, atribui estritamente a guarda true
    private String construirGuardExpressao(FuncaoSolidity func, ListasInfo info) {
        if (func.isConstructor())
            return "true";

        StringBuilder guard = new StringBuilder();

        for (Condicional cond : info.getCondicionais()) {
            if (cond.getNomeFuncao().equals(func.getNome())) {
                if (cond.getTipo().equals("require") || cond.getTipo().equals("assert")) {
                    if (guard.length() > 0)
                        guard.append(" AND ");
                    guard.append(cond.getExpressao());
                }
            }
        }

        for (String modifier : func.getModifiers()) {
            if (modifier.contains("onlyOwner") || modifier.contains("nonReentrant")) {
                if (guard.length() > 0)
                    guard.append(" AND ");
                guard.append(modifier);
            }
        }

        return guard.toString();
    }

    private String gerarId(String prefix) {
        return prefix + "_" + (idCounter++);
    }

    private String extrairNomeVariavel(String expr) {
        if (expr == null)
            return "";
        expr = expr.trim();
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("^([a-zA-Z_][a-zA-Z0-9_.]*)").matcher(expr);
        if (matcher.find())
            return matcher.group(1);
        return expr;
    }

    public void exibirResultados() {
        System.out.println("\n========== RESULTADOS DA RPC ==========");
        System.out.println("\nLUGARES (" + lugares.size() + "):");
        for (Lugar lugar : lugares) {
            System.out.println("  " + lugar);
        }

        System.out.println("\nTRANSIÇÕES (" + transicoes.size() + "):");
        for (Transicao trans : transicoes) {
            System.out.println("  " + trans);
        }

        System.out.println("\nARCOS (" + arcos.size() + "):");
        for (Arco arco : arcos) {
            System.out.println("  " + arco);
        }
        System.out.println("=========================================\n");
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

    private String gerarMarcacaoInicialOracle(String colorSet) {
        if (colorSet.contains("x")) {
            String[] tipos = colorSet.split("x");
            List<String> valores = new ArrayList<>();
            for (String t : tipos) {
                valores.add(obterValorDefaultPorTipo(t.trim()));
            }
            return "(" + String.join(", ", valores) + ")";
        }
        return obterValorDefaultPorTipo(colorSet);
    }

    /**
     * Retorna um valor simbólico ou zerado válido para o tipo CPN.
     */
    private String obterValorDefaultPorTipo(String tipo) {
        switch (tipo) {
            case "ADDRESS":
                return "\"0x_ext\""; // Endereço genérico simulando um usuário externo
            case "UINT":
            case "INT":
                return "0"; // Valor numérico padrão
            case "BOOL":
                return "false";
            case "STRING":
                return "\"\"";
            default:
                return "ext_data"; // Fallback para Structs/Enums
        }
    }
}