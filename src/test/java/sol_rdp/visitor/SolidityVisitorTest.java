package sol_rdp.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import sol_rdp.antlr.SolidityLexer;
import sol_rdp.antlr.SolidityParser;
import sol_rdp.solidity.ListasInfo;
import sol_rdp.solidity.VariavelGlobal;

public class SolidityVisitorTest {

    @Test
    public void shouldExtractMappingKeyTypeAsTipoIndiceForGlobalVariable() {
        String source = "pragma solidity ^0.8.0;\n"
                + "contract Test {\n"
                + "    mapping(uint8 => uint256) public balances;\n"
                + "}\n";

        SolidityParser parser = new SolidityParser(
                new CommonTokenStream(new SolidityLexer(CharStreams.fromString(source)))
        );
        ParseTree tree = parser.sourceUnit();

        ListasInfo info = (ListasInfo) new SolidityVisitor().visit(tree);
        assertNotNull(info);
        assertEquals(1, info.getVariaveisGlobais().size());

        VariavelGlobal variavel = info.getVariaveisGlobais().get(0);
        assertEquals("balances", variavel.getNome());
        assertEquals("mapping(uint8=>uint256)", variavel.getTipo());
        assertEquals("uint8", variavel.getTipoIndice());
    }
}
