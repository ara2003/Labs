package com.example.lab.statement;

import java.util.Optional;

import com.example.lab.ReturnType;
import com.example.lab.SemanticError;

public record VoidReturnStatement(int line) implements Statement {
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(context.isReturn())
			return SemanticError.printReturnError(line());
		if(!context.isFuncDef())
			return SemanticError.print("return outside function", line());
		context.setReturn();
		return true;
	}
	
	@Override
	public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
		return Optional.of(ReturnType.VOID);
	}
	
}
