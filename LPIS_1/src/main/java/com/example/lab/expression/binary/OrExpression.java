package com.example.lab.expression.binary;

import com.example.lab.expression.Expression;

public class OrExpression extends BinaryExpression {
	
	public OrExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		return new OrExpression(a, b);
	}
	
	@Override
	public String sign() {
		return "*";
	}
	
}
