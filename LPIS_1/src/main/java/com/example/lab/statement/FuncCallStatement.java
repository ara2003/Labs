package com.example.lab.statement;

import com.example.lab.expression.FuncCallExpression;

public record FuncCallStatement(FuncCallExpression expr) implements Statement {
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		return expr.checkContextSemantic(context);
	}
	
	@Override
	public int line() {
		return expr.line();
	}
	
}
