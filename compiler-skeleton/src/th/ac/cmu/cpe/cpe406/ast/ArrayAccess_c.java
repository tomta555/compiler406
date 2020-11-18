package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class ArrayAccess_c extends Variable_c implements ArrayAccess {
	protected Id name;
    protected Expr index;
    protected Type type;
	public ArrayAccess_c(Position pos,Id name, Expr index) {
		super(pos,name);
        assert (name != null && index != null);
        this.name = name;
        this.index = index;
	}
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		Type arrType = sym.lookup(name.name());
		if (arrType != null) {
			if (!arrType.isArray()) {
				throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: '" + id.name() + "' is not an array");
			} else {
				if (!index.typeCheck(sym).isInt()) {
					throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: Array index is not an 'int'");
				}
				this.type = arrType.getElementType();
			}
		} else {
			throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: '" + id.name() + "' was not declared in this scope");
		}
		return this.type;
	}

	

}
