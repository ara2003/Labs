package com.example.lab;

import java.util.Objects;

public record Variable(Type type, String name) {
	
	
	public Variable {
		Objects.requireNonNull(type);
		Objects.requireNonNull(name);
	}
	
	public Variable(String name) {
		this(Type.ELEMENT, name);
	}
	
	public String toCodeString() {
		if(type == Type.LIST)
			return "list " + name;
		return name;
	}
}
