package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class ArrayAccess_c extends Variable_c implements ArrayAccess {
	protected Id array;
    protected Expr index;
	public ArrayAccess_c(Position pos,Id array, Expr index) {
		super(pos,array);
        assert (array != null && index != null);
        this.array = array;
        this.index = index;
	}
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
