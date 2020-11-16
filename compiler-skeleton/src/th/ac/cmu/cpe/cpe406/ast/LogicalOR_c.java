package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class LogicalOR_c extends LogicalOp_c implements LogicalOR {

	public LogicalOR_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

}
