package th.ac.cmu.cpe.cpe406.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public class CPE406ErrorQueue extends StdErrorQueue {
    protected PrintWriter typedpw;
    protected boolean errorReported;

    public CPE406ErrorQueue(PrintStream err, int limit, String name,
            PrintWriter typedpw) {
        super(err, limit, name);
        this.typedpw = typedpw;
    }

    @Override
    public void displayError(ErrorInfo e) {
        if (!errorReported) {
            String message = e.getErrorKind() != ErrorInfo.DEBUG
                    ? e.getMessage()
                    : e.getErrorString() + " -- " + e.getMessage();

            Position position = e.getPosition();

            if (typedpw != null) {
                typedpw.write(position.line() + ":" + position.column()
                        + " error:" + message);
            }

            errorReported = true;
        }

        super.displayError(e);
    }
}
