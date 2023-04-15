package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.statement.error.SemanticError;

public record CodeBlockStatement(Statement code) implements Statement {
	
	@Override
	public int line() {
		return code.line();
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		return code.tryResolveReturnType(context);
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		return code.checkSemantic(context.block());
	}
	
}
