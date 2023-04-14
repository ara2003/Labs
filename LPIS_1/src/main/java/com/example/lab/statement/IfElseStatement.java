package com.example.lab.statement;

import com.example.lab.expression.Expression;

public record IfElseStatement(Expression expr, Statement Then, Statement Else) implements Statement {
	
	public IfElseStatement {
	}
	
	public static Statement newStatement(Expression expr, Statement Then, Statement Else) {
		var exprValue = expr.tryGetConstElementValue();
		if(exprValue != null) {
			if(exprValue == 0)
				return Else;
			return Then;
		}
		return new IfElseStatement(expr, Then, Else);
	}
	
	@Override
	public void checkSemantic(StatementContext context) {
		expr.checkSemantic(context);
		Then.checkSemantic(context);
		Else.checkSemantic(context);
	}
	
	@Override
	public String toCodeString() {
		return "if " + expr.toMathString() + ":\n\t" + Then.toCodeString().replace("\n", "\n\t") + "\nelse:\n\t"
				+ Else.toCodeString().replace("\n", "\n\t");
	}
	
}
