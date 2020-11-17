package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Array_c extends TypeNode_c implements Array {

	protected TypeNode type;
    protected Integer dim;
	public Array_c(Position pos, TypeNode type) {
        super(pos);
        assert (type != null);
        this.type = type;
    }
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SymTable BuildSymbolTable(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
