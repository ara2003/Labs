package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.SemanticChecker;

public interface Statement extends SemanticChecker {

	
	default void preCheckSemantic(StatementContext context) {
		
	}
	
	default ReturnType tryResolveReturnType(StatementContext context) {
		return null;
	}
	
	String toCodeString();
	
}
