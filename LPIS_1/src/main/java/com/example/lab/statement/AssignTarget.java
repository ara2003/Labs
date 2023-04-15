package com.example.lab.statement;

import com.example.lab.Type;
import com.example.lab.expression.Expression;

public interface AssignTarget extends Expression {
	
	void init(StatementContext context, Type type);
	
}