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
		SUM_OPERATION=10, MULT_OPERATION=11, INC_OPERATION=12, DEC_OPERATION=13, 
		LIST=14, ELEMENT=15, FOR=16, WHILE=17, IF=18, ELSE=19, SWITCH=20, CASE=21, 
		ID=22, NUMBER=23, NEWLINE=24, SKIP_=25, BEGIN=26, END=27;
	public static final int
		RULE_code = 0, RULE_codeBlock = 1, RULE_assignExp = 2, RULE_funcDef = 3, 
		RULE_funcCall = 4, RULE_whileExp = 5, RULE_forExp = 6, RULE_ifExp = 7, 
		RULE_expr = 8, RULE_mult_expr = 9, RULE_atom_expr = 10, RULE_number_expr = 11, 
		RULE_id_expr = 12, RULE_new_list = 13, RULE_numbers = 14, RULE_paramiters = 15, 
		RULE_paramiter = 16, RULE_arguments = 17, RULE_type = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"code", "codeBlock", "assignExp", "funcDef", "funcCall", "whileExp", 
			"forExp", "ifExp", "expr", "mult_expr", "atom_expr", "number_expr", "id_expr", 
			"new_list", "numbers", "paramiters", "paramiter", "arguments", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "':'", "'in'", "'['", "']'", "','", "'func'", 
			null, null, "'++'", "'--'", "'list'", "'element'", "'for'", "'while'", 
			"'if'", "'else'", "'switch'", "'case'", null, null, "'{BEGIN}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "FUNC", "SUM_OPERATION", 
			"MULT_OPERATION", "INC_OPERATION", "DEC_OPERATION", "LIST", "ELEMENT", 
			"FOR", "WHILE", "IF", "ELSE", "SWITCH", "CASE", "ID", "NUMBER", "NEWLINE", 
			"SKIP_", "BEGIN", "END"
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

	public static class CodeContext extends ParserRuleContext {
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<AssignExpContext> assignExp() {
			return getRuleContexts(AssignExpContext.class);
		}
		public AssignExpContext assignExp(int i) {
			return getRuleContext(AssignExpContext.class,i);
		}
		public List<WhileExpContext> whileExp() {
			return getRuleContexts(WhileExpContext.class);
		}
		public WhileExpContext whileExp(int i) {
			return getRuleContext(WhileExpContext.class,i);
		}
		public List<ForExpContext> forExp() {
			return getRuleContexts(ForExpContext.class);
		}
		public ForExpContext forExp(int i) {
			return getRuleContext(ForExpContext.class,i);
		}
		public List<IfExpContext> ifExp() {
			return getRuleContexts(IfExpContext.class);
		}
		public IfExpContext ifExp(int i) {
			return getRuleContext(IfExpContext.class,i);
		}
		public List<FuncCallContext> funcCall() {
			return getRuleContexts(FuncCallContext.class);
		}
		public FuncCallContext funcCall(int i) {
			return getRuleContext(FuncCallContext.class,i);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNC) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << ID) | (1L << BEGIN))) != 0)) {
				{
				setState(45);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(38);
					funcDef();
					}
					break;
				case 2:
					{
					setState(39);
					assignExp();
					}
					break;
				case 3:
					{
					setState(40);
					whileExp();
					}
					break;
				case 4:
					{
					setState(41);
					forExp();
					}
					break;
				case 5:
					{
					setState(42);
					ifExp();
					}
					break;
				case 6:
					{
					setState(43);
					funcCall();
					}
					break;
				case 7:
					{
					setState(44);
					codeBlock();
					}
					break;
				}
				}
				setState(49);
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

	public static class CodeBlockContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_codeBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(BEGIN);
			setState(51);
			code();
			setState(52);
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

	public static class AssignExpContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignExp; }
	}

	public final AssignExpContext assignExp() throws RecognitionException {
		AssignExpContext _localctx = new AssignExpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ID);
			setState(55);
			match(T__0);
			setState(56);
			expr();
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

	public static class FuncDefContext extends ParserRuleContext {
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
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(FUNC);
			setState(59);
			match(ID);
			setState(60);
			match(T__1);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LIST) | (1L << ELEMENT) | (1L << ID))) != 0)) {
				{
				setState(61);
				paramiters();
				}
			}

			setState(64);
			match(T__2);
			setState(65);
			match(T__3);
			setState(66);
			match(BEGIN);
			setState(67);
			code();
			setState(68);
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

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(ID);
			setState(71);
			match(T__1);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(72);
				arguments();
				}
			}

			setState(75);
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

	public static class WhileExpContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(exampleParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
		public WhileExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileExp; }
	}

	public final WhileExpContext whileExp() throws RecognitionException {
		WhileExpContext _localctx = new WhileExpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whileExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(WHILE);
			setState(78);
			expr();
			setState(79);
			match(T__3);
			setState(80);
			match(BEGIN);
			setState(81);
			code();
			setState(82);
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

	public static class ForExpContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(exampleParser.FOR, 0); }
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
		public ForExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExp; }
	}

	public final ForExpContext forExp() throws RecognitionException {
		ForExpContext _localctx = new ForExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(FOR);
			setState(85);
			match(ID);
			setState(86);
			match(T__4);
			setState(87);
			expr();
			setState(88);
			match(T__3);
			setState(89);
			match(BEGIN);
			setState(90);
			code();
			setState(91);
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

	public static class IfExpContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(exampleParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(exampleParser.BEGIN, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode END() { return getToken(exampleParser.END, 0); }
		public IfExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExp; }
	}

	public final IfExpContext ifExp() throws RecognitionException {
		IfExpContext _localctx = new IfExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(IF);
			setState(94);
			expr();
			setState(95);
			match(T__3);
			setState(96);
			match(BEGIN);
			setState(97);
			code();
			setState(98);
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

	public static class ExprContext extends ParserRuleContext {
		public List<Mult_exprContext> mult_expr() {
			return getRuleContexts(Mult_exprContext.class);
		}
		public Mult_exprContext mult_expr(int i) {
			return getRuleContext(Mult_exprContext.class,i);
		}
		public List<TerminalNode> SUM_OPERATION() { return getTokens(exampleParser.SUM_OPERATION); }
		public TerminalNode SUM_OPERATION(int i) {
			return getToken(exampleParser.SUM_OPERATION, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			mult_expr();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUM_OPERATION) {
				{
				{
				setState(101);
				match(SUM_OPERATION);
				setState(102);
				mult_expr();
				}
				}
				setState(107);
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

	public static class Mult_exprContext extends ParserRuleContext {
		public List<Atom_exprContext> atom_expr() {
			return getRuleContexts(Atom_exprContext.class);
		}
		public Atom_exprContext atom_expr(int i) {
			return getRuleContext(Atom_exprContext.class,i);
		}
		public List<TerminalNode> MULT_OPERATION() { return getTokens(exampleParser.MULT_OPERATION); }
		public TerminalNode MULT_OPERATION(int i) {
			return getToken(exampleParser.MULT_OPERATION, i);
		}
		public Mult_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_expr; }
	}

	public final Mult_exprContext mult_expr() throws RecognitionException {
		Mult_exprContext _localctx = new Mult_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_mult_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			atom_expr();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT_OPERATION) {
				{
				{
				setState(109);
				match(MULT_OPERATION);
				setState(110);
				atom_expr();
				}
				}
				setState(115);
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

	public static class Atom_exprContext extends ParserRuleContext {
		public Number_exprContext number_expr() {
			return getRuleContext(Number_exprContext.class,0);
		}
		public New_listContext new_list() {
			return getRuleContext(New_listContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public Id_exprContext id_expr() {
			return getRuleContext(Id_exprContext.class,0);
		}
		public Atom_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom_expr; }
	}

	public final Atom_exprContext atom_expr() throws RecognitionException {
		Atom_exprContext _localctx = new Atom_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atom_expr);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				number_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				new_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				funcCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				id_expr();
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

	public static class Number_exprContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(exampleParser.NUMBER, 0); }
		public Number_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_expr; }
	}

	public final Number_exprContext number_expr() throws RecognitionException {
		Number_exprContext _localctx = new Number_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_number_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
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

	public static class Id_exprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(exampleParser.ID, 0); }
		public Id_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_expr; }
	}

	public final Id_exprContext id_expr() throws RecognitionException {
		Id_exprContext _localctx = new Id_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_id_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
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

	public static class New_listContext extends ParserRuleContext {
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public New_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_list; }
	}

	public final New_listContext new_list() throws RecognitionException {
		New_listContext _localctx = new New_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_new_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__5);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(127);
				numbers();
				}
			}

			setState(130);
			match(T__6);
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
		enterRule(_localctx, 28, RULE_numbers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(NUMBER);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(133);
				match(T__7);
				setState(134);
				match(NUMBER);
				}
				}
				setState(139);
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
		enterRule(_localctx, 30, RULE_paramiters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			paramiter();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(141);
				match(T__7);
				setState(142);
				paramiter();
				}
				}
				setState(147);
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
		enterRule(_localctx, 32, RULE_paramiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIST || _la==ELEMENT) {
				{
				setState(148);
				type();
				}
			}

			setState(151);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(exampleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(exampleParser.ID, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(ID);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(154);
				match(T__7);
				setState(155);
				match(ID);
				}
				}
				setState(160);
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
		enterRule(_localctx, 36, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00a6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\60\n\2\f\2\16\2\63"+
		"\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5A\n\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6L\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\7\nj\n\n\f\n\16\nm\13\n\3\13\3\13\3\13\7\13r\n\13\f\13\16\13"+
		"u\13\13\3\f\3\f\3\f\3\f\5\f{\n\f\3\r\3\r\3\16\3\16\3\17\3\17\5\17\u0083"+
		"\n\17\3\17\3\17\3\20\3\20\3\20\7\20\u008a\n\20\f\20\16\20\u008d\13\20"+
		"\3\21\3\21\3\21\7\21\u0092\n\21\f\21\16\21\u0095\13\21\3\22\5\22\u0098"+
		"\n\22\3\22\3\22\3\23\3\23\3\23\7\23\u009f\n\23\f\23\16\23\u00a2\13\23"+
		"\3\24\3\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\3"+
		"\3\2\20\21\2\u00a5\2\61\3\2\2\2\4\64\3\2\2\2\68\3\2\2\2\b<\3\2\2\2\nH"+
		"\3\2\2\2\fO\3\2\2\2\16V\3\2\2\2\20_\3\2\2\2\22f\3\2\2\2\24n\3\2\2\2\26"+
		"z\3\2\2\2\30|\3\2\2\2\32~\3\2\2\2\34\u0080\3\2\2\2\36\u0086\3\2\2\2 \u008e"+
		"\3\2\2\2\"\u0097\3\2\2\2$\u009b\3\2\2\2&\u00a3\3\2\2\2(\60\5\b\5\2)\60"+
		"\5\6\4\2*\60\5\f\7\2+\60\5\16\b\2,\60\5\20\t\2-\60\5\n\6\2.\60\5\4\3\2"+
		"/(\3\2\2\2/)\3\2\2\2/*\3\2\2\2/+\3\2\2\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2"+
		"\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\3\3\2\2\2\63\61\3\2\2\2\64"+
		"\65\7\34\2\2\65\66\5\2\2\2\66\67\7\35\2\2\67\5\3\2\2\289\7\30\2\29:\7"+
		"\3\2\2:;\5\22\n\2;\7\3\2\2\2<=\7\13\2\2=>\7\30\2\2>@\7\4\2\2?A\5 \21\2"+
		"@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\7\5\2\2CD\7\6\2\2DE\7\34\2\2EF\5\2\2"+
		"\2FG\7\35\2\2G\t\3\2\2\2HI\7\30\2\2IK\7\4\2\2JL\5$\23\2KJ\3\2\2\2KL\3"+
		"\2\2\2LM\3\2\2\2MN\7\5\2\2N\13\3\2\2\2OP\7\23\2\2PQ\5\22\n\2QR\7\6\2\2"+
		"RS\7\34\2\2ST\5\2\2\2TU\7\35\2\2U\r\3\2\2\2VW\7\22\2\2WX\7\30\2\2XY\7"+
		"\7\2\2YZ\5\22\n\2Z[\7\6\2\2[\\\7\34\2\2\\]\5\2\2\2]^\7\35\2\2^\17\3\2"+
		"\2\2_`\7\24\2\2`a\5\22\n\2ab\7\6\2\2bc\7\34\2\2cd\5\2\2\2de\7\35\2\2e"+
		"\21\3\2\2\2fk\5\24\13\2gh\7\f\2\2hj\5\24\13\2ig\3\2\2\2jm\3\2\2\2ki\3"+
		"\2\2\2kl\3\2\2\2l\23\3\2\2\2mk\3\2\2\2ns\5\26\f\2op\7\r\2\2pr\5\26\f\2"+
		"qo\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\25\3\2\2\2us\3\2\2\2v{\5\30"+
		"\r\2w{\5\34\17\2x{\5\n\6\2y{\5\32\16\2zv\3\2\2\2zw\3\2\2\2zx\3\2\2\2z"+
		"y\3\2\2\2{\27\3\2\2\2|}\7\31\2\2}\31\3\2\2\2~\177\7\30\2\2\177\33\3\2"+
		"\2\2\u0080\u0082\7\b\2\2\u0081\u0083\5\36\20\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\t\2\2\u0085\35\3\2\2"+
		"\2\u0086\u008b\7\31\2\2\u0087\u0088\7\n\2\2\u0088\u008a\7\31\2\2\u0089"+
		"\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\37\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0093\5\"\22\2\u008f\u0090"+
		"\7\n\2\2\u0090\u0092\5\"\22\2\u0091\u008f\3\2\2\2\u0092\u0095\3\2\2\2"+
		"\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094!\3\2\2\2\u0095\u0093\3"+
		"\2\2\2\u0096\u0098\5&\24\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\7\30\2\2\u009a#\3\2\2\2\u009b\u00a0\7\30\2"+
		"\2\u009c\u009d\7\n\2\2\u009d\u009f\7\30\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1%\3\2\2\2"+
		"\u00a2\u00a0\3\2\2\2\u00a3\u00a4\t\2\2\2\u00a4\'\3\2\2\2\16/\61@Kksz\u0082"+
		"\u008b\u0093\u0097\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}