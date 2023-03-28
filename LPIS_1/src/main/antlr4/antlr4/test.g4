grammar test;


tokens { BEGIN, END }

sum
 : NUMBER
 | BEGIN sum sum END
 ;

NUMBER: [0-9]+;
