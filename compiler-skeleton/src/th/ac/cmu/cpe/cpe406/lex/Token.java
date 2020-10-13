package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** The base class of all tokens. */
public abstract class Token {
    protected Position position;
    protected int symbol;

    public Token(Position position, int symbol) {
        this.position = position;
        this.symbol = symbol;
    }

    public Position getPosition() {
        return position;
    }

    public int symbol() {
        return symbol;
    }

    protected static String escape(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
            case '\'':
                sb.append("\\'");
                break;
            case '\"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '\t':
                sb.append("\\t");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\n':
                sb.append("\\n");
                break;
            default:
                if (c < 0x20 || c > 0x7e && c < 0xFF)
                    sb.append("\\" + Integer.toOctalString(c));
                else sb.append(c);
            }
        }
        return sb.toString();
    }
}
