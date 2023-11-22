package com.example.lab.statement;

import com.example.lab.Type;
import com.example.lab.expression.Expression;
import com.example.lab.interpreter.InterpreterContext;

public interface AssignTarget extends Expression {

    boolean init(StatementContext context, Type type);

    void assign(InterpreterContext context, Expression expr);

}