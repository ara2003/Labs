// Generated from d:\programing\Java\repos\Labs\LPIS_1\src\main\antlr4\antlr4\test.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, FUNC=6, PASS=7, NOT_OPERATION=8, 
		LOGIC_OPERATION=9, COMPARE_OPERATION=10, MULT_OPERATION=11, PLUS_OPERATION=12, 
		MINUS_OPERATION=13, LIST=14, ELEMENT=15, FOR=16, WHILE=17, IF=18, ELSE=19, 
		SWITCH=20, DEFAULT=21, CASE=22, RETURN=23, BREAK=24, CONTINUE=25, ID=26, 
		NUMBER=27, NEWLINE=28, SKIP_=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "FUNC", "PASS", "NOT_OPERATION", 
			"LOGIC_OPERATION", "COMPARE_OPERATION", "MULT_OPERATION", "PLUS_OPERATION", 
			"MINUS_OPERATION", "LIST", "ELEMENT", "FOR", "WHILE", "IF", "ELSE", "SWITCH", 
			"DEFAULT", "CASE", "RETURN", "BREAK", "CONTINUE", "ID", "NUMBER", "NEWLINE", 
			"SKIP_", "COMMENT", "SPACES"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "','", "'func'", "'pass'", "'not'", 
			null, null, null, "'+'", "'-'", "'list'", "'element'", "'for'", "'while'", 
			"'if'", "'else'", "'switch'", "'default'", "'case'", "'return'", "'break'", 
			"'continue'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "FUNC", "PASS", "NOT_OPERATION", 
			"LOGIC_OPERATION", "COMPARE_OPERATION", "MULT_OPERATION", "PLUS_OPERATION", 
			"MINUS_OPERATION", "LIST", "ELEMENT", "FOR", "WHILE", "IF", "ELSE", "SWITCH", 
			"DEFAULT", "CASE", "RETURN", "BREAK", "CONTINUE", "ID", "NUMBER", "NEWLINE", 
			"SKIP_"
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


	public testLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "test.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 27:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			    skip();

			    var text = getText();
			    var depth = solveDepth(text);

			    while(depth < lastDepth) {
			        lastDepth--;
			        bufferEmit(new CommonToken(exampleParser.END, "}"));
			    }
			    while(depth > lastDepth) {
			        lastDepth++;
			        bufferEmit(new CommonToken(exampleParser.BEGIN, "{"));
			    }
			   
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00e6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n_\n\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13j\n\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\7\33\u00bd\n\33\f\33\16\33\u00c0\13\33\3\34"+
		"\6\34\u00c3\n\34\r\34\16\34\u00c4\3\35\5\35\u00c8\n\35\3\35\3\35\7\35"+
		"\u00cc\n\35\f\35\16\35\u00cf\13\35\3\35\3\35\3\36\3\36\5\36\u00d5\n\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00dd\n\37\f\37\16\37\u00e0\13\37"+
		"\3 \6 \u00e3\n \r \16 \u00e4\2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37=\2?\2\3\2\t\4\2>>@@\6\2\'\',,\61\61`"+
		"`\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\4\2\f\f\16\17\4\2\13\13\"\"\2\u00ef"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2"+
		"\2\2\17P\3\2\2\2\21U\3\2\2\2\23^\3\2\2\2\25i\3\2\2\2\27k\3\2\2\2\31m\3"+
		"\2\2\2\33o\3\2\2\2\35q\3\2\2\2\37v\3\2\2\2!~\3\2\2\2#\u0082\3\2\2\2%\u0088"+
		"\3\2\2\2\'\u008b\3\2\2\2)\u0090\3\2\2\2+\u0097\3\2\2\2-\u009f\3\2\2\2"+
		"/\u00a4\3\2\2\2\61\u00ab\3\2\2\2\63\u00b1\3\2\2\2\65\u00ba\3\2\2\2\67"+
		"\u00c2\3\2\2\29\u00c7\3\2\2\2;\u00d4\3\2\2\2=\u00d8\3\2\2\2?\u00e2\3\2"+
		"\2\2AB\7*\2\2B\4\3\2\2\2CD\7+\2\2D\6\3\2\2\2EF\7]\2\2F\b\3\2\2\2GH\7_"+
		"\2\2H\n\3\2\2\2IJ\7.\2\2J\f\3\2\2\2KL\7h\2\2LM\7w\2\2MN\7p\2\2NO\7e\2"+
		"\2O\16\3\2\2\2PQ\7r\2\2QR\7c\2\2RS\7u\2\2ST\7u\2\2T\20\3\2\2\2UV\7p\2"+
		"\2VW\7q\2\2WX\7v\2\2X\22\3\2\2\2YZ\7c\2\2Z[\7p\2\2[_\7f\2\2\\]\7q\2\2"+
		"]_\7t\2\2^Y\3\2\2\2^\\\3\2\2\2_\24\3\2\2\2`j\t\2\2\2ab\7@\2\2bj\7?\2\2"+
		"cd\7>\2\2dj\7?\2\2ef\7?\2\2fj\7?\2\2gh\7#\2\2hj\7?\2\2i`\3\2\2\2ia\3\2"+
		"\2\2ic\3\2\2\2ie\3\2\2\2ig\3\2\2\2j\26\3\2\2\2kl\t\3\2\2l\30\3\2\2\2m"+
		"n\7-\2\2n\32\3\2\2\2op\7/\2\2p\34\3\2\2\2qr\7n\2\2rs\7k\2\2st\7u\2\2t"+
		"u\7v\2\2u\36\3\2\2\2vw\7g\2\2wx\7n\2\2xy\7g\2\2yz\7o\2\2z{\7g\2\2{|\7"+
		"p\2\2|}\7v\2\2} \3\2\2\2~\177\7h\2\2\177\u0080\7q\2\2\u0080\u0081\7t\2"+
		"\2\u0081\"\3\2\2\2\u0082\u0083\7y\2\2\u0083\u0084\7j\2\2\u0084\u0085\7"+
		"k\2\2\u0085\u0086\7n\2\2\u0086\u0087\7g\2\2\u0087$\3\2\2\2\u0088\u0089"+
		"\7k\2\2\u0089\u008a\7h\2\2\u008a&\3\2\2\2\u008b\u008c\7g\2\2\u008c\u008d"+
		"\7n\2\2\u008d\u008e\7u\2\2\u008e\u008f\7g\2\2\u008f(\3\2\2\2\u0090\u0091"+
		"\7u\2\2\u0091\u0092\7y\2\2\u0092\u0093\7k\2\2\u0093\u0094\7v\2\2\u0094"+
		"\u0095\7e\2\2\u0095\u0096\7j\2\2\u0096*\3\2\2\2\u0097\u0098\7f\2\2\u0098"+
		"\u0099\7g\2\2\u0099\u009a\7h\2\2\u009a\u009b\7c\2\2\u009b\u009c\7w\2\2"+
		"\u009c\u009d\7n\2\2\u009d\u009e\7v\2\2\u009e,\3\2\2\2\u009f\u00a0\7e\2"+
		"\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7g\2\2\u00a3.\3\2"+
		"\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8"+
		"\7w\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7p\2\2\u00aa\60\3\2\2\2\u00ab\u00ac"+
		"\7d\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7c\2\2\u00af"+
		"\u00b0\7m\2\2\u00b0\62\3\2\2\2\u00b1\u00b2\7e\2\2\u00b2\u00b3\7q\2\2\u00b3"+
		"\u00b4\7p\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7p\2\2"+
		"\u00b7\u00b8\7w\2\2\u00b8\u00b9\7g\2\2\u00b9\64\3\2\2\2\u00ba\u00be\t"+
		"\4\2\2\u00bb\u00bd\t\5\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\66\3\2\2\2\u00c0\u00be\3\2\2"+
		"\2\u00c1\u00c3\t\6\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c58\3\2\2\2\u00c6\u00c8\7\17\2\2\u00c7"+
		"\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cd\7\f"+
		"\2\2\u00ca\u00cc\5? \2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d1\b\35\2\2\u00d1:\3\2\2\2\u00d2\u00d5\5? \2\u00d3\u00d5\5=\37\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\b\36"+
		"\3\2\u00d7<\3\2\2\2\u00d8\u00d9\7\61\2\2\u00d9\u00da\7\61\2\2\u00da\u00de"+
		"\3\2\2\2\u00db\u00dd\n\7\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df>\3\2\2\2\u00e0\u00de\3\2\2\2"+
		"\u00e1\u00e3\t\b\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5@\3\2\2\2\f\2^i\u00be\u00c4\u00c7\u00cd"+
		"\u00d4\u00de\u00e4\4\3\35\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}