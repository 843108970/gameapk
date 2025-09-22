package com.b.b;

final class r implements g {

    /* renamed from: a  reason: collision with root package name */
    public final f f873a = new f();

    /* renamed from: b  reason: collision with root package name */
    public final w f874b;

    /* renamed from: c  reason: collision with root package name */
    boolean f875c;

    r(w wVar) {
        if (wVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f874b = wVar;
    }

    public final y a() {
        return this.f874b.a();
    }

    public final void a_(f fVar, long j) {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.f873a.a_(fVar, j);
        p();
    }

    public final g b(String str) {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.f873a.b(str);
        return p();
    }

    public final g b(byte[] bArr) {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.f873a.b(bArr);
        return p();
    }

    public final g b(byte[] bArr, int i, int i2) {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.f873a.b(bArr, i, i2);
        return p();
    }

    public final f c() {
        return this.f873a;
    }

    public final void close() {
        if (!this.f875c) {
            Throwable th = null;
            try {
                if (this.f873a.f855b > 0) {
                    this.f874b.a_(this.f873a, this.f873a.f855b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f874b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f875c = true;
            if (th != null) {
                aa.a(th);
            }
        }
    }

    public final g f(int i) {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.f873a.f(i);
        return p();
    }

    public final void flush() {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        if (this.f873a.f855b > 0) {
            this.f874b.a_(this.f873a, this.f873a.f855b);
        }
        this.f874b.flush();
    }

    public final g g(int i) {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.f873a.g(i);
        return p();
    }

    public final g h(int i) {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.f873a.h(i);
        return p();
    }

    public final g i(long j) {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.f873a.i(j);
        return p();
    }

    public final g j(long j) {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        this.f873a.j(j);
        return p();
    }

    public final g p() {
        if (this.f875c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f873a;
        long j = fVar.f855b;
        if (j == 0) {
            j = 0;
        } else {
            t tVar = fVar.f854a.g;
            if (tVar.f881c < 8192 && tVar.e) {
                j -= (long) (tVar.f881c - tVar.f880b);
            }
        }
        if (j > 0) {
            this.f874b.a_(this.f873a, j);
        }
        return this;
    }

    public final String toString() {
        return "buffer(" + this.f874b + ")";
    }
}
