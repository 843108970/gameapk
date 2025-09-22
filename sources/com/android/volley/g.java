package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f480a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<l<?>> f481b;

    /* renamed from: c  reason: collision with root package name */
    private final f f482c;
    private final b d;
    private final o e;

    public g(BlockingQueue<l<?>> blockingQueue, f fVar, b bVar, o oVar) {
        this.f481b = blockingQueue;
        this.f482c = fVar;
        this.d = bVar;
        this.e = oVar;
    }

    private void a() {
        this.f480a = true;
        interrupt();
    }

    @TargetApi(14)
    private static void a(l<?> lVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(lVar.f488c);
        }
    }

    private void a(l<?> lVar, s sVar) {
        this.e.a(lVar, l.a(sVar));
    }

    public final void run() {
        String str;
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                l take = this.f481b.take();
                try {
                    take.a("network-queue-take");
                    if (take.a()) {
                        str = "network-discard-cancelled";
                    } else {
                        if (Build.VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(take.f488c);
                        }
                        i a2 = this.f482c.a(take);
                        take.a("network-http-complete");
                        if (!a2.d || !take.i) {
                            n a3 = take.a(a2);
                            take.a("network-parse-complete");
                            if (take.g && a3.f501b != null) {
                                this.d.a(take.f487b, a3.f501b);
                                take.a("network-cache-written");
                            }
                            take.i = true;
                            this.e.a((l<?>) take, (n<?>) a3);
                        } else {
                            str = "not-modified";
                        }
                    }
                    take.b(str);
                } catch (s e2) {
                    e2.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.e.a((l<?>) take, l.a(e2));
                } catch (Exception e3) {
                    t.a(e3, "Unhandled exception %s", e3.toString());
                    s sVar = new s((Throwable) e3);
                    sVar.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.e.a((l<?>) take, sVar);
                }
            } catch (InterruptedException unused) {
                if (this.f480a) {
                    return;
                }
            }
        }
    }
}
