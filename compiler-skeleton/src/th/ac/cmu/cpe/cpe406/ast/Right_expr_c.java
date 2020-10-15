package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Right_expr_c extends Expr_c implements Right_expr{
	
	Expr l;
	Expr r;
	
	public Right_expr_c(Position pos, Expr l, Expr r) {
		super(pos);
		this.l = l;
		this.r = r;
	}

}
