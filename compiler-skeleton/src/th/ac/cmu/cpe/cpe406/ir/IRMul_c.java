package th.ac.cmu.cpe.cpe406.ir;

public class IRMul_c extends IRExpr_c implements IRMul {
	
	protected IRExpr l;
	protected IRExpr r;
	
	public IRMul_c(IRExpr l, IRExpr r) {
		this.l = l;
		this.r = r;
	}
}
