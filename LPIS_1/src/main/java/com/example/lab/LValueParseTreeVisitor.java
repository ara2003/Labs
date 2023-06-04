package com.example.lab;


import com.example.lab.expression.ListIndexExpression;
import com.example.lab.expression.VarExpression;
import com.example.lab.statement.AssignTarget;

import antlr4.exampleBaseVisitor;
import antlr4.exampleParser.ListIndexContext;
import antlr4.exampleParser.VarNameContext;

public final class LValueParseTreeVisitor extends exampleBaseVisitor<AssignTarget> {
	
	@Override
	public AssignTarget visitVarName(VarNameContext ctx) {
		return new VarExpression(ctx.getText(), ctx.getStart().getLine());
	}

	
	@Override
	protected AssignTarget aggregateResult(AssignTarget aggregate, AssignTarget nextResult) {
		if(aggregate == null)
			return nextResult;
		if(nextResult == null)
			return aggregate;
		throw new UnsupportedOperationException(aggregate + " " + nextResult);
	}
	
	@Override
	public AssignTarget visitListIndex(ListIndexContext ctx) {
		var name = ctx.varName();
		if(name != null) {
			var n = visit(name);
			var value = visit(ctx.rvalue(0));
			return new ListIndexExpression(n, value);
		}
		var n = visit(ctx.rvalue(0));
		var index = visit(ctx.rvalue(1));
		return new ListIndexExpression(n, index);
	}
	
}
