package com.google.a.a.c;

import com.google.a.c.a;
import java.util.LinkedList;

final class f {

    /* renamed from: a  reason: collision with root package name */
    static final f f2997a = new f(g.f3000a, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    final int f2998b;

    /* renamed from: c  reason: collision with root package name */
    final int f2999c;
    final int d;
    private final g e;

    private f(g gVar, int i, int i2, int i3) {
        this.e = gVar;
        this.f2998b = i;
        this.f2999c = i2;
        this.d = i3;
    }

    private int a() {
        return this.f2998b;
    }

    private g b() {
        return this.e;
    }

    private int c() {
        return this.f2999c;
    }

    private int d() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final f a(int i) {
        g gVar = this.e;
        int i2 = this.f2998b;
        int i3 = this.d;
        if (this.f2998b == 4 || this.f2998b == 2) {
            int i4 = d.g[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            gVar = gVar.a(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        f fVar = new f(gVar, i2, this.f2999c + 1, i3 + ((this.f2999c == 0 || this.f2999c == 31) ? 18 : this.f2999c == 62 ? 9 : 8));
        return fVar.f2999c == 2078 ? fVar.b(i + 1) : fVar;
    }

    /* access modifiers changed from: package-private */
    public final f a(int i, int i2) {
        int i3 = this.d;
        g gVar = this.e;
        if (i != this.f2998b) {
            int i4 = d.g[this.f2998b][i];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            gVar = gVar.a(i5, i6);
            i3 += i6;
        }
        int i7 = i == 2 ? 4 : 5;
        return new f(gVar.a(i2, i7), i, 0, i3 + i7);
    }

    /* access modifiers changed from: package-private */
    public final a a(byte[] bArr) {
        LinkedList<g> linkedList = new LinkedList<>();
        for (g gVar = b(bArr.length).e; gVar != null; gVar = gVar.f3001b) {
            linkedList.addFirst(gVar);
        }
        a aVar = new a();
        for (g a2 : linkedList) {
            a2.a(aVar, bArr);
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(f fVar) {
        int i = this.d + (d.g[this.f2998b][fVar.f2998b] >> 16);
        if (fVar.f2999c > 0 && (this.f2999c == 0 || this.f2999c > fVar.f2999c)) {
            i += 10;
        }
        return i <= fVar.d;
    }

    /* access modifiers changed from: package-private */
    public final f b(int i) {
        return this.f2999c == 0 ? this : new f(new b(this.e, i - this.f2999c, this.f2999c), this.f2998b, 0, this.d);
    }

    /* access modifiers changed from: package-private */
    public final f b(int i, int i2) {
        g gVar = this.e;
        int i3 = this.f2998b == 2 ? 4 : 5;
        return new f(gVar.a(d.h[this.f2998b][i], i3).a(i2, 5), this.f2998b, 0, this.d + i3 + 5);
    }

    public final String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{d.f2992a[this.f2998b], Integer.valueOf(this.d), Integer.valueOf(this.f2999c)});
    }
}
