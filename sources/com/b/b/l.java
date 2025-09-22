package com.b.b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class l implements x {

    /* renamed from: a  reason: collision with root package name */
    private int f861a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final h f862b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f863c;
    private final m d;
    private final CRC32 e = new CRC32();

    public l(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f863c = new Inflater(true);
        this.f862b = n.a(xVar);
        this.d = new m(this.f862b, this.f863c);
    }

    private void a(f fVar, long j, long j2) {
        t tVar = fVar.f854a;
        while (j >= ((long) (tVar.f881c - tVar.f880b))) {
            tVar = tVar.f;
            j -= (long) (tVar.f881c - tVar.f880b);
        }
        while (j2 > 0) {
            int i = (int) (((long) tVar.f880b) + j);
            int min = (int) Math.min((long) (tVar.f881c - i), j2);
            this.e.update(tVar.f879a, i, min);
            tVar = tVar.f;
            j = 0;
            j2 -= (long) min;
        }
    }

    private static void a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    public final long a(f fVar, long j) {
        long j2;
        f fVar2 = fVar;
        long j3 = j;
        if (j3 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j3);
        } else if (j3 == 0) {
            return 0;
        } else {
            if (this.f861a == 0) {
                this.f862b.a(10);
                byte b2 = this.f862b.c().b(3);
                boolean z = ((b2 >> 1) & 1) == 1;
                if (z) {
                    a(this.f862b.c(), 0, 10);
                }
                a("ID1ID2", 8075, (int) this.f862b.f());
                this.f862b.f(8);
                if (((b2 >> 2) & 1) == 1) {
                    this.f862b.a(2);
                    if (z) {
                        a(this.f862b.c(), 0, 2);
                    }
                    long h = (long) this.f862b.c().h();
                    this.f862b.a(h);
                    if (z) {
                        j2 = h;
                        a(this.f862b.c(), 0, h);
                    } else {
                        j2 = h;
                    }
                    this.f862b.f(j2);
                }
                if (((b2 >> 3) & 1) == 1) {
                    long a2 = this.f862b.a((byte) 0);
                    if (a2 == -1) {
                        throw new EOFException();
                    }
                    if (z) {
                        a(this.f862b.c(), 0, a2 + 1);
                    }
                    this.f862b.f(a2 + 1);
                }
                if (((b2 >> 4) & 1) == 1) {
                    long a3 = this.f862b.a((byte) 0);
                    if (a3 == -1) {
                        throw new EOFException();
                    }
                    if (z) {
                        a(this.f862b.c(), 0, a3 + 1);
                    }
                    this.f862b.f(a3 + 1);
                }
                if (z) {
                    a("FHCRC", (int) this.f862b.h(), (int) (short) ((int) this.e.getValue()));
                    this.e.reset();
                }
                this.f861a = 1;
            }
            if (this.f861a == 1) {
                long j4 = fVar2.f855b;
                long a4 = this.d.a(fVar2, j3);
                if (a4 != -1) {
                    a(fVar2, j4, a4);
                    return a4;
                }
                this.f861a = 2;
            }
            if (this.f861a == 2) {
                a("CRC", this.f862b.i(), (int) this.e.getValue());
                a("ISIZE", this.f862b.i(), (int) this.f863c.getBytesWritten());
                this.f861a = 3;
                if (!this.f862b.d()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public final y a() {
        return this.f862b.a();
    }

    public final void close() {
        this.d.close();
    }
}
