package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.ir.IRConst_c;
import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.types.BoolType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class BooleanLit_c extends Expr_c implements BooleanLit{

	protected boolean value;
	protected Type type;
	
	public BooleanLit_c(Position pos, boolean value) {
		super(pos);
		this.value = value;
	}

	@Override
	public Type typeCheck(SymTable sym) {
		this.type = new BoolType_c();
		return this.type;
	}

	@Override
	public IRExpr translate() {
		int v = 0;
		if (value) {
			v = 1;
		}
		return new IRConst_c(v);
	}
}
