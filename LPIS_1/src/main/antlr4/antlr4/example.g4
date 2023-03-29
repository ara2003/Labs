grammar example;

tokens { BEGIN, END }

@lexer::header {
import java.util.LinkedList;
import java.util.Queue;
}

@lexer::members {
private int lastDepth = 0;

private final Queue<Token> buffer = new LinkedList<>();

public boolean atStart() {
    return getCharIndex() == 0;
}

public void bufferEmit(Token token) {
    buffer.add(token);
}

private static int solveDepth(String string) {
    var index = string.indexOf('\t');
    if(index < 0)
        return 0;
    return string.length() - index;
}

public Token nextToken() {
    if(buffer.isEmpty()) {
        var next = super.nextToken();
        if(!buffer.isEmpty()) {
            var result = buffer.poll();
            buffer.add(next);
            return result;
        }
        if(next.getType() == Token.EOF) {
            while(lastDepth-- > 0)
                buffer.add(new CommonToken(exampleParser.END, "}"));
            buffer.add(next);
            return nextToken();
        }
        return next;
    }
    return buffer.poll();
}
}

program
 : code EOF
 ;

code: stmt *;
stmt
 : funcDefStmt
 | assignStmt
 | whileStmt
 | forStmt
 | ifStmt
 | funcCallStmt
 | codeBlockStmt
 | breakStmt
 | continueStmt
 | returnStmt
 ;


codeBlockStmt: BEGIN code END;

assignStmt: lvalue '=' rvalue;

funcDefStmt: FUNC ID '(' paramiters? ')' ':' BEGIN code END; 
paramiters: paramiter (',' paramiter)*;
paramiter: type? ID;

funcCallStmt: ID '(' arguments? ')';
arguments: rvalue (',' rvalue)*;

whileStmt: WHILE rvalue ':' BEGIN code END;

forStmt: FOR ID 'in' rvalue ':' BEGIN code END;

ifStmt: IF rvalue ':' BEGIN code END;

lvalue
 : ID
 ;

rvalue: logicExpr;

logicExpr
    : compareExpr (LOGIC_OPERATION compareExpr)*
    ;
compareExpr
    : sumExpr (COMPARE_OPERATION sumExpr)*
    ;
sumExpr
    : multExpr (SUM_OPERATION multExpr)*
    ;
multExpr
    : unaryExpr (MULT_OPERATION unaryExpr)*
    ;
unaryExpr
    : prefix_unary_operation? atomExpr syfix_unary_operation?
    ;


prefix_unary_operation
 : INC_OPERATION
 | DEC_OPERATION
 | NOT_OPERATION
 | PLUS_OPERATION
 | MINUS_OPERATION
 ;
syfix_unary_operation
 : INC_OPERATION
 | DEC_OPERATION
 ;
atomExpr
    : lvalue
    | newList
    | numberExpr
    | funcCallStmt
    | '(' rvalue ')'
    ;

numberExpr: NUMBER;

newList: '[' numbers? ']';
numbers: NUMBER (',' NUMBER)*;
type: ELEMENT | LIST;
breakStmt: BREAK ;
continueStmt: CONTINUE ;
returnStmt: RETURN rvalue?;

FUNC: 'func';
NOT_OPERATION: 'not';
LOGIC_OPERATION: 'and' | 'or';
COMPARE_OPERATION: '<' | '>' | '>=' | '<=' |  '==' | '!=';
SUM_OPERATION: PLUS_OPERATION | MINUS_OPERATION;
MULT_OPERATION: '*' | '/' | '%';
INC_OPERATION: '++';
DEC_OPERATION: '--';
PLUS_OPERATION: '+';
MINUS_OPERATION: '-';

LIST: 'list';
ELEMENT: 'element';
FOR: 'for';
WHILE: 'while';
IF: 'if';
ELSE: 'else';
SWITCH: 'switch';
CASE: 'case';

RETURN: 'return';
BREAK: 'break';
CONTINUE: 'continue';

ID: [a-zA-Z][a-zA-Z0-9_]*;

NUMBER: [0-9]+;

NEWLINE
 : (  '\n' '\t'* )
   {
    skip();

    var text = getText();
    var depth = solveDepth(text);

    while(depth < lastDepth) {
        lastDepth--;
        bufferEmit(new CommonToken(exampleParser.END, "}"));
    }
    while(depth > lastDepth) {
        lastDepth++;
        bufferEmit(new CommonToken(exampleParser.BEGIN, "{"));
    }
   }
 ;


SKIP_
 : ( SPACES | COMMENT ) -> channel(HIDDEN)
 ;

fragment COMMENT
 : '//' ~[\r\n\f]*
 ;

fragment TABS
 : [\t]+
 ;

fragment SPACES
 : [ \r\f]+
 ;