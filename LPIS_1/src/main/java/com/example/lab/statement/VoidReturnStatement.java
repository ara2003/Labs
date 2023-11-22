package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.SemanticError;
import com.example.lab.interpreter.InterpreterContext;

import java.util.Optional;

public record VoidReturnStatement(int line) implements Statement {

    @Override
    public boolean checkContextSemantic(StatementContext context) {
        if (context.isReturn())
            return SemanticError.printReturnError(line());
        if (!context.isFuncDef())
            return SemanticError.print("return outside function", line());
        context.setReturn();
        return true;
    }

    @Override
    public void runInterpreter(InterpreterContext context) {
        context.returnVoid();
    }

    @Override
    public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
        return Optional.of(ReturnType.VOID);
    }

}
