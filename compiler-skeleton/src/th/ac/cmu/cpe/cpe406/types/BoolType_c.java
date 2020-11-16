package th.ac.cmu.cpe.cpe406.types;

public class BoolType_c extends Type_c implements BoolType {

	@Override
	public boolean isInt() {
		return false;
	}

	@Override
	public boolean isBool() {
		return true;
	}

}
