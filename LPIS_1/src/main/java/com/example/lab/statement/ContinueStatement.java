package com.example.lab.statement;

import com.example.lab.statement.error.SemanticError;
import com.example.lab.statement.error.SemanticErrorBase;
import com.example.lab.statement.error.SemanticOK;

public record ContinueStatement(int line) implements Statement {
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		if(!context.isForDef())
			return new SemanticErrorBase("continue outside for/while", line());
		return new SemanticOK();
	}
	
}
