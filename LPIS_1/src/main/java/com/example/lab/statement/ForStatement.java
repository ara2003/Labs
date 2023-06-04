package com.example.lab.statement;

import java.util.Optional;

import com.example.lab.ReturnType;
import com.example.lab.SemanticError;
import com.example.lab.expression.Expression;


public record ForStatement(String index, Expression iter_list, Statement code) implements Statement {
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(context.isReturn())
			return SemanticError.printReturnError(line());
		boolean result = true;
		result &= iter_list.checkContextSemantic(context);
		var ctx = context.forDefBlock();
		ctx.initVariable(index);
		result &= code.checkContextSemantic(ctx);
		return result;
	}
	
	@Override
	public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
		var ctx = context.forDefBlock();
		ctx.initVariable(index);
		return code.tryResolveReturnType(ctx);
	}
	
	@Override
	public int line() {
		return iter_list.line();
	}
	
}
