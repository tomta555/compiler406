package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.BoolType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public abstract class LogicalOp_c extends Binary_c implements LogicalOp {

	protected Type type;
	
	public LogicalOp_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		Type lType = l.typeCheck(sym);
		Type rType = r.typeCheck(sym);
		if (lType != null && rType != null) {
			if (!lType.isBool()) {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Left or Right of operator is not 'bool'");
			}
			if (!rType.isBool()) {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Left or Right of operator is not 'bool'");
			}
		} else {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Left or Right of operator is 'null'");
		}
		this.type = new BoolType_c();
		return this.type;
	}

}
