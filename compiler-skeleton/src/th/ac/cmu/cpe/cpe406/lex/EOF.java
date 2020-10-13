package th.ac.cmu.cpe.cpe406.lex;

import th.ac.cmu.cpe.cpe406.util.Position;

/** Token class for end-of-file. */
public class EOF extends Token {
    public EOF(Position position, int sym) {
        super(position, sym);
    }

    @Override
    public String toString() {
        return "end of file";
    }
}
