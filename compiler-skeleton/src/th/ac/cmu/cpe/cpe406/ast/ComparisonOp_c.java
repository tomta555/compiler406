package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.BoolType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public abstract class ComparisonOp_c extends Binary_c implements ComparisonOp {
	
	protected Type type;
	
	public ComparisonOp_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		Type lType = l.typeCheck(sym);
		Type rType = r.typeCheck(sym);
		if (lType != null && rType != null) {
			if (!lType.isInt()) {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line()+ "\nError: Left of operator is not 'int'");
			}
			if (!rType.isInt()) {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line()+ "\nError: Right of operator is not 'int'");
			}
		} else {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line()+ "\nError: Left or Right of operator is 'null'");
		}
		this.type = new BoolType_c();
		return this.type;
	}
}
