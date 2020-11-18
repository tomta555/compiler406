package th.ac.cmu.cpe.cpe406.ast;

import java.util.List;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Program_c extends Node_c implements Program {

    protected String filename;
    protected List<Stmt> stmts;
    protected List<FuncDecl> funcs;
    public Program_c(Position pos, String filename, List<Stmt> stmts, List<FuncDecl> funcs) {
        super(pos);
        this.filename = filename;
        this.stmts = stmts;
        this.funcs = funcs;
    }
    
	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		for (Stmt s : stmts) {
			s.typeCheck(sym);
		}
		return new Unit_c();
	}

	@Override
	public SymTable BuildSymbolTable(SymTable sym) throws Exception {
		for (FuncDecl f : funcs) {
			f.BuildSymbolTable(sym);
		}
		return sym;
	}
}
