package th.ac.cmu.cpe.cpe406.types;

import java.util.HashMap;
import java.util.Map;

public class SymTable_c implements SymTable {
	
	Map<String, Type> table = new HashMap<>();
	
	@Override
	public Type lookup(String name) {
		if (table.containsKey(name)) return table.get(name);
		else return null;
	}

	@Override
	public void add(String name, Type type) {
		table.put(name, type);
	}

}
