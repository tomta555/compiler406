package th.ac.cmu.cpe.cpe406.ast;

import java.util.LinkedList;
import java.util.List;

import th.ac.cmu.cpe.cpe406.ir.IRCJump_c;
import th.ac.cmu.cpe.cpe406.ir.IRConst_c;
import th.ac.cmu.cpe.cpe406.ir.IREseq_c;
import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.ir.IRLabel_c;
import th.ac.cmu.cpe.cpe406.ir.IRMove_c;
import th.ac.cmu.cpe.cpe406.ir.IRSeq_c;
import th.ac.cmu.cpe.cpe406.ir.IRStmt;
import th.ac.cmu.cpe.cpe406.ir.IRTemp_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class LogicalAND_c extends LogicalOp_c implements LogicalAND {

	public LogicalAND_c(Position pos, Expr l, Expr r) {
		super(pos, l, r);
	}

	@Override
	public IRExpr translate() {
		List<IRStmt> stmtList = new LinkedList<>();
		String x = "x";
		String l1 = "l1";
		String l2 = "l2";
		String lf = "lf";
		
		stmtList.add(new IRMove_c(new IRTemp_c(x), new IRConst_c(0)));
		stmtList.add(new IRCJump_c(l.translate(),l1,lf));
		stmtList.add(new IRLabel_c(l1));
		stmtList.add(new IRCJump_c(r.translate(),l2,lf));
		stmtList.add(new IRLabel_c(l2));
		stmtList.add(new IRMove_c(new IRTemp_c(x), new IRConst_c(1)));
		stmtList.add(new IRLabel_c(lf));
		
		return new IREseq_c(new IRSeq_c(stmtList), new IRTemp_c(x));
	}

}
