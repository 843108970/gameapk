package org.a;

public abstract class e<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f4270a;

    private e(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Description should be non null!");
        }
        this.f4270a = str;
    }

    public final void describeTo(g gVar) {
        gVar.a(this.f4270a);
    }
}
