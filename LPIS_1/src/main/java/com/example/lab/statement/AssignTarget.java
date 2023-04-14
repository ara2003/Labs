package com.example.lab.statement;

import java.util.stream.Stream;

import com.example.lab.Type;
import com.example.lab.expression.Expression;

public interface AssignTarget {
	
	Stream<? extends Expression> usedExpressions();
	
	void init(StatementContext context, Type type);
	
	String toCodeString();
	
}