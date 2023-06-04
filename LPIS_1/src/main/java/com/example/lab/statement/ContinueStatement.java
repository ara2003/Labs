package com.example.lab.statement;

import com.example.lab.SemanticError;

public record ContinueStatement(int line) implements Statement {
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(context.isReturn())
			return SemanticError.printReturnError(line());
		context.setReturn();
		if(!context.isForDef())
			return SemanticError.print("continue outside for/while", line());
		return true;
	}
	
}
