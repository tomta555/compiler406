package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Equal_c extends Binary_c implements Equal{

	public Equal_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

}
