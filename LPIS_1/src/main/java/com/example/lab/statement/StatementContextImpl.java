package com.example.lab.statement;

import java.util.ArrayList;
import java.util.Collection;

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
	public void funcDef(Function function) {
		functions.add(function);
	}
	
	@Override
	public ReturnType getReturnType(FunctionSignature signature) {
		return functions.stream().filter(x -> signature.equals(x.signature())).findAny().map(Function::returnType)
				.orElseGet(() ->
				{
					throw new UnsupportedOperationException("not init function " + signature);
				});
	}
	
	@Override
	public Type getVariableType(String variable) {
		return variables.stream().filter(x -> variable.equals(x.name())).findAny().map(Variable::type).orElseGet(() -> {
			throw new UnsupportedOperationException("not init variable " + variable + " in " + variables);
		});
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
	public void initVariable(Variable variable) {
		variables.add(variable);
	}
	
}
