package com.example.lab.statement;

import java.util.Optional;

import com.example.lab.ReturnType;

public record CodeBlockStatement(Statement code) implements Statement {
	
	@Override
	public int line() {
		return code.line();
	}
	
	@Override
	public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
		return code.tryResolveReturnType(context);
	}
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		return code.checkContextSemantic(context.block());
	}
	
}
