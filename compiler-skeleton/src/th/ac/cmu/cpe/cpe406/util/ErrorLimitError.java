package th.ac.cmu.cpe.cpe406.util;

/** Exception thrown when the number of errors exceeds a limit. */
public class ErrorLimitError extends RuntimeException {
    private static final long serialVersionUID = SerialVersionUID.generate();

    public ErrorLimitError(String msg) {
        super(msg);
    }

    public ErrorLimitError() {
        super();
    }
}
