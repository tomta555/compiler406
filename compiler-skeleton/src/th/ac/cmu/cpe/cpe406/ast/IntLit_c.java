package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class IntLit_c extends Expr_c implements IntLit{

	protected int value;
	protected Type type;
	
	public IntLit_c(Position pos, int value) {
		super(pos);
		this.value = value;
		
	}   
	
	public Type typeCheck(SymTable sym) {
//		this.type =   ;
		return this.type;
	}
}

	