package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Variable_c extends Expr_c implements Variable {

    protected Id id;

    public Variable_c(Position pos, Id id) {
        super(pos);
        this.id = id;
    }

	@Override
	public Type typeCheck(SymTable sym) {
		// TODO Auto-generated method stub
		return null;
	}

}
