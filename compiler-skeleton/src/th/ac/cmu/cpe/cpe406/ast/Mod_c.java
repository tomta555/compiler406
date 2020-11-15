package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Mod_c extends ArithmeticOp_c implements Mod{

	public Mod_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

}
