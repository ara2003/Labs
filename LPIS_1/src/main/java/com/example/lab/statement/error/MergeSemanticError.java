package com.example.lab.statement.error;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;


public record MergeSemanticError(List<? extends SemanticError> errors) implements SemanticError {
	
	
	public MergeSemanticError(SemanticError... errors) {
		this(List.of(errors));
	}
	
	@Override
	public void show(PrintStream out) {
		for(var e : errors)
			e.show(out);
	}
	
	@Override
	public SemanticError merge(SemanticError other) {
		return Stream.concat(Stream.of(other), errors.stream()).reduce(SemanticError::merge).get();
	}
	
	public static SemanticError newError(List<? extends SemanticError> errors) {
		return errors.stream().map(x -> (SemanticError) x).reduce(SemanticError::merge)
				.get();
	}
	
	public static SemanticError newError(SemanticError... errors) {
		return newError(List.of(errors));
	}
	
}
