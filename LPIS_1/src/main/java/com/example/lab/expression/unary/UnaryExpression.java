package com.example.lab.expression.unary;

import com.example.lab.Type;
import com.example.lab.expression.Expression;
import com.example.lab.statement.StatementContext;

public abstract class UnaryExpression implements Expression {
	
	protected final Expression arg;
	
	public UnaryExpression(Expression arg) {
		this.arg = arg;
	}
	
	@Override
	public Type getType(StatementContext context) {
		return arg.getType(context);
	}
	
	public abstract String sign();
	
	@Override
	public int line() {
		return arg.line();
	}
	
}
