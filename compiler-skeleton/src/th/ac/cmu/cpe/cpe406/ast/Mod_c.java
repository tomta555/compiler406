package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.ir.IRMod_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Mod_c extends ArithmeticOp_c implements Mod{

	public Mod_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}
	
	@Override
	public IRExpr translate() {
		return new IRMod_c(l.translate(),r.translate());
	}
}
