package com.example.lab.expression.binary;

import java.util.Optional;

import com.example.lab.Type;
import com.example.lab.expression.Expression;
import com.example.lab.statement.StatementContext;
import com.example.lab.statement.error.MergeSemanticError;
import com.example.lab.statement.error.SemanticError;

public abstract class BinaryExpression implements Expression {
	
	protected final Expression a, b;
	
	public BinaryExpression(Expression a, Expression b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int line() {
		return a.line();
	}
	
	public abstract String sign();
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + a + ", " + b + "]";
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		return MergeSemanticError.newError(a.checkSemantic(context), b.checkSemantic(context));
	}
	
	@Override
	public Optional<Type> resolveResultType(StatementContext context) {
		var aOptType = a.resolveResultType(context);
		if(aOptType.isEmpty())
			return Optional.empty();
		var aType = aOptType.get();
		
		var bOptType = b.resolveResultType(context);
		if(bOptType.isEmpty())
			return Optional.empty();
		var bType = bOptType.get();
		
		if(aType == Type.ELEMENT && bType == Type.ELEMENT)
			return Optional.of(Type.ELEMENT);
		return Optional.of(Type.LIST);
	}
	
}
