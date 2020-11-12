package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.util.Position;
import java.util.List;

public class Block_c extends Stmt_c implements Block {

	protected List<Stmt> statements;
	public Block_c(Position pos, List<Stmt> statements) {
        super(pos);
        assert (statements != null);
        this.statements = statements;
    }

	public void typeCheck(SymTable sym) {
//		for (Stmt s:statements)
//			s.typeCheck(sym);
	}		
}
