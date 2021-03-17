// Generated from C:/Users/Jonas/Documents/GitHub/Gio\SyntaxAnalysis.g4 by ANTLR 4.9.1
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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, BOOL=40, ID=41, DIGITS=42, DIGIT=43, LETTER=44, LETTERORDIGIT=45, 
		WS=46, LINE_COMMENT=47;
	public static final int
		RULE_prog = 0, RULE_func = 1, RULE_eventHand = 2, RULE_block = 3, RULE_stmt = 4, 
		RULE_funcCall_Stmt = 5, RULE_incr_Stmt = 6, RULE_decr_Stmt = 7, RULE_expression = 8, 
		RULE_primary = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "func", "eventHand", "block", "stmt", "funcCall_Stmt", "incr_Stmt", 
			"decr_Stmt", "expression", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'('", "','", "')'", "'endFunction'", "'when'", "'endWhen'", 
			"'if'", "'do'", "'else if'", "'else do'", "'endIf'", "'repeat'", "'endRepeat'", 
			"'repeatIf'", "'endRepeatIf'", "'repeatUntil'", "'endRepeatUntil'", "'='", 
			"'.'", "'++'", "'--'", "'['", "']'", "'*'", "'/'", "'%'", "'+'", "'-'", 
			"'<='", "'>='", "'>'", "'<'", "'=='", "'!='", "'&&'", "'||'", "'?'", 
			"':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "BOOL", "ID", "DIGITS", "DIGIT", "LETTER", "LETTERORDIGIT", 
			"WS", "LINE_COMMENT"
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitProg(this);
		}
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
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__5) {
				{
				setState(22);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(20);
					func();
					}
					break;
				case T__5:
					{
					setState(21);
					eventHand();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
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
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(T__0);
			setState(30);
			match(ID);
			setState(31);
			match(T__1);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << BOOL) | (1L << ID) | (1L << DIGITS))) != 0)) {
				{
				setState(32);
				expression(0);
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(33);
					match(T__2);
					setState(34);
					expression(0);
					}
					}
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(42);
			match(T__3);
			setState(43);
			block();
			setState(44);
			match(T__4);
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
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EventHandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventHand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterEventHand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitEventHand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitEventHand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventHandContext eventHand() throws RecognitionException {
		EventHandContext _localctx = new EventHandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eventHand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__5);
			setState(47);
			match(ID);
			setState(48);
			match(T__1);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << BOOL) | (1L << ID) | (1L << DIGITS))) != 0)) {
				{
				setState(49);
				expression(0);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(50);
					match(T__2);
					setState(51);
					expression(0);
					}
					}
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(59);
			match(T__3);
			setState(60);
			block();
			setState(61);
			match(T__6);
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
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << ID))) != 0)) {
				{
				{
				setState(63);
				stmt();
				}
				}
				setState(68);
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
		public TerminalNode DIGITS() { return getToken(SyntaxAnalysisParser.DIGITS, 0); }
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public FuncCall_StmtContext funcCall_Stmt() {
			return getRuleContext(FuncCall_StmtContext.class,0);
		}
		public Incr_StmtContext incr_Stmt() {
			return getRuleContext(Incr_StmtContext.class,0);
		}
		public Decr_StmtContext decr_Stmt() {
			return getRuleContext(Decr_StmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		int _la;
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(T__7);
				setState(70);
				match(T__1);
				setState(71);
				expression(0);
				setState(72);
				match(T__3);
				setState(73);
				match(T__8);
				setState(74);
				block();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(75);
					match(T__9);
					setState(76);
					match(T__1);
					setState(77);
					expression(0);
					setState(78);
					match(T__3);
					setState(79);
					match(T__8);
					setState(80);
					block();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(87);
					match(T__10);
					setState(88);
					block();
					}
				}

				setState(91);
				match(T__11);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(T__12);
				setState(94);
				match(T__1);
				setState(98);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGITS:
					{
					setState(95);
					match(DIGITS);
					}
					break;
				case T__3:
					{
					}
					break;
				case ID:
					{
					setState(97);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(100);
				match(T__3);
				setState(101);
				block();
				setState(102);
				match(T__13);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(T__14);
				setState(105);
				match(T__1);
				setState(106);
				expression(0);
				setState(107);
				match(T__3);
				setState(108);
				block();
				setState(109);
				match(T__15);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				match(T__16);
				setState(112);
				match(T__1);
				setState(113);
				expression(0);
				setState(114);
				match(T__3);
				setState(115);
				block();
				setState(116);
				match(T__17);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
				funcCall_Stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
				match(ID);
				setState(120);
				match(T__18);
				setState(124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(121);
					expression(0);
					}
					break;
				case 2:
					{
					setState(122);
					incr_Stmt();
					}
					break;
				case 3:
					{
					setState(123);
					decr_Stmt();
					}
					break;
				}
				setState(126);
				match(T__19);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(128);
				incr_Stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(129);
				decr_Stmt();
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

	public static class FuncCall_StmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FuncCall_StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall_Stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterFuncCall_Stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitFuncCall_Stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitFuncCall_Stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCall_StmtContext funcCall_Stmt() throws RecognitionException {
		FuncCall_StmtContext _localctx = new FuncCall_StmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcCall_Stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(ID);
			setState(133);
			match(T__1);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << BOOL) | (1L << ID) | (1L << DIGITS))) != 0)) {
				{
				setState(134);
				expression(0);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(135);
					match(T__2);
					setState(136);
					expression(0);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144);
			match(T__3);
			setState(145);
			match(T__19);
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
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public Incr_StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incr_Stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterIncr_Stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitIncr_Stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitIncr_Stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Incr_StmtContext incr_Stmt() throws RecognitionException {
		Incr_StmtContext _localctx = new Incr_StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_incr_Stmt);
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(T__20);
				setState(148);
				match(ID);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(ID);
				setState(150);
				match(T__20);
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
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public Decr_StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decr_Stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterDecr_Stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitDecr_Stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitDecr_Stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decr_StmtContext decr_Stmt() throws RecognitionException {
		Decr_StmtContext _localctx = new Decr_StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_decr_Stmt);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(T__21);
				setState(154);
				match(ID);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(ID);
				setState(156);
				match(T__21);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token bop;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public FuncCall_StmtContext funcCall_Stmt() {
			return getRuleContext(FuncCall_StmtContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitExpression(this);
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
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(160);
				primary();
				}
				break;
			case 2:
				{
				setState(161);
				funcCall_Stmt();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(193);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(165);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(166);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(167);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(168);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(169);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(170);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(171);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(172);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(173);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(174);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__34) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(175);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(176);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(177);
						((ExpressionContext)_localctx).bop = match(T__35);
						setState(178);
						expression(4);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(179);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(180);
						((ExpressionContext)_localctx).bop = match(T__36);
						setState(181);
						expression(3);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(182);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(183);
						((ExpressionContext)_localctx).bop = match(T__37);
						setState(184);
						expression(0);
						setState(185);
						match(T__38);
						setState(186);
						expression(1);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(189);
						match(T__22);
						setState(190);
						expression(0);
						setState(191);
						match(T__23);
						}
						break;
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DIGITS() { return getToken(SyntaxAnalysisParser.DIGITS, 0); }
		public TerminalNode ID() { return getToken(SyntaxAnalysisParser.ID, 0); }
		public TerminalNode BOOL() { return getToken(SyntaxAnalysisParser.BOOL, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxAnalysisListener ) ((SyntaxAnalysisListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxAnalysisVisitor ) return ((SyntaxAnalysisVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primary);
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(T__1);
				setState(199);
				expression(0);
				setState(200);
				match(T__3);
				}
				break;
			case DIGITS:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(DIGITS);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				match(ID);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
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
		case 7:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u00d2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\3&\n\3\f\3\16\3)\13\3\5\3+\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\5\4<\n\4\3\4\3\4\3\4\3\4\3\5\7\5C\n"+
		"\5\f\5\16\5F\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\6U\n\6\f\6\16\6X\13\6\3\6\3\6\5\6\\\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6e\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\177\n\6\3\6\3\6\3\6\3\6\5\6\u0085"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\7\7\u008c\n\7\f\7\16\7\u008f\13\7\5\7\u0091\n"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b\u009a\n\b\3\t\3\t\3\t\3\t\5\t\u00a0"+
		"\n\t\3\n\3\n\3\n\5\n\u00a5\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\7\n\u00c4\n\n\f\n\16\n\u00c7\13\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00d0\n\13\3\13\2\3\22\f\2\4\6\b\n\f\16\20\22\24\2\6\3\2\33"+
		"\35\3\2\36\37\3\2 #\3\2$%\2\u00eb\2\32\3\2\2\2\4\37\3\2\2\2\6\60\3\2\2"+
		"\2\bD\3\2\2\2\n\u0084\3\2\2\2\f\u0086\3\2\2\2\16\u0099\3\2\2\2\20\u009f"+
		"\3\2\2\2\22\u00a4\3\2\2\2\24\u00cf\3\2\2\2\26\31\5\4\3\2\27\31\5\6\4\2"+
		"\30\26\3\2\2\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2"+
		"\33\35\3\2\2\2\34\32\3\2\2\2\35\36\7\2\2\3\36\3\3\2\2\2\37 \7\3\2\2 !"+
		"\7+\2\2!*\7\4\2\2\"\'\5\22\n\2#$\7\5\2\2$&\5\22\n\2%#\3\2\2\2&)\3\2\2"+
		"\2\'%\3\2\2\2\'(\3\2\2\2(+\3\2\2\2)\'\3\2\2\2*\"\3\2\2\2*+\3\2\2\2+,\3"+
		"\2\2\2,-\7\6\2\2-.\5\b\5\2./\7\7\2\2/\5\3\2\2\2\60\61\7\b\2\2\61\62\7"+
		"+\2\2\62;\7\4\2\2\638\5\22\n\2\64\65\7\5\2\2\65\67\5\22\n\2\66\64\3\2"+
		"\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29<\3\2\2\2:8\3\2\2\2;\63\3\2\2\2"+
		";<\3\2\2\2<=\3\2\2\2=>\7\6\2\2>?\5\b\5\2?@\7\t\2\2@\7\3\2\2\2AC\5\n\6"+
		"\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\t\3\2\2\2FD\3\2\2\2GH\7\n"+
		"\2\2HI\7\4\2\2IJ\5\22\n\2JK\7\6\2\2KL\7\13\2\2LV\5\b\5\2MN\7\f\2\2NO\7"+
		"\4\2\2OP\5\22\n\2PQ\7\6\2\2QR\7\13\2\2RS\5\b\5\2SU\3\2\2\2TM\3\2\2\2U"+
		"X\3\2\2\2VT\3\2\2\2VW\3\2\2\2W[\3\2\2\2XV\3\2\2\2YZ\7\r\2\2Z\\\5\b\5\2"+
		"[Y\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\16\2\2^\u0085\3\2\2\2_`\7\17\2\2"+
		"`d\7\4\2\2ae\7,\2\2be\3\2\2\2ce\7+\2\2da\3\2\2\2db\3\2\2\2dc\3\2\2\2e"+
		"f\3\2\2\2fg\7\6\2\2gh\5\b\5\2hi\7\20\2\2i\u0085\3\2\2\2jk\7\21\2\2kl\7"+
		"\4\2\2lm\5\22\n\2mn\7\6\2\2no\5\b\5\2op\7\22\2\2p\u0085\3\2\2\2qr\7\23"+
		"\2\2rs\7\4\2\2st\5\22\n\2tu\7\6\2\2uv\5\b\5\2vw\7\24\2\2w\u0085\3\2\2"+
		"\2x\u0085\5\f\7\2yz\7+\2\2z~\7\25\2\2{\177\5\22\n\2|\177\5\16\b\2}\177"+
		"\5\20\t\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081"+
		"\7\26\2\2\u0081\u0085\3\2\2\2\u0082\u0085\5\16\b\2\u0083\u0085\5\20\t"+
		"\2\u0084G\3\2\2\2\u0084_\3\2\2\2\u0084j\3\2\2\2\u0084q\3\2\2\2\u0084x"+
		"\3\2\2\2\u0084y\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\13\3\2\2\2\u0086\u0087\7+\2\2\u0087\u0090\7\4\2\2\u0088\u008d\5\22\n"+
		"\2\u0089\u008a\7\5\2\2\u008a\u008c\5\22\n\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\7\6\2\2\u0093\u0094\7\26\2\2\u0094\r\3\2\2"+
		"\2\u0095\u0096\7\27\2\2\u0096\u009a\7+\2\2\u0097\u0098\7+\2\2\u0098\u009a"+
		"\7\27\2\2\u0099\u0095\3\2\2\2\u0099\u0097\3\2\2\2\u009a\17\3\2\2\2\u009b"+
		"\u009c\7\30\2\2\u009c\u00a0\7+\2\2\u009d\u009e\7+\2\2\u009e\u00a0\7\30"+
		"\2\2\u009f\u009b\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\21\3\2\2\2\u00a1\u00a2"+
		"\b\n\1\2\u00a2\u00a5\5\24\13\2\u00a3\u00a5\5\f\7\2\u00a4\u00a1\3\2\2\2"+
		"\u00a4\u00a3\3\2\2\2\u00a5\u00c5\3\2\2\2\u00a6\u00a7\f\t\2\2\u00a7\u00a8"+
		"\t\2\2\2\u00a8\u00c4\5\22\n\n\u00a9\u00aa\f\b\2\2\u00aa\u00ab\t\3\2\2"+
		"\u00ab\u00c4\5\22\n\t\u00ac\u00ad\f\7\2\2\u00ad\u00ae\t\4\2\2\u00ae\u00c4"+
		"\5\22\n\b\u00af\u00b0\f\6\2\2\u00b0\u00b1\t\5\2\2\u00b1\u00c4\5\22\n\7"+
		"\u00b2\u00b3\f\5\2\2\u00b3\u00b4\7&\2\2\u00b4\u00c4\5\22\n\6\u00b5\u00b6"+
		"\f\4\2\2\u00b6\u00b7\7\'\2\2\u00b7\u00c4\5\22\n\5\u00b8\u00b9\f\3\2\2"+
		"\u00b9\u00ba\7(\2\2\u00ba\u00bb\5\22\n\2\u00bb\u00bc\7)\2\2\u00bc\u00bd"+
		"\5\22\n\3\u00bd\u00c4\3\2\2\2\u00be\u00bf\f\13\2\2\u00bf\u00c0\7\31\2"+
		"\2\u00c0\u00c1\5\22\n\2\u00c1\u00c2\7\32\2\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u00a6\3\2\2\2\u00c3\u00a9\3\2\2\2\u00c3\u00ac\3\2\2\2\u00c3\u00af\3\2"+
		"\2\2\u00c3\u00b2\3\2\2\2\u00c3\u00b5\3\2\2\2\u00c3\u00b8\3\2\2\2\u00c3"+
		"\u00be\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\23\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\7\4\2\2\u00c9\u00ca"+
		"\5\22\n\2\u00ca\u00cb\7\6\2\2\u00cb\u00d0\3\2\2\2\u00cc\u00d0\7,\2\2\u00cd"+
		"\u00d0\7+\2\2\u00ce\u00d0\7*\2\2\u00cf\u00c8\3\2\2\2\u00cf\u00cc\3\2\2"+
		"\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\25\3\2\2\2\26\30\32\'"+
		"*8;DV[d~\u0084\u008d\u0090\u0099\u009f\u00a4\u00c3\u00c5\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}