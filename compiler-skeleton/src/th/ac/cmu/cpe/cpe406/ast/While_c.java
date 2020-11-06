package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Position;
//if  creating another loop, change this file to loop.
public class While_c extends Stmt_c implements While {
	protected Expr cond;
    protected Stmt body;
    
	public While_c(Position pos, Expr cond, Stmt body) {
		super(pos);
		assert (body != null);
		this.body = body;
        this.cond = cond;
		// TODO Auto-generated constructor stub
	}



}
