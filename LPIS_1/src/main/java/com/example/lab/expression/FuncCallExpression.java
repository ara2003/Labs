package com.example.lab.expression;

import java.util.List;
import java.util.stream.Stream;

import com.example.lab.FunctionSignature;
import com.example.lab.Type;
import com.example.lab.statement.StatementContext;


public record FuncCallExpression(String name, List<? extends Expression> args) implements Expression {
	
	
	public FuncCallExpression(String func) {
		this(func, List.of());
	}
	
	@Override
	public Stream<String> useVariables() {
		return args.stream().flatMap(Expression::useVariables);
	}
	
	@Override
	public Stream<String> useFunctions() {
		return Stream.concat(Stream.of(name), args.stream().flatMap(Expression::useFunctions));
	}
	
	@Override
	public Type tryResolveResultType() {
		return null;
	}
	
	@Override
	public String toMathString() {
		return name + "(" + args.stream().map(Expression::toMathString).reduce((a, b) -> a + ", " + b).orElse("") + ")";
	}
	
	@Override
	public Type resolveResultType(StatementContext context) {
		return context.getReturnType(signature(context)).toType();
	}
	
	public FunctionSignature signature(StatementContext context) {
		return new FunctionSignature(name, args.stream().map(x -> x.resolveResultType(context)).toList());
	}
	
	
	@Override
	public void checkSemantic(StatementContext context) {
		Expression.super.checkSemantic(context);
		args().forEach(x -> x.checkSemantic(context));
		var s = signature(context);
		if(!context.hasFunction(s))
			throw new RuntimeException("call not define function signature " + s);
	}
}
