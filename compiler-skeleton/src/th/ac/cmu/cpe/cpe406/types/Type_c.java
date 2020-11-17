package th.ac.cmu.cpe.cpe406.types;

import java.util.List;

public abstract class Type_c implements Type {
	
	@Override
	public boolean isInt() {
		return false;
	}
	
	@Override
	public boolean isBool() {
		return false;
	}
	
	@Override
	public boolean isUnit() {
		return false;
	}
	
	@Override
	public boolean isFunction() {
		return false;
	}
	
	@Override
	public List<Type> getParamTypes(){
		return null;
	}
	
	@Override
	public Type getReturnType() {
		return null;	
	}
}
