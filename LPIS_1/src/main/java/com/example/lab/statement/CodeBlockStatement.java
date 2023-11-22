package com.example.lab.statement;

import java.util.Optional;

import com.example.lab.ReturnType;
import com.example.lab.interpreter.InterpreterContext;

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

	@Override
	public void runInterpreter(InterpreterContext context) {
		code.runInterpreter(context.block());
	}

}
