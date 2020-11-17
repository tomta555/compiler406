package th.ac.cmu.cpe.cpe406.ir;

public class IRMove_c extends IRStmt_c implements IRMove {

	protected IRExpr dest;
	protected IRExpr e;
	public IRMove_c(IRExpr dest, IRExpr e) {
		this.dest = dest;
		this.e = e;
	}
}
