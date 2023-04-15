package com.example.lab.statement.error;

import java.io.PrintStream;

public record SemanticErrorBase(String text, int line) implements SemanticError {
	
	
	public SemanticErrorBase {
		if(text.isBlank())
			throw new IllegalArgumentException("black text");
	}
	
	@Override
	public void show(PrintStream out) {
		out.println("Semantic Error: line:" + line + " " + text);
	}
	
	@Override
	public SemanticError merge(SemanticError other) {
		if(other.isOK())
			return this;
		return new MergeSemanticError(this, other);
	}
	
}
