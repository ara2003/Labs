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
	
	private final boolean isFuncDef, isForDef;
	private boolean isReturn = false;
	
	
	public StatementContextImpl() {
		this(false, false);
	}
	
	private StatementContextImpl(boolean isFuncDef, boolean isForDef) {
		this.isFuncDef = isFuncDef;
		this.isForDef = isForDef;
	}
	
	@Override
	public StatementContext block() {
		var block = new StatementContextImpl(isFuncDef, isForDef);
		block.variables.addAll(variables);
		block.functions.addAll(functions);
		return block;
	}
	
	@Override
	public StatementContext forDefBlock() {
		var block = new StatementContextImpl(isFuncDef, true);
		block.variables.addAll(variables);
		block.functions.addAll(functions);
		return block;
	}
	
	@Override
	public void funcDef(Function function) {
		functions.add(function);
	}
	
	@Override
	public StatementContext funcDefBlock() {
		var block = new StatementContextImpl(true, false);
		block.variables.addAll(variables);
		block.functions.addAll(functions);
		return block;
	}
	
	@Override
	public Optional<ReturnType> getReturnType(FunctionSignature signature) {
		Objects.requireNonNull(signature);
		return functions.stream().filter(x -> signature.equals(x.signature())).findAny().map(Function::returnType);
	}
	
	@Override
	public Optional<Type> getVariableType(String variable) {
		return variables.stream().filter(x -> variable.equals(x.name())).findAny().map(Variable::type);
	}
	
	@Override
	public boolean hasFunction(FunctionSignature signature) {
		return functions.stream().map(x -> x.signature()).anyMatch(x -> x.equals(signature));
	}
	
	@Override
	public boolean hasVariable(String name) {
		return variables.stream().anyMatch(x -> name.equals(x.name()));
	}
	
	@Override
	public boolean hasVariable(Variable variable) {
		return variables.contains(variable);
	}
	
	@Override
	public void initVariable(Variable variable) {
		if(hasVariable(variable.name()))
			throw new IllegalArgumentException("var alredy init");
		variables.add(variable);
	}
	
	@Override
	public boolean isForDef() {
		return isForDef;
	}
	
	@Override
	public boolean isFuncDef() {
		return isFuncDef;
	}
	
	@Override
	public String toString() {
		return "StatementContextImpl [" + variables + ", " + functions + "]";
	}
	
	@Override
	public boolean isReturn() {
		return isReturn;
	}
	
	@Override
	public void setReturn() {
		isReturn = true;
	}
	
}
