package com.example.lab;


import com.example.lab.statement.AssignTarget;
import com.example.lab.statement.VariableAssignTarget;

import antlr4.exampleBaseVisitor;
import antlr4.exampleParser.VarNameContext;

public final class LValueParseTreeVisitor extends exampleBaseVisitor<AssignTarget> {
	
	@Override
	public AssignTarget visitVarName(VarNameContext ctx) {
		return new VariableAssignTarget(ctx.getText());
	}

	
	@Override
	protected AssignTarget aggregateResult(AssignTarget aggregate, AssignTarget nextResult) {
		if(aggregate == null)
			return nextResult;
		if(nextResult == null)
			return aggregate;
		throw new UnsupportedOperationException(aggregate + " " + nextResult);
	}
	
}
