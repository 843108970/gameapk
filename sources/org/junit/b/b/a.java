package org.junit.b.b;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Throwable;
import org.a.g;
import org.a.i;
import org.a.k;
import org.a.p;

public final class a<T extends Throwable> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    private final k<T> f4461a;

    private a(k<T> kVar) {
        this.f4461a = kVar;
    }

    @i
    public static <T extends Throwable> k<T> a(k<T> kVar) {
        return new a(kVar);
    }

    private void a(T t, g gVar) {
        this.f4461a.a(t, gVar);
        gVar.a("\nStacktrace was: ");
        StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter));
        gVar.a(stringWriter.toString());
    }

    private boolean a(T t) {
        return this.f4461a.a(t);
    }

    private static String b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @i
    public static <T extends Exception> k<T> b(k<T> kVar) {
        return new a(kVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void b(Object obj, g gVar) {
        Throwable th = (Throwable) obj;
        this.f4461a.a(th, gVar);
        gVar.a("\nStacktrace was: ");
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        gVar.a(stringWriter.toString());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean b(Object obj) {
        return this.f4461a.a((Throwable) obj);
    }

    public final void describeTo(g gVar) {
        this.f4461a.describeTo(gVar);
    }
}
