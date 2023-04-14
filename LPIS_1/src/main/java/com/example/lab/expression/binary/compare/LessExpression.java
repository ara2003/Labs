package com.example.lab.expression.binary.compare;

import com.example.lab.expression.Expression;

public class LessExpression extends CompareBinaryExpression {
	
	public LessExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		return new LessExpression(a, b);
	}
	
	@Override
	public String sign() {
		return "<";
	}
	
}
