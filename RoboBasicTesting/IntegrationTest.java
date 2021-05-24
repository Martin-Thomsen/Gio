package RoboBasicTesting;

import RoboBasic.*;
import RoboBasicGen.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.ldap.Control;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IntegrationTest {
    ParseTree getParseTree(String input) {
        CharStream stream = CharStreams.fromString(input);
        SyntaxAnalysisLexer lexer = new SyntaxAnalysisLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SyntaxAnalysisParser parser = new SyntaxAnalysisParser(tokens);
        return parser.prog();
    }

    @Test
    public void FuncCollectShouldProduceEnvironment() {
        // ARRANGE
        ParseTree tree = getParseTree("function void run() endFunction");
        FuncCollect funcCollect = new FuncCollect();
        funcCollect.visit(tree);

        // ASSERT
        for(Map.Entry func : funcCollect.getEnvironment().entrySet()) {
            Assert.assertTrue(func.getKey() instanceof String);
            Assert.assertTrue(func.getValue() instanceof SyntaxAnalysisFuncType);
        }
    }

    @Test
    public void FuncCollectShouldProduceErrorList() {
        // ARRANGE
        ParseTree tree = getParseTree("function void run() endFunction function void run() endFunction");
        FuncCollect funcCollect = new FuncCollect();
        funcCollect.visit(tree);

        // ACT
        List<String> errorList = funcCollect.getErrors();

        // ASSERT
        Assert.assertTrue(funcCollect.getErrors() != null);
        Assert.assertTrue(errorList.size() > 0);
    }
}
