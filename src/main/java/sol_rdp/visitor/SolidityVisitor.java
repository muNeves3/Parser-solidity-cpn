package sol_rdp.visitor;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import sol_rdp.antlr.SolidityParserBaseVisitor;
import sol_rdp.antlr.SolidityParser;
import sol_rdp.solidity.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolidityVisitor extends SolidityParserBaseVisitor<Object> {
    private ListasInfo info;
    private String contratoAtual;
    private String funcaoAtual;

    public SolidityVisitor() {
        this.info = null;
        this.contratoAtual = "";
        this.funcaoAtual = "";
    }

    @Override
    public Object visitSourceUnit(SolidityParser.SourceUnitContext ctx) {
        info = new ListasInfo("Contrato");
        visitChildren(ctx);
        return info;
    }

    @Override
    public Object visitContractDefinition(SolidityParser.ContractDefinitionContext ctx) {
        if (ctx.identifier() != null) {
            contratoAtual = ctx.identifier().getText();
            info.setNomeContrato(contratoAtual);
        }
        
        // Processar os elementos do contrato (contractBodyElement*)
        for (int i = 0; i < ctx.contractBodyElement().size(); i++) {
            SolidityParser.ContractBodyElementContext element = ctx.contractBodyElement(i);
            
            // Verificar se é uma variável de estado
            if (element.stateVariableDeclaration() != null) {
                visitStateVariableDeclaration(element.stateVariableDeclaration());
            }
            // Verificar se é um construtor
            else if (element.constructorDefinition() != null) {
                visitConstructorDefinition(element.constructorDefinition());
            }
            // Verificar se é uma função
            else if (element.functionDefinition() != null) {
                visitFunctionDefinition(element.functionDefinition());
            }
        }
        
        return null;
    }

    @Override
    public Object visitStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx) {
        String texto = ctx.getText();
        
        // Extrair tipo usando typeName() do ANTLR
        String tipo = "";
        if (ctx.typeName() != null) {
            tipo = ctx.typeName().getText();
        }
        
        // Extrair nome e visibilidade
        String nome = "";
        String visibilidade = "internal";
        
        // Procurar por palavras-chave de visibilidade no texto
        if (texto.contains("public")) {
            visibilidade = "public";
        } else if (texto.contains("private")) {
            visibilidade = "private";
        } else if (texto.contains("external")) {
            visibilidade = "external";
        } else if (texto.contains("internal")) {
            visibilidade = "internal";
        }
        
        // Extrair nome - remove tipo do início e procura o primeiro identificador válido após visibilidade
        String semTipo = texto;
        if (!tipo.isEmpty()) {
            semTipo = texto.replaceFirst(Pattern.quote(tipo), "").trim();
        }
        
        // Remove visibilidade
        semTipo = semTipo.replaceAll("public|private|internal|external|constant|immutable", "").trim();
        
        // O primeiro token restante é o nome
        if (!semTipo.isEmpty()) {
            String[] partes = semTipo.split(";")[0].split("[=,]");
            String primeiraParte = partes[0].trim();
            // Extrair apenas identificador válido
            if (primeiraParte.matches(".*[a-zA-Z_][a-zA-Z0-9_]*.*")) {
                nome = primeiraParte.replaceAll("[^a-zA-Z0-9_]", "");
                // Se não conseguiu, tenta outro método
                if (nome.isEmpty() || nome.length() < 1) {
                    nome = primeiraParte.trim();
                }
            }
        }
        
        // Extrair valor inicial
        String valorInicial = "";
        if (ctx.expression() != null) {
            valorInicial = ctx.expression().getText();
        }
        
        if (!nome.isEmpty() && !tipo.isEmpty()) {
            VariavelGlobal var = new VariavelGlobal(nome, tipo, visibilidade, valorInicial, "");
            info.adicionarVariavelGlobal(var);
        }
        
        return null;
    }

    public Object visitConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx) {
        String nomeFuncao = "constructor";
        funcaoAtual = nomeFuncao;
        
        String visibilidade = "internal";
        Map<String, String> parametros = new HashMap<>();
        List<String> nomesRetorno = new ArrayList<>();
        List<String> tiposRetorno = new ArrayList<>();
        List<String> modifiers = new ArrayList<>();
        boolean isConstructor = true;
        
        // Extrair parâmetros
        if (ctx.arguments != null) {
            for (SolidityParser.ParameterDeclarationContext paramDecl : ctx.arguments.parameters) {
                String tipoParam = paramDecl.type.getText();
                String nomeParam = "";
                if (paramDecl.name != null) {
                    nomeParam = paramDecl.name.getText();
                }
                if (nomeParam.isEmpty() || nomeParam.equals("")) {
                    nomeParam = "param_" + parametros.size();
                }
                parametros.put(nomeParam, tipoParam);
            }
        }
        
        int linhaInicio = ctx.getStart().getLine();
        int linhaFim = ctx.getStop().getLine();
        
        FuncaoSolidity funcao = new FuncaoSolidity(
                nomeFuncao, nomesRetorno, tiposRetorno, visibilidade, parametros,
                linhaInicio, linhaFim, modifiers, isConstructor
        );
        
        info.adicionarFuncao(funcao);
        
        analisarBloco(ctx.getText());
        
        funcaoAtual = "";
        return null;
    }

    @Override
    public Object visitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx) {
        String nomeFuncao = "";
        if (ctx.identifier() != null) {
            nomeFuncao = ctx.identifier().getText();
        }
        
        if (nomeFuncao.isEmpty()) {
            nomeFuncao = "constructor";
        }
        
        funcaoAtual = nomeFuncao;
        
        String visibilidade = "internal";
        Map<String, String> parametros = new HashMap<>();
        List<String> nomesRetorno = new ArrayList<>();
        List<String> tiposRetorno = new ArrayList<>();
        List<String> modifiers = new ArrayList<>();
        boolean isConstructor = nomeFuncao.equals("constructor");
        
        String texto = ctx.getText();
        if (texto.contains("public")) {
            visibilidade = "public";
        } else if (texto.contains("private")) {
            visibilidade = "private";
        } else if (texto.contains("external")) {
            visibilidade = "external";
        }

        if (ctx.arguments != null && ctx.arguments.parameters != null) {
            for (SolidityParser.ParameterDeclarationContext paramDecl : ctx.arguments.parameters) {
                String tipoParam = paramDecl.type.getText();
                String nomeParam = "";
                if (paramDecl.name != null) {
                    nomeParam = paramDecl.name.getText();
                }
                // Se não tem nome, usar um genérico baseado no tipo
                if (nomeParam.isEmpty() || nomeParam.equals("")) {
                    nomeParam = "param_" + parametros.size();
                }
                parametros.put(nomeParam, tipoParam);
            }
        }
        

        if (texto.contains("view")) {
            modifiers.add("view");
        }
        if (texto.contains("pure")) {
            modifiers.add("pure");
        }
        if (texto.contains("payable")) {
            modifiers.add("payable");
        }
        
        int linhaInicio = ctx.getStart().getLine();
        int linhaFim = ctx.getStop().getLine();
        
        FuncaoSolidity funcao = new FuncaoSolidity(
                nomeFuncao, nomesRetorno, tiposRetorno, visibilidade, parametros,
                linhaInicio, linhaFim, modifiers, isConstructor
        );
        
        info.adicionarFuncao(funcao);
        
        analisarBloco(ctx.getText());
        
        funcaoAtual = "";
        return visitChildren(ctx);
    }

    private void analisarBloco(String blocoTexto) {
        extrairRequires(blocoTexto);
        extrairAsserts(blocoTexto);
        extrairOperacoes(blocoTexto);
        extrairChamadas(blocoTexto);
    }

    private void extrairRequires(String texto) {
        Pattern pattern = Pattern.compile("require\\s*\\(([^)]*)\\)");
        Matcher matcher = pattern.matcher(texto);
        
        while (matcher.find()) {
            String expressao = matcher.group(1);
            if (expressao.contains(",")) {
                expressao = expressao.split(",")[0];
            }
            Condicional cond = new Condicional("require", expressao.trim(), funcaoAtual, 0);
            info.adicionarCondicional(cond);
        }
    }

    private void extrairAsserts(String texto) {
        Pattern pattern = Pattern.compile("assert\\s*\\(([^)]*)\\)");
        Matcher matcher = pattern.matcher(texto);
        
        while (matcher.find()) {
            String expressao = matcher.group(1);
            Condicional cond = new Condicional("assert", expressao.trim(), funcaoAtual, 0);
            info.adicionarCondicional(cond);
        }
    }

    private void extrairOperacoes(String texto) {
        Pattern pattern = Pattern.compile("([a-zA-Z_][a-zA-Z0-9_]*)\\s*([+\\-*/%]?=)\\s*([^;=]*)");
        Matcher matcher = pattern.matcher(texto);
        
        Set<String> jaProcessadas = new HashSet<>();
        while (matcher.find()) {
            String varDestino = matcher.group(1);
            String operador = matcher.group(2);
            String lado_direito = matcher.group(3).trim();
            
            if (!varDestino.equals("require") && !varDestino.equals("assert") && !jaProcessadas.contains(varDestino + operador + lado_direito)) {
                List<String> operandos = new ArrayList<>();
                operandos.add(lado_direito);
                
                OperacaoSolidity op = new OperacaoSolidity(varDestino, operador, operandos, 0, funcaoAtual);
                info.adicionarOperacao(op);
                jaProcessadas.add(varDestino + operador + lado_direito);
            }
        }
    }

    private void extrairChamadas(String texto) {
        Pattern pattern = Pattern.compile("([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\(([^)]*)\\)");
        Matcher matcher = pattern.matcher(texto);
        
        Set<String> jaProcessadas = new HashSet<>();
        while (matcher.find()) {
            String nomeFuncaoAlvo = matcher.group(1);
            String args = matcher.group(2);
            
            if (!nomeFuncaoAlvo.equals("require") && !nomeFuncaoAlvo.equals("assert") && !jaProcessadas.contains(nomeFuncaoAlvo)) {
                List<String> argumentos = new ArrayList<>();
                if (!args.isEmpty()) {
                    for (String arg : args.split(",")) {
                        argumentos.add(arg.trim());
                    }
                }
                
                ChamadaFuncao chamada = new ChamadaFuncao(funcaoAtual, nomeFuncaoAlvo, argumentos, 0);
                info.adicionarChamada(chamada);
                jaProcessadas.add(nomeFuncaoAlvo);
            }
        }
    }
}
