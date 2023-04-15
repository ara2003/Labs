package com.example.lab.expression.binary.compare;


import java.util.Optional;

import com.example.lab.Type;
import com.example.lab.expression.Expression;
import com.example.lab.expression.binary.BinaryExpression;
import com.example.lab.statement.StatementContext;
import com.example.lab.statement.error.SemanticError;
import com.example.lab.statement.error.SemanticErrorBase;
import com.example.lab.statement.error.SemanticOK;

public abstract class CompareBinaryExpression extends BinaryExpression {
	
	public CompareBinaryExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	@Override
	public SemanticError checkSemantic(StatementContext context) {
		var result = super.checkSemantic(context);
		if(!result.isOK())
			return result;
		
		var aOptType = a.resolveResultType(context);
		var bOptType = b.resolveResultType(context);
		
		final SemanticError e1, e2;
		
		if(aOptType.isEmpty())
			e1 = new SemanticErrorBase("can not resolve type of right comporating operator", a.line());
		else {
			var aType = aOptType.get();
			if(aType == Type.ELEMENT)
				e1 = new SemanticOK();
			else
				e1 = new SemanticErrorBase("type of right comporating operator is list", a.line());
		}
		if(bOptType.isEmpty())
			e2 = new SemanticErrorBase("can not resolve type of left comporating operator", b.line());
		else {
			var bType = bOptType.get();
			if(bType == Type.ELEMENT)
				e2 = new SemanticOK();
			else
				e2 = new SemanticErrorBase("type of left comporating operator is list", b.line());
		}
		
		return e1.merge(e2);
	}
	
	@Override
	public Optional<Type> resolveResultType(StatementContext context) {
		return Optional.of(Type.ELEMENT);
	}
}
