package th.ac.cmu.cpe.cpe406.lex;

import java.io.IOException;
import java.util.Set;

/**
 * The interface "Lexer" describes lexers produced by JFlex.
 */
public interface Lexer {

    /** This character denotes the end of file */
    final public static int YYEOF = -1;

    /**
     * The file being scanned, for use in constructing diagnostic
     * messages.
     */
    public String file();

    /**
     * The path to the file being scanned, for use in constructing diagnostic
     * messages.
     */
    public String path();

    /**
     * Resumes scanning until the next regular expression is matched,
     * the end of input is encountered or an I/O-Error occurs.
     *
     * @return      the next token
     * @exception   IOException  if any I/O-Error occurs
     */
    public Token nextToken() throws IOException;

    /**
     * @return a set of keywords defined by the language.
     */
    Set<String> keywords();
}
