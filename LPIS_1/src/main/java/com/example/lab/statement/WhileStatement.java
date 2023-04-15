package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.expression.Expression;
import com.example.lab.statement.error.MergeSemanticError;
import com.example.lab.statement.error.SemanticError;


public record WhileStatement(Expression expr, Statement code) implements Statement {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		final SemanticError e1, e2;
		e1 = expr.checkSemantic(context);
		var b = context.forDefBlock();
		e2 = code.checkSemantic(b);
		return MergeSemanticError.newError(e1, e2);
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		return code.tryResolveReturnType(context);
	}
	
	@Override
	public int line() {
		return expr.line();
	}
	
}
