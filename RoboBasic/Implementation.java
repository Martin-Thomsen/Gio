package RoboBasic;
import org.antlr.v4.runtime.*;
import java.util.List;
import RoboBasicGen.*;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.naming.ldap.Control;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Implementation {
    public static void main(String[] args) throws Exception {
        SyntaxAnalysisLexer lexer = new SyntaxAnalysisLexer(CharStreams.fromFileName("C:\\Users\\m-s-t\\Documents\\GitHub\\Gio\\Input.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SyntaxAnalysisParser parser = new SyntaxAnalysisParser(tokens);
        ParseTree tree = parser.prog();

        FuncCollect funcCollect = new FuncCollect();
        funcCollect.visit(tree);

        EventCollect eventCollect = new EventCollect();
        eventCollect.CollectEvents();

        ControlsCollect controlsCollect = new ControlsCollect();
        controlsCollect.CollectControls();

        EvalVisitor evalVisitor = new EvalVisitor(funcCollect.getEnvironment(), eventCollect.getEnvironment(), controlsCollect, funcCollect.getErrors());
        evalVisitor.visit(tree);

        TranslateVisitor translateVisitor = new TranslateVisitor(eventCollect.getEnvironment(), controlsCollect);
        String output = translateVisitor.visit(tree);

        List<String> errors = evalVisitor.getErrors();

        File errorFile = new File("C:\\Users\\m-s-t\\Documents\\GitHub\\Gio\\Errors.txt");
        File outputFile = new File("C:\\Users\\m-s-t\\Documents\\GitHub\\Gio\\Output.txt");
        errorFile.createNewFile();
        outputFile.createNewFile();

        FileWriter errorWriter = new FileWriter(errorFile);
        FileWriter outputWriter = new FileWriter(outputFile);

        StringBuilder errorString = new StringBuilder();

        for(String error : errors) {
            errorString.append(error).append("\n");
        }

        errorWriter.write(errorString.toString());
        errorWriter.close();

        outputWriter.write(output);
        outputWriter.close();
    }
}