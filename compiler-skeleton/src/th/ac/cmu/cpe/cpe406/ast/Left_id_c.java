package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Left_id_c extends Expr_c implements Left_id {
	
	Expr l;
	Expr r;
	
	public Left_id_c(Position pos, Expr l, Expr r) {
		super(pos);
		this.l = l;
		this.r = r;
	}


}
