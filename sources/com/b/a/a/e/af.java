package com.b.a.a.e;

import android.support.v7.widget.ActivityChooserView;
import com.b.a.a.c;
import com.b.b.f;
import com.b.b.g;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class af implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f647b = Logger.getLogger(g.class.getName());

    /* renamed from: a  reason: collision with root package name */
    final f f648a = new f(this.e);

    /* renamed from: c  reason: collision with root package name */
    private final g f649c;
    private final boolean d;
    private final f e = new f();
    private int f = 16384;
    private boolean g;

    public af(g gVar, boolean z) {
        this.f649c = gVar;
        this.d = z;
    }

    private void a(int i, int i2, byte b2, byte b3) {
        if (f647b.isLoggable(Level.FINE)) {
            f647b.fine(g.a(false, i, i2, b2, b3));
        }
        if (i2 > this.f) {
            throw g.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) != 0) {
            throw g.a("reserved bit set: %s", Integer.valueOf(i));
        } else {
            g gVar = this.f649c;
            gVar.h((i2 >>> 16) & 255);
            gVar.h((i2 >>> 8) & 255);
            gVar.h(i2 & 255);
            this.f649c.h(b2 & 255);
            this.f649c.h(b3 & 255);
            this.f649c.f(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
    }

    private void b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.f, j);
            long j2 = (long) min;
            long j3 = j - j2;
            a(i, min, (byte) 9, j3 == 0 ? (byte) 4 : 0);
            this.f649c.a_(this.e, j2);
            j = j3;
        }
    }

    public final synchronized void a() {
        if (this.g) {
            throw new IOException("closed");
        } else if (this.d) {
            if (f647b.isLoggable(Level.FINE)) {
                f647b.fine(c.a(">> CONNECTION %s", g.f677a.e()));
            }
            this.f649c.b(g.f677a.h());
            this.f649c.flush();
        }
    }

    public final synchronized void a(int i, long j) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (j != 0) {
            if (j <= 2147483647L) {
                a(i, 4, (byte) 8, (byte) 0);
                this.f649c.f((int) j);
                this.f649c.flush();
            }
        }
        throw g.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
    }

    public final synchronized void a(int i, b bVar) {
        if (this.g) {
            throw new IOException("closed");
        } else if (bVar.g == -1) {
            throw new IllegalArgumentException();
        } else {
            a(i, 4, (byte) 3, (byte) 0);
            this.f649c.f(bVar.g);
            this.f649c.flush();
        }
    }

    public final synchronized void a(int i, b bVar, byte[] bArr) {
        if (this.g) {
            throw new IOException("closed");
        } else if (bVar.g == -1) {
            throw g.a("errorCode.httpCode == -1", new Object[0]);
        } else {
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f649c.f(i);
            this.f649c.f(bVar.g);
            if (bArr.length > 0) {
                this.f649c.b(bArr);
            }
            this.f649c.flush();
        }
    }

    public final synchronized void a(al alVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f = alVar.c(this.f);
        if (alVar.b() != -1) {
            this.f648a.a(alVar.b());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.f649c.flush();
    }

    public final synchronized void a(boolean z, int i, int i2) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z ? (byte) 1 : 0);
        this.f649c.f(i);
        this.f649c.f(i2);
        this.f649c.flush();
    }

    public final synchronized void a(boolean z, int i, f fVar, int i2) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(i, i2, (byte) 0, z ? (byte) 1 : 0);
        if (i2 > 0) {
            this.f649c.a_(fVar, (long) i2);
        }
    }

    public final synchronized void a(boolean z, int i, List<c> list) {
        if (this.g) {
            throw new IOException("closed");
        } else if (this.g) {
            throw new IOException("closed");
        } else {
            this.f648a.a(list);
            long b2 = this.e.b();
            int min = (int) Math.min((long) this.f, b2);
            long j = (long) min;
            byte b3 = b2 == j ? (byte) 4 : 0;
            if (z) {
                b3 = (byte) (b3 | 1);
            }
            a(i, min, (byte) 1, b3);
            this.f649c.a_(this.e, j);
            if (b2 > j) {
                b(i, b2 - j);
            }
        }
    }

    public final synchronized void b() {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f649c.flush();
    }

    public final synchronized void b(al alVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        int i = 0;
        a(0, alVar.a() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (alVar.a(i)) {
                this.f649c.g(i == 4 ? 3 : i == 7 ? 4 : i);
                this.f649c.f(alVar.b(i));
            }
            i++;
        }
        this.f649c.flush();
    }

    public final int c() {
        return this.f;
    }

    public final synchronized void close() {
        this.g = true;
        this.f649c.close();
    }
}
