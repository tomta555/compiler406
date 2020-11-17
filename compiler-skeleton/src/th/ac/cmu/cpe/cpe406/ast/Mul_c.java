package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.ir.IRMul_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Mul_c extends ArithmeticOp_c implements Mul{

	public Mul_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

	@Override
	public IRExpr translate() {
		return new IRMul_c(l.translate(),r.translate());
	}
}
