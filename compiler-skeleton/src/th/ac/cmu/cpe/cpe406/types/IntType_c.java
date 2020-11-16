package th.ac.cmu.cpe.cpe406.types;

public class IntType_c extends Type_c implements IntType{
	
	@Override
	public boolean isInt() {
		return true;
	}

	@Override
	public boolean isBool() {
		return false;
	}
}
