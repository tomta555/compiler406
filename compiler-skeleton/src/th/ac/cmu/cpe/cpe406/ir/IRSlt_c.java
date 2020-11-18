package th.ac.cmu.cpe.cpe406.ir;

public class IRSlt_c extends IRExpr_c implements IRSlt {

	protected IRExpr l;
	protected IRExpr r;
	
	public IRSlt_c(IRExpr l, IRExpr r) {
		this.l = l;
		this.r = r;
	}
	
}
