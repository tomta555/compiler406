package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Boolean_Lit_c extends Expr_c implements Boolean_Lit{

	protected boolean value;
	
	public Boolean_Lit_c(Position pos, boolean value) {
		super(pos);
		this.value = value;
	}

	@Override
	public Type typeCheck(SymTable sym) {
		// TODO Auto-generated method stub
		return null;
	}

}
