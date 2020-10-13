package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** A token class for literals. */
public abstract class Literal extends Token {
    public Literal(Position position, int sym) {
        super(position, sym);
    }
}
