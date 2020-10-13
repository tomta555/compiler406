package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.frontend.Source;
import th.ac.cmu.cpe.cpe406.parse.sym;
import th.ac.cmu.cpe.cpe406.util.Position;
import th.ac.cmu.cpe.cpe406.util.ErrorQueue;
import th.ac.cmu.cpe.cpe406.util.ErrorInfo;
import java.math.BigInteger;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

@SuppressWarnings({"unused", "fallthrough", "all"})
%%

%public
%class Lexer_c
%implements Lexer
%type Token
%function next_token

%unicode
%pack

%line
%column
%char

%state STRING, CHARACTER, END_OF_LINE_COMMENT

%{
    StringBuffer sb = new StringBuffer();
    String file;
    String path;
    ErrorQueue eq;
    Writer lexedw;

    HashMap<String, Integer> keywords;
    Position literalBegin;
    boolean lexErrorReported;

    public Lexer_c(java.io.Reader reader, Source file, ErrorQueue eq, Writer lexedw) {
        this(reader);
        this.file = file.name();
        this.path = file.path();
        this.eq = eq;
        this.lexedw = lexedw;
        this.keywords = new HashMap<>();
        init_keywords();
    }

    public Set<String> keywords() {
        if (keywords == null) {
        keywords = new HashMap<>();
        init_keywords();
        }

        return Collections.unmodifiableSet(keywords.keySet());
    }

    protected void init_keywords() {
        keywords.put("int",           sym.INT);
    }

    @Override
    public String file() {
        return file;
    }

    @Override
    public String path() {
        return path;
    }

    @Override
    public Token nextToken() throws IOException {
        Token tok = next_token();
        Position pos = tok.getPosition();
        if (lexedw != null && !lexErrorReported && tok.symbol() != sym.EOF)
            lexedw.write(pos.line() + ":" + pos.column() + " " + tok
                    + "\n");
        return tok;
    }

    private Position pos() {
        return new Position(path, file, yyline+1, yycolumn + 1, yyline+1,
                            yycolumn + 1 + yytext().length(), yychar,
                            yychar + yytext().length());
    }

    private Position pos(int len) {
        return new Position(path, file, yyline+1, yycolumn+1-len, yyline+1,
                            yycolumn+1, yychar-len, yychar);
    }

    private Token key(int symbol) {
        return new Keyword(pos(), yytext(), symbol);
    }

    private Token op(int symbol) {
        return new Operator(pos(), yytext(), symbol);
    }

    private Token id() {
        return new Identifier(pos(), yytext(), sym.IDENTIFIER);
    }

    private Token int_lit(String s, int radix) {
        BigInteger x = new BigInteger(s, radix);
        boolean boundary = (radix == 10 && s.equals("9223372036854775808"));
        int bits = radix == 10 ? 63 : 64;
        if (x.bitLength() > bits && !boundary) {
            return lexError("Integer literal \"" +
                        yytext() + "\" out of range.", pos());
        }
        if (boundary) {
            return new IntegerLiteral(pos(), x.longValue(),
                    sym.INTEGER_LITERAL_BD);
        }
        return new IntegerLiteral(pos(), x.longValue(), sym.INTEGER_LITERAL);
    }

    private Token char_lit(String s) {
        int len = s.length();
        yycolumn++;
        Token result;
        if (len == 1) {
            char x = s.charAt(0);
            result = new CharacterLiteral(pos(yychar - literalBegin.offset() + 1), x, sym.CHARACTER_LITERAL);
        }
        else {
            return lexError("Illegal character literal \'" + s + "\'", pos(yychar - literalBegin.offset() + 1));
        }
        yycolumn--;
        return result;
    }

    private Token boolean_lit(boolean x) {
        return new BooleanLiteral(pos(), x, sym.BOOLEAN_LITERAL);
    }

    private Token string_lit() {
        return new StringLiteral(pos(yychar - literalBegin.offset()), sb.toString(),
                                 sym.STRING_LITERAL);
    }

    private String chop(int i, int j) {
        return yytext().substring(i,yylength()-j);
    }

    private String chop(int j) {
        return chop(0, j);
    }

    private String chop() {
        return chop(0, 1);
    }

    private Token lexError(String msg, Position pos) {
        eq.enqueue(ErrorInfo.LEXICAL_ERROR, msg, pos);
        if (lexedw != null && !lexErrorReported) {
            try {
                lexedw.write(pos.line() + ":" + pos.column() + " error:" + msg
                        + "\n");
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            lexErrorReported = true;
        }
        return new LexErrorToken(pos);
    }
%}

%eofval{
    return new EOF(pos(), sym.EOF);
%eofval}

/* Line Terminators */
/* LineTerminator:
      the ASCII LF character, also known as "newline"
      the ASCII CR character, also known as "return"
      the ASCII CR character followed by the ASCII LF character
*/
LineTerminator = \n|\r|\r\n

/* White Space */
/*
WhiteSpace:
    the ASCII SP character, also known as "space"
    the ASCII HT character, also known as "horizontal tab"
    the ASCII FF character, also known as "form feed"
    LineTerminator
*/
WhiteSpace = [ \t\f] | {LineTerminator}

/* Identifiers */
Identifier = [:letter:] ([:jletter:] | [:digit:] | \')*

/* Integer Literals */
DecimalNumeral = 0 | [1-9][0-9]*

%%

<YYINITIAL> {
    /* Comments */
    "//"    { yybegin(END_OF_LINE_COMMENT); }

    /* Character Literals */
    \'      { yybegin(CHARACTER); literalBegin = pos(); sb.setLength(0); }

    /* String Literals */
    \"      { yybegin(STRING); literalBegin = pos(); sb.setLength(0); }

    {Identifier}   { Integer i = keywords.get(yytext());
                     if (i == null) return id();
                     else return key(i.intValue()); }

    /* Separators */
    ":"    { return op(sym.COLON); }
    ";"    { return op(sym.SEMICOLON); }

    /* Operators */
    "="    { return op(sym.EQ);         }

    /* Integer Literals */
    {DecimalNumeral}             { return int_lit(yytext(), 10); }

    /* White Space */
    {WhiteSpace}                 { /* ignore */ }
}

<END_OF_LINE_COMMENT> {
    {LineTerminator}             { yybegin(YYINITIAL); }
    .                            { /* ignore */ }
}

<CHARACTER, STRING> {
    /* Escape Sequences for Character and String Literals */
    "\\b"                        { sb.append('\b'); }
    "\\t"                        { sb.append('\t'); }
    "\\n"                        { sb.append('\n'); }
    "\\f"                        { sb.append('\f'); }
    "\\r"                        { sb.append('\r'); }
    "\\\""                       { sb.append('\"'); }
    "\\'"                        { sb.append('\''); }
    "\\\\"                       { sb.append('\\'); }

    /* Illegal escape character */
    \\.                          { sb.append(yytext());
                                   return lexError("Illegal escape character \"" +
                                              yytext() + "\"", pos()); }
}

<CHARACTER> {
    /* End of the character literal */
    \'                           { yybegin(YYINITIAL);
                                   return char_lit(sb.toString()); }

    /* Unclosed character literal */
    {LineTerminator}             { yybegin(YYINITIAL);
                                   return lexError("Unclosed character literal",
                                             pos(yychar - literalBegin.offset())); }
    <<EOF>>                      { yybegin(YYINITIAL);
                                   return lexError("Unclosed character literal",
                                             pos(yychar - literalBegin.offset())); }

    /* Anything else is okay */
    [^\r\n\'\\]+                 { sb.append( yytext() ); }
}

<STRING> {
    /* End of string */
    \"                           { yybegin(YYINITIAL);
                                   return string_lit(); }

    /* Unclosed string literal */
    {LineTerminator}             { yybegin(YYINITIAL);
                                   return lexError("Unclosed string literal",
                                              pos(yychar - literalBegin.offset())); }
    <<EOF>>                      { yybegin(YYINITIAL);
                                   return lexError("Unclosed string literal",
                                              pos(yychar - literalBegin.offset())); }

    /* Anything else is okay */
    [^\r\n\"\\]+                 { sb.append( yytext() ); }
}

/* Fallthrough case: anything not matched above is an error */
[^]                              { return lexError("Illegal character \"" +
                                              yytext() + "\"", pos()); }
