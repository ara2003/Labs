package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.expression.Expression;
import com.example.lab.statement.error.MergeSemanticError;
import com.example.lab.statement.error.SemanticError;


public record ForStatement(String index, Expression iter_list, Statement code) implements Statement {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		final SemanticError e1, e2;
		e1 = iter_list.checkSemantic(context);
		var b = context.block();
		b.initVariable(index);
		e2 = code.checkSemantic(b);
		return MergeSemanticError.newError(e1, e2);
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		var b = context.block();
		b.initVariable(index);
		return code.tryResolveReturnType(b);
	}
	
}
