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
		NOT_OPERATION=10, LOGIC_OPERATION=11, COMPARE_OPERATION=12, SUM_OPERATION=13, 
		MULT_OPERATION=14, INC_OPERATION=15, DEC_OPERATION=16, PLUS_OPERATION=17, 
		MINUS_OPERATION=18, LIST=19, ELEMENT=20, FOR=21, WHILE=22, IF=23, ELSE=24, 
		SWITCH=25, CASE=26, RETURN=27, BREAK=28, CONTINUE=29, ID=30, NUMBER=31, 
		NEWLINE=32, SKIP_=33, BEGIN=34, END=35;
	public static final int
		RULE_program = 0, RULE_code = 1, RULE_stmt = 2, RULE_codeBlockStmt = 3, 
		RULE_assignStmt = 4, RULE_funcDefStmt = 5, RULE_paramiters = 6, RULE_paramiter = 7, 
		RULE_funcCallStmt = 8, RULE_arguments = 9, RULE_whileStmt = 10, RULE_forStmt = 11, 
		RULE_ifStmt = 12, RULE_lvalue = 13, RULE_rvalue = 14, RULE_logicExpr = 15, 
		RULE_compareExpr = 16, RULE_sumExpr = 17, RULE_multExpr = 18, RULE_unaryExpr = 19, 
		RULE_prefix_unary_operation = 20, RULE_syfix_unary_operation = 21, RULE_atomExpr = 22, 
		RULE_numberExpr = 23, RULE_newList = 24, RULE_numbers = 25, RULE_type = 26, 
		RULE_breakStmt = 27, RULE_continueStmt = 28, RULE_returnStmt = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "code", "stmt", "codeBlockStmt", "assignStmt", "funcDefStmt", 
			"paramiters", "paramiter", "funcCallStmt", "arguments", "whileStmt", 
			"forStmt", "ifStmt", "lvalue", "rvalue", "logicExpr", "compareExpr", 
			"sumExpr", "multExpr", "unaryExpr", "prefix_unary_operation", "syfix_unary_operation", 
			"atomExpr", "numberExpr", "newList", "numbers", "type", "breakStmt", 
			"continueStmt", "returnStmt"
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
			"BREAK", "CONTINUE", "ID", "NUMBER", "NEWLINE", "SKIP_", "BEGIN", "END"
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
			setState(60);
			code();
			setState(61);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNC) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID) | (1L << BEGIN))) != 0)) {
				{
				{
				setState(63);
				stmt();
				}
				}
				setState(68);
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
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				funcDefStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				assignStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				forStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				ifStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				funcCallStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(75);
				codeBlockStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(76);
				breakStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(77);
				continueStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(78);
				returnStmt();
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
		enterRule(_localctx, 6, RULE_codeBlockStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(BEGIN);
			setState(82);
			code();
			setState(83);
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
		enterRule(_localctx, 8, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			lvalue();
			setState(86);
			match(T__0);
			setState(87);
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
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
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
		enterRule(_localctx, 10, RULE_funcDefStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(FUNC);
			setState(90);
			match(ID);
			setState(91);
			match(T__1);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LIST) | (1L << ELEMENT) | (1L << ID))) != 0)) {
				{
				setState(92);
				paramiters();
				}
			}

			setState(95);
			match(T__2);
			setState(96);
			match(T__3);
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
		enterRule(_localctx, 12, RULE_paramiters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			paramiter();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(102);
				match(T__4);
				setState(103);
				paramiter();
				}
				}
				setState(108);
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
		enterRule(_localctx, 14, RULE_paramiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIST || _la==ELEMENT) {
				{
				setState(109);
				type();
				}
			}

			setState(112);
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
		enterRule(_localctx, 16, RULE_funcCallStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ID);
			setState(115);
			match(T__1);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << NOT_OPERATION) | (1L << INC_OPERATION) | (1L << DEC_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(116);
				arguments();
				}
			}

			setState(119);
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
		enterRule(_localctx, 18, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			rvalue();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(122);
				match(T__4);
				setState(123);
				rvalue();
				}
				}
				setState(128);
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(exampleParser.WHILE, 0); }
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
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
			match(BEGIN);
			setState(133);
			code();
			setState(134);
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

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(exampleParser.FOR, 0); }
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(FOR);
			setState(137);
			match(ID);
			setState(138);
			match(T__5);
			setState(139);
			rvalue();
			setState(140);
			match(T__3);
			setState(141);
			match(BEGIN);
			setState(142);
			code();
			setState(143);
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(exampleParser.IF, 0); }
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(IF);
			setState(146);
			rvalue();
			setState(147);
			match(T__3);
			setState(148);
			match(BEGIN);
			setState(149);
			code();
			setState(150);
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

	public static class LvalueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
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
		enterRule(_localctx, 28, RULE_rvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
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
		enterRule(_localctx, 30, RULE_logicExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			compareExpr();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGIC_OPERATION) {
				{
				{
				setState(157);
				match(LOGIC_OPERATION);
				setState(158);
				compareExpr();
				}
				}
				setState(163);
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
		enterRule(_localctx, 32, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			sumExpr();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPARE_OPERATION) {
				{
				{
				setState(165);
				match(COMPARE_OPERATION);
				setState(166);
				sumExpr();
				}
				}
				setState(171);
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
		enterRule(_localctx, 34, RULE_sumExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			multExpr();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUM_OPERATION) {
				{
				{
				setState(173);
				match(SUM_OPERATION);
				setState(174);
				multExpr();
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
		enterRule(_localctx, 36, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			unaryExpr();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT_OPERATION) {
				{
				{
				setState(181);
				match(MULT_OPERATION);
				setState(182);
				unaryExpr();
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

	public static class UnaryExprContext extends ParserRuleContext {
		public AtomExprContext atomExpr() {
			return getRuleContext(AtomExprContext.class,0);
		}
		public Prefix_unary_operationContext prefix_unary_operation() {
			return getRuleContext(Prefix_unary_operationContext.class,0);
		}
		public Syfix_unary_operationContext syfix_unary_operation() {
			return getRuleContext(Syfix_unary_operationContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_OPERATION) | (1L << INC_OPERATION) | (1L << DEC_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION))) != 0)) {
				{
				setState(188);
				prefix_unary_operation();
				}
			}

			setState(191);
			atomExpr();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INC_OPERATION || _la==DEC_OPERATION) {
				{
				setState(192);
				syfix_unary_operation();
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

	public static class Prefix_unary_operationContext extends ParserRuleContext {
		public TerminalNode INC_OPERATION() { return getToken(exampleParser.INC_OPERATION, 0); }
		public TerminalNode DEC_OPERATION() { return getToken(exampleParser.DEC_OPERATION, 0); }
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
		enterRule(_localctx, 40, RULE_prefix_unary_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_OPERATION) | (1L << INC_OPERATION) | (1L << DEC_OPERATION) | (1L << PLUS_OPERATION) | (1L << MINUS_OPERATION))) != 0)) ) {
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

	public static class Syfix_unary_operationContext extends ParserRuleContext {
		public TerminalNode INC_OPERATION() { return getToken(exampleParser.INC_OPERATION, 0); }
		public TerminalNode DEC_OPERATION() { return getToken(exampleParser.DEC_OPERATION, 0); }
		public Syfix_unary_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syfix_unary_operation; }
	}

	public final Syfix_unary_operationContext syfix_unary_operation() throws RecognitionException {
		Syfix_unary_operationContext _localctx = new Syfix_unary_operationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_syfix_unary_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ( !(_la==INC_OPERATION || _la==DEC_OPERATION) ) {
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
		enterRule(_localctx, 44, RULE_atomExpr);
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				lvalue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				newList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				numberExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				funcCallStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(203);
				match(T__1);
				setState(204);
				rvalue();
				setState(205);
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
		enterRule(_localctx, 46, RULE_numberExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
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
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public NewListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newList; }
	}

	public final NewListContext newList() throws RecognitionException {
		NewListContext _localctx = new NewListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_newList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__6);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(212);
				numbers();
				}
			}

			setState(215);
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

	public static class NumbersContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(exampleParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(exampleParser.NUMBER, i);
		}
		public NumbersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numbers; }
	}

	public final NumbersContext numbers() throws RecognitionException {
		NumbersContext _localctx = new NumbersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_numbers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(NUMBER);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(218);
				match(T__4);
				setState(219);
				match(NUMBER);
				}
				}
				setState(224);
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
		enterRule(_localctx, 52, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
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
		enterRule(_localctx, 54, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
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
		enterRule(_localctx, 56, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
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
		enterRule(_localctx, 58, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(RETURN);
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(232);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\3\7\3C\n\3\f\3\16\3F\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4R\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7`\n\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\t\5\tq\n\t"+
		"\3\t\3\t\3\n\3\n\3\n\5\nx\n\n\3\n\3\n\3\13\3\13\3\13\7\13\177\n\13\f\13"+
		"\16\13\u0082\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\21\7\21\u00a2\n\21\f\21\16\21\u00a5\13\21\3\22\3\22\3\22\7"+
		"\22\u00aa\n\22\f\22\16\22\u00ad\13\22\3\23\3\23\3\23\7\23\u00b2\n\23\f"+
		"\23\16\23\u00b5\13\23\3\24\3\24\3\24\7\24\u00ba\n\24\f\24\16\24\u00bd"+
		"\13\24\3\25\5\25\u00c0\n\25\3\25\3\25\5\25\u00c4\n\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00d2\n\30\3\31\3\31"+
		"\3\32\3\32\5\32\u00d8\n\32\3\32\3\32\3\33\3\33\3\33\7\33\u00df\n\33\f"+
		"\33\16\33\u00e2\13\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\5\37\u00ec"+
		"\n\37\3\37\2\2 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<\2\5\4\2\f\f\21\24\3\2\21\22\3\2\25\26\2\u00eb\2>\3\2\2\2\4D"+
		"\3\2\2\2\6Q\3\2\2\2\bS\3\2\2\2\nW\3\2\2\2\f[\3\2\2\2\16g\3\2\2\2\20p\3"+
		"\2\2\2\22t\3\2\2\2\24{\3\2\2\2\26\u0083\3\2\2\2\30\u008a\3\2\2\2\32\u0093"+
		"\3\2\2\2\34\u009a\3\2\2\2\36\u009c\3\2\2\2 \u009e\3\2\2\2\"\u00a6\3\2"+
		"\2\2$\u00ae\3\2\2\2&\u00b6\3\2\2\2(\u00bf\3\2\2\2*\u00c5\3\2\2\2,\u00c7"+
		"\3\2\2\2.\u00d1\3\2\2\2\60\u00d3\3\2\2\2\62\u00d5\3\2\2\2\64\u00db\3\2"+
		"\2\2\66\u00e3\3\2\2\28\u00e5\3\2\2\2:\u00e7\3\2\2\2<\u00e9\3\2\2\2>?\5"+
		"\4\3\2?@\7\2\2\3@\3\3\2\2\2AC\5\6\4\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE"+
		"\3\2\2\2E\5\3\2\2\2FD\3\2\2\2GR\5\f\7\2HR\5\n\6\2IR\5\26\f\2JR\5\30\r"+
		"\2KR\5\32\16\2LR\5\22\n\2MR\5\b\5\2NR\58\35\2OR\5:\36\2PR\5<\37\2QG\3"+
		"\2\2\2QH\3\2\2\2QI\3\2\2\2QJ\3\2\2\2QK\3\2\2\2QL\3\2\2\2QM\3\2\2\2QN\3"+
		"\2\2\2QO\3\2\2\2QP\3\2\2\2R\7\3\2\2\2ST\7$\2\2TU\5\4\3\2UV\7%\2\2V\t\3"+
		"\2\2\2WX\5\34\17\2XY\7\3\2\2YZ\5\36\20\2Z\13\3\2\2\2[\\\7\13\2\2\\]\7"+
		" \2\2]_\7\4\2\2^`\5\16\b\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\5\2\2bc\7"+
		"\6\2\2cd\7$\2\2de\5\4\3\2ef\7%\2\2f\r\3\2\2\2gl\5\20\t\2hi\7\7\2\2ik\5"+
		"\20\t\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\17\3\2\2\2nl\3\2\2\2"+
		"oq\5\66\34\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7 \2\2s\21\3\2\2\2tu\7 \2"+
		"\2uw\7\4\2\2vx\5\24\13\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\5\2\2z\23\3"+
		"\2\2\2{\u0080\5\36\20\2|}\7\7\2\2}\177\5\36\20\2~|\3\2\2\2\177\u0082\3"+
		"\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\25\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\u0084\7\30\2\2\u0084\u0085\5\36\20\2\u0085\u0086\7\6\2"+
		"\2\u0086\u0087\7$\2\2\u0087\u0088\5\4\3\2\u0088\u0089\7%\2\2\u0089\27"+
		"\3\2\2\2\u008a\u008b\7\27\2\2\u008b\u008c\7 \2\2\u008c\u008d\7\b\2\2\u008d"+
		"\u008e\5\36\20\2\u008e\u008f\7\6\2\2\u008f\u0090\7$\2\2\u0090\u0091\5"+
		"\4\3\2\u0091\u0092\7%\2\2\u0092\31\3\2\2\2\u0093\u0094\7\31\2\2\u0094"+
		"\u0095\5\36\20\2\u0095\u0096\7\6\2\2\u0096\u0097\7$\2\2\u0097\u0098\5"+
		"\4\3\2\u0098\u0099\7%\2\2\u0099\33\3\2\2\2\u009a\u009b\7 \2\2\u009b\35"+
		"\3\2\2\2\u009c\u009d\5 \21\2\u009d\37\3\2\2\2\u009e\u00a3\5\"\22\2\u009f"+
		"\u00a0\7\r\2\2\u00a0\u00a2\5\"\22\2\u00a1\u009f\3\2\2\2\u00a2\u00a5\3"+
		"\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4!\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a6\u00ab\5$\23\2\u00a7\u00a8\7\16\2\2\u00a8\u00aa\5$\23\2"+
		"\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac#\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b3\5&\24\2\u00af"+
		"\u00b0\7\17\2\2\u00b0\u00b2\5&\24\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3"+
		"\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4%\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00bb\5(\25\2\u00b7\u00b8\7\20\2\2\u00b8\u00ba\5(\25\2"+
		"\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\'\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\5*\26\2\u00bf"+
		"\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\5."+
		"\30\2\u00c2\u00c4\5,\27\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		")\3\2\2\2\u00c5\u00c6\t\2\2\2\u00c6+\3\2\2\2\u00c7\u00c8\t\3\2\2\u00c8"+
		"-\3\2\2\2\u00c9\u00d2\5\34\17\2\u00ca\u00d2\5\62\32\2\u00cb\u00d2\5\60"+
		"\31\2\u00cc\u00d2\5\22\n\2\u00cd\u00ce\7\4\2\2\u00ce\u00cf\5\36\20\2\u00cf"+
		"\u00d0\7\5\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00c9\3\2\2\2\u00d1\u00ca\3\2"+
		"\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00cc\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d2"+
		"/\3\2\2\2\u00d3\u00d4\7!\2\2\u00d4\61\3\2\2\2\u00d5\u00d7\7\t\2\2\u00d6"+
		"\u00d8\5\64\33\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3"+
		"\2\2\2\u00d9\u00da\7\n\2\2\u00da\63\3\2\2\2\u00db\u00e0\7!\2\2\u00dc\u00dd"+
		"\7\7\2\2\u00dd\u00df\7!\2\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\65\3\2\2\2\u00e2\u00e0\3\2\2"+
		"\2\u00e3\u00e4\t\4\2\2\u00e4\67\3\2\2\2\u00e5\u00e6\7\36\2\2\u00e69\3"+
		"\2\2\2\u00e7\u00e8\7\37\2\2\u00e8;\3\2\2\2\u00e9\u00eb\7\35\2\2\u00ea"+
		"\u00ec\5\36\20\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec=\3\2\2"+
		"\2\23DQ_lpw\u0080\u00a3\u00ab\u00b3\u00bb\u00bf\u00c3\u00d1\u00d7\u00e0"+
		"\u00eb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}