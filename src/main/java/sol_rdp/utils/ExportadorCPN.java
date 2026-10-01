package sol_rdp.utils;

import sol_rdp.cpn.Arco;
import sol_rdp.cpn.Lugar;
import sol_rdp.cpn.Transicao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportadorCPN {

    // Layout
    private static final double X_INICIAL = -400.0;
    private static final double DX = 220.0;
    private static final double Y_ESTADO = 100.0;
    private static final double Y_TRANSICAO = -50.0;
    private static final double Y_PARAM = -200.0;

    private static final Set<String> RESERVADAS = new HashSet<>(Arrays.asList(
            "true", "false", "andalso", "orelse", "not", "if", "then", "else",
            "empty", "NULL", "div", "mod"));

    // identificador que não faz parte de número nem de nome qualificado
    private static final Pattern IDENT = Pattern.compile("(?<![\\w.])[A-Za-z_]\\w*");

    private final List<String> avisos = new ArrayList<>();

    public List<String> getAvisos() {
        return Collections.unmodifiableList(avisos);
    }

    /**
     * Arco já com as pontas resolvidas (lugar / transição) e a direção definida.
     */
    private static class ArcoResolvido {
        final Arco arco;
        final String lugarId;
        final String transId;
        final boolean lugarParaTrans;

        ArcoResolvido(Arco arco, String lugarId, String transId, boolean lugarParaTrans) {
            this.arco = arco;
            this.lugarId = lugarId;
            this.transId = transId;
            this.lugarParaTrans = lugarParaTrans;
        }
    }

    public void exportar(List<Lugar> lugares, List<Transicao> transicoes, List<Arco> arcos, String caminhoArquivo) {
        avisos.clear();
        try {
            // ==========================================
            // 0. INDEXAÇÃO E RESOLUÇÃO DOS ARCOS
            // (Arco guarda IDs como "lugar_var_0"/"trans_9"; o código antigo
            // procurava por NOME e descartava todos os arcos silenciosamente)
            // ==========================================
            Map<String, Lugar> lugarPorId = new LinkedHashMap<>();
            Map<String, Transicao> transPorId = new LinkedHashMap<>();
            Map<String, String> nomeParaId = new HashMap<>();

            for (Lugar l : lugares) {
                lugarPorId.put(l.getId().trim(), l);
                nomeParaId.putIfAbsent(l.getName().trim(), l.getId().trim());
            }
            for (Transicao t : transicoes) {
                transPorId.put(t.getId().trim(), t);
                nomeParaId.putIfAbsent(t.getName().trim(), t.getId().trim());
            }

            Function<String, String> resolver = ref -> {
                if (ref == null)
                    return null;
                String r = ref.trim();
                if (lugarPorId.containsKey(r) || transPorId.containsKey(r))
                    return r;
                return nomeParaId.get(r); // fallback: referência por nome
            };

            List<ArcoResolvido> resolvidos = new ArrayList<>();
            for (Arco arco : arcos) {
                String src = resolver.apply(arco.getSourceId());
                String tgt = resolver.apply(arco.getTargetId());
                if (src == null || tgt == null) {
                    avisos.add("Arco " + arco.getId() + " ignorado: extremidade não encontrada (source='"
                            + arco.getSourceId() + "', target='" + arco.getTargetId() + "').");
                    continue;
                }
                boolean srcLugar = lugarPorId.containsKey(src);
                boolean tgtLugar = lugarPorId.containsKey(tgt);
                if (srcLugar == tgtLugar) {
                    avisos.add("Arco " + arco.getId() + " ignorado: liga dois "
                            + (srcLugar ? "lugares" : "transições") + " (" + src + " -> " + tgt + ").");
                    continue;
                }
                resolvidos.add(srcLugar
                        ? new ArcoResolvido(arco, src, tgt, true)
                        : new ArcoResolvido(arco, tgt, src, false));
            }

            // ==========================================
            // 1. INFERÊNCIA DE VARIÁVEIS + DIAGNÓSTICOS
            // ==========================================
            Map<String, String> tipoVar = new LinkedHashMap<>();
            inferirVariaveis(resolvidos, lugarPorId, tipoVar, true); // entradas primeiro: são elas que ligam variáveis
            inferirVariaveis(resolvidos, lugarPorId, tipoVar, false);
            diagnosticarVariaveis(transicoes, resolvidos, tipoVar);

            // ==========================================
            // 2. DOCUMENTO
            // ==========================================
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element workspace = doc.createElement("workspaceElements");
            doc.appendChild(workspace);

            Element generator = doc.createElement("generator");
            generator.setAttribute("tool", "CPN Tools");
            generator.setAttribute("version", "4.0.1");
            generator.setAttribute("format", "6");
            workspace.appendChild(generator);

            Element cpnet = doc.createElement("cpnet");
            workspace.appendChild(cpnet);

            Element globbox = doc.createElement("globbox");
            gerarDeclaracoesGlobaisSML(doc, globbox, lugares, tipoVar);
            cpnet.appendChild(globbox);

            String pageId = gerarId();
            Element page = doc.createElement("page");
            page.setAttribute("id", pageId);
            Element pageAttr = doc.createElement("pageattr");
            pageAttr.setAttribute("name", "Rede_Solidity");
            page.appendChild(pageAttr);
            cpnet.appendChild(page);

            // ==========================================
            // 3. LAYOUT
            // estado: linha y=100 | transições: y=-50 | parâmetros: acima da sua transição
            // ==========================================
            Map<String, double[]> pos = new HashMap<>();
            int i = 0;
            for (Lugar l : lugares) {
                if (!isParametro(l))
                    pos.put(l.getId().trim(), new double[] { X_INICIAL + DX * i++, Y_ESTADO });
            }
            i = 0;
            for (Transicao t : transicoes) {
                pos.put(t.getId().trim(), new double[] { X_INICIAL + DX * i++, Y_TRANSICAO });
            }
            Map<String, Integer> usosPorTrans = new HashMap<>();
            int soltos = 0;
            for (Lugar l : lugares) {
                if (!isParametro(l))
                    continue;
                String id = l.getId().trim();
                String alvo = null;
                for (ArcoResolvido a : resolvidos) {
                    if (a.lugarParaTrans && a.lugarId.equals(id)) {
                        alvo = a.transId;
                        break;
                    }
                }
                if (alvo != null) {
                    int n = usosPorTrans.merge(alvo, 1, Integer::sum) - 1;
                    pos.put(id, new double[] { pos.get(alvo)[0] + 160.0 * n, Y_PARAM });
                } else {
                    pos.put(id, new double[] { X_INICIAL + DX * soltos++, Y_PARAM - 150.0 });
                }
            }

            Map<String, String> xmlId = new HashMap<>(); // id lógico -> id do XML

            // ==========================================
            // 4. LUGARES
            // ==========================================
            for (Lugar lugar : lugares) {
                String lid = lugar.getId().trim();
                double[] p = pos.get(lid);
                double xPos = p[0], yPos = p[1];

                Element place = doc.createElement("place");
                String placeId = gerarId();
                place.setAttribute("id", placeId);
                xmlId.put(lid, placeId);

                place.appendChild(createPosattr(doc, xPos, yPos));
                appendStandardVisuals(doc, place);
                place.appendChild(createTextElement(doc, lugar.getName()));

                Element ellipse = doc.createElement("ellipse");
                ellipse.setAttribute("w", "140.0");
                ellipse.setAttribute("h", "60.0");
                place.appendChild(ellipse);

                Element token = doc.createElement("token");
                token.setAttribute("x", "-10.0");
                token.setAttribute("y", "0.0");
                place.appendChild(token);

                Element marking = doc.createElement("marking");
                marking.setAttribute("x", "0.0");
                marking.setAttribute("y", "0.0");
                marking.setAttribute("hidden", "false");
                place.appendChild(marking);

                if (lugar.getColorSet() != null && !lugar.getColorSet().isEmpty()) {
                    Element type = doc.createElement("type");
                    type.setAttribute("id", gerarId());
                    type.appendChild(createPosattr(doc, xPos + 40, yPos - 35));
                    appendStandardVisuals(doc, type);
                    type.appendChild(createTextElement(doc, lugar.getColorSet()));
                    place.appendChild(type);
                }

                String initM = lugar.getInitialMarking();
                if (initM != null && !initM.trim().isEmpty() && !initM.trim().equalsIgnoreCase("empty")) {
                    Element initmark = doc.createElement("initmark");
                    initmark.setAttribute("id", gerarId());
                    initmark.appendChild(createPosattr(doc, xPos + 40, yPos + 35));
                    appendStandardVisuals(doc, initmark);
                    initmark.appendChild(createTextElement(doc, converterMarcacaoInicial(initM)));
                    place.appendChild(initmark);
                }

                page.appendChild(place);
            }

            // ==========================================
            // 5. TRANSIÇÕES
            // ==========================================
            for (Transicao transicao : transicoes) {
                String tid = transicao.getId().trim();
                double[] p = pos.get(tid);
                double xPos = p[0], yPos = p[1];

                Element trans = doc.createElement("trans");
                String transId = gerarId();
                trans.setAttribute("id", transId);
                trans.setAttribute("explicit", "false");
                xmlId.put(tid, transId);

                trans.appendChild(createPosattr(doc, xPos, yPos));
                appendStandardVisuals(doc, trans);
                trans.appendChild(createTextElement(doc, transicao.getName()));

                Element box = doc.createElement("box");
                box.setAttribute("w", "120.0");
                box.setAttribute("h", "45.0");
                trans.appendChild(box);

                Element binding = doc.createElement("binding");
                binding.setAttribute("x", "7.2");
                binding.setAttribute("y", "-3.0");
                trans.appendChild(binding);

                if (transicao.getGuard() != null && !transicao.getGuard().trim().isEmpty()) {
                    Element cond = doc.createElement("cond");
                    cond.setAttribute("id", gerarId());
                    cond.appendChild(createPosattr(doc, xPos - 50, yPos + 35));
                    appendStandardVisuals(doc, cond);
                    cond.appendChild(
                            createTextElement(doc, "[" + traduzirOperadores(transicao.getGuard().trim()) + "]"));
                    trans.appendChild(cond);
                }

                trans.appendChild(createEmptyBlock(doc, "time", xPos, yPos));
                trans.appendChild(createEmptyBlock(doc, "code", xPos, yPos));
                trans.appendChild(createEmptyBlock(doc, "priority", xPos, yPos));

                page.appendChild(trans);
            }

            // ==========================================
            // 6. ARCOS
            // ==========================================
            for (ArcoResolvido ar : resolvidos) {
                Arco arco = ar.arco;

                Element arc = doc.createElement("arc");
                arc.setAttribute("id", gerarId());
                arc.setAttribute("order", "1");
                // O DTD do CPN Tools exige MAIÚSCULAS: PTOT / TTOP / BOTHDIR
                arc.setAttribute("orientation", ar.lugarParaTrans ? "PTOT" : "TTOP");

                arc.appendChild(createPosattr(doc, 0, 0));
                appendStandardVisuals(doc, arc);

                Element arrowattr = doc.createElement("arrowattr");
                arrowattr.setAttribute("headsize", "1.200000");
                arrowattr.setAttribute("currentcyckle", "2");
                arc.appendChild(arrowattr);

                Element transend = doc.createElement("transend");
                transend.setAttribute("idref", xmlId.get(ar.transId));
                arc.appendChild(transend);

                Element placeend = doc.createElement("placeend");
                placeend.setAttribute("idref", xmlId.get(ar.lugarId));
                arc.appendChild(placeend);

                if (arco.getExpression() != null && !arco.getExpression().trim().isEmpty()) {
                    double[] pl = pos.get(ar.lugarId);
                    double[] tr = pos.get(ar.transId);
                    // desloca para separar o arco de ida do arco de volta entre o mesmo par
                    double dx = ar.lugarParaTrans ? -20.0 : 20.0;
                    Element annot = doc.createElement("annot");
                    annot.setAttribute("id", gerarId());
                    annot.appendChild(createPosattr(doc, (pl[0] + tr[0]) / 2.0 + dx, (pl[1] + tr[1]) / 2.0));
                    appendStandardVisuals(doc, annot);
                    annot.appendChild(createTextElement(doc, converterParaSML(arco.getExpression())));
                    arc.appendChild(annot);
                }

                page.appendChild(arc);
            }

            // ==========================================
            // 7. INSTÂNCIAS
            // ==========================================
            String instanceId = gerarId();
            Element instances = doc.createElement("instances");
            Element instance = doc.createElement("instance");
            instance.setAttribute("id", instanceId);
            instance.setAttribute("page", pageId);
            instances.appendChild(instance);
            cpnet.appendChild(instances);

            Element binders = doc.createElement("binders");
            Element cpnbinder = doc.createElement("cpnbinder");
            cpnbinder.setAttribute("id", gerarId());
            cpnbinder.setAttribute("x", "100");
            cpnbinder.setAttribute("y", "100");
            cpnbinder.setAttribute("width", "1000");
            cpnbinder.setAttribute("height", "700");

            Element sheets = doc.createElement("sheets");
            Element cpnsheet = doc.createElement("cpnsheet");
            cpnsheet.setAttribute("id", gerarId());
            cpnsheet.setAttribute("panx", "450.0");
            cpnsheet.setAttribute("pany", "200.0");
            cpnsheet.setAttribute("zoom", "1.0");
            cpnsheet.setAttribute("instance", instanceId);

            Element zorder1 = doc.createElement("zorder");
            Element position1 = doc.createElement("position");
            position1.setAttribute("value", "0");
            zorder1.appendChild(position1);
            cpnsheet.appendChild(zorder1);

            sheets.appendChild(cpnsheet);
            cpnbinder.appendChild(sheets);

            Element zorder2 = doc.createElement("zorder");
            Element position2 = doc.createElement("position");
            position2.setAttribute("value", "0");
            zorder2.appendChild(position2);
            cpnbinder.appendChild(zorder2);

            binders.appendChild(cpnbinder);
            cpnet.appendChild(binders);

            // ==========================================
            // 8. SALVAR
            // ==========================================
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//CPN//DTD CPNXML 1.0//EN");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://cpntools.org/DTD/6/cpn.dtd");

            File arquivoDestino = new File(caminhoArquivo);
            if (arquivoDestino.getParentFile() != null) {
                arquivoDestino.getParentFile().mkdirs();
            }

            transformer.transform(new DOMSource(doc), new StreamResult(arquivoDestino));

            System.out.println("[SUCESSO] Arquivo .cpn exportado para: " + arquivoDestino.getAbsolutePath());
            System.out.println("          " + lugares.size() + " lugares, " + transicoes.size() + " transições, "
                    + resolvidos.size() + "/" + arcos.size() + " arcos.");
            for (String a : avisos) {
                System.err.println("[AVISO] " + a);
            }

        } catch (Exception e) {
            System.err.println("[ERRO] Falha ao exportar XML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ==========================================
    // INFERÊNCIA E DIAGNÓSTICO DE VARIÁVEIS
    // ==========================================

    private boolean isParametro(Lugar l) {
        return l.isOracle() || (l.getName() != null && l.getName().trim().startsWith("par-"));
    }

    /**
     * Deduz o tipo de cada variável pela posição que ela ocupa na tupla do arco
     * e pelo colset do lugar ligado. Ex.: arco (C, E) em CLIENTExUINT => C:CLIENTE,
     * E:UINT.
     */
    private void inferirVariaveis(List<ArcoResolvido> arcos, Map<String, Lugar> lugarPorId,
            Map<String, String> tipoVar, boolean entradas) {
        for (ArcoResolvido ar : arcos) {
            if (ar.lugarParaTrans != entradas)
                continue;
            Lugar lugar = lugarPorId.get(ar.lugarId);
            String cs = lugar.getColorSet() == null ? "" : lugar.getColorSet().trim();
            if (cs.isEmpty() || ar.arco.getExpression() == null)
                continue;
            List<String> tipos = Arrays.asList(cs.split("x"));

            for (String resultado : resultadosDaExpressao(ar.arco.getExpression())) {
                List<String> comps = componentes(resultado);
                if (comps.size() == tipos.size()) {
                    for (int k = 0; k < comps.size(); k++) {
                        for (String v : identificadores(comps.get(k))) {
                            registrarTipo(tipoVar, v, tipos.get(k).trim(), ar.arco.getId());
                        }
                    }
                } else if (comps.size() == 1 && comps.get(0).matches("[A-Za-z_]\\w*")
                        && !RESERVADAS.contains(comps.get(0))) {
                    registrarTipo(tipoVar, comps.get(0), cs, ar.arco.getId()); // variável do colset inteiro
                } else {
                    avisos.add("Arco " + ar.arco.getId() + ": expressão '" + resultado + "' não casa com o colset "
                            + cs + " do lugar '" + lugar.getName() + "'.");
                }
            }
        }
    }

    private void registrarTipo(Map<String, String> tipoVar, String var, String tipo, String arcoId) {
        String atual = tipoVar.get(var);
        if (atual == null) {
            tipoVar.put(var, tipo);
        } else if (!atual.equals(tipo)) {
            avisos.add("Conflito de tipo da variável '" + var + "' no arco " + arcoId + ": declarada como " + atual
                    + ", mas usada aqui como " + tipo + ". O CPN Tools não aceita a mesma variável com dois tipos.");
        }
    }

    /**
     * Avisa de variáveis que o CPN Tools não conseguirá ligar ("Cannot bind X from
     * large color-set").
     */
    private void diagnosticarVariaveis(List<Transicao> transicoes, List<ArcoResolvido> arcos,
            Map<String, String> tipoVar) {
        for (Transicao t : transicoes) {
            String tid = t.getId().trim();
            Set<String> ligadas = new LinkedHashSet<>();
            Set<String> usadas = new LinkedHashSet<>();

            for (ArcoResolvido ar : arcos) {
                if (!ar.transId.equals(tid) || ar.arco.getExpression() == null)
                    continue;
                if (ar.lugarParaTrans) {
                    ligadas.addAll(identificadores(ar.arco.getExpression()));
                } else {
                    usadas.addAll(identificadores(ar.arco.getExpression()));
                }
            }
            if (t.getGuard() != null)
                usadas.addAll(identificadores(t.getGuard()));

            usadas.removeAll(ligadas);
            if (!usadas.isEmpty()) {
                avisos.add("Transição '" + t.getName() + "': variáveis " + usadas
                        + " são usadas em arco de saída/guarda mas não são ligadas por nenhum arco de ENTRADA."
                        + " O CPN Tools dará 'Cannot bind ... from large color-set'. Isso vem da tradução"
                        + " Solidity->CPN (parâmetro/variável sem origem), não do exportador.");
            }
        }
    }

    // ==========================================
    // TRADUÇÃO DE EXPRESSÕES PARA SML
    // ==========================================

    /** Operadores do formato intermediário/Solidity -> SML. */
    private String traduzirOperadores(String s) {
        s = s.replaceAll("\\bAND\\b", "andalso").replaceAll("\\bOR\\b", "orelse");
        s = s.replace("&&", " andalso ").replace("||", " orelse ");
        s = s.replace("!=", "<>").replace("==", "=");
        s = s.replace("!", "not ");
        return s;
    }

    /**
     * Converte a inscrição de um arco ("c1 -> r1; c2 -> r2", "(C, E)", "A", ...) em
     * SML.
     */
    private String converterParaSML(String expr) {
        if (expr == null || expr.trim().isEmpty())
            return "";
        String e = traduzirOperadores(expr.trim());

        if (e.contains("->")) {
            StringBuilder sb = new StringBuilder();
            for (String clausula : splitTopLevel(e, ';')) {
                int idx = clausula.indexOf("->");
                if (idx < 0)
                    continue;
                String cond = clausula.substring(0, idx).trim();
                String res = clausula.substring(idx + 2).trim();
                String r = res.equals("NULL") ? "empty" : comoMultiset(res);
                sb.append("if (").append(cond).append(") then ").append(r).append(" else ");
            }
            sb.append("empty");
            return sb.toString();
        }
        return comoMultiset(e);
    }

    private String comoMultiset(String r) {
        r = r.trim();
        if (r.equals("empty") || r.contains("`"))
            return r;
        return "1`" + r;
    }

    /**
     * Marcação inicial: constantes apenas. Identificadores soltos (ex.: ext_data,
     * que é variável no Solidity/oráculo) viram strings literais.
     */
    private String converterMarcacaoInicial(String marcacao) {
        List<String> termos = new ArrayList<>();
        for (String termo : marcacao.trim().split("\\+\\+")) {
            termo = termo.trim();
            String prefixo = "1`";
            String corpo = termo;
            Matcher m = Pattern.compile("^(\\d+)\\s*`(.*)$", Pattern.DOTALL).matcher(termo);
            if (m.matches()) {
                prefixo = m.group(1) + "`";
                corpo = m.group(2).trim();
            }
            termos.add(prefixo + citarIdentificadores(corpo));
        }
        return String.join(" ++ ", termos);
    }

    private String citarIdentificadores(String corpo) {
        Matcher m = Pattern.compile("\"[^\"]*\"|(?<![\\w.])[A-Za-z_]\\w*").matcher(corpo);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String tok = m.group();
            String sub = (tok.startsWith("\"") || RESERVADAS.contains(tok)) ? tok : "\"" + tok + "\"";
            m.appendReplacement(sb, Matcher.quoteReplacement(sub));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    // ==========================================
    // PARSING AUXILIAR DE EXPRESSÕES
    // ==========================================

    /**
     * Lado direito de cada cláusula "cond -> resultado" (ignora NULL), ou a própria
     * expressão.
     */
    private List<String> resultadosDaExpressao(String expr) {
        List<String> out = new ArrayList<>();
        if (expr.contains("->")) {
            for (String clausula : splitTopLevel(expr, ';')) {
                int idx = clausula.indexOf("->");
                if (idx < 0)
                    continue;
                String res = clausula.substring(idx + 2).trim();
                if (!res.equals("NULL"))
                    out.add(res);
            }
        } else {
            out.add(expr.trim());
        }
        return out;
    }

    /** "(C, E-1)" -> ["C", "E-1"]; "A" -> ["A"]. Remove prefixo "n`" se houver. */
    private List<String> componentes(String resultado) {
        String s = resultado.trim();
        int bt = s.indexOf('`');
        if (bt >= 0 && s.substring(0, bt).trim().matches("\\d+"))
            s = s.substring(bt + 1).trim();
        if (s.startsWith("(") && s.endsWith(")") && parentesesExternos(s)) {
            List<String> out = new ArrayList<>();
            for (String c : splitTopLevel(s.substring(1, s.length() - 1), ','))
                out.add(c.trim());
            return out;
        }
        return Collections.singletonList(s);
    }

    /** O primeiro '(' fecha exatamente no último ')'? */
    private boolean parentesesExternos(String s) {
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                depth++;
            else if (c == ')') {
                depth--;
                if (depth == 0 && i < s.length() - 1)
                    return false;
            }
        }
        return depth == 0;
    }

    private List<String> splitTopLevel(String s, char sep) {
        List<String> out = new ArrayList<>();
        int depth = 0;
        boolean aspas = false;
        StringBuilder cur = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '"')
                aspas = !aspas;
            if (!aspas) {
                if (c == '(')
                    depth++;
                else if (c == ')')
                    depth--;
                else if (c == sep && depth == 0) {
                    out.add(cur.toString());
                    cur.setLength(0);
                    continue;
                }
            }
            cur.append(c);
        }
        out.add(cur.toString());
        return out;
    }

    private Set<String> identificadores(String s) {
        Set<String> out = new LinkedHashSet<>();
        String limpo = s.replaceAll("\"[^\"]*\"", "\"\"").replaceAll("\\b(AND|OR)\\b", " ");
        Matcher m = IDENT.matcher(limpo);
        while (m.find()) {
            if (!RESERVADAS.contains(m.group()))
                out.add(m.group());
        }
        return out;
    }

    // ==========================================
    // DECLARAÇÕES GLOBAIS
    // ==========================================

    private void gerarDeclaracoesGlobaisSML(Document doc, Element globbox, List<Lugar> lugares,
            Map<String, String> tipoVar) {
        Element block = doc.createElement("block");
        block.setAttribute("id", gerarId());
        Element idEl = doc.createElement("id");
        idEl.setTextContent("Declaracoes_Solidity");
        block.appendChild(idEl);

        // Descobre os colsets a partir dos lugares: bases primeiro, produtos depois
        Set<String> bases = new LinkedHashSet<>();
        Set<String> produtos = new LinkedHashSet<>();
        for (Lugar l : lugares) {
            String cs = l.getColorSet() == null ? "" : l.getColorSet().trim();
            if (cs.isEmpty())
                continue;
            if (cs.contains("x")) {
                produtos.add(cs);
                bases.addAll(Arrays.asList(cs.split("x")));
            } else {
                bases.add(cs);
            }
        }

        for (String b : bases) {
            String base = tipoBase(b);
            adicionarColor(doc, block, b, base, "colset " + b + " = " + base + ";");
        }
        for (String p : produtos) {
            adicionarProductColor(doc, block, p, p.split("x"));
        }

        // Variáveis agrupadas por tipo, com os tipos inferidos dos arcos
        Map<String, List<String>> porTipo = new LinkedHashMap<>();
        for (Map.Entry<String, String> e : tipoVar.entrySet()) {
            porTipo.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        }
        for (Map.Entry<String, List<String>> e : porTipo.entrySet()) {
            adicionarVar(doc, block, e.getKey(), e.getValue().toArray(new String[0]));
        }

        globbox.appendChild(block);
    }

    private String tipoBase(String nome) {
        String n = nome.toUpperCase();
        if (n.matches("U?INT\\d*"))
            return "int";
        if (n.equals("BOOL"))
            return "bool";
        return "string";
    }

    private void adicionarColor(Document doc, Element block, String nome, String tagBase, String layoutText) {
        Element color = doc.createElement("color");
        color.setAttribute("id", gerarId());
        Element idEl = doc.createElement("id");
        idEl.setTextContent(nome);
        color.appendChild(idEl);

        color.appendChild(doc.createElement(tagBase));

        Element layout = doc.createElement("layout");
        layout.setTextContent(layoutText);
        color.appendChild(layout);

        block.appendChild(color);
    }

    private void adicionarProductColor(Document doc, Element block, String nome, String[] componentes) {
        Element color = doc.createElement("color");
        color.setAttribute("id", gerarId());
        Element idEl = doc.createElement("id");
        idEl.setTextContent(nome);
        color.appendChild(idEl);

        Element product = doc.createElement("product");
        for (String c : componentes) {
            Element id = doc.createElement("id");
            id.setTextContent(c);
            product.appendChild(id);
        }
        color.appendChild(product);

        Element layout = doc.createElement("layout");
        layout.setTextContent("colset " + nome + " = product " + String.join(" * ", componentes) + ";");
        color.appendChild(layout);

        block.appendChild(color);
    }

    private void adicionarVar(Document doc, Element block, String tipo, String... nomes) {
        Element var = doc.createElement("var");
        var.setAttribute("id", gerarId());

        Element type = doc.createElement("type");
        Element typeId = doc.createElement("id");
        typeId.setTextContent(tipo);
        type.appendChild(typeId);
        var.appendChild(type);

        for (String n : nomes) {
            Element idEl = doc.createElement("id");
            idEl.setTextContent(n);
            var.appendChild(idEl);
        }

        Element layout = doc.createElement("layout");
        layout.setTextContent("var " + String.join(", ", nomes) + ": " + tipo + ";");
        var.appendChild(layout);

        block.appendChild(var);
    }

    // ==========================================
    // AUXILIARES XML
    // ==========================================

    private String gerarId() {
        return "ID" + UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    private Element createPosattr(Document doc, double x, double y) {
        Element pos = doc.createElement("posattr");
        pos.setAttribute("x", String.valueOf(x));
        pos.setAttribute("y", String.valueOf(y));
        return pos;
    }

    private Element createTextElement(Document doc, String content) {
        Element text = doc.createElement("text");
        text.setTextContent(content);
        return text;
    }

    private void appendStandardVisuals(Document doc, Element parent) {
        Element fillattr = doc.createElement("fillattr");
        fillattr.setAttribute("colour", "White");
        fillattr.setAttribute("pattern", "");
        fillattr.setAttribute("filled", "false");
        parent.appendChild(fillattr);

        Element lineattr = doc.createElement("lineattr");
        lineattr.setAttribute("colour", "Black");
        lineattr.setAttribute("thick", "1");
        lineattr.setAttribute("type", "Solid");
        parent.appendChild(lineattr);

        Element textattr = doc.createElement("textattr");
        textattr.setAttribute("colour", "Black");
        textattr.setAttribute("bold", "false");
        parent.appendChild(textattr);
    }

    private Element createEmptyBlock(Document doc, String tagName, double xPos, double yPos) {
        Element el = doc.createElement(tagName);
        el.setAttribute("id", gerarId());
        el.appendChild(createPosattr(doc, xPos + 50, yPos + 50));
        appendStandardVisuals(doc, el);
        Element text = doc.createElement("text");
        text.setAttribute("tool", "CPN Tools");
        text.setAttribute("version", "4.0.1");
        el.appendChild(text);
        return el;
    }
}