package com.example.lab.statement;

import com.example.lab.expression.FuncCallExpression;
import com.example.lab.statement.error.SemanticError;

public record FuncCallStatement(FuncCallExpression expr) implements Statement {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		return expr.checkSemantic(context);
	}
	
}
