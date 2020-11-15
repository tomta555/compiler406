package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class BooleanLit_c extends Expr_c implements BooleanLit{

	protected boolean value;
	
	public BooleanLit_c(Position pos, boolean value) {
		super(pos);
		this.value = value;
	}

	@Override
	public Type typeCheck(SymTable sym) {
		// TODO Auto-generated method stub
		return null;
	}

}
