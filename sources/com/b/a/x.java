package com.b.a;

import com.b.a.a.c;
import com.b.b.f;
import com.b.b.g;
import java.util.List;

public final class x extends aq {

    /* renamed from: a  reason: collision with root package name */
    private static final ah f836a = ah.a("application/x-www-form-urlencoded");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f837b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f838c;

    x(List<String> list, List<String> list2) {
        this.f837b = c.a(list);
        this.f838c = c.a(list2);
    }

    private long a(g gVar, boolean z) {
        f fVar = z ? new f() : gVar.c();
        int size = this.f837b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                fVar.h(38);
            }
            fVar.b(this.f837b.get(i));
            fVar.h(61);
            fVar.b(this.f838c.get(i));
        }
        if (!z) {
            return 0;
        }
        long b2 = fVar.b();
        fVar.o();
        return b2;
    }

    public final ah a() {
        return f836a;
    }

    public final void a(g gVar) {
        a(gVar, false);
    }

    public final long b() {
        return a((g) null, true);
    }
}
