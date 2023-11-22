package com.example.lab.expression;

import com.example.lab.FunctionContext;
import com.example.lab.SemanticChecker;
import com.example.lab.Type;
import com.example.lab.interpreter.InterpreterContext;

import java.util.List;
import java.util.Optional;

public interface Expression extends SemanticChecker {

    default Object runInterpreter(InterpreterContext context) {
        var type = getType(context);
        if (type == null) {
            runVoidInterpreter(context);
            return null;
        }
        return switch (type) {
            case ELEMENT -> runElementInterpreter(context);
            case LIST -> runListInterpreter(context);
        };
    }

    Type getType(FunctionContext context);

    default void runVoidInterpreter(InterpreterContext context) {
        throw new IllegalArgumentException("cls = " + getClass());
    }

    default int runElementInterpreter(InterpreterContext context) {
        throw new IllegalArgumentException("cls = " + getClass());
    }

    default List<Integer> runListInterpreter(InterpreterContext context) {
        throw new IllegalArgumentException("cls = " + getClass());
    }

    default Optional<Type> tryGetType() {
        return Optional.of(getType(null));
    }

}
