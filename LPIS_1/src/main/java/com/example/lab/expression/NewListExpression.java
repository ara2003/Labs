package com.example.lab.expression;

import java.util.List;
import java.util.stream.Stream;

import com.example.lab.Type;


public record NewListExpression(List<? extends Expression> args) implements Expression {
	
	
	public NewListExpression() {
		this(List.of());
	}
	
	@Override
	public Stream<String> useVariables() {
		return args.stream().flatMap(Expression::useVariables);
	}
	
	@Override
	public Stream<String> useFunctions() {
		return args.stream().flatMap(Expression::useFunctions);
	}
	
	@Override
	public Type tryResolveResultType() {
		return Type.LIST;
	}
	
	@Override
	public List<Integer> tryGetConstListValue() {
		var values = args.stream().map(x -> x.tryGetConstElementValue()).toList();
		if(values.contains(null))
			return null;
		return values;
	}
	
	@Override
	public String toMathString() {
		return "[" + args.stream().map(Expression::toMathString).reduce((a, b) -> a + ", " + b).orElse("") + "]";
	}
	
}
