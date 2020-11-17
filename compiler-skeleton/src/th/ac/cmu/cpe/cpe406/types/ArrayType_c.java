package th.ac.cmu.cpe.cpe406.types;

public class ArrayType_c extends Type_c implements ArrayType {
	
	protected Type type;
	
	public ArrayType_c(Type type) {
		this.type = type; 
	}
	
	@Override
	public boolean isArray() {
		return true;
	}

	@Override
	public Type getElementType() {
		return this.type;
	}
}
