package com.example.lab.statement.error;

import java.io.PrintStream;

public record SemanticOK() implements SemanticError {
	
	@Override
	public void show(PrintStream out) {
	}
	
	@Override
	public boolean isOK() {
		return true;
	}
	
	@Override
	public SemanticError merge(SemanticError other) {
		return other;
	}
	
}
