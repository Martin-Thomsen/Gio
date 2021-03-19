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
		BOOL=25, ID=26, DIGITS=27, DIGIT=28, LETTER=29, LETTERORDIGIT=30, MUL=31, 
		DIV=32, ADD=33, SUB=34, MOD=35, GE=36, LE=37, GT=38, LT=39, EQUALS=40, 
		NOTEQUALS=41, AND=42, OR=43, QMARK=44, COLON=45, WS=46, LINE_COMMENT=47;
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
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "BOOL", 
			"ID", "DIGITS", "DIGIT", "LETTER", "LETTERORDIGIT", "MUL", "DIV", "ADD", 
			"SUB", "MOD", "GE", "LE", "GT", "LT", "EQUALS", "NOTEQUALS", "AND", "OR", 
			"QMARK", "COLON", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'('", "')'", "'endFunction'", "'when'", "'endWhen'", 
			"'if'", "'do'", "'else if'", "'else do'", "'endIf'", "'repeat'", "'endRepeat'", 
			"'repeatIf'", "'endRepeatIf'", "'repeatUntil'", "'endRepeatUntil'", "'='", 
			"'.'", "'++'", "'--'", "'['", "']'", "','", null, null, null, null, null, 
			null, "'*'", "'/'", "'+'", "'-'", "'%'", "'>='", "'<='", "'>'", "'<'", 
			"'=='", "'!='", "'&&'", "'||'", "'?'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "BOOL", "ID", "DIGITS", "DIGIT", "LETTER", "LETTERORDIGIT", "MUL", 
			"DIV", "ADD", "SUB", "MOD", "GE", "LE", "GT", "LT", "EQUALS", "NOTEQUALS", 
			"AND", "OR", "QMARK", "COLON", "WS", "LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0148\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00fe\n\32"+
		"\3\33\3\33\3\33\7\33\u0103\n\33\f\33\16\33\u0106\13\33\3\34\3\34\3\34"+
		"\3\34\5\34\u010c\n\34\3\35\3\35\3\36\3\36\3\37\3\37\5\37\u0114\n\37\3"+
		" \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3"+
		")\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3"+
		"\60\7\60\u0142\n\60\f\60\16\60\u0145\13\60\3\60\3\60\2\2\61\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\5\4\2C\\c|\5\2\13\f\17\17\"\"\4"+
		"\2\f\f\17\17\2\u014d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\3a\3\2\2\2\5j\3\2\2\2\7l\3\2\2\2\tn\3\2\2\2\13z\3\2\2"+
		"\2\r\177\3\2\2\2\17\u0087\3\2\2\2\21\u008a\3\2\2\2\23\u008d\3\2\2\2\25"+
		"\u0095\3\2\2\2\27\u009d\3\2\2\2\31\u00a3\3\2\2\2\33\u00aa\3\2\2\2\35\u00b4"+
		"\3\2\2\2\37\u00bd\3\2\2\2!\u00c9\3\2\2\2#\u00d5\3\2\2\2%\u00e4\3\2\2\2"+
		"\'\u00e6\3\2\2\2)\u00e8\3\2\2\2+\u00eb\3\2\2\2-\u00ee\3\2\2\2/\u00f0\3"+
		"\2\2\2\61\u00f2\3\2\2\2\63\u00fd\3\2\2\2\65\u00ff\3\2\2\2\67\u010b\3\2"+
		"\2\29\u010d\3\2\2\2;\u010f\3\2\2\2=\u0113\3\2\2\2?\u0115\3\2\2\2A\u0117"+
		"\3\2\2\2C\u0119\3\2\2\2E\u011b\3\2\2\2G\u011d\3\2\2\2I\u011f\3\2\2\2K"+
		"\u0122\3\2\2\2M\u0125\3\2\2\2O\u0127\3\2\2\2Q\u0129\3\2\2\2S\u012c\3\2"+
		"\2\2U\u012f\3\2\2\2W\u0132\3\2\2\2Y\u0135\3\2\2\2[\u0137\3\2\2\2]\u0139"+
		"\3\2\2\2_\u013d\3\2\2\2ab\7h\2\2bc\7w\2\2cd\7p\2\2de\7e\2\2ef\7v\2\2f"+
		"g\7k\2\2gh\7q\2\2hi\7p\2\2i\4\3\2\2\2jk\7*\2\2k\6\3\2\2\2lm\7+\2\2m\b"+
		"\3\2\2\2no\7g\2\2op\7p\2\2pq\7f\2\2qr\7H\2\2rs\7w\2\2st\7p\2\2tu\7e\2"+
		"\2uv\7v\2\2vw\7k\2\2wx\7q\2\2xy\7p\2\2y\n\3\2\2\2z{\7y\2\2{|\7j\2\2|}"+
		"\7g\2\2}~\7p\2\2~\f\3\2\2\2\177\u0080\7g\2\2\u0080\u0081\7p\2\2\u0081"+
		"\u0082\7f\2\2\u0082\u0083\7Y\2\2\u0083\u0084\7j\2\2\u0084\u0085\7g\2\2"+
		"\u0085\u0086\7p\2\2\u0086\16\3\2\2\2\u0087\u0088\7k\2\2\u0088\u0089\7"+
		"h\2\2\u0089\20\3\2\2\2\u008a\u008b\7f\2\2\u008b\u008c\7q\2\2\u008c\22"+
		"\3\2\2\2\u008d\u008e\7g\2\2\u008e\u008f\7n\2\2\u008f\u0090\7u\2\2\u0090"+
		"\u0091\7g\2\2\u0091\u0092\7\"\2\2\u0092\u0093\7k\2\2\u0093\u0094\7h\2"+
		"\2\u0094\24\3\2\2\2\u0095\u0096\7g\2\2\u0096\u0097\7n\2\2\u0097\u0098"+
		"\7u\2\2\u0098\u0099\7g\2\2\u0099\u009a\7\"\2\2\u009a\u009b\7f\2\2\u009b"+
		"\u009c\7q\2\2\u009c\26\3\2\2\2\u009d\u009e\7g\2\2\u009e\u009f\7p\2\2\u009f"+
		"\u00a0\7f\2\2\u00a0\u00a1\7K\2\2\u00a1\u00a2\7h\2\2\u00a2\30\3\2\2\2\u00a3"+
		"\u00a4\7t\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7r\2\2\u00a6\u00a7\7g\2\2"+
		"\u00a7\u00a8\7c\2\2\u00a8\u00a9\7v\2\2\u00a9\32\3\2\2\2\u00aa\u00ab\7"+
		"g\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae\7T\2\2\u00ae\u00af"+
		"\7g\2\2\u00af\u00b0\7r\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7c\2\2\u00b2"+
		"\u00b3\7v\2\2\u00b3\34\3\2\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6\7g\2\2\u00b6"+
		"\u00b7\7r\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7v\2\2"+
		"\u00ba\u00bb\7K\2\2\u00bb\u00bc\7h\2\2\u00bc\36\3\2\2\2\u00bd\u00be\7"+
		"g\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7f\2\2\u00c0\u00c1\7T\2\2\u00c1\u00c2"+
		"\7g\2\2\u00c2\u00c3\7r\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7c\2\2\u00c5"+
		"\u00c6\7v\2\2\u00c6\u00c7\7K\2\2\u00c7\u00c8\7h\2\2\u00c8 \3\2\2\2\u00c9"+
		"\u00ca\7t\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7r\2\2\u00cc\u00cd\7g\2\2"+
		"\u00cd\u00ce\7c\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0\7W\2\2\u00d0\u00d1"+
		"\7p\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7n\2\2\u00d4"+
		"\"\3\2\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7f\2\2\u00d8"+
		"\u00d9\7T\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7r\2\2\u00db\u00dc\7g\2\2"+
		"\u00dc\u00dd\7c\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7W\2\2\u00df\u00e0"+
		"\7p\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7n\2\2\u00e3"+
		"$\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5&\3\2\2\2\u00e6\u00e7\7\60\2\2\u00e7"+
		"(\3\2\2\2\u00e8\u00e9\7-\2\2\u00e9\u00ea\7-\2\2\u00ea*\3\2\2\2\u00eb\u00ec"+
		"\7/\2\2\u00ec\u00ed\7/\2\2\u00ed,\3\2\2\2\u00ee\u00ef\7]\2\2\u00ef.\3"+
		"\2\2\2\u00f0\u00f1\7_\2\2\u00f1\60\3\2\2\2\u00f2\u00f3\7.\2\2\u00f3\62"+
		"\3\2\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6\7t\2\2\u00f6\u00f7\7w\2\2\u00f7"+
		"\u00fe\7g\2\2\u00f8\u00f9\7h\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb\7n\2\2"+
		"\u00fb\u00fc\7u\2\2\u00fc\u00fe\7g\2\2\u00fd\u00f4\3\2\2\2\u00fd\u00f8"+
		"\3\2\2\2\u00fe\64\3\2\2\2\u00ff\u0104\5;\36\2\u0100\u0103\5=\37\2\u0101"+
		"\u0103\7a\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2"+
		"\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\66\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0107\u0108\59\35\2\u0108\u0109\5\67\34\2\u0109\u010c\3\2\2\2"+
		"\u010a\u010c\59\35\2\u010b\u0107\3\2\2\2\u010b\u010a\3\2\2\2\u010c8\3"+
		"\2\2\2\u010d\u010e\4\62;\2\u010e:\3\2\2\2\u010f\u0110\t\2\2\2\u0110<\3"+
		"\2\2\2\u0111\u0114\5;\36\2\u0112\u0114\59\35\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0112\3\2\2\2\u0114>\3\2\2\2\u0115\u0116\7,\2\2\u0116@\3\2\2\2\u0117"+
		"\u0118\7\61\2\2\u0118B\3\2\2\2\u0119\u011a\7-\2\2\u011aD\3\2\2\2\u011b"+
		"\u011c\7/\2\2\u011cF\3\2\2\2\u011d\u011e\7\'\2\2\u011eH\3\2\2\2\u011f"+
		"\u0120\7@\2\2\u0120\u0121\7?\2\2\u0121J\3\2\2\2\u0122\u0123\7>\2\2\u0123"+
		"\u0124\7?\2\2\u0124L\3\2\2\2\u0125\u0126\7@\2\2\u0126N\3\2\2\2\u0127\u0128"+
		"\7>\2\2\u0128P\3\2\2\2\u0129\u012a\7?\2\2\u012a\u012b\7?\2\2\u012bR\3"+
		"\2\2\2\u012c\u012d\7#\2\2\u012d\u012e\7?\2\2\u012eT\3\2\2\2\u012f\u0130"+
		"\7(\2\2\u0130\u0131\7(\2\2\u0131V\3\2\2\2\u0132\u0133\7~\2\2\u0133\u0134"+
		"\7~\2\2\u0134X\3\2\2\2\u0135\u0136\7A\2\2\u0136Z\3\2\2\2\u0137\u0138\7"+
		"<\2\2\u0138\\\3\2\2\2\u0139\u013a\t\3\2\2\u013a\u013b\3\2\2\2\u013b\u013c"+
		"\b/\2\2\u013c^\3\2\2\2\u013d\u013e\7\61\2\2\u013e\u013f\7\61\2\2\u013f"+
		"\u0143\3\2\2\2\u0140\u0142\n\4\2\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2"+
		"\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0147\b\60\2\2\u0147`\3\2\2\2\t\2\u00fd\u0102\u0104"+
		"\u010b\u0113\u0143\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}