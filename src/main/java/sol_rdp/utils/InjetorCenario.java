package sol_rdp.utils;

import sol_rdp.cpn.Arco;
import sol_rdp.cpn.Lugar;
import sol_rdp.cpn.Transicao;
import sol_rdp.rpc.RPCBuilder;
import sol_rdp.solidity.FuncaoSolidity;
import sol_rdp.solidity.ListasInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InjetorCenario {

    /**
     * Lê o arquivo scenario.json gerado pela Etapa 1 (ou pelo Recorder do Remix)
     * e injeta as marcas temporizadas (@1, @2, @3... com +++) nos lugares oráculo
     * da RPC.
     */
    public static void aplicarCenario(String caminhoScenarioJson, RPCBuilder builder, ListasInfo info)
            throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(caminhoScenarioJson)));

        // 1. Mapeia "account{0}": "0x..." -> endereço real
        Map<String, String> contas = new HashMap<>();
        Matcher mAcc = Pattern.compile("\"(account\\{\\d+\\})\"\\s*:\\s*\"([^\"]+)\"").matcher(json);
        while (mAcc.find()) {
            contas.put(mAcc.group(1), mAcc.group(2));
        }

        Map<String, Lugar> lugaresPorNome = new HashMap<>();
        Map<String, List<String>> filasMarcasPorLugar = new LinkedHashMap<>();
        for (Lugar l : builder.getLugares()) {
            lugaresPorNome.put(l.getName(), l);
            filasMarcasPorLugar.put(l.getName(), new ArrayList<>());
        }

        // 2. Percorre cada transação gravada no scenario.json usando contagem
        // balanceada de chaves
        Matcher mHeader = Pattern.compile("\"timestamp\"\\s*:\\s*(\\d+)\\s*,\\s*\"record\"\\s*:\\s*\\{", Pattern.DOTALL)
                .matcher(json);

        int contadorFallback = 0;
        while (mHeader.find()) {
            contadorFallback++;
            int passo = Integer.parseInt(mHeader.group(1));
            if (passo <= 0)
                passo = contadorFallback;

            int indiceAbreChave = mHeader.end() - 1;
            String blocoRecord = extrairBlocoBalanceado(json, indiceAbreChave);

            String tipo = extrairCampoString(blocoRecord, "type");
            String nomeFunc = extrairCampoString(blocoRecord, "name");
            String fromRaw = extrairCampoString(blocoRecord, "from");
            String valueRaw = extrairCampoString(blocoRecord, "value");
            List<String> paramsRaw = extrairArrayParametros(blocoRecord);

            String enderecoSender = contas.getOrDefault(fromRaw, fromRaw);
            boolean ehConstrutor = "constructor".equalsIgnoreCase(tipo)
                    || "constructor".equalsIgnoreCase(nomeFunc)
                    || "construtor".equalsIgnoreCase(nomeFunc);

            String nomeTransicaoRPC = ehConstrutor ? "construtor" : nomeFunc;

            // A) Marca no lugar de parâmetros (parconstrutor ou par<funcao>)
            if (ehConstrutor) {
                if (filasMarcasPorLugar.containsKey("parconstrutor")) {
                    if (paramsRaw.isEmpty()) {
                        filasMarcasPorLugar.get("parconstrutor").add("1`true@" + passo);
                    } else {
                        FuncaoSolidity fConst = buscarFuncao("constructor", info);
                        String token = formatarTokenParametros(paramsRaw, fConst);
                        filasMarcasPorLugar.get("parconstrutor").add("1`" + token + "@" + passo);
                    }
                }
            } else {
                String nomeLugarPar = "par" + nomeFunc;
                if (filasMarcasPorLugar.containsKey(nomeLugarPar)) {
                    FuncaoSolidity f = buscarFuncao(nomeFunc, info);
                    String token = formatarTokenParametros(paramsRaw, f);
                    filasMarcasPorLugar.get(nomeLugarPar).add("1`" + token + "@" + passo);
                }
            }

            // B) Marca em msg.send (se a transição tiver arco vindo de msg.send)
            if (transicaoConsomeDeLugar(nomeTransicaoRPC, "msg.send", builder)) {
                filasMarcasPorLugar.get("msg.send").add("1`\"" + enderecoSender + "\"@" + passo);
            }

            // C) Marca em msg.value (se a transição tiver arco vindo de msg.value)
            if (transicaoConsomeDeLugar(nomeTransicaoRPC, "msg.value", builder)) {
                String valLimpo = (valueRaw == null || valueRaw.isEmpty()) ? "0" : valueRaw.replaceAll("[^0-9]", "");
                if (valLimpo.isEmpty())
                    valLimpo = "0";
                filasMarcasPorLugar.get("msg.value").add("1`" + valLimpo + "@" + passo);
            }
        }

        // 3. Aplica os multiconjuntos temporizados (+++) nos lugares da RPC
        int lugaresPreenchidos = 0;
        for (Map.Entry<String, List<String>> entry : filasMarcasPorLugar.entrySet()) {
            List<String> marcas = entry.getValue();
            if (!marcas.isEmpty() && lugaresPorNome.containsKey(entry.getKey())) {
                String initTimed = String.join(" +++\n", marcas);
                lugaresPorNome.get(entry.getKey()).setInitialMarking(initTimed);
                lugaresPreenchidos++;
            }
        }

        System.out.println("[2/4] Cenario injetado: " + contadorFallback + " transacoes (@1..@"
                + contadorFallback + ") distribuidas em " + lugaresPreenchidos + " lugares.");
    }

    /**
     * Extrai o conteúdo interno de um objeto JSON {...} respeitando chaves
     * aninhadas
     * e ignorando chaves dentro de strings (como "account{0}").
     */
    private static String extrairBlocoBalanceado(String texto, int indiceAbreChave) {
        if (indiceAbreChave < 0 || indiceAbreChave >= texto.length() || texto.charAt(indiceAbreChave) != '{') {
            return "";
        }
        int profundidade = 0;
        boolean emAspas = false;
        for (int i = indiceAbreChave; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == '"' && (i == 0 || texto.charAt(i - 1) != '\\')) {
                emAspas = !emAspas;
            } else if (!emAspas) {
                if (c == '{') {
                    profundidade++;
                } else if (c == '}') {
                    profundidade--;
                    if (profundidade == 0) {
                        return texto.substring(indiceAbreChave + 1, i);
                    }
                }
            }
        }
        return "";
    }

    private static boolean transicaoConsomeDeLugar(String nomeTransicao, String nomeLugar, RPCBuilder builder) {
        String idLugar = null;
        for (Lugar l : builder.getLugares()) {
            if (l.getName().equalsIgnoreCase(nomeLugar)) {
                idLugar = l.getId();
                break;
            }
        }
        String idTrans = null;
        for (Transicao t : builder.getTransicoes()) {
            if (t.getName().equalsIgnoreCase(nomeTransicao)) {
                idTrans = t.getId();
                break;
            }
        }
        if (idLugar == null || idTrans == null)
            return false;

        for (Arco a : builder.getArcos()) {
            if (a.getSourceId().equals(idLugar) && a.getTargetId().equals(idTrans)) {
                return true;
            }
        }
        return false;
    }

    private static String formatarTokenParametros(List<String> valores, FuncaoSolidity func) {
        List<String> tipos = new ArrayList<>();
        if (func != null && func.getParametros() != null) {
            tipos.addAll(func.getParametros().values());
        }

        List<String> formatados = new ArrayList<>();
        for (int i = 0; i < valores.size(); i++) {
            String v = valores.get(i).trim();
            String t = (i < tipos.size()) ? tipos.get(i).toLowerCase() : "";

            if (t.startsWith("address") || t.equals("string") || v.startsWith("0x")) {
                if (!v.startsWith("\"")) {
                    v = "\"" + v + "\"";
                }
            }
            formatados.add(v);
        }

        if (formatados.size() == 1) {
            return formatados.get(0);
        }
        return "(" + String.join(", ", formatados) + ")";
    }

    private static FuncaoSolidity buscarFuncao(String nome, ListasInfo info) {
        for (FuncaoSolidity f : info.getFuncoes()) {
            if (f.getNome().equalsIgnoreCase(nome)
                    || (nome.equalsIgnoreCase("constructor") && f.isConstructor())) {
                return f;
            }
        }
        return null;
    }

    private static String extrairCampoString(String bloco, String campo) {
        Matcher m = Pattern.compile("\"" + campo + "\"\\s*:\\s*\"([^\"]*)\"").matcher(bloco);
        return m.find() ? m.group(1).trim() : "";
    }

    private static List<String> extrairArrayParametros(String bloco) {
        List<String> params = new ArrayList<>();
        Matcher m = Pattern.compile("\"parameters\"\\s*:\\s*\\[(.*?)\\]", Pattern.DOTALL).matcher(bloco);
        if (m.find()) {
            String conteudo = m.group(1).trim();
            if (!conteudo.isEmpty()) {
                Matcher mItem = Pattern.compile("\"([^\"]*)\"|([^,\\s]+)").matcher(conteudo);
                while (mItem.find()) {
                    String val = mItem.group(1) != null ? mItem.group(1) : mItem.group(2);
                    params.add(val.trim());
                }
            }
        }
        return params;
    }
}