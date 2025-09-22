package junit.b;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    protected i f4033a;

    /* renamed from: b  reason: collision with root package name */
    protected Throwable f4034b;

    public k(i iVar, Throwable th) {
        this.f4033a = iVar;
        this.f4034b = th;
    }

    private Throwable c() {
        return this.f4034b;
    }

    private String d() {
        return this.f4034b.getMessage();
    }

    private boolean e() {
        return this.f4034b instanceof b;
    }

    public final i a() {
        return this.f4033a;
    }

    public final String b() {
        StringWriter stringWriter = new StringWriter();
        this.f4034b.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public final String toString() {
        return this.f4033a + ": " + this.f4034b.getMessage();
    }
}
