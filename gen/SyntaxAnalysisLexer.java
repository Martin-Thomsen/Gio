// Generated from C:/Users/m-s-t/Documents/GitHub/Gio\SyntaxAnalysis.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SyntaxAnalysisLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, BOOL=26, ID=27, DIGITS=28, DIGIT=29, LETTER=30, LETTERORDIGIT=31, 
		MUL=32, DIV=33, ADD=34, SUB=35, MOD=36, GE=37, LE=38, GT=39, LT=40, EQUALS=41, 
		NOTEQUALS=42, AND=43, OR=44, QMARK=45, COLON=46, WS=47, LINE_COMMENT=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"BOOL", "ID", "DIGITS", "DIGIT", "LETTER", "LETTERORDIGIT", "MUL", "DIV", 
			"ADD", "SUB", "MOD", "GE", "LE", "GT", "LT", "EQUALS", "NOTEQUALS", "AND", 
			"OR", "QMARK", "COLON", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'('", "')'", "'endFunction'", "'when'", "'endWhen'", 
			"'if'", "'do'", "'else if'", "'else do'", "'endIf'", "'repeat'", "'endRepeat'", 
			"'repeatIf'", "'endRepeatIf'", "'until'", "'.'", "'='", "'++'", "'--'", 
			"'return'", "','", "'void'", "'num'", "'bool'", null, null, null, null, 
			null, null, "'*'", "'/'", "'+'", "'-'", "'%'", "'>='", "'<='", "'>'", 
			"'<'", "'=='", "'!='", "'&&'", "'||'", "'?'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "BOOL", "ID", "DIGITS", "DIGIT", "LETTER", "LETTERORDIGIT", 
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


	public SyntaxAnalysisLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SyntaxAnalysis.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0146\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00fc\n\33\3\34\3\34"+
		"\3\34\7\34\u0101\n\34\f\34\16\34\u0104\13\34\3\35\3\35\3\35\3\35\5\35"+
		"\u010a\n\35\3\36\3\36\3\37\3\37\3 \3 \5 \u0112\n \3!\3!\3\"\3\"\3#\3#"+
		"\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,"+
		"\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61"+
		"\u0140\n\61\f\61\16\61\u0143\13\61\3\61\3\61\2\2\62\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62\3\2\5\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f"+
		"\17\17\2\u014b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5l\3\2\2\2\7n\3\2\2\2\tp\3\2\2\2\13|\3"+
		"\2\2\2\r\u0081\3\2\2\2\17\u0089\3\2\2\2\21\u008c\3\2\2\2\23\u008f\3\2"+
		"\2\2\25\u0097\3\2\2\2\27\u009f\3\2\2\2\31\u00a5\3\2\2\2\33\u00ac\3\2\2"+
		"\2\35\u00b6\3\2\2\2\37\u00bf\3\2\2\2!\u00cb\3\2\2\2#\u00d1\3\2\2\2%\u00d3"+
		"\3\2\2\2\'\u00d5\3\2\2\2)\u00d8\3\2\2\2+\u00db\3\2\2\2-\u00e2\3\2\2\2"+
		"/\u00e4\3\2\2\2\61\u00e9\3\2\2\2\63\u00ed\3\2\2\2\65\u00fb\3\2\2\2\67"+
		"\u00fd\3\2\2\29\u0109\3\2\2\2;\u010b\3\2\2\2=\u010d\3\2\2\2?\u0111\3\2"+
		"\2\2A\u0113\3\2\2\2C\u0115\3\2\2\2E\u0117\3\2\2\2G\u0119\3\2\2\2I\u011b"+
		"\3\2\2\2K\u011d\3\2\2\2M\u0120\3\2\2\2O\u0123\3\2\2\2Q\u0125\3\2\2\2S"+
		"\u0127\3\2\2\2U\u012a\3\2\2\2W\u012d\3\2\2\2Y\u0130\3\2\2\2[\u0133\3\2"+
		"\2\2]\u0135\3\2\2\2_\u0137\3\2\2\2a\u013b\3\2\2\2cd\7h\2\2de\7w\2\2ef"+
		"\7p\2\2fg\7e\2\2gh\7v\2\2hi\7k\2\2ij\7q\2\2jk\7p\2\2k\4\3\2\2\2lm\7*\2"+
		"\2m\6\3\2\2\2no\7+\2\2o\b\3\2\2\2pq\7g\2\2qr\7p\2\2rs\7f\2\2st\7H\2\2"+
		"tu\7w\2\2uv\7p\2\2vw\7e\2\2wx\7v\2\2xy\7k\2\2yz\7q\2\2z{\7p\2\2{\n\3\2"+
		"\2\2|}\7y\2\2}~\7j\2\2~\177\7g\2\2\177\u0080\7p\2\2\u0080\f\3\2\2\2\u0081"+
		"\u0082\7g\2\2\u0082\u0083\7p\2\2\u0083\u0084\7f\2\2\u0084\u0085\7Y\2\2"+
		"\u0085\u0086\7j\2\2\u0086\u0087\7g\2\2\u0087\u0088\7p\2\2\u0088\16\3\2"+
		"\2\2\u0089\u008a\7k\2\2\u008a\u008b\7h\2\2\u008b\20\3\2\2\2\u008c\u008d"+
		"\7f\2\2\u008d\u008e\7q\2\2\u008e\22\3\2\2\2\u008f\u0090\7g\2\2\u0090\u0091"+
		"\7n\2\2\u0091\u0092\7u\2\2\u0092\u0093\7g\2\2\u0093\u0094\7\"\2\2\u0094"+
		"\u0095\7k\2\2\u0095\u0096\7h\2\2\u0096\24\3\2\2\2\u0097\u0098\7g\2\2\u0098"+
		"\u0099\7n\2\2\u0099\u009a\7u\2\2\u009a\u009b\7g\2\2\u009b\u009c\7\"\2"+
		"\2\u009c\u009d\7f\2\2\u009d\u009e\7q\2\2\u009e\26\3\2\2\2\u009f\u00a0"+
		"\7g\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7f\2\2\u00a2\u00a3\7K\2\2\u00a3"+
		"\u00a4\7h\2\2\u00a4\30\3\2\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7g\2\2\u00a7"+
		"\u00a8\7r\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7v\2\2"+
		"\u00ab\32\3\2\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7"+
		"f\2\2\u00af\u00b0\7T\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7r\2\2\u00b2\u00b3"+
		"\7g\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5\7v\2\2\u00b5\34\3\2\2\2\u00b6\u00b7"+
		"\7t\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7r\2\2\u00b9\u00ba\7g\2\2\u00ba"+
		"\u00bb\7c\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7K\2\2\u00bd\u00be\7h\2\2"+
		"\u00be\36\3\2\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7"+
		"f\2\2\u00c2\u00c3\7T\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7r\2\2\u00c5\u00c6"+
		"\7g\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7K\2\2\u00c9"+
		"\u00ca\7h\2\2\u00ca \3\2\2\2\u00cb\u00cc\7w\2\2\u00cc\u00cd\7p\2\2\u00cd"+
		"\u00ce\7v\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7n\2\2\u00d0\"\3\2\2\2\u00d1"+
		"\u00d2\7\60\2\2\u00d2$\3\2\2\2\u00d3\u00d4\7?\2\2\u00d4&\3\2\2\2\u00d5"+
		"\u00d6\7-\2\2\u00d6\u00d7\7-\2\2\u00d7(\3\2\2\2\u00d8\u00d9\7/\2\2\u00d9"+
		"\u00da\7/\2\2\u00da*\3\2\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7g\2\2\u00dd"+
		"\u00de\7v\2\2\u00de\u00df\7w\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7p\2\2"+
		"\u00e1,\3\2\2\2\u00e2\u00e3\7.\2\2\u00e3.\3\2\2\2\u00e4\u00e5\7x\2\2\u00e5"+
		"\u00e6\7q\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7f\2\2\u00e8\60\3\2\2\2\u00e9"+
		"\u00ea\7p\2\2\u00ea\u00eb\7w\2\2\u00eb\u00ec\7o\2\2\u00ec\62\3\2\2\2\u00ed"+
		"\u00ee\7d\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0\7q\2\2\u00f0\u00f1\7n\2\2"+
		"\u00f1\64\3\2\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7"+
		"w\2\2\u00f5\u00fc\7g\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7c\2\2\u00f8\u00f9"+
		"\7n\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fc\7g\2\2\u00fb\u00f2\3\2\2\2\u00fb"+
		"\u00f6\3\2\2\2\u00fc\66\3\2\2\2\u00fd\u0102\5=\37\2\u00fe\u0101\5? \2"+
		"\u00ff\u0101\7a\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\u0104"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u01038\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0105\u0106\5;\36\2\u0106\u0107\59\35\2\u0107\u010a\3\2"+
		"\2\2\u0108\u010a\5;\36\2\u0109\u0105\3\2\2\2\u0109\u0108\3\2\2\2\u010a"+
		":\3\2\2\2\u010b\u010c\4\62;\2\u010c<\3\2\2\2\u010d\u010e\t\2\2\2\u010e"+
		">\3\2\2\2\u010f\u0112\5=\37\2\u0110\u0112\5;\36\2\u0111\u010f\3\2\2\2"+
		"\u0111\u0110\3\2\2\2\u0112@\3\2\2\2\u0113\u0114\7,\2\2\u0114B\3\2\2\2"+
		"\u0115\u0116\7\61\2\2\u0116D\3\2\2\2\u0117\u0118\7-\2\2\u0118F\3\2\2\2"+
		"\u0119\u011a\7/\2\2\u011aH\3\2\2\2\u011b\u011c\7\'\2\2\u011cJ\3\2\2\2"+
		"\u011d\u011e\7@\2\2\u011e\u011f\7?\2\2\u011fL\3\2\2\2\u0120\u0121\7>\2"+
		"\2\u0121\u0122\7?\2\2\u0122N\3\2\2\2\u0123\u0124\7@\2\2\u0124P\3\2\2\2"+
		"\u0125\u0126\7>\2\2\u0126R\3\2\2\2\u0127\u0128\7?\2\2\u0128\u0129\7?\2"+
		"\2\u0129T\3\2\2\2\u012a\u012b\7#\2\2\u012b\u012c\7?\2\2\u012cV\3\2\2\2"+
		"\u012d\u012e\7(\2\2\u012e\u012f\7(\2\2\u012fX\3\2\2\2\u0130\u0131\7~\2"+
		"\2\u0131\u0132\7~\2\2\u0132Z\3\2\2\2\u0133\u0134\7A\2\2\u0134\\\3\2\2"+
		"\2\u0135\u0136\7<\2\2\u0136^\3\2\2\2\u0137\u0138\t\3\2\2\u0138\u0139\3"+
		"\2\2\2\u0139\u013a\b\60\2\2\u013a`\3\2\2\2\u013b\u013c\7\61\2\2\u013c"+
		"\u013d\7\61\2\2\u013d\u0141\3\2\2\2\u013e\u0140\n\4\2\2\u013f\u013e\3"+
		"\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0144\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\b\61\2\2\u0145b\3\2\2\2"+
		"\t\2\u00fb\u0100\u0102\u0109\u0111\u0141\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}