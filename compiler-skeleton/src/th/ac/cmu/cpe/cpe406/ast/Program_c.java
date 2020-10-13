package th.ac.cmu.cpe.cpe406.ast;

import java.util.List;

import th.ac.cmu.cpe.cpe406.util.Position;

public class Program_c extends Node_c implements Program {

    protected String filename;

    public Program_c(Position pos, String filename, List<Stmt> stmts) {
        super(pos);
        this.filename = filename;
    }

}
