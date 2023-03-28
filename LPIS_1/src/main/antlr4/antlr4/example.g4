grammar example;


// BEGIN: '{';
// END: '}';
tokens { BEGIN, END }

@lexer::members {

public void printHello() {
    System.out.println("Hello world");
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

NEWLINE: '{BEGIN}';

SKIP_
 : ( SPACES | COMMENT ) -> channel(HIDDEN)
 ;
fragment COMMENT
 : '\\' ~[\r\n\f]*
 |  '/*' .* '*/'
 ;
fragment SPACES
 : [ \t]+
 ;