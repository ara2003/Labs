package com.example.lab;

import java.util.Optional;

public interface FunctionContext {

    Optional<ReturnType> getReturnType(FunctionSignature function);

    Optional<Type> getVariableType(String name);

    FunctionContext block();

}
