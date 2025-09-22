package b;

import android.support.v7.widget.ActivityChooserView;
import b.a.c;
import b.ab;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private int f336a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f337b = 5;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Runnable f338c;
    @Nullable
    private ExecutorService d;
    private final Deque<ab.a> e = new ArrayDeque();
    private final Deque<ab.a> f = new ArrayDeque();
    private final Deque<ab> g = new ArrayDeque();

    public p() {
    }

    private p(ExecutorService executorService) {
        this.d = executorService;
    }

    private synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    private synchronized void a(@Nullable Runnable runnable) {
        this.f338c = runnable;
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int i;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                e();
            }
            i = i();
            runnable = this.f338c;
        }
        if (i == 0 && runnable != null) {
            runnable.run();
        }
    }

    private synchronized int b() {
        return this.f336a;
    }

    private synchronized void b(int i) {
        if (i <= 0) {
            try {
                throw new IllegalArgumentException("max < 1: " + i);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            this.f337b = i;
            e();
        }
    }

    private synchronized int c() {
        return this.f337b;
    }

    private int c(ab.a aVar) {
        int i = 0;
        for (ab.a a2 : this.f) {
            if (a2.a().equals(aVar.a())) {
                i++;
            }
        }
        return i;
    }

    private synchronized void d() {
        for (ab.a aVar : this.e) {
            ab.this.c();
        }
        for (ab.a aVar2 : this.f) {
            ab.this.c();
        }
        for (ab c2 : this.g) {
            c2.c();
        }
    }

    private void e() {
        if (this.f.size() < this.f336a && !this.e.isEmpty()) {
            Iterator<ab.a> it = this.e.iterator();
            while (it.hasNext()) {
                ab.a next = it.next();
                if (c(next) < this.f337b) {
                    it.remove();
                    this.f.add(next);
                    a().execute(next);
                }
                if (this.f.size() >= this.f336a) {
                    return;
                }
            }
        }
    }

    private synchronized List<e> f() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (ab.a aVar : this.e) {
            arrayList.add(ab.this);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized List<e> g() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.g);
        for (ab.a aVar : this.f) {
            arrayList.add(ab.this);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized int h() {
        return this.e.size();
    }

    private synchronized int i() {
        return this.f.size() + this.g.size();
    }

    public final synchronized void a(int i) {
        if (i <= 0) {
            try {
                throw new IllegalArgumentException("max < 1: " + i);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            this.f336a = i;
            e();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(ab.a aVar) {
        if (this.f.size() >= this.f336a || c(aVar) >= this.f337b) {
            this.e.add(aVar);
            return;
        }
        this.f.add(aVar);
        a().execute(aVar);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(ab abVar) {
        this.g.add(abVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(ab.a aVar) {
        a(this.f, aVar, true);
    }

    /* access modifiers changed from: package-private */
    public final void b(ab abVar) {
        a(this.g, abVar, false);
    }
}
