package com.example.lab.statement;

import java.util.List;
import java.util.Objects;

import com.example.lab.Function;
import com.example.lab.Variable;
import com.example.lab.statement.error.SemanticError;


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
	public void preCheckSemantic(StatementContext context) {
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		var b = context.block();
		for(var p : parametrs)
			b.initVariable(p);
		context.funcDef(function(b));
		return code.checkSemantic(b);
	}
	
	private Function function(StatementContext context) {
		return new Function(name, parametrs, code.tryResolveReturnType(context));
	}
	
}
