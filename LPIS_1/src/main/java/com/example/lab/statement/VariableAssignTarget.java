package com.example.lab.statement;

import java.util.stream.Stream;

import com.example.lab.Type;
import com.example.lab.Variable;
import com.example.lab.expression.Expression;


public record VariableAssignTarget(String name) implements AssignTarget {
	
	@Override
	public Stream<? extends Expression> usedExpressions() {
		return Stream.empty();
	}
	
	@Override
	public void init(StatementContext context, Type type) {
		context.initVariable(new Variable(type, name));
	}
	
	@Override
	public String toCodeString() {
		return name;
	}
	
}
