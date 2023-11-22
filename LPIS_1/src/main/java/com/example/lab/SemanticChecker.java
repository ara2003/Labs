package com.example.lab;

import com.example.lab.statement.StatementContext;

public interface SemanticChecker {

    default boolean checkContextSemantic(StatementContext context) {
        return true;
    }

    default int line() {
        throw new UnsupportedOperationException();
    }

}
