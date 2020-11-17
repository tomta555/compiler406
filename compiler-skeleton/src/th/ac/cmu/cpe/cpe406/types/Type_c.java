package th.ac.cmu.cpe.cpe406.types;

import java.util.List;

public abstract class Type_c implements Type {
	protected int size;
	
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
	public boolean isArray() {
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
	
	@Override
	public Type getElementType() {
		return null;
	}
	
	@Override
	public int size() {
		return -1;
	}
	
	@Override
	public void addSize(int size) {
		this.size = size;
	}

}
