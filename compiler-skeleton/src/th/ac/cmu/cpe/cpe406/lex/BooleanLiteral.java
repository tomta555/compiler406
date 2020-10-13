package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** Token class for boolean literals. */
public class BooleanLiteral extends Literal {
    protected Boolean val;

    public BooleanLiteral(Position position, boolean b, int sym) {
        super(position, sym);
        val = Boolean.valueOf(b);
    }

    public Boolean getValue() {
        return val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
