package com.example.lab.statement;

import java.util.Optional;

import com.example.lab.ReturnType;
import com.example.lab.SemanticError;
import com.example.lab.expression.Expression;

public record ReturnStatement(Expression expression) implements Statement {
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(context.isReturn())
			return SemanticError.printReturnError(expression.line());
		if(!context.isFuncDef())
			return SemanticError.print("return outside function", line());
		context.setReturn();
		return expression.checkContextSemantic(context);
	}
	
	@Override
	public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
		return Optional.ofNullable(expression.getType(context)).map(x -> x.toReturnType());
	}
	
	@Override
	public int line() {
		return expression.line();
	}
	
}
