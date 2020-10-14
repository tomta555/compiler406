package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class BooleanLit_c extends Expr_c implements BooleanLit{

	protected boolean bool;
	
	public BooleanLit_c(Position pos, boolean bool) {
		super(pos);
		this.bool = bool;
	}

}
