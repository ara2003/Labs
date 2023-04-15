grammar example;

tokens { BEGIN, END }


options {
	language='Java';
}

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

private static int solveDepth(String text) {
    return text.chars().map(x -> (switch(x) {
        case '\t' -> 4;
        case ' ' -> 1;
        default -> 0;
    })).sum() / 4;
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

code
 : stmt*
 | passStat
 ;

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
 | switchStmt
 ;

passStat: PASS;
codeBlockStmt: BEGIN code END;

assignStmt: lvalue '=' rvalue;
funcDefStmt: FUNC ID '(' paramiters? ')' ':' codeBlockStmt; 
paramiters: paramiter (',' paramiter)*;
paramiter: type? ID;
funcCallStmt: ID '(' arguments? ')';
whileStmt: WHILE rvalue ':' codeBlockStmt;
switchStmt: SWITCH rvalue ':' BEGIN caseStat+ defaultStat? END;
caseStat: CASE NUMBER ':' codeBlockStmt;
defaultStat: DEFAULT ':' codeBlockStmt;
forStmt: FOR ID 'in' rvalue ':' codeBlockStmt;
ifStmt: IF rvalue ':' codeBlockStmt elseStmt?;
elseStmt: ELSE ':' codeBlockStmt;
breakStmt: BREAK ;
continueStmt: CONTINUE ;
returnStmt: RETURN rvalue?;

numberExpr: NUMBER;
inBracketsRvalue: '(' rvalue ')';
atomExpr
    : lvalue
    | newList
    | numberExpr
    | funcCallStmt
    | inBracketsRvalue
    ;
unaryExpr
    : unaryExprPrefix? atomExpr
    ;
multExpr
    : unaryExpr (MULT_OPERATION unaryExpr)*
    ;
sumExpr
    : multExpr (('+'|'-') multExpr)*
    ;
compareExpr
    : sumExpr (COMPARE_OPERATION sumExpr)*
    ;
logicExpr
    : compareExpr (LOGIC_OPERATION compareExpr)*
    ;

rvalue: logicExpr;

lvalue
 : varName
 | varName list_index 
 | '(' rvalue ')' list_index 
 ;

varName
 : ID
 ;
 
list_index
 : '[' rvalue ']'
 ; 

unaryExprPrefix
 : 'not'
 | '+'
 | '-'
 ;

newList: '[' arguments? ']';
arguments: rvalue (',' rvalue)*;
type: ELEMENT | LIST;

FUNC: 'func';
PASS: 'pass';
NOT_OPERATION: 'not';
LOGIC_OPERATION: 'and' | 'or';
COMPARE_OPERATION: '<' | '>' | '>=' | '<=' |  '==' | '!=';
MULT_OPERATION: '*' | '/' | '%' | '^';
PLUS_OPERATION: '+';
MINUS_OPERATION: '-';

LIST: 'list';
ELEMENT: 'element';
FOR: 'for';
WHILE: 'while';
IF: 'if';
ELSE: 'else';
SWITCH: 'switch';
DEFAULT: 'default';
CASE: 'case';

RETURN: 'return';
BREAK: 'break';
CONTINUE: 'continue';

ID: [a-zA-Z][a-zA-Z0-9_]*;

NUMBER: [0-9]+;

NEWLINE
 : (  '\r'? '\n' SPACES* )
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

fragment SPACES
 : [ \t]+
 ;