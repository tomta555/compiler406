package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.parse.sym;
import th.ac.cmu.cpe.cpe406.util.Position;

/** Token class for end-of-file. */
public class LexErrorToken extends Token {
    public LexErrorToken(Position position) {
        super(position, sym.error);
    }

    @Override
    public String toString() {
        return "lexical error";
    }
}
