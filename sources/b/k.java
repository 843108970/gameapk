package b;

import android.support.v7.widget.ActivityChooserView;
import b.a.c;
import b.a.c.d;
import b.a.c.g;
import b.a.h.e;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    static final Executor f319a = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean g = true;

    /* renamed from: b  reason: collision with root package name */
    final int f320b;

    /* renamed from: c  reason: collision with root package name */
    final Runnable f321c;
    final Deque<b.a.c.c> d;
    final d e;
    boolean f;
    private final long h;

    public k() {
        this(TimeUnit.MINUTES);
    }

    private k(TimeUnit timeUnit) {
        this.f321c = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r8 = this;
                L_0x0000:
                    b.k r0 = b.k.this
                    long r1 = java.lang.System.nanoTime()
                    long r0 = r0.a((long) r1)
                    r2 = -1
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 != 0) goto L_0x0011
                    return
                L_0x0011:
                    r2 = 0
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 <= 0) goto L_0x0000
                    r2 = 1000000(0xf4240, double:4.940656E-318)
                    long r4 = r0 / r2
                    long r2 = r2 * r4
                    long r6 = r0 - r2
                    b.k r0 = b.k.this
                    monitor-enter(r0)
                    b.k r1 = b.k.this     // Catch:{ InterruptedException -> 0x002c }
                    int r2 = (int) r6     // Catch:{ InterruptedException -> 0x002c }
                    r1.wait(r4, r2)     // Catch:{ InterruptedException -> 0x002c }
                    goto L_0x002c
                L_0x002a:
                    r1 = move-exception
                    goto L_0x002e
                L_0x002c:
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    goto L_0x0000
                L_0x002e:
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: b.k.AnonymousClass1.run():void");
            }
        };
        this.d = new ArrayDeque();
        this.e = new d();
        this.f320b = 5;
        this.h = timeUnit.toNanos(5);
    }

    private synchronized int a() {
        int i;
        i = 0;
        for (b.a.c.c cVar : this.d) {
            if (cVar.k.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    private int a(b.a.c.c cVar, long j) {
        List<Reference<g>> list = cVar.k;
        int i = 0;
        while (i < list.size()) {
            Reference reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                e.b().a("A connection to " + cVar.f60a.f272a.f8a + " was leaked. Did you forget to close a response body?", ((g.a) reference).f72a);
                list.remove(i);
                cVar.h = true;
                if (list.isEmpty()) {
                    cVar.l = j - this.h;
                    return 0;
                }
            }
        }
        return list.size();
    }

    @Nullable
    private b.a.c.c a(a aVar, g gVar, ag agVar) {
        if (g || Thread.holdsLock(this)) {
            for (b.a.c.c next : this.d) {
                if (next.a(aVar, agVar)) {
                    gVar.a(next);
                    return next;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    @Nullable
    private Socket a(a aVar, g gVar) {
        if (g || Thread.holdsLock(this)) {
            for (b.a.c.c next : this.d) {
                if (next.a(aVar, (ag) null) && next.e() && next != gVar.b()) {
                    if (!g.h && !Thread.holdsLock(gVar.f71c)) {
                        throw new AssertionError();
                    } else if (gVar.g == null && gVar.e.k.size() == 1) {
                        Socket a2 = gVar.a(true, false, false);
                        gVar.e = next;
                        next.k.add(gVar.e.k.get(0));
                        return a2;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    private void a(b.a.c.c cVar) {
        if (g || Thread.holdsLock(this)) {
            if (!this.f) {
                this.f = true;
                f319a.execute(this.f321c);
            }
            this.d.add(cVar);
            return;
        }
        throw new AssertionError();
    }

    private synchronized int b() {
        return this.d.size();
    }

    private boolean b(b.a.c.c cVar) {
        if (!g && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (cVar.h || this.f320b == 0) {
            this.d.remove(cVar);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    private void c() {
        ArrayList<b.a.c.c> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<b.a.c.c> it = this.d.iterator();
            while (it.hasNext()) {
                b.a.c.c next = it.next();
                if (next.k.isEmpty()) {
                    next.h = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        for (b.a.c.c cVar : arrayList) {
            c.a(cVar.f62c);
        }
    }

    /* access modifiers changed from: package-private */
    public final long a(long j) {
        int size;
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            b.a.c.c cVar = null;
            int i = 0;
            int i2 = 0;
            for (b.a.c.c next : this.d) {
                List<Reference<g>> list = next.k;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        size = list.size();
                        break;
                    }
                    Reference reference = list.get(i3);
                    if (reference.get() != null) {
                        i3++;
                    } else {
                        e.b().a("A connection to " + next.f60a.f272a.f8a + " was leaked. Did you forget to close a response body?", ((g.a) reference).f72a);
                        list.remove(i3);
                        next.h = true;
                        if (list.isEmpty()) {
                            next.l = j - this.h;
                            size = 0;
                            break;
                        }
                    }
                }
                if (size > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.l;
                    if (j3 > j2) {
                        cVar = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.h) {
                if (i <= this.f320b) {
                    if (i > 0) {
                        long j4 = this.h - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.h;
                        return j5;
                    } else {
                        this.f = false;
                        return -1;
                    }
                }
            }
            this.d.remove(cVar);
            c.a(cVar.f62c);
            return 0;
        }
    }
}
