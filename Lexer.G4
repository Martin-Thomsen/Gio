lexer grammar Lexer;
//LEXICAL ELEMENTS

//KEYWORDS
RUN:                'run';
ENDRUN:             'endRun';
FUNCTION:           'function';
ENDFUNCTION:        'endFunction';
WHEN:               'when';
ENDWHEN:            'endWhen';
IF:                 'if';
ENDIF:              'endIf';
DO:                 'do';
ELSEIF:             'else if';
ELSEDO:             'else do';
REPEAT:             'repeat';
ENDREPEAT:          'endRepeat';
REPEATIF:           'repeat if';
ENDREPEATIF:        'endRepeatIf';
REPEATUNTIL:        'repeatUntil';
ENDREPEATUNTIL:     'endRepeatUntil';

BOOL:               TRUE | FALSE;
BOOL_OP:            EQUAL | GE | LE | LT | GT | NOTEQUAL;
ID:                 LETTER (LETTERORDIGIT | UNDERSCORE)*;
DIGITS:             DIGIT DIGITS
		            | DIGIT;
DIGIT:              '0'..'9';
LETTER:             'a'..'z'
                    | 'A'..'Z';
LETTERORDIGIT:      LETTER
                    | DIGIT;

LPAREN:             '(';
RPAREN:             ')';
LBRACK:             '[';
RBRACK:             ']';
COMMA:              ',';
DOT:                '.';
UNDERSCORE:         '_';

ASSIGN:             '=';
GT:                 '>';
LT:                 '<';
BANG:               '!';
EQUAL:              '==';
LE:                 '<=';
GE:                 '>=';
NOTEQUAL:           '!=';
AND:                '&&';
OR:                 '||';
INC:                '++';
DEC:                '--';
PLUS:               '+';
MINUS:              '-';
MULTIPLY:           '*';
DIV:                '/';
TRUE:               'true';
FALSE:              'false';

WS:                 [ \t\r\n]       -> skip;
LINE_COMMENT:       '//' ~[\r\n]*   -> skip;

parser grammar Parser;
options { tokenVocab = Lexer; }