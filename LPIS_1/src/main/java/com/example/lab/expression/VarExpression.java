package com.example.lab.expression;

import java.util.Optional;

import com.example.lab.Type;
import com.example.lab.Variable;
import com.example.lab.statement.AssignTarget;
import com.example.lab.statement.StatementContext;
import com.example.lab.statement.error.SemanticError;
import com.example.lab.statement.error.SemanticErrorBase;

public record VarExpression(String name, int line) implements AssignTarget {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		if(!context.hasVariable(name))
			return new SemanticErrorBase("not init variable " + name, line);
		return AssignTarget.super.checkSemantic(context);
	}
	
	@Override
	public Optional<Type> resolveResultType(StatementContext context) {
		return context.getVariableType(name);
	}
	
	@Override
	public void init(StatementContext context, Type type) {
		context.initVariable(new Variable(type, name));
	}
	
}
