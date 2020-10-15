package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Boolean_Lit_c extends Expr_c implements Boolean_Lit{

	protected boolean value;
	
	public Boolean_Lit_c(Position pos, boolean value) {
		super(pos);
		this.value = value;
	}

}
