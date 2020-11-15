package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Id_c extends Node_c implements Id {

    protected String name;

    public Id_c(Position pos, String name) {
        super(pos);
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return new Unit_c();
	}
}
