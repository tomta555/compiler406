package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Logical_OR_c extends Binary_c implements Logical_OR {

	public Logical_OR_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

}
