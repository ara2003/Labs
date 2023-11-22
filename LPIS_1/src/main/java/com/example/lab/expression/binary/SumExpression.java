package com.example.lab.expression.binary;

import com.example.lab.expression.Expression;
import com.example.lab.interpreter.InterpreterContext;

public class SumExpression extends BinaryExpression {

    public SumExpression(Expression a, Expression b) {
        super(a, b);
    }

    public static Expression newExpression(Expression a, Expression b) {
        return new SumExpression(a, b);
    }

    @Override
    public String sign() {
        return "+";
    }

    @Override
    public int runElementInterpreter(InterpreterContext context) {
        return a.runElementInterpreter(context) + b.runElementInterpreter(context);
    }

}
