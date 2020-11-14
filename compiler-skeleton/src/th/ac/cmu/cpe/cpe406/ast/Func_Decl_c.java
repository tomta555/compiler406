package th.ac.cmu.cpe.cpe406.ast;

import java.util.List;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Func_Decl_c extends Node_c implements Func_Decl {
	
    protected Id name;
    protected TypeNode returnType;
    protected List<Param> params;
    protected Block body;
	public Func_Decl_c(Position pos, Id name, List<Param> params, TypeNode returnType, Block body) {
		super(pos);
        this.name = name;
        this.returnType = returnType;
        this.params = params;
        this.body = null;
	}
	@Override
	public Func_Decl body(Block b) {
		this.body = b;
		return this;
	}

}
