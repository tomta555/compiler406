package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Empty_c extends Stmt_c implements Empty {
	
	protected Type type;
	
	public Empty_c(Position pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		this.type = new Unit_c();
		return this.type;
	}

}
