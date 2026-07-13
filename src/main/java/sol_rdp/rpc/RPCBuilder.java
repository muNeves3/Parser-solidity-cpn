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
        criarArcosCondicionais(info);
        
        System.out.println("RPC construída com sucesso!");
    }

    private void criarLugaresVariaveis(ListasInfo info) {
        System.out.println("\n--- Criando Lugares para Variáveis de Estado ---");
        
        for (VariavelGlobal var : info.getVariaveisGlobais()) {
            String lugarId = gerarId("lugar_var");
            String colorSet = mapearTipoParaColorSet(var.getTipo());
            
            Lugar lugar = new Lugar(
                    lugarId,
                    var.getNome(),
                    colorSet,
                    var.getValorInicial(),
                    false
            );
            
            lugares.add(lugar);
            lugaresVariaveis.put(var.getNome(), lugar);
            
            System.out.println(String.format("  Lugar: %s (tipo: %s, colorSet: %s)", 
                    var.getNome(), var.getTipo(), colorSet));
        }
    }

    private void criarLugaresOraculos(ListasInfo info) {
        System.out.println("\n--- Criando Lugares Oráculos para Parâmetros ---");
        
        for (FuncaoSolidity func : info.getFuncoes()) {
            boolean temParametros = !func.getParametros().isEmpty();
            boolean isPublicOrExternal = func.getVisibilidade().equals("public") || func.getVisibilidade().equals("external");
            
            if ((func.isConstructor() && temParametros) || (isPublicOrExternal && temParametros)) {
                String lugarId = gerarId("lugar_oracle");
                String nomeLugar = "par-" + func.getNome();
                
                StringBuilder tipos = new StringBuilder();
                for (String tipo : func.getParametros().values()) {
                    if (tipos.length() > 0) tipos.append(",");
                    tipos.append(mapearTipoParaColorSet(tipo));
                }
                
                Lugar lugarOracle = new Lugar(
                        lugarId,
                        nomeLugar,
                        tipos.toString(),
                        "empty",
                        true
                );
                
                lugares.add(lugarOracle);
                System.out.println(String.format("  Lugar Oracle: %s (colorSet: %s)", 
                        nomeLugar, tipos.toString()));
            }
        }
    }

    private void criarTransicoesFuncoes(ListasInfo info) {
        System.out.println("\n--- Criando Transições para Funções ---");
        
        for (FuncaoSolidity func : info.getFuncoes()) {
            String transId = gerarId("trans");
            
            String guardExpressao = construirGuardExpressao(func, info);
            
            Transicao trans = new Transicao(
                    transId,
                    func.getNome(),
                    guardExpressao
            );
            
            transicoes.add(trans);
            transicoesFunc.put(func.getNome(), trans);
            
            System.out.println(String.format("  Transição: %s%s", 
                    func.getNome(), 
                    !guardExpressao.isEmpty() ? " [Guard: " + guardExpressao + "]" : ""));
        }
    }

    private void criarArcosFluxoDados(ListasInfo info) {
        System.out.println("\n--- Criando Arcos de Fluxo de Dados ---");
        
        Map<String, Set<String>> variavelsPorFuncao = mapearVariaveisAFuncoes(info);
        
        for (FuncaoSolidity func : info.getFuncoes()) {
            Transicao trans = transicoesFunc.get(func.getNome());
            if (trans == null) {
                continue;
            }
            
            Set<String> variaveisUsadas = variavelsPorFuncao.getOrDefault(func.getNome(), new HashSet<>());
            
            for (String nomeVar : variaveisUsadas) {
                Lugar lugarVar = lugaresVariaveis.get(nomeVar);
                if (lugarVar != null) {
                    criarArcoDuplo(lugarVar, trans);
                }
            }
            
            // Criar arcos de parâmetros (tanto para funções quanto para construtor)
            criarArcosParametros(func, trans);
        }
    }

    private void criarArcoDuplo(Lugar lugar, Transicao transicao) {
        String arcoId1 = gerarId("arco");
        String arcoId2 = gerarId("arco");
        
        Arco arcoEntrada = new Arco(arcoId1, lugar.getId(), transicao.getId(), lugar.getColorSet());
        Arco arcoSaida = new Arco(arcoId2, transicao.getId(), lugar.getId(), lugar.getColorSet());
        
        arcos.add(arcoEntrada);
        arcos.add(arcoSaida);
        
        System.out.println(String.format("  Arco Duplo: %s <-> %s (expressão: %s)", 
                lugar.getName(), transicao.getName(), lugar.getColorSet()));
    }

    private void criarArcosParametros(FuncaoSolidity func, Transicao trans) {
        if (func.getVisibilidade().equals("public") || func.getVisibilidade().equals("external") || func.isConstructor()) {
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

    private void criarArcosCondicionais(ListasInfo info) {
        System.out.println("\n--- Analisando Condicionais (Require/Assert) ---");
        
        for (Condicional cond : info.getCondicionais()) {
            Transicao trans = transicoesFunc.get(cond.getNomeFuncao());
            if (trans != null && !trans.getGuard().isEmpty()) {
                System.out.println(String.format("  Condicional %s na função %s: %s", 
                        cond.getTipo(), cond.getNomeFuncao(), cond.getExpressao()));
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
