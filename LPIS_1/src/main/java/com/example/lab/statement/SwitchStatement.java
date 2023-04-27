package com.example.lab.statement;

import java.util.List;

import com.example.lab.SemanticError;
import com.example.lab.Type;
import com.example.lab.expression.Expression;

public record SwitchStatement(Expression expr, List<? extends Statement> caseStatements, Statement defaultStatement)
		implements Statement {
	
	@Override
	public int line() {
		return expr.line();
	}
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		boolean result = true;
		if(expr.checkContextSemantic(context)) {
			var type = expr.getType(context);
			if(type != null)
				result &= SemanticError.printIf("type of swich argument is not element", line(),
						type.equals(Type.ELEMENT));
		}else
			result = false;
		for(var x : caseStatements)
			result &= x.checkContextSemantic(context);
		result &= defaultStatement.checkContextSemantic(context);
		return result;
	}
	
	
}
