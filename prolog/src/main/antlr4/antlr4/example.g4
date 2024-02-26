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
 : expr '.'
 ;

ruleStmt
 : expr ':-' expr '.'
 ;

goalStmt
 : '?-' expr '.'
 | expr '?'
 ;

predicateName
 : ID
 ;

term
 : nameTerm
 | listTermComma
 | listTermHeadTail
 | emptyTerm
 ;

nameTerm
 : ID
 ;

listTermComma
 : '[' (term (',' term)*)? ']'
 ;

listTermHeadTail
 : '[' term '|' term ']'
 ;

emptyTerm
 : '_'
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
 | '%' ~[\r\n\f]*
 ;

fragment SPACES
 : [ \t\n\r]+
 ;