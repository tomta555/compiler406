package th.ac.cmu.cpe.cpe406.ast;

import java.util.List;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Assign_c extends Stmt_c implements Assign {

	List<Variable> l;
	List<Expr> r;

    public Assign_c(Position pos, List<Variable> l, List<Expr> r) {
        super(pos);
        this.l = l;
        this.r = r;
    }

}
