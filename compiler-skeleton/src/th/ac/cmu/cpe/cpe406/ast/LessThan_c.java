package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.ir.IRSlt_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class LessThan_c extends ComparisonOp_c implements LessThan {

	public LessThan_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

	@Override
	public IRExpr translate() {
		// TODO Auto-generated method stub
		return new IRSlt_c(l.translate(), r.translate());
	}

}
