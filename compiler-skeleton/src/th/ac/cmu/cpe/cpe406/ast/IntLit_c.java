package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class IntLit_c extends Expr_c implements IntLit{

	protected int value;

	public IntLit_c(Position pos, int value) {
		super(pos);
		this.value = value;
	}   
}
