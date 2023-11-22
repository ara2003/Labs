package com.example.lab.expression;

import com.example.lab.FunctionContext;
import com.example.lab.Type;
import com.example.lab.interpreter.InterpreterContext;

public record NumberExpression(int value, int line) implements Expression {

    public NumberExpression(String value, int line) {
        this(Integer.parseInt(value), line);
    }

    public NumberExpression {
    }

    @Override
    public Type getType(FunctionContext context) {
        return Type.ELEMENT;
    }

    @Override
    public int runElementInterpreter(InterpreterContext context) {
        return value;
    }

}
