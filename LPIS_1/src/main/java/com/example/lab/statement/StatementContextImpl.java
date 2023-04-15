package com.example.lab.statement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import com.example.lab.Function;
import com.example.lab.FunctionSignature;
import com.example.lab.ReturnType;
import com.example.lab.Type;
import com.example.lab.Variable;

public class StatementContextImpl implements StatementContext {
	
	private final Collection<Variable> variables = new ArrayList<>();
	private final Collection<Function> functions = new ArrayList<>();
	
	@Override
	public StatementContext block() {
		var block = new StatementContextImpl();
		block.variables.addAll(variables);
		block.functions.addAll(functions);
		return block;
	}
	
	@Override
	public String toString() {
		return "StatementContextImpl [" + variables + ", " + functions + "]";
	}
	
	@Override
	public void funcDef(Function function) {
		functions.add(function);
	}
	
	@Override
	public Optional<ReturnType> getReturnType(FunctionSignature signature) {
		Objects.requireNonNull(signature);
		return functions.stream().filter(x -> signature.equals(x.signature())).findAny().map(Function::returnType);
	}
	
	@Override
	public Optional<Type> getVariableType(String variable) {
		return variables.stream().filter(x -> variable.equals(x.name())).findAny().map(x -> x.type());
	}
	
	@Override
	public boolean hasFunction(FunctionSignature signature) {
		return functions.stream().anyMatch(x -> signature.equals(x.signature()));
	}
	
	@Override
	public boolean hasVariable(Variable variable) {
		return variables.contains(variable);
	}
	
	@Override
	public boolean hasVariable(String name) {
		return variables.stream().anyMatch(x -> name.equals(x.name()));
	}
	
	@Override
	public void initVariable(Variable variable) {
		variables.add(variable);
	}
	
}
