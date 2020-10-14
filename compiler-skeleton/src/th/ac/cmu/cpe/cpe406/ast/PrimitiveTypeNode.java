package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.InternalCompilerError;

public interface PrimitiveTypeNode extends TypeNode {
    public enum Kind {
        INT, BOOL;
    	
        @Override
        public String toString() {
            switch (this) {
            case INT:
                return "int";
            case BOOL:
            	return "boolean";
            }
            throw new InternalCompilerError("Unknown primitive type");
        }
    }
}
