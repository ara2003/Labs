package com.example.lab.expression.unary;

import com.example.lab.FunctionContext;
import com.example.lab.Type;
import com.example.lab.expression.Expression;

public abstract class UnaryExpression implements Expression {

    protected final Expression arg;

    public UnaryExpression(Expression arg) {
        this.arg = arg;
    }

    @Override
    public Type getType(FunctionContext context) {
        return arg.getType(context);
    }

    public abstract String sign();

    @Override
    public int line() {
        return arg.line();
    }

}
