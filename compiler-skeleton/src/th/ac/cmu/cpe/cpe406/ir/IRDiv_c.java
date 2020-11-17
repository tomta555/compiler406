package th.ac.cmu.cpe.cpe406.ir;

public class IRDiv_c extends IRExpr_c implements IRDiv {
	
	protected IRExpr l;
	protected IRExpr r;
	
	public IRDiv_c(IRExpr l, IRExpr r) {
		this.l = l;
		this.r = r;
	}
}
