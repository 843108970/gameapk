package b.a.f;

import c.f;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final f f104a = f.encodeUtf8(":");

    /* renamed from: b  reason: collision with root package name */
    public static final f f105b = f.encodeUtf8(":status");

    /* renamed from: c  reason: collision with root package name */
    public static final f f106c = f.encodeUtf8(":method");
    public static final f d = f.encodeUtf8(":path");
    public static final f e = f.encodeUtf8(":scheme");
    public static final f f = f.encodeUtf8(":authority");
    public final f g;
    public final f h;
    final int i;

    public c(f fVar, f fVar2) {
        this.g = fVar;
        this.h = fVar2;
        this.i = fVar.size() + 32 + fVar2.size();
    }

    public c(f fVar, String str) {
        this(fVar, f.encodeUtf8(str));
    }

    public c(String str, String str2) {
        this(f.encodeUtf8(str), f.encodeUtf8(str2));
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
        return b.a.c.a("%s: %s", this.g.utf8(), this.h.utf8());
    }
}
