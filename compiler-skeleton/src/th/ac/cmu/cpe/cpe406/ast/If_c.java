package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.util.Position;

public class If_c extends Stmt_c implements If {
	protected Expr cond;
    protected Stmt consequent;
    protected Stmt alternative;
    
	public If_c(Position pos, Expr cond, Stmt consequent) {
		super(pos);
        assert cond != null && consequent != null;
        this.cond = cond;
        this.consequent = consequent;
	}

	public If_c(Position pos, Expr cond, Stmt consequent, Stmt alternative) {
		super(pos);
        assert cond != null && consequent != null; // alternative may be null;
        this.cond = cond;
        this.consequent = consequent;
        this.alternative = alternative;
	}

}
