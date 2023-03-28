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
        return next;
    }
    return buffer.poll();
}
}



code: (funcDef | assignExp | whileExp | forExp | ifExp | funcCall | codeBlock)*;

codeBlock: BEGIN code END;

assignExp: ID '=' expr;

funcDef: FUNC ID '(' paramiters? ')' ':' BEGIN code END; 

funcCall: ID '(' arguments? ')';

whileExp: WHILE expr ':' BEGIN code END;

forExp: FOR ID 'in' expr ':' BEGIN code END;

ifExp: IF expr ':' BEGIN code END;

expr
    : mult_expr (SUM_OPERATION mult_expr)*
    ;

mult_expr
    : atom_expr (MULT_OPERATION atom_expr)*
    ;

atom_expr
    : number_expr
    | new_list
    | funcCall
    | id_expr
    ;

number_expr: NUMBER;
id_expr: ID;

new_list: '[' numbers? ']';
numbers: NUMBER (',' NUMBER)*;
paramiters: paramiter (',' paramiter)*;
paramiter: type? ID;
arguments: ID (',' ID)*;
type: ELEMENT | LIST;


FUNC: 'func';
SUM_OPERATION: '+' | '-';
MULT_OPERATION: '*' | '/' | '%';
INC_OPERATION: '++';
DEC_OPERATION: '--';

LIST: 'list';
ELEMENT: 'element';
FOR: 'for';
WHILE: 'while';
IF: 'if';
ELSE: 'else';
SWITCH: 'switch';
CASE: 'case';

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
 : '#' ~[\r\n\f]*
 ;

fragment TABS
 : [\t]+
 ;

fragment SPACES
 : [ \r\f]+
 ;