package com.example.lab.statement;

import java.util.Optional;

import com.example.lab.ReturnType;
import com.example.lab.SemanticError;
import com.example.lab.Type;
import com.example.lab.expression.Expression;

public record IfStatement(Expression expr, Statement Then, Statement Else) implements Statement {
	
	public IfStatement {
	}
	
	public static Statement newStatement(Expression expr, Statement Then, Statement Else) {
		return new IfStatement(expr, Then, Else);
	}
	
	@Override
	public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
		var thenReturnType = Then.tryResolveReturnType(context);
		var elseReturnType = Else.tryResolveReturnType(context);
		
		if(thenReturnType.isEmpty())
			return elseReturnType;
		if(elseReturnType.isEmpty())
			return thenReturnType;
		
		//		if(thenReturnType.get() == ReturnType.VOID)
		//			return elseReturnType;
		//		if(elseReturnType.get() == ReturnType.VOID)
		//			return thenReturnType;
		
		throw new UnsupportedOperationException(thenReturnType + " " + elseReturnType);
	}
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		var thenBlock = context.block();
		var elseBlock = context.block();
		boolean result = true;
		if(expr.checkContextSemantic(context)) {
			var type = expr.getType(context);
			if(type != null)
				result &= SemanticError.printIf("type of if argument is not element", line(),
						type.equals(Type.ELEMENT));
		}else
			result = false;
		result &= Then.checkContextSemantic(thenBlock);
		result &= Else.checkContextSemantic(elseBlock);
		if(thenBlock.isReturn() && elseBlock.isReturn())
			context.setReturn();
		return result;
	}
	
	@Override
	public int line() {
		return expr.line();
	}
	
}
