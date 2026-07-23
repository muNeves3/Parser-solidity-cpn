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

    // Inicializa as listas de entidades da rede
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
        System.out.println("\nIniciando construção da RPC conforme Algoritmo 3...");

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

        for (FuncaoSolidity func : info.getFuncoes()) {
            boolean temParametros = !func.getParametros().isEmpty();
            // Exceção: apenas public e external são oráculos. Construtor NUNCA é oráculo.
            boolean isOracle = (func.getVisibilidade().equals("public") || func.getVisibilidade().equals("external"))
                    && !func.isConstructor();

            if (temParametros || func.isConstructor() || !isOracle) {
                String lugarId = gerarId("lugar_param");
                String nomeLugar = "par-" + func.getNome();

                String tiposColorSet;
                if (func.isConstructor() && !temParametros) {
                    tiposColorSet = "BOOL"; // Construtor exige apenas cor booleana
                } else {
                    StringBuilder tipos = new StringBuilder();
                    for (String tipo : func.getParametros().values()) {
                        if (tipos.length() > 0)
                            tipos.append("x"); // Produto cartesiano de cores
                        tipos.append(mapearTipoParaColorSet(tipo, ""));
                    }
                    tiposColorSet = tipos.toString();
                }

                Lugar lugar = new Lugar(lugarId, nomeLugar, tiposColorSet, func.isConstructor() ? "1`true" : "empty",
                        isOracle);
                lugares.add(lugar);
                lugaresVariaveis.put(nomeLugar, lugar); // Salva para uso em chamadas internas

                System.out.println(String.format("  Lugar Parâmetro: %s (colorSet: %s, isOracle: %s)", nomeLugar,
                        tiposColorSet, isOracle));
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

            System.out.println(String.format("  Lugar: %s (tipo: %s, colorSet: %s)",
                    var.getNome(), var.getTipo(), colorSet));
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

            Transicao trans = new Transicao(
                    transId,
                    func.getNome(),
                    guardExpressao);

            transicoes.add(trans);
            transicoesFunc.put(func.getNome(), trans);

            System.out.println(String.format("  Transição: %s%s",
                    func.getNome(),
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
                // Monta a tupla (Z, E) ou a variável simples Z
                GerenciadorVariaveis gerLocal = gerenciadoresLocais.get(chamada.getNomeFuncaoChamadora());
                String expressaoArco = lugarAlvo.getColorSet().contains("x") ? "(Z, E)" : "Z";

                // Aplica a condicional na chamada (ex: D != Y -> NULL; D == Y -> (Z, E))
                // isChamadaInterna = true
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
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (op.getNomeFuncao().equals(nomeFuncao) && op.getVariavelDestino().startsWith(nomeVariavel)) {
                return op;
            }
        }
        return null;
    }

    // Recebe operações de atribuição (+=, -=, =) e as transforma em equações de
    // transição de estado. Substitui os identificadores do Solidity pelas letras da
    // RPC. Por exemplo, a operação balances += amount é desmembrada da tupla
    // original (Z, F) e traduzida para (Z, F + E).
    private String traduzirOperacaoParaRPC(OperacaoSolidity op, String expressaoEntrada, GerenciadorVariaveis ger) {
        String operador = op.getOperador();
        String ladoDireito = String.join(" ", op.getOperandos());

        // Ordena as chaves pela maior primeiro para evitar substituições parciais
        List<String> keys = new ArrayList<>(ger.getMapa().keySet());
        keys.sort((a, b) -> b.length() - a.length());

        for (String key : keys) {
            ladoDireito = ladoDireito.replace(key, ger.getMapa().get(key));
        }
        ladoDireito = ladoDireito.replaceAll("\\[.*?\\]", "").trim();

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
            }
        } else {
            if (operador.equals("="))
                return ladoDireito;
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

        for (Condicional cond : info.getCondicionais()) {
            if (cond.getNomeFuncao().equals(nomeFuncao)) {
                String logica = cond.getExpressao();

                List<String> keys = new ArrayList<>(ger.getMapa().keySet());
                keys.sort((a, b) -> b.length() - a.length());
                for (String key : keys) {
                    logica = logica.replace(key, ger.getMapa().get(key));
                }
                logica = logica.replaceAll("\\[.*?\\]", "").trim();
                String oposto = inverterLogica(logica);

                if (isChamadaInterna) {
                    if (cond.getTipo().equals("if")) {
                        return logica + " -> NULL; " + oposto + " -> " + expressaoOriginal;
                    }
                    return oposto + " -> NULL; " + logica + " -> " + expressaoOriginal;
                } else {
                    if (cond.getTipo().equals("require") || cond.getTipo().equals("assert")) {
                        return oposto + " -> NULL; " + logica + " -> " + expressaoMutada;
                    } else {
                        return logica + " -> " + expressaoOriginal + "; " + oposto + " -> " + expressaoMutada;
                    }
                }
            }
        }
        return expressaoMutada;
    }

    // responsável por inverter a lógica de uma expressão condicional, transformando
    // operadores de comparação em seus opostos.
    // para a montagem de caminhos lógicos de descarte (-> NULL).
    private String inverterLogica(String logica) {
        if (logica.contains("<="))
            return logica.replace("<=", ">");
        if (logica.contains(">="))
            return logica.replace(">=", "<");
        if (logica.contains("<"))
            return logica.replace("<", ">=");
        if (logica.contains(">"))
            return logica.replace(">", "<=");
        if (logica.contains("=="))
            return logica.replace("==", "!=");
        if (logica.contains("!="))
            return logica.replace("!=", "==");
        return "!(" + logica + ")";
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
                    expressao = ger.getOuCriarVariavel("param_constructor", "BOOL"); // Gera 'A'
                } else {
                    // Mapeia receiver (Z) e amount (E)
                    String v1 = ger.getOuCriarVariavel("receiver", "ADDRESS");
                    String v2 = ger.getOuCriarVariavel("amount", "UINT");
                    expressao = "(" + v1 + ", " + v2 + ")";
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
            resultado.putIfAbsent(funcao, new HashSet<>());
            resultado.get(funcao).add(extrairNomeBase(op.getVariavelDestino()));

            for (String operando : op.getOperandos()) {
                String varName = extrairNomeBase(operando);
                if (!varName.isEmpty())
                    resultado.get(funcao).add(varName);
            }
        }

        for (Condicional cond : info.getCondicionais()) {
            String funcao = cond.getNomeFuncao();
            resultado.putIfAbsent(funcao, new HashSet<>());

            // Regex atualizada para permitir o ponto (msg.sender)
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

            GerenciadorVariaveis gerLocal = new GerenciadorVariaveis();
            gerenciadoresLocais.put(func.getNome(), gerLocal);

            // 1º PASSO IMPORTANTE: Processar parâmetros ANTES dos arcos para mapear as
            // letras (E, Z)
            criarArcosParametros(func, trans, gerLocal);
            gerLocal.getOuCriarVariavel("msg.sender", "ADDRESS");

            // 2º PASSO: Criar as ligações
            Set<String> variaveisUsadas = variaveisPorFuncao.getOrDefault(func.getNome(), new HashSet<>());
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

        String indiceVar = "Z"; // Padrão
        if (lugar.getName().equals("balances") && func.getNome().equals("send")) {
            indiceVar = ger.getOuCriarVariavel("msg.sender", "ADDRESS"); // Atribui Y
        }

        String expressaoEntrada;
        if (lugar.getColorSet().contains("x")) {
            expressaoEntrada = "(" + indiceVar + ", " + ger.getOuCriarVariavel(lugar.getName(), "UINT") + ")";
        } else {
            expressaoEntrada = ger.getOuCriarVariavel(lugar.getName(), lugar.getColorSet());
        }

        String expressaoSaida = expressaoEntrada;
        OperacaoSolidity operacao = buscarOperacaoDaVariavel(lugar.getName(), func.getNome(), info);
        if (operacao != null) {
            expressaoSaida = traduzirOperacaoParaRPC(operacao, expressaoEntrada, ger);
        }

        String expressaoFinalSaida = aplicarCondicionaisRPC(expressaoSaida, expressaoEntrada, func.getNome(), info, ger,
                false);

        if (!func.isConstructor() || lugar.getName().equals("msg.sender")) {
            arcos.add(new Arco(arcoId1, lugar.getId(), transicao.getId(), expressaoEntrada));
        }

        if (!lugar.getName().equals("msg.sender")) {
            arcos.add(new Arco(arcoId2, transicao.getId(), lugar.getId(), expressaoFinalSaida));
        }
    }

    // responsável por avaliar se a transição possui regras de guarda
    // Ele concatena modifiers e condições primárias globais à assinatura da
    // transição. Para o construtor, atribui estritamente a guarda true
    private String construirGuardExpressao(FuncaoSolidity func, ListasInfo info) {
        // Construtor sempre está habilitado (guard = true)
        if (func.isConstructor()) {
            return "true";
        }

        StringBuilder guard = new StringBuilder();

        for (Condicional cond : info.getCondicionais()) {
            if (cond.getNomeFuncao().equals(func.getNome())) {
                if (cond.getTipo().equals("require") || cond.getTipo().equals("assert")) {
                    if (guard.length() > 0) {
                        guard.append(" AND ");
                    }
                    guard.append(cond.getExpressao());
                }
            }
        }

        for (String modifier : func.getModifiers()) {
            if (modifier.contains("onlyOwner") || modifier.contains("nonReentrant")) {
                if (guard.length() > 0) {
                    guard.append(" AND ");
                }
                guard.append(modifier);
            }
        }

        return guard.toString();
    }

    private String gerarId(String prefix) {
        return prefix + "_" + (idCounter++);
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
}
