package com.example.lab;

import com.example.lab.statement.StatementContext;
import com.example.lab.statement.error.SemanticError;
import com.example.lab.statement.error.SemanticOK;

public interface SemanticChecker {
	
	default SemanticError checkSemantic(StatementContext context) {
		return new SemanticOK();
	}
	
	int line();
	
}
