package com.b.a.a.e;

import android.support.v7.widget.ActivityChooserView;
import com.b.a.a.c;
import com.b.b.i;
import java.util.Arrays;
import java.util.List;

final class f {

    /* renamed from: a  reason: collision with root package name */
    int f674a;

    /* renamed from: b  reason: collision with root package name */
    int f675b;

    /* renamed from: c  reason: collision with root package name */
    c[] f676c;
    int d;
    int e;
    int f;
    private final com.b.b.f g;
    private final boolean h;
    private int i;
    private boolean j;

    f(com.b.b.f fVar) {
        this(fVar, (byte) 0);
    }

    private f(com.b.b.f fVar, byte b2) {
        this.i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f676c = new c[8];
        this.d = this.f676c.length - 1;
        this.e = 0;
        this.f = 0;
        this.f674a = 4096;
        this.f675b = 4096;
        this.h = true;
        this.g = fVar;
    }

    private void a() {
        Arrays.fill(this.f676c, (Object) null);
        this.d = this.f676c.length - 1;
        this.e = 0;
        this.f = 0;
    }

    private void a(int i2, int i3, int i4) {
        int i5;
        com.b.b.f fVar;
        if (i2 < i3) {
            fVar = this.g;
            i5 = i2 | i4;
        } else {
            this.g.h(i4 | i3);
            i5 = i2 - i3;
            while (i5 >= 128) {
                this.g.h(128 | (i5 & 127));
                i5 >>>= 7;
            }
            fVar = this.g;
        }
        fVar.h(i5);
    }

    private void a(c cVar) {
        int i2 = cVar.i;
        if (i2 > this.f675b) {
            a();
            return;
        }
        b((this.f + i2) - this.f675b);
        if (this.e + 1 > this.f676c.length) {
            c[] cVarArr = new c[(this.f676c.length * 2)];
            System.arraycopy(this.f676c, 0, cVarArr, this.f676c.length, this.f676c.length);
            this.d = this.f676c.length - 1;
            this.f676c = cVarArr;
        }
        int i3 = this.d;
        this.d = i3 - 1;
        this.f676c[i3] = cVar;
        this.e++;
        this.f += i2;
    }

    private void a(i iVar) {
        int g2;
        int i2;
        if (this.h) {
            ag.a();
            if (ag.a(iVar) < iVar.g()) {
                com.b.b.f fVar = new com.b.b.f();
                ag.a();
                ag.a(iVar, fVar);
                iVar = fVar.k();
                g2 = iVar.g();
                i2 = 128;
                a(g2, 127, i2);
                this.g.a(iVar);
            }
        }
        g2 = iVar.g();
        i2 = 0;
        a(g2, 127, i2);
        this.g.a(iVar);
    }

    private int b(int i2) {
        int i3 = 0;
        if (i2 > 0) {
            int length = this.f676c.length;
            while (true) {
                length--;
                if (length < this.d || i2 <= 0) {
                    System.arraycopy(this.f676c, this.d + 1, this.f676c, this.d + 1 + i3, this.e);
                    Arrays.fill(this.f676c, this.d + 1, this.d + 1 + i3, (Object) null);
                    this.d += i3;
                } else {
                    i2 -= this.f676c[length].i;
                    this.f -= this.f676c[length].i;
                    this.e--;
                    i3++;
                }
            }
            System.arraycopy(this.f676c, this.d + 1, this.f676c, this.d + 1 + i3, this.e);
            Arrays.fill(this.f676c, this.d + 1, this.d + 1 + i3, (Object) null);
            this.d += i3;
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.f674a = i2;
        int min = Math.min(i2, 16384);
        if (this.f675b != min) {
            if (min < this.f675b) {
                this.i = Math.min(this.i, min);
            }
            this.j = true;
            this.f675b = min;
            if (this.f675b >= this.f) {
                return;
            }
            if (this.f675b == 0) {
                a();
            } else {
                b(this.f - this.f675b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(List<c> list) {
        int i2;
        int i3;
        if (this.j) {
            if (this.i < this.f675b) {
                a(this.i, 31, 32);
            }
            this.j = false;
            this.i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            a(this.f675b, 31, 32);
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            c cVar = list.get(i4);
            i f2 = cVar.g.f();
            i iVar = cVar.h;
            Integer num = d.f670b.get(f2);
            if (num != null) {
                i3 = num.intValue() + 1;
                if (i3 > 1 && i3 < 8) {
                    if (c.a((Object) d.f669a[i3 - 1].h, (Object) iVar)) {
                        i2 = i3;
                    } else if (c.a((Object) d.f669a[i3].h, (Object) iVar)) {
                        i2 = i3;
                        i3++;
                    }
                }
                i2 = i3;
                i3 = -1;
            } else {
                i3 = -1;
                i2 = -1;
            }
            if (i3 == -1) {
                int i5 = this.d + 1;
                int length = this.f676c.length;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    if (c.a((Object) this.f676c[i5].g, (Object) f2)) {
                        if (c.a((Object) this.f676c[i5].h, (Object) iVar)) {
                            i3 = d.f669a.length + (i5 - this.d);
                            break;
                        } else if (i2 == -1) {
                            i2 = (i5 - this.d) + d.f669a.length;
                        }
                    }
                    i5++;
                }
            }
            if (i3 != -1) {
                a(i3, 127, 128);
            } else {
                if (i2 == -1) {
                    this.g.h(64);
                    a(f2);
                } else {
                    i iVar2 = c.f666a;
                    if (!f2.a(0, iVar2, 0, iVar2.g()) || c.f.equals(f2)) {
                        a(i2, 63, 64);
                    } else {
                        a(i2, 15, 0);
                        a(iVar);
                    }
                }
                a(iVar);
                a(cVar);
            }
        }
    }
}
