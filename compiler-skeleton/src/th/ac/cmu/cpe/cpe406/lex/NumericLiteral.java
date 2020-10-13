package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** A token class for numerical literals. */
public abstract class NumericLiteral extends Literal {
    protected Number val;

    public NumericLiteral(Position position, int sym) {
        super(position, sym);
    }

    public Number getValue() {
        return val;
    }
}
