package th.ac.cmu.cpe.cpe406.ir;

public class IRSub_c extends IRExpr_c implements IRSub {
	
	protected IRExpr l;
	protected IRExpr r;
	
	public IRSub_c(IRExpr l, IRExpr r) {
		this.l = l;
		this.r = r;
	}
}
