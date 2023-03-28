// Generated from d:\programing\Java\repos\Labs\LPIS_1\src\main\antlr4\antlr4\test.g4 by ANTLR 4.9.2

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
public class testLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, NUMBER=2, SKIP_=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "NUMBER", "SKIP_", "COMMENT", "TABS", "SPACES"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "NUMBER", "SKIP_"
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
				return next;
			}
			return buffer.poll();
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
		case 0:
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
			        bufferEmit(new CommonToken(testParser.END, "}"));
			    }
			    while(depth > lastDepth) {
			        lastDepth++;
			        bufferEmit(new CommonToken(testParser.BEGIN, "{"));
			    }
			   
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\5\64\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\2\3\2\3\3\6\3\32\n\3\r\3\16\3\33\3\4\3\4\5\4 \n\4\3\4\3\4\3\5"+
		"\3\5\7\5&\n\5\f\5\16\5)\13\5\3\6\6\6,\n\6\r\6\16\6-\3\7\6\7\61\n\7\r\7"+
		"\16\7\62\2\2\b\3\3\5\4\7\5\t\2\13\2\r\2\3\2\6\3\2\62;\4\2\f\f\16\17\3"+
		"\2\13\13\4\2\16\17\"\"\2\66\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\3\17\3"+
		"\2\2\2\5\31\3\2\2\2\7\37\3\2\2\2\t#\3\2\2\2\13+\3\2\2\2\r\60\3\2\2\2\17"+
		"\23\7\f\2\2\20\22\7\13\2\2\21\20\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23"+
		"\24\3\2\2\2\24\26\3\2\2\2\25\23\3\2\2\2\26\27\b\2\2\2\27\4\3\2\2\2\30"+
		"\32\t\2\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34"+
		"\6\3\2\2\2\35 \5\r\7\2\36 \5\t\5\2\37\35\3\2\2\2\37\36\3\2\2\2 !\3\2\2"+
		"\2!\"\b\4\3\2\"\b\3\2\2\2#\'\7%\2\2$&\n\3\2\2%$\3\2\2\2&)\3\2\2\2\'%\3"+
		"\2\2\2\'(\3\2\2\2(\n\3\2\2\2)\'\3\2\2\2*,\t\4\2\2+*\3\2\2\2,-\3\2\2\2"+
		"-+\3\2\2\2-.\3\2\2\2.\f\3\2\2\2/\61\t\5\2\2\60/\3\2\2\2\61\62\3\2\2\2"+
		"\62\60\3\2\2\2\62\63\3\2\2\2\63\16\3\2\2\2\t\2\23\33\37\'-\62\4\3\2\2"+
		"\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}