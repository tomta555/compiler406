package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Add_c extends Binary_c implements Add {
	
	public Add_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}
}
