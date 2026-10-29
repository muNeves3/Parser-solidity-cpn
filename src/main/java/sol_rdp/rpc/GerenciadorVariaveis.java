package sol_rdp.rpc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GerenciadorVariaveis {

    // Mapa: nome da variável no Solidity -> variável SML no arco (ex: "receiver" ->
    // "Z")
    private final Map<String, String> mapaSolidityParaSML;
    // Mapa: variável SML -> ColorSet SML (ex: "Z" -> "ADDRESS")
    private final Map<String, String> mapaVariavelParaCor;

    private static final String[] POOL_ADDRESS = { "Z", "D", "W", "U" };
    private static final String[] POOL_UINT = { "E", "F", "P", "Q", "V", "T", "I" };
    private static final String[] POOL_BOOL = { "B", "A", "C" };
    private static final String[] POOL_GERAL = { "X", "M", "N", "R", "S" };

    private int idxAddress = 0;
    private int idxUint = 0;
    private int idxBool = 0;
    private int idxGeral = 0;

    public GerenciadorVariaveis() {
        this.mapaSolidityParaSML = new LinkedHashMap<>();
        this.mapaVariavelParaCor = new LinkedHashMap<>();
    }

    /**
     * Obtém a variável SML já associada ao identificador Solidity nesta transição
     * ou aloca uma nova variável única do ColorSet correspondente.
     */
    public String obterOuAlocarVariavel(String nomeSolidity, String colorSet) {
        String chave = nomeSolidity.trim();
        if (mapaSolidityParaSML.containsKey(chave)) {
            return mapaSolidityParaSML.get(chave);
        }

        String varSML;
        // Padroniza msg.sender sempre como "Y" para consistência entre arcos
        if (chave.equals("msg.sender") || chave.equals("msg.send")) {
            varSML = "Y";
        } else if (chave.equals("parconstrutor")) {
            varSML = "A";
        } else {
            varSML = proximoSimboloDisponivel(colorSet);
        }

        mapaSolidityParaSML.put(chave, varSML);
        mapaVariavelParaCor.put(varSML, colorSet);
        return varSML;
    }

    private String proximoSimboloDisponivel(String colorSet) {
        String cor = colorSet.toUpperCase();
        if (cor.equals("ADDRESS")) {
            while (idxAddress < POOL_ADDRESS.length) {
                String cand = POOL_ADDRESS[idxAddress++];
                if (!mapaVariavelParaCor.containsKey(cand))
                    return cand;
            }
            return "ADDR_" + (++idxAddress);
        } else if (cor.equals("UINT") || cor.equals("INT")) {
            while (idxUint < POOL_UINT.length) {
                String cand = POOL_UINT[idxUint++];
                if (!mapaVariavelParaCor.containsKey(cand))
                    return cand;
            }
            return "U_" + (++idxUint);
        } else if (cor.equals("BOOL")) {
            while (idxBool < POOL_BOOL.length) {
                String cand = POOL_BOOL[idxBool++];
                if (!mapaVariavelParaCor.containsKey(cand))
                    return cand;
            }
            return "B_" + (++idxBool);
        } else {
            while (idxGeral < POOL_GERAL.length) {
                String cand = POOL_GERAL[idxGeral++];
                if (!mapaVariavelParaCor.containsKey(cand))
                    return cand;
            }
            return "V_" + (++idxGeral);
        }
    }

    public void registrarVariavelExplicita(String nomeSolidity, String varSML, String colorSet) {
        mapaSolidityParaSML.put(nomeSolidity.trim(), varSML);
        mapaVariavelParaCor.put(varSML, colorSet);
    }

    public String buscarVariavelSML(String nomeSolidity) {
        return mapaSolidityParaSML.get(nomeSolidity.trim());
    }

    public Map<String, String> getMapaSolidityParaSML() {
        return new HashMap<>(mapaSolidityParaSML);
    }

    public Map<String, String> getMapaVariavelParaCor() {
        return new LinkedHashMap<>(mapaVariavelParaCor);
    }
}