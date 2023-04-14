package com.example.lab.expression.binary.compare;

import com.example.lab.expression.Expression;
import com.example.lab.expression.NumberExpression;

public class EqualsExpression extends CompareBinaryExpression {
	
	public EqualsExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		if(a.equals(b))
			return NumberExpression.TRUE;
		return new EqualsExpression(a, b);
	}
	
	@Override
	public String sign() {
		return "==";
	}
	
}
