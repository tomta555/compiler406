package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Assign_c extends Stmt_c implements Assign {

    Expr l;
    Expr r;

    public Assign_c(Position pos, Expr l, Expr r) {
        super(pos);
        this.l = l;
        this.r = r;
    }

}
