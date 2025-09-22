package org.junit.b.b;

import java.lang.Throwable;
import org.a.g;
import org.a.i;
import org.a.k;
import org.a.m;
import org.a.p;

public final class c<T extends Throwable> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    private final k<String> f4463a;

    private c(k<String> kVar) {
        this.f4463a = kVar;
    }

    @i
    public static <T extends Throwable> k<T> a(k<String> kVar) {
        return new c(kVar);
    }

    private void a(T t, g gVar) {
        gVar.a("message ");
        this.f4463a.a(t.getMessage(), gVar);
    }

    private boolean a(T t) {
        return this.f4463a.a(t.getMessage());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void b(Object obj, g gVar) {
        gVar.a("message ");
        this.f4463a.a(((Throwable) obj).getMessage(), gVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean b(Object obj) {
        return this.f4463a.a(((Throwable) obj).getMessage());
    }

    public final void describeTo(g gVar) {
        gVar.a("exception with message ");
        gVar.a((m) this.f4463a);
    }
}
