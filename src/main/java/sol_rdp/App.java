package sol_rdp;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import sol_rdp.antlr.SolidityLexer;
import sol_rdp.antlr.SolidityParser;
import sol_rdp.solidity.ListasInfo;
import sol_rdp.visitor.SolidityVisitor;
import sol_rdp.rpc.RPCBuilder;
import sol_rdp.cpn.Lugar;
import sol_rdp.cpn.Transicao;
import sol_rdp.cpn.Arco;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        if (args.length == 0) {
            System.err.println("Uso: java App <arquivo.sol>");
            System.exit(1);
        }

        try {
            CharStream input = CharStreams.fromFileName(args[0]);
            SolidityLexer lexer = new SolidityLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SolidityParser parser = new SolidityParser(tokens);
            ParseTree tree = parser.sourceUnit(); 

            System.out.println("\n========== FASE 1: ANÁLISE SINTÁTICA E SEMÂNTICA ==========");
            SolidityVisitor visitor = new SolidityVisitor();
            ListasInfo info = (ListasInfo) visitor.visit(tree);
            
            if (info != null) {
                info.exibirResumo();
                
                System.out.println("\n========== FASE 2: CONSTRUÇÃO DA RPC ==========");
                RPCBuilder builder = new RPCBuilder();
                builder.construirRPC(info);
                builder.exibirResultados();
            } else {
                System.err.println("Erro: Análise retornou null");
                System.exit(1);
            }
            
            System.out.println("\n========== ANÁLISE CONCLUÍDA COM SUCESSO ==========\n");
        } catch (Exception e) {
            System.err.println("Erro durante análise: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
