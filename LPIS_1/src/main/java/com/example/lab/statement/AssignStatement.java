package com.example.lab.statement;

import com.example.lab.SemanticError;
import com.example.lab.expression.Expression;
import com.example.lab.interpreter.InterpreterContext;

import java.util.Objects;

public record AssignStatement(AssignTarget target, Expression expr) implements Statement {

    public AssignStatement {
        Objects.requireNonNull(target);
        Objects.requireNonNull(expr);
    }

    @Override
    public boolean checkContextSemantic(StatementContext context) {
        if (context.isReturn())
            return SemanticError.printReturnError(line());
        if (!expr.checkContextSemantic(context))
            return false;
        return target.init(context, expr.getType(context));
    }

    @Override
    public int line() {
        return target.line();
    }

    @Override
    public void runInterpreter(InterpreterContext context) {
		target.assign(context, expr);
    }

}
