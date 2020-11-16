package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.BoolType_c;
import th.ac.cmu.cpe.cpe406.types.IntType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Param_c extends Node_c implements Param {

    protected Id id;
    protected TypeNode typeNode;
    protected Type type;

    public Param_c(Position pos, Id id, TypeNode typeNode) {
        super(pos);
        this.id = id;
        this.typeNode = typeNode;
    }

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
    	Type typeToAdd = null;
    	if (sym.lookup(id.toString()) == null) {
	    	if (typeNode.typeCheck(sym).isInt()) {
	    		typeToAdd = new IntType_c();
	    	} else if (typeNode.typeCheck(sym).isBool()){
	    		typeToAdd = new BoolType_c();
	    	} else {
	    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Primitive type error");
	    		// this happen when internal compile error with Unknown primitive type
	    	}
    	} else {
    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Duplicate parameter '"+ id.name());
    	}
    	sym.add(id.name(), typeToAdd);

		return typeToAdd;
	}
	
	@Override
	public SymTable BuildSymbolTable(SymTable sym) throws Exception {
		// TODO Auto-generated method stub
		return sym;
	}
	

}
