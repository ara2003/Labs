package com.example.lab.expression;

import java.util.List;
import java.util.Optional;

import com.example.lab.FunctionSignature;
import com.example.lab.ReturnType;
import com.example.lab.Type;
import com.example.lab.statement.StatementContext;
import com.example.lab.statement.error.SemanticError;
import com.example.lab.statement.error.SemanticErrorBase;
import com.example.lab.statement.error.SemanticOK;


public record FuncCallExpression(String name, List<? extends Expression> args, int line) implements Expression {
	
	
	public FuncCallExpression(String name, List<? extends Expression> args) {
		this(name, args, 0);
	}
	
	public FuncCallExpression(String name) {
		this(name, List.of());
	}
	
	@Override
	public Optional<Type> resolveResultType(StatementContext context) {
		var s = signature(context);
		if(s == null)
			return Optional.empty();
		return context.getReturnType(s).map(ReturnType::toType);
	}
	
	public FunctionSignature signature(StatementContext context) {
		var argTypes = args.stream().map(x -> x.resolveResultType(context)).toList();
		if(argTypes.stream().anyMatch(Optional::isEmpty))
			return null;
		return new FunctionSignature(name, argTypes.stream().map(Optional::get).toList());
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		SemanticError error;
		error = args().stream().map(x -> x.checkSemantic(context)).reduce(SemanticError::merge)
				.orElseGet(SemanticOK::new);
		if(!error.isOK())
			return error;
		
		var s = signature(context);
		if(!context.hasFunction(s))
			return new SemanticErrorBase("call not define function signature " + s, line);
		return Expression.super.checkSemantic(context);
	}
	
}
