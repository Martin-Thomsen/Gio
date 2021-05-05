grammar SyntaxAnalysis;
//PARSER PART
prog:               (func | eventHand)* EOF                                     #program
                    ;

func:               'function' ftype id=ID '(' fparam ')' block 'endFunction'   #function
                    ;

eventHand:          'when' id=ID '(' fparam ')' block 'endWhen'                 #when
                    ;

block:              stmt*                                                       #blk
                    ;

stmt:               'if' '(' expression ')' 'do' block ('else if' '(' expression ')' 'do' block)* ('else do' block)? 'endIf'    #if
				    | 'repeat' '(' (digits=DIGITS | id=ID) ')' block 'endRepeat'                                                #rep
				    | 'repeatIf' '(' expression ')' block 'endRepeatIf'                                                         #rep_if
				    | 'repeat' block 'until' '(' expression ')'                                                                 #rep_until
                    | func_Call '.'                                                                                             #func_stmt
				    | type id=ID '=' (expression | incr_Stmt | decr_Stmt) '.'                                                   #var_decl
				    | id=ID '=' (expression | incr_Stmt | decr_Stmt) '.'                                                        #assign
				    | incr_Stmt '.'                                                                                             #incr
				    | decr_Stmt '.'                                                                                             #decr
				    | return_Stmt '.'                                                                                           #ret
				    ;

incr_Stmt:          '++' id=ID         #pre_incr
                    | id=ID '++'       #post_incr
                    ;

decr_Stmt:          '--' id=ID         #pre_decr
                    | id=ID '--'       #post_decr
                    ;

return_Stmt:        'return' expression                                             #returnStmt
                    ;

expression:         primary                                                         #prim
                    | func_Call                                                     #func_expr
                    | '!' expression                                                #not
                    | expression bop=('*'|'/'|'%') expression                       #mul_div_mod
                    | expression bop=('+'|'-') expression                           #add_sub
                    | expression bop=('<=' | '>=' | '<' | '>') expression           #le_ge_lt_gt
                    | expression bop=('==' | '!=') expression                       #equal_notequal
                    | expression bop='&&' expression                                #logical_and
                    | expression bop='||' expression                                #logical_or
                    | <assoc=right> expression bop='?' expression ':' expression    #tertiary
                    ;

primary:            '(' expression ')'      #parens
                    | digits=DIGITS         #digits
                    | id=ID                 #id
                    | bool=BOOL             #bool
                    ;

func_Call:          id=ID '(' param ')'                                             #funcCall
                    ;

fparam:             (type id=ID (',' type id=ID)*)?                                 #fparameters
                    ;

param:              (expression (',' expression)*)?                                 #parameters
                    ;

ftype:              'void'                                                          #void_ftype
                    | type                                                          #type_ftype
                    ;

type:               'num'                                                           #num_type
                    | 'bool'                                                        #bool_type
                    ;

//LEXICAL PART
BOOL:               'true' | 'false';
ID:                 [a-zA-Z_][a-zA-Z_0-9]*;
DIGITS:             [0-9]*;

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