package th.ac.cmu.cpe.cpe406.types;

import java.util.List;

public class FunctionType_c extends Type_c implements FunctionType {
	protected List<Type> paramTypes;
	protected Type returnType;
	public FunctionType_c(List<Type> paramTypes, Type returnType) {
		this.paramTypes = paramTypes;
		this.returnType = returnType;
	}
	
	@Override
	public boolean isFunction() {
		return true;
	}

	@Override
	public List<Type> getParamTypes() {
		return this.paramTypes;
	}

	@Override
	public Type getReturnType() {
		return this.returnType;
	}
}
