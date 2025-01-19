package com.example.lab;

import java.util.List;
import java.util.Objects;

import static com.example.lab.expression.Expression.Type;

public record Function(String name, List<? extends Type> parameters, Type returnType) {

    public Function(FunctionSignature signature, Type returnType) {
        this(signature.name(), signature.argumentTypes(), returnType);
    }

    public Function {
        Objects.requireNonNull(parameters);
        Objects.requireNonNull(name);
    }

    public FunctionSignature signature() {
        return new FunctionSignature(name, parameters);
    }

}
