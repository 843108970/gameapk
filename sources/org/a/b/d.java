package org.a.b;

import java.util.Iterator;
import org.a.m;

public final class d<T> implements Iterator<m> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<T> f4266a;

    public d(Iterator<T> it) {
        this.f4266a = it;
    }

    private m a() {
        return new c(this.f4266a.next());
    }

    public final boolean hasNext() {
        return this.f4266a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return new c(this.f4266a.next());
    }

    public final void remove() {
        this.f4266a.remove();
    }
}
