package sol_rdp.rpc;

import java.util.HashMap;
import java.util.Map;

class GerenciadorVariaveis {
    private int addrCount = 0;
    private int uintCount = 0;
    private final String[] addrVars = { "Z", "Y", "X", "W" };
    private final String[] uintVars = { "E", "F", "G", "H" };

    // Mapeia o nome da variável no Solidity para a letra na RPC (ex: "amount" ->
    // "E")
    private Map<String, String> mapaVariaveis = new HashMap<>();

    public String getOuCriarVariavel(String nomeSolidity, String tipoCor) {
        // Se já associou uma letra a essa variável nesta transição, reutiliza
        if (nomeSolidity != null && mapaVariaveis.containsKey(nomeSolidity)) {
            return mapaVariaveis.get(nomeSolidity);
        }

        String novaVar;
        if (tipoCor.equals("ADDRESS") || tipoCor.equals("AZUL")) {
            novaVar = addrCount < addrVars.length ? addrVars[addrCount++] : "Addr" + addrCount++;
        } else if (tipoCor.equals("UINT") || tipoCor.equals("VERDE")) {
            novaVar = uintCount < uintVars.length ? uintVars[uintCount++] : "Num" + uintCount++;
        } else {
            novaVar = "V_" + tipoCor;
        }

        if (nomeSolidity != null && !nomeSolidity.isEmpty()) {
            mapaVariaveis.put(nomeSolidity, novaVar);
        }
        return novaVar;
    }

    public Map<String, String> getMapa() {
        return mapaVariaveis;
    }
}