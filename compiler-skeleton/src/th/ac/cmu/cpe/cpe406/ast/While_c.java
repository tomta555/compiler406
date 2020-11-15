package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;
//if  creating another loop, change this file to loop.
public class While_c extends Stmt_c implements While {
	protected Expr cond;
    protected Stmt body;
    protected Type type;
	public While_c(Position pos, Expr cond, Stmt body) {
		super(pos);
		assert (body != null);
		this.body = body;
        this.cond = cond;
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		if (cond != null && body != null) {
			if (cond.typeCheck(sym).isBool()) {
				if (!body.typeCheck(sym).isUnit()) {
					throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Some statement in while body is not a valid statement");
				}
			} else {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\\nError: Condition of 'while' is not 'bool'");
			}
		} else {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Condition or body is 'null'");
		}
		this.type = new Unit_c();
		return this.type;
	}

}
