package th.ac.cmu.cpe.cpe406.util;

/**
 * A {@code ErrorQueue} handles outputting error messages.
 */
public interface ErrorQueue {
    public void enqueue(int type, String message);

    public void enqueue(int type, String message, Position position);

    public void enqueue(ErrorInfo e);

    public void flush();

    public boolean hasErrors();

    public int errorCount();
}
