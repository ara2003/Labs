package com.example.lab;

import java.util.List;
import java.util.Objects;

public record Function(String name, List<? extends Type> parametrs, ReturnType returnType) {
	public Function {
		Objects.requireNonNull(parametrs);
		Objects.requireNonNull(name);
	}
	
	
	public Function(FunctionSignature signature, ReturnType returnType) {
		this(signature.name(), signature.argumentTypes(), returnType);
	}
	
	public FunctionSignature signature() {
		return new FunctionSignature(name, parametrs);
	}
	
}
