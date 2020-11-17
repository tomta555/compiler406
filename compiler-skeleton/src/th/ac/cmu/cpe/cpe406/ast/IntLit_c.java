package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.ir.IRConst_c;
import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.types.IntType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class IntLit_c extends Expr_c implements IntLit{

	protected int value;
	protected Type type;
	
	public IntLit_c(Position pos, int value) {
		super(pos);
		this.value = value;
	}   
	
	@Override
	public Type typeCheck(SymTable sym) {
		this.type = new IntType_c();
		return this.type;
	}

	@Override
	public IRExpr translate() {
		return new IRConst_c(value);
	}

}

	