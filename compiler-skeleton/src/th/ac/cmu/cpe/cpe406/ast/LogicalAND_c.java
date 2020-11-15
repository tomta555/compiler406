package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class LogicalAND_c extends LogicalOp_c implements LogicalAND {

	public LogicalAND_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

}
