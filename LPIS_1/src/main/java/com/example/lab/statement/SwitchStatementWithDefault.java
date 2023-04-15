package com.example.lab.statement;

import java.util.List;
import java.util.stream.Stream;

import com.example.lab.expression.Expression;
import com.example.lab.statement.error.MergeSemanticError;
import com.example.lab.statement.error.SemanticError;

public record SwitchStatementWithDefault(Expression expr, List<Statement> caseStat, Statement defaultStat)
implements Statement {
	
	@Override
	public int line() {
		return expr.line();
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		var e1 = expr.checkSemantic(context);
		var e2 = defaultStat.checkSemantic(context);
		return MergeSemanticError.newError(
				Stream.concat(Stream.of(e1, e2), caseStat.stream().map(x -> x.checkSemantic(context))).toList());
	}
}
