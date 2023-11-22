package com.example.lab.statement;

import com.example.lab.interpreter.InterpreterContext;

public class EmptyStatement implements Statement {

    @Override
    public int line() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void runInterpreter(InterpreterContext context) {
    }

}
