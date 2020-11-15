package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Pow_c extends ArithmeticOp_c implements Pow {

	public Pow_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

}
