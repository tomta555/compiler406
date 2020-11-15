package th.ac.cmu.cpe.cpe406.ast;

import java.util.List;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.SymTable_c;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class FuncDecl_c extends Node_c implements FuncDecl {
	
    protected Id name;
    protected TypeNode returnType;
    protected List<Param> params;
    protected Block body;
    protected Type type;
	public FuncDecl_c(Position pos, Id name, List<Param> params, TypeNode returnType, Block body) {
		super(pos);
        this.name = name;
        this.returnType = returnType;
        this.params = params;
        this.body = null;
	}
	
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		SymTable newSym = new SymTable_c(sym);
		for (Param p : params) {
			p.typeCheck(newSym);
		}
    	if (returnType.typeCheck(sym).isInt()) {
    		
    	} else if (returnType.typeCheck(sym).isBool()){
    		
    	} else {
    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Primitive type error");
    		// this happen when internal compile error with Unknown primitive type
    	}
    	if (!body.typeCheck(newSym).isUnit()) { //Body can't declare variable name that already is an input argument
    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Some statement in function body is not a valid statement");
    	}
		this.type = new Unit_c();
		return this.type;
	}
	
	@Override
	public FuncDecl body(Block b) {
		this.body = b;
		return this;
	}

}
