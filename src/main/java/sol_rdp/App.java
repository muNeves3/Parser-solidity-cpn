package sol_rdp;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import sol_rdp.antlr.SolidityLexer;
import sol_rdp.antlr.SolidityParser;
import sol_rdp.rpc.RPCBuilder;
import sol_rdp.solidity.ListasInfo;
import sol_rdp.utils.ExportadorCPN;
import sol_rdp.utils.InjetorCenario;
import sol_rdp.visitor.SolidityVisitor;

import java.io.File;

public class App {
    public static void main(String[] args) {
        String caminhoContrato = args.length > 0 ? args[0] : "exemplos/Eleicao.sol";
        String caminhoSaidaCpn = args.length > 1 ? args[1] : "saida/contrato_modelo.cpn";
        String caminhoScenario = args.length > 2 ? args[2] : "saida/scenario.json";

        try {
            // Fase 1: Análise Sintática e Semântica
            CharStream input = CharStreams.fromFileName(caminhoContrato);
            SolidityLexer lexer = new SolidityLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SolidityParser parser = new SolidityParser(tokens);
            ParseTree tree = parser.sourceUnit();

            SolidityVisitor visitor = new SolidityVisitor();
            ListasInfo info = (ListasInfo) visitor.visit(tree);

            // Fase 2: Construção da RPC
            RPCBuilder builder = new RPCBuilder();
            builder.construirRPC(info);

            // Etapa 2 do Pipeline: Injeção automática das marcas temporizadas (@1, @2...)
            File arquivoScenario = new File(caminhoScenario);
            if (arquivoScenario.exists()) {
                InjetorCenario.aplicarCenario(arquivoScenario.getPath(), builder, info);
            }

            builder.exibirResultados();

            // Exportação para XML do CPN Tools (ativa 'timed' automaticamente se houver @t)
            ExportadorCPN exportador = new ExportadorCPN();
            exportador.exportar(builder, info, caminhoSaidaCpn);
            System.out.println("Arquivo CPN exportado com sucesso em: " + caminhoSaidaCpn);

        } catch (Exception e) {
            System.err.println("Erro durante execucao: " + e.getMessage());
            e.printStackTrace();
        }
    }
}