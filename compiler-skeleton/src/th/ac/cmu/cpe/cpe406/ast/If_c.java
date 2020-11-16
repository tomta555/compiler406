package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class If_c extends Stmt_c implements If {
	
	protected Expr cond;
    protected Stmt consequent;
    protected Stmt alternative;
    protected Type type;
    
	public If_c(Position pos, Expr cond, Stmt consequent) {
		super(pos);
        assert cond != null && consequent != null;
        this.cond = cond;
        this.consequent = consequent;
	}

	public If_c(Position pos, Expr cond, Stmt consequent, Stmt alternative) {
		super(pos);
        assert cond != null && consequent != null && alternative != null; // alternative may be null;
        this.cond = cond;
        this.consequent = consequent;
        this.alternative = alternative;
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		if (cond != null && consequent != null) {
			if (cond.typeCheck(sym).isBool()) {
				if (!consequent.typeCheck(sym).isUnit()) {
					throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Consequent of 'if' is not valid");
				} 
				
				if (alternative != null) {
					if (!alternative.typeCheck(sym).isUnit()) {
						throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Alternative of 'else' is not valid");
					}
				}
			} else {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Condition of 'if' is not 'bool'");
			}
		} else {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Condition or Consequent is 'null'");
		}
		this.type = new Unit_c();
		return this.type;
	}

}
