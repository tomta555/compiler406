package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.ir.IRSub_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Sub_c extends ArithmeticOp_c implements Sub {
	
	public Sub_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

	@Override
	public IRExpr translate() {
		return new IRSub_c(l.translate(),r.translate());
	}

}
