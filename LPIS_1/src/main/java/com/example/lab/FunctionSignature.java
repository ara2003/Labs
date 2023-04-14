package com.example.lab;

import java.util.List;
import java.util.Objects;

public record FunctionSignature(String name, List<? extends Type> argumentTypes) {
	
	
	public FunctionSignature {
		Objects.requireNonNull(argumentTypes);
		Objects.requireNonNull(name);
	}
	
}
