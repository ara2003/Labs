package com.example.lab.statement;

import com.example.lab.SemanticError;
import com.example.lab.expression.FuncCallExpression;
import com.example.lab.interpreter.InterpreterContext;

public record FuncCallStatement(FuncCallExpression expr) implements Statement {

    @Override
    public boolean checkContextSemantic(StatementContext context) {
        if (context.isReturn())
            return SemanticError.printReturnError(line());
        if (!expr.args().stream().map(x -> x.checkContextSemantic(context)).allMatch(x -> x))
            return false;
        var s = expr.signature(context);
        if (!context.hasFunction(s))
            return SemanticError.print("call not define function signature " + s, line());
        return true;
    }

    @Override
    public int line() {
        return expr.line();
    }

    @Override
    public void runInterpreter(InterpreterContext context) {
        expr.runVoidInterpreter(context);
    }

}
