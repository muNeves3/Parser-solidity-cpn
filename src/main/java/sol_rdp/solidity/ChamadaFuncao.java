package sol_rdp.solidity;

import java.util.List;

public class ChamadaFuncao {
    private String nomeFuncaoChamadora;
    private String nomeFuncaoAlvo;
    private List<String> argumentos;
    private int linha;

    public ChamadaFuncao(String nomeFuncaoChamadora, String nomeFuncaoAlvo, List<String> argumentos, int linha) {
        this.nomeFuncaoChamadora = nomeFuncaoChamadora;
        this.nomeFuncaoAlvo = nomeFuncaoAlvo;
        this.argumentos = argumentos;
        this.linha = linha;
    }

    public String getNomeFuncaoChamadora() {
        return nomeFuncaoChamadora;
    }

    public void setNomeFuncaoChamadora(String nomeFuncaoChamadora) {
        this.nomeFuncaoChamadora = nomeFuncaoChamadora;
    }

    public String getNomeFuncaoAlvo() {
        return nomeFuncaoAlvo;
    }

    public void setNomeFuncaoAlvo(String nomeFuncaoAlvo) {
        this.nomeFuncaoAlvo = nomeFuncaoAlvo;
    }

    public List<String> getArgumentos() {
        return argumentos;
    }

    public void setArgumentos(List<String> argumentos) {
        this.argumentos = argumentos;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    @Override
    public String toString() {
        return String.format("ChamadaFuncao{nomeFuncaoChamadora='%s', nomeFuncaoAlvo='%s', argumentos=%s, linha=%d}",
                nomeFuncaoChamadora, nomeFuncaoAlvo, argumentos, linha);
    }
}
