package th.ac.cmu.cpe.cpe406.ir;

public class IREseq_c extends IRExpr_c implements IREseq {
	
	protected IRStmt stmt;
	protected IRExpr expr;
	
	public IREseq_c(IRStmt s, IRExpr  e) {
		this.stmt = s;
		this.expr = e;
	}
}
