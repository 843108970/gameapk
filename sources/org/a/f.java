package org.a;

public abstract class f<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f4271a;

    private f(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Description must be non null!");
        }
        this.f4271a = str;
    }

    public final void describeTo(g gVar) {
        gVar.a(this.f4271a);
    }
}
