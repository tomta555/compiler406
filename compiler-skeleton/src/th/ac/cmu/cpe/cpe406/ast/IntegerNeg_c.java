package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.IntType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class IntegerNeg_c extends Unary_c implements IntegerNeg{
	
	protected Type type;
	
	public IntegerNeg_c(Position pos, Expr expr) {
		super(pos, expr);
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		Type exprType = expr.typeCheck(sym);
		if(!exprType.isInt()) {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Expression is not 'int");
		}
		this.type = new IntType_c();
		return this.type;
	}

}
