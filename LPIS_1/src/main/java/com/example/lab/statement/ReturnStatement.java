package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.Type;
import com.example.lab.expression.Expression;
import com.example.lab.statement.error.SemanticError;
import com.example.lab.statement.error.SemanticErrorBase;

public record ReturnStatement(Expression expression) implements Statement {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		if(!context.isFuncDef())
			return new SemanticErrorBase("return outside function", line());
		return expression.checkSemantic(context);
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		return expression.resolveResultType(context).map(Type::toReturnType).orElse(null);
	}
	
	@Override
	public int line() {
		return expression.line();
	}
	
}
