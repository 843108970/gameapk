package com.b.a;

import android.support.v7.widget.ActivityChooserView;
import com.b.a.a.b.d;
import com.b.a.a.b.g;
import com.b.a.a.c;
import com.b.a.a.g.h;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class n {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f818c = true;
    private static final Executor d = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    final d f819a;

    /* renamed from: b  reason: collision with root package name */
    boolean f820b;
    private final int e;
    private final long f;
    private final Runnable g;
    private final Deque<com.b.a.a.b.c> h;

    public n() {
        this(TimeUnit.MINUTES);
    }

    private n(TimeUnit timeUnit) {
        this.g = new o(this);
        this.h = new ArrayDeque();
        this.f819a = new d();
        this.e = 5;
        this.f = timeUnit.toNanos(5);
    }

    /* access modifiers changed from: package-private */
    public final long a(long j) {
        int size;
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            com.b.a.a.b.c cVar = null;
            int i = 0;
            int i2 = 0;
            for (com.b.a.a.b.c next : this.h) {
                List<Reference<g>> list = next.d;
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
                        h.b().a("A connection to " + next.a().f793a.f563a + " was leaked. Did you forget to close a response body?", ((com.b.a.a.b.h) reference).f602a);
                        list.remove(i3);
                        next.f590a = true;
                        if (list.isEmpty()) {
                            next.e = j - this.f;
                            size = 0;
                            break;
                        }
                    }
                }
                if (size > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.e;
                    if (j3 > j2) {
                        cVar = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f) {
                if (i <= this.e) {
                    if (i > 0) {
                        long j4 = this.f - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f;
                        return j5;
                    } else {
                        this.f820b = false;
                        return -1;
                    }
                }
            }
            this.h.remove(cVar);
            c.a(cVar.b());
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final com.b.a.a.b.c a(a aVar, g gVar) {
        if (f818c || Thread.holdsLock(this)) {
            for (com.b.a.a.b.c next : this.h) {
                if (next.a(aVar)) {
                    gVar.a(next);
                    return next;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public final void a(com.b.a.a.b.c cVar) {
        if (f818c || Thread.holdsLock(this)) {
            if (!this.f820b) {
                this.f820b = true;
                d.execute(this.g);
            }
            this.h.add(cVar);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public final Socket b(a aVar, g gVar) {
        if (f818c || Thread.holdsLock(this)) {
            for (com.b.a.a.b.c next : this.h) {
                if (next.a(aVar) && next.d() && next != gVar.b()) {
                    return gVar.b(next);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public final boolean b(com.b.a.a.b.c cVar) {
        if (!f818c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (cVar.f590a || this.e == 0) {
            this.h.remove(cVar);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }
}
