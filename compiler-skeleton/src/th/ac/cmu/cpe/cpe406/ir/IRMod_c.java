package th.ac.cmu.cpe.cpe406.ir;

public class IRMod_c extends IRExpr_c implements IRMod {

	
	protected IRExpr l;
	protected IRExpr r;
	
	public IRMod_c(IRExpr l, IRExpr r) {
		this.l = l;
		this.r = r;
	}
}
