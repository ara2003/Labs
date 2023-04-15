package com.example.lab.statement;

import java.util.List;
import java.util.stream.Stream;

import com.example.lab.expression.Expression;
import com.example.lab.statement.error.MergeSemanticError;
import com.example.lab.statement.error.SemanticError;

public record SwitchStatement(Expression expr, List<? extends Statement> caseStat) implements Statement {
	
	@Override
	public int line() {
		return expr.line();
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		var e = expr.checkSemantic(context);
		return MergeSemanticError
				.newError(Stream.concat(Stream.of(e), caseStat.stream().map(x -> x.checkSemantic(context))).toList());
	}
	
}
