package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.ArrayType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class ArrayTypeNode_c extends TypeNode_c implements ArrayTypeNode {

	protected TypeNode arrayType;
    protected Integer dim;
    protected Type type;
	public ArrayTypeNode_c(Position pos, TypeNode arrayType) {
        super(pos);
        assert (type != null);
        this.arrayType = arrayType;
    }
	
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		this.type = new ArrayType_c(arrayType.typeCheck(sym));
		return this.type;
	}
	
	@Override
	public SymTable BuildSymbolTable(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
