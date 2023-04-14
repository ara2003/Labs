package com.example.lab.statement;

import java.util.List;

import com.example.lab.ReturnType;

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
	public void checkSemantic(StatementContext context) {
		for(var s : statements)
			s.checkSemantic(context);
	}
	
	@Override
	public void preCheckSemantic(StatementContext context) {
		for(var s : statements)
			s.preCheckSemantic(context);
	}
	@Override
	public String toCodeString() {
		return statements.stream().map(x -> x.toCodeString()).reduce((a, b) -> a + "\n" + b).orElse("");
	}
	
}
