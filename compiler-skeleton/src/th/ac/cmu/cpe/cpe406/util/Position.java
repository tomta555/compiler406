package th.ac.cmu.cpe.cpe406.util;

import java.io.Serializable;

/**
 * This class represents a position within a source file. It is used to record
 * where each AST node is located in a source file; this is used, for
 * example, for generating error messages.
 **/
public class Position implements Serializable {
    static final long serialVersionUID = SerialVersionUID.generate();

    private String path;
    private String file;
    private String info;

    private int line;
    private int column;

    private int endLine;
    private int endColumn;

    private boolean compilerGenerated = false;

    // Position in characters from the beginning of the containing character
    // stream
    private int offset;
    private int endOffset;

    public static final int UNKNOWN = -1;
    public static final int END_UNUSED = -2;
    public static final Position COMPILER_GENERATED =
            new Position("Compiler Generated", true);

    public static final int THIS_METHOD = 1;
    public static final int CALLER = THIS_METHOD + 1;

    public void setInfo(String info) {
        this.info = info;
    }

    /** Get a compiler generated position. */
    public boolean isCompilerGenerated() {
        return compilerGenerated;
    }

    /** For deserialization. */
    protected Position() {
        line = endLine = 0;
        column = endColumn = 0;
        offset = endOffset = 0;
    }

    public Position(String desc, boolean compilerGenerated) {
        this(null, desc, UNKNOWN, UNKNOWN);
        this.compilerGenerated = compilerGenerated;
    }

    public Position(String desc, int line, boolean compilerGenerated) {
        this(null, desc, line, UNKNOWN);
        this.compilerGenerated = compilerGenerated;
    }

    public Position(String path, String file) {
        this(path, file, UNKNOWN, UNKNOWN);
    }

    public Position(String path, String file, int line) {
        this(path, file, line, UNKNOWN);
    }

    public Position(String path, String file, int line, int column) {
        this(path, file, line, column, END_UNUSED, END_UNUSED);
    }

    public Position(String path, String file, int line, int column, int endLine,
            int endColumn) {
        this(path, file, line, column, endLine, endColumn, 0, 0);
    }

    public Position(String path, String file, int line, int column, int endLine,
            int endColumn, int offset, int endOffset) {
        this.file = file;
        this.path = path;
        this.line = line;
        this.column = column;
        this.endLine = endLine;
        this.endColumn = endColumn;
        this.offset = offset;
        this.endOffset = endOffset;
    }

    public Position(Position start, Position end) {
        this(start.path(),
             start.file(),
             start.line,
             start.column,
             end == null ? start.endLine : end.endLine,
             end == null ? start.endColumn : end.endColumn,
             start.offset,
             end == null ? start.endOffset : end.endOffset);
    }

    public Position truncateEnd(int len) {
        if (this == COMPILER_GENERATED) return this;

        int eo = endOffset;
        int el = endLine;
        int ec = endColumn;

        if (eo >= offset + len)
            eo -= len;
        else eo = offset;

        if (line == el) {
            if (ec >= column + len)
                ec -= len;
            else ec = column;
        }
        else if (ec >= len)
            ec -= len;
        else {
            el = line;
            ec = column;
        }

        return new Position(path, file, line, column, el, ec, offset, eo);
    }

    public Position startOf() {
        if (this == COMPILER_GENERATED) return this;
        return new Position(path,
                            file,
                            line,
                            column,
                            line,
                            column,
                            offset,
                            offset);
    }

    public Position endOf() {
        if (this == COMPILER_GENERATED) return this;
        return new Position(path,
                            file,
                            endLine,
                            endColumn,
                            endLine,
                            endColumn,
                            endOffset,
                            endOffset);
    }

    public int line() {
        return line;
    }

    public int column() {
        return column;
    }

    public int endLine() {
        if (endLine == UNKNOWN || line != UNKNOWN && endLine < line)
            return line;
        return endLine;
    }

    public int endColumn() {
        if (endColumn == UNKNOWN || column != UNKNOWN && endLine() == line()
                && endColumn < column)
            return column;
        return endColumn;
    }

    public int offset() {
        return offset;
    }

    public int endOffset() {
        if (endOffset == UNKNOWN || offset != UNKNOWN && endOffset < offset)
            return offset;
        return endOffset;
    }

    public String file() {
        return file;
    }

    public String path() {
        return path;
    }

    public String nameAndLineString() {
        // Maybe we should use path here, if it isn't too long...
        String s = path;

        if (s == null || s.length() == 0) s = file;

        if (s == null) s = "unknown file";

        if (line != UNKNOWN) {
            s += ":" + line;
            if (endLine != line && endLine != UNKNOWN && endLine != END_UNUSED)
                s += "-" + endLine;
        }

        if (info != null) s += " (" + info + ")";

        return s;
    }

    @Override
    public String toString() {
        String s = path;

        if (s == null) s = file;

        if (s == null) s = "unknown file";

        if (line != UNKNOWN) {
            s += ":" + line;

            if (column != UNKNOWN) {
                s += "," + column;
                if (line == endLine && endColumn != UNKNOWN
                        && endColumn != END_UNUSED)
                    s += "-" + endColumn;
                if (line != endLine && endColumn != UNKNOWN
                        && endColumn != END_UNUSED)
                    s += "-" + endLine + "," + endColumn;
            }
        }

        if (info != null) s += " (" + info + ")";

        return s;
    }

    /**
     * Check if 2 positions are comparable.
     * Any 2 positions are comparable if they belong in the same file and represent
     * valid positions in the respective files.
     */
    private static boolean isComparable(Position pos1, Position pos2) {
        if (pos1 == null || pos2 == null) return false;

        if (pos1.compilerGenerated || pos2.compilerGenerated) return false;

        if (pos1.file == null || pos2.file == null
                || !pos1.file.equals(pos2.file))
            return false;

        if (pos1.path == null || pos2.path == null
                || !pos1.path.equals(pos2.path))
            return false;

        if (pos1.line == UNKNOWN || pos2.line == UNKNOWN) return false;

        if (pos1.column == UNKNOWN || pos2.column == UNKNOWN) return false;

        if (pos1.endLine == UNKNOWN || pos2.endLine == UNKNOWN) return false;

        if (pos1.endColumn == UNKNOWN || pos2.endColumn == UNKNOWN)
            return false;

        return true;
    }

    /**
     * Returns the first of the given 2 positions i.e. if pos1 starts before pos2, then first(pos1, pos2) = pos1.
     * Returns null if the given 2 positions are not comparable.
     */
    public static Position first(Position pos1, Position pos2) {
        if (!isComparable(pos1, pos2)) return null;

        if (pos1.line < pos2.line) return pos1;

        if (pos1.line == pos2.line && pos1.column <= pos2.column) return pos1;

        return pos2;
    }

    /**
     * Returns the last of the given 2 positions i.e. if pos1 ends after pos2, then last(pos1, pos2) = pos1.
     * Returns null if the given 2 positions are not comparable.
     */
    public static Position last(Position pos1, Position pos2) {
        if (!isComparable(pos1, pos2)) return null;

        if (pos1.endLine > pos2.endLine) return pos1;

        if (pos1.endLine == pos2.endLine && pos1.endColumn >= pos2.endColumn)
            return pos1;

        return pos2;
    }
}
