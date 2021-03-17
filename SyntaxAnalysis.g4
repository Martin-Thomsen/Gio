grammar SyntaxAnalysis;
//PARSER PART
prog:               (func | eventHand)* EOF;

func:               'function' ID '(' (expression (',' expression)*)? ')' block 'endFunction';
eventHand:          'when' ID '(' (expression (',' expression)*)? ')' block 'endWhen';

block:              stmt*;
stmt:               'if' '(' expression ')' 'do' block ('else if' '(' expression ')' 'do' block)* ('else do' block)? 'endIf'
				    | 'repeat' '(' (DIGITS || ID) ')' block 'endRepeat'
				    | 'repeatIf' '(' expression ')' block 'endRepeatIf'
				    | 'repeatUntil' '(' expression ')' block 'endRepeatUntil'
                    | funcCall_Stmt
				    | ID '=' (expression | incr_Stmt | decr_Stmt) '.'
				    | incr_Stmt
				    | decr_Stmt;

funcCall_Stmt:      ID '(' (expression (',' expression)*)? ')' '.';
incr_Stmt:          '++' ID
                    | ID '++';
decr_Stmt:          '--' ID
                    | ID '--';

expression:         primary
                    | expression '[' expression ']'
                    | funcCall_Stmt
                    | expression bop=('*'|'/'|'%') expression
                    | expression bop=('+'|'-') expression
                    | expression bop=('<=' | '>=' | '>' | '<') expression
                    | expression bop=('==' | '!=') expression
                    | expression bop='&&' expression
                    | expression bop='||' expression
                    | <assoc=right> expression bop='?' expression ':' expression;
primary:            '(' expression ')'
                    | DIGITS
                    | ID
                    | BOOL;

//LEXICAL PART
BOOL:               'true' | 'false';
ID:                 LETTER (LETTERORDIGIT | '_')*;
DIGITS:             DIGIT DIGITS
		            | DIGIT;
DIGIT:              '0'..'9';
LETTER:             'a'..'z'
                    | 'A'..'Z';
LETTERORDIGIT:      LETTER
                    | DIGIT;

WS:                 [ \t\r\n]       -> skip;
LINE_COMMENT:       '//' ~[\r\n]*   -> skip;