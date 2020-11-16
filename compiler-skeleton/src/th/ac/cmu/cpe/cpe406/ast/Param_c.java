package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Param_c extends Node_c implements Param {

    protected Id id;
    protected TypeNode typeNode;
    protected Type type;

    public Param_c(Position pos, Id id, TypeNode typeNode) {
        super(pos);
        this.id = id;
        this.typeNode = typeNode;
    }

}
