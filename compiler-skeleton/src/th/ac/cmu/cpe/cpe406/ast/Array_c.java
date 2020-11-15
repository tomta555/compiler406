package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Array_c extends TypeNode_c implements Array {
	protected TypeNode type;
    protected Integer dim;
	public Array_c(Position pos, TypeNode type ,Integer dim) {
        super(pos);
        assert (type != null);
        this.type = type;
        this.dim = dim;
    }


}
