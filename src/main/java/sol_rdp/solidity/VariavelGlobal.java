package sol_rdp.solidity;

public class VariavelGlobal {
    private String nome;
    private String tipo;
    private String visibilidade;
    private String valorInicial;
    private String tipoIndice;

    public VariavelGlobal(String nome, String tipo, String visibilidade, String valorInicial, String tipoIndice) {
        this.nome = nome;
        this.tipo = tipo;
        this.visibilidade = visibilidade;
        this.valorInicial = valorInicial;
        this.tipoIndice = tipoIndice;
    }

    public VariavelGlobal(String nome, String tipo, String visibilidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.visibilidade = visibilidade;
        this.valorInicial = "";
        this.tipoIndice = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
    }

    public String getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(String valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getTipoIndice() {
        return tipoIndice;
    }

    public void setTipoIndice(String tipoIndice) {
        this.tipoIndice = tipoIndice;
    }

    @Override
    public String toString() {
        return String.format("VariavelGlobal{nome='%s', tipo='%s', visibilidade='%s', valorInicial='%s', tipoIndice='%s'}",
                nome, tipo, visibilidade, valorInicial, tipoIndice);
    }
}
