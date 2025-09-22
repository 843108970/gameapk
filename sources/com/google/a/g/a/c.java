package com.google.a.g.a;

import com.google.a.t;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f3184a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f3185b;

    /* renamed from: c  reason: collision with root package name */
    public final t[] f3186c;

    public c(int i, int[] iArr, int i2, int i3, int i4) {
        this.f3184a = i;
        this.f3185b = iArr;
        float f = (float) i4;
        this.f3186c = new t[]{new t((float) i2, f), new t((float) i3, f)};
    }

    private int a() {
        return this.f3184a;
    }

    private int[] b() {
        return this.f3185b;
    }

    private t[] c() {
        return this.f3186c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && this.f3184a == ((c) obj).f3184a;
    }

    public final int hashCode() {
        return this.f3184a;
    }
}
