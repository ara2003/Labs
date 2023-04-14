package com.example.lab.expression.unary;

import com.example.lab.expression.Expression;

public class UnaryPlusExpression extends UnaryExpression {
	
	public UnaryPlusExpression(Expression arg) {
		super(arg);
	}
	
	public static Expression newExpression(Expression expr) {
		return expr;
	}
	
	@Override
	public String sign() {
		return "+";
	}
	
}
