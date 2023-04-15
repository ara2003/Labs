package com.example.lab.statement;

import java.util.List;

import com.example.lab.ReturnType;
import com.example.lab.statement.error.MergeSemanticError;
import com.example.lab.statement.error.SemanticError;

public record MergeStatement(List<? extends Statement> statements) implements Statement {
	
	public static Statement newStatement(List<? extends Statement> statements) {
		return new MergeStatement(statements);
	}
	public static Statement newStatement(Statement... statements) {
		return newStatement(List.of(statements));
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		ReturnType type = null;
		for(var s : statements) {
			type = s.tryResolveReturnType(context);
			if(type != null)
				return type;
		}
		return type;
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		return MergeSemanticError.newError(statements.stream().map(x -> x.checkSemantic(context)).toList());
	}
	
	@Override
	public void preCheckSemantic(StatementContext context) {
		for(var s : statements)
			s.preCheckSemantic(context);
	}
	
}
