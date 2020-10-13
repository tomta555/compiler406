package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Copy;
import th.ac.cmu.cpe.cpe406.util.InternalCompilerError;
import th.ac.cmu.cpe.cpe406.util.Position;

public abstract class Node_c implements Node {

    protected Position pos;

    public Node_c(Position pos) {
        this.pos = pos;
    }

    @Override
    public Position position() {
        return pos;
    }

    /**
     * Return a clone of this node if the given node is this node,
     * or the given node otherwise.
     * @param n the node
     * @return a clone of n if n == this, or n otherwise
     */
    protected <N extends Node_c> N copyIfNeeded(N n) {
        if (n == this) return Copy.Util.copy(n);
        return n;
    }

    @Override
    public Node copy() {
        try {
            return (Node) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalCompilerError("Java clone() weirdness.");
        }
    }
}
