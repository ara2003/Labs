package com.example.lab.expression.binary;

import com.example.lab.expression.Expression;

public class AndExpression extends BinaryExpression {
	
	public AndExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		return new AndExpression(a, b);
	}
	
	@Override
	public String sign() {
		return "*";
	}
	
}
