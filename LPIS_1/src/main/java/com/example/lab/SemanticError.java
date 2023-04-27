package com.example.lab;

public class SemanticError {
	
	public static boolean print(String message, int line) {
		System.out.println("Semantic Error line: " + line + " message: " + message);
		return false;
	}
	
	public static boolean printReturnError(int line) {
		return print("alredy return", line);
	}
	
	public static boolean printIf(String message, int line, boolean a) {
		if(a)
			return true;
		return print(message, line);
	}
	
}
