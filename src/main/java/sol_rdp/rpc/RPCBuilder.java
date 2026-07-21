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

    public RPCBuilder() {
        this.lugares = new ArrayList<>();
        this.transicoes = new ArrayList<>();
        this.arcos = new ArrayList<>();
        this.lugaresVariaveis = new HashMap<>();
        this.transicoesFunc = new HashMap<>();
        this.idCounter = 0;
    }

    public void construirRPC(ListasInfo info) {
        System.out.println("\nIniciando construção da RPC conforme Algoritmo 3...");

        criarLugaresVariaveis(info);
        criarLugaresOraculos(info);
        criarTransicoesFuncoes(info);
        criarArcosFluxoDados(info);
        criarArcosDeChamadas(info);
        System.out.println("RPC construída com sucesso!");
    }

    private void criarLugaresOraculos(ListasInfo info) {
        System.out.println("\n--- Criando Lugares para Parâmetros ---");

        for (FuncaoSolidity func : info.getFuncoes()) {
            boolean temParametros = !func.getParametros().isEmpty();
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
                            tipos.append("x");
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

    private String mapearTipoParaColorSet(String tipoValor, String tipoIndice) {
        String corValor = mapearTipoSimples(tipoValor);

        if (tipoIndice != null && !tipoIndice.isEmpty()) {
            String corIndice = mapearTipoSimples(tipoIndice);
            return corIndice + "x" + corValor;
        }
        return corValor;
    }

    // private String gerarExpressaoArco(String colorSet, GerenciadorVariaveis ger)
    // {
    // if (!colorSet.contains("x")) {
    // return ger.getNovaVariavel(colorSet);
    // }

    // // Se for um produto (ex: ADDRESSxUINT), quebra e monta a tupla (ex: "(Z,
    // E)")
    // String[] cores = colorSet.split("x");
    // StringBuilder expr = new StringBuilder("(");
    // for (int i = 0; i < cores.length; i++) {
    // if (i > 0)
    // expr.append(", ");
    // expr.append(ger.getNovaVariavel(cores[i]));
    // }
    // expr.append(")");

    // return expr.toString();
    // }

    private String gerarExpressaoArcoBase(String colorSet, GerenciadorVariaveis ger, String nomeVariavelOrigem) {
        if (!colorSet.contains("x")) {
            return ger.getOuCriarVariavel(nomeVariavelOrigem, colorSet);
        }

        // Para mappings (ex: ADDRESSxUINT)
        String[] cores = colorSet.split("x");
        StringBuilder expr = new StringBuilder("(");

        // O primeiro elemento é o índice, o segundo é o valor
        expr.append(ger.getOuCriarVariavel(nomeVariavelOrigem + "_idx", cores[0]));
        expr.append(", ");
        expr.append(ger.getOuCriarVariavel(nomeVariavelOrigem + "_val", cores[1]));
        expr.append(")");

        return expr.toString();
    }

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

    private void criarArcosFluxoDados(ListasInfo info) {
        System.out.println("\n--- Criando Arcos de Fluxo de Dados ---");

        Map<String, Set<String>> variaveisPorFuncao = mapearVariaveisAFuncoes(info);

        for (FuncaoSolidity func : info.getFuncoes()) {
            Transicao trans = transicoesFunc.get(func.getNome());
            if (trans == null)
                continue;

            // Inicia um pool de variáveis zerado para esta transição
            GerenciadorVariaveis gerVariaveis = new GerenciadorVariaveis();

            Set<String> variaveisUsadas = variaveisPorFuncao.getOrDefault(func.getNome(), new HashSet<>());
            for (String nomeVar : variaveisUsadas) {
                Lugar lugarVar = lugaresVariaveis.get(nomeVar);
                if (lugarVar != null) {
                    criarArcoDuplo(lugarVar, trans, gerVariaveis, func, info);
                }
            }

            criarArcosParametros(func, trans);
        }
    }

    private void criarArcoDuplo(Lugar lugar, Transicao transicao, GerenciadorVariaveis ger, FuncaoSolidity func,
            ListasInfo info) {
        String arcoId1 = gerarId("arco");
        String arcoId2 = gerarId("arco");

        String expressaoEntrada = gerarExpressaoArcoBase(lugar.getColorSet(), ger, lugar.getName());
        String expressaoSaida = expressaoEntrada;

        OperacaoSolidity operacao = buscarOperacaoDaVariavel(lugar.getName(), func.getNome(), info);

        if (operacao != null) {
            expressaoSaida = traduzirOperacaoParaRPC(operacao, expressaoEntrada, ger);
        }

        String expressaoFinalSaida = aplicarCondicionaisRPC(expressaoSaida, expressaoEntrada, func.getNome(), info,
                ger);

        Arco arcoEntrada = new Arco(arcoId1, lugar.getId(), transicao.getId(), expressaoEntrada);
        Arco arcoSaida = new Arco(arcoId2, transicao.getId(), lugar.getId(), expressaoFinalSaida);

        arcos.add(arcoEntrada);
        arcos.add(arcoSaida);

        System.out.println(String.format("  Arco Entrada: %s -> %s (expr: %s)", lugar.getName(), transicao.getName(),
                expressaoEntrada));
        System.out.println(String.format("  Arco Saída:   %s -> %s (expr: %s)", transicao.getName(), lugar.getName(),
                expressaoFinalSaida));
    }

    private OperacaoSolidity buscarOperacaoDaVariavel(String nomeVariavel, String nomeFuncao, ListasInfo info) {
        for (OperacaoSolidity op : info.getOperacoes()) {
            if (op.getNomeFuncao().equals(nomeFuncao) && op.getVariavelDestino().startsWith(nomeVariavel)) {
                return op;
            }
        }
        return null;
    }

    private String traduzirOperacaoParaRPC(OperacaoSolidity op, String expressaoEntrada, GerenciadorVariaveis ger) {
        String operador = op.getOperador();
        String ladoDireito = String.join(" ", op.getOperandos());

        String exprMath = ladoDireito;
        for (Map.Entry<String, String> entry : ger.getMapa().entrySet()) {
            exprMath = exprMath.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
        }

        if (expressaoEntrada.startsWith("(")) {
            String[] partes = expressaoEntrada.replace("(", "").replace(")", "").split(",");
            if (partes.length >= 2) {
                String indice = partes[0].trim(); // Ex: Z
                String valorAtual = partes[1].trim(); // Ex: F

                if (operador.equals("+=")) {
                    return "(" + indice + ", " + valorAtual + " + " + exprMath.trim() + ")";
                } else if (operador.equals("-=")) {
                    return "(" + indice + ", " + valorAtual + " - " + exprMath.trim() + ")";
                } else if (operador.equals("=")) {
                    return "(" + indice + ", " + exprMath.trim() + ")";
                }
            }
        } else {
            // Lógica para variáveis de estado simples (sem índice/tupla)
            String valorAtual = expressaoEntrada;
            if (operador.equals("+=")) {
                return valorAtual + " + " + exprMath.trim();
            } else if (operador.equals("-=")) {
                return valorAtual + " - " + exprMath.trim();
            } else if (operador.equals("=")) {
                return exprMath.trim();
            }
        }

        return expressaoEntrada;
    }

    private void criarArcosDeChamadas(ListasInfo info) {
        System.out.println("\n--- Criando Arcos de Chamadas Internas ---");
        for (ChamadaFuncao chamada : info.getChamadas()) {
            Transicao transChamadora = transicoesFunc.get(chamada.getNomeFuncaoChamadora());
            Lugar lugarAlvo = lugaresVariaveis.get("par-" + chamada.getNomeFuncaoAlvo());

            if (transChamadora != null && lugarAlvo != null) {
                String arcoId = gerarId("arco");

                // Mapeamento dos argumentos passados para a transição
                String expressaoArco = lugarAlvo.getColorSet().contains("x") ? "(Z, E)" : "Z";

                Arco arco = new Arco(arcoId, transChamadora.getId(), lugarAlvo.getId(), expressaoArco);
                arcos.add(arco);
                System.out.println(String.format("  Arco de Chamada: %s -> %s (expr: %s)", transChamadora.getName(),
                        lugarAlvo.getName(), expressaoArco));
            }
        }
    }

    private String aplicarCondicionaisRPC(String expressaoMutada, String expressaoOriginal, String nomeFuncao,
            ListasInfo info, GerenciadorVariaveis ger) {
        StringBuilder condFinal = new StringBuilder();

        for (Condicional cond : info.getCondicionais()) {
            if (cond.getNomeFuncao().equals(nomeFuncao)
                    && (cond.getTipo().equals("if") || cond.getTipo().equals("require"))) {
                String logica = cond.getExpressao();

                // Traduz a lógica "amount <= balances" para "E <= F"
                for (Map.Entry<String, String> entry : ger.getMapa().entrySet()) {
                    logica = logica.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }
                logica = logica.replaceAll("\\[.*?\\]", ""); // Limpa chaves de array

                // Exemplo do método: E > F -> NULL, E <= F -> (Y, F-E)
                String oposto = inverterLogica(logica);
                condFinal.append(oposto).append(" -> ")
                        .append(cond.getTipo().equals("require") ? "NULL" : expressaoOriginal);
                condFinal.append(", ");
                condFinal.append(logica).append(" -> ").append(expressaoMutada);

                return condFinal.toString();
            }
        }
        return expressaoMutada;
    }

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

    private void criarArcosParametros(FuncaoSolidity func, Transicao trans) {
        if (func.getVisibilidade().equals("public") || func.getVisibilidade().equals("external")
                || func.isConstructor()) {
            String nomeLugarOracle = "par-" + func.getNome();

            for (Lugar lugar : lugares) {
                if (lugar.getName().equals(nomeLugarOracle)) {
                    String arcoId = gerarId("arco");
                    Arco arco = new Arco(arcoId, lugar.getId(), trans.getId(), lugar.getColorSet());
                    arcos.add(arco);

                    System.out.println(String.format("  Arco Parâmetro: %s -> %s",
                            lugar.getName(), trans.getName()));
                    break;
                }
            }
        }
    }

    private Map<String, Set<String>> mapearVariaveisAFuncoes(ListasInfo info) {
        Map<String, Set<String>> resultado = new HashMap<>();

        // Extrair variáveis de operações
        for (OperacaoSolidity op : info.getOperacoes()) {
            String funcao = op.getNomeFuncao();
            resultado.putIfAbsent(funcao, new HashSet<>());
            resultado.get(funcao).add(op.getVariavelDestino());

            for (String operando : op.getOperandos()) {
                String varName = extrairNomeVariavel(operando);
                if (!varName.isEmpty()) {
                    resultado.get(funcao).add(varName);
                }
            }
        }

        // Extrair variáveis de condicionais (require, assert, if)
        for (Condicional cond : info.getCondicionais()) {
            String funcao = cond.getNomeFuncao();
            resultado.putIfAbsent(funcao, new HashSet<>());

            // Extrair todos os identificadores da expressão
            String expressao = cond.getExpressao();
            String[] tokens = expressao.split("[^a-zA-Z0-9_]");
            for (String token : tokens) {
                String varName = extrairNomeVariavel(token);
                if (!varName.isEmpty() && !varName.equals("msg")) {
                    resultado.get(funcao).add(varName);
                }
            }
        }

        // Extrair variáveis de chamadas de função
        for (ChamadaFuncao chamada : info.getChamadas()) {
            String funcaoChamadora = chamada.getNomeFuncaoChamadora();
            resultado.putIfAbsent(funcaoChamadora, new HashSet<>());

            for (String arg : chamada.getArgumentos()) {
                String varName = extrairNomeVariavel(arg);
                if (!varName.isEmpty()) {
                    resultado.get(funcaoChamadora).add(varName);
                }
            }
        }

        return resultado;
    }

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

    private String mapearTipoParaColorSet(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            return "ANY";
        }

        tipo = tipo.toLowerCase();

        if (tipo.startsWith("uint")) {
            return "UINT";
        } else if (tipo.startsWith("int")) {
            return "INT";
        } else if (tipo.equals("bool")) {
            return "BOOL";
        } else if (tipo.equals("address")) {
            return "ADDRESS";
        } else if (tipo.equals("string")) {
            return "STRING";
        } else if (tipo.contains("mapping")) {
            return "MAPPING";
        } else if (tipo.contains("[]")) {
            return "ARRAY";
        } else {
            return tipo.toUpperCase();
        }
    }

    private String extrairNomeVariavel(String expr) {
        expr = expr.trim();
        if (expr.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return expr;
        }
        return "";
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

    public List<Lugar> getLugares() {
        return lugares;
    }

    public List<Transicao> getTransicoes() {
        return transicoes;
    }

    public List<Arco> getArcos() {
        return arcos;
    }
}
