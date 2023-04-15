package com.example.lab.expression.binary.compare;

import com.example.lab.expression.Expression;

public class MoreExpression extends CompareBinaryExpression {
	
	public MoreExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		return new MoreExpression(a, b);
	}
	
	@Override
	public String sign() {
		return ">";
	}
	
}
