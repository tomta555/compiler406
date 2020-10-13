package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** A token class for identifiers. */
public class Identifier extends Token {
    protected String identifier;

    public Identifier(Position position, String identifier, int sym) {
        super(position, sym);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "id " + identifier;
    }
}
