package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.IntType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Div_c extends ArithmeticOp_c implements Div{

	public Div_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}
	
	// implement type check for DIVIDE BY ZERO
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		Type lType = l.typeCheck(sym);
		Type rType = r.typeCheck(sym);
		if (lType != null && rType != null) {
			if (!lType.isInt()) {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Left of operator is not 'int'");
			}
			if (!rType.isInt()) {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Right of operator is not 'int'");
			}
			if (r.getValue() == 0) {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Division by zero");
			}
		} else {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Left or Right of operator is 'null'");
		}
		this.type = new IntType_c();
		return this.type;
	}
	
}
