package c;

import javax.annotation.Nullable;

final class u {

    /* renamed from: a  reason: collision with root package name */
    static final int f430a = 8192;

    /* renamed from: b  reason: collision with root package name */
    static final int f431b = 1024;

    /* renamed from: c  reason: collision with root package name */
    final byte[] f432c;
    int d;
    int e;
    boolean f;
    boolean g;
    u h;
    u i;

    u() {
        this.f432c = new byte[8192];
        this.g = true;
        this.f = false;
    }

    u(u uVar) {
        this(uVar.f432c, uVar.d, uVar.e);
        uVar.f = true;
    }

    u(byte[] bArr, int i2, int i3) {
        this.f432c = bArr;
        this.d = i2;
        this.e = i3;
        this.g = false;
        this.f = true;
    }

    private u a(int i2) {
        u uVar;
        if (i2 <= 0 || i2 > this.e - this.d) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            uVar = new u(this);
        } else {
            uVar = v.a();
            System.arraycopy(this.f432c, this.d, uVar.f432c, 0, i2);
        }
        uVar.e = uVar.d + i2;
        this.d += i2;
        this.i.a(uVar);
        return uVar;
    }

    private void b() {
        if (this.i == this) {
            throw new IllegalStateException();
        } else if (this.i.g) {
            int i2 = this.e - this.d;
            if (i2 <= (8192 - this.i.e) + (this.i.f ? 0 : this.i.d)) {
                a(this.i, i2);
                a();
                v.a(this);
            }
        }
    }

    @Nullable
    public final u a() {
        u uVar = this.h != this ? this.h : null;
        this.i.h = this.h;
        this.h.i = this.i;
        this.h = null;
        this.i = null;
        return uVar;
    }

    public final u a(u uVar) {
        uVar.i = this;
        uVar.h = this.h;
        this.h.i = uVar;
        this.h = uVar;
        return uVar;
    }

    public final void a(u uVar, int i2) {
        if (!uVar.g) {
            throw new IllegalArgumentException();
        }
        if (uVar.e + i2 > 8192) {
            if (uVar.f) {
                throw new IllegalArgumentException();
            } else if ((uVar.e + i2) - uVar.d > 8192) {
                throw new IllegalArgumentException();
            } else {
                System.arraycopy(uVar.f432c, uVar.d, uVar.f432c, 0, uVar.e - uVar.d);
                uVar.e -= uVar.d;
                uVar.d = 0;
            }
        }
        System.arraycopy(this.f432c, this.d, uVar.f432c, uVar.e, i2);
        uVar.e += i2;
        this.d += i2;
    }
}
