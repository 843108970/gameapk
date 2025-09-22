package org.junit.runner.b;

import org.junit.runner.b.b;
import org.junit.runner.c;
import org.junit.runner.i;

@b.a
final class e extends b {

    /* renamed from: a  reason: collision with root package name */
    private final b f4630a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f4631b;

    e(b bVar, Object obj) {
        this.f4630a = bVar;
        this.f4631b = obj;
    }

    public final void a(a aVar) throws Exception {
        synchronized (this.f4631b) {
            this.f4630a.a(aVar);
        }
    }

    public final void a(c cVar) throws Exception {
        synchronized (this.f4631b) {
            this.f4630a.a(cVar);
        }
    }

    public final void a(i iVar) throws Exception {
        synchronized (this.f4631b) {
            this.f4630a.a(iVar);
        }
    }

    public final void b(a aVar) {
        synchronized (this.f4631b) {
            this.f4630a.b(aVar);
        }
    }

    public final void b(c cVar) throws Exception {
        synchronized (this.f4631b) {
            this.f4630a.b(cVar);
        }
    }

    public final void c(c cVar) throws Exception {
        synchronized (this.f4631b) {
            this.f4630a.c(cVar);
        }
    }

    public final void d(c cVar) throws Exception {
        synchronized (this.f4631b) {
            this.f4630a.d(cVar);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return this.f4630a.equals(((e) obj).f4630a);
    }

    public final int hashCode() {
        return this.f4630a.hashCode();
    }

    public final String toString() {
        return this.f4630a.toString() + " (with synchronization wrapper)";
    }
}
