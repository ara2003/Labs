// Generated from d:\programing\Java\repos\Labs\LPIS_1\src\main\antlr4\antlr4\example.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class exampleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, FUNC=9, 
		PASS=10, NOT_OPERATION=11, LOGIC_OPERATION=12, COMPARE_OPERATION=13, MULT_OPERATION=14, 
		PLUS_OPERATION=15, MINUS_OPERATION=16, LIST=17, ELEMENT=18, FOR=19, WHILE=20, 
		IF=21, ELSE=22, SWITCH=23, DEFAULT=24, CASE=25, RETURN=26, BREAK=27, CONTINUE=28, 
		ID=29, NUMBER=30, NEWLINE=31, SKIP_=32, BEGIN=33, END=34, SUM_OPERATION=35;
	public static final int
		RULE_program = 0, RULE_code = 1, RULE_stmt = 2, RULE_passStat = 3, RULE_codeBlockStmt = 4, 
		RULE_assignStmt = 5, RULE_funcDefStmt = 6, RULE_paramiters = 7, RULE_paramiter = 8, 
		RULE_funcCallStmt = 9, RULE_whileStmt = 10, RULE_switchStmt = 11, RULE_caseStat = 12, 
		RULE_defaultStat = 13, RULE_forStmt = 14, RULE_ifStmt = 15, RULE_lvalue = 16, 
		RULE_rvalue = 17, RULE_logicExpr = 18, RULE_compareExpr = 19, RULE_sumExpr = 20, 
		RULE_multExpr = 21, RULE_unaryExpr = 22, RULE_prefix_unary_operation = 23, 
		RULE_atomExpr = 24, RULE_numberExpr = 25, RULE_newList = 26, RULE_rvalues = 27, 
		RULE_type = 28, RULE_breakStmt = 29, RULE_continueStmt = 30, RULE_returnStmt = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "code", "stmt", "passStat", "codeBlockStmt", "assignStmt", 
			"funcDefStmt", "paramiters", "paramiter", "funcCallStmt", "whileStmt", 
			"switchStmt", "caseStat", "defaultStat", "forStmt", "ifStmt", "lvalue", 
			"rvalue", "logicExpr", "compareExpr", "sumExpr", "multExpr", "unaryExpr", 
			"prefix_unary_operation", "atomExpr", "numberExpr", "newList", "rvalues", 
			"type", "breakStmt", "continueStmt", "returnStmt"
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
			"ID", "NUMBER", "NEWLINE", "SKIP_", "BEGIN", "END", "SUM_OPERATION"
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
	public String getGrammarFileName() { return "example.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public exampleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(exampleParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			code();
			setState(65);
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

	public static class CodeContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public PassStatContext passStat() {
			return getRuleContext(PassStatContext.class,0);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code);
		int _la;
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case FUNC:
			case FOR:
			case WHILE:
			case IF:
			case SWITCH:
			case RETURN:
			case BREAK:
			case CONTINUE:
			case ID:
			case BEGIN:
			case END:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNC) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << SWITCH) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID) | (1L << BEGIN))) != 0)) {
					{
					{
					setState(67);
					stmt();
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case PASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				passStat();
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

	public static class StmtContext extends ParserRuleContext {
		public FuncDefStmtContext funcDefStmt() {
			return getRuleContext(FuncDefStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public FuncCallStmtContext funcCallStmt() {
			return getRuleContext(FuncCallStmtContext.class,0);
		}
		public CodeBlockStmtContext codeBlockStmt() {
			return getRuleContext(CodeBlockStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public SwitchStmtContext switchStmt() {
			return getRuleContext(SwitchStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				funcDefStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				assignStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				forStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				ifStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				funcCallStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				codeBlockStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
				breakStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(84);
				continueStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(85);
				returnStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(86);
				switchStmt();
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

	public static class PassStatContext extends ParserRuleContext {
		public TerminalNode PASS() { return getToken(exampleParser.PASS, 0); }
		public PassStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passStat; }
	}

	public final PassStatContext passStat() throws RecognitionException {
		PassStatContext _localctx = new PassStatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_passStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(PASS);
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

	public static class CodeBlockStmtContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
		public CodeBlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlockStmt; }
	}

	public final CodeBlockStmtContext codeBlockStmt() throws RecognitionException {
		CodeBlockStmtContext _localctx = new CodeBlockStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_codeBlockStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(BEGIN);
			setState(92);
			code();
			setState(93);
			match(END);
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

	public static class AssignStmtContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			lvalue();
			setState(96);
			match(T__0);
			setState(97);
			rvalue();
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

	public static class FuncDefStmtContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(exampleParser.FUNC, 0); }
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public CodeBlockStmtContext codeBlockStmt() {
			return getRuleContext(CodeBlockStmtContext.class,0);
		}
		public ParamitersContext paramiters() {
			return getRuleContext(ParamitersContext.class,0);
		}
		public FuncDefStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefStmt; }
	}

	public final FuncDefStmtContext funcDefStmt() throws RecognitionException {
		FuncDefStmtContext _localctx = new FuncDefStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcDefStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(FUNC);
			setState(100);
			match(ID);
			setState(101);
			match(T__1);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LIST) | (1L << ELEMENT) | (1L << ID))) != 0)) {
				{
				setState(102);
				paramiters();
				}
			}

			setState(105);
			match(T__2);
			setState(106);
			match(T__3);
			setState(107);
			codeBlockStmt();
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

	public static class ParamitersContext extends ParserRuleContext {
		public List<ParamiterContext> paramiter() {
			return getRuleContexts(ParamiterContext.class);
		}
		public ParamiterContext paramiter(int i) {
			return getRuleContext(ParamiterContext.class,i);
		}
		public ParamitersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramiters; }
	}

	public final ParamitersContext paramiters() throws RecognitionException {
		ParamitersContext _localctx = new ParamitersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramiters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			paramiter();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(110);
				match(T__4);
				setState(111);
				paramiter();
				}
				}
				setState(116);
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

	public static class ParamiterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramiter; }
	}

	public final ParamiterContext paramiter() throws RecognitionException {
		ParamiterContext _localctx = new ParamiterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_paramiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIST || _la==ELEMENT) {
				{
				setState(117);
				type();
				}
			}

			setState(120);
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

	public static class FuncCallStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public RvaluesContext rvalues() {
			return getRuleContext(RvaluesContext.class,0);
		}
		public FuncCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallStmt; }
	}

	public final FuncCallStmtContext funcCallStmt() throws RecognitionException {
		FuncCallStmtContext _localctx = new FuncCallStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcCallStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ID);
			setState(123);
			match(T__1);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(124);
				rvalues();
				}
			}

			setState(127);
			match(T__2);
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(exampleParser.WHILE, 0); }
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public CodeBlockStmtContext codeBlockStmt() {
			return getRuleContext(CodeBlockStmtContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(WHILE);
			setState(130);
			rvalue();
			setState(131);
			match(T__3);
			setState(132);
			codeBlockStmt();
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

	public static class SwitchStmtContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(exampleParser.SWITCH, 0); }
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
		public List<CaseStatContext> caseStat() {
			return getRuleContexts(CaseStatContext.class);
		}
		public CaseStatContext caseStat(int i) {
			return getRuleContext(CaseStatContext.class,i);
		}
		public List<DefaultStatContext> defaultStat() {
			return getRuleContexts(DefaultStatContext.class);
		}
		public DefaultStatContext defaultStat(int i) {
			return getRuleContext(DefaultStatContext.class,i);
		}
		public SwitchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStmt; }
	}

	public final SwitchStmtContext switchStmt() throws RecognitionException {
		SwitchStmtContext _localctx = new SwitchStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_switchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(SWITCH);
			setState(135);
			rvalue();
			setState(136);
			match(T__3);
			setState(137);
			match(BEGIN);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFAULT || _la==CASE) {
				{
				setState(140);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CASE:
					{
					setState(138);
					caseStat();
					}
					break;
				case DEFAULT:
					{
					setState(139);
					defaultStat();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(END);
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

	public static class CaseStatContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(exampleParser.CASE, 0); }
		public TerminalNode NUMBER() { return getToken(exampleParser.NUMBER, 0); }
		public CodeBlockStmtContext codeBlockStmt() {
			return getRuleContext(CodeBlockStmtContext.class,0);
		}
		public CaseStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStat; }
	}

	public final CaseStatContext caseStat() throws RecognitionException {
		CaseStatContext _localctx = new CaseStatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_caseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(CASE);
			setState(148);
			match(NUMBER);
			setState(149);
			match(T__3);
			setState(150);
			codeBlockStmt();
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

	public static class DefaultStatContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(exampleParser.DEFAULT, 0); }
		public CodeBlockStmtContext codeBlockStmt() {
			return getRuleContext(CodeBlockStmtContext.class,0);
		}
		public DefaultStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultStat; }
	}

	public final DefaultStatContext defaultStat() throws RecognitionException {
		DefaultStatContext _localctx = new DefaultStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_defaultStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(DEFAULT);
			setState(153);
			match(T__3);
			setState(154);
			codeBlockStmt();
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

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(exampleParser.FOR, 0); }
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public CodeBlockStmtContext codeBlockStmt() {
			return getRuleContext(CodeBlockStmtContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(FOR);
			setState(157);
			match(ID);
			setState(158);
			match(T__5);
			setState(159);
			rvalue();
			setState(160);
			match(T__3);
			setState(161);
			codeBlockStmt();
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(exampleParser.IF, 0); }
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public CodeBlockStmtContext codeBlockStmt() {
			return getRuleContext(CodeBlockStmtContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(IF);
			setState(164);
			rvalue();
			setState(165);
			match(T__3);
			setState(166);
			codeBlockStmt();
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
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_lvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
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
		enterRule(_localctx, 34, RULE_rvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
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

	public static class LogicExprContext extends ParserRuleContext {
		public List<CompareExprContext> compareExpr() {
			return getRuleContexts(CompareExprContext.class);
		}
		public CompareExprContext compareExpr(int i) {
			return getRuleContext(CompareExprContext.class,i);
		}
		public List<TerminalNode> LOGIC_OPERATION() { return getTokens(exampleParser.LOGIC_OPERATION); }
		public TerminalNode LOGIC_OPERATION(int i) {
			return getToken(exampleParser.LOGIC_OPERATION, i);
		}
		public LogicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpr; }
	}

	public final LogicExprContext logicExpr() throws RecognitionException {
		LogicExprContext _localctx = new LogicExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_logicExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			compareExpr();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGIC_OPERATION) {
				{
				{
				setState(173);
				match(LOGIC_OPERATION);
				setState(174);
				compareExpr();
				}
				}
				setState(179);
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
		public List<TerminalNode> COMPARE_OPERATION() { return getTokens(exampleParser.COMPARE_OPERATION); }
		public TerminalNode COMPARE_OPERATION(int i) {
			return getToken(exampleParser.COMPARE_OPERATION, i);
		}
		public CompareExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareExpr; }
	}

	public final CompareExprContext compareExpr() throws RecognitionException {
		CompareExprContext _localctx = new CompareExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			sumExpr();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPARE_OPERATION) {
				{
				{
				setState(181);
				match(COMPARE_OPERATION);
				setState(182);
				sumExpr();
				}
				}
				setState(187);
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
		public List<TerminalNode> SUM_OPERATION() { return getTokens(exampleParser.SUM_OPERATION); }
		public TerminalNode SUM_OPERATION(int i) {
			return getToken(exampleParser.SUM_OPERATION, i);
		}
		public SumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumExpr; }
	}

	public final SumExprContext sumExpr() throws RecognitionException {
		SumExprContext _localctx = new SumExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sumExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			multExpr();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUM_OPERATION) {
				{
				{
				setState(189);
				match(SUM_OPERATION);
				setState(190);
				multExpr();
				}
				}
				setState(195);
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

	public static class MultExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public List<TerminalNode> MULT_OPERATION() { return getTokens(exampleParser.MULT_OPERATION); }
		public TerminalNode MULT_OPERATION(int i) {
			return getToken(exampleParser.MULT_OPERATION, i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			unaryExpr();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT_OPERATION) {
				{
				{
				setState(197);
				match(MULT_OPERATION);
				setState(198);
				unaryExpr();
				}
				}
				setState(203);
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

	public static class UnaryExprContext extends ParserRuleContext {
		public AtomExprContext atomExpr() {
			return getRuleContext(AtomExprContext.class,0);
		}
		public Prefix_unary_operationContext prefix_unary_operation() {
			return getRuleContext(Prefix_unary_operationContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_unaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION))) != 0)) {
				{
				setState(204);
				prefix_unary_operation();
				}
			}

			setState(207);
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

	public static class Prefix_unary_operationContext extends ParserRuleContext {
		public TerminalNode NOT_OPERATION() { return getToken(exampleParser.NOT_OPERATION, 0); }
		public TerminalNode PLUS_OPERATION() { return getToken(exampleParser.PLUS_OPERATION, 0); }
		public TerminalNode MINUS_OPERATION() { return getToken(exampleParser.MINUS_OPERATION, 0); }
		public Prefix_unary_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_unary_operation; }
	}

	public final Prefix_unary_operationContext prefix_unary_operation() throws RecognitionException {
		Prefix_unary_operationContext _localctx = new Prefix_unary_operationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_prefix_unary_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
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
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public AtomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpr; }
	}

	public final AtomExprContext atomExpr() throws RecognitionException {
		AtomExprContext _localctx = new AtomExprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_atomExpr);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				lvalue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				newList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
				numberExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(214);
				funcCallStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(215);
				match(T__1);
				setState(216);
				rvalue();
				setState(217);
				match(T__2);
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

	public static class NumberExprContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(exampleParser.NUMBER, 0); }
		public NumberExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberExpr; }
	}

	public final NumberExprContext numberExpr() throws RecognitionException {
		NumberExprContext _localctx = new NumberExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_numberExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
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

	public static class NewListContext extends ParserRuleContext {
		public RvaluesContext rvalues() {
			return getRuleContext(RvaluesContext.class,0);
		}
		public NewListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newList; }
	}

	public final NewListContext newList() throws RecognitionException {
		NewListContext _localctx = new NewListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_newList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__6);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(224);
				rvalues();
				}
			}

			setState(227);
			match(T__7);
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

	public static class RvaluesContext extends ParserRuleContext {
		public List<RvalueContext> rvalue() {
			return getRuleContexts(RvalueContext.class);
		}
		public RvalueContext rvalue(int i) {
			return getRuleContext(RvalueContext.class,i);
		}
		public RvaluesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rvalues; }
	}

	public final RvaluesContext rvalues() throws RecognitionException {
		RvaluesContext _localctx = new RvaluesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rvalues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			rvalue();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(230);
				match(T__4);
				setState(231);
				rvalue();
				}
				}
				setState(236);
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
		public TerminalNode ELEMENT() { return getToken(exampleParser.ELEMENT, 0); }
		public TerminalNode LIST() { return getToken(exampleParser.LIST, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
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

	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(exampleParser.BREAK, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(BREAK);
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

	public static class ContinueStmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(exampleParser.CONTINUE, 0); }
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(CONTINUE);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(exampleParser.RETURN, 0); }
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(RETURN);
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(244);
				rvalue();
				}
				break;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00fa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\3\7\3G\n\3\f\3\16\3J\13\3\3\3\5\3M\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4Z\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\5\bj\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\ts\n"+
		"\t\f\t\16\tv\13\t\3\n\5\ny\n\n\3\n\3\n\3\13\3\13\3\13\5\13\u0080\n\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u008f\n\r\f"+
		"\r\16\r\u0092\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\7\24\u00b2\n\24\f\24\16\24\u00b5\13\24\3\25"+
		"\3\25\3\25\7\25\u00ba\n\25\f\25\16\25\u00bd\13\25\3\26\3\26\3\26\7\26"+
		"\u00c2\n\26\f\26\16\26\u00c5\13\26\3\27\3\27\3\27\7\27\u00ca\n\27\f\27"+
		"\16\27\u00cd\13\27\3\30\5\30\u00d0\n\30\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00de\n\32\3\33\3\33\3\34\3\34\5\34"+
		"\u00e4\n\34\3\34\3\34\3\35\3\35\3\35\7\35\u00eb\n\35\f\35\16\35\u00ee"+
		"\13\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\5!\u00f8\n!\3!\2\2\"\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\4\4\2\r\r\21"+
		"\22\3\2\23\24\2\u00f7\2B\3\2\2\2\4L\3\2\2\2\6Y\3\2\2\2\b[\3\2\2\2\n]\3"+
		"\2\2\2\fa\3\2\2\2\16e\3\2\2\2\20o\3\2\2\2\22x\3\2\2\2\24|\3\2\2\2\26\u0083"+
		"\3\2\2\2\30\u0088\3\2\2\2\32\u0095\3\2\2\2\34\u009a\3\2\2\2\36\u009e\3"+
		"\2\2\2 \u00a5\3\2\2\2\"\u00aa\3\2\2\2$\u00ac\3\2\2\2&\u00ae\3\2\2\2(\u00b6"+
		"\3\2\2\2*\u00be\3\2\2\2,\u00c6\3\2\2\2.\u00cf\3\2\2\2\60\u00d3\3\2\2\2"+
		"\62\u00dd\3\2\2\2\64\u00df\3\2\2\2\66\u00e1\3\2\2\28\u00e7\3\2\2\2:\u00ef"+
		"\3\2\2\2<\u00f1\3\2\2\2>\u00f3\3\2\2\2@\u00f5\3\2\2\2BC\5\4\3\2CD\7\2"+
		"\2\3D\3\3\2\2\2EG\5\6\4\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IM\3"+
		"\2\2\2JH\3\2\2\2KM\5\b\5\2LH\3\2\2\2LK\3\2\2\2M\5\3\2\2\2NZ\5\16\b\2O"+
		"Z\5\f\7\2PZ\5\26\f\2QZ\5\36\20\2RZ\5 \21\2SZ\5\24\13\2TZ\5\n\6\2UZ\5<"+
		"\37\2VZ\5> \2WZ\5@!\2XZ\5\30\r\2YN\3\2\2\2YO\3\2\2\2YP\3\2\2\2YQ\3\2\2"+
		"\2YR\3\2\2\2YS\3\2\2\2YT\3\2\2\2YU\3\2\2\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2"+
		"\2Z\7\3\2\2\2[\\\7\f\2\2\\\t\3\2\2\2]^\7#\2\2^_\5\4\3\2_`\7$\2\2`\13\3"+
		"\2\2\2ab\5\"\22\2bc\7\3\2\2cd\5$\23\2d\r\3\2\2\2ef\7\13\2\2fg\7\37\2\2"+
		"gi\7\4\2\2hj\5\20\t\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\5\2\2lm\7\6\2"+
		"\2mn\5\n\6\2n\17\3\2\2\2ot\5\22\n\2pq\7\7\2\2qs\5\22\n\2rp\3\2\2\2sv\3"+
		"\2\2\2tr\3\2\2\2tu\3\2\2\2u\21\3\2\2\2vt\3\2\2\2wy\5:\36\2xw\3\2\2\2x"+
		"y\3\2\2\2yz\3\2\2\2z{\7\37\2\2{\23\3\2\2\2|}\7\37\2\2}\177\7\4\2\2~\u0080"+
		"\58\35\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082"+
		"\7\5\2\2\u0082\25\3\2\2\2\u0083\u0084\7\26\2\2\u0084\u0085\5$\23\2\u0085"+
		"\u0086\7\6\2\2\u0086\u0087\5\n\6\2\u0087\27\3\2\2\2\u0088\u0089\7\31\2"+
		"\2\u0089\u008a\5$\23\2\u008a\u008b\7\6\2\2\u008b\u0090\7#\2\2\u008c\u008f"+
		"\5\32\16\2\u008d\u008f\5\34\17\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2"+
		"\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7$\2\2\u0094\31\3\2\2\2\u0095"+
		"\u0096\7\33\2\2\u0096\u0097\7 \2\2\u0097\u0098\7\6\2\2\u0098\u0099\5\n"+
		"\6\2\u0099\33\3\2\2\2\u009a\u009b\7\32\2\2\u009b\u009c\7\6\2\2\u009c\u009d"+
		"\5\n\6\2\u009d\35\3\2\2\2\u009e\u009f\7\25\2\2\u009f\u00a0\7\37\2\2\u00a0"+
		"\u00a1\7\b\2\2\u00a1\u00a2\5$\23\2\u00a2\u00a3\7\6\2\2\u00a3\u00a4\5\n"+
		"\6\2\u00a4\37\3\2\2\2\u00a5\u00a6\7\27\2\2\u00a6\u00a7\5$\23\2\u00a7\u00a8"+
		"\7\6\2\2\u00a8\u00a9\5\n\6\2\u00a9!\3\2\2\2\u00aa\u00ab\7\37\2\2\u00ab"+
		"#\3\2\2\2\u00ac\u00ad\5&\24\2\u00ad%\3\2\2\2\u00ae\u00b3\5(\25\2\u00af"+
		"\u00b0\7\16\2\2\u00b0\u00b2\5(\25\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3"+
		"\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\'\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00bb\5*\26\2\u00b7\u00b8\7\17\2\2\u00b8\u00ba\5*\26\2"+
		"\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc)\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c3\5,\27\2\u00bf"+
		"\u00c0\7%\2\2\u00c0\u00c2\5,\27\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4+\3\2\2\2\u00c5\u00c3"+
		"\3\2\2\2\u00c6\u00cb\5.\30\2\u00c7\u00c8\7\20\2\2\u00c8\u00ca\5.\30\2"+
		"\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc"+
		"\3\2\2\2\u00cc-\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\5\60\31\2\u00cf"+
		"\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\5\62"+
		"\32\2\u00d2/\3\2\2\2\u00d3\u00d4\t\2\2\2\u00d4\61\3\2\2\2\u00d5\u00de"+
		"\5\"\22\2\u00d6\u00de\5\66\34\2\u00d7\u00de\5\64\33\2\u00d8\u00de\5\24"+
		"\13\2\u00d9\u00da\7\4\2\2\u00da\u00db\5$\23\2\u00db\u00dc\7\5\2\2\u00dc"+
		"\u00de\3\2\2\2\u00dd\u00d5\3\2\2\2\u00dd\u00d6\3\2\2\2\u00dd\u00d7\3\2"+
		"\2\2\u00dd\u00d8\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\63\3\2\2\2\u00df\u00e0"+
		"\7 \2\2\u00e0\65\3\2\2\2\u00e1\u00e3\7\t\2\2\u00e2\u00e4\58\35\2\u00e3"+
		"\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\7\n"+
		"\2\2\u00e6\67\3\2\2\2\u00e7\u00ec\5$\23\2\u00e8\u00e9\7\7\2\2\u00e9\u00eb"+
		"\5$\23\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed9\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\t\3\2\2"+
		"\u00f0;\3\2\2\2\u00f1\u00f2\7\35\2\2\u00f2=\3\2\2\2\u00f3\u00f4\7\36\2"+
		"\2\u00f4?\3\2\2\2\u00f5\u00f7\7\34\2\2\u00f6\u00f8\5$\23\2\u00f7\u00f6"+
		"\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8A\3\2\2\2\24HLYitx\177\u008e\u0090\u00b3"+
		"\u00bb\u00c3\u00cb\u00cf\u00dd\u00e3\u00ec\u00f7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}