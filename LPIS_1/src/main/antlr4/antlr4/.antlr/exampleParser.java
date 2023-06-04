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
		ID=29, NUMBER=30, NEWLINE=31, SKIP_=32, BEGIN=33, END=34;
	public static final int
		RULE_program = 0, RULE_code = 1, RULE_stmt = 2, RULE_passStat = 3, RULE_codeBlockStmt = 4, 
		RULE_assignStmt = 5, RULE_funcDefStmt = 6, RULE_paramiters = 7, RULE_paramiter = 8, 
		RULE_funcCallStmt = 9, RULE_whileStmt = 10, RULE_switchStmt = 11, RULE_caseStat = 12, 
		RULE_defaultStat = 13, RULE_forStmt = 14, RULE_ifStmt = 15, RULE_elseStmt = 16, 
		RULE_breakStmt = 17, RULE_continueStmt = 18, RULE_returnStmt = 19, RULE_funcCallExpr = 20, 
		RULE_numberExpr = 21, RULE_inBracketsRvalue = 22, RULE_atomExpr = 23, 
		RULE_unaryExpr = 24, RULE_multExpr = 25, RULE_sumExpr = 26, RULE_compareExpr = 27, 
		RULE_logicExpr = 28, RULE_rvalue = 29, RULE_lvalue = 30, RULE_varName = 31, 
		RULE_listIndex = 32, RULE_unaryExprPrefix = 33, RULE_newList = 34, RULE_arguments = 35, 
		RULE_type = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "code", "stmt", "passStat", "codeBlockStmt", "assignStmt", 
			"funcDefStmt", "paramiters", "paramiter", "funcCallStmt", "whileStmt", 
			"switchStmt", "caseStat", "defaultStat", "forStmt", "ifStmt", "elseStmt", 
			"breakStmt", "continueStmt", "returnStmt", "funcCallExpr", "numberExpr", 
			"inBracketsRvalue", "atomExpr", "unaryExpr", "multExpr", "sumExpr", "compareExpr", 
			"logicExpr", "rvalue", "lvalue", "varName", "listIndex", "unaryExprPrefix", 
			"newList", "arguments", "type"
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
			"ID", "NUMBER", "NEWLINE", "SKIP_", "BEGIN", "END"
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
			setState(74);
			code();
			setState(75);
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
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case T__1:
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
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << FUNC) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << SWITCH) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID) | (1L << BEGIN))) != 0)) {
					{
					{
					setState(77);
					stmt();
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case PASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
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
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				funcDefStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				assignStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				forStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(90);
				ifStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				funcCallStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(92);
				codeBlockStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				breakStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(94);
				continueStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(95);
				returnStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(96);
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
			setState(99);
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
			setState(101);
			match(BEGIN);
			setState(102);
			code();
			setState(103);
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
			setState(105);
			lvalue();
			setState(106);
			match(T__0);
			setState(107);
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
		public ParamitersContext paramiters() {
			return getRuleContext(ParamitersContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
		public FuncDefStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefStmt; }
	}

	public final FuncDefStmtContext funcDefStmt() throws RecognitionException {
		FuncDefStmtContext _localctx = new FuncDefStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcDefStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(FUNC);
			setState(110);
			match(ID);
			setState(111);
			match(T__1);
			setState(112);
			paramiters();
			setState(113);
			match(T__2);
			setState(114);
			match(T__3);
			setState(115);
			match(BEGIN);
			setState(116);
			code();
			setState(117);
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
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LIST) | (1L << ELEMENT) | (1L << ID))) != 0)) {
				{
				setState(119);
				paramiter();
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(120);
					match(T__4);
					setState(121);
					paramiter();
					}
					}
					setState(126);
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
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIST || _la==ELEMENT) {
				{
				setState(129);
				type();
				}
			}

			setState(132);
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
		public FuncCallExprContext funcCallExpr() {
			return getRuleContext(FuncCallExprContext.class,0);
		}
		public FuncCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallStmt; }
	}

	public final FuncCallStmtContext funcCallStmt() throws RecognitionException {
		FuncCallStmtContext _localctx = new FuncCallStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcCallStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			funcCallExpr();
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
			setState(136);
			match(WHILE);
			setState(137);
			rvalue();
			setState(138);
			match(T__3);
			setState(139);
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
		public DefaultStatContext defaultStat() {
			return getRuleContext(DefaultStatContext.class,0);
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
			setState(141);
			match(SWITCH);
			setState(142);
			rvalue();
			setState(143);
			match(T__3);
			setState(144);
			match(BEGIN);
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(145);
				caseStat();
				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE );
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(150);
				defaultStat();
				}
			}

			setState(153);
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
			setState(155);
			match(CASE);
			setState(156);
			match(NUMBER);
			setState(157);
			match(T__3);
			setState(158);
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
			setState(160);
			match(DEFAULT);
			setState(161);
			match(T__3);
			setState(162);
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
			setState(164);
			match(FOR);
			setState(165);
			match(ID);
			setState(166);
			match(T__5);
			setState(167);
			rvalue();
			setState(168);
			match(T__3);
			setState(169);
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
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(IF);
			setState(172);
			rvalue();
			setState(173);
			match(T__3);
			setState(174);
			codeBlockStmt();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(175);
				elseStmt();
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

	public static class ElseStmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(exampleParser.ELSE, 0); }
		public CodeBlockStmtContext codeBlockStmt() {
			return getRuleContext(CodeBlockStmtContext.class,0);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(ELSE);
			setState(179);
			match(T__3);
			setState(180);
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

	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(exampleParser.BREAK, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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
		enterRule(_localctx, 36, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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
		enterRule(_localctx, 38, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(RETURN);
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(187);
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

	public static class FuncCallExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FuncCallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallExpr; }
	}

	public final FuncCallExprContext funcCallExpr() throws RecognitionException {
		FuncCallExprContext _localctx = new FuncCallExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funcCallExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(ID);
			setState(191);
			match(T__1);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(192);
				arguments();
				}
			}

			setState(195);
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

	public static class NumberExprContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(exampleParser.NUMBER, 0); }
		public NumberExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberExpr; }
	}

	public final NumberExprContext numberExpr() throws RecognitionException {
		NumberExprContext _localctx = new NumberExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_numberExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
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
		enterRule(_localctx, 44, RULE_inBracketsRvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__1);
			setState(200);
			rvalue();
			setState(201);
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
		public FuncCallExprContext funcCallExpr() {
			return getRuleContext(FuncCallExprContext.class,0);
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
		enterRule(_localctx, 46, RULE_atomExpr);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				lvalue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				newList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				numberExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				funcCallExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(207);
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
		enterRule(_localctx, 48, RULE_unaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION))) != 0)) {
				{
				setState(210);
				unaryExprPrefix();
				}
			}

			setState(213);
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
		enterRule(_localctx, 50, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			unaryExpr();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT_OPERATION) {
				{
				{
				setState(216);
				match(MULT_OPERATION);
				setState(217);
				unaryExpr();
				}
				}
				setState(222);
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
		public List<TerminalNode> PLUS_OPERATION() { return getTokens(exampleParser.PLUS_OPERATION); }
		public TerminalNode PLUS_OPERATION(int i) {
			return getToken(exampleParser.PLUS_OPERATION, i);
		}
		public List<TerminalNode> MINUS_OPERATION() { return getTokens(exampleParser.MINUS_OPERATION); }
		public TerminalNode MINUS_OPERATION(int i) {
			return getToken(exampleParser.MINUS_OPERATION, i);
		}
		public SumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumExpr; }
	}

	public final SumExprContext sumExpr() throws RecognitionException {
		SumExprContext _localctx = new SumExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_sumExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			multExpr();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS_OPERATION || _la==MINUS_OPERATION) {
				{
				{
				setState(224);
				_la = _input.LA(1);
				if ( !(_la==PLUS_OPERATION || _la==MINUS_OPERATION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(225);
				multExpr();
				}
				}
				setState(230);
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
		enterRule(_localctx, 54, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			sumExpr();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPARE_OPERATION) {
				{
				{
				setState(232);
				match(COMPARE_OPERATION);
				setState(233);
				sumExpr();
				}
				}
				setState(238);
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
		enterRule(_localctx, 56, RULE_logicExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			compareExpr();
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGIC_OPERATION) {
				{
				{
				setState(240);
				match(LOGIC_OPERATION);
				setState(241);
				compareExpr();
				}
				}
				setState(246);
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
		enterRule(_localctx, 58, RULE_rvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
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
		public ListIndexContext listIndex() {
			return getRuleContext(ListIndexContext.class,0);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_lvalue);
		try {
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				varName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				listIndex();
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
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
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

	public static class ListIndexContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public List<RvalueContext> rvalue() {
			return getRuleContexts(RvalueContext.class);
		}
		public RvalueContext rvalue(int i) {
			return getRuleContext(RvalueContext.class,i);
		}
		public ListIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listIndex; }
	}

	public final ListIndexContext listIndex() throws RecognitionException {
		ListIndexContext _localctx = new ListIndexContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_listIndex);
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				varName();
				setState(256);
				match(T__6);
				setState(257);
				rvalue();
				setState(258);
				match(T__7);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(T__1);
				setState(261);
				rvalue();
				setState(262);
				match(T__2);
				setState(263);
				match(T__6);
				setState(264);
				rvalue();
				setState(265);
				match(T__7);
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

	public static class UnaryExprPrefixContext extends ParserRuleContext {
		public TerminalNode NOT_OPERATION() { return getToken(exampleParser.NOT_OPERATION, 0); }
		public TerminalNode PLUS_OPERATION() { return getToken(exampleParser.PLUS_OPERATION, 0); }
		public TerminalNode MINUS_OPERATION() { return getToken(exampleParser.MINUS_OPERATION, 0); }
		public UnaryExprPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExprPrefix; }
	}

	public final UnaryExprPrefixContext unaryExprPrefix() throws RecognitionException {
		UnaryExprPrefixContext _localctx = new UnaryExprPrefixContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_unaryExprPrefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
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
		enterRule(_localctx, 68, RULE_newList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(T__6);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(272);
				arguments();
				}
			}

			setState(275);
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
		enterRule(_localctx, 70, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			rvalue();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(278);
				match(T__4);
				setState(279);
				rvalue();
				}
				}
				setState(284);
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
		enterRule(_localctx, 72, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0122\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\3\7\3Q\n\3\f\3\16\3"+
		"T\13\3\3\3\5\3W\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4d\n"+
		"\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\5\t\u0082\n\t\3"+
		"\n\5\n\u0085\n\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\6\r\u0095\n\r\r\r\16\r\u0096\3\r\5\r\u009a\n\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u00b3\n\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\5\25\u00bf\n\25\3\26\3\26\3\26\5\26\u00c4\n\26\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u00d3"+
		"\n\31\3\32\5\32\u00d6\n\32\3\32\3\32\3\33\3\33\3\33\7\33\u00dd\n\33\f"+
		"\33\16\33\u00e0\13\33\3\34\3\34\3\34\7\34\u00e5\n\34\f\34\16\34\u00e8"+
		"\13\34\3\35\3\35\3\35\7\35\u00ed\n\35\f\35\16\35\u00f0\13\35\3\36\3\36"+
		"\3\36\7\36\u00f5\n\36\f\36\16\36\u00f8\13\36\3\37\3\37\3 \3 \5 \u00fe"+
		"\n \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u010e\n"+
		"\"\3#\3#\3$\3$\5$\u0114\n$\3$\3$\3%\3%\3%\7%\u011b\n%\f%\16%\u011e\13"+
		"%\3&\3&\3&\2\2\'\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJ\2\5\3\2\21\22\4\2\r\r\21\22\3\2\23\24\2\u011d\2L\3\2"+
		"\2\2\4V\3\2\2\2\6c\3\2\2\2\be\3\2\2\2\ng\3\2\2\2\fk\3\2\2\2\16o\3\2\2"+
		"\2\20\u0081\3\2\2\2\22\u0084\3\2\2\2\24\u0088\3\2\2\2\26\u008a\3\2\2\2"+
		"\30\u008f\3\2\2\2\32\u009d\3\2\2\2\34\u00a2\3\2\2\2\36\u00a6\3\2\2\2 "+
		"\u00ad\3\2\2\2\"\u00b4\3\2\2\2$\u00b8\3\2\2\2&\u00ba\3\2\2\2(\u00bc\3"+
		"\2\2\2*\u00c0\3\2\2\2,\u00c7\3\2\2\2.\u00c9\3\2\2\2\60\u00d2\3\2\2\2\62"+
		"\u00d5\3\2\2\2\64\u00d9\3\2\2\2\66\u00e1\3\2\2\28\u00e9\3\2\2\2:\u00f1"+
		"\3\2\2\2<\u00f9\3\2\2\2>\u00fd\3\2\2\2@\u00ff\3\2\2\2B\u010d\3\2\2\2D"+
		"\u010f\3\2\2\2F\u0111\3\2\2\2H\u0117\3\2\2\2J\u011f\3\2\2\2LM\5\4\3\2"+
		"MN\7\2\2\3N\3\3\2\2\2OQ\5\6\4\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2"+
		"\2SW\3\2\2\2TR\3\2\2\2UW\5\b\5\2VR\3\2\2\2VU\3\2\2\2W\5\3\2\2\2Xd\5\16"+
		"\b\2Yd\5\f\7\2Zd\5\26\f\2[d\5\36\20\2\\d\5 \21\2]d\5\24\13\2^d\5\n\6\2"+
		"_d\5$\23\2`d\5&\24\2ad\5(\25\2bd\5\30\r\2cX\3\2\2\2cY\3\2\2\2cZ\3\2\2"+
		"\2c[\3\2\2\2c\\\3\2\2\2c]\3\2\2\2c^\3\2\2\2c_\3\2\2\2c`\3\2\2\2ca\3\2"+
		"\2\2cb\3\2\2\2d\7\3\2\2\2ef\7\f\2\2f\t\3\2\2\2gh\7#\2\2hi\5\4\3\2ij\7"+
		"$\2\2j\13\3\2\2\2kl\5> \2lm\7\3\2\2mn\5<\37\2n\r\3\2\2\2op\7\13\2\2pq"+
		"\7\37\2\2qr\7\4\2\2rs\5\20\t\2st\7\5\2\2tu\7\6\2\2uv\7#\2\2vw\5\4\3\2"+
		"wx\7$\2\2x\17\3\2\2\2y~\5\22\n\2z{\7\7\2\2{}\5\22\n\2|z\3\2\2\2}\u0080"+
		"\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081"+
		"y\3\2\2\2\u0081\u0082\3\2\2\2\u0082\21\3\2\2\2\u0083\u0085\5J&\2\u0084"+
		"\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\37"+
		"\2\2\u0087\23\3\2\2\2\u0088\u0089\5*\26\2\u0089\25\3\2\2\2\u008a\u008b"+
		"\7\26\2\2\u008b\u008c\5<\37\2\u008c\u008d\7\6\2\2\u008d\u008e\5\n\6\2"+
		"\u008e\27\3\2\2\2\u008f\u0090\7\31\2\2\u0090\u0091\5<\37\2\u0091\u0092"+
		"\7\6\2\2\u0092\u0094\7#\2\2\u0093\u0095\5\32\16\2\u0094\u0093\3\2\2\2"+
		"\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099"+
		"\3\2\2\2\u0098\u009a\5\34\17\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2"+
		"\u009a\u009b\3\2\2\2\u009b\u009c\7$\2\2\u009c\31\3\2\2\2\u009d\u009e\7"+
		"\33\2\2\u009e\u009f\7 \2\2\u009f\u00a0\7\6\2\2\u00a0\u00a1\5\n\6\2\u00a1"+
		"\33\3\2\2\2\u00a2\u00a3\7\32\2\2\u00a3\u00a4\7\6\2\2\u00a4\u00a5\5\n\6"+
		"\2\u00a5\35\3\2\2\2\u00a6\u00a7\7\25\2\2\u00a7\u00a8\7\37\2\2\u00a8\u00a9"+
		"\7\b\2\2\u00a9\u00aa\5<\37\2\u00aa\u00ab\7\6\2\2\u00ab\u00ac\5\n\6\2\u00ac"+
		"\37\3\2\2\2\u00ad\u00ae\7\27\2\2\u00ae\u00af\5<\37\2\u00af\u00b0\7\6\2"+
		"\2\u00b0\u00b2\5\n\6\2\u00b1\u00b3\5\"\22\2\u00b2\u00b1\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3!\3\2\2\2\u00b4\u00b5\7\30\2\2\u00b5\u00b6\7\6\2\2"+
		"\u00b6\u00b7\5\n\6\2\u00b7#\3\2\2\2\u00b8\u00b9\7\35\2\2\u00b9%\3\2\2"+
		"\2\u00ba\u00bb\7\36\2\2\u00bb\'\3\2\2\2\u00bc\u00be\7\34\2\2\u00bd\u00bf"+
		"\5<\37\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf)\3\2\2\2\u00c0"+
		"\u00c1\7\37\2\2\u00c1\u00c3\7\4\2\2\u00c2\u00c4\5H%\2\u00c3\u00c2\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7\5\2\2\u00c6"+
		"+\3\2\2\2\u00c7\u00c8\7 \2\2\u00c8-\3\2\2\2\u00c9\u00ca\7\4\2\2\u00ca"+
		"\u00cb\5<\37\2\u00cb\u00cc\7\5\2\2\u00cc/\3\2\2\2\u00cd\u00d3\5> \2\u00ce"+
		"\u00d3\5F$\2\u00cf\u00d3\5,\27\2\u00d0\u00d3\5*\26\2\u00d1\u00d3\5.\30"+
		"\2\u00d2\u00cd\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\61\3\2\2\2\u00d4\u00d6\5D#\2\u00d5"+
		"\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\5\60"+
		"\31\2\u00d8\63\3\2\2\2\u00d9\u00de\5\62\32\2\u00da\u00db\7\20\2\2\u00db"+
		"\u00dd\5\62\32\2\u00dc\u00da\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3"+
		"\2\2\2\u00de\u00df\3\2\2\2\u00df\65\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1"+
		"\u00e6\5\64\33\2\u00e2\u00e3\t\2\2\2\u00e3\u00e5\5\64\33\2\u00e4\u00e2"+
		"\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\67\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ee\5\66\34\2\u00ea\u00eb\7\17"+
		"\2\2\u00eb\u00ed\5\66\34\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef9\3\2\2\2\u00f0\u00ee\3\2\2\2"+
		"\u00f1\u00f6\58\35\2\u00f2\u00f3\7\16\2\2\u00f3\u00f5\58\35\2\u00f4\u00f2"+
		"\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		";\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\5:\36\2\u00fa=\3\2\2\2\u00fb"+
		"\u00fe\5@!\2\u00fc\u00fe\5B\"\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2"+
		"\2\u00fe?\3\2\2\2\u00ff\u0100\7\37\2\2\u0100A\3\2\2\2\u0101\u0102\5@!"+
		"\2\u0102\u0103\7\t\2\2\u0103\u0104\5<\37\2\u0104\u0105\7\n\2\2\u0105\u010e"+
		"\3\2\2\2\u0106\u0107\7\4\2\2\u0107\u0108\5<\37\2\u0108\u0109\7\5\2\2\u0109"+
		"\u010a\7\t\2\2\u010a\u010b\5<\37\2\u010b\u010c\7\n\2\2\u010c\u010e\3\2"+
		"\2\2\u010d\u0101\3\2\2\2\u010d\u0106\3\2\2\2\u010eC\3\2\2\2\u010f\u0110"+
		"\t\3\2\2\u0110E\3\2\2\2\u0111\u0113\7\t\2\2\u0112\u0114\5H%\2\u0113\u0112"+
		"\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7\n\2\2\u0116"+
		"G\3\2\2\2\u0117\u011c\5<\37\2\u0118\u0119\7\7\2\2\u0119\u011b\5<\37\2"+
		"\u011a\u0118\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011dI\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120\t\4\2\2\u0120"+
		"K\3\2\2\2\27RVc~\u0081\u0084\u0096\u0099\u00b2\u00be\u00c3\u00d2\u00d5"+
		"\u00de\u00e6\u00ee\u00f6\u00fd\u010d\u0113\u011c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}