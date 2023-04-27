package com.example.lab.statement;

public class EmptyStatement implements Statement {
	
	@Override
	public int line() {
		throw new UnsupportedOperationException();
	}
	
}
