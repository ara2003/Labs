package com.example.lab.statement;

import com.example.lab.ReturnType;
import com.example.lab.SemanticError;
import com.example.lab.expression.Expression;

import java.util.Optional;

public record ForStatement(String index, Expression iter_list, Statement code) implements Statement {

    @Override
    public boolean checkContextSemantic(StatementContext context) {
        if (context.isReturn())
            return SemanticError.printReturnError(line());
        boolean result = true;
        result &= iter_list.checkContextSemantic(context);
        var ctx = context.forDefBlock();
        ctx.initVariable(index);
        result &= code.checkContextSemantic(ctx);
        return result;
    }

    @Override
    public int line() {
        return iter_list.line();
    }

    @Override
    public Optional<ReturnType> tryResolveReturnType(StatementContext context) {
        var ctx = context.forDefBlock();
        ctx.initVariable(index);
        return code.tryResolveReturnType(ctx);
    }

}
