package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.expression.Expression;
import com.example.lab.statement.error.MergeSemanticError;
import com.example.lab.statement.error.SemanticError;

public record IfStatement(Expression expr, Statement Then) implements Statement {
	
	public IfStatement {
	}
	
	public static Statement newStatement(Expression expr, Statement Then) {
		return new IfStatement(expr, Then);
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		return Then.tryResolveReturnType(context);
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		var e1 = expr.checkSemantic(context);
		var e2 = Then.checkSemantic(context);
		return MergeSemanticError.newError(e1, e2);
	}
	
}
