package sol_rdp.solidity;

import java.util.List;
import java.util.Map;

public class FuncaoSolidity {
    private String nome;
    private List<String> nomesRetorno;
    private List<String> tiposRetorno;
    private String visibilidade;
    private Map<String, String> parametros;
    private int linhaInicio;
    private int linhaFim;
    private List<String> modifiers;
    private boolean isConstructor;

    public FuncaoSolidity(String nome, List<String> nomesRetorno, List<String> tiposRetorno,
                          String visibilidade, Map<String, String> parametros,
                          int linhaInicio, int linhaFim) {
        this.nome = nome;
        this.nomesRetorno = nomesRetorno;
        this.tiposRetorno = tiposRetorno;
        this.visibilidade = visibilidade;
        this.parametros = parametros;
        this.linhaInicio = linhaInicio;
        this.linhaFim = linhaFim;
        this.modifiers = List.of();
        this.isConstructor = false;
    }

    public FuncaoSolidity(String nome, List<String> nomesRetorno, List<String> tiposRetorno,
                          String visibilidade, Map<String, String> parametros,
                          int linhaInicio, int linhaFim, List<String> modifiers, boolean isConstructor) {
        this.nome = nome;
        this.nomesRetorno = nomesRetorno;
        this.tiposRetorno = tiposRetorno;
        this.visibilidade = visibilidade;
        this.parametros = parametros;
        this.linhaInicio = linhaInicio;
        this.linhaFim = linhaFim;
        this.modifiers = modifiers;
        this.isConstructor = isConstructor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getNomesRetorno() {
        return nomesRetorno;
    }

    public void setNomesRetorno(List<String> nomesRetorno) {
        this.nomesRetorno = nomesRetorno;
    }

    public List<String> getTiposRetorno() {
        return tiposRetorno;
    }

    public void setTiposRetorno(List<String> tiposRetorno) {
        this.tiposRetorno = tiposRetorno;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }

    public int getLinhaInicio() {
        return linhaInicio;
    }

    public void setLinhaInicio(int linhaInicio) {
        this.linhaInicio = linhaInicio;
    }

    public int getLinhaFim() {
        return linhaFim;
    }

    public void setLinhaFim(int linhaFim) {
        this.linhaFim = linhaFim;
    }

    public List<String> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<String> modifiers) {
        this.modifiers = modifiers;
    }

    public boolean isConstructor() {
        return isConstructor;
    }

    public void setConstructor(boolean constructor) {
        isConstructor = constructor;
    }

    @Override
    public String toString() {
        return String.format("FuncaoSolidity{nome='%s', visibilidade='%s', parametros=%s, modifiers=%s}",
                nome, visibilidade, parametros, modifiers);
    }
}