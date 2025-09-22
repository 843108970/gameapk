package com.b.a.a.b;

import com.b.a.aw;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<aw> f593a = new LinkedHashSet();

    public final synchronized void a(aw awVar) {
        this.f593a.add(awVar);
    }

    public final synchronized void b(aw awVar) {
        this.f593a.remove(awVar);
    }

    public final synchronized boolean c(aw awVar) {
        return this.f593a.contains(awVar);
    }
}
