package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.BoolType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class EqualEqual_c extends ComparisonOp_c implements EqualEqual{

	public EqualEqual_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		Type lType = l.typeCheck(sym);
		Type rType = r.typeCheck(sym);
		if (lType != null && rType != null) {
			if (lType.isInt()) {					//if left is int
				if (!rType.isInt()) {				//if right is bool
					throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line()+ "\nError: Can't compare expression type 'bool' with expression type 'int'");
				}
			}
			else if (!lType.isInt()) {				//if left is bool
				if (rType.isInt()) {				//if right is int
					throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line()+ "\nError: Can't compare expression type 'int' with expression type 'bool'");
				}
			}
		} else {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line()+ "\nError: Left or Right of operator is 'null'");
		}
		this.type = new BoolType_c();
		return this.type;
	}

}
