package com.example.lab.statement;

import java.util.Objects;

import com.example.lab.expression.Expression;

public record AssignStatement(AssignTarget target, Expression expr) implements Statement {
	
	
	public AssignStatement {
		Objects.requireNonNull(target);
		Objects.requireNonNull(expr);
	}
	
	@Override
	public void preCheckSemantic(StatementContext context) {
		context.checkSemantic(target.usedExpressions().flatMap(x -> x.useVariables(context)));
		expr.checkSemantic(context);
		target.init(context, expr.resolveResultType(context));
	}
	
	@Override
	public void checkSemantic(StatementContext context) {
	}
	
	@Override
	public String toCodeString() {
		return target.toCodeString() + " = " + expr.toMathString();
	}
	
}
