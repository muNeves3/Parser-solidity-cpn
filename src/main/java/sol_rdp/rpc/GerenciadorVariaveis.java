package sol_rdp.rpc;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorVariaveis {

    // Gerador de caracteres por tipo
    private Map<String, Character> controleTipos;

    // Memória da Transição Atual: "Nome da Variável Solidity" -> "Letra da RPC"
    private Map<String, String> variaveisMapeadasNaTransicao;

    public GerenciadorVariaveis() {
        iniciarNovoEscopoDeTransicao();
    }

    /**
     * Prepara a memória para uma nova transição.
     */
    public void iniciarNovoEscopoDeTransicao() {
        this.variaveisMapeadasNaTransicao = new HashMap<>();
        this.controleTipos = new HashMap<>();

        // Mapeamento dos tipos primitivos mais comuns do Solidity
        this.controleTipos.put("address", 'Z'); // Z, Y, X...
        this.controleTipos.put("uint", 'E'); // E, F, G...
        this.controleTipos.put("int", 'E'); // E, F, G...
        this.controleTipos.put("bool", 'A'); // A, B, C...
        this.controleTipos.put("string", 'S'); // S, T, U...
        this.controleTipos.put("bytes", 'V'); // V, W...

        // Fallback genérico de segurança
        this.controleTipos.put("default", 'M');
    }

    /**
     * Retorna a letra da RPC para uma variável Solidity dentro da transição atual.
     */
    public String getVariavel(String nomeVariavelSolidity, String tipoSolidity) {

        // 1. Variável já foi processada nesta transição?
        if (variaveisMapeadasNaTransicao.containsKey(nomeVariavelSolidity)) {
            return variaveisMapeadasNaTransicao.get(nomeVariavelSolidity);
        }

        // 2. Normaliza o tipo e lida com Structs/Enums (User-Defined Types)
        String tipoSanitizado = normalizarTipo(tipoSolidity);

        // Se for um tipo customizado que ainda não tem um contador, criamos um
        // dinamicamente
        if (!controleTipos.containsKey(tipoSanitizado)) {
            registrarTipoCustomizado(tipoSanitizado);
        }

        // 3. Pega o caractere atual para este tipo
        char letraGerada = controleTipos.get(tipoSanitizado);
        String nomeVariavelRPC = String.valueOf(letraGerada);

        // 4. Atualiza o alfabeto para a próxima variável DESTE TIPO
        if (tipoSanitizado.equals("address")) {
            controleTipos.put(tipoSanitizado, (char) (letraGerada - 1)); // Decrementa
        } else {
            controleTipos.put(tipoSanitizado, (char) (letraGerada + 1)); // Incrementa
        }

        // 5. Salva na memória do escopo atual
        variaveisMapeadasNaTransicao.put(nomeVariavelSolidity, nomeVariavelRPC);

        return nomeVariavelRPC;
    }

    /**
     * Normaliza as variações dos tipos primitivos do Solidity.
     */
    private String normalizarTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty())
            return "default";

        String t = tipo.trim();

        // Trata todas as variações de uint (uint8, uint256, etc)
        if (t.startsWith("uint"))
            return "uint";

        // Trata todas as variações de int (int8, int256, etc)
        if (t.startsWith("int"))
            return "int";

        // Trata variações de bytes (bytes1, bytes32, etc)
        if (t.startsWith("bytes"))
            return "bytes";

        // Tipos estritos
        if (t.equals("address") || t.equals("address payable"))
            return "address";
        if (t.equals("bool"))
            return "bool";
        if (t.equals("string"))
            return "string";

        // Se não for nenhum tipo primitivo mapeado, assumimos que é um Struct ou Enum
        // (ex: "Pessoa")
        // Retornamos o próprio nome para que ganhe um contador dinâmico.
        return t;
    }

    /**
     * Cria um contador de letras baseando-se na primeira letra do Struct/Enum.
     */
    private void registrarTipoCustomizado(String tipoCustomizado) {
        // Pega a primeira letra do tipo customizado (ex: "Pessoa" -> 'P')
        char primeiraLetra = tipoCustomizado.toUpperCase().charAt(0);

        // Para evitar colisões com tipos nativos (ex: Uint que usa 'E', 'F'),
        // poderíamos adicionar uma validação aqui. Para simplificar, iniciamos o
        // contador.
        this.controleTipos.put(tipoCustomizado, primeiraLetra);
    }

    public Map<String, String> getMapaVariaveis() {
        return variaveisMapeadasNaTransicao;
    }
}