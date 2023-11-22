package com.example.lab.expression.binary;

import com.example.lab.FunctionContext;
import com.example.lab.Type;
import com.example.lab.expression.Expression;
import com.example.lab.statement.StatementContext;

public abstract class BinaryExpression implements Expression {

    protected final Expression a, b;

    public BinaryExpression(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    public abstract String sign();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + a + ", " + b + "]";
    }

    @Override
    public boolean checkContextSemantic(StatementContext context) {
        return a.checkContextSemantic(context) && b.checkContextSemantic(context);
    }

    @Override
    public int line() {
        return a.line();
    }

    @Override
    public Type getType(FunctionContext context) {
        var aType = a.getType(context);
        var bType = b.getType(context);
        if (aType == Type.LIST || bType == Type.LIST)
            return Type.LIST;
        if (aType == Type.ELEMENT && bType == Type.ELEMENT)
            return Type.ELEMENT;
        return null;
    }

}
