package RoboBasic;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Implementation {
    public static void main(String[] args) throws Exception {
        SyntaxAnalysisLexer lexer = new SyntaxAnalysisLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SyntaxAnalysisParser parser = new SyntaxAnalysisParser(tokens);
    }
}