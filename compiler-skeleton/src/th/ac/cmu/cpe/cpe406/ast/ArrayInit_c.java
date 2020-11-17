package th.ac.cmu.cpe.cpe406.ast;

import java.util.List;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class ArrayInit_c extends Stmt_c implements ArrayInit {
	protected Id id; 
	protected List<Expr> elements;

	public ArrayInit_c(Position pos,Id id,List<Expr> elements) {
		super(pos);
        assert (elements != null);
        this.id = id;
        this.elements = elements ;
    }

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		int size = elements.size();
		String aType = "";
		Type arrType = sym.lookup(id.name());
		if (arrType != null) {
			if (!arrType.isArray()) {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: "+ id.name() + " is not an array");
			} else {
				arrType.addSize(size);
				if (arrType.getElementType().isInt()) {
					aType = "int";
				} else if (arrType.getElementType().isBool()) {
					aType = "bool";
				} else {
					throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Unknown array Type");
				}
			}
			if (aType == "int") {
				for (Expr e : elements) {
					if(e.typeCheck(sym).isBool()) {
						throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: All elements must be type int");
					}	
				}
			} else if (aType == "bool") {
				for (Expr e : elements) {
					if(e.typeCheck(sym).isInt()) {
						throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: All elements must be type bool");
					}	
				}
			} else {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Unknown element Type");
			}
		} else {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Array " + id.name() + " was not declared in this scope");
		}
		
		
		return new Unit_c();
	}

}
