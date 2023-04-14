package com.example.lab.expression;

import java.util.stream.Stream;

import com.example.lab.Type;

public record NumberExpression(int value) implements Expression {
	
	public static final Expression FALSE = new NumberExpression(0);
	public static final Expression TRUE = new NumberExpression(1);
	
	public NumberExpression {
	}
	
	public NumberExpression(String value) {
		this(Integer.parseInt(value));
	}
	
	@Override
	public Stream<String> useVariables() {
		return Stream.empty();
	}
	
	@Override
	public Stream<String> useFunctions() {
		return Stream.empty();
	}
	
	@Override
	public Integer tryGetConstElementValue() {
		return value;
	}
	
	@Override
	public String toMathString() {
		return "" + value;
	}
	
	@Override
	public Type tryResolveResultType() {
		return Type.ELEMENT;
	}
	
	public static Expression getBoolean(boolean bool) {
		return bool ? TRUE : FALSE;
	}
	
}
