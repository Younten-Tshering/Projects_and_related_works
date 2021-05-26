/* --------------------------UserCode Section------------------------ */
/* Used to generate tokens from input string. */

package src;
import java_cup.runtime.*;


%%

/* -----------------Options and Declarations Section----------------- */

/*
   The name of the class JFlex will create will be Lexer.
   Will write the code to the file Lexer.java.
*/

%class Lexer

/*
  The current line number can be accessed with the variable yyline
  and the current column number with the variable yycolumn.
*/
%line
%column

/*
   Will switch to a CUP compatibility mode to interface with a CUP
   generated parser.
*/
%cup

/*
  Declarations

  Code between %{ and %}, both of which must be at the beginning of a
  line, will be copied letter to letter into the lexer class source.
  Here you declare member variables and functions that are used inside
  scanner actions.
*/
%{

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    private void debug(String type){
        if(type == "SEPARATOR")
            System.out.println("<"+type+">");
        else
            System.out.print("<"+type+">");
    } 

    private void debug(String type, String text){
        System.out.print("<"+type+","+text+">");
    } 
%}


LineTerminator = \r|\n|\r\n

WhiteSpace     = {LineTerminator} | [ \t\f]

int = 0 | [1-9][0-9]*

dot = "."
float = [0-9]+{dot}[0-9]+

digit    = [0-9]*
alphabet = [a-zA-Z ]*
specials = [!|@|#|$|%|\^|&|*|(|)]*
string   = \'{alphabet}{specials}{digit}\'

boolean = true|false

var = [A-Za-z_][A-Za-z_0-9]*


%%
/* ------------------------Lexical Rules Section---------------------- */

/*
   This section contains regular expressions and actions, i.e. Java
   code, that will be executed when the scanner matches the associated
   regular expression. */

<YYINITIAL> {

    "+"        { debug("PLUS");  return symbol(sym.PLUS); }
    "-"        { debug("MINUS"); return symbol(sym.MINUS); }
    "*"        { debug("TIMES"); return symbol(sym.TIMES); }
    "/"        { debug("DIVIDE"); return symbol(sym.DIVIDE); }
    "%"        { debug("MOD");  return symbol(sym.MOD); }
    ";"        { debug("SEMI"); return symbol(sym.SEMI); }
    ","        { debug("COMMA"); return symbol(sym.COMMA); }
    "="        { debug("EQUALS"); return symbol(sym.EQUALS); }

    "("        { debug("LPAREN"); return symbol(sym.LPAREN); }
    ")"        { debug("RPAREN"); return symbol(sym.RPAREN); }

    "=="       { debug("ET"); return symbol(sym.ET); }
    "!="       { debug("NET"); return symbol(sym.NET); }
    "<"        { debug("LT"); return symbol(sym.LT); }
    "<="       { debug("LTE"); return symbol(sym.LTE); }
    ">"        { debug("GT"); return symbol(sym.GT); }
    ">="       { debug("GTE"); return symbol(sym.GTE); }
    "&&"       { debug("AND"); return symbol(sym.AND); }
    "||"       { debug("OR"); return symbol(sym.OR); }

    "int"      { debug("INT"); return symbol(sym.INT); }
    "float"    { debug("FLOAT"); return symbol(sym.FLOAT); }
    "boolean"  { debug("BOOL"); return symbol(sym.BOOL); }
    "string"   { debug("STRING"); return symbol(sym.STRING); }

    "if"       { debug("IF"); return symbol(sym.IF); }
    "endif"     { debug("ENDIF"); return symbol(sym.ENDIF); }
    "else"     { debug("ELSE"); return symbol(sym.ELSE); }
    "while"    { debug("WHILE"); return symbol(sym.WHILE); }

    "{"         { debug("BEGIN"); return symbol(sym.BEGIN); }
    "}"         { debug("END"); return symbol(sym.END); }   

    "print"    { debug("PRINT"); return symbol(sym.PRINT); }
    "println"   { debug("PRINTLN"); return symbol(sym.PRINTLN); }

    {int}      { debug("INT_LITERAL",yytext()); return symbol(sym.INT_LITERAL, new Integer(yytext())); }
    {float}    { debug("FLOAT_LITERAL",yytext()); return symbol(sym.FLOAT_LITERAL, new Float(yytext())); }
    {string}   { debug("STRING_LITERAL",yytext()); return symbol(sym.STRING_LITERAL, new String(yytext())); }
    {boolean}  { debug("BOOL_LITERAL",yytext()); return symbol(sym.BOL, new Boolean(yytext())); }

    {var}      { 
        Integer n = (Integer) SymbolTable.table.get(yytext());
        if (n == null) {
            SymbolTable.table.put(yytext(), 0);
        }
        debug("VAR", yytext() ); 
        return symbol(sym.VAR, yytext()); 
    }


    /* Don't do anything if whitespace is found */

    {WhiteSpace}       { /* just skip what was found, do nothing */ }
}

[^]                    { throw new Error("Illegal character <"+yytext()+">"); }