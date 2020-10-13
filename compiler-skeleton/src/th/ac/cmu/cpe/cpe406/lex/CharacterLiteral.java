package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** Token class for char literals. */
public class CharacterLiteral extends Literal {
    protected Character val;

    public CharacterLiteral(Position position, char c, int sym) {
        super(position, sym);
        val = new Character(c);
    }

    public Character getValue() {
        return val;
    }

    public String getEscapedValue() {
        return Token.escape(String.valueOf(val));
    }

    @Override
    public String toString() {
        return "character " + getEscapedValue();
    }
}
