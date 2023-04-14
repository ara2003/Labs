package com.example.lab.statement;

import com.example.lab.statement.StatementContext;

public interface SemanticChecker {
	
	default void preCheckSemantic(StatementContext context) {
		
	}
	
	void checkSemantic(StatementContext context);
	
}
