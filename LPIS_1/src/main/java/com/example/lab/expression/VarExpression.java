package com.example.lab.expression;

import java.util.stream.Stream;

import com.example.lab.Type;
import com.example.lab.statement.StatementContext;

public record VarExpression(String name) implements Expression {
	
	@Override
	public Stream<String> useFunctions() {
		return Stream.empty();
	}
	
	@Override
	public Type tryResolveResultType() {
		return null;
	}
	
	@Override
	public String toMathString() {
		return name;
	}
	
	@Override
	public Stream<String> useVariables() {
		return Stream.of(name);
	}
	
	@Override
	public Type resolveResultType(StatementContext context) {
		return context.getVariableType(name);
	}
	
}
