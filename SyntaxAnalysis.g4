grammar SyntaxAnalysis;
//PARSER PART
prog:               (func | eventHand)* EOF
                    ;

func:               'function' ID '(' param ')' block 'endFunction'       #function
                    ;

eventHand:          'when' ID '(' param ')' block 'endWhen'               #when
                    ;

block:              stmt*                                                 #blk
                    ;

stmt:               'if' '(' expression ')' 'do' block ('else if' '(' expression ')' 'do' block)* ('else do' block)? 'endIf'    #if
				    | 'repeat' '(' (DIGITS | ID) ')' block 'endRepeat'                                                          #rep
				    | 'repeatIf' '(' expression ')' block 'endRepeatIf'                                                         #rep_if
				    | 'repeatUntil' '(' expression ')' block 'endRepeatUntil'                                                   #rep_until
                    | func_Call                                                                                                 #func_stmt
				    | ID '=' (expression | incr_Stmt | decr_Stmt) '.'                                                           #assign
				    | incr_Stmt                                                                                                 #incr
				    | decr_Stmt                                                                                                 #decr
				    ;

incr_Stmt:          '++' ID         #pre_incr
                    | ID '++'       #post_incr
                    ;

decr_Stmt:          '--' ID         #pre_decr
                    | ID '--'       #post_decr
                    ;

expression:         primary                                                         #prim
                    | expression '[' expression ']'                                 #array
                    | func_Call                                                     #func_expr
                    | expression bop=('*'|'/'|'%') expression                       #mul_div_mod
                    | expression bop=('+'|'-') expression                           #add_sub
                    | expression bop=('<=' | '>=' | '<' | '>') expression           #le_ge_lt_gt
                    | expression bop=('==' | '!=') expression                       #equal_notequal
                    | expression bop='&&' expression                                #logical_and
                    | expression bop='||' expression                                #logical_or
                    | <assoc=right> expression bop='?' expression ':' expression    #tertiary
                    ;

primary:            '(' expression ')'      #parens
                    | DIGITS                #digits
                    | ID                    #id
                    | BOOL                  #bool
                    ;

func_Call:          ID '(' param ')' '.'                                            #funcCall
                    ;

param:              (expression (',' expression)*)?                                 #parameters
                    ;

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

MUL:                '*';
DIV:                '/';
ADD:                '+';
SUB:                '-';
MOD:                '%';
GE:                 '>=';
LE:                 '<=';
GT:                 '>';
LT:                 '<';
EQUALS:             '==';
NOTEQUALS:          '!=';
AND:                '&&';
OR:                 '||';
QMARK:              '?';
COLON:              ':';

WS:                 [ \t\r\n]       -> skip;
LINE_COMMENT:       '//' ~[\r\n]*   -> skip;