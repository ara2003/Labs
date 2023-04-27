package com.example.lab.expression;

import java.util.List;

import com.example.lab.SemanticError;
import com.example.lab.Type;
import com.example.lab.statement.StatementContext;


public record NewListExpression(List<? extends Expression> args, int line) implements Expression {
	
	public NewListExpression(int line) {
		this(List.of(), line);
	}
	
	@Override
	public Type getType(StatementContext context) {
		return Type.LIST;
	}
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(!args.stream().map(x -> x.checkContextSemantic(context)).anyMatch(x -> x))
			return false;
		boolean result = true;
		for(var arg : args) {
			var type = arg.getType(context);
			if(type != Type.ELEMENT)
				result &= SemanticError.print("type of element new list is not element", line);
		}
		return result;
	}
	
}
