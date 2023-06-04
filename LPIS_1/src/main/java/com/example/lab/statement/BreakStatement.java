package com.example.lab.statement;

import com.example.lab.SemanticError;

public record BreakStatement(int line) implements Statement {
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(context.isReturn())
			return SemanticError.printReturnError(line());
		if(!context.isForDef())
			return SemanticError.print("break outside for/while", line());
		context.setReturn();
		return true;
	}
	
}
