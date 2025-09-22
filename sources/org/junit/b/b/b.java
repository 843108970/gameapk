package org.junit.b.b;

import java.lang.Throwable;
import org.a.g;
import org.a.i;
import org.a.k;
import org.a.m;
import org.a.p;

public final class b<T extends Throwable> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    private final k<? extends Throwable> f4462a;

    private b(k<? extends Throwable> kVar) {
        this.f4462a = kVar;
    }

    @i
    public static <T extends Throwable> k<T> a(k<? extends Throwable> kVar) {
        return new b(kVar);
    }

    private void a(T t, g gVar) {
        gVar.a("cause ");
        this.f4462a.a(t.getCause(), gVar);
    }

    private boolean a(T t) {
        return this.f4462a.a(t.getCause());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void b(Object obj, g gVar) {
        gVar.a("cause ");
        this.f4462a.a(((Throwable) obj).getCause(), gVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean b(Object obj) {
        return this.f4462a.a(((Throwable) obj).getCause());
    }

    public final void describeTo(g gVar) {
        gVar.a("exception with cause ");
        gVar.a((m) this.f4462a);
    }
}
