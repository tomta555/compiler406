package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** A token class for int literals. */
public class IntegerLiteral extends NumericLiteral {
    public IntegerLiteral(Position position, long i, int sym) {
        super(position, sym);
        val = new Long(i);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("integer ");
        if (val.longValue() == Long.MIN_VALUE) {
            // the literal is negative, but print it as positive.
            sb.append("9223372036854775808");
        }
        else sb.append(val.toString());
        return sb.toString();
    }
}
