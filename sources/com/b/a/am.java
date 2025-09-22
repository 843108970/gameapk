package com.b.a;

import com.b.a.a.b.g;
import com.b.a.a.c.a;
import com.b.a.a.c.b;
import com.b.a.a.c.c;
import com.b.a.a.c.k;
import com.b.a.a.g.h;
import java.io.IOException;
import java.util.ArrayList;

final class am implements g {

    /* renamed from: a  reason: collision with root package name */
    final ai f770a;

    /* renamed from: b  reason: collision with root package name */
    final k f771b;

    /* renamed from: c  reason: collision with root package name */
    final ao f772c;
    final boolean d;
    private boolean e;

    am(ai aiVar, ao aoVar, boolean z) {
        this.f770a = aiVar;
        this.f772c = aoVar;
        this.d = z;
        this.f771b = new k(aiVar, z);
    }

    private void d() {
        this.f771b.a(h.b().a("response.body().close()"));
    }

    public final as a() {
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        d();
        try {
            this.f770a.f763c.a(this);
            as c2 = c();
            if (c2 != null) {
                return c2;
            }
            throw new IOException("Canceled");
        } finally {
            this.f770a.f763c.b(this);
        }
    }

    public final void a(h hVar) {
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        d();
        this.f770a.f763c.a(new an(this, hVar));
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        ad d2 = this.f772c.f775a.d("/...");
        d2.f753b = ac.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        d2.f754c = ac.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return d2.b().toString();
    }

    /* access modifiers changed from: package-private */
    public final as c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f770a.g);
        arrayList.add(this.f771b);
        arrayList.add(new a(this.f770a.j));
        ai aiVar = this.f770a;
        arrayList.add(new com.b.a.a.a.a(aiVar.k != null ? aiVar.k.f800a : aiVar.l));
        arrayList.add(new com.b.a.a.b.a(this.f770a));
        if (!this.d) {
            arrayList.addAll(this.f770a.h);
        }
        arrayList.add(new b(this.d));
        return new com.b.a.a.c.h(arrayList, (g) null, (c) null, (m) null, 0, this.f772c).a(this.f772c);
    }

    public final /* synthetic */ Object clone() {
        return new am(this.f770a, this.f772c, this.d);
    }
}
