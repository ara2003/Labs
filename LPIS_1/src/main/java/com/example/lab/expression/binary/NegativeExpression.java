package com.example.lab.expression.binary;

import com.example.lab.expression.Expression;

public class NegativeExpression extends BinaryExpression {
	
	public NegativeExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		return new NegativeExpression(a, b);
	}
	
	@Override
	public String sign() {
		return "-";
	}
	
}
