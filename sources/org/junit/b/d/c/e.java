package org.junit.b.d.c;

import java.util.ArrayList;
import java.util.List;
import org.junit.e.a.d;
import org.junit.e.a.f;
import org.junit.e.a.j;

public final class e extends j {

    /* renamed from: a  reason: collision with root package name */
    private final j f4498a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f4499b;

    /* renamed from: c  reason: collision with root package name */
    private final List<d> f4500c;

    public e(j jVar, List<d> list, Object obj) {
        this.f4498a = jVar;
        this.f4500c = list;
        this.f4499b = obj;
    }

    public final void a() throws Throwable {
        ArrayList arrayList = new ArrayList();
        try {
            this.f4498a.a();
            for (d a2 : this.f4500c) {
                try {
                    a2.a(this.f4499b, new Object[0]);
                } catch (Throwable th) {
                    arrayList.add(th);
                }
            }
        } catch (Throwable th2) {
            arrayList.add(th2);
        }
        f.assertEmpty(arrayList);
    }
}
