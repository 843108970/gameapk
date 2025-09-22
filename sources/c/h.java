package c;

import java.io.IOException;

public abstract class h implements x {

    /* renamed from: a  reason: collision with root package name */
    private final x f393a;

    public h(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f393a = xVar;
    }

    private x a() {
        return this.f393a;
    }

    public void a(c cVar, long j) throws IOException {
        this.f393a.a(cVar, j);
    }

    public void close() throws IOException {
        this.f393a.close();
    }

    public void flush() throws IOException {
        this.f393a.flush();
    }

    public z timeout() {
        return this.f393a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f393a.toString() + ")";
    }
}
