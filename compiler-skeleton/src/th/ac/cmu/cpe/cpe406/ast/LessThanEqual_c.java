package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class LessThanEqual_c extends ComparisonOp_c implements LessThanEqual {

	public LessThanEqual_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

}
