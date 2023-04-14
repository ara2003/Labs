package com.example.lab.expression.binary;

import com.example.lab.expression.Expression;

public class XORExpression extends BinaryExpression {
	
	public XORExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		return new XORExpression(a, b);
	}
	
	@Override
	public String sign() {
		return "*";
	}
	
}
