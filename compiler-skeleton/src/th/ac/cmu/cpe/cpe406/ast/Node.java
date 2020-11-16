package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Copy;
import th.ac.cmu.cpe.cpe406.util.Position;

public interface Node extends Copy<Node> {

    Position position();

	Type typeCheck(SymTable sym) throws Exception;
	
	SymTable BuildSymbolTable(SymTable sym) throws Exception;
	
}
