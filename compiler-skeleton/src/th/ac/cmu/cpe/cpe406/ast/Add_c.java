package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.IntType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.InternalCompilerError;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Add_c extends Binary_c implements Add {
	protected Type type;
	public Add_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}
	
	public Type typeCheck(SymTable sym) {
		Type lType = l.typeCheck(sym);
		Type rType = r.typeCheck(sym);
		if (lType != null && rType != null) {
			if (!lType.isInt()) { // how to check if lType is int
				throw new InternalCompilerError("left is not int"); // how can we Throw error
			}
			if (!rType.isInt()) {
				throw new InternalCompilerError("right is not int");
			}
		}
		this.type = new IntType_c();
		return this.type;
	}
}
