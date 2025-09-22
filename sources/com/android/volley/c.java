package com.android.volley;

import android.os.Process;
import com.android.volley.b;
import java.util.concurrent.BlockingQueue;

public final class c extends Thread {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f466b = t.f504b;

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f467a = false;

    /* renamed from: c  reason: collision with root package name */
    private final BlockingQueue<l<?>> f468c;
    /* access modifiers changed from: private */
    public final BlockingQueue<l<?>> d;
    private final b e;
    private final o f;

    public c(BlockingQueue<l<?>> blockingQueue, BlockingQueue<l<?>> blockingQueue2, b bVar, o oVar) {
        this.f468c = blockingQueue;
        this.d = blockingQueue2;
        this.e = bVar;
        this.f = oVar;
    }

    private void a() {
        this.f467a = true;
        interrupt();
    }

    public final void run() {
        if (f466b) {
            t.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.e.a();
        while (true) {
            try {
                final l take = this.f468c.take();
                take.a("cache-queue-take");
                if (take.a()) {
                    take.b("cache-discard-canceled");
                } else {
                    b.a a2 = this.e.a(take.f487b);
                    if (a2 == null) {
                        take.a("cache-miss");
                    } else {
                        if (a2.e < System.currentTimeMillis()) {
                            take.a("cache-hit-expired");
                            take.k = a2;
                        } else {
                            take.a("cache-hit");
                            n a3 = take.a(new i(a2.f463a, a2.g));
                            take.a("cache-hit-parsed");
                            if (!(a2.f < System.currentTimeMillis())) {
                                this.f.a((l<?>) take, (n<?>) a3);
                            } else {
                                take.a("cache-hit-refresh-needed");
                                take.k = a2;
                                a3.d = true;
                                this.f.a(take, a3, new Runnable() {
                                    public final void run() {
                                        try {
                                            c.this.d.put(take);
                                        } catch (InterruptedException unused) {
                                        }
                                    }
                                });
                            }
                        }
                    }
                    this.d.put(take);
                }
            } catch (InterruptedException unused) {
                if (this.f467a) {
                    return;
                }
            }
        }
    }
}
