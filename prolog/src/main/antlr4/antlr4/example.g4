grammar example;

program
 : code EOF
 ;

code
 : stmt*
 ;

stmt
 : factStmt
 | ruleStmt
 | goalStmt
 ;

factStmt
 : predicateName '(' (term (',' term)*)? ')' '.'
 ;

ruleStmt
 : predicateName '(' (term (',' term)*)? ')' ':-' expr '.'
 ;

goalStmt
 : '?-' expr '.'
 ;

predicateName
 : ID
 ;

term
 : ID
 ;

expr
 : predicate
 | expr ',' expr
 ;

predicate
 : predicateName '(' (term (',' term)*)? ')'
 ;

COMPARE_OPERATION: '<' | '>' | '>=' | '<=' |  '==' | '!=';
MULT_OPERATION: '*' | '/' | '%' | '^';
PLUS_MINUS_OPERATION: '+' | '-';

MINUS: '-';
PLUS: '+';
ASIGN: '=';
SET_DELAYED: ':=';
PAIR: '->';
PATTERN_MARK: '_';

ID: [a-zA-Z][a-zA-Z0-9_]*;

NUMBER: [0-9]+;

SKIP_
 : ( SPACES | COMMENT ) -> channel(HIDDEN)
 ;

fragment COMMENT
 : '//' ~[\r\n\f]*
 ;

fragment SPACES
 : [ \t\n\r]+
 ;