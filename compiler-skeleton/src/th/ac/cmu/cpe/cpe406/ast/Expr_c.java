package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.util.Position;

public abstract class Expr_c extends Node_c implements Expr {

    public Expr_c(Position pos) {
        super(pos);
    }
    
	@Override
	public SymTable BuildSymbolTable(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return sym;
	}
	
}
