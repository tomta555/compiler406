package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;

public interface Expr extends Node {

	Type typeCheck(SymTable sym) throws Exception;

	int getValue();

}
