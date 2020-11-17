package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.ir.IRAdd_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Add_c extends ArithmeticOp_c implements Add {
	
	public Add_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

	@Override
	public IRExpr translate() {
		return new IRAdd_c(l.translate(),r.translate());
	}
	
}
