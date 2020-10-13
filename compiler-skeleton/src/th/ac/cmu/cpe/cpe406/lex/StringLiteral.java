package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** A token class for string literals. */
public class StringLiteral extends Literal {
    protected String val;

    public StringLiteral(Position position, String s, int sym) {
        super(position, sym);
        val = s;
    }

    public String getValue() {
        return val;
    }

    @Override
    public String toString() {
        return "string " + Token.escape(val);
    }
}
