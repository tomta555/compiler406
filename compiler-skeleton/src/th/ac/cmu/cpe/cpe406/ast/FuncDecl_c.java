package th.ac.cmu.cpe.cpe406.ast;

import java.util.List;

import th.ac.cmu.cpe.cpe406.util.Position;

public class FuncDecl_c extends Node_c implements FuncDecl {
	
    protected Id name;
    protected TypeNode returnType;
    protected List<Param> params;
    protected Block body;
	public FuncDecl_c(Position pos, Id name, List<Param> params, TypeNode returnType, Block body) {
		super(pos);
        this.name = name;
        this.returnType = returnType;
        this.params = params;
        this.body = null;
	}
	@Override
	public FuncDecl body(Block b) {
		this.body = b;
		return this;
	}

}
