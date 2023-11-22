package com.example.lab.statement;

import com.example.lab.*;

import java.util.Optional;

public interface StatementContext extends FunctionContext {

    StatementContext funcDefBlock();

    StatementContext forDefBlock();

    StatementContext block();

    boolean isReturn();

    void setReturn();

    boolean isFuncDef();

    boolean isForDef();

    void funcDef(Function function);

    Optional<ReturnType> getReturnType(FunctionSignature function);

    Optional<Type> getVariableType(String variable);

    boolean hasFunction(FunctionSignature signature);

    default boolean hasVariable(Variable variable) {
        return hasVariable(variable.name());
    }

    boolean hasVariable(String name);

    default void initVariable(String name) {
        initVariable(new Variable(name));
    }

    void initVariable(Variable variable);

}
