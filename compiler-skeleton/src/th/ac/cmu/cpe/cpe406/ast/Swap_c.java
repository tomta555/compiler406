package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Swap_c extends Stmt_c implements Swap {
	
	Expr l;
	Expr r;

	public Swap_c(Position pos, Expr l, Expr r) {
		super(pos);
		this.l = l;
		this.r = r;
	}
}
