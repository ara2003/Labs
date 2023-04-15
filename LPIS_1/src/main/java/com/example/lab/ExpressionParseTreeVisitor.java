package com.example.lab;

import org.antlr.v4.runtime.ParserRuleContext;

import com.example.lab.expression.Expression;
import com.example.lab.expression.FuncCallExpression;
import com.example.lab.expression.NewListExpression;
import com.example.lab.expression.NumberExpression;
import com.example.lab.expression.RemainderDivisionExpression;
import com.example.lab.expression.VarExpression;
import com.example.lab.expression.binary.AndExpression;
import com.example.lab.expression.binary.DivExpression;
import com.example.lab.expression.binary.MultExpression;
import com.example.lab.expression.binary.NegativeExpression;
import com.example.lab.expression.binary.OrExpression;
import com.example.lab.expression.binary.SumExpression;
import com.example.lab.expression.binary.XORExpression;
import com.example.lab.expression.binary.compare.EqualsExpression;
import com.example.lab.expression.binary.compare.LessOrEqualsExpression;
import com.example.lab.expression.binary.compare.MoreExpression;
import com.example.lab.expression.binary.compare.MoreOrEqualsExpression;
import com.example.lab.expression.binary.compare.NotEqualsExpression;
import com.example.lab.expression.unary.UnaryMinusExpression;
import com.example.lab.expression.unary.UnaryNotExpression;
import com.example.lab.expression.unary.UnaryPlusExpression;

import antlr4.exampleBaseVisitor;
import antlr4.exampleParser.CompareExprContext;
import antlr4.exampleParser.FuncCallStmtContext;
import antlr4.exampleParser.InBracketsRvalueContext;
import antlr4.exampleParser.LogicExprContext;
import antlr4.exampleParser.MultExprContext;
import antlr4.exampleParser.NewListContext;
import antlr4.exampleParser.NumberExprContext;
import antlr4.exampleParser.SumExprContext;
import antlr4.exampleParser.UnaryExprContext;
import antlr4.exampleParser.VarNameContext;

public final class ExpressionParseTreeVisitor extends exampleBaseVisitor<Expression> {
	
	@Override
	public Expression visitInBracketsRvalue(InBracketsRvalueContext ctx) {
		return super.visitRvalue(ctx.rvalue());
	}
	
	@Override
	public Expression visitNumberExpr(NumberExprContext ctx) {
		return new NumberExpression(ctx.getText(), ctx.getStart().getLine());
	}
	
	@Override
	public Expression visitCompareExpr(CompareExprContext ctx) {
		return visitBiExpression(ctx);
	}
	
	@Override
	public Expression visitLogicExpr(LogicExprContext ctx) {
		return visitBiExpression(ctx);
	}
	
	@Override
	public Expression visitSumExpr(SumExprContext ctx) {
		return visitBiExpression(ctx);
	}
	
	private Expression visitBiExpression(ParserRuleContext ctx) {
		var result = visit(ctx.getChild(0));
		for(var i = 1; i < ctx.getChildCount(); i += 2) {
			var sign = ctx.getChild(i).getText();
			var expr = ctx.getChild(i + 1).accept(this);
			result = switch(sign) {
				case "+" -> SumExpression.newExpression(result, expr);
				case "-" -> NegativeExpression.newExpression(result, expr);
			
				case "*" -> MultExpression.newExpression(result, expr);
				case "/" -> DivExpression.newExpression(result, expr);
				case "%" -> RemainderDivisionExpression.newExpression(result, expr);
				case "^" -> XORExpression.newExpression(result, expr);
			
				case "and" -> AndExpression.newExpression(result, expr);
				case "or" -> OrExpression.newExpression(result, expr);
			
				case "==" -> EqualsExpression.newExpression(result, expr);
				case "!=" -> NotEqualsExpression.newExpression(result, expr);
				case ">=" -> MoreOrEqualsExpression.newExpression(result, expr);
				case ">" -> MoreExpression.newExpression(result, expr);
				case "<=" -> LessOrEqualsExpression.newExpression(result, expr);
				case "<" -> LessOrEqualsExpression.newExpression(result, expr);
			
				default -> throw new IllegalArgumentException("Unexpected value: " + sign);
			};
		}
		return result;
	}
	
	@Override
	public Expression visitNewList(NewListContext ctx) {
		var line = ctx.getStart().getLine();
		var arguments = ctx.arguments();
		if(arguments == null) {
			return new NewListExpression(line);
		}else {
			var args = arguments.rvalue().stream().map(x -> visitRvalue(x)).toList();
			return new NewListExpression(args, line);
		}
	}
	
	@Override
	public Expression visitUnaryExpr(UnaryExprContext ctx) {
		var prefix = ctx.unaryExprPrefix();
		var expr = ctx.atomExpr().accept(this);
		if(prefix == null)
			return expr;
		return switch(prefix.getText()) {
			case "not" -> UnaryNotExpression.newExpression(expr);
			case "+" -> UnaryPlusExpression.newExpression(expr);
			case "-" -> UnaryMinusExpression.newExpression(expr);
			default -> throw new IllegalArgumentException("Unexpected value: " + prefix.getText());
		};
	}
	
	@Override
	public Expression visitMultExpr(MultExprContext ctx) {
		return visitBiExpression(ctx);
	}
	
	@Override
	public Expression visitVarName(VarNameContext ctx) {
		return new VarExpression(ctx.getText(), ctx.getStart().getLine());
	}
	
	@Override
	public FuncCallExpression visitFuncCallStmt(FuncCallStmtContext ctx) {
		var arguments = ctx.arguments();
		if(arguments == null) {
			return new FuncCallExpression(ctx.ID().getText());
		}else {
			var args = arguments.rvalue().stream().map(x -> visitRvalue(x)).toList();
			return new FuncCallExpression(ctx.ID().getText(), args);
		}
	}
	
	@Override
	protected Expression aggregateResult(Expression aggregate, Expression nextResult) {
		if(aggregate == null && nextResult != null)
			return nextResult;
		throw new UnsupportedOperationException(aggregate + " " + nextResult);
	}
	
}
