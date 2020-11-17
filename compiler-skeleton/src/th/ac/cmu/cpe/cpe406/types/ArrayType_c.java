package th.ac.cmu.cpe.cpe406.types;

public class ArrayType_c extends Type_c implements ArrayType {
	
	protected Type type;
	protected int size;
	
	public ArrayType_c(Type type, int size) {
		this.type = type; 
		this.size = size;
	}
	
	@Override
	public boolean isArray() {
		return true;
	}

	@Override
	public Type getElementType() {
		return this.type;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public void addSize(int size) {
		this.size = size;
	}
}
