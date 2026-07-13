package sol_rdp.solidity;

public class Condicional {
    private String tipo;
    private String expressao;
    private String nomeFuncao;
    private int linha;
    private String mensagem;

    public Condicional(String tipo, String expressao, String nomeFuncao, int linha) {
        this.tipo = tipo;
        this.expressao = expressao;
        this.nomeFuncao = nomeFuncao;
        this.linha = linha;
        this.mensagem = "";
    }

    public Condicional(String tipo, String expressao, String nomeFuncao, int linha, String mensagem) {
        this.tipo = tipo;
        this.expressao = expressao;
        this.nomeFuncao = nomeFuncao;
        this.linha = linha;
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return String.format("Condicional{tipo='%s', expressao='%s', nomeFuncao='%s', linha=%d, mensagem='%s'}",
                tipo, expressao, nomeFuncao, linha, mensagem);
    }
}
