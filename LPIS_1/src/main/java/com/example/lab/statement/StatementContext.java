package com.example.lab.statement;

import java.util.Optional;

import com.example.lab.Function;
import com.example.lab.FunctionSignature;
import com.example.lab.ReturnType;
import com.example.lab.Type;
import com.example.lab.Variable;

public interface StatementContext {
	
	default StatementContext block() {
		return this;
	}
	
	void funcDef(Function function);
	
	Optional<ReturnType> getReturnType(FunctionSignature function);
	
	Optional<Type> getVariableType(String variable);
	
	boolean hasFunction(FunctionSignature signature);
	boolean hasVariable(String name);
	
	default boolean hasVariable(Variable variable) {
		return hasVariable(variable.name());
	}
	
	default void initVariable(String name) {
		initVariable(new Variable(name));
	}
	
	void initVariable(Variable variable);
	
	
	
}
