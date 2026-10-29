package sol_rdp.utils;

import sol_rdp.cpn.Arco;
import sol_rdp.cpn.Lugar;
import sol_rdp.cpn.Transicao;
import sol_rdp.rpc.GerenciadorVariaveis;
import sol_rdp.rpc.RPCBuilder;
import sol_rdp.solidity.EnumSolidity;
import sol_rdp.solidity.ListasInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportadorCPN {

    private int cpnIdCounter = 1412300000;

    private String nextCpnId() {
        return "ID" + (++cpnIdCounter);
    }

    public void exportar(RPCBuilder builder, ListasInfo info, String caminhoArquivo) throws IOException {
        exportar(
                builder.getLugares(),
                builder.getTransicoes(),
                builder.getArcos(),
                builder.getGerenciadoresLocais(),
                builder.getVariavelListaPorVar(),
                builder.getTipoListaPorVar(),
                info,
                caminhoArquivo);
    }

    public void exportar(
            List<Lugar> lugares,
            List<Transicao> transicoes,
            List<Arco> arcos,
            ListasInfo info,
            String caminhoArquivo) throws IOException {
        exportar(lugares, transicoes, arcos, null, null, null, info, caminhoArquivo);
    }

    public void exportar(
            List<Lugar> lugares,
            List<Transicao> transicoes,
            List<Arco> arcos,
            Map<String, GerenciadorVariaveis> gerenciadoresLocais,
            Map<String, String> variavelListaPorVar,
            Map<String, String> tipoListaPorVar,
            ListasInfo info,
            String caminhoArquivo) throws IOException {

        File arquivo = new File(caminhoArquivo);
        if (arquivo.getParentFile() != null) {
            arquivo.getParentFile().mkdirs();
        }

        // Mapeia IDs internos (P1, T10, A14) para IDs numéricos estritos do CPN Tools
        // (ID1412...)
        Map<String, String> mapaIdsXML = new HashMap<>();
        for (Lugar l : lugares) {
            mapaIdsXML.put(l.getId(), nextCpnId());
        }
        for (Transicao t : transicoes) {
            mapaIdsXML.put(t.getId(), nextCpnId());
        }
        for (Arco a : arcos) {
            mapaIdsXML.put(a.getId(), nextCpnId());
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(arquivo))) {
            out.println("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
            out.println(
                    "<!DOCTYPE workspaceElements PUBLIC \"-//CPN//DTD CPNXML 1.0//EN\" \"http://cpntools.org/DTD/6/cpn.dtd\">");
            out.println("<workspaceElements>");
            out.println("  <generator tool=\"CPN Tools\" version=\"4.0.1\" format=\"6\"/>");
            out.println("  <cpnet>");

            // 1. Globbox completo no padrão do CPN Tools 4.0.1
            escreverGlobbox(out, lugares, transicoes, arcos, gerenciadoresLocais, variavelListaPorVar, tipoListaPorVar,
                    info);

            // 2. Página da Rede de Petri
            String pageId = "ID6";
            String pageName = (info != null && info.getNomeContrato() != null && !info.getNomeContrato().isEmpty())
                    ? info.getNomeContrato()
                    : "New Page";

            out.println("    <page id=\"" + pageId + "\">");
            out.println("      <pageattr name=\"" + escaparXML(pageName) + "\"/>");

            Map<String, double[]> posicoesNos = calcularPosicoes(lugares, transicoes);

            for (Lugar l : lugares) {
                double[] pos = posicoesNos.getOrDefault(l.getId(), new double[] { 0.0, 0.0 });
                escreverLugarXML(out, l, mapaIdsXML.get(l.getId()), pos[0], pos[1]);
            }

            for (Transicao t : transicoes) {
                double[] pos = posicoesNos.getOrDefault(t.getId(), new double[] { 0.0, 0.0 });
                escreverTransicaoXML(out, t, mapaIdsXML.get(t.getId()), pos[0], pos[1]);
            }

            Set<String> idsLugares = new HashSet<>();
            for (Lugar l : lugares) {
                idsLugares.add(l.getId());
            }

            Map<String, Integer> contagemParNos = new HashMap<>();
            for (Arco a : arcos) {
                if (posicoesNos.containsKey(a.getSourceId()) && posicoesNos.containsKey(a.getTargetId())) {
                    boolean sourceEhLugar = idsLugares.contains(a.getSourceId());
                    String placeOrigId = sourceEhLugar ? a.getSourceId() : a.getTargetId();
                    String transOrigId = sourceEhLugar ? a.getTargetId() : a.getSourceId();
                    String chavePar = placeOrigId + "_" + transOrigId;
                    int order = contagemParNos.getOrDefault(chavePar, 0) + 1;
                    contagemParNos.put(chavePar, order);

                    escreverArcoXML(out, a, mapaIdsXML.get(a.getId()), mapaIdsXML, idsLugares, posicoesNos, order);
                }
            }

            out.println("      <constraints/>");
            out.println("    </page>");

            // 3. Instância da página
            String instanceId = "ID2149";
            out.println("    <instances>");
            out.println("      <instance id=\"" + instanceId + "\" page=\"" + pageId + "\"/>");
            out.println("    </instances>");

            // 4. Opções padrão do simulador CPN Tools
            escreverOptionsPadrao(out);

            // 5. Binders para abrir a folha da rede na interface gráfica
            out.println("    <binders>");
            out.println("      <cpnbinder id=\"ID2222\" x=\"256\" y=\"8\" width=\"1200\" height=\"800\">");
            out.println("        <sheets>");
            out.println(
                    "          <cpnsheet id=\"ID2215\" panx=\"0.000000\" pany=\"0.000000\" zoom=\"1.000000\" instance=\""
                            + instanceId + "\">");
            out.println("            <zorder>");
            out.println("              <position value=\"0\"/>");
            out.println("            </zorder>");
            out.println("          </cpnsheet>");
            out.println("        </sheets>");
            out.println("        <zorder>");
            out.println("          <position value=\"0\"/>");
            out.println("        </zorder>");
            out.println("      </cpnbinder>");
            out.println("    </binders>");

            out.println("    <monitorblock name=\"Monitors\"/>");
            out.println("    <IndexNode expanded=\"true\"/>");
            out.println("  </cpnet>");
            out.println("</workspaceElements>");
        }
    }

    private void escreverGlobbox(
            PrintWriter out,
            List<Lugar> lugares,
            List<Transicao> transicoes,
            List<Arco> arcos,
            Map<String, GerenciadorVariaveis> gerenciadoresLocais,
            Map<String, String> variavelListaPorVar,
            Map<String, String> tipoListaPorVar,
            ListasInfo info) {

        out.println("    <globbox>");

        // Bloco 1: Standard priorities
        out.println("      <block id=\"" + nextCpnId() + "\">");
        out.println("        <id>Standard priorities</id>");
        out.println("        <ml id=\"" + nextCpnId() + "\">val P_HIGH = 100;");
        out.println("          <layout>val P_HIGH = 100;</layout>");
        out.println("        </ml>");
        out.println("        <ml id=\"" + nextCpnId() + "\">val P_NORMAL = 1000;");
        out.println("          <layout>val P_NORMAL = 1000;</layout>");
        out.println("        </ml>");
        out.println("        <ml id=\"" + nextCpnId() + "\">val P_LOW = 10000;");
        out.println("          <layout>val P_LOW = 10000;</layout>");
        out.println("        </ml>");
        out.println("      </block>");

        // Bloco 2: Standard declarations
        out.println("      <block id=\"ID1\">");
        out.println("        <id>Standard declarations</id>");
        escreverColorBase(out, "ID85042", "UNIT", "unit", "colset UNIT = unit;");
        escreverColorBase(out, "ID4", "BOOL", "bool", null);
        escreverColorBase(out, "ID3", "INT", "int", null);
        escreverColorBase(out, nextCpnId(), "INTINF", "intinf", "colset INTINF = intinf;");
        escreverColorBase(out, nextCpnId(), "TIME", "time", "colset TIME = time;");
        escreverColorBase(out, nextCpnId(), "REAL", "real", "colset REAL = real;");
        escreverColorBase(out, "ID5", "STRING", "string", null);

        // Tipos primitivos do Solidity
        escreverColorBase(out, nextCpnId(), "ADDRESS", "string", "colset ADDRESS = string;");
        escreverColorBase(out, nextCpnId(), "UINT", "int", "colset UINT = int;");

        // Enums do contrato
        if (info != null && info.getEnums() != null) {
            for (EnumSolidity en : info.getEnums()) {
                escreverColorEnum(out, en.getNome().toUpperCase(), en.getValores());
            }
        }

        // Coleta primeiro todas as listas (<TI>_LIST) e depois todos os produtos (que
        // podem depender das listas)
        Set<String> listasDeclaradas = new LinkedHashSet<>();
        Set<String> produtosSimples = new LinkedHashSet<>();
        Set<String> produtosDeListas = new LinkedHashSet<>();

        for (Lugar l : lugares) {
            String cs = l.getColorSet();
            if (cs == null || cs.isEmpty())
                continue;

            if (cs.contains("x")) {
                String[] partes = cs.split("x");
                boolean contemLista = false;
                for (String p : partes) {
                    if (p.endsWith("_LIST")) {
                        listasDeclaradas.add(p);
                        contemLista = true;
                    }
                }
                if (contemLista) {
                    produtosDeListas.add(cs);
                } else {
                    produtosSimples.add(cs);
                }
            } else if (cs.endsWith("_LIST")) {
                listasDeclaradas.add(cs);
            }
        }

        if (tipoListaPorVar != null) {
            listasDeclaradas.addAll(tipoListaPorVar.values());
        }

        // 1º Declara produtos de tipos simples (ex: ADDRESSxUINT, UINTxUINT)
        for (String prod : produtosSimples) {
            escreverColorProduct(out, prod, Arrays.asList(prod.split("x")));
        }

        // 2º Declara tipos de listas (ex: ADDRESS_LIST, UINT_LIST)
        for (String tipoLista : listasDeclaradas) {
            String tipoElem = tipoLista.replace("_LIST", "");
            escreverColorList(out, tipoLista, tipoElem);
        }

        // 3º Declara produtos de listas (ex: ADDRESS_LISTxUINT_LIST)
        for (String prodLista : produtosDeListas) {
            escreverColorProduct(out, prodLista, Arrays.asList(prodLista.split("x")));
        }

        // 4º Declara todas as variáveis SML usadas nos arcos e nas guardas
        Map<String, String> todasVariaveis = new LinkedHashMap<>();
        if (gerenciadoresLocais != null) {
            for (GerenciadorVariaveis gv : gerenciadoresLocais.values()) {
                todasVariaveis.putAll(gv.getMapaVariavelParaCor());
            }
        }
        if (variavelListaPorVar != null && tipoListaPorVar != null) {
            for (Map.Entry<String, String> entry : variavelListaPorVar.entrySet()) {
                todasVariaveis.put(entry.getValue(), tipoListaPorVar.get(entry.getKey()));
            }
        }

        inferirVariaveisDosArcos(lugares, arcos, todasVariaveis);

        for (Map.Entry<String, String> vEntry : todasVariaveis.entrySet()) {
            escreverVarDecl(out, vEntry.getKey(), vEntry.getValue());
        }

        out.println("      </block>");
        out.println("    </globbox>");
    }

    private void inferirVariaveisDosArcos(
            List<Lugar> lugares, List<Arco> arcos, Map<String, String> todasVariaveis) {

        Map<String, Lugar> mapaLugares = new HashMap<>();
        for (Lugar l : lugares) {
            mapaLugares.put(l.getId(), l);
        }

        Pattern padraoIdent = Pattern.compile("\\b([A-Z][A-Z0-9_]*)\\b");

        for (Arco a : arcos) {
            Lugar lugar = mapaLugares.containsKey(a.getSourceId())
                    ? mapaLugares.get(a.getSourceId())
                    : mapaLugares.get(a.getTargetId());
            if (lugar == null)
                continue;

            String corLugar = lugar.getColorSet();
            String expr = a.getExpression();
            if (expr == null || corLugar == null)
                continue;

            if (corLugar.endsWith("_LIST") && !corLugar.contains("x")) {
                String tipoElem = corLugar.replace("_LIST", "");
                Matcher m = padraoIdent.matcher(expr);
                while (m.find()) {
                    String v = m.group(1);
                    if (v.startsWith("L")) {
                        todasVariaveis.putIfAbsent(v, corLugar);
                    } else {
                        todasVariaveis.putIfAbsent(v, tipoElem);
                    }
                }
            } else if (corLugar.contains("x")) {
                String[] tipos = corLugar.split("x");
                int abre = expr.indexOf('(');
                int fecha = expr.lastIndexOf(')');
                if (abre != -1 && fecha != -1 && fecha > abre) {
                    String[] elems = expr.substring(abre + 1, fecha).split(",");
                    for (int i = 0; i < Math.min(tipos.length, elems.length); i++) {
                        String tipoComp = tipos[i];
                        Matcher m = padraoIdent.matcher(elems[i]);
                        while (m.find()) {
                            String v = m.group(1);
                            if (tipoComp.endsWith("_LIST")) {
                                if (v.startsWith("L")) {
                                    todasVariaveis.putIfAbsent(v, tipoComp);
                                } else {
                                    todasVariaveis.putIfAbsent(v, tipoComp.replace("_LIST", ""));
                                }
                            } else {
                                todasVariaveis.putIfAbsent(v, tipoComp);
                            }
                        }
                    }
                }
            } else {
                Matcher m = padraoIdent.matcher(expr);
                while (m.find()) {
                    todasVariaveis.putIfAbsent(m.group(1), corLugar);
                }
            }
        }
    }

    private void escreverColorBase(PrintWriter out, String id, String nome, String tagTipo, String layout) {
        out.println("        <color id=\"" + id + "\">");
        out.println("          <id>" + nome + "</id>");
        out.println("          <" + tagTipo + "/>");
        if (layout != null) {
            out.println("          <layout>" + layout + "</layout>");
        }
        out.println("        </color>");
    }

    private void escreverColorEnum(PrintWriter out, String nome, List<String> valores) {
        out.println("        <color id=\"" + nextCpnId() + "\">");
        out.println("          <id>" + nome + "</id>");
        out.println("          <enum>");
        for (String v : valores) {
            out.println("            <id>" + v + "</id>");
        }
        out.println("          </enum>");
        out.println("          <layout>colset " + nome + " = with " + String.join(" | ", valores) + ";</layout>");
        out.println("        </color>");
    }

    private void escreverColorList(PrintWriter out, String nomeLista, String tipoElemento) {
        out.println("        <color id=\"" + nextCpnId() + "\">");
        out.println("          <id>" + nomeLista + "</id>");
        out.println("          <list>");
        out.println("            <id>" + tipoElemento + "</id>");
        out.println("          </list>");
        out.println("          <layout>colset " + nomeLista + " = list " + tipoElemento + ";</layout>");
        out.println("        </color>");
    }

    private void escreverColorProduct(PrintWriter out, String nomeProduto, List<String> componentes) {
        out.println("        <color id=\"" + nextCpnId() + "\">");
        out.println("          <id>" + nomeProduto + "</id>");
        out.println("          <product>");
        for (String c : componentes) {
            out.println("            <id>" + c + "</id>");
        }
        out.println("          </product>");
        out.println("          <layout>colset " + nomeProduto + " = product " + String.join(" * ", componentes)
                + ";</layout>");
        out.println("        </color>");
    }

    private void escreverVarDecl(PrintWriter out, String nomeVar, String colorSet) {
        out.println("        <var id=\"" + nextCpnId() + "\">");
        out.println("          <type>");
        out.println("            <id>" + colorSet + "</id>");
        out.println("          </type>");
        out.println("          <id>" + nomeVar + "</id>");
        out.println("          <layout>var " + nomeVar + " : " + colorSet + ";</layout>");
        out.println("        </var>");
    }

    private void escreverLugarXML(PrintWriter out, Lugar l, String xmlId, double x, double y) {
        String initMark = (l.getInitialMarking() != null) ? l.getInitialMarking().trim() : "";

        out.println("      <place id=\"" + xmlId + "\">");
        out.println("        <posattr x=\"" + String.format(Locale.US, "%.6f", x) + "\" y=\""
                + String.format(Locale.US, "%.6f", y) + "\"/>");
        out.println("        <fillattr colour=\"White\" pattern=\"\" filled=\"false\"/>");
        out.println("        <lineattr colour=\"Black\" thick=\"1\" type=\"Solid\"/>");
        out.println("        <textattr colour=\"Black\" bold=\"false\"/>");
        out.println("        <text>" + escaparXML(l.getName()) + "</text>");
        out.println("        <ellipse w=\"110.000000\" h=\"56.000000\"/>");
        out.println("        <token x=\"-10.000000\" y=\"0.000000\"/>");
        out.println("        <marking x=\"0.000000\" y=\"0.000000\" hidden=\"false\">");
        out.println("          <snap snap_id=\"0\" anchor.horizontal=\"0\" anchor.vertical=\"0\"/>");
        out.println("        </marking>");
        out.println("        <type id=\"" + nextCpnId() + "\">");
        out.println("          <posattr x=\"" + String.format(Locale.US, "%.6f", x + 50.0) + "\" y=\""
                + String.format(Locale.US, "%.6f", y - 30.0) + "\"/>");
        out.println("          <fillattr colour=\"White\" pattern=\"Solid\" filled=\"false\"/>");
        out.println("          <lineattr colour=\"Black\" thick=\"0\" type=\"Solid\"/>");
        out.println("          <textattr colour=\"Black\" bold=\"false\"/>");
        out.println("          <text tool=\"CPN Tools\" version=\"4.0.1\">" + escaparXML(l.getColorSet()) + "</text>");
        out.println("        </type>");
        out.println("        <initmark id=\"" + nextCpnId() + "\">");
        out.println("          <posattr x=\"" + String.format(Locale.US, "%.6f", x + 50.0) + "\" y=\""
                + String.format(Locale.US, "%.6f", y + 30.0) + "\"/>");
        out.println("          <fillattr colour=\"White\" pattern=\"Solid\" filled=\"false\"/>");
        out.println("          <lineattr colour=\"Black\" thick=\"0\" type=\"Solid\"/>");
        out.println("          <textattr colour=\"Black\" bold=\"false\"/>");
        if (initMark.isEmpty()) {
            out.println("          <text tool=\"CPN Tools\" version=\"4.0.1\"/>");
        } else {
            out.println("          <text tool=\"CPN Tools\" version=\"4.0.1\">" + escaparXML(initMark) + "</text>");
        }
        out.println("        </initmark>");
        out.println("      </place>");
    }

    private void escreverTransicaoXML(PrintWriter out, Transicao t, String xmlId, double x, double y) {
        String guarda = (t.getGuard() != null) ? t.getGuard().trim() : "";

        out.println("      <trans id=\"" + xmlId + "\" explicit=\"false\">");
        out.println("        <posattr x=\"" + String.format(Locale.US, "%.6f", x) + "\" y=\""
                + String.format(Locale.US, "%.6f", y) + "\"/>");
        out.println("        <fillattr colour=\"White\" pattern=\"\" filled=\"false\"/>");
        out.println("        <lineattr colour=\"Black\" thick=\"1\" type=\"Solid\"/>");
        out.println("        <textattr colour=\"Black\" bold=\"false\"/>");
        out.println("        <text>" + escaparXML(t.getName()) + "</text>");
        out.println("        <box w=\"118.000000\" h=\"40.000000\"/>");
        out.println("        <binding x=\"7.200000\" y=\"-3.000000\"/>");

        out.println("        <cond id=\"" + nextCpnId() + "\">");
        out.println("          <posattr x=\"" + String.format(Locale.US, "%.6f", x - 45.0) + "\" y=\""
                + String.format(Locale.US, "%.6f", y + 30.0) + "\"/>");
        out.println("          <fillattr colour=\"White\" pattern=\"Solid\" filled=\"false\"/>");
        out.println("          <lineattr colour=\"Black\" thick=\"0\" type=\"Solid\"/>");
        out.println("          <textattr colour=\"Black\" bold=\"false\"/>");
        if (guarda.isEmpty()) {
            out.println("          <text tool=\"CPN Tools\" version=\"4.0.1\"/>");
        } else {
            out.println("          <text tool=\"CPN Tools\" version=\"4.0.1\">" + escaparXML(guarda) + "</text>");
        }
        out.println("        </cond>");

        out.println("        <time id=\"" + nextCpnId() + "\">");
        out.println("          <posattr x=\"" + String.format(Locale.US, "%.6f", x + 55.0) + "\" y=\""
                + String.format(Locale.US, "%.6f", y + 30.0) + "\"/>");
        out.println("          <fillattr colour=\"White\" pattern=\"Solid\" filled=\"false\"/>");
        out.println("          <lineattr colour=\"Black\" thick=\"0\" type=\"Solid\"/>");
        out.println("          <textattr colour=\"Black\" bold=\"false\"/>");
        out.println("          <text tool=\"CPN Tools\" version=\"4.0.1\"/>");
        out.println("        </time>");

        out.println("        <code id=\"" + nextCpnId() + "\">");
        out.println("          <posattr x=\"" + String.format(Locale.US, "%.6f", x + 65.0) + "\" y=\""
                + String.format(Locale.US, "%.6f", y - 30.0) + "\"/>");
        out.println("          <fillattr colour=\"White\" pattern=\"Solid\" filled=\"false\"/>");
        out.println("          <lineattr colour=\"Black\" thick=\"0\" type=\"Solid\"/>");
        out.println("          <textattr colour=\"Black\" bold=\"false\"/>");
        out.println("          <text tool=\"CPN Tools\" version=\"4.0.1\"/>");
        out.println("        </code>");

        out.println("        <priority id=\"" + nextCpnId() + "\">");
        out.println("          <posattr x=\"" + String.format(Locale.US, "%.6f", x - 65.0) + "\" y=\""
                + String.format(Locale.US, "%.6f", y - 30.0) + "\"/>");
        out.println("          <fillattr colour=\"White\" pattern=\"Solid\" filled=\"false\"/>");
        out.println("          <lineattr colour=\"Black\" thick=\"0\" type=\"Solid\"/>");
        out.println("          <textattr colour=\"Black\" bold=\"false\"/>");
        out.println("          <text tool=\"CPN Tools\" version=\"4.0.1\"/>");
        out.println("        </priority>");

        out.println("      </trans>");
    }

    private void escreverArcoXML(
            PrintWriter out,
            Arco a,
            String xmlArcId,
            Map<String, String> mapaIdsXML,
            Set<String> idsLugares,
            Map<String, double[]> posicoes,
            int order) {

        boolean sourceEhLugar = idsLugares.contains(a.getSourceId());
        String orientation = sourceEhLugar ? "PtoT" : "TtoP";
        String placeOrigId = sourceEhLugar ? a.getSourceId() : a.getTargetId();
        String transOrigId = sourceEhLugar ? a.getTargetId() : a.getSourceId();

        String placeXmlId = mapaIdsXML.get(placeOrigId);
        String transXmlId = mapaIdsXML.get(transOrigId);

        double[] posP = posicoes.getOrDefault(placeOrigId, new double[] { 0.0, 0.0 });
        double[] posT = posicoes.getOrDefault(transOrigId, new double[] { 0.0, 0.0 });
        double midX = (posP[0] + posT[0]) / 2.0;
        double midY = (posP[1] + posT[1]) / 2.0 + (sourceEhLugar ? 14.0 : -14.0);

        out.println("      <arc id=\"" + xmlArcId + "\" orientation=\"" + orientation + "\" order=\"" + order + "\">");
        out.println("        <posattr x=\"0.000000\" y=\"0.000000\"/>");
        out.println("        <fillattr colour=\"White\" pattern=\"\" filled=\"false\"/>");
        out.println("        <lineattr colour=\"Black\" thick=\"1\" type=\"Solid\"/>");
        out.println("        <textattr colour=\"Black\" bold=\"false\"/>");
        out.println("        <arrowattr headsize=\"1.200000\" currentcyckle=\"2\"/>");
        out.println("        <transend idref=\"" + transXmlId + "\"/>");
        out.println("        <placeend idref=\"" + placeXmlId + "\"/>");
        out.println("        <annot id=\"" + nextCpnId() + "\">");
        out.println("          <posattr x=\"" + String.format(Locale.US, "%.6f", midX) + "\" y=\""
                + String.format(Locale.US, "%.6f", midY) + "\"/>");
        out.println("          <fillattr colour=\"White\" pattern=\"Solid\" filled=\"false\"/>");
        out.println("          <lineattr colour=\"Black\" thick=\"0\" type=\"Solid\"/>");
        out.println("          <textattr colour=\"Black\" bold=\"false\"/>");
        out.println(
                "          <text tool=\"CPN Tools\" version=\"4.0.1\">" + escaparXML(a.getExpression()) + "</text>");
        out.println("        </annot>");
        out.println("      </arc>");
    }

    private void escreverOptionsPadrao(PrintWriter out) {
        out.println("    <options>");
        String[][] opcoes = {
                { "realtimestamp", "false" }, { "fair_be", "false" }, { "global_fairness", "false" },
                { "extensions.10001.enable", "true" }, { "extensions.10006.enable", "true" },
                { "extensions.10003.enable", "true" }, { "extensions.10005.enable", "true" },
                { "extensions.10002.enable", "true" }, { "repavg", "true" }, { "repciavg", "true" },
                { "repcount", "false" }, { "repfirstval", "false" }, { "replastval", "false" },
                { "repmax", "true" }, { "repmin", "true" }, { "repssquare", "false" },
                { "repssqdev", "false" }, { "repstddev", "true" }, { "repsum", "false" },
                { "repvariance", "false" }, { "avg", "true" }, { "ciavg", "false" },
                { "count", "true" }, { "firstval", "false" }, { "lastval", "false" },
                { "max", "true" }, { "min", "true" }, { "ssquare", "false" }, { "ssqdev", "false" },
                { "stddev", "false" }, { "sum", "false" }, { "variance", "false" },
                { "firstupdate", "false" }, { "interval", "false" }, { "lastupdate", "false" },
                { "untimedavg", "true" }, { "untimedciavg", "false" }, { "untimedcount", "true" },
                { "untimedfirstval", "false" }, { "untimedlastval", "false" }, { "untimedmax", "true" },
                { "untimedmin", "true" }, { "untimedssquare", "false" }, { "untimedssqdev", "false" },
                { "untimedstddev", "false" }, { "untimedsum", "true" }, { "untimedvariance", "false" }
        };
        for (String[] op : opcoes) {
            out.println("      <option name=\"" + op[0] + "\">");
            out.println("        <value><boolean>" + op[1] + "</boolean></value>");
            out.println("      </option>");
        }
        out.println("      <option name=\"outputdirectory\">");
        out.println("        <value><text>&lt;same as model&gt;</text></value>");
        out.println("      </option>");
        out.println("    </options>");
    }

    private Map<String, double[]> calcularPosicoes(List<Lugar> lugares, List<Transicao> transicoes) {
        Map<String, double[]> mapa = new HashMap<>();
        int i = 0;
        for (Lugar l : lugares) {
            double x = -320.0 + (i % 3) * 300.0;
            double y = 240.0 - (i / 3) * 190.0;
            mapa.put(l.getId(), new double[] { x, y });
            i++;
        }
        int j = 0;
        for (Transicao t : transicoes) {
            double x = -170.0 + (j % 3) * 300.0;
            double y = 140.0 - (j / 3) * 190.0;
            mapa.put(t.getId(), new double[] { x, y });
            j++;
        }
        return mapa;
    }

    private String escaparXML(String s) {
        if (s == null)
            return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}