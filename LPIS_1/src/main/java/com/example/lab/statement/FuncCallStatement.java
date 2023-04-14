package com.example.lab.statement;

import com.example.lab.expression.FuncCallExpression;

public record FuncCallStatement(FuncCallExpression expr) implements Statement {
	
	@Override
	public void checkSemantic(StatementContext context) {
		expr.checkSemantic(context);
		
	}
	
	@Override
	public String toCodeString() {
		return expr.toMathString();
	}
	
}
