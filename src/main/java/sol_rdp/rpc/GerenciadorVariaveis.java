package sol_rdp.rpc;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorVariaveis {
    private char letraAtual = 'A';
    private int cicloAtual = 0;

    private Map<String, String> mapaVariaveis = new HashMap<>();

    public String getOuCriarVariavel(String nomeSolidity, String tipoCor) {
        // Reutiliza a variável se ela já foi mapeada nesta transição
        if (nomeSolidity != null && mapaVariaveis.containsKey(nomeSolidity)) {
            return mapaVariaveis.get(nomeSolidity);
        }

        // Monta a string da nova variável (ex: A, B, C... Z, A1, B1...)
        String novaVar = cicloAtual == 0 ? String.valueOf(letraAtual) : letraAtual + String.valueOf(cicloAtual);

        // Incrementa o contador ASCII (de A até Z)
        letraAtual++;
        if (letraAtual > 'Z') {
            letraAtual = 'A';
            cicloAtual++;
        }

        // Registra a nova associação
        if (nomeSolidity != null && !nomeSolidity.isEmpty()) {
            mapaVariaveis.put(nomeSolidity, novaVar);
        }

        return novaVar;
    }

    public Map<String, String> getMapa() {
        return mapaVariaveis;
    }
}