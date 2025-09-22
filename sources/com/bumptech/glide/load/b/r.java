package com.bumptech.glide.load.b;

import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final Map<g, k<?>> f1170a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<g, k<?>> f1171b = new HashMap();

    r() {
    }

    private k<?> a(g gVar, boolean z) {
        return a(z).get(gVar);
    }

    @VisibleForTesting
    private Map<g, k<?>> a() {
        return Collections.unmodifiableMap(this.f1170a);
    }

    private void b(g gVar, k<?> kVar) {
        a(kVar.i).put(gVar, kVar);
    }

    public final Map<g, k<?>> a(boolean z) {
        return z ? this.f1171b : this.f1170a;
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar, k<?> kVar) {
        Map<g, k<?>> a2 = a(kVar.i);
        if (kVar.equals(a2.get(gVar))) {
            a2.remove(gVar);
        }
    }
}
