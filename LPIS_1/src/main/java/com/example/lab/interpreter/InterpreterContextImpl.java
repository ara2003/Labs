package com.example.lab.interpreter;

import com.example.lab.FunctionSignature;
import com.example.lab.ReturnType;
import com.example.lab.Type;
import com.example.lab.statement.StatementContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InterpreterContextImpl implements InterpreterContext {

    private final StatementContext context;
    private final Map<String, Object> values = new HashMap<>();

    public InterpreterContextImpl(StatementContext context) {
        this.context = context;
    }

    @Override
    public void returnVoid() {
    }

    @Override
    public void callFunctionVoid(String name, List<Object> arguments) {
        if (name.equals("print")) {
            System.out.println(arguments.get(0));
        }
    }

    @Override
    public void setValue(String name, int value) {
        values.put(name, value);
    }

    @Override
    public void setValue(String name, List<Integer> value) {
        values.put(name, value);
    }

    @Override
    public int getValueElement(String name) {
        return (Integer) values.get(name);
    }

    @Override
    public List<Integer> getValueList(String name) {
        return (List<Integer>) values.get(name);
    }

    @Override
    public InterpreterContext block() {
        var block = new InterpreterContextImpl(context.block());
        block.values.putAll(values);
        return block;
    }

    @Override
    public Optional<ReturnType> getReturnType(FunctionSignature function) {
        return context.getReturnType(function);
    }

    @Override
    public Optional<Type> getVariableType(String name) {
        return context.getVariableType(name);
    }

}
