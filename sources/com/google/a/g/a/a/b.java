package com.google.a.g.a.a;

import com.google.a.g.a.c;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final com.google.a.g.a.b f3176a;

    /* renamed from: b  reason: collision with root package name */
    final com.google.a.g.a.b f3177b;

    /* renamed from: c  reason: collision with root package name */
    final c f3178c;
    private final boolean d = true;

    b(com.google.a.g.a.b bVar, com.google.a.g.a.b bVar2, c cVar) {
        this.f3176a = bVar;
        this.f3177b = bVar2;
        this.f3178c = cVar;
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    private boolean a() {
        return this.d;
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private com.google.a.g.a.b b() {
        return this.f3176a;
    }

    private com.google.a.g.a.b c() {
        return this.f3177b;
    }

    private c d() {
        return this.f3178c;
    }

    private boolean e() {
        return this.f3177b == null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f3176a, bVar.f3176a) && a(this.f3177b, bVar.f3177b) && a(this.f3178c, bVar.f3178c);
    }

    public final int hashCode() {
        return (a(this.f3176a) ^ a(this.f3177b)) ^ a(this.f3178c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f3176a);
        sb.append(" , ");
        sb.append(this.f3177b);
        sb.append(" : ");
        sb.append(this.f3178c == null ? "null" : Integer.valueOf(this.f3178c.f3184a));
        sb.append(" ]");
        return sb.toString();
    }
}
