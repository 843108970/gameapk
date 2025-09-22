package com.b.a;

import android.support.v7.widget.ActivityChooserView;
import com.b.a.a.c;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private int f832a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f833b = 5;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f834c;
    private ExecutorService d;
    private final Deque<an> e = new ArrayDeque();
    private final Deque<an> f = new ArrayDeque();
    private final Deque<am> g = new ArrayDeque();

    private synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int c2;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                b();
            }
            c2 = c();
            runnable = this.f834c;
        }
        if (c2 == 0 && runnable != null) {
            runnable.run();
        }
    }

    private void b() {
        if (this.f.size() < this.f832a && !this.e.isEmpty()) {
            Iterator<an> it = this.e.iterator();
            while (it.hasNext()) {
                an next = it.next();
                if (c(next) < this.f833b) {
                    it.remove();
                    this.f.add(next);
                    a().execute(next);
                }
                if (this.f.size() >= this.f832a) {
                    return;
                }
            }
        }
    }

    private synchronized int c() {
        return this.f.size() + this.g.size();
    }

    private int c(an anVar) {
        int i = 0;
        for (an a2 : this.f) {
            if (a2.a().equals(anVar.a())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(am amVar) {
        this.g.add(amVar);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(an anVar) {
        if (this.f.size() >= this.f832a || c(anVar) >= this.f833b) {
            this.e.add(anVar);
            return;
        }
        this.f.add(anVar);
        a().execute(anVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(am amVar) {
        a(this.g, amVar, false);
    }

    /* access modifiers changed from: package-private */
    public final void b(an anVar) {
        a(this.f, anVar, true);
    }
}
