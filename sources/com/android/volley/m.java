package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class m {
    private static final int g = 4;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Queue<l<?>>> f495a;

    /* renamed from: b  reason: collision with root package name */
    final Set<l<?>> f496b;

    /* renamed from: c  reason: collision with root package name */
    final PriorityBlockingQueue<l<?>> f497c;
    List<b> d;
    private AtomicInteger e;
    private final PriorityBlockingQueue<l<?>> f;
    private final b h;
    private final f i;
    private final o j;
    private g[] k;
    private c l;

    public interface a {
        boolean a(l<?> lVar);
    }

    public interface b<T> {
        void a();
    }

    private m(b bVar, f fVar) {
        this(bVar, fVar, (o) new e(new Handler(Looper.getMainLooper())));
    }

    public m(b bVar, f fVar, byte b2) {
        this(bVar, fVar);
    }

    private m(b bVar, f fVar, o oVar) {
        this.e = new AtomicInteger();
        this.f495a = new HashMap();
        this.f496b = new HashSet();
        this.f497c = new PriorityBlockingQueue<>();
        this.f = new PriorityBlockingQueue<>();
        this.d = new ArrayList();
        this.h = bVar;
        this.i = fVar;
        this.k = new g[4];
        this.j = oVar;
    }

    private void a(a aVar) {
        synchronized (this.f496b) {
            for (l next : this.f496b) {
                if (aVar.a(next)) {
                    next.h = true;
                }
            }
        }
    }

    private <T> void a(b<T> bVar) {
        synchronized (this.d) {
            this.d.add(bVar);
        }
    }

    private void b() {
        if (this.l != null) {
            c cVar = this.l;
            cVar.f467a = true;
            cVar.interrupt();
        }
        for (int i2 = 0; i2 < this.k.length; i2++) {
            if (this.k[i2] != null) {
                g gVar = this.k[i2];
                gVar.f480a = true;
                gVar.interrupt();
            }
        }
    }

    private <T> void b(l<T> lVar) {
        synchronized (this.f496b) {
            this.f496b.remove(lVar);
        }
        synchronized (this.d) {
            Iterator<b> it = this.d.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (lVar.g) {
            synchronized (this.f495a) {
                String str = lVar.f487b;
                Queue remove = this.f495a.remove(str);
                if (remove != null) {
                    if (t.f504b) {
                        t.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), str);
                    }
                    this.f497c.addAll(remove);
                }
            }
        }
    }

    private <T> void b(b<T> bVar) {
        synchronized (this.d) {
            this.d.remove(bVar);
        }
    }

    private int c() {
        return this.e.incrementAndGet();
    }

    private b d() {
        return this.h;
    }

    public final <T> l<T> a(l<T> lVar) {
        lVar.f = this;
        synchronized (this.f496b) {
            this.f496b.add(lVar);
        }
        lVar.e = Integer.valueOf(this.e.incrementAndGet());
        lVar.a("add-to-queue");
        if (!lVar.g) {
            this.f.add(lVar);
            return lVar;
        }
        synchronized (this.f495a) {
            String str = lVar.f487b;
            if (this.f495a.containsKey(str)) {
                Queue queue = this.f495a.get(str);
                if (queue == null) {
                    queue = new LinkedList();
                }
                queue.add(lVar);
                this.f495a.put(str, queue);
                if (t.f504b) {
                    t.a("Request for cacheKey=%s is in flight, putting on hold.", str);
                }
            } else {
                this.f495a.put(str, (Object) null);
                this.f497c.add(lVar);
            }
        }
        return lVar;
    }

    public final void a() {
        if (this.l != null) {
            c cVar = this.l;
            cVar.f467a = true;
            cVar.interrupt();
        }
        for (int i2 = 0; i2 < this.k.length; i2++) {
            if (this.k[i2] != null) {
                g gVar = this.k[i2];
                gVar.f480a = true;
                gVar.interrupt();
            }
        }
        this.l = new c(this.f497c, this.f, this.h, this.j);
        this.l.start();
        for (int i3 = 0; i3 < this.k.length; i3++) {
            g gVar2 = new g(this.f, this.i, this.h, this.j);
            this.k[i3] = gVar2;
            gVar2.start();
        }
    }

    public final void a(final Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        a((a) new a() {
            public final boolean a(l<?> lVar) {
                return lVar.l == obj;
            }
        });
    }
}
