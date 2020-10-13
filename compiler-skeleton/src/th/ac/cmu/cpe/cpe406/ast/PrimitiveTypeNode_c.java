package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class PrimitiveTypeNode_c extends TypeNode_c
        implements PrimitiveTypeNode {

    protected PrimitiveTypeNode.Kind kind;

    public PrimitiveTypeNode_c(Position pos, PrimitiveTypeNode.Kind kind) {
        super(pos);
        this.kind = kind;
    }

}
