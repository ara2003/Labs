package com.example.lab.statement;

import java.util.Optional;

import com.example.lab.ReturnType;
import com.example.lab.SemanticChecker;

public interface Statement extends SemanticChecker {
	
	default Optional<ReturnType> tryResolveReturnType(StatementContext context) {
		return Optional.empty();
	}
	
}
