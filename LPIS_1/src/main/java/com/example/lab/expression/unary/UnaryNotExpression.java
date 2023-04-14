package com.example.lab.expression.unary;

import com.example.lab.expression.Expression;

public class UnaryNotExpression extends UnaryExpression {
	
	public UnaryNotExpression(Expression arg) {
		super(arg);
	}
	
	public static Expression newExpression(Expression expr) {
		return expr;
	}
	
	@Override
	public String sign() {
		return "not";
	}
	
}
