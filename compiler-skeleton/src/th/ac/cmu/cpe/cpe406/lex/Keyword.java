package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** A token class for keywords. */
public class Keyword extends Token {
    protected String keyword;

    public Keyword(Position position, String s, int sym) {
        super(position, sym);
        keyword = s;
    }

    @Override
    public String toString() {
        return keyword;
    }
}
