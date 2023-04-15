package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.expression.Expression;
import com.example.lab.statement.error.SemanticError;

public record ReturnStatement(Expression expression) implements Statement {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		return expression.checkSemantic(context);
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		return expression.resolveResultType(context).map(x -> x.toReturnType()).orElse(null);
	}
	
}
