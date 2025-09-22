package com.b.a.a.e;

import com.b.b.h;
import com.b.b.i;
import com.b.b.n;
import com.b.b.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class e {

    /* renamed from: a  reason: collision with root package name */
    c[] f671a;

    /* renamed from: b  reason: collision with root package name */
    int f672b;

    /* renamed from: c  reason: collision with root package name */
    int f673c;
    int d;
    private final List<c> e;
    private final h f;
    private final int g;
    private int h;

    e(x xVar) {
        this(xVar, (byte) 0);
    }

    private e(x xVar, byte b2) {
        this.e = new ArrayList();
        this.f671a = new c[8];
        this.f672b = this.f671a.length - 1;
        this.f673c = 0;
        this.d = 0;
        this.g = 4096;
        this.h = 4096;
        this.f = n.a(xVar);
    }

    private int a(int i) {
        int i2 = 0;
        if (i > 0) {
            int length = this.f671a.length;
            while (true) {
                length--;
                if (length < this.f672b || i <= 0) {
                    System.arraycopy(this.f671a, this.f672b + 1, this.f671a, this.f672b + 1 + i2, this.f673c);
                    this.f672b += i2;
                } else {
                    i -= this.f671a[length].i;
                    this.d -= this.f671a[length].i;
                    this.f673c--;
                    i2++;
                }
            }
            System.arraycopy(this.f671a, this.f672b + 1, this.f671a, this.f672b + 1 + i2, this.f673c);
            this.f672b += i2;
        }
        return i2;
    }

    private int a(int i, int i2) {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        int i4 = 0;
        while (true) {
            int e2 = e();
            if ((e2 & 128) == 0) {
                return i2 + (e2 << i4);
            }
            i2 += (e2 & 127) << i4;
            i4 += 7;
        }
    }

    private void a(c cVar) {
        this.e.add(cVar);
        int i = cVar.i;
        if (i > this.h) {
            d();
            return;
        }
        a((this.d + i) - this.h);
        if (this.f673c + 1 > this.f671a.length) {
            c[] cVarArr = new c[(this.f671a.length * 2)];
            System.arraycopy(this.f671a, 0, cVarArr, this.f671a.length, this.f671a.length);
            this.f672b = this.f671a.length - 1;
            this.f671a = cVarArr;
        }
        int i2 = this.f672b;
        this.f672b = i2 - 1;
        this.f671a[i2] = cVar;
        this.f673c++;
        this.d += i;
    }

    private int b(int i) {
        return this.f672b + 1 + i;
    }

    private i c(int i) {
        return (d(i) ? d.f669a[i] : this.f671a[b(i - d.f669a.length)]).g;
    }

    private void c() {
        if (this.h >= this.d) {
            return;
        }
        if (this.h == 0) {
            d();
        } else {
            a(this.d - this.h);
        }
    }

    private void d() {
        Arrays.fill(this.f671a, (Object) null);
        this.f672b = this.f671a.length - 1;
        this.f673c = 0;
        this.d = 0;
    }

    private static boolean d(int i) {
        return i >= 0 && i <= d.f669a.length - 1;
    }

    private int e() {
        return this.f.e() & 255;
    }

    private i f() {
        int e2 = e();
        boolean z = (e2 & 128) == 128;
        int a2 = a(e2, 127);
        return z ? i.a(ag.a().a(this.f.e((long) a2))) : this.f.c((long) a2);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        c cVar;
        List<c> list;
        c cVar2;
        while (!this.f.d()) {
            byte e2 = this.f.e() & 255;
            if (e2 == 128) {
                throw new IOException("index == 0");
            } else if ((e2 & 128) == 128) {
                int a2 = a(e2, 127) - 1;
                if (d(a2)) {
                    this.e.add(d.f669a[a2]);
                } else {
                    int b2 = b(a2 - d.f669a.length);
                    if (b2 < 0 || b2 > this.f671a.length - 1) {
                        throw new IOException("Header index too large " + (a2 + 1));
                    }
                    this.e.add(this.f671a[b2]);
                }
            } else {
                if (e2 == 64) {
                    cVar2 = new c(d.a(f()), f());
                } else if ((e2 & 64) == 64) {
                    cVar2 = new c(c(a(e2, 63) - 1), f());
                } else if ((e2 & 32) == 32) {
                    this.h = a(e2, 31);
                    if (this.h < 0 || this.h > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    c();
                } else {
                    if (e2 == 16 || e2 == 0) {
                        i a3 = d.a(f());
                        i f2 = f();
                        list = this.e;
                        cVar = new c(a3, f2);
                    } else {
                        i c2 = c(a(e2, 15) - 1);
                        i f3 = f();
                        list = this.e;
                        cVar = new c(c2, f3);
                    }
                    list.add(cVar);
                }
                a(cVar2);
            }
        }
    }

    public final List<c> b() {
        ArrayList arrayList = new ArrayList(this.e);
        this.e.clear();
        return arrayList;
    }
}
