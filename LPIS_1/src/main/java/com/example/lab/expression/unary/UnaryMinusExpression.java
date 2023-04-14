package com.example.lab.expression.unary;

import com.example.lab.expression.Expression;

public class UnaryMinusExpression extends UnaryExpression {
	
	public UnaryMinusExpression(Expression arg) {
		super(arg);
	}
	
	public static Expression newExpression(Expression expr) {
		return new UnaryMinusExpression(expr);
	}
	
	@Override
	public String sign() {
		return "-";
	}
	
}
