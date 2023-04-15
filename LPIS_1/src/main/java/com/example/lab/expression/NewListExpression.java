package com.example.lab.expression;

import java.util.List;
import java.util.Optional;

import com.example.lab.Type;
import com.example.lab.statement.StatementContext;
import com.example.lab.statement.error.MergeSemanticError;
import com.example.lab.statement.error.SemanticError;


public record NewListExpression(List<? extends Expression> args, int line) implements Expression {
	
	
	public NewListExpression(int line) {
		this(List.of(), line);
	}
	
	
	public NewListExpression {
	}
	
	@Override
	public Optional<Type> resolveResultType(StatementContext context) {
		return Optional.of(Type.LIST);
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		return MergeSemanticError.newError(args.stream().map(x -> x.checkSemantic(context)).toList());
	}
	
}
