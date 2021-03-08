parser grammar Parser;
options { tokenVocab = Lexer; }

//PARSER ELEMENTS
prrunog:               (func | eventHand)* runFunc (func | eventHand)* EOF;

//PARSER ELEMENTS

func:               FUNCTION ID LPAREN (param (COMMA param)*)? RPAREN stmt* ENDFUNCTION;
eventHand:          WHEN ID LPAREN (param (COMMA param)*)? RPAREN stmt* ENDWHEN;
runFunc:            RUN LPAREN RPAREN stmt* ENDRUN;

stmt:               if_Stmt
				    | repeatIf_Stmt
				    | repeatUntil_Stmt
				    | repeat_Stmt
                    | funcCall_Stmt
				    | assign_Stmt
				    | incr_Stmt
				    | decr_Stmt;

if_Stmt:            IF LPAREN bool_Expr RPAREN DO stmt* (ELSEIF LPAREN bool_Expr RPAREN DO stmt*)* (ELSEDO stmt*)? ENDIF;
repeatIf_Stmt:      REPEATIF LPAREN bool_Expr RPAREN stmt* ENDREPEATIF;
repeatUntil_Stmt:   REPEATUNTIL LPAREN bool_Expr RPAREN stmt* ENDREPEATUNTIL;
repeat_Stmt:        REPEAT LPAREN DIGITS RPAREN stmt* ENDREPEAT;
funcCall_Stmt:      ID LPAREN (value (COMMA value)*)? RPAREN DOT;
assign_Stmt:        ID ASSIGN arith_Expr DOT
                            | bool_Expr DOT
                            | ID ASSIGN incr_Stmt DOT
                            | ID ASSIGN decr_Stmt DOT
                            | ID ASSIGN factor_Stmt DOT;
incr_Stmt:          INC ID
                    | ID INC;
decr_Stmt:          DEC ID
                    | ID DEC;
factor_Stmt:        ID BANG
                    | DIGITS BANG;
arith_Expr:         add;
add:                mul add_p;
add_p:              //Epsilon
				    | PLUS mul add_p
				    | MINUS mul add_p;
mul:                term mul_p;
mul_p:              //Epsilon
                    | BANG mul_p
				    | MULTIPLY term mul_p
				    | DIV term mul_p;
term:               DIGITS
                    | ID
				    | LPAREN add RPAREN;
param:              ID;

bool_Expr:          value BOOL_OP value ((OR | AND) bool_Expr)?
				    | BOOL;

value:              DIGITS | ID | arith_Expr | BOOL;