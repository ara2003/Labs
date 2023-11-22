package com.example.lab.expression.binary.compare;

import com.example.lab.expression.Expression;
import com.example.lab.interpreter.InterpreterContext;

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

	@Override
	public int runElementInterpreter(InterpreterContext context) {
		return a.runElementInterpreter(context) < b.runElementInterpreter(context) ? 1 : 0;
	}
}
