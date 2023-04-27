package com.example.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record FunctionSignature(String name, List<? extends Type> argumentTypes) {
	
	
	public FunctionSignature(String name, List<? extends Type> argumentTypes) {
		Objects.requireNonNull(argumentTypes);
		Objects.requireNonNull(name);
		for(var type : argumentTypes)
			Objects.requireNonNull(type);
		this.name = name;
		this.argumentTypes = new ArrayList<>(argumentTypes);
	}
	
	@Override
	public String toString() {
		return name + "(" + argumentTypes.stream().map(x -> x.toString()).reduce((a, b) -> a + ", " + b).orElse("")
				+ ")";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(argumentTypes, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof FunctionSignature)) {
			return false;
		}
		FunctionSignature other = (FunctionSignature) obj;
		if(!Objects.equals(name, other.name))
			return false;
		return Objects.equals(argumentTypes, other.argumentTypes);
	}
	
}
