package org.a.b;

import java.lang.reflect.Array;
import java.util.Iterator;

public final class a implements Iterator<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4260a;

    /* renamed from: b  reason: collision with root package name */
    private int f4261b = 0;

    public a(Object obj) {
        if (!obj.getClass().isArray()) {
            throw new IllegalArgumentException("not an array");
        }
        this.f4260a = obj;
    }

    public final boolean hasNext() {
        return this.f4261b < Array.getLength(this.f4260a);
    }

    public final Object next() {
        Object obj = this.f4260a;
        int i = this.f4261b;
        this.f4261b = i + 1;
        return Array.get(obj, i);
    }

    public final void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }
}
