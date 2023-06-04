// Generated from d:\programing\Java\repos\Labs\LPIS_1\src\main\antlr4\antlr4\example.g4 by ANTLR 4.9.2

import java.util.LinkedList;
import java.util.Queue;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class exampleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, FUNC=9, 
		PASS=10, NOT_OPERATION=11, LOGIC_OPERATION=12, COMPARE_OPERATION=13, MULT_OPERATION=14, 
		PLUS_OPERATION=15, MINUS_OPERATION=16, LIST=17, ELEMENT=18, FOR=19, WHILE=20, 
		IF=21, ELSE=22, SWITCH=23, DEFAULT=24, CASE=25, RETURN=26, BREAK=27, CONTINUE=28, 
		ID=29, NUMBER=30, NEWLINE=31, SKIP_=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "FUNC", 
			"PASS", "NOT_OPERATION", "LOGIC_OPERATION", "COMPARE_OPERATION", "MULT_OPERATION", 
			"PLUS_OPERATION", "MINUS_OPERATION", "LIST", "ELEMENT", "FOR", "WHILE", 
			"IF", "ELSE", "SWITCH", "DEFAULT", "CASE", "RETURN", "BREAK", "CONTINUE", 
			"ID", "NUMBER", "NEWLINE", "SKIP_", "COMMENT", "SPACES"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "':'", "','", "'in'", "'['", "']'", "'func'", 
			"'pass'", "'not'", null, null, null, "'+'", "'-'", "'list'", "'element'", 
			"'for'", "'while'", "'if'", "'else'", "'switch'", "'default'", "'case'", 
			"'return'", "'break'", "'continue'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "FUNC", "PASS", 
			"NOT_OPERATION", "LOGIC_OPERATION", "COMPARE_OPERATION", "MULT_OPERATION", 
			"PLUS_OPERATION", "MINUS_OPERATION", "LIST", "ELEMENT", "FOR", "WHILE", 
			"IF", "ELSE", "SWITCH", "DEFAULT", "CASE", "RETURN", "BREAK", "CONTINUE", 
			"ID", "NUMBER", "NEWLINE", "SKIP_"
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


	private int lastDepth = 0;

	private final Queue<Token> buffer = new LinkedList<>();

	public boolean atStart() {
	    return getCharIndex() == 0;
	}

	public void bufferEmit(Token token) {
	    buffer.add(token);
	}

	private static int solveDepth(String text) {
	    return text.chars().map(x -> (switch(x) {
	        case '\t' -> 4;
	        case ' ' -> 1;
	        default -> 0;
	    })).sum() / 4;
	}

	public Token nextToken() {
	    if(buffer.isEmpty()) {
	        var next = super.nextToken();
	        if(!buffer.isEmpty()) {
	            var result = buffer.poll();
	            buffer.add(next);
	            return result;
	        }
	        if(next.getType() == Token.EOF) {
	            while(lastDepth-- > 0)
	                buffer.add(new CommonToken(exampleParser.END, "}"));
	            buffer.add(next);
	            return nextToken();
	        }
	        return next;
	    }
	    return buffer.poll();
	}


	public exampleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "example.g4"; }

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
		case 30:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00f3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\rl\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16w\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\7\36\u00ca\n\36\f\36\16\36\u00cd\13\36\3\37\6\37\u00d0\n\37"+
		"\r\37\16\37\u00d1\3 \5 \u00d5\n \3 \3 \7 \u00d9\n \f \16 \u00dc\13 \3"+
		" \3 \3!\3!\5!\u00e2\n!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00ea\n\"\f\"\16\"\u00ed"+
		"\13\"\3#\6#\u00f0\n#\r#\16#\u00f1\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C\2E\2\3\2\t\4\2>>@@\6\2\'"+
		"\',,\61\61``\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\4\2\f\f\16\17\4\2\13\13\""+
		"\"\2\u00fc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3G\3\2\2\2\5I\3\2\2\2"+
		"\7K\3\2\2\2\tM\3\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17T\3\2\2\2\21V\3\2\2\2"+
		"\23X\3\2\2\2\25]\3\2\2\2\27b\3\2\2\2\31k\3\2\2\2\33v\3\2\2\2\35x\3\2\2"+
		"\2\37z\3\2\2\2!|\3\2\2\2#~\3\2\2\2%\u0083\3\2\2\2\'\u008b\3\2\2\2)\u008f"+
		"\3\2\2\2+\u0095\3\2\2\2-\u0098\3\2\2\2/\u009d\3\2\2\2\61\u00a4\3\2\2\2"+
		"\63\u00ac\3\2\2\2\65\u00b1\3\2\2\2\67\u00b8\3\2\2\29\u00be\3\2\2\2;\u00c7"+
		"\3\2\2\2=\u00cf\3\2\2\2?\u00d4\3\2\2\2A\u00e1\3\2\2\2C\u00e5\3\2\2\2E"+
		"\u00ef\3\2\2\2GH\7?\2\2H\4\3\2\2\2IJ\7*\2\2J\6\3\2\2\2KL\7+\2\2L\b\3\2"+
		"\2\2MN\7<\2\2N\n\3\2\2\2OP\7.\2\2P\f\3\2\2\2QR\7k\2\2RS\7p\2\2S\16\3\2"+
		"\2\2TU\7]\2\2U\20\3\2\2\2VW\7_\2\2W\22\3\2\2\2XY\7h\2\2YZ\7w\2\2Z[\7p"+
		"\2\2[\\\7e\2\2\\\24\3\2\2\2]^\7r\2\2^_\7c\2\2_`\7u\2\2`a\7u\2\2a\26\3"+
		"\2\2\2bc\7p\2\2cd\7q\2\2de\7v\2\2e\30\3\2\2\2fg\7c\2\2gh\7p\2\2hl\7f\2"+
		"\2ij\7q\2\2jl\7t\2\2kf\3\2\2\2ki\3\2\2\2l\32\3\2\2\2mw\t\2\2\2no\7@\2"+
		"\2ow\7?\2\2pq\7>\2\2qw\7?\2\2rs\7?\2\2sw\7?\2\2tu\7#\2\2uw\7?\2\2vm\3"+
		"\2\2\2vn\3\2\2\2vp\3\2\2\2vr\3\2\2\2vt\3\2\2\2w\34\3\2\2\2xy\t\3\2\2y"+
		"\36\3\2\2\2z{\7-\2\2{ \3\2\2\2|}\7/\2\2}\"\3\2\2\2~\177\7n\2\2\177\u0080"+
		"\7k\2\2\u0080\u0081\7u\2\2\u0081\u0082\7v\2\2\u0082$\3\2\2\2\u0083\u0084"+
		"\7g\2\2\u0084\u0085\7n\2\2\u0085\u0086\7g\2\2\u0086\u0087\7o\2\2\u0087"+
		"\u0088\7g\2\2\u0088\u0089\7p\2\2\u0089\u008a\7v\2\2\u008a&\3\2\2\2\u008b"+
		"\u008c\7h\2\2\u008c\u008d\7q\2\2\u008d\u008e\7t\2\2\u008e(\3\2\2\2\u008f"+
		"\u0090\7y\2\2\u0090\u0091\7j\2\2\u0091\u0092\7k\2\2\u0092\u0093\7n\2\2"+
		"\u0093\u0094\7g\2\2\u0094*\3\2\2\2\u0095\u0096\7k\2\2\u0096\u0097\7h\2"+
		"\2\u0097,\3\2\2\2\u0098\u0099\7g\2\2\u0099\u009a\7n\2\2\u009a\u009b\7"+
		"u\2\2\u009b\u009c\7g\2\2\u009c.\3\2\2\2\u009d\u009e\7u\2\2\u009e\u009f"+
		"\7y\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7e\2\2\u00a2"+
		"\u00a3\7j\2\2\u00a3\60\3\2\2\2\u00a4\u00a5\7f\2\2\u00a5\u00a6\7g\2\2\u00a6"+
		"\u00a7\7h\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7w\2\2\u00a9\u00aa\7n\2\2"+
		"\u00aa\u00ab\7v\2\2\u00ab\62\3\2\2\2\u00ac\u00ad\7e\2\2\u00ad\u00ae\7"+
		"c\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7g\2\2\u00b0\64\3\2\2\2\u00b1\u00b2"+
		"\7t\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7w\2\2\u00b5"+
		"\u00b6\7t\2\2\u00b6\u00b7\7p\2\2\u00b7\66\3\2\2\2\u00b8\u00b9\7d\2\2\u00b9"+
		"\u00ba\7t\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7m\2\2"+
		"\u00bd8\3\2\2\2\u00be\u00bf\7e\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7p\2"+
		"\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5"+
		"\7w\2\2\u00c5\u00c6\7g\2\2\u00c6:\3\2\2\2\u00c7\u00cb\t\4\2\2\u00c8\u00ca"+
		"\t\5\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc<\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\t\6\2\2"+
		"\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2>\3\2\2\2\u00d3\u00d5\7\17\2\2\u00d4\u00d3\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00da\7\f\2\2\u00d7\u00d9\5E"+
		"#\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\b "+
		"\2\2\u00de@\3\2\2\2\u00df\u00e2\5E#\2\u00e0\u00e2\5C\"\2\u00e1\u00df\3"+
		"\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b!\3\2\u00e4"+
		"B\3\2\2\2\u00e5\u00e6\7\61\2\2\u00e6\u00e7\7\61\2\2\u00e7\u00eb\3\2\2"+
		"\2\u00e8\u00ea\n\7\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9"+
		"\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ecD\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee"+
		"\u00f0\t\b\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2F\3\2\2\2\f\2kv\u00cb\u00d1\u00d4\u00da"+
		"\u00e1\u00eb\u00f1\4\3 \2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}