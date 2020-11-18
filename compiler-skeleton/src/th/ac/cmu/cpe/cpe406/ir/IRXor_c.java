package th.ac.cmu.cpe.cpe406.ir;

public class IRXor_c extends IRExpr_c implements IRXor {
	
	protected IRExpr l;
	protected IRExpr r;
	
	public IRXor_c(IRExpr l, IRExpr r) {
		this.l = l;
		this.r = r;
	}
}