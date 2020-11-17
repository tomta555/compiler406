package th.ac.cmu.cpe.cpe406.ir;

import java.util.List;

public class IRSeq_c extends IRStmt_c implements IRSeq {
	
	protected List<IRStmt> seq;
	
	public IRSeq_c(List<IRStmt> seq) {
		this.seq = seq;
	}
}
