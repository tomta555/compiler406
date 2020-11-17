package th.ac.cmu.cpe.cpe406.ir;

public class IRAdd_c extends IRExpr_c implements IRAdd {
	
	protected IRExpr l;
	protected IRExpr r;
	
	public IRAdd_c(IRExpr l, IRExpr r) {
		this.l = l;
		this.r = r;
	}

}
