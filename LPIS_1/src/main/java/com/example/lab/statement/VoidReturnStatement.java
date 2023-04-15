package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.statement.error.SemanticError;
import com.example.lab.statement.error.SemanticErrorBase;
import com.example.lab.statement.error.SemanticOK;

public record VoidReturnStatement(int line) implements Statement {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		if(!context.isFuncDef())
			return new SemanticErrorBase("return outside function", line());
		return new SemanticOK();
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		return ReturnType.VOID;
	}
	
}
