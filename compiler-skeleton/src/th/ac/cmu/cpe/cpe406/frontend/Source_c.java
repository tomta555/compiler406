package th.ac.cmu.cpe.cpe406.frontend;

import java.io.File;
import java.io.IOException;

import th.ac.cmu.cpe.cpe406.util.InternalCompilerError;

public class Source_c implements Source {

    protected File f;
    protected Kind kind;

    public Source_c(File f, Kind kind) {
        this.f = f;
        this.kind = kind;
    }

    @Override
    public boolean userSpecified() {
        return kind == Kind.USER_SPECIFIED;
    }

    @Override
    public boolean compilerGenerated() {
        return kind == Kind.COMPILER_GENERATED;
    }

    @Override
    public void setKind(Kind kind) {
        this.kind = kind;
    }

    @Override
    public Kind kind() {
        return kind;
    }

    @Override
    public String name() {
        return f.getPath();
    }

    @Override
    public String path() {
        try {
            return f.getCanonicalPath();
        }
        catch (IOException e) {
            throw new InternalCompilerError(e);
        }
    }

    @Override
    public String toString() {
        return path();
    }
}
