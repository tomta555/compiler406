package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.BoolType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class BooleanNeg_c extends Unary_c implements BooleanNeg {
	
	protected Type type;
	
	public BooleanNeg_c(Position pos, Expr expr) {
		super(pos, expr);
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		Type exprType = expr.typeCheck(sym);
		if(!exprType.isBool()) {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line()+ "\nError: Expression is not 'bool'");
		}
		this.type = new BoolType_c();
		return this.type;
	}

}
