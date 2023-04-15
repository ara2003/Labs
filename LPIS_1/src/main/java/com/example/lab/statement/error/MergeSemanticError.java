package com.example.lab.statement.error;

import java.io.PrintStream;
import java.util.List;


public record MergeSemanticError(List<? extends SemanticError> errors) implements SemanticError {
	
	public MergeSemanticError(List<? extends SemanticError> errors) {
		this.errors = errors.stream().filter(x -> !x.isOK()).toList();
	}
	
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
		if(equals(other))
			return other;
		if(other.isOK())
			return this;
		if(isOK())
			return other;
		return MergeSemanticError.newError(this, other);
	}
	
	public static SemanticError newError(List<? extends SemanticError> errors) {
		return new MergeSemanticError(errors);
	}
	
	public static SemanticError newError(SemanticError... errors) {
		return newError(List.of(errors));
	}
	
	@Override
	public boolean isOK() {
		return errors.stream().map(x -> x.isOK()).reduce(true, (a, b) -> a && b);
	}
	
}
