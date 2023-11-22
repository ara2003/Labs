package com.example.lab.statement;

import java.util.List;
import java.util.Objects;

import com.example.lab.Function;
import com.example.lab.FunctionSignature;
import com.example.lab.ReturnType;
import com.example.lab.SemanticError;
import com.example.lab.Variable;
import com.example.lab.interpreter.InterpreterContext;

public record FuncDefStatement(String name, List<? extends Variable> parametrs, Statement code)
implements Statement {
	
	public FuncDefStatement(String name, Statement code) {
		this(name, List.of(), code);
	}
	
	public FuncDefStatement {
		Objects.requireNonNull(name);
		Objects.requireNonNull(parametrs);
		Objects.requireNonNull(code);
	}

	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(context.isReturn())
			return SemanticError.printReturnError(line());
		var b = context.funcDefBlock();
		for(var p : parametrs)
			b.initVariable(p);
		if(!code.checkContextSemantic(b))
			return false;
		var func = function(b);
		context.funcDef(func);
		return true;
	}
	
	private FunctionSignature signature(StatementContext context) {
		return new FunctionSignature(name, parametrs.stream().map(x -> x.type()).toList());
	}
	
	private Function function(StatementContext context) {
		final ReturnType returnType;
		try {
			returnType = code.tryResolveReturnType(context).orElse(ReturnType.VOID);
		}catch (Exception e) {
			throw new RuntimeException("" + name, e);
		}
		return new Function(signature(context), returnType);
	}
	
	@Override
	public int line() {
		return code.line() - 1;
	}
	
}
