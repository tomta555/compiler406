package th.ac.cmu.cpe.cpe406.ast;

import java.util.LinkedList;
import java.util.List;

import th.ac.cmu.cpe.cpe406.ir.IRExpr;
import th.ac.cmu.cpe.cpe406.types.SymTable;
import th.ac.cmu.cpe.cpe406.types.Type;
import th.ac.cmu.cpe.cpe406.util.Position;

public class Call_c extends Expr_c implements Call {

	protected Id id;
	protected List<Expr> args;
	protected Type type;
	public Call_c(Position pos, Id id, List<Expr> args) {
		super(pos);
		this.id = id;
		this.args = args;
	}

	@Override
	public Type typeCheck(SymTable sym) throws Exception{
		
		Type funcType = sym.lookup(id.name());
		
		if(!funcType.isFunction()) {
			throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: '" + id.name() + "' is not a function");
		}
		
		List<Type> paramTypes = funcType.getParamTypes();
		
		List<String> paramStrs = new LinkedList<>();
		
		List<String> argStrs = new LinkedList<>();
		
		String argsTypeStr = "";
		
		for (Expr e : args) {
			Type argType = e.typeCheck(sym);
			if (argType.isInt()) {
				argStrs.add("int");
				argsTypeStr += ",int";
			} else if(argType.isBool()) {
				argStrs.add("bool");
				argsTypeStr += ",bool";
			} else if(argType.isArray()) {
				if (argType.getElementType().isInt()) {
					argStrs.add("int[]");
					argsTypeStr += ",int[]";
				} else if (argType.getElementType().isBool()) {
					argStrs.add("bool[]");
					argsTypeStr += ",bool[]";
				} else {
					throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Unknown array type");
				}
			} else {
				throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Unknown argument type");
			}
		}
		
		String returnTypeStr = "";
		String paramTypeStr = "";
		
		if(funcType.getReturnType().isInt()) {
			returnTypeStr = "int";
		} else if(funcType.getReturnType().isBool()) {
			returnTypeStr = "Bool";
		}
		
		for(int i = 0; i < paramTypes.size(); i++) {
			if (paramTypes.get(i).isInt()) {
				paramStrs.add("int");
				paramTypeStr += ",int";
			} else if(paramTypes.get(i).isBool()) {
				paramStrs.add("bool");
				paramTypeStr += ",bool";
			} else if(paramTypes.get(i).isArray()) {
				if (paramTypes.get(i).getElementType().isInt()) {
					paramStrs.add("int[]");
					paramTypeStr += ",int[]";
				} else if (paramTypes.get(i).getElementType().isBool()) {
					paramStrs.add("bool[]");
					paramTypeStr += ",bool[]";
				} else {
					throw new Exception("Compile error at " + pos.path() + "\nline:" + pos.line() + "\nError: Unknown array type");
				}
			}
		}
		
		if(paramTypes.size() < argStrs.size()) {
			throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: Too many arguments to function " + id.name() + "(" + paramTypeStr.replaceFirst(",", "") + "):" + returnTypeStr);
		} else if(paramTypes.size() > argStrs.size()) {
			throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: Too few arguments to function " + id.name() + "("+ paramTypeStr.replaceFirst(",", "") + "):" + returnTypeStr);
		}
		
		for(int i = 0; i < argStrs.size(); i++) {
			if (argStrs.get(i) != paramStrs.get(i)) {
				throw new Exception("Compile error at " + pos.path() + "line:" + pos.line() + "\nError: Can't pass type ("+ argsTypeStr.replaceFirst(",", "") + ") to function " + id.name() + "("+ paramTypeStr.replaceFirst(",", "") + "):" + returnTypeStr);
			}
		}
		
		
		this.type = funcType.getReturnType();
		return this.type;
	}

	@Override
	public IRExpr translate() {
		// TODO Auto-generated method stub
		return null;
	}



}
