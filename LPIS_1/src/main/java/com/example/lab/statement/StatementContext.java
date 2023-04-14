package com.example.lab.statement;

import java.util.stream.Stream;

import com.example.lab.Function;
import com.example.lab.FunctionSignature;
import com.example.lab.ReturnType;
import com.example.lab.Type;
import com.example.lab.Variable;

public interface StatementContext {
	
	void initVariable(Variable variable);
	boolean hasVariable(Variable variable);
	Type getVariableType(String variable);
	
	default void checkSemantic(Stream<? extends Variable> variables) {
		variables.forEach(x -> {
			if(!hasVariable(x))
				throw new UnsupportedOperationException("use not define variable " + x);
		});
	}
	
	default StatementContext block() {
		return this;
	}
	
	ReturnType getReturnType(FunctionSignature function);
	void funcDef(Function function);
	boolean hasFunction(FunctionSignature signature);
	
	default void initVariable(String name) {
		initVariable(new Variable(name));
	}
	
	
	
}
