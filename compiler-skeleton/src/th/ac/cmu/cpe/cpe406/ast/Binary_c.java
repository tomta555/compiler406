package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public abstract class Binary_c extends Expr_c implements Binary{
	Expr l;
	Expr r;
	public Binary_c(Position pos, Expr l, Expr r) {
		super(pos);
		assert (l != null && r != null);
		this.l = l;
		this.r = r;
	}
}
