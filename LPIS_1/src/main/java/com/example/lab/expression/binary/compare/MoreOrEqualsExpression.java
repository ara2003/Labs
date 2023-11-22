package com.example.lab.expression.binary.compare;

import com.example.lab.expression.Expression;
import com.example.lab.expression.NumberExpression;
import com.example.lab.interpreter.InterpreterContext;

public class MoreOrEqualsExpression extends CompareBinaryExpression {
	
	public MoreOrEqualsExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	public static Expression newExpression(Expression a, Expression b) {
		if(a.equals(b))
			return new NumberExpression(1, a.line());
		return new MoreOrEqualsExpression(a, b);
	}
	
	@Override
	public String sign() {
		return ">=";
	}

	@Override
	public int runElementInterpreter(InterpreterContext context) {
		return a.runElementInterpreter(context) >= b.runElementInterpreter(context) ? 1 : 0;
	}
}
