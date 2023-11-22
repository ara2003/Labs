package com.example.lab.expression;

import com.example.lab.*;
import com.example.lab.interpreter.InterpreterContext;
import com.example.lab.statement.StatementContext;

import java.util.List;

public record FuncCallExpression(String name, List<? extends Expression> args, int line) implements Expression {

    public FuncCallExpression(String name, int line) {
        this(name, List.of(), line);
    }

    @Override
    public Type getType(FunctionContext context) {
        var s = signature(context);
        return context.getReturnType(s).map(x -> x.toType()).orElse(null);
    }

    @Override
    public void runVoidInterpreter(InterpreterContext context) {
        context.callFunctionVoid(name, args.stream().map(x -> x.runInterpreter(context)).toList());
    }

    public FunctionSignature signature(FunctionContext context) {
        var argTypes = args.stream().map(x -> x.getType(context)).toList();
        return new FunctionSignature(name, argTypes);
    }

    @Override
    public boolean checkContextSemantic(StatementContext context) {
        if (!args().stream().map(x -> x.checkContextSemantic(context)).allMatch(x -> x))
            return false;
        var s = signature(context);
        if (!context.hasFunction(s))
            return SemanticError.print("call not define function signature " + s, line);
        var type = context.getReturnType(s).get();
        if (type == ReturnType.VOID)
            return SemanticError.print("get return on void function " + s, line);
        return Expression.super.checkContextSemantic(context);
    }

}
