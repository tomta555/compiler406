package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.ArrayType_c;
import th.ac.cmu.cpe.cpe406.types.BoolType_c;
import th.ac.cmu.cpe.cpe406.types.IntType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class LocalDecl_c extends Stmt_c implements LocalDecl {

    protected Id id;
    protected TypeNode typeNode;
    protected Type type;

    public LocalDecl_c(Position pos, Id id, TypeNode typeNode) {
        super(pos);
        this.id = id;
        this.typeNode = typeNode;
    }
    
    @Override
    public Type typeCheck(SymTable sym) throws Exception{
    	Type typeToAdd = null;
    	if (sym.lookup(id.name()) == null) {
    		Type checkType = typeNode.typeCheck(sym);
	    	if (checkType.isInt()) {
	    		typeToAdd = new IntType_c();
	    	} else if (checkType.isBool()){
	    		typeToAdd = new BoolType_c();
	    	} else if (checkType.isArray()){
	    		Type eleType = checkType.getElementType();
	    		typeToAdd = new ArrayType_c(eleType);
	    	}
	    	else {
	    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Primitive type error");
	    		// this happen when internal compile error with Unknown primitive type
	    	}
    	} else {
    		String typeError = "Unknown Type";
    		if (sym.lookup(id.name()).isInt()){
    			typeError = "int";
    		} else if (sym.lookup(id.name()).isBool()){
    			typeError = "bool";
    		} 
    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Redeclaration of '" + id.name()  +":" + typeError + "'");
    	}
    	sym.add(id.name(), typeToAdd);
    	
    	this.type = new Unit_c();
		return this.type;
	}
}

	