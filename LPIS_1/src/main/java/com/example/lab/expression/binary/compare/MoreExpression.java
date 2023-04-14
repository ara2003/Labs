package com.example.lab.expression.binary.compare;

import com.example.lab.expression.Expression;
import com.example.lab.expression.NumberExpression;

public class MoreExpression extends CompareBinaryExpression {
	
	public MoreExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		var aValue = a.tryGetConstElementValue();
		var bValue = b.tryGetConstElementValue();
		
		if(aValue != null && bValue != null)
			return NumberExpression.getBoolean(aValue > bValue);
		
		return new MoreExpression(a, b);
	}
	
	@Override
	public String sign() {
		return ">";
	}
	
}
