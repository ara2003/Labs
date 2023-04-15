package com.example.lab.statement;

import com.example.lab.expression.Expression;
import com.example.lab.statement.error.MergeSemanticError;
import com.example.lab.statement.error.SemanticError;

public record IfElseStatement(Expression expr, Statement Then, Statement Else) implements Statement {
	
	public IfElseStatement {
	}
	
	public static Statement newStatement(Expression expr, Statement Then, Statement Else) {
		return new IfElseStatement(expr, Then, Else);
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		return MergeSemanticError.newError(expr.checkSemantic(context), Then.checkSemantic(context),
				Else.checkSemantic(context));
	}
	
	@Override
	public int line() {
		return expr.line();
	}
	
}
