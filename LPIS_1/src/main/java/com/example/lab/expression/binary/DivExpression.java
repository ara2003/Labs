package com.example.lab.expression.binary;

import com.example.lab.expression.Expression;

public class DivExpression extends BinaryExpression {
	
	public DivExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		return new DivExpression(a, b);
	}
	
	@Override
	public String sign() {
		return "*";
	}
	
}
