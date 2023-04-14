package com.example.lab.expression.binary.compare;


import com.example.lab.Type;
import com.example.lab.expression.Expression;
import com.example.lab.expression.binary.BinaryExpression;
import com.example.lab.statement.StatementContext;

public abstract class CompareBinaryExpression extends BinaryExpression {
	
	public CompareBinaryExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	@Override
	public void checkSemantic(StatementContext context) {
		super.checkSemantic(context);
		resolveResultType(context);
	}
	
	@Override
	public Type resolveResultType(StatementContext context) {
		var aType = a.resolveResultType(context);
		var bType = b.resolveResultType(context);
		if(aType == Type.LIST || bType == Type.LIST)
			throw new UnsupportedOperationException("compare list " + toMathString());
		return Type.ELEMENT;
	}
	
	@Override
	public Type tryResolveResultType() {
		var aType = a.tryResolveResultType();
		var bType = b.tryResolveResultType();
		if(aType == Type.LIST || bType == Type.LIST)
			throw new UnsupportedOperationException("compare list " + toMathString());
		return Type.ELEMENT;
	}
	
}
