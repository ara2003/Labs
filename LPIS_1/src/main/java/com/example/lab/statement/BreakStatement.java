package com.example.lab.statement;

import com.example.lab.statement.error.SemanticError;
import com.example.lab.statement.error.SemanticErrorBase;
import com.example.lab.statement.error.SemanticOK;

public record BreakStatement(int line) implements Statement {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		if(!context.isForDef())
			return new SemanticErrorBase("break outside for/while", line());
		return new SemanticOK();
	}
	
}
