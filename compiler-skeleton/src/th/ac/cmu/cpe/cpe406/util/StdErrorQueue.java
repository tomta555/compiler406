package th.ac.cmu.cpe.cpe406.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.StringTokenizer;

/**
 * A {@code StdErrorQueue} handles outputting error messages.
 */
public class StdErrorQueue extends AbstractErrorQueue {
    private PrintStream err;

    public StdErrorQueue(PrintStream err, int limit, String name) {
        super(limit, name);
        this.err = err;
    }

    @Override
    public void displayError(ErrorInfo e) {
        String message = e.getErrorKind() != ErrorInfo.DEBUG
                ? e.getMessage() : e.getErrorString() + " -- " + e.getMessage();

        Position position = e.getPosition();

        String prefix = position != null ? position.nameAndLineString() : name;

        if (prefix == null) prefix = "jlc";

        /*

        // This doesn't work: it breaks the error message into one word
        // per line.

        CodeWriter w = new CodeWriter(err, 78);

        w.begin(0);
        w.write(prefix + ":");
        w.write(" ");

        StringTokenizer st = new StringTokenizer(message, " ");

        while (st.hasMoreTokens()) {
        String s = st.nextToken();
            w.write(s);
            if (st.hasMoreTokens()) {
                w.allowBreak(0, " ");
            }
        }

        w.end();
        w.newline(0);

        try {
            w.flush();
        }
        catch (IOException ex) {
        }
        */

        // I (Nate) tried without success to get CodeWriter to do this.
        // It would be nice if we could specify where breaks are allowed
        // when generating the error.  We don't want to break Jif labels,
        // for instance.

        int lmargin = 4;
        int rmargin = 78;

        StringBuffer sb = new StringBuffer(prefix + ": ");
        sb.ensureCapacity(rmargin);
        int width = 0;
        width += prefix.length() + 2;

        StringTokenizer lines = new StringTokenizer(message, "\n", true);
        boolean needNewline = false;
        boolean isPostCompilerError =
                e.getErrorKind() == ErrorInfo.POST_COMPILER_ERROR;
        boolean lineHasContent = prefix.length() > 0;

        while (lines.hasMoreTokens()) {
            String line = lines.nextToken();

            if (line.charAt(0) != '\n') {
                if (isPostCompilerError) {
                    // Post-compiler errors are probably formatted already,
                    // so print the message as is, but indent on new lines.
                    sb.append(line);
                    lineHasContent = true;
                }
                else {
                    StringTokenizer st = new StringTokenizer(line, " ", true);

                    while (st.hasMoreTokens()) {
                        String s = st.nextToken();

                        if (width + s.length() + 1 > rmargin) {
                            if (lineHasContent) {
                                err.println(sb.toString());
                                lineHasContent = false;
                            }
                            for (int i = 0; i < lmargin; i++)
                                sb.setCharAt(i, ' ');
                            sb.setLength(lmargin);
                            width = lmargin;
                        }

                        if (s.charAt(0) != ' ') lineHasContent = true;

                        sb.append(s);
                        width += s.length();
                    }
                }

                needNewline = true;
            }
            else {
                err.print(line);
                needNewline = false;
            }

            if (lines.hasMoreTokens()) {
                if (lineHasContent) {
                    err.print(sb.toString());
                    lineHasContent = false;
                }
                for (int i = 0; i < lmargin; i++)
                    sb.setCharAt(i, ' ');
                sb.setLength(lmargin);
                width = lmargin;
            }
            else if (needNewline) err.println(sb.toString());
        }

        if (position != null) showError(position);
    }

    @Override
    protected void tooManyErrors(ErrorInfo lastError) {
        Position position = lastError.getPosition();
        String prefix = position != null ? position.file() + ": " : "";
        err.println(prefix + "Too many errors.  Aborting compilation.");
    }

    protected Reader reader(Position pos) throws IOException {
        if (pos.path() != null && pos.line() != Position.UNKNOWN)
            return new FileReader(pos.path());
        return null;
    }

    private void showError(Position pos) {
        try (Reader r = reader(pos)) {
            if (r == null) return;

            try (LineNumberReader reader = new LineNumberReader(r)) {

                String s = reader.readLine();
                while (s != null && reader.getLineNumber() < pos.line())
                    s = reader.readLine();

                if (s != null) {
                    err.println(s);
                    showErrorIndicator(pos, reader.getLineNumber(), s);

                    if (pos.endLine() != pos.line()
                            && pos.endLine() != Position.UNKNOWN
                            && pos.endLine() != Position.END_UNUSED) {

                        // if there is more than two lines,
                        // print some ellipsis.
                        if (pos.endLine() - pos.line() > 1) {
                            // add some whitespace first
                            for (int j = 0; j < s.length()
                                    && Character.isWhitespace(s.charAt(j)); j++)
                                err.print(s.charAt(j));
                            err.println("...");
                        }

                        while (reader.getLineNumber() < pos.endLine())
                            s = reader.readLine();

                        // s is now the last line of the error.
                        if (s != null) {
                            err.println(s);
                            showErrorIndicator(pos, reader.getLineNumber(), s);
                        }
                    }
                }
            }

            err.println();
        }
        catch (IOException e) {
        }
    }

    protected void showErrorIndicator(Position pos, int lineNum, String s) {
        if (pos.column() == Position.UNKNOWN) return;

        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i)))
            err.print(s.charAt(i++));

        int startIndAt = i; // column position to start showing the indicator marks
        int stopIndAt = s.length() - 1; // column position to stop showing the indicator marks
        if (pos.line() == lineNum) startIndAt = pos.column() - 1;
        if (pos.endLine() == lineNum) stopIndAt = pos.endColumn() - 2;
        if (stopIndAt < startIndAt) stopIndAt = startIndAt;
        if (pos.endColumn() == Position.UNKNOWN
                || pos.endColumn() == Position.END_UNUSED)
            stopIndAt = startIndAt;

        for (; i <= stopIndAt; i++) {
            char c = '-';
            if (i < startIndAt) c = ' ';
            if (i < s.length() && s.charAt(i) == '\t') c = '\t';
            if (i == startIndAt && pos.line() == lineNum) c = '^';
            if (i == stopIndAt && pos.endLine() == lineNum) c = '^';

            err.print(c);
        }

        err.println();
    }

    @Override
    public void flush() {
        if (!flushed) if (errorCount() > 0) err.println(errorCount() + " error"
                + (errorCount() > 1 ? "s." : "."));
        super.flush();
    }
}
