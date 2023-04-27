package com.example.lab.statement;

import java.util.Objects;
import java.util.Optional;

import com.example.lab.ReturnType;
import com.example.lab.expression.Expression;

public record AssignStatement(AssignTarget target, Expression expr) implements Statement {
	
	
	public AssignStatement {
		Objects.requireNonNull(target);
		Objects.requireNonNull(expr);
	}
	
	@Override
	public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
		target.init(context, expr.getType(context));
		return Statement.super.tryResolveReturnType(context);
	}
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(!expr.checkContextSemantic(context))
			return false;
		return target.init(context, expr.getType(context));
	}
	
	@Override
	public int line() {
		return target.line();
	}
	
}
