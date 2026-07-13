package sol_rdp.solidity;

import java.util.List;

public class OperacaoSolidity {
    private String variavelDestino;
    private String operador;
    private List<String> operandos;
    private int linha;
    private String nomeFuncao;

    public OperacaoSolidity(String variavelDestino, String operador, List<String> operandos, int linha) {
        this.variavelDestino = variavelDestino;
        this.operador = operador;
        this.operandos = operandos;
        this.linha = linha;
        this.nomeFuncao = "";
    }

    public OperacaoSolidity(String variavelDestino, String operador, List<String> operandos, int linha, String nomeFuncao) {
        this.variavelDestino = variavelDestino;
        this.operador = operador;
        this.operandos = operandos;
        this.linha = linha;
        this.nomeFuncao = nomeFuncao;
    }

    public String getVariavelDestino() {
        return variavelDestino;
    }

    public void setVariavelDestino(String variavelDestino) {
        this.variavelDestino = variavelDestino;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public List<String> getOperandos() {
        return operandos;
    }

    public void setOperandos(List<String> operandos) {
        this.operandos = operandos;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    @Override
    public String toString() {
        return String.format("OperacaoSolidity{variavelDestino='%s', operador='%s', operandos=%s, linha=%d, nomeFuncao='%s'}",
                variavelDestino, operador, operandos, linha, nomeFuncao);
    }
}