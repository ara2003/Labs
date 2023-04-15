package com.example.lab;

import java.util.List;
import java.util.Objects;

public record FunctionSignature(String name, List<? extends Type> argumentTypes) {
	
	
	public FunctionSignature {
		Objects.requireNonNull(argumentTypes);
		Objects.requireNonNull(name);
		for(var type : argumentTypes)
			Objects.requireNonNull(type);
	}
	
	@Override
	public String toString() {
		return name + "(" + argumentTypes.stream().map(x -> x.toString()).reduce((a, b) -> a + ", " + b).orElse("")
				+ ")";
	}
	
	
	
}
