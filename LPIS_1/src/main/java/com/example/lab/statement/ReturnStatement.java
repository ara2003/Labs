package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.expression.Expression;

public record ReturnStatement(Expression expression) implements InFunctionStatement {
	
	@Override
	public void checkSemantic(StatementContext context) {
		expression.checkSemantic(context);
	}
	
	@Override
	public ReturnType returnType(StatementContext context) {
		return expression.resolveResultType(context).toReturnType();
	}
	
	@Override
	public String toCodeString() {
		return "return " + expression.toMathString();
	}
	
}
