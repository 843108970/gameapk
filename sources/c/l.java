package c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class l implements y {

    /* renamed from: a  reason: collision with root package name */
    private static final byte f398a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final byte f399b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final byte f400c = 3;
    private static final byte d = 4;
    private static final byte e = 0;
    private static final byte f = 1;
    private static final byte g = 2;
    private static final byte h = 3;
    private int i = 0;
    private final e j;
    private final Inflater k;
    private final o l;
    private final CRC32 m = new CRC32();

    public l(y yVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.k = new Inflater(true);
        this.j = p.a(yVar);
        this.l = new o(this.j, this.k);
    }

    private void a() throws IOException {
        this.j.a(10);
        byte c2 = this.j.a().c(3);
        boolean z = ((c2 >> 1) & 1) == 1;
        if (z) {
            a(this.j.a(), 0, 10);
        }
        a("ID1ID2", 8075, (int) this.j.h());
        this.j.h(8);
        if (((c2 >> 2) & 1) == 1) {
            this.j.a(2);
            if (z) {
                a(this.j.a(), 0, 2);
            }
            long a2 = (long) ab.a(this.j.a().h());
            this.j.a(a2);
            if (z) {
                a(this.j.a(), 0, a2);
            }
            this.j.h(a2);
        }
        if (((c2 >> 3) & 1) == 1) {
            long a3 = this.j.a((byte) 0);
            if (a3 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.j.a(), 0, a3 + 1);
            }
            this.j.h(a3 + 1);
        }
        if (((c2 >> 4) & 1) == 1) {
            long a4 = this.j.a((byte) 0);
            if (a4 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.j.a(), 0, a4 + 1);
            }
            this.j.h(a4 + 1);
        }
        if (z) {
            a("FHCRC", (int) this.j.k(), (int) (short) ((int) this.m.getValue()));
            this.m.reset();
        }
    }

    private void a(c cVar, long j2, long j3) {
        u uVar = cVar.f386b;
        while (j2 >= ((long) (uVar.e - uVar.d))) {
            uVar = uVar.h;
            j2 -= (long) (uVar.e - uVar.d);
        }
        while (j3 > 0) {
            int i2 = (int) (((long) uVar.d) + j2);
            int min = (int) Math.min((long) (uVar.e - i2), j3);
            this.m.update(uVar.f432c, i2, min);
            uVar = uVar.h;
            j2 = 0;
            j3 -= (long) min;
        }
    }

    private static void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}));
        }
    }

    private void b() throws IOException {
        a("CRC", this.j.l(), (int) this.m.getValue());
        a("ISIZE", this.j.l(), (int) this.k.getBytesWritten());
    }

    public final void close() throws IOException {
        this.l.close();
    }

    public final long read(c cVar, long j2) throws IOException {
        long j3;
        c cVar2 = cVar;
        long j4 = j2;
        if (j4 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        } else if (j4 == 0) {
            return 0;
        } else {
            if (this.i == 0) {
                this.j.a(10);
                byte c2 = this.j.a().c(3);
                boolean z = ((c2 >> 1) & 1) == 1;
                if (z) {
                    a(this.j.a(), 0, 10);
                }
                a("ID1ID2", 8075, (int) this.j.h());
                this.j.h(8);
                if (((c2 >> 2) & 1) == 1) {
                    this.j.a(2);
                    if (z) {
                        a(this.j.a(), 0, 2);
                    }
                    long k2 = (long) this.j.a().k();
                    this.j.a(k2);
                    if (z) {
                        j3 = k2;
                        a(this.j.a(), 0, k2);
                    } else {
                        j3 = k2;
                    }
                    this.j.h(j3);
                }
                if (((c2 >> 3) & 1) == 1) {
                    long a2 = this.j.a((byte) 0);
                    if (a2 == -1) {
                        throw new EOFException();
                    }
                    if (z) {
                        a(this.j.a(), 0, a2 + 1);
                    }
                    this.j.h(a2 + 1);
                }
                if (((c2 >> 4) & 1) == 1) {
                    long a3 = this.j.a((byte) 0);
                    if (a3 == -1) {
                        throw new EOFException();
                    }
                    if (z) {
                        a(this.j.a(), 0, a3 + 1);
                    }
                    this.j.h(a3 + 1);
                }
                if (z) {
                    a("FHCRC", (int) this.j.k(), (int) (short) ((int) this.m.getValue()));
                    this.m.reset();
                }
                this.i = 1;
            }
            if (this.i == 1) {
                long j5 = cVar2.f387c;
                long read = this.l.read(cVar2, j4);
                if (read != -1) {
                    a(cVar2, j5, read);
                    return read;
                }
                this.i = 2;
            }
            if (this.i == 2) {
                a("CRC", this.j.l(), (int) this.m.getValue());
                a("ISIZE", this.j.l(), (int) this.k.getBytesWritten());
                this.i = 3;
                if (!this.j.d()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public final z timeout() {
        return this.j.timeout();
    }
}
