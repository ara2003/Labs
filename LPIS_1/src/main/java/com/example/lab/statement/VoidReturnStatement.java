package com.example.lab.statement;

import com.example.lab.ReturnType;

public class VoidReturnStatement implements InFunctionStatement {
	
	@Override
	public void checkSemantic(StatementContext context) {
	}
	
	@Override
	public ReturnType returnType(StatementContext context) {
		return ReturnType.VOID;
	}
	
}
