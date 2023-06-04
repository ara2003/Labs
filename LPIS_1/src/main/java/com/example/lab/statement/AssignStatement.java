package com.example.lab.statement;

import java.util.Objects;

import com.example.lab.SemanticError;
import com.example.lab.expression.Expression;

public record AssignStatement(AssignTarget target, Expression expr) implements Statement {
	
	
	public AssignStatement {
		Objects.requireNonNull(target);
		Objects.requireNonNull(expr);
	}
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(context.isReturn())
			return SemanticError.printReturnError(line());
		if(!expr.checkContextSemantic(context))
			return false;
		return target.init(context, expr.getType(context));
	}
	
	@Override
	public int line() {
		return target.line();
	}
	
}
