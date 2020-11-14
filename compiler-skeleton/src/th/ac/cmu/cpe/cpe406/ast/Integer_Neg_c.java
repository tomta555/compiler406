package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Integer_Neg_c extends Unary_c implements Integer_Neg{

	public Integer_Neg_c(Position pos, Expr expr) {
		super(pos, expr);
	}

	@Override
	public Type typeCheck(SymTable sym) {
		// TODO Auto-generated method stub
		return null;
	}

}
