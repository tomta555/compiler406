package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.BoolType_c;
import th.ac.cmu.cpe.cpe406.types.IntType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class PrimitiveTypeNode_c extends TypeNode_c
        implements PrimitiveTypeNode {

    protected PrimitiveTypeNode.Kind kind;
    protected Type type;
    public PrimitiveTypeNode_c(Position pos, PrimitiveTypeNode.Kind kind) {
        super(pos);
        this.kind = kind;
    }

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		if (kind.toString() == "int") {
			this.type = new IntType_c();
		} else if (kind.toString() == "bool") {
			this.type = new BoolType_c();
		} else {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Unknown Primitive Type");
		}
		return this.type;
	}
	
	@Override
	public SymTable BuildSymbolTable(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return sym;
	}
	
}
