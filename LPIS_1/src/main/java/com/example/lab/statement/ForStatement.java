package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.expression.Expression;


public record ForStatement(String index, Expression iter_list, Statement code) implements Statement {
	
	@Override
	public void checkSemantic(StatementContext context) {
		iter_list.checkSemantic(context);
		var b = context.block();
		b.initVariable(index);
		code.checkSemantic(b);
	}
	
	@Override
	public String toCodeString() {
		return "for " + index + " in " + iter_list.toMathString() + ":\n\t" + code.toCodeString().replace("\n", "\n\t");
	}
	
	@Override
	public ReturnType tryResolveReturnType(StatementContext context) {
		var b = context.block();
		b.initVariable(index);
		return code.tryResolveReturnType(b);
	}
	
}
