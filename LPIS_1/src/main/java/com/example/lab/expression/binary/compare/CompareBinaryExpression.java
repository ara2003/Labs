package com.example.lab.expression.binary.compare;


import com.example.lab.SemanticError;
import com.example.lab.Type;
import com.example.lab.expression.Expression;
import com.example.lab.expression.binary.BinaryExpression;
import com.example.lab.statement.StatementContext;

public abstract class CompareBinaryExpression extends BinaryExpression {
	
	public CompareBinaryExpression(Expression a, Expression b) {
		super(a, b);
	}
	
	@Override
	public boolean checkContextSemantic(StatementContext context) {
		if(!super.checkContextSemantic(context))
			return false;
		
		var aType = a.getType(context);
		var bType = b.getType(context);
		
		return ((aType == Type.ELEMENT) ? true : SemanticError.print("type of right comporating operator is list", 0))
				&& ((bType == Type.ELEMENT) ? true
						: SemanticError.print("type of left comporating operator is list", 0));
	}
	
	@Override
	public Type getType(StatementContext context) {
		return Type.ELEMENT;
	}
}
