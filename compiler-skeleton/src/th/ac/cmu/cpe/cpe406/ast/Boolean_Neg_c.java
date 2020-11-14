package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Boolean_Neg_c extends Unary_c implements Boolean_Neg {
	
	public Boolean_Neg_c(Position pos, Expr expr) {
		super(pos, expr);
	}

	@Override
	public Type typeCheck(SymTable sym) {
		// TODO Auto-generated method stub
		return null;
	}

}
