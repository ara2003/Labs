package com.example.lab.expression.unary;

import java.util.stream.Stream;

import com.example.lab.Type;
import com.example.lab.expression.Expression;

public abstract class UnaryExpression implements Expression {
	
	protected final Expression arg;
	
	public UnaryExpression(Expression arg) {
		this.arg = arg;
	}
	
	public abstract String sign();
	
	@Override
	public String toMathString() {
		return "(" + sign() + " " + arg + ")";
	}
	
	@Override
	public Type tryResolveResultType() {
		return arg.tryResolveResultType();
	}
	
	@Override
	public Stream<String> useFunctions() {
		return arg.useFunctions();
	}
	
	@Override
	public Stream<String> useVariables() {
		return arg.useVariables();
	}
}
