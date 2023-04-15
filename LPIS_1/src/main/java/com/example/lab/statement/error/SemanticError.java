package com.example.lab.statement.error;

import java.io.PrintStream;

public interface SemanticError {
	
	void show(PrintStream out);
	
	default boolean isOK() {
		return false;
	}
	
	SemanticError merge(SemanticError other);
}
