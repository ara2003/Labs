package com.example.lab.expression.binary;

import java.util.stream.Stream;

import com.example.lab.Type;
import com.example.lab.expression.Expression;

public abstract class BinaryExpression implements Expression {
	
	protected final Expression a, b;
	
	public BinaryExpression(Expression a, Expression b) {
		this.a = a;
		this.b = b;
	}
	
	public abstract String sign();
	
	@Override
	public String toMathString() {
		return a.toMathStringWithBrackets() + " " + sign() + " " + b.toMathStringWithBrackets();
	}
	
	@Override
	public String toMathStringWithBrackets() {
		return "(" + toMathString() + ")";
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + a + ", " + b + "]";
	}
	
	@Override
	public Type tryResolveResultType() {
		var aType = a.tryResolveResultType();
		var bType = b.tryResolveResultType();
		if(aType == null || bType == null)
			return null;
		if(aType != bType)
			throw new UnsupportedOperationException("type of " + this);
		return aType;
	}
	
	@Override
	public Stream<String> useFunctions() {
		return Stream.concat(a.useFunctions(), b.useFunctions());
	}
	
	@Override
	public Stream<String> useVariables() {
		return Stream.concat(a.useVariables(), b.useVariables());
	}
}
