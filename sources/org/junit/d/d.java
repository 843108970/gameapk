package org.junit.d;

import java.util.ArrayList;
import java.util.List;
import org.a.a.a;
import org.a.k;

final class d {

    /* renamed from: a  reason: collision with root package name */
    final List<k<?>> f4538a = new ArrayList();

    d() {
    }

    private void a(k<?> kVar) {
        this.f4538a.add(kVar);
    }

    private static k<Throwable> b(k<?> kVar) {
        return kVar;
    }

    private boolean b() {
        return !this.f4538a.isEmpty();
    }

    private k<Throwable> c() {
        return this.f4538a.size() == 1 ? this.f4538a.get(0) : a.a(new ArrayList(this.f4538a));
    }

    private List<k<? super Throwable>> d() {
        return new ArrayList(this.f4538a);
    }

    /* access modifiers changed from: package-private */
    public final k<Throwable> a() {
        return org.junit.b.b.a.a(this.f4538a.size() == 1 ? this.f4538a.get(0) : a.a(new ArrayList(this.f4538a)));
    }
}
