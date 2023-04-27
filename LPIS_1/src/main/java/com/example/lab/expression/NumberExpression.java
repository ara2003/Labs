package com.example.lab.expression;

import com.example.lab.Type;
import com.example.lab.statement.StatementContext;

public record NumberExpression(int value, int line) implements Expression {
	
	public NumberExpression {
	}
	
	public NumberExpression(String value, int line) {
		this(Integer.parseInt(value), line);
	}
	
	@Override
	public Type getType(StatementContext context) {
		return Type.ELEMENT;
	}
	
	
	
}
