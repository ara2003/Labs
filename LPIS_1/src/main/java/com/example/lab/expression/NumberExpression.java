package com.example.lab.expression;

import java.util.Optional;

import com.example.lab.Type;
import com.example.lab.statement.StatementContext;

public record NumberExpression(int value, int line) implements Expression {
	
	public NumberExpression {
	}
	
	public NumberExpression(String value, int line) {
		this(Integer.parseInt(value), line);
	}
	
	@Override
	public Optional<Type> resolveResultType(StatementContext context) {
		return Optional.of(Type.ELEMENT);
	}
	
	
	
}
