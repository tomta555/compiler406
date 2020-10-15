package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Logical_AND_c extends Binary_c implements Logical_AND {

	public Logical_AND_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}
	
}
