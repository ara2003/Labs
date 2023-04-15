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
		return switch(type) {
			case ELEMENT -> "element " + name;
			case LIST -> "list " + name;
		};
	}
}
