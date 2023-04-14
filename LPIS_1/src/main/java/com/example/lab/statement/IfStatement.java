package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.expression.Expression;

public record IfStatement(Expression expr, Statement Then) implements Statement {
	
	public IfStatement {
	}
	
	public static Statement newStatement(Expression expr, Statement Then) {
		var exprValue = expr.tryGetConstElementValue();
		if(exprValue != null) {
			if(exprValue == 0)
				return null;
			return Then;
		}
		return new IfStatement(expr, Then);
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		return Then.tryResolveReturnType(context);
	}
	
	@Override
	public void checkSemantic(StatementContext context) {
		expr.checkSemantic(context);
		Then.checkSemantic(context);
	}
	
}
