package th.ac.cmu.cpe.cpe406.ast;


import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.SymTable_c;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;
import java.util.List;

public class Block_c extends Stmt_c implements Block {

	protected List<Stmt> statements;
	protected Type type;
	public Block_c(Position pos, List<Stmt> statements) {
        super(pos);
        assert (statements != null);
        this.statements = statements;
    }

	@Override
    public Type typeCheck(SymTable sym) throws Exception{
		SymTable newSym = new SymTable_c(sym);
    	for (Stmt s : statements) {
    		 if (!s.typeCheck(newSym).isUnit()) {
    			 throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Some statement in block is not a valid statement");
    		 }
    	}
    	this.type = new Unit_c();
		return this.type;
		
	}
}
