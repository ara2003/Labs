package com.example.lab.statement;

import com.example.lab.ReturnType;

public interface InFunctionStatement extends Statement {
	
	ReturnType returnType();
	ReturnType returnType(StatementContext context);
	
	@Override
	default ReturnType tryResolveReturnType(StatementContext context) {
		return returnType(context);
	}
	
}
