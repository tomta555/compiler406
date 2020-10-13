package th.ac.cmu.cpe.cpe406.ast;

import th.ac.cmu.cpe.cpe406.util.Copy;
import th.ac.cmu.cpe.cpe406.util.Position;

public interface Node extends Copy<Node> {

    Position position();
}
