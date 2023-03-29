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
		NOT_OPERATION=10, LOGIC_OPERATION=11, COMPARE_OPERATION=12, SUM_OPERATION=13, 
		MULT_OPERATION=14, INC_OPERATION=15, DEC_OPERATION=16, PLUS_OPERATION=17, 
		MINUS_OPERATION=18, LIST=19, ELEMENT=20, FOR=21, WHILE=22, IF=23, ELSE=24, 
		SWITCH=25, CASE=26, RETURN=27, BREAK=28, CONTINUE=29, ID=30, NUMBER=31, 
		NEWLINE=32, SKIP_=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "FUNC", 
			"NOT_OPERATION", "LOGIC_OPERATION", "COMPARE_OPERATION", "SUM_OPERATION", 
			"MULT_OPERATION", "INC_OPERATION", "DEC_OPERATION", "PLUS_OPERATION", 
			"MINUS_OPERATION", "LIST", "ELEMENT", "FOR", "WHILE", "IF", "ELSE", "SWITCH", 
			"CASE", "RETURN", "BREAK", "CONTINUE", "ID", "NUMBER", "NEWLINE", "SKIP_", 
			"COMMENT", "TABS", "SPACES"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "':'", "','", "'in'", "'['", "']'", "'func'", 
			"'not'", null, null, null, null, "'++'", "'--'", "'+'", "'-'", "'list'", 
			"'element'", "'for'", "'while'", "'if'", "'else'", "'switch'", "'case'", 
			"'return'", "'break'", "'continue'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "FUNC", "NOT_OPERATION", 
			"LOGIC_OPERATION", "COMPARE_OPERATION", "SUM_OPERATION", "MULT_OPERATION", 
			"INC_OPERATION", "DEC_OPERATION", "PLUS_OPERATION", "MINUS_OPERATION", 
			"LIST", "ELEMENT", "FOR", "WHILE", "IF", "ELSE", "SWITCH", "CASE", "RETURN", 
			"BREAK", "CONTINUE", "ID", "NUMBER", "NEWLINE", "SKIP_"
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

	private static int solveDepth(String string) {
	    var index = string.indexOf('\t');
	    if(index < 0)
	        return 0;
	    return string.length() - index;
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
		case 31:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00f6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\5\fk\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rv\n"+
		"\r\3\16\3\16\5\16z\n\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\7"+
		"\37\u00cb\n\37\f\37\16\37\u00ce\13\37\3 \6 \u00d1\n \r \16 \u00d2\3!\3"+
		"!\7!\u00d7\n!\f!\16!\u00da\13!\3!\3!\3\"\3\"\5\"\u00e0\n\"\3\"\3\"\3#"+
		"\3#\3#\3#\7#\u00e8\n#\f#\16#\u00eb\13#\3$\6$\u00ee\n$\r$\16$\u00ef\3%"+
		"\6%\u00f3\n%\r%\16%\u00f4\2\2&\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E\2G\2I\2\3\2\n\4\2>>@@\5\2\'\'"+
		",,\61\61\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\4\2\f\f\16\17\3\2\13\13\4\2\16"+
		"\17\"\"\2\u00ff\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3K\3"+
		"\2\2\2\5M\3\2\2\2\7O\3\2\2\2\tQ\3\2\2\2\13S\3\2\2\2\rU\3\2\2\2\17X\3\2"+
		"\2\2\21Z\3\2\2\2\23\\\3\2\2\2\25a\3\2\2\2\27j\3\2\2\2\31u\3\2\2\2\33y"+
		"\3\2\2\2\35{\3\2\2\2\37}\3\2\2\2!\u0080\3\2\2\2#\u0083\3\2\2\2%\u0085"+
		"\3\2\2\2\'\u0087\3\2\2\2)\u008c\3\2\2\2+\u0094\3\2\2\2-\u0098\3\2\2\2"+
		"/\u009e\3\2\2\2\61\u00a1\3\2\2\2\63\u00a6\3\2\2\2\65\u00ad\3\2\2\2\67"+
		"\u00b2\3\2\2\29\u00b9\3\2\2\2;\u00bf\3\2\2\2=\u00c8\3\2\2\2?\u00d0\3\2"+
		"\2\2A\u00d4\3\2\2\2C\u00df\3\2\2\2E\u00e3\3\2\2\2G\u00ed\3\2\2\2I\u00f2"+
		"\3\2\2\2KL\7?\2\2L\4\3\2\2\2MN\7*\2\2N\6\3\2\2\2OP\7+\2\2P\b\3\2\2\2Q"+
		"R\7<\2\2R\n\3\2\2\2ST\7.\2\2T\f\3\2\2\2UV\7k\2\2VW\7p\2\2W\16\3\2\2\2"+
		"XY\7]\2\2Y\20\3\2\2\2Z[\7_\2\2[\22\3\2\2\2\\]\7h\2\2]^\7w\2\2^_\7p\2\2"+
		"_`\7e\2\2`\24\3\2\2\2ab\7p\2\2bc\7q\2\2cd\7v\2\2d\26\3\2\2\2ef\7c\2\2"+
		"fg\7p\2\2gk\7f\2\2hi\7q\2\2ik\7t\2\2je\3\2\2\2jh\3\2\2\2k\30\3\2\2\2l"+
		"v\t\2\2\2mn\7@\2\2nv\7?\2\2op\7>\2\2pv\7?\2\2qr\7?\2\2rv\7?\2\2st\7#\2"+
		"\2tv\7?\2\2ul\3\2\2\2um\3\2\2\2uo\3\2\2\2uq\3\2\2\2us\3\2\2\2v\32\3\2"+
		"\2\2wz\5#\22\2xz\5%\23\2yw\3\2\2\2yx\3\2\2\2z\34\3\2\2\2{|\t\3\2\2|\36"+
		"\3\2\2\2}~\7-\2\2~\177\7-\2\2\177 \3\2\2\2\u0080\u0081\7/\2\2\u0081\u0082"+
		"\7/\2\2\u0082\"\3\2\2\2\u0083\u0084\7-\2\2\u0084$\3\2\2\2\u0085\u0086"+
		"\7/\2\2\u0086&\3\2\2\2\u0087\u0088\7n\2\2\u0088\u0089\7k\2\2\u0089\u008a"+
		"\7u\2\2\u008a\u008b\7v\2\2\u008b(\3\2\2\2\u008c\u008d\7g\2\2\u008d\u008e"+
		"\7n\2\2\u008e\u008f\7g\2\2\u008f\u0090\7o\2\2\u0090\u0091\7g\2\2\u0091"+
		"\u0092\7p\2\2\u0092\u0093\7v\2\2\u0093*\3\2\2\2\u0094\u0095\7h\2\2\u0095"+
		"\u0096\7q\2\2\u0096\u0097\7t\2\2\u0097,\3\2\2\2\u0098\u0099\7y\2\2\u0099"+
		"\u009a\7j\2\2\u009a\u009b\7k\2\2\u009b\u009c\7n\2\2\u009c\u009d\7g\2\2"+
		"\u009d.\3\2\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7h\2\2\u00a0\60\3\2\2\2"+
		"\u00a1\u00a2\7g\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5"+
		"\7g\2\2\u00a5\62\3\2\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7y\2\2\u00a8\u00a9"+
		"\7k\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7e\2\2\u00ab\u00ac\7j\2\2\u00ac"+
		"\64\3\2\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7u\2\2\u00b0"+
		"\u00b1\7g\2\2\u00b1\66\3\2\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7g\2\2\u00b4"+
		"\u00b5\7v\2\2\u00b5\u00b6\7w\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7p\2\2"+
		"\u00b88\3\2\2\2\u00b9\u00ba\7d\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7g\2"+
		"\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7m\2\2\u00be:\3\2\2\2\u00bf\u00c0\7"+
		"e\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4"+
		"\7k\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7g\2\2\u00c7"+
		"<\3\2\2\2\u00c8\u00cc\t\4\2\2\u00c9\u00cb\t\5\2\2\u00ca\u00c9\3\2\2\2"+
		"\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd>\3"+
		"\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\t\6\2\2\u00d0\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3@\3\2\2\2"+
		"\u00d4\u00d8\7\f\2\2\u00d5\u00d7\7\13\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00da"+
		"\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00db\u00dc\b!\2\2\u00dcB\3\2\2\2\u00dd\u00e0\5I%\2\u00de"+
		"\u00e0\5E#\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2"+
		"\2\u00e1\u00e2\b\"\3\2\u00e2D\3\2\2\2\u00e3\u00e4\7\61\2\2\u00e4\u00e5"+
		"\7\61\2\2\u00e5\u00e9\3\2\2\2\u00e6\u00e8\n\7\2\2\u00e7\u00e6\3\2\2\2"+
		"\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00eaF\3"+
		"\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\t\b\2\2\u00ed\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0H\3\2\2\2"+
		"\u00f1\u00f3\t\t\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2"+
		"\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5J\3\2\2\2\r\2juy\u00cc\u00d2\u00d8\u00df"+
		"\u00e9\u00ef\u00f4\4\3!\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}