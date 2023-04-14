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
		RULE_defaultStat = 13, RULE_forStmt = 14, RULE_ifStmt = 15, RULE_breakStmt = 16, 
		RULE_continueStmt = 17, RULE_returnStmt = 18, RULE_numberExpr = 19, RULE_inBracketsRvalue = 20, 
		RULE_atomExpr = 21, RULE_unaryExpr = 22, RULE_multExpr = 23, RULE_sumExpr = 24, 
		RULE_compareExpr = 25, RULE_logicExpr = 26, RULE_rvalue = 27, RULE_lvalue = 28, 
		RULE_varName = 29, RULE_list_index = 30, RULE_unaryExprPrefix = 31, RULE_newList = 32, 
		RULE_arguments = 33, RULE_type = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "code", "stmt", "passStat", "codeBlockStmt", "assignStmt", 
			"funcDefStmt", "paramiters", "paramiter", "funcCallStmt", "whileStmt", 
			"switchStmt", "caseStat", "defaultStat", "forStmt", "ifStmt", "breakStmt", 
			"continueStmt", "returnStmt", "numberExpr", "inBracketsRvalue", "atomExpr", 
			"unaryExpr", "multExpr", "sumExpr", "compareExpr", "logicExpr", "rvalue", 
			"lvalue", "varName", "list_index", "unaryExprPrefix", "newList", "arguments", 
			"type"
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
			setState(70);
			code();
			setState(71);
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
			setState(80);
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
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << FUNC) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << SWITCH) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID) | (1L << BEGIN))) != 0)) {
					{
					{
					setState(73);
					stmt();
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case PASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
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
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				funcDefStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				assignStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				forStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				ifStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(87);
				funcCallStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(88);
				codeBlockStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(89);
				breakStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(90);
				continueStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(91);
				returnStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(92);
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
			setState(95);
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
			setState(97);
			match(BEGIN);
			setState(98);
			code();
			setState(99);
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
			setState(101);
			lvalue();
			setState(102);
			match(T__0);
			setState(103);
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
			setState(105);
			match(FUNC);
			setState(106);
			match(ID);
			setState(107);
			match(T__1);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LIST) | (1L << ELEMENT) | (1L << ID))) != 0)) {
				{
				setState(108);
				paramiters();
				}
			}

			setState(111);
			match(T__2);
			setState(112);
			match(T__3);
			setState(113);
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
			setState(115);
			paramiter();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(116);
				match(T__4);
				setState(117);
				paramiter();
				}
				}
				setState(122);
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
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIST || _la==ELEMENT) {
				{
				setState(123);
				type();
				}
			}

			setState(126);
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
		enterRule(_localctx, 18, RULE_funcCallStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(ID);
			setState(129);
			match(T__1);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(130);
				arguments();
				}
			}

			setState(133);
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
			setState(135);
			match(WHILE);
			setState(136);
			rvalue();
			setState(137);
			match(T__3);
			setState(138);
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
			setState(140);
			match(SWITCH);
			setState(141);
			rvalue();
			setState(142);
			match(T__3);
			setState(143);
			match(BEGIN);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFAULT || _la==CASE) {
				{
				setState(146);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CASE:
					{
					setState(144);
					caseStat();
					}
					break;
				case DEFAULT:
					{
					setState(145);
					defaultStat();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
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
			setState(153);
			match(CASE);
			setState(154);
			match(NUMBER);
			setState(155);
			match(T__3);
			setState(156);
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
			setState(158);
			match(DEFAULT);
			setState(159);
			match(T__3);
			setState(160);
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
			setState(162);
			match(FOR);
			setState(163);
			match(ID);
			setState(164);
			match(T__5);
			setState(165);
			rvalue();
			setState(166);
			match(T__3);
			setState(167);
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
		public List<CodeBlockStmtContext> codeBlockStmt() {
			return getRuleContexts(CodeBlockStmtContext.class);
		}
		public CodeBlockStmtContext codeBlockStmt(int i) {
			return getRuleContext(CodeBlockStmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(exampleParser.ELSE, 0); }
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
			setState(169);
			match(IF);
			setState(170);
			rvalue();
			setState(171);
			match(T__3);
			setState(172);
			codeBlockStmt();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(173);
				match(ELSE);
				setState(174);
				match(T__3);
				setState(175);
				codeBlockStmt();
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

	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(exampleParser.BREAK, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
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
		enterRule(_localctx, 34, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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
		enterRule(_localctx, 36, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(RETURN);
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(183);
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

	public static class NumberExprContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(exampleParser.NUMBER, 0); }
		public NumberExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberExpr; }
	}

	public final NumberExprContext numberExpr() throws RecognitionException {
		NumberExprContext _localctx = new NumberExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_numberExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
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
		enterRule(_localctx, 40, RULE_inBracketsRvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__1);
			setState(189);
			rvalue();
			setState(190);
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
		enterRule(_localctx, 42, RULE_atomExpr);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				lvalue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				newList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				numberExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				funcCallStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(196);
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
		enterRule(_localctx, 44, RULE_unaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION))) != 0)) {
				{
				setState(199);
				unaryExprPrefix();
				}
			}

			setState(202);
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
		enterRule(_localctx, 46, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			unaryExpr();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT_OPERATION) {
				{
				{
				setState(205);
				match(MULT_OPERATION);
				setState(206);
				unaryExpr();
				}
				}
				setState(211);
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
		enterRule(_localctx, 48, RULE_sumExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			multExpr();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS_OPERATION || _la==MINUS_OPERATION) {
				{
				{
				setState(213);
				_la = _input.LA(1);
				if ( !(_la==PLUS_OPERATION || _la==MINUS_OPERATION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(214);
				multExpr();
				}
				}
				setState(219);
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
		enterRule(_localctx, 50, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			sumExpr();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPARE_OPERATION) {
				{
				{
				setState(221);
				match(COMPARE_OPERATION);
				setState(222);
				sumExpr();
				}
				}
				setState(227);
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
		enterRule(_localctx, 52, RULE_logicExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			compareExpr();
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGIC_OPERATION) {
				{
				{
				setState(229);
				match(LOGIC_OPERATION);
				setState(230);
				compareExpr();
				}
				}
				setState(235);
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
		enterRule(_localctx, 54, RULE_rvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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
		enterRule(_localctx, 56, RULE_lvalue);
		try {
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				varName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				varName();
				setState(240);
				list_index();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				match(T__1);
				setState(243);
				rvalue();
				setState(244);
				match(T__2);
				setState(245);
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
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
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
		enterRule(_localctx, 60, RULE_list_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__6);
			setState(252);
			rvalue();
			setState(253);
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
		enterRule(_localctx, 62, RULE_unaryExprPrefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
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
		enterRule(_localctx, 64, RULE_newList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__6);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << NOT_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(258);
				arguments();
				}
			}

			setState(261);
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
		enterRule(_localctx, 66, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			rvalue();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(264);
				match(T__4);
				setState(265);
				rvalue();
				}
				}
				setState(270);
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
		enterRule(_localctx, 68, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0114\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\3\7\3M\n\3\f\3\16\3P\13\3\3\3\5"+
		"\3S\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4`\n\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\bp\n\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\n\5\n\177\n\n\3\n\3\n\3\13\3"+
		"\13\3\13\5\13\u0086\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\7\r\u0095\n\r\f\r\16\r\u0098\13\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u00b3\n\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\5\24\u00bb\n\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u00c8\n\27\3\30\5\30\u00cb\n\30\3\30\3\30\3\31\3\31\3\31\7\31\u00d2"+
		"\n\31\f\31\16\31\u00d5\13\31\3\32\3\32\3\32\7\32\u00da\n\32\f\32\16\32"+
		"\u00dd\13\32\3\33\3\33\3\33\7\33\u00e2\n\33\f\33\16\33\u00e5\13\33\3\34"+
		"\3\34\3\34\7\34\u00ea\n\34\f\34\16\34\u00ed\13\34\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00fa\n\36\3\37\3\37\3 \3 \3"+
		" \3 \3!\3!\3\"\3\"\5\"\u0106\n\"\3\"\3\"\3#\3#\3#\7#\u010d\n#\f#\16#\u0110"+
		"\13#\3$\3$\3$\2\2%\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDF\2\5\3\2\21\22\4\2\r\r\21\22\3\2\23\24\2\u0111\2H\3\2"+
		"\2\2\4R\3\2\2\2\6_\3\2\2\2\ba\3\2\2\2\nc\3\2\2\2\fg\3\2\2\2\16k\3\2\2"+
		"\2\20u\3\2\2\2\22~\3\2\2\2\24\u0082\3\2\2\2\26\u0089\3\2\2\2\30\u008e"+
		"\3\2\2\2\32\u009b\3\2\2\2\34\u00a0\3\2\2\2\36\u00a4\3\2\2\2 \u00ab\3\2"+
		"\2\2\"\u00b4\3\2\2\2$\u00b6\3\2\2\2&\u00b8\3\2\2\2(\u00bc\3\2\2\2*\u00be"+
		"\3\2\2\2,\u00c7\3\2\2\2.\u00ca\3\2\2\2\60\u00ce\3\2\2\2\62\u00d6\3\2\2"+
		"\2\64\u00de\3\2\2\2\66\u00e6\3\2\2\28\u00ee\3\2\2\2:\u00f9\3\2\2\2<\u00fb"+
		"\3\2\2\2>\u00fd\3\2\2\2@\u0101\3\2\2\2B\u0103\3\2\2\2D\u0109\3\2\2\2F"+
		"\u0111\3\2\2\2HI\5\4\3\2IJ\7\2\2\3J\3\3\2\2\2KM\5\6\4\2LK\3\2\2\2MP\3"+
		"\2\2\2NL\3\2\2\2NO\3\2\2\2OS\3\2\2\2PN\3\2\2\2QS\5\b\5\2RN\3\2\2\2RQ\3"+
		"\2\2\2S\5\3\2\2\2T`\5\16\b\2U`\5\f\7\2V`\5\26\f\2W`\5\36\20\2X`\5 \21"+
		"\2Y`\5\24\13\2Z`\5\n\6\2[`\5\"\22\2\\`\5$\23\2]`\5&\24\2^`\5\30\r\2_T"+
		"\3\2\2\2_U\3\2\2\2_V\3\2\2\2_W\3\2\2\2_X\3\2\2\2_Y\3\2\2\2_Z\3\2\2\2_"+
		"[\3\2\2\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2\2`\7\3\2\2\2ab\7\f\2\2b\t\3\2\2"+
		"\2cd\7#\2\2de\5\4\3\2ef\7$\2\2f\13\3\2\2\2gh\5:\36\2hi\7\3\2\2ij\58\35"+
		"\2j\r\3\2\2\2kl\7\13\2\2lm\7\37\2\2mo\7\4\2\2np\5\20\t\2on\3\2\2\2op\3"+
		"\2\2\2pq\3\2\2\2qr\7\5\2\2rs\7\6\2\2st\5\n\6\2t\17\3\2\2\2uz\5\22\n\2"+
		"vw\7\7\2\2wy\5\22\n\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\21\3\2"+
		"\2\2|z\3\2\2\2}\177\5F$\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0081\7\37\2\2\u0081\23\3\2\2\2\u0082\u0083\7\37\2\2\u0083\u0085\7\4"+
		"\2\2\u0084\u0086\5D#\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0088\7\5\2\2\u0088\25\3\2\2\2\u0089\u008a\7\26\2\2\u008a"+
		"\u008b\58\35\2\u008b\u008c\7\6\2\2\u008c\u008d\5\n\6\2\u008d\27\3\2\2"+
		"\2\u008e\u008f\7\31\2\2\u008f\u0090\58\35\2\u0090\u0091\7\6\2\2\u0091"+
		"\u0096\7#\2\2\u0092\u0095\5\32\16\2\u0093\u0095\5\34\17\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7$"+
		"\2\2\u009a\31\3\2\2\2\u009b\u009c\7\33\2\2\u009c\u009d\7 \2\2\u009d\u009e"+
		"\7\6\2\2\u009e\u009f\5\n\6\2\u009f\33\3\2\2\2\u00a0\u00a1\7\32\2\2\u00a1"+
		"\u00a2\7\6\2\2\u00a2\u00a3\5\n\6\2\u00a3\35\3\2\2\2\u00a4\u00a5\7\25\2"+
		"\2\u00a5\u00a6\7\37\2\2\u00a6\u00a7\7\b\2\2\u00a7\u00a8\58\35\2\u00a8"+
		"\u00a9\7\6\2\2\u00a9\u00aa\5\n\6\2\u00aa\37\3\2\2\2\u00ab\u00ac\7\27\2"+
		"\2\u00ac\u00ad\58\35\2\u00ad\u00ae\7\6\2\2\u00ae\u00b2\5\n\6\2\u00af\u00b0"+
		"\7\30\2\2\u00b0\u00b1\7\6\2\2\u00b1\u00b3\5\n\6\2\u00b2\u00af\3\2\2\2"+
		"\u00b2\u00b3\3\2\2\2\u00b3!\3\2\2\2\u00b4\u00b5\7\35\2\2\u00b5#\3\2\2"+
		"\2\u00b6\u00b7\7\36\2\2\u00b7%\3\2\2\2\u00b8\u00ba\7\34\2\2\u00b9\u00bb"+
		"\58\35\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\'\3\2\2\2\u00bc"+
		"\u00bd\7 \2\2\u00bd)\3\2\2\2\u00be\u00bf\7\4\2\2\u00bf\u00c0\58\35\2\u00c0"+
		"\u00c1\7\5\2\2\u00c1+\3\2\2\2\u00c2\u00c8\5:\36\2\u00c3\u00c8\5B\"\2\u00c4"+
		"\u00c8\5(\25\2\u00c5\u00c8\5\24\13\2\u00c6\u00c8\5*\26\2\u00c7\u00c2\3"+
		"\2\2\2\u00c7\u00c3\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c6\3\2\2\2\u00c8-\3\2\2\2\u00c9\u00cb\5@!\2\u00ca\u00c9\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\5,\27\2\u00cd/\3\2\2\2"+
		"\u00ce\u00d3\5.\30\2\u00cf\u00d0\7\20\2\2\u00d0\u00d2\5.\30\2\u00d1\u00cf"+
		"\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\61\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00db\5\60\31\2\u00d7\u00d8\t\2"+
		"\2\2\u00d8\u00da\5\60\31\2\u00d9\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\63\3\2\2\2\u00dd\u00db\3\2\2"+
		"\2\u00de\u00e3\5\62\32\2\u00df\u00e0\7\17\2\2\u00e0\u00e2\5\62\32\2\u00e1"+
		"\u00df\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\65\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00eb\5\64\33\2\u00e7"+
		"\u00e8\7\16\2\2\u00e8\u00ea\5\64\33\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed"+
		"\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\67\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ee\u00ef\5\66\34\2\u00ef9\3\2\2\2\u00f0\u00fa\5<\37"+
		"\2\u00f1\u00f2\5<\37\2\u00f2\u00f3\5> \2\u00f3\u00fa\3\2\2\2\u00f4\u00f5"+
		"\7\4\2\2\u00f5\u00f6\58\35\2\u00f6\u00f7\7\5\2\2\u00f7\u00f8\5> \2\u00f8"+
		"\u00fa\3\2\2\2\u00f9\u00f0\3\2\2\2\u00f9\u00f1\3\2\2\2\u00f9\u00f4\3\2"+
		"\2\2\u00fa;\3\2\2\2\u00fb\u00fc\7\37\2\2\u00fc=\3\2\2\2\u00fd\u00fe\7"+
		"\t\2\2\u00fe\u00ff\58\35\2\u00ff\u0100\7\n\2\2\u0100?\3\2\2\2\u0101\u0102"+
		"\t\3\2\2\u0102A\3\2\2\2\u0103\u0105\7\t\2\2\u0104\u0106\5D#\2\u0105\u0104"+
		"\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7\n\2\2\u0108"+
		"C\3\2\2\2\u0109\u010e\58\35\2\u010a\u010b\7\7\2\2\u010b\u010d\58\35\2"+
		"\u010c\u010a\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010fE\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\t\4\2\2\u0112"+
		"G\3\2\2\2\26NR_oz~\u0085\u0094\u0096\u00b2\u00ba\u00c7\u00ca\u00d3\u00db"+
		"\u00e3\u00eb\u00f9\u0105\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}