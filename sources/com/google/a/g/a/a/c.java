package com.google.a.g.a.a;

import java.util.ArrayList;
import java.util.List;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final List<b> f3179a;

    /* renamed from: b  reason: collision with root package name */
    final int f3180b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3181c = false;

    c(List<b> list, int i) {
        this.f3179a = new ArrayList(list);
        this.f3180b = i;
    }

    private List<b> a() {
        return this.f3179a;
    }

    private int b() {
        return this.f3180b;
    }

    private boolean c() {
        return this.f3181c;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(List<b> list) {
        return this.f3179a.equals(list);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3179a.equals(cVar.f3179a) && this.f3181c == cVar.f3181c;
    }

    public final int hashCode() {
        return this.f3179a.hashCode() ^ Boolean.valueOf(this.f3181c).hashCode();
    }

    public final String toString() {
        return "{ " + this.f3179a + " }";
    }
}
