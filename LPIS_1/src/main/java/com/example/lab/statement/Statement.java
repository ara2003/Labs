package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.SemanticChecker;
import com.example.lab.interpreter.InterpreterContext;

import java.util.Optional;

public interface Statement extends SemanticChecker {

    default void runInterpreter(InterpreterContext context) {
        throw new IllegalArgumentException("cls = " + getClass());
    }

    default Optional<ReturnType> tryResolveReturnType(StatementContext context) {
        return Optional.empty();
    }

}
