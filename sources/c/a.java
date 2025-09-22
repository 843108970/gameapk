package c;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class a extends z {

    /* renamed from: a  reason: collision with root package name */
    private static final int f376a = 65536;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    static a f377b;
    private static final long d = TimeUnit.SECONDS.toMillis(60);
    private static final long e = TimeUnit.MILLISECONDS.toNanos(d);
    private boolean f;
    @Nullable
    private a g;
    private long h;

    /* renamed from: c.a$a  reason: collision with other inner class name */
    private static final class C0006a extends Thread {
        C0006a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<c.a> r0 = c.a.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                c.a r1 = c.a.e()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                c.a r2 = c.a.f377b     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                c.a.f377b = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.a()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: c.a.C0006a.run():void");
        }
    }

    private x a(final x xVar) {
        return new x() {
            public final void a(c cVar, long j) throws IOException {
                ab.a(cVar.f387c, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        u uVar = cVar.f386b;
                        while (true) {
                            if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                                break;
                            }
                            long j3 = j2 + ((long) (cVar.f386b.e - cVar.f386b.d));
                            if (j3 >= j) {
                                j2 = j;
                                break;
                            }
                            j2 = j3;
                        }
                        a.this.j_();
                        try {
                            xVar.a(cVar, j2);
                            a.this.a(true);
                            j -= j2;
                        } catch (IOException e) {
                            throw a.this.b(e);
                        } catch (Throwable th) {
                            a.this.a(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }

            public final void close() throws IOException {
                a.this.j_();
                try {
                    xVar.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.b(e);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public final void flush() throws IOException {
                a.this.j_();
                try {
                    xVar.flush();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.b(e);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public final z timeout() {
                return a.this;
            }

            public final String toString() {
                return "AsyncTimeout.sink(" + xVar + ")";
            }
        };
    }

    private y a(final y yVar) {
        return new y() {
            public final void close() throws IOException {
                try {
                    yVar.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.b(e);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public final long read(c cVar, long j) throws IOException {
                a.this.j_();
                try {
                    long read = yVar.read(cVar, j);
                    a.this.a(true);
                    return read;
                } catch (IOException e) {
                    throw a.this.b(e);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            public final z timeout() {
                return a.this;
            }

            public final String toString() {
                return "AsyncTimeout.source(" + yVar + ")";
            }
        };
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (f377b == null) {
                f377b = new a();
                new C0006a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.h = nanoTime + Math.min(j, aVar.c() - nanoTime);
            } else if (j != 0) {
                aVar.h = nanoTime + j;
            } else if (z) {
                aVar.h = aVar.c();
            } else {
                throw new AssertionError();
            }
            long j2 = aVar.h - nanoTime;
            a aVar2 = f377b;
            while (true) {
                if (aVar2.g == null) {
                    break;
                } else if (j2 < aVar2.g.h - nanoTime) {
                    break;
                } else {
                    aVar2 = aVar2.g;
                }
            }
            aVar.g = aVar2.g;
            aVar2.g = aVar;
            if (aVar2 == f377b) {
                a.class.notify();
            }
        }
    }

    private static synchronized boolean a(a aVar) {
        boolean z;
        synchronized (a.class) {
            a aVar2 = f377b;
            while (true) {
                if (aVar2 == null) {
                    z = true;
                    break;
                } else if (aVar2.g == aVar) {
                    aVar2.g = aVar.g;
                    aVar.g = null;
                    z = false;
                    break;
                } else {
                    aVar2 = aVar2.g;
                }
            }
        }
        return z;
    }

    private long b(long j) {
        return this.h - j;
    }

    @Nullable
    static a e() throws InterruptedException {
        a aVar = f377b.g;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(d);
            if (f377b.g != null || System.nanoTime() - nanoTime < e) {
                return null;
            }
            return f377b;
        }
        long nanoTime2 = aVar.h - System.nanoTime();
        if (nanoTime2 > 0) {
            long j = nanoTime2 / 1000000;
            a.class.wait(j, (int) (nanoTime2 - (1000000 * j)));
            return null;
        }
        f377b.g = aVar.g;
        aVar.g = null;
        return aVar;
    }

    /* access modifiers changed from: protected */
    public IOException a(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) throws IOException {
        if (k_() && z) {
            throw a((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException b(IOException iOException) throws IOException {
        return !k_() ? iOException : a(iOException);
    }

    public final void j_() {
        if (this.f) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l_ = l_();
        boolean m_ = m_();
        if (l_ != 0 || m_) {
            this.f = true;
            a(this, l_, m_);
        }
    }

    public final boolean k_() {
        if (!this.f) {
            return false;
        }
        this.f = false;
        return a(this);
    }
}
