package sol_rdp.solidity;

import java.util.ArrayList;
import java.util.List;

public class ListasInfo {
    private String nomeContrato;
    private List<VariavelGlobal> variaveisGlobais;
    private List<FuncaoSolidity> funcoes;
    private List<OperacaoSolidity> operacoes;
    private List<ChamadaFuncao> chamadas;
    private List<Condicional> condicionais;
    private List<EnumSolidity> enums;
    private List<StructSolidity> structs;

    public ListasInfo(String nomeContrato) {
        this.nomeContrato = nomeContrato;
        this.variaveisGlobais = new ArrayList<>();
        this.funcoes = new ArrayList<>();
        this.operacoes = new ArrayList<>();
        this.chamadas = new ArrayList<>();
        this.condicionais = new ArrayList<>();
        this.enums = new ArrayList<>();
        this.structs = new ArrayList<>();
    }

    public String getNomeContrato() {
        return nomeContrato;
    }

    public void setNomeContrato(String nomeContrato) {
        this.nomeContrato = nomeContrato;
    }

    public List<VariavelGlobal> getVariaveisGlobais() {
        return variaveisGlobais;
    }

    public void adicionarVariavelGlobal(VariavelGlobal variavel) {
        this.variaveisGlobais.add(variavel);
    }

    public List<FuncaoSolidity> getFuncoes() {
        return funcoes;
    }

    public void adicionarFuncao(FuncaoSolidity funcao) {
        this.funcoes.add(funcao);
    }

    public List<OperacaoSolidity> getOperacoes() {
        return operacoes;
    }

    public void adicionarOperacao(OperacaoSolidity operacao) {
        this.operacoes.add(operacao);
    }

    public List<ChamadaFuncao> getChamadas() {
        return chamadas;
    }

    public void adicionarChamada(ChamadaFuncao chamada) {
        this.chamadas.add(chamada);
    }

    public List<Condicional> getCondicionais() {
        return condicionais;
    }

    public void adicionarCondicional(Condicional condicional) {
        this.condicionais.add(condicional);
    }

    public List<EnumSolidity> getEnums() {
        return enums;
    }

    public void adicionarEnum(EnumSolidity enumSol) {
        this.enums.add(enumSol);
    }

    public List<StructSolidity> getStructs() {
        return structs;
    }

    public void adicionarStruct(StructSolidity structSol) {
        this.structs.add(structSol);
    }

    public void exibirResumo() {
        System.out.println("\n========== RESUMO DA ANÁLISE ==========");
        System.out.println("Contrato: " + nomeContrato);

        if (!enums.isEmpty()) {
            System.out.println("\nEnums (" + enums.size() + "):");
            enums.forEach(e -> System.out.println("  - " + e));
        }

        if (!structs.isEmpty()) {
            System.out.println("\nStructs (" + structs.size() + "):");
            structs.forEach(s -> System.out.println("  - " + s));
        }
        System.out.println("\nVariáveis Globais (" + variaveisGlobais.size() + "):");
        variaveisGlobais.forEach(v -> System.out.println("  - " + v));
        System.out.println("\nFunções (" + funcoes.size() + "):");
        funcoes.forEach(f -> System.out.println("  - " + f));
        System.out.println("\nOperações (" + operacoes.size() + "):");
        operacoes.forEach(o -> System.out.println("  - " + o));
        System.out.println("\nChamadas (" + chamadas.size() + "):");
        chamadas.forEach(c -> System.out.println("  - " + c));
        System.out.println("\nCondicionais (" + condicionais.size() + "):");
        condicionais.forEach(cond -> System.out.println("  - " + cond));
        System.out.println("=======================================\n");
    }

    @Override
    public String toString() {
        return String.format(
                "ListasInfo{nomeContrato='%s', variaveis=%d, funcoes=%d, operacoes=%d, chamadas=%d, condicionais=%d}",
                nomeContrato, variaveisGlobais.size(), funcoes.size(), operacoes.size(), chamadas.size(),
                condicionais.size());
    }
}
