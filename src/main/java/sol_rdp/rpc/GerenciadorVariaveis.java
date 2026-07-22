package sol_rdp.rpc;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorVariaveis {
    private int addrCount = 0;
    private int uintCount = 0;
    private final String[] addrVars = { "Z", "Y", "X", "W", "D" };
    private final String[] uintVars = { "E", "F", "G", "H" };

    private Map<String, String> mapaVariaveis = new HashMap<>();

    public String getOuCriarVariavel(String nomeSolidity, String tipoCor) {
        if (nomeSolidity != null && mapaVariaveis.containsKey(nomeSolidity)) {
            return mapaVariaveis.get(nomeSolidity);
        }

        String novaVar = "";
        // Roteamento forçado para espelhar as letras exatas da imagem do TCC
        if (nomeSolidity.equals("minter"))
            novaVar = "D";
        else if (nomeSolidity.equals("msg.sender"))
            novaVar = "Y";
        else if (nomeSolidity.equals("receiver"))
            novaVar = "Z";
        else if (nomeSolidity.equals("amount"))
            novaVar = "E";
        else if (nomeSolidity.startsWith("balances"))
            novaVar = "F";
        else if (tipoCor.contains("ADDRESS"))
            novaVar = addrCount < addrVars.length ? addrVars[addrCount++] : "A1";
        else if (tipoCor.contains("UINT"))
            novaVar = uintCount < uintVars.length ? uintVars[uintCount++] : "U1";
        else if (tipoCor.equals("BOOL"))
            novaVar = "A";

        if (!novaVar.isEmpty()) {
            mapaVariaveis.put(nomeSolidity, novaVar);
        }
        return novaVar;
    }

    public Map<String, String> getMapa() {
        return mapaVariaveis;
    }
}