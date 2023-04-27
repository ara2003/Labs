package com.example.lab.expression;

import java.util.Optional;

import com.example.lab.SemanticChecker;
import com.example.lab.Type;
import com.example.lab.statement.StatementContext;

public interface Expression extends SemanticChecker {
	
	Type getType(StatementContext context);
	
	default Optional<Type> tryGetType() {
		return Optional.of(getType(null));
	}
	
}
