package th.ac.cmu.cpe.cpe406.ast;

import java.util.ArrayList;
import java.util.List;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Assign_c extends Stmt_c implements Assign {

	List<Variable> l;
	List<Expr> r;
	protected Type type;
	
    public Assign_c(Position pos, List<Variable> l, List<Expr> r) {
        super(pos);
        this.l = l;
        this.r = r;
    }
    
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		int varLength = l.size();
		int exprLength = r.size();
		if(varLength == exprLength) {
			ArrayList<Type> lTypeList = new ArrayList<Type>(varLength);
			ArrayList<Type> rTypeList = new ArrayList<Type>(exprLength);
			for(Variable v: l) {
				lTypeList.add(v.typeCheck(sym));
			}
			for(Expr e : r) {
				rTypeList.add(e.typeCheck(sym));
			}
			for(int i=0 ; i < varLength ; i++) {
				Type lType = lTypeList.get(i);
				Type rType = rTypeList.get(i);
				if (lType != null && rType != null) {
					if (lType.isInt()) {					//if left is int
						if (!rType.isInt()) {				//if right is bool
							throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Can't assign expression type 'bool' to variable type 'int' ");
						}
					}
					else if (!lType.isInt()) {				//if left is bool
						if (rType.isInt()) {				//if right is int
							throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Can't assign expression type 'int' to variable type 'bool' ");
						}
					}
				} else {
					throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Some variable(s) or expression(s) are 'null' ");
				}
			}
		} else {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Number of variable and expression not match");
		}

		this.type = new Unit_c();
		return this.type;
	}

}
