package c;

import java.io.IOException;

public abstract class i implements y {
    private final y delegate;

    public i(y yVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = yVar;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final y delegate() {
        return this.delegate;
    }

    public long read(c cVar, long j) throws IOException {
        return this.delegate.read(cVar, j);
    }

    public z timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
