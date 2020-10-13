package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class LocalDecl_c extends Stmt_c implements LocalDecl {

    protected Id id;
    protected TypeNode typeNode;

    public LocalDecl_c(Position pos, Id id, TypeNode typeNode) {
        super(pos);
        this.id = id;
        this.typeNode = typeNode;
    }
}
