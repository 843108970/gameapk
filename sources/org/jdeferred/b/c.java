package org.jdeferred.b;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c implements Iterable<f> {

    /* renamed from: a  reason: collision with root package name */
    final List<f> f4409a;

    public c(int i) {
        this.f4409a = new CopyOnWriteArrayList(new f[i]);
    }

    private int a() {
        return this.f4409a.size();
    }

    private f a(int i) {
        return this.f4409a.get(i);
    }

    private void a(int i, f fVar) {
        this.f4409a.set(i, fVar);
    }

    public final Iterator<f> iterator() {
        return this.f4409a.iterator();
    }

    public final String toString() {
        return "MultipleResults [results=" + this.f4409a + "]";
    }
}
