package org.a;

import com.cyjh.common.util.s;
import org.a.b.b;

public abstract class j<T, U> extends o<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final b f4273a = new b("featureValueOf", 1);

    /* renamed from: b  reason: collision with root package name */
    private final k<? super U> f4274b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4275c;
    private final String d;

    private j(k<? super U> kVar, String str, String str2) {
        super(f4273a);
        this.f4274b = kVar;
        this.f4275c = str;
        this.d = str2;
    }

    /* access modifiers changed from: protected */
    public abstract U b();

    /* access modifiers changed from: protected */
    public final boolean b(T t, g gVar) {
        Object b2 = b();
        if (this.f4274b.a(b2)) {
            return true;
        }
        gVar.a(this.d).a(s.a.f1696a);
        this.f4274b.a(b2, gVar);
        return false;
    }

    public final void describeTo(g gVar) {
        gVar.a(this.f4275c).a(s.a.f1696a).a((m) this.f4274b);
    }
}
