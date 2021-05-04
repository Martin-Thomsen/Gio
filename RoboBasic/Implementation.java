package RoboBasic;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import RoboBasicGen.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Implementation {
    public static void main(String[] args) throws Exception {
        SyntaxAnalysisLexer lexer = new SyntaxAnalysisLexer(CharStreams.fromFileName("C:\\Users\\m-s-t\\Documents\\GitHub\\Gio\\Input.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SyntaxAnalysisParser parser = new SyntaxAnalysisParser(tokens);

        FuncCollect funcCollect = new FuncCollect();
        funcCollect.visit(parser.prog());

        parser.reset();
        EvalVisitor evalVisitor = new EvalVisitor(funcCollect.getEnvironment());
        evalVisitor.visit(parser.prog());

        parser.reset();
        TranslateVisitor translateVisitor = new TranslateVisitor();
        String output = translateVisitor.visit(parser.prog());

        //System.out.println(output);

        List<String> errors = evalVisitor.getErrors();

        File file = new File("C:\\Users\\m-s-t\\Documents\\GitHub\\Gio\\Errors.txt");
        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        writer.write("123");

        for(String error : errors) {
            System.out.println(error);
            writer.append(error);
        }
        writer.close();
    }
}