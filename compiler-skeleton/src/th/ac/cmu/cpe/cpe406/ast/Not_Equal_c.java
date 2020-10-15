package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Not_Equal_c extends Binary_c implements Not_Equal {

	public Not_Equal_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

}
