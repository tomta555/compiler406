package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Greater_Than_Equal_c extends Binary_c implements Greater_Than_Equal {

	public Greater_Than_Equal_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

}