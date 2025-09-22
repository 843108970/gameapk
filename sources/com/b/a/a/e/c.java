package com.b.a.a.e;

import com.b.b.i;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final i f666a = i.a(":");

    /* renamed from: b  reason: collision with root package name */
    public static final i f667b = i.a(":status");

    /* renamed from: c  reason: collision with root package name */
    public static final i f668c = i.a(":method");
    public static final i d = i.a(":path");
    public static final i e = i.a(":scheme");
    public static final i f = i.a(":authority");
    public final i g;
    public final i h;
    final int i;

    public c(i iVar, i iVar2) {
        this.g = iVar;
        this.h = iVar2;
        this.i = iVar.g() + 32 + iVar2.g();
    }

    public c(i iVar, String str) {
        this(iVar, i.a(str));
    }

    public c(String str, String str2) {
        this(i.a(str), i.a(str2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.g.equals(cVar.g) && this.h.equals(cVar.h);
        }
    }

    public final int hashCode() {
        return ((this.g.hashCode() + 527) * 31) + this.h.hashCode();
    }

    public final String toString() {
        return com.b.a.a.c.a("%s: %s", this.g.a(), this.h.a());
    }
}
