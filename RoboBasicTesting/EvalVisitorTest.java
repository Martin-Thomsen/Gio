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

import static org.junit.Assert.*;

public class EvalVisitorTest {
    List<String> GetErrorsFromInput(String input) throws IOException {
        CharStream stream = CharStreams.fromString(input);
        SyntaxAnalysisLexer lexer = new SyntaxAnalysisLexer(stream);
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

        return evalVisitor.getErrors();
    }
    
    boolean CorrectInput(String input) throws IOException {
        return GetErrorsFromInput(input).size() == 0;
    }
    
    boolean WrongInput(String input) throws IOException {
        return GetErrorsFromInput(input).size() > 0;
    }

    @Test
    public void visitFunction() throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. endFunction";
        String wrongInput = "function run() num a = 0. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitWhen()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. endFunction when onHitByBullet() num b = heading. endWhen";
        String wrongInput = "function void run() num a = 0. endFunction when onHitByBullet() bool b = heading. endWhen";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitIf()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() if(true) do num a = 0. endIf endFunction";
        String wrongInput = "function void run() if(2) do num a = 0. endIf endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitRep()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() repeat(5) num a = 0. endRepeat endFunction";
        String wrongInput = "function void run() bool b = true. repeat(b) num a = 0. endRepeat endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitRep_if()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() repeatIf(true) num a = 0. endRepeatIf endFunction";
        String wrongInput = "function void run() num b = 0. repeatIf(b) num a = 0. endRepeatIf endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitRep_until()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() repeat num a = 0. until(true) endFunction";
        String wrongInput = "function void run() num b = 0. repeat num a = 0. until(b) endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitFunc_stmt()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = test(). endFunction function num test() num b = 0. return b. endFunction";
        String wrongInput = "function void run() num a = test(). endFunction function void test() num b = 0. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitVar_decl()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. endFunction";
        String wrongInput = "function void run() bool a = 0. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitAssign()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. a = 2. endFunction";
        String wrongInput = "function void run() num a = 0. a = true. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitIncr()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. a++. endFunction";
        String wrongInput = "function void run() bool a = true. a++. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitDecr()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. a--. endFunction";
        String wrongInput = "function void run() bool a = 0. a--. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitReturnStmt()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. endFunction function num test() return 2. endFunction";
        String wrongInput = "function void run() num a = 0. endFunction function num test() endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitPre_incr()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. ++a. endFunction";
        String wrongInput = "function void run() bool a = 0. ++a. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitPost_incr()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. a++. endFunction";
        String wrongInput = "function void run() bool a = 0. a++. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitPre_decr()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. --a. endFunction";
        String wrongInput = "function void run() bool a = 0. --a. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitPost_decr()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. a--. endFunction";
        String wrongInput = "function void run() bool a = 0. a--. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitNot()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() bool a = !true. endFunction";
        String wrongInput = "function void run() num a = !true. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitMul_div_mod()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 1 * 2. endFunction";
        String wrongInput = "function void run() num a = 1 * true. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitAdd_sub()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 1 + 2. endFunction";
        String wrongInput = "function void run() num a = 1 + true. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitLe_ge_lt_gt()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() bool a = 1 > 0. endFunction";
        String wrongInput = "function void run() num a = 1 > 0. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitEqual_notequal()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() bool a = 1 == 2. endFunction";
        String wrongInput = "function void run() num a = 1 == 2. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitLogical_and()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() bool a = true && false. endFunction";
        String wrongInput = "function void run() bool a = 1 && false. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitLogical_or()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() bool a = true || false. endFunction";
        String wrongInput = "function void run() bool a = 1 || false. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitTernary()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = true ? 1 : 2. endFunction";
        String wrongInput = "function void run() num a = 1 ? 1 : 2. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitId()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() num a = 0. num b = a. endFunction";
        String wrongInput = "function void run() num a = 0. num b = c. endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitFuncCall()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() test(). endFunction function void test() endFunction";
        String wrongInput = "function void run() test(). endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }

    @Test
    public void visitParameters()  throws IOException {
        // ARRANGE
        String correctInput = "function void run() test(0). endFunction function void test(num x) endFunction";
        String wrongInput = "function void run() test(). endFunction function void test(num x) endFunction";

        // ACT
        boolean resultCorrect = CorrectInput(correctInput);
        boolean resultWrong = WrongInput(wrongInput);

        // ASSERT
        Assert.assertTrue(resultCorrect);
        Assert.assertTrue(resultWrong);
    }
}