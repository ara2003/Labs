// Generated from d:\programing\Java\repos\Labs\LPIS_1\src\main\antlr4\antlr4\test.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testParser extends Parser {
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
	public static final int
		RULE_funcCallStmt = 0, RULE_numberExpr = 1, RULE_inBracketsRvalue = 2, 
		RULE_atomExpr = 3, RULE_unaryExpr = 4, RULE_multExpr = 5, RULE_sumExpr = 6, 
		RULE_compareExpr = 7, RULE_logicExpr = 8, RULE_rvalue = 9, RULE_lvalue = 10, 
		RULE_varName = 11, RULE_list_index = 12, RULE_unaryExprPrefix = 13, RULE_newList = 14, 
		RULE_arguments = 15, RULE_type = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"funcCallStmt", "numberExpr", "inBracketsRvalue", "atomExpr", "unaryExpr", 
			"multExpr", "sumExpr", "compareExpr", "logicExpr", "rvalue", "lvalue", 
			"varName", "list_index", "unaryExprPrefix", "newList", "arguments", "type"
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

	@Override
	public String getGrammarFileName() { return "test.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public testParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FuncCallStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(testParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FuncCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallStmt; }
	}

	public final FuncCallStmtContext funcCallStmt() throws RecognitionException {
		FuncCallStmtContext _localctx = new FuncCallStmtContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_funcCallStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(ID);
			setState(35);
			match(T__0);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(36);
				arguments();
				}
			}

			setState(39);
			match(T__1);
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

	public static class NumberExprContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(testParser.NUMBER, 0); }
		public NumberExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberExpr; }
	}

	public final NumberExprContext numberExpr() throws RecognitionException {
		NumberExprContext _localctx = new NumberExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_numberExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(NUMBER);
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

	public static class InBracketsRvalueContext extends ParserRuleContext {
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public InBracketsRvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inBracketsRvalue; }
	}

	public final InBracketsRvalueContext inBracketsRvalue() throws RecognitionException {
		InBracketsRvalueContext _localctx = new InBracketsRvalueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_inBracketsRvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__0);
			setState(44);
			rvalue();
			setState(45);
			match(T__1);
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

	public static class AtomExprContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public NewListContext newList() {
			return getRuleContext(NewListContext.class,0);
		}
		public NumberExprContext numberExpr() {
			return getRuleContext(NumberExprContext.class,0);
		}
		public FuncCallStmtContext funcCallStmt() {
			return getRuleContext(FuncCallStmtContext.class,0);
		}
		public InBracketsRvalueContext inBracketsRvalue() {
			return getRuleContext(InBracketsRvalueContext.class,0);
		}
		public AtomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpr; }
	}

	public final AtomExprContext atomExpr() throws RecognitionException {
		AtomExprContext _localctx = new AtomExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atomExpr);
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				lvalue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				newList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				numberExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				funcCallStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				inBracketsRvalue();
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

	public static class UnaryExprContext extends ParserRuleContext {
		public AtomExprContext atomExpr() {
			return getRuleContext(AtomExprContext.class,0);
		}
		public UnaryExprPrefixContext unaryExprPrefix() {
			return getRuleContext(UnaryExprPrefixContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION))) != 0)) {
				{
				setState(54);
				unaryExprPrefix();
				}
			}

			setState(57);
			atomExpr();
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

	public static class MultExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public List<TerminalNode> MULT_OPERATION() { return getTokens(testParser.MULT_OPERATION); }
		public TerminalNode MULT_OPERATION(int i) {
			return getToken(testParser.MULT_OPERATION, i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			unaryExpr();
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT_OPERATION) {
				{
				{
				setState(60);
				match(MULT_OPERATION);
				setState(61);
				unaryExpr();
				}
				}
				setState(66);
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

	public static class SumExprContext extends ParserRuleContext {
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public List<TerminalNode> PLUS_OPERATION() { return getTokens(testParser.PLUS_OPERATION); }
		public TerminalNode PLUS_OPERATION(int i) {
			return getToken(testParser.PLUS_OPERATION, i);
		}
		public List<TerminalNode> MINUS_OPERATION() { return getTokens(testParser.MINUS_OPERATION); }
		public TerminalNode MINUS_OPERATION(int i) {
			return getToken(testParser.MINUS_OPERATION, i);
		}
		public SumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumExpr; }
	}

	public final SumExprContext sumExpr() throws RecognitionException {
		SumExprContext _localctx = new SumExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sumExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			multExpr();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS_OPERATION || _la==MINUS_OPERATION) {
				{
				{
				setState(68);
				_la = _input.LA(1);
				if ( !(_la==PLUS_OPERATION || _la==MINUS_OPERATION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(69);
				multExpr();
				}
				}
				setState(74);
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

	public static class CompareExprContext extends ParserRuleContext {
		public List<SumExprContext> sumExpr() {
			return getRuleContexts(SumExprContext.class);
		}
		public SumExprContext sumExpr(int i) {
			return getRuleContext(SumExprContext.class,i);
		}
		public List<TerminalNode> COMPARE_OPERATION() { return getTokens(testParser.COMPARE_OPERATION); }
		public TerminalNode COMPARE_OPERATION(int i) {
			return getToken(testParser.COMPARE_OPERATION, i);
		}
		public CompareExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareExpr; }
	}

	public final CompareExprContext compareExpr() throws RecognitionException {
		CompareExprContext _localctx = new CompareExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			sumExpr();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPARE_OPERATION) {
				{
				{
				setState(76);
				match(COMPARE_OPERATION);
				setState(77);
				sumExpr();
				}
				}
				setState(82);
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

	public static class LogicExprContext extends ParserRuleContext {
		public List<CompareExprContext> compareExpr() {
			return getRuleContexts(CompareExprContext.class);
		}
		public CompareExprContext compareExpr(int i) {
			return getRuleContext(CompareExprContext.class,i);
		}
		public List<TerminalNode> LOGIC_OPERATION() { return getTokens(testParser.LOGIC_OPERATION); }
		public TerminalNode LOGIC_OPERATION(int i) {
			return getToken(testParser.LOGIC_OPERATION, i);
		}
		public LogicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpr; }
	}

	public final LogicExprContext logicExpr() throws RecognitionException {
		LogicExprContext _localctx = new LogicExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logicExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			compareExpr();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGIC_OPERATION) {
				{
				{
				setState(84);
				match(LOGIC_OPERATION);
				setState(85);
				compareExpr();
				}
				}
				setState(90);
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

	public static class RvalueContext extends ParserRuleContext {
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public RvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rvalue; }
	}

	public final RvalueContext rvalue() throws RecognitionException {
		RvalueContext _localctx = new RvalueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			logicExpr();
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

	public static class LvalueContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public List_indexContext list_index() {
			return getRuleContext(List_indexContext.class,0);
		}
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lvalue);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				varName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				varName();
				setState(95);
				list_index();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(T__0);
				setState(98);
				rvalue();
				setState(99);
				match(T__1);
				setState(100);
				list_index();
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

	public static class VarNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(testParser.ID, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(ID);
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

	public static class List_indexContext extends ParserRuleContext {
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public List_indexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_index; }
	}

	public final List_indexContext list_index() throws RecognitionException {
		List_indexContext _localctx = new List_indexContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_list_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__2);
			setState(107);
			rvalue();
			setState(108);
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

	public static class UnaryExprPrefixContext extends ParserRuleContext {
		public TerminalNode NOT_OPERATION() { return getToken(testParser.NOT_OPERATION, 0); }
		public TerminalNode PLUS_OPERATION() { return getToken(testParser.PLUS_OPERATION, 0); }
		public TerminalNode MINUS_OPERATION() { return getToken(testParser.MINUS_OPERATION, 0); }
		public UnaryExprPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExprPrefix; }
	}

	public final UnaryExprPrefixContext unaryExprPrefix() throws RecognitionException {
		UnaryExprPrefixContext _localctx = new UnaryExprPrefixContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unaryExprPrefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class NewListContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public NewListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newList; }
	}

	public final NewListContext newList() throws RecognitionException {
		NewListContext _localctx = new NewListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_newList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__2);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(113);
				arguments();
				}
			}

			setState(116);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<RvalueContext> rvalue() {
			return getRuleContexts(RvalueContext.class);
		}
		public RvalueContext rvalue(int i) {
			return getRuleContext(RvalueContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			rvalue();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(119);
				match(T__4);
				setState(120);
				rvalue();
				}
				}
				setState(125);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ELEMENT() { return getToken(testParser.ELEMENT, 0); }
		public TerminalNode LIST() { return getToken(testParser.LIST, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==LIST || _la==ELEMENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\5\2(\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\5\5\67\n\5\3\6\5\6:\n\6\3\6\3\6\3\7\3\7\3\7\7\7A\n\7\f\7\16\7D\13"+
		"\7\3\b\3\b\3\b\7\bI\n\b\f\b\16\bL\13\b\3\t\3\t\3\t\7\tQ\n\t\f\t\16\tT"+
		"\13\t\3\n\3\n\3\n\7\nY\n\n\f\n\16\n\\\13\n\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\fi\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\5\20u\n\20\3\20\3\20\3\21\3\21\3\21\7\21|\n\21\f\21\16\21\177\13"+
		"\21\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2"+
		"\5\3\2\16\17\4\2\n\n\16\17\3\2\20\21\2\177\2$\3\2\2\2\4+\3\2\2\2\6-\3"+
		"\2\2\2\b\66\3\2\2\2\n9\3\2\2\2\f=\3\2\2\2\16E\3\2\2\2\20M\3\2\2\2\22U"+
		"\3\2\2\2\24]\3\2\2\2\26h\3\2\2\2\30j\3\2\2\2\32l\3\2\2\2\34p\3\2\2\2\36"+
		"r\3\2\2\2 x\3\2\2\2\"\u0080\3\2\2\2$%\7\34\2\2%\'\7\3\2\2&(\5 \21\2\'"+
		"&\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\4\2\2*\3\3\2\2\2+,\7\35\2\2,\5\3\2"+
		"\2\2-.\7\3\2\2./\5\24\13\2/\60\7\4\2\2\60\7\3\2\2\2\61\67\5\26\f\2\62"+
		"\67\5\36\20\2\63\67\5\4\3\2\64\67\5\2\2\2\65\67\5\6\4\2\66\61\3\2\2\2"+
		"\66\62\3\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67\t\3\2\2\2"+
		"8:\5\34\17\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\5\b\5\2<\13\3\2\2\2=B\5\n"+
		"\6\2>?\7\r\2\2?A\5\n\6\2@>\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\r\3"+
		"\2\2\2DB\3\2\2\2EJ\5\f\7\2FG\t\2\2\2GI\5\f\7\2HF\3\2\2\2IL\3\2\2\2JH\3"+
		"\2\2\2JK\3\2\2\2K\17\3\2\2\2LJ\3\2\2\2MR\5\16\b\2NO\7\f\2\2OQ\5\16\b\2"+
		"PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\21\3\2\2\2TR\3\2\2\2UZ\5\20"+
		"\t\2VW\7\13\2\2WY\5\20\t\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\23"+
		"\3\2\2\2\\Z\3\2\2\2]^\5\22\n\2^\25\3\2\2\2_i\5\30\r\2`a\5\30\r\2ab\5\32"+
		"\16\2bi\3\2\2\2cd\7\3\2\2de\5\24\13\2ef\7\4\2\2fg\5\32\16\2gi\3\2\2\2"+
		"h_\3\2\2\2h`\3\2\2\2hc\3\2\2\2i\27\3\2\2\2jk\7\34\2\2k\31\3\2\2\2lm\7"+
		"\5\2\2mn\5\24\13\2no\7\6\2\2o\33\3\2\2\2pq\t\3\2\2q\35\3\2\2\2rt\7\5\2"+
		"\2su\5 \21\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7\6\2\2w\37\3\2\2\2x}\5\24"+
		"\13\2yz\7\7\2\2z|\5\24\13\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2"+
		"~!\3\2\2\2\177}\3\2\2\2\u0080\u0081\t\4\2\2\u0081#\3\2\2\2\f\'\669BJR"+
		"Zht}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}