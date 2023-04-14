package com.example.lab.statement;

import java.util.List;
import java.util.Objects;

import com.example.lab.Function;
import com.example.lab.Variable;


public record FuncDefStatement(String name, List<? extends Variable> parametrs, InFunctionStatement code)
implements Statement {
	
	public FuncDefStatement(String name, InFunctionStatement code) {
		this(name, List.of(), code);
	}
	
	public FuncDefStatement {
		Objects.requireNonNull(name);
		Objects.requireNonNull(parametrs);
		Objects.requireNonNull(code);
	}
	
	@Override
	public void preCheckSemantic(StatementContext context) {
		context.funcDef(function(context));
	}
	
	@Override
	public void checkSemantic(StatementContext context) {
		var b = context.block();
		for(var p : parametrs)
			b.initVariable(p);
		code.checkSemantic(b);
	}
	
	private Function function(StatementContext context) {
		return new Function(name, parametrs, code.returnType(context));
	}
	
	private Function function() {
		return new Function(name, parametrs, code.returnType());
	}
	
	@Override
	public String toCodeString() {
		return "func " + name + "("
				+ parametrs.stream().map(x -> x.toCodeString()).reduce((a, b) -> a + ", " + b).orElse("") + ") -> "
				+ function().returnType() + ":\n\t"
				+ code.toCodeString().replace("\n", "\n\t");
	}
	
}
