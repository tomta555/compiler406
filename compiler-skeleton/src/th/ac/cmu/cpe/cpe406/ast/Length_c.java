package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.types.IntType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Length_c extends Expr_c implements Length {

	protected Id id;
	protected Type type;
	
	public Length_c(Position pos, Id id) {
		super(pos);
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		Type arrType = sym.lookup(id.name());
		if (arrType != null) {
			if (!arrType.isArray()) {
				throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: '" + id.name() + "' is not an array");
			}
		}else {
			throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: '" + id.name() + "' was not declared in this scope");
		}
		this.type = new IntType_c();
		return this.type;
	}

	@Override
	public IRExpr translate() {
		// TODO Auto-generated method stub
		return null;
	}


}
