package th.ac.cmu.cpe.cpe406.ast;

import java.util.List;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class ArrayInit_c extends Stmt_c implements ArrayInit {
	protected Id id; 
	protected List<Expr> elements;

	public ArrayInit_c(Position pos,Id id,List<Expr> elements) {
		super(pos);
		// TODO Auto-generated constructor stub
        assert (elements != null);
        this.id = id;
        this.elements = elements ;
    }
	

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
