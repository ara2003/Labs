package com.example.lab.statement;

import java.util.Objects;

import com.example.lab.expression.Expression;
import com.example.lab.statement.error.SemanticError;

public record AssignStatement(AssignTarget target, Expression expr) implements Statement {
	
	
	public AssignStatement {
		Objects.requireNonNull(target);
		Objects.requireNonNull(expr);
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		var result = expr.checkSemantic(context);
		
		var type = expr.resolveResultType(context);
		if(type.isPresent())
			target.init(context, type.get());
		
		
		return result;
	}
	
	@Override
	public int line() {
		return target.line();
	}
	
}
