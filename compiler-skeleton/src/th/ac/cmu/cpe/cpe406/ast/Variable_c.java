package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Variable_c extends Expr_c implements Variable {

    protected Id id;
    protected Type type;
    
    public Variable_c(Position pos, Id id) {
        super(pos);
        this.id = id;
    }

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		Type varType = sym.lookup(id.name());
		if(varType == null) {
			throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: '" + id.name() + "' was not declared in this scope");
		}
		this.type = varType;
		return this.type;
	}
}
