package th.ac.cmu.cpe.cpe406.ir;

public class IRMem_c extends IRExpr_c implements IRMem {

	protected IRExpr e;
	
	public IRMem_c(IRExpr e) {
		this.e = e;
	}
}
