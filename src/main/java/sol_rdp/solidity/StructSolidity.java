package sol_rdp.solidity;

import java.util.Map;

public class StructSolidity {
    private String nome;
    // Mapeia o nome do campo para o seu tipo (ex: "c" -> "Cliente")
    private Map<String, String> campos;

    public StructSolidity(String nome, Map<String, String> campos) {
        this.nome = nome;
        this.campos = campos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, String> getCampos() {
        return campos;
    }

    public void setCampos(Map<String, String> campos) {
        this.campos = campos;
    }

    @Override
    public String toString() {
        return String.format("StructSolidity{nome='%s', campos=%s}", nome, campos);
    }
}
