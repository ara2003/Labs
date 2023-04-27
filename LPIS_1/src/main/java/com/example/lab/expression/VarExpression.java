package com.example.lab.expression;

import com.example.lab.SemanticError;
import com.example.lab.Type;
import com.example.lab.Variable;
import com.example.lab.statement.AssignTarget;
import com.example.lab.statement.StatementContext;

public record VarExpression(String name, int line) implements AssignTarget {
	
	@Override
	public Type getType(StatementContext context) {
		return context.getVariableType(name).get();
	}
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(!context.hasVariable(name))
			return SemanticError.print("use not define variale '" + name + "' ", line());
		return true;
	}
	
	@Override
	public boolean init(StatementContext context, Type type) {
		if(context.hasVariable(name)) {
			var ctxType = context.getVariableType(name).get();
			if(ctxType != type)
				return SemanticError.print("set '" + type + "' to '" + ctxType + "' variable", line);
			return true;
		}
		context.initVariable(new Variable(type, name));
		return true;
	}
	
}
