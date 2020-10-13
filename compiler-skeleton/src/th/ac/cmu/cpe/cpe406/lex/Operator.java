package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** A token class for operators. */
public class Operator extends Token {
    protected String which;

    public Operator(Position position, String which, int sym) {
        super(position, sym);
        this.which = which;
    }

    @Override
    public String toString() {
        return which;
    }
}
