package th.ac.cmu.cpe.cpe406.types;

import java.util.List;

public interface Type {
	boolean isInt();
	boolean isBool();
	boolean isUnit();
	boolean isFunction();
	List<Type> getParamTypes();
	Type getReturnType();
	boolean isArray();
	Type getElementType();

}
