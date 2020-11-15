package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public abstract class ArithmeticOp_c extends Binary_c implements ArithmeticOp {

	public ArithmeticOp_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type typeCheck(SymTable sym) {
		// TODO Auto-generated method stub
		return null;
	}

}
