package com.example.lab.expression;

import com.example.lab.expression.binary.BinaryExpression;

public class RemainderDivisionExpression extends BinaryExpression {
	
	public RemainderDivisionExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		return new RemainderDivisionExpression(a, b);
	}
	
	@Override
	public String sign() {
		return "%";
	}
	
}
