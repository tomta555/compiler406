package th.ac.cmu.cpe.cpe406.ast;

import java.util.LinkedList;
import java.util.List;

import th.ac.cmu.cpe.cpe406.types.FunctionType_c;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.SymTable_c;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.types.Unit_c;
import th.ac.cmu.cpe.cpe406.util.Position;

public class FuncDecl_c extends Node_c implements FuncDecl {
	
    protected Id name;
    protected TypeNode returnType;
    protected Stmt returnStmt;
    protected List<Param> params;
    protected Block body;
    protected Type type;
    protected Type retType;
    protected SymTable funcSym;
	public FuncDecl_c(Position pos, Id name, List<Param> params, TypeNode returnType, Block body) {
		super(pos);
        this.name = name;
        this.returnType = returnType;
        this.params = params;
        this.body = null;
	}
	
	@Override
	public FuncDecl body(Block b) {
		this.body = b;
		return this;
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception {
		
		Type returnStmtType = null;
		
		String returnStmtTypeString = "";
		
		String returnTypeString = "";
		
    	this.returnStmt = body.getLastStatement();
    	
    	if (returnStmt != null) {
    		
    		returnStmtType = returnStmt.typeCheck(this.funcSym);
    		
    		if (returnStmtType.isUnit()) {
    			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: No return statement in function body");
    		} else if (returnStmtType.isInt()) {
    			returnStmtTypeString = "int";
    		} else if (returnStmtType.isBool()) {
    			returnStmtTypeString = "bool";
    		}
    		else {
    			
    		}
    	} else {
    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: No return statement in function body");
    	}
    	
    	if (retType.isInt()) {
    		returnTypeString = "int";
    	} else if (retType.isBool()){
    		returnTypeString = "bool";
    	} else {
    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Primitive type error");
    		// this happen when internal compile error with Unknown primitive type
    	}
    	
    	if (returnTypeString != returnStmtTypeString) {
    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Return statement must return type " + returnTypeString);
    	}
		
    	if (!body.typeCheckFunc(funcSym).isUnit()) { //Body can't declare variable name that already is an input argument
    		throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Some statement in function body is not a valid statement");
    	}

		this.type = new Unit_c();
		return this.type;
	}

	@Override
	public SymTable BuildSymbolTable(SymTable sym) throws Exception {
		
		Type fn = sym.lookup(name.name());
		
		if (fn != null) {
			throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Redeclaration of function'" + name.name()+"'");
		}
		
		SymTable newSym = new SymTable_c(sym);
		
		List<Type> paramTypes = new LinkedList<>();

		for (Param p : params) {
			paramTypes.add(p.typeCheck(newSym));
		}
		
		this.funcSym = newSym;
		
		Type retType = returnType.typeCheck(newSym);
		
		this.retType = retType;
		
    	Type funcType = new FunctionType_c(paramTypes, retType);
    	
    	sym.add(name.name(), funcType);
    	    	
		return sym;
	}
	
}
