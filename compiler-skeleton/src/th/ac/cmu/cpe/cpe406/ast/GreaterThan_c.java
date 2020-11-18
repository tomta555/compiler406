package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.ir.IRSlt_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class GreaterThan_c extends ComparisonOp_c implements GreaterThan {

	public GreaterThan_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

	@Override
	public IRExpr translate() {
		return new IRSlt_c(r.translate(), l.translate());
	}

}
