package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public abstract class Unary_c extends Expr_c implements Unary{

	protected Expr expr;
	
    public Unary_c(Position pos, Expr expr) {
        super(pos);
        assert (expr != null);
        this.expr = expr;
    }
}
