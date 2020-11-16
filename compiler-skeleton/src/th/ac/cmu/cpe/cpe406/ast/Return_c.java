package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Return_c extends Stmt_c implements Return {
	
	protected Expr expr;
	
	public Return_c(Position pos, Expr expr) {
		super(pos);
		this.expr = expr;
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
