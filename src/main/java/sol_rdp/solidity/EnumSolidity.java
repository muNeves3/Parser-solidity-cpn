package sol_rdp.solidity;

import java.util.List;

public class EnumSolidity {
    private String nome;
    private List<String> valores;

    public EnumSolidity(String nome, List<String> valores) {
        this.nome = nome;
        this.valores = valores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getValores() {
        return valores;
    }

    public void setValores(List<String> valores) {
        this.valores = valores;
    }

    @Override
    public String toString() {
        return String.format("EnumSolidity{nome='%s', valores=%s}", nome, valores);
    }
}
