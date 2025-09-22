package b.a.f;

import android.support.v7.widget.ActivityChooserView;
import b.a.f.d;
import c.c;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class j implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f165c = Logger.getLogger(e.class.getName());

    /* renamed from: a  reason: collision with root package name */
    int f166a = 16384;

    /* renamed from: b  reason: collision with root package name */
    final d.b f167b = new d.b(this.f);
    private final c.d d;
    private final boolean e;
    private final c f = new c();
    private boolean g;

    j(c.d dVar, boolean z) {
        this.d = dVar;
        this.e = z;
    }

    private void a(int i, byte b2, c cVar, int i2) throws IOException {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.d.a(cVar, (long) i2);
        }
    }

    private void a(int i, int i2, byte b2, byte b3) throws IOException {
        if (f165c.isLoggable(Level.FINE)) {
            f165c.fine(e.a(false, i, i2, b2, b3));
        }
        if (i2 > this.f166a) {
            throw e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f166a), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) != 0) {
            throw e.a("reserved bit set: %s", Integer.valueOf(i));
        } else {
            c.d dVar = this.d;
            dVar.l((i2 >>> 16) & 255);
            dVar.l((i2 >>> 8) & 255);
            dVar.l(i2 & 255);
            this.d.l(b2 & 255);
            this.d.l(b3 & 255);
            this.d.i(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
    }

    private synchronized void a(int i, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        c(false, i, list);
    }

    private static void a(c.d dVar, int i) throws IOException {
        dVar.l((i >>> 16) & 255);
        dVar.l((i >>> 8) & 255);
        dVar.l(i & 255);
    }

    private void b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f166a, j);
            long j2 = (long) min;
            long j3 = j - j2;
            a(i, min, (byte) 9, j3 == 0 ? (byte) 4 : 0);
            this.d.a(this.f, j2);
            j = j3;
        }
    }

    private int c() {
        return this.f166a;
    }

    private void c(boolean z, int i, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f167b.a(list);
        long j = this.f.f387c;
        int min = (int) Math.min((long) this.f166a, j);
        long j2 = (long) min;
        byte b2 = j == j2 ? (byte) 4 : 0;
        if (z) {
            b2 = (byte) (b2 | 1);
        }
        a(i, min, (byte) 1, b2);
        this.d.a(this.f, j2);
        if (j > j2) {
            b(i, j - j2);
        }
    }

    public final synchronized void a() throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (this.e) {
            if (f165c.isLoggable(Level.FINE)) {
                f165c.fine(b.a.c.a(">> CONNECTION %s", e.f116a.hex()));
            }
            this.d.d(e.f116a.toByteArray());
            this.d.flush();
        }
    }

    public final synchronized void a(int i, int i2, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f167b.a(list);
        long j = this.f.f387c;
        int min = (int) Math.min((long) (this.f166a - 4), j);
        long j2 = (long) min;
        a(i, min + 4, (byte) 5, j == j2 ? (byte) 4 : 0);
        this.d.i(i2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.d.a(this.f, j2);
        if (j > j2) {
            b(i, j - j2);
        }
    }

    public final synchronized void a(int i, long j) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        if (j != 0) {
            if (j <= 2147483647L) {
                a(i, 4, (byte) 8, (byte) 0);
                this.d.i((int) j);
                this.d.flush();
            }
        }
        throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
    }

    public final synchronized void a(int i, b bVar) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (bVar.httpCode == -1) {
            throw new IllegalArgumentException();
        } else {
            a(i, 4, (byte) 3, (byte) 0);
            this.d.i(bVar.httpCode);
            this.d.flush();
        }
    }

    public final synchronized void a(int i, b bVar, byte[] bArr) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (bVar.httpCode == -1) {
            throw e.a("errorCode.httpCode == -1", new Object[0]);
        } else {
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.d.i(i);
            this.d.i(bVar.httpCode);
            if (bArr.length > 0) {
                this.d.d(bArr);
            }
            this.d.flush();
        }
    }

    public final synchronized void a(n nVar) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        int i = this.f166a;
        if ((nVar.i & 32) != 0) {
            i = nVar.j[5];
        }
        this.f166a = i;
        if (nVar.a() != -1) {
            this.f167b.a(nVar.a());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.d.flush();
    }

    public final synchronized void a(boolean z, int i, int i2) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z ? (byte) 1 : 0);
        this.d.i(i);
        this.d.i(i2);
        this.d.flush();
    }

    public final synchronized void a(boolean z, int i, c cVar, int i2) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        a(i, i2, (byte) 0, z ? (byte) 1 : 0);
        if (i2 > 0) {
            this.d.a(cVar, (long) i2);
        }
    }

    public final synchronized void a(boolean z, int i, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        c(z, i, list);
    }

    public final synchronized void b() throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.d.flush();
    }

    public final synchronized void b(n nVar) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        int i = 0;
        a(0, Integer.bitCount(nVar.i) * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (nVar.a(i)) {
                this.d.k(i == 4 ? 3 : i == 7 ? 4 : i);
                this.d.i(nVar.j[i]);
            }
            i++;
        }
        this.d.flush();
    }

    public final synchronized void b(boolean z, int i, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        c(z, i, list);
    }

    public final synchronized void close() throws IOException {
        this.g = true;
        this.d.close();
    }
}
