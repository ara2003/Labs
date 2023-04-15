package com.example.lab.expression.unary;

import java.util.Optional;

import com.example.lab.Type;
import com.example.lab.expression.Expression;
import com.example.lab.statement.StatementContext;

public abstract class UnaryExpression implements Expression {
	
	protected final Expression arg;
	
	public UnaryExpression(Expression arg) {
		this.arg = arg;
	}
	
	@Override
	public Optional<Type> resolveResultType(StatementContext context) {
		return Optional.of(Type.ELEMENT);
	}
	
	public abstract String sign();
	
	@Override
	public int line() {
		return arg.line();
	}
	
}
