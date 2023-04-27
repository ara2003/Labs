package com.example.lab.statement;

import java.util.Optional;

import com.example.lab.ReturnType;
import com.example.lab.SemanticError;
import com.example.lab.Type;
import com.example.lab.expression.Expression;

public record WhileStatement(Expression expr, Statement code) implements Statement {
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		boolean result = true;
		result &= expr.checkContextSemantic(context);
		result &= SemanticError.printIf("type of while argument is not element", expr.line(),
				expr.getType(context).equals(Type.ELEMENT));
		var ctx = context.forDefBlock();
		result &= code.checkContextSemantic(ctx);
		return result;
	}
	
	@Override
	public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
		return code.tryResolveReturnType(context);
	}
	
	@Override
	public int line() {
		return code.line();
	}
	
}
