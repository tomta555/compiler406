package th.ac.cmu.cpe.cpe406.ir;

public class IRCJump_c extends IRStmt_c implements IRCJump {
	
	protected IRExpr e;
	protected String l1, l2;
	
	public IRCJump_c(IRExpr e, String l1, String l2) {
		this.e = e;
		this.l1 = l1;
		this.l2 = l2;
	}
}
