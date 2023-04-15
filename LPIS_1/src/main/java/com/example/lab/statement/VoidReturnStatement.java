package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.statement.error.SemanticError;
import com.example.lab.statement.error.SemanticOK;

public class VoidReturnStatement implements Statement {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		return new SemanticOK();
	}
	
	
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		return ReturnType.VOID;
	}
	
}
