// Generated from C:/Users/m-s-t/Documents/GitHub/Gio\SyntaxAnalysis.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SyntaxAnalysisParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, BOOL=27, ID=28, DIGITS=29, DIGIT=30, LETTER=31, LETTERORDIGIT=32, 
		MUL=33, DIV=34, ADD=35, SUB=36, MOD=37, GE=38, LE=39, GT=40, LT=41, EQUALS=42, 
		NOTEQUALS=43, AND=44, OR=45, QMARK=46, COLON=47, WS=48, LINE_COMMENT=49;
	public static final int
		RULE_prog = 0, RULE_func = 1, RULE_eventHand = 2, RULE_block = 3, RULE_stmt = 4, 
		RULE_incr_Stmt = 5, RULE_decr_Stmt = 6, RULE_return_Stmt = 7, RULE_expression = 8, 
		RULE_primary = 9, RULE_func_Call = 10, RULE_fparam = 11, RULE_param = 12, 
		RULE_ftype = 13, RULE_type = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "func", "eventHand", "block", "stmt", "incr_Stmt", "decr_Stmt", 
			"return_Stmt", "expression", "primary", "func_Call", "fparam", "param", 
			"ftype", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'('", "')'", "'endFunction'", "'when'", "'endWhen'", 
			"'if'", "'do'", "'else if'", "'else do'", "'endIf'", "'repeat'", "'endRepeat'", 
			"'repeatIf'", "'endRepeatIf'", "'until'", "'.'", "'='", "'++'", "'--'", 
			"'return'", "'!'", "','", "'void'", "'num'", "'bool'", null, null, null, 
			null, null, null, "'*'", "'/'", "'+'", "'-'", "'%'", "'>='", "'<='", 
			"'>'", "'<'", "'=='", "'!='", "'&&'", "'||'", "'?'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "BOOL", "ID", "DIGITS", "DIGIT", "LETTER", "LETTERORDIGIT", 
			"MUL", "DIV", "ADD", "SUB", "MOD", "GE", "LE", "GT", "LT", "EQUALS", 
			"NOTEQUALS", "AND", "OR", "QMARK", "COLON", "WS", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SyntaxAnalysis.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SyntaxAnalysisParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SyntaxAnalysisParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public List<EventHandContext> eventHand() {
			return getRuleContexts(EventHandContext.class);
		}
		public EventHandContext eventHand(int i) {
			return getRuleContext(EventHandContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__4) {
				{
				setState(32);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(30);
					func();
					}
					break;
				case T__4:
					{
					setState(31);
					eventHand();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionContext extends FuncContext {
		public FtypeContext ftype() {
			return getRuleContext(FtypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public FparamContext fparam() {
			return getRuleContext(FparamContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		try {
			_localctx = new FunctionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__0);
			setState(40);
			ftype();
			setState(41);
			match(ID);
			setState(42);
			match(T__1);
			setState(43);
			fparam();
			setState(44);
			match(T__2);
			setState(45);
			block();
			setState(46);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventHandContext extends ParserRuleContext {
		public EventHandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventHand; }
	 
		public EventHandContext() { }
		public void copyFrom(EventHandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhenContext extends EventHandContext {
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public FparamContext fparam() {
			return getRuleContext(FparamContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhenContext(EventHandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitWhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventHandContext eventHand() throws RecognitionException {
		EventHandContext _localctx = new EventHandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eventHand);
		try {
			_localctx = new WhenContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__4);
			setState(49);
			match(ID);
			setState(50);
			match(T__1);
			setState(51);
			fparam();
			setState(52);
			match(T__2);
			setState(53);
			block();
			setState(54);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlkContext extends BlockContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlkContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitBlk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			_localctx = new BlkContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__11) | (1L << T__13) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__24) | (1L << T__25) | (1L << ID))) != 0)) {
				{
				{
				setState(56);
				stmt();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RetContext extends StmtContext {
		public Return_StmtContext return_Stmt() {
			return getRuleContext(Return_StmtContext.class,0);
		}
		public RetContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rep_ifContext extends StmtContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Rep_ifContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitRep_if(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncrContext extends StmtContext {
		public Incr_StmtContext incr_Stmt() {
			return getRuleContext(Incr_StmtContext.class,0);
		}
		public IncrContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitIncr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rep_untilContext extends StmtContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Rep_untilContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitRep_until(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Func_stmtContext extends StmtContext {
		public Func_CallContext func_Call() {
			return getRuleContext(Func_CallContext.class,0);
		}
		public Func_stmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitFunc_stmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Var_declContext extends StmtContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Incr_StmtContext incr_Stmt() {
			return getRuleContext(Incr_StmtContext.class,0);
		}
		public Decr_StmtContext decr_Stmt() {
			return getRuleContext(Decr_StmtContext.class,0);
		}
		public Var_declContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RepContext extends StmtContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DIGITS() { return getToken(SyntaxAnalysisParser.DIGITS, 0); }
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public RepContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitRep(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends StmtContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecrContext extends StmtContext {
		public Decr_StmtContext decr_Stmt() {
			return getRuleContext(Decr_StmtContext.class,0);
		}
		public DecrContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitDecr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends StmtContext {
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Incr_StmtContext incr_Stmt() {
			return getRuleContext(Incr_StmtContext.class,0);
		}
		public Decr_StmtContext decr_Stmt() {
			return getRuleContext(Decr_StmtContext.class,0);
		}
		public AssignContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		int _la;
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(T__6);
				setState(63);
				match(T__1);
				setState(64);
				expression(0);
				setState(65);
				match(T__2);
				setState(66);
				match(T__7);
				setState(67);
				block();
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(68);
					match(T__8);
					setState(69);
					match(T__1);
					setState(70);
					expression(0);
					setState(71);
					match(T__2);
					setState(72);
					match(T__7);
					setState(73);
					block();
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(80);
					match(T__9);
					setState(81);
					block();
					}
				}

				setState(84);
				match(T__10);
				}
				break;
			case 2:
				_localctx = new RepContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(T__11);
				setState(87);
				match(T__1);
				setState(88);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==DIGITS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(89);
				match(T__2);
				setState(90);
				block();
				setState(91);
				match(T__12);
				}
				break;
			case 3:
				_localctx = new Rep_ifContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				match(T__13);
				setState(94);
				match(T__1);
				setState(95);
				expression(0);
				setState(96);
				match(T__2);
				setState(97);
				block();
				setState(98);
				match(T__14);
				}
				break;
			case 4:
				_localctx = new Rep_untilContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				match(T__11);
				setState(101);
				block();
				setState(102);
				match(T__15);
				setState(103);
				match(T__1);
				setState(104);
				expression(0);
				setState(105);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new Func_stmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				func_Call();
				setState(108);
				match(T__16);
				}
				break;
			case 6:
				_localctx = new Var_declContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(110);
				type();
				setState(111);
				match(ID);
				setState(112);
				match(T__17);
				setState(116);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(113);
					expression(0);
					}
					break;
				case 2:
					{
					setState(114);
					incr_Stmt();
					}
					break;
				case 3:
					{
					setState(115);
					decr_Stmt();
					}
					break;
				}
				setState(118);
				match(T__16);
				}
				break;
			case 7:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(120);
				match(ID);
				setState(121);
				match(T__17);
				setState(125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(122);
					expression(0);
					}
					break;
				case 2:
					{
					setState(123);
					incr_Stmt();
					}
					break;
				case 3:
					{
					setState(124);
					decr_Stmt();
					}
					break;
				}
				setState(127);
				match(T__16);
				}
				break;
			case 8:
				_localctx = new IncrContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(129);
				incr_Stmt();
				setState(130);
				match(T__16);
				}
				break;
			case 9:
				_localctx = new DecrContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(132);
				decr_Stmt();
				setState(133);
				match(T__16);
				}
				break;
			case 10:
				_localctx = new RetContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(135);
				return_Stmt();
				setState(136);
				match(T__16);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Incr_StmtContext extends ParserRuleContext {
		public Incr_StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incr_Stmt; }
	 
		public Incr_StmtContext() { }
		public void copyFrom(Incr_StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Post_incrContext extends Incr_StmtContext {
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public Post_incrContext(Incr_StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitPost_incr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pre_incrContext extends Incr_StmtContext {
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public Pre_incrContext(Incr_StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitPre_incr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Incr_StmtContext incr_Stmt() throws RecognitionException {
		Incr_StmtContext _localctx = new Incr_StmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_incr_Stmt);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				_localctx = new Pre_incrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(T__18);
				setState(141);
				match(ID);
				}
				break;
			case ID:
				_localctx = new Post_incrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(ID);
				setState(143);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decr_StmtContext extends ParserRuleContext {
		public Decr_StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decr_Stmt; }
	 
		public Decr_StmtContext() { }
		public void copyFrom(Decr_StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Pre_decrContext extends Decr_StmtContext {
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public Pre_decrContext(Decr_StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitPre_decr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Post_decrContext extends Decr_StmtContext {
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public Post_decrContext(Decr_StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitPost_decr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decr_StmtContext decr_Stmt() throws RecognitionException {
		Decr_StmtContext _localctx = new Decr_StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_decr_Stmt);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				_localctx = new Pre_decrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(T__19);
				setState(147);
				match(ID);
				}
				break;
			case ID:
				_localctx = new Post_decrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(ID);
				setState(149);
				match(T__19);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_StmtContext extends ParserRuleContext {
		public Return_StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_Stmt; }
	 
		public Return_StmtContext() { }
		public void copyFrom(Return_StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnStmtContext extends Return_StmtContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(Return_StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_StmtContext return_Stmt() throws RecognitionException {
		Return_StmtContext _localctx = new Return_StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_return_Stmt);
		try {
			_localctx = new ReturnStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__20);
			setState(153);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Logical_orContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(SyntaxAnalysisParser.OR, 0); }
		public Logical_orContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitLogical_or(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitPrim(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Le_ge_lt_gtContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LE() { return getToken(SyntaxAnalysisParser.LE, 0); }
		public TerminalNode GE() { return getToken(SyntaxAnalysisParser.GE, 0); }
		public TerminalNode LT() { return getToken(SyntaxAnalysisParser.LT, 0); }
		public TerminalNode GT() { return getToken(SyntaxAnalysisParser.GT, 0); }
		public Le_ge_lt_gtContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitLe_ge_lt_gt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Logical_andContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(SyntaxAnalysisParser.AND, 0); }
		public Logical_andContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitLogical_and(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Func_exprContext extends ExpressionContext {
		public Func_CallContext func_Call() {
			return getRuleContext(Func_CallContext.class,0);
		}
		public Func_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitFunc_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Equal_notequalContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(SyntaxAnalysisParser.EQUALS, 0); }
		public TerminalNode NOTEQUALS() { return getToken(SyntaxAnalysisParser.NOTEQUALS, 0); }
		public Equal_notequalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitEqual_notequal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TertiaryContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(SyntaxAnalysisParser.COLON, 0); }
		public TerminalNode QMARK() { return getToken(SyntaxAnalysisParser.QMARK, 0); }
		public TertiaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitTertiary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Add_subContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(SyntaxAnalysisParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SyntaxAnalysisParser.SUB, 0); }
		public Add_subContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitAdd_sub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Mul_div_modContext extends ExpressionContext {
		public Token bop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(SyntaxAnalysisParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(SyntaxAnalysisParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SyntaxAnalysisParser.MOD, 0); }
		public Mul_div_modContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitMul_div_mod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new PrimContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(156);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new Func_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				func_Call();
				}
				break;
			case 3:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				match(T__21);
				setState(159);
				expression(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(186);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new Mul_div_modContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(163);
						((Mul_div_modContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((Mul_div_modContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new Add_subContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(165);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(166);
						((Add_subContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((Add_subContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(167);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new Le_ge_lt_gtContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(168);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(169);
						((Le_ge_lt_gtContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GE) | (1L << LE) | (1L << GT) | (1L << LT))) != 0)) ) {
							((Le_ge_lt_gtContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(170);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new Equal_notequalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(171);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(172);
						((Equal_notequalContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOTEQUALS) ) {
							((Equal_notequalContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(173);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new Logical_andContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(175);
						((Logical_andContext)_localctx).bop = match(AND);
						setState(176);
						expression(4);
						}
						break;
					case 6:
						{
						_localctx = new Logical_orContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(178);
						((Logical_orContext)_localctx).bop = match(OR);
						setState(179);
						expression(3);
						}
						break;
					case 7:
						{
						_localctx = new TertiaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(181);
						((TertiaryContext)_localctx).bop = match(QMARK);
						setState(182);
						expression(0);
						setState(183);
						match(COLON);
						setState(184);
						expression(1);
						}
						break;
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensContext extends PrimaryContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParensContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends PrimaryContext {
		public TerminalNode BOOL() { return getToken(SyntaxAnalysisParser.BOOL, 0); }
		public BoolContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DigitsContext extends PrimaryContext {
		public TerminalNode DIGITS() { return getToken(SyntaxAnalysisParser.DIGITS, 0); }
		public DigitsContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitDigits(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends PrimaryContext {
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public IdContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primary);
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(T__1);
				setState(192);
				expression(0);
				setState(193);
				match(T__2);
				}
				break;
			case DIGITS:
				_localctx = new DigitsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(DIGITS);
				}
				break;
			case ID:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(ID);
				}
				break;
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(BOOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_CallContext extends ParserRuleContext {
		public Func_CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_Call; }
	 
		public Func_CallContext() { }
		public void copyFrom(Func_CallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncCallContext extends Func_CallContext {
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public FuncCallContext(Func_CallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_CallContext func_Call() throws RecognitionException {
		Func_CallContext _localctx = new Func_CallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_func_Call);
		try {
			_localctx = new FuncCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(ID);
			setState(201);
			match(T__1);
			setState(202);
			param();
			setState(203);
			match(T__2);
			setState(204);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FparamContext extends ParserRuleContext {
		public FparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fparam; }
	 
		public FparamContext() { }
		public void copyFrom(FparamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FparametersContext extends FparamContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(SyntaxAnalysisParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SyntaxAnalysisParser.ID, i);
		}
		public FparametersContext(FparamContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitFparameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FparamContext fparam() throws RecognitionException {
		FparamContext _localctx = new FparamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fparam);
		int _la;
		try {
			_localctx = new FparametersContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24 || _la==T__25) {
				{
				setState(206);
				type();
				setState(207);
				match(ID);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__22) {
					{
					{
					setState(208);
					match(T__22);
					setState(209);
					type();
					setState(210);
					match(ID);
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParametersContext extends ParamContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ParametersContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_param);
		int _la;
		try {
			_localctx = new ParametersContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__21) | (1L << BOOL) | (1L << ID) | (1L << DIGITS))) != 0)) {
				{
				setState(219);
				expression(0);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__22) {
					{
					{
					setState(220);
					match(T__22);
					setState(221);
					expression(0);
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FtypeContext extends ParserRuleContext {
		public FtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ftype; }
	 
		public FtypeContext() { }
		public void copyFrom(FtypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Type_ftypeContext extends FtypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Type_ftypeContext(FtypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitType_ftype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Void_ftypeContext extends FtypeContext {
		public Void_ftypeContext(FtypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitVoid_ftype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FtypeContext ftype() throws RecognitionException {
		FtypeContext _localctx = new FtypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ftype);
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				_localctx = new Void_ftypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(T__23);
				}
				break;
			case T__24:
			case T__25:
				_localctx = new Type_ftypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Num_typeContext extends TypeContext {
		public Num_typeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitNum_type(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bool_typeContext extends TypeContext {
		public Bool_typeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitBool_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				_localctx = new Num_typeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				match(T__24);
				}
				break;
			case T__25:
				_localctx = new Bool_typeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u00f0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f"+
		"\2\16\2&\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\7\5<\n\5\f\5\16\5?\13\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6\3\6\3\6\5\6U\n"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6w\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0080\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u008d\n\6\3\7\3\7\3\7\3\7\5\7\u0093\n\7\3\b\3\b\3"+
		"\b\3\b\5\b\u0099\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u00a3\n\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\7\n\u00bd\n\n\f\n\16\n\u00c0\13\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00c9\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u00d7\n\r\f\r\16\r\u00da\13\r\5\r\u00dc\n\r\3\16\3"+
		"\16\3\16\7\16\u00e1\n\16\f\16\16\16\u00e4\13\16\5\16\u00e6\n\16\3\17\3"+
		"\17\5\17\u00ea\n\17\3\20\3\20\5\20\u00ee\n\20\3\20\2\3\22\21\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36\2\7\3\2\36\37\4\2#$\'\'\3\2%&\3\2(+\3\2"+
		",-\2\u0106\2$\3\2\2\2\4)\3\2\2\2\6\62\3\2\2\2\b=\3\2\2\2\n\u008c\3\2\2"+
		"\2\f\u0092\3\2\2\2\16\u0098\3\2\2\2\20\u009a\3\2\2\2\22\u00a2\3\2\2\2"+
		"\24\u00c8\3\2\2\2\26\u00ca\3\2\2\2\30\u00db\3\2\2\2\32\u00e5\3\2\2\2\34"+
		"\u00e9\3\2\2\2\36\u00ed\3\2\2\2 #\5\4\3\2!#\5\6\4\2\" \3\2\2\2\"!\3\2"+
		"\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\7\2\2\3(\3"+
		"\3\2\2\2)*\7\3\2\2*+\5\34\17\2+,\7\36\2\2,-\7\4\2\2-.\5\30\r\2./\7\5\2"+
		"\2/\60\5\b\5\2\60\61\7\6\2\2\61\5\3\2\2\2\62\63\7\7\2\2\63\64\7\36\2\2"+
		"\64\65\7\4\2\2\65\66\5\30\r\2\66\67\7\5\2\2\678\5\b\5\289\7\b\2\29\7\3"+
		"\2\2\2:<\5\n\6\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\t\3\2\2\2?="+
		"\3\2\2\2@A\7\t\2\2AB\7\4\2\2BC\5\22\n\2CD\7\5\2\2DE\7\n\2\2EO\5\b\5\2"+
		"FG\7\13\2\2GH\7\4\2\2HI\5\22\n\2IJ\7\5\2\2JK\7\n\2\2KL\5\b\5\2LN\3\2\2"+
		"\2MF\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PT\3\2\2\2QO\3\2\2\2RS\7\f\2"+
		"\2SU\5\b\5\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\7\r\2\2W\u008d\3\2\2\2XY"+
		"\7\16\2\2YZ\7\4\2\2Z[\t\2\2\2[\\\7\5\2\2\\]\5\b\5\2]^\7\17\2\2^\u008d"+
		"\3\2\2\2_`\7\20\2\2`a\7\4\2\2ab\5\22\n\2bc\7\5\2\2cd\5\b\5\2de\7\21\2"+
		"\2e\u008d\3\2\2\2fg\7\16\2\2gh\5\b\5\2hi\7\22\2\2ij\7\4\2\2jk\5\22\n\2"+
		"kl\7\5\2\2l\u008d\3\2\2\2mn\5\26\f\2no\7\23\2\2o\u008d\3\2\2\2pq\5\36"+
		"\20\2qr\7\36\2\2rv\7\24\2\2sw\5\22\n\2tw\5\f\7\2uw\5\16\b\2vs\3\2\2\2"+
		"vt\3\2\2\2vu\3\2\2\2wx\3\2\2\2xy\7\23\2\2y\u008d\3\2\2\2z{\7\36\2\2{\177"+
		"\7\24\2\2|\u0080\5\22\n\2}\u0080\5\f\7\2~\u0080\5\16\b\2\177|\3\2\2\2"+
		"\177}\3\2\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7\23\2\2\u0082"+
		"\u008d\3\2\2\2\u0083\u0084\5\f\7\2\u0084\u0085\7\23\2\2\u0085\u008d\3"+
		"\2\2\2\u0086\u0087\5\16\b\2\u0087\u0088\7\23\2\2\u0088\u008d\3\2\2\2\u0089"+
		"\u008a\5\20\t\2\u008a\u008b\7\23\2\2\u008b\u008d\3\2\2\2\u008c@\3\2\2"+
		"\2\u008cX\3\2\2\2\u008c_\3\2\2\2\u008cf\3\2\2\2\u008cm\3\2\2\2\u008cp"+
		"\3\2\2\2\u008cz\3\2\2\2\u008c\u0083\3\2\2\2\u008c\u0086\3\2\2\2\u008c"+
		"\u0089\3\2\2\2\u008d\13\3\2\2\2\u008e\u008f\7\25\2\2\u008f\u0093\7\36"+
		"\2\2\u0090\u0091\7\36\2\2\u0091\u0093\7\25\2\2\u0092\u008e\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\r\3\2\2\2\u0094\u0095\7\26\2\2\u0095\u0099\7\36\2"+
		"\2\u0096\u0097\7\36\2\2\u0097\u0099\7\26\2\2\u0098\u0094\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\17\3\2\2\2\u009a\u009b\7\27\2\2\u009b\u009c\5\22"+
		"\n\2\u009c\21\3\2\2\2\u009d\u009e\b\n\1\2\u009e\u00a3\5\24\13\2\u009f"+
		"\u00a3\5\26\f\2\u00a0\u00a1\7\30\2\2\u00a1\u00a3\5\22\n\n\u00a2\u009d"+
		"\3\2\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00be\3\2\2\2\u00a4"+
		"\u00a5\f\t\2\2\u00a5\u00a6\t\3\2\2\u00a6\u00bd\5\22\n\n\u00a7\u00a8\f"+
		"\b\2\2\u00a8\u00a9\t\4\2\2\u00a9\u00bd\5\22\n\t\u00aa\u00ab\f\7\2\2\u00ab"+
		"\u00ac\t\5\2\2\u00ac\u00bd\5\22\n\b\u00ad\u00ae\f\6\2\2\u00ae\u00af\t"+
		"\6\2\2\u00af\u00bd\5\22\n\7\u00b0\u00b1\f\5\2\2\u00b1\u00b2\7.\2\2\u00b2"+
		"\u00bd\5\22\n\6\u00b3\u00b4\f\4\2\2\u00b4\u00b5\7/\2\2\u00b5\u00bd\5\22"+
		"\n\5\u00b6\u00b7\f\3\2\2\u00b7\u00b8\7\60\2\2\u00b8\u00b9\5\22\n\2\u00b9"+
		"\u00ba\7\61\2\2\u00ba\u00bb\5\22\n\3\u00bb\u00bd\3\2\2\2\u00bc\u00a4\3"+
		"\2\2\2\u00bc\u00a7\3\2\2\2\u00bc\u00aa\3\2\2\2\u00bc\u00ad\3\2\2\2\u00bc"+
		"\u00b0\3\2\2\2\u00bc\u00b3\3\2\2\2\u00bc\u00b6\3\2\2\2\u00bd\u00c0\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\23\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\u00c2\7\4\2\2\u00c2\u00c3\5\22\n\2\u00c3\u00c4\7\5\2\2"+
		"\u00c4\u00c9\3\2\2\2\u00c5\u00c9\7\37\2\2\u00c6\u00c9\7\36\2\2\u00c7\u00c9"+
		"\7\35\2\2\u00c8\u00c1\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c8\u00c6\3\2\2\2"+
		"\u00c8\u00c7\3\2\2\2\u00c9\25\3\2\2\2\u00ca\u00cb\7\36\2\2\u00cb\u00cc"+
		"\7\4\2\2\u00cc\u00cd\5\32\16\2\u00cd\u00ce\7\5\2\2\u00ce\u00cf\7\23\2"+
		"\2\u00cf\27\3\2\2\2\u00d0\u00d1\5\36\20\2\u00d1\u00d8\7\36\2\2\u00d2\u00d3"+
		"\7\31\2\2\u00d3\u00d4\5\36\20\2\u00d4\u00d5\7\36\2\2\u00d5\u00d7\3\2\2"+
		"\2\u00d6\u00d2\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00d0\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\31\3\2\2\2\u00dd\u00e2\5\22\n\2\u00de\u00df\7\31"+
		"\2\2\u00df\u00e1\5\22\n\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2"+
		"\2\2\u00e5\u00dd\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\33\3\2\2\2\u00e7\u00ea"+
		"\7\32\2\2\u00e8\u00ea\5\36\20\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2"+
		"\2\u00ea\35\3\2\2\2\u00eb\u00ee\7\33\2\2\u00ec\u00ee\7\34\2\2\u00ed\u00eb"+
		"\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\37\3\2\2\2\26\"$=OTv\177\u008c\u0092"+
		"\u0098\u00a2\u00bc\u00be\u00c8\u00d8\u00db\u00e2\u00e5\u00e9\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}