package com.example.lab;

import java.util.List;
import java.util.Objects;

public record Function(String name, List<? extends Variable> parametrs, ReturnType returnType) {
	public Function {
		Objects.requireNonNull(parametrs);
		Objects.requireNonNull(name);
		Objects.requireNonNull(returnType);
	}
	
	public FunctionSignature signature() {
		return new FunctionSignature(name, parametrs.stream().map(x -> x.type()).toList());
	}
	
}
