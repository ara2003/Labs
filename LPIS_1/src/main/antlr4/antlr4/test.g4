grammar test;


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

NEWLINE
 : (  '\n' '\t'* )
   {
    skip();

    var text = getText();
    var depth = solveDepth(text);

    while(depth < lastDepth) {
        lastDepth--;
        bufferEmit(new CommonToken(testParser.END, "}"));
    }
    while(depth > lastDepth) {
        lastDepth++;
        bufferEmit(new CommonToken(testParser.BEGIN, "{"));
    }
   }
 ;

code
 : (sumTerm) EOF
 ;

sumTerm
 : BEGIN atomTerm atomTerm END
 ;

atomTerm
 : NUMBER
 | sumTerm
 ;

NUMBER: [0-9]+;

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