package com.example.lab.statement;

import com.example.lab.SemanticError;

public record BreakStatement(int line) implements Statement {
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(!context.isForDef())
			return SemanticError.print("break outside for/while", line());
		return true;
	}
	
}
