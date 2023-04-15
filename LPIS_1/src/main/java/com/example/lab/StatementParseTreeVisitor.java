package com.example.lab;

import com.example.lab.statement.AssignStatement;
import com.example.lab.statement.ForStatement;
import com.example.lab.statement.FuncCallStatement;
import com.example.lab.statement.FuncDefStatement;
import com.example.lab.statement.IfElseStatement;
import com.example.lab.statement.IfStatement;
import com.example.lab.statement.MergeStatement;
import com.example.lab.statement.ReturnStatement;
import com.example.lab.statement.Statement;
import com.example.lab.statement.VoidReturnStatement;

import antlr4.exampleBaseVisitor;
import antlr4.exampleParser.AssignStmtContext;
import antlr4.exampleParser.ForStmtContext;
import antlr4.exampleParser.FuncCallStmtContext;
import antlr4.exampleParser.FuncDefStmtContext;
import antlr4.exampleParser.IfStmtContext;
import antlr4.exampleParser.ParamiterContext;
import antlr4.exampleParser.PassStatContext;
import antlr4.exampleParser.ReturnStmtContext;

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
	public Statement visitAssignStmt(AssignStmtContext ctx) {
		var target = lvalues.visit(ctx.lvalue());
		var expr = expressions.visit(ctx.rvalue());
		return new AssignStatement(target, expr);
	}
	
	@Override
	public Statement visitFuncCallStmt(FuncCallStmtContext ctx) {
		var expr = expressions.visitFuncCallStmt(ctx);
		return new FuncCallStatement(expr);
	}
	
	@Override
	public Statement visitReturnStmt(ReturnStmtContext ctx) {
		var value = ctx.rvalue();
		if(value == null)
			return new VoidReturnStatement();
		return new ReturnStatement(expressions.visit(value));
	}
	
	@Override
	public Statement visitPassStat(PassStatContext ctx) {
		return new VoidReturnStatement();
	}
	
	@Override
	public Statement visitFuncDefStmt(FuncDefStmtContext ctx) {
		var paramiters = ctx.paramiters();
		if(paramiters == null) {
			return new FuncDefStatement(ctx.ID().getText(), visit(ctx.codeBlockStmt()));
		}else {
			var params = paramiters.paramiter().stream().map(x -> createParamiter(x)).toList();
			return new FuncDefStatement(ctx.ID().getText(), params,
					visit(ctx.codeBlockStmt()));
		}
	}
	
	@Override
	public Statement visitIfStmt(IfStmtContext ctx) {
		var expr = expressions.visit(ctx.rvalue());
		var then = visit(ctx.codeBlockStmt());
		var _else = ctx.elseStmt();
		if(_else == null)
			return IfStatement.newStatement(expr, then);
		return IfElseStatement.newStatement(expr, then, visit(_else));
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