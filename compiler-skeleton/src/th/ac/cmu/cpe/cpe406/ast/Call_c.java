package th.ac.cmu.cpe.cpe406.ast;

import java.util.List;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Call_c extends Expr_c implements Call {

	protected Id id;
	protected List<Expr> args;
	
	public Call_c(Position pos, Id id, List<Expr> args) {
		super(pos);
		this.id = id;
		this.args = args;
	}

	@Override
	public Type typeCheck(SymTable sym) {
		// TODO Auto-generated method stub
		return null;
	}



}
