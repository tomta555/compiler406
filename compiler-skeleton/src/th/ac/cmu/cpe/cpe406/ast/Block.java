package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;

public interface Block extends Stmt {

	Stmt getLastStatement();

	Type typeCheckFunc(SymTable sym) throws Exception;

}
