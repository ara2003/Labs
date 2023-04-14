package com.example.lab.statement;

import java.util.Objects;
import java.util.Optional;

import com.example.lab.ReturnType;


public record WrapInFunctionStatement(Statement statement) implements InFunctionStatement {
	
	public WrapInFunctionStatement {
		Objects.requireNonNull(statement);
	}
	
	public static InFunctionStatement newStatement(Statement statement) {
		if(statement instanceof InFunctionStatement f)
			return f;
		return new WrapInFunctionStatement(statement);
	}
	
	@Override
	public void checkSemantic(StatementContext context) {
		statement.checkSemantic(context);
	}
	
	@Override
	public ReturnType returnType(StatementContext context) {
		return Optional.ofNullable(statement.tryResolveReturnType(context)).orElse(ReturnType.VOID);
	}
	
	@Override
	public String toCodeString() {
		return statement.toCodeString();
	}
	
}
