package com.example.lab;

import java.util.Optional;

import com.example.lab.statement.AssignStatement;
import com.example.lab.statement.BreakStatement;
import com.example.lab.statement.CodeBlockStatement;
import com.example.lab.statement.ContinueStatement;
import com.example.lab.statement.EmptyStatement;
import com.example.lab.statement.ForStatement;
import com.example.lab.statement.FuncCallStatement;
import com.example.lab.statement.FuncDefStatement;
import com.example.lab.statement.IfStatement;
import com.example.lab.statement.MergeStatement;
import com.example.lab.statement.PassStatement;
import com.example.lab.statement.ReturnStatement;
import com.example.lab.statement.Statement;
import com.example.lab.statement.SwitchStatement;
import com.example.lab.statement.VoidReturnStatement;
import com.example.lab.statement.WhileStatement;

import antlr4.exampleBaseVisitor;
import antlr4.exampleParser.AssignStmtContext;
import antlr4.exampleParser.BreakStmtContext;
import antlr4.exampleParser.CodeBlockStmtContext;
import antlr4.exampleParser.ContinueStmtContext;
import antlr4.exampleParser.ForStmtContext;
import antlr4.exampleParser.FuncCallStmtContext;
import antlr4.exampleParser.FuncDefStmtContext;
import antlr4.exampleParser.IfStmtContext;
import antlr4.exampleParser.ParamiterContext;
import antlr4.exampleParser.PassStatContext;
import antlr4.exampleParser.ReturnStmtContext;
import antlr4.exampleParser.SwitchStmtContext;
import antlr4.exampleParser.WhileStmtContext;

public final class StatementParseTreeVisitor extends exampleBaseVisitor<Statement> {
	
	private final ExpressionParseTreeVisitor expressions;
	private final LValueParseTreeVisitor lvalues;
	
	public StatementParseTreeVisitor(ExpressionParseTreeVisitor expressions, LValueParseTreeVisitor lvalues) {
		this.expressions = expressions;
		this.lvalues = lvalues;
	}
	
	@Override
	protected Statement aggregateResult(Statement aggregate, Statement nextResult) {
		if(aggregate == null)
			return nextResult;
		if(nextResult == null)
			return aggregate;
		return MergeStatement.newStatement(aggregate, nextResult);
	}
	
	@Override
	protected Statement defaultResult() {
		return new EmptyStatement();
	}
	
	@Override
	public Statement visitCodeBlockStmt(CodeBlockStmtContext ctx) {
		return new CodeBlockStatement(visit(ctx.code()));
	}
	
	@Override
	public Statement visitSwitchStmt(SwitchStmtContext ctx) {
		var defaultStat = Optional.ofNullable(ctx.defaultStat()).map(x -> visit(x))
				.orElseGet(() -> new EmptyStatement());
		return new SwitchStatement(expressions.visit(ctx.rvalue()), ctx.caseStat().stream().map(x -> visit(x)).toList(),
				defaultStat);
	}
	
	@Override
	public Statement visitAssignStmt(AssignStmtContext ctx) {
		var target = lvalues.visit(ctx.lvalue());
		var expr = expressions.visit(ctx.rvalue());
		return new AssignStatement(target, expr);
	}
	
	@Override
	public Statement visitBreakStmt(BreakStmtContext ctx) {
		return new BreakStatement(ctx.getStart().getLine());
	}
	
	@Override
	public Statement visitContinueStmt(ContinueStmtContext ctx) {
		return new ContinueStatement(ctx.getStart().getLine());
	}
	
	@Override
	public Statement visitWhileStmt(WhileStmtContext ctx) {
		return new WhileStatement(expressions.visit(ctx.rvalue()), visit(ctx.codeBlockStmt()));
	}
	
	@Override
	public Statement visitFuncCallStmt(FuncCallStmtContext ctx) {
		var expr = expressions.visitFuncCallExpr(ctx.funcCallExpr());
		return new FuncCallStatement(expr);
	}
	
	@Override
	public Statement visitReturnStmt(ReturnStmtContext ctx) {
		var value = ctx.rvalue();
		if(value == null)
			return new VoidReturnStatement(ctx.getStart().getLine());
		return new ReturnStatement(expressions.visit(value));
	}
	
	@Override
	public Statement visitPassStat(PassStatContext ctx) {
		return new PassStatement(ctx.getStart().getLine());
	}
	
	@Override
	public Statement visitFuncDefStmt(FuncDefStmtContext ctx) {
		var paramiters = ctx.paramiters();
		var params = paramiters.paramiter().stream().map(x -> createParamiter(x)).toList();
		return new FuncDefStatement(ctx.ID().getText(), params, visit(ctx.code()));
	}
	
	@Override
	public Statement visitIfStmt(IfStmtContext ctx) {
		var expr = expressions.visit(ctx.rvalue());
		var then = visit(ctx.codeBlockStmt());
		var _else = Optional.ofNullable(ctx.elseStmt()).map(x -> visit(x)).orElseGet(() -> new EmptyStatement());
		return IfStatement.newStatement(expr, then, _else);
	}
	
	
	private Variable createParamiter(ParamiterContext x) {
		var type = x.type();
		var name = x.ID().getText();
		if(type == null)
			return new Variable(name);
		return new Variable(createType(type.getText()), name);
	}
	
	private Type createType(String type) {
		return switch(type) {
			case "list" -> Type.LIST;
			case "element" -> Type.ELEMENT;
			default ->
				throw new IllegalArgumentException("Unexpected value: " + type);
		};
	}
	
	@Override
	public Statement visitForStmt(ForStmtContext ctx) {
		var iter_list = expressions.visit(ctx.rvalue());
		var code = visit(ctx.codeBlockStmt());
		return new ForStatement(ctx.ID().getText(), iter_list, code);
	}
	
	
}