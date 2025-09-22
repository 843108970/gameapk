package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.b.o;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class a {
    private static final int h = 1;

    /* renamed from: a  reason: collision with root package name */
    final Handler f1007a = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            a.this.a((b) message.obj);
            return true;
        }
    });
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public final Map<g, b> f1008b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    o.a f1009c;
    @Nullable
    ReferenceQueue<o<?>> d;
    @Nullable
    public Thread e;
    public volatile boolean f;
    @Nullable
    volatile C0011a g;
    private final boolean i;

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.b.a$a  reason: collision with other inner class name */
    interface C0011a {
        void a();
    }

    @VisibleForTesting
    static final class b extends WeakReference<o<?>> {

        /* renamed from: a  reason: collision with root package name */
        final g f1012a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f1013b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        u<?> f1014c;

        b(@NonNull g gVar, @NonNull o<?> oVar, @NonNull ReferenceQueue<? super o<?>> referenceQueue, boolean z) {
            super(oVar, referenceQueue);
            this.f1012a = (g) i.a(gVar, "Argument must not be null");
            this.f1014c = (!oVar.f1164a || !z) ? null : (u) i.a(oVar.f1165b, "Argument must not be null");
            this.f1013b = oVar.f1164a;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f1014c = null;
            clear();
        }
    }

    a(boolean z) {
        this.i = z;
    }

    private ReferenceQueue<o<?>> a() {
        if (this.d == null) {
            this.d = new ReferenceQueue<>();
            this.e = new Thread(new Runnable() {
                public final void run() {
                    Process.setThreadPriority(10);
                    a aVar = a.this;
                    while (!aVar.f) {
                        try {
                            aVar.f1007a.obtainMessage(1, (b) aVar.d.remove()).sendToTarget();
                            C0011a aVar2 = aVar.g;
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }, "glide-active-resources");
            this.e.start();
        }
        return this.d;
    }

    @VisibleForTesting
    private void a(C0011a aVar) {
        this.g = aVar;
    }

    private void a(o.a aVar) {
        this.f1009c = aVar;
    }

    private void a(g gVar) {
        b remove = this.f1008b.remove(gVar);
        if (remove != null) {
            remove.a();
        }
    }

    @Nullable
    private o<?> b(g gVar) {
        b bVar = this.f1008b.get(gVar);
        if (bVar == null) {
            return null;
        }
        o<?> oVar = (o) bVar.get();
        if (oVar == null) {
            a(bVar);
        }
        return oVar;
    }

    private void b() {
        while (!this.f) {
            try {
                this.f1007a.obtainMessage(1, (b) this.d.remove()).sendToTarget();
                C0011a aVar = this.g;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @VisibleForTesting
    private void c() {
        this.f = true;
        if (this.e != null) {
            this.e.interrupt();
            try {
                this.e.join(TimeUnit.SECONDS.toMillis(5));
                if (this.e.isAlive()) {
                    throw new RuntimeException("Failed to join in time");
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final void a(@NonNull b bVar) {
        k.a();
        this.f1008b.remove(bVar.f1012a);
        if (bVar.f1013b && bVar.f1014c != null) {
            o oVar = new o(bVar.f1014c, true, false);
            oVar.a(bVar.f1012a, this.f1009c);
            this.f1009c.a(bVar.f1012a, oVar);
        }
    }

    public final void a(g gVar, o<?> oVar) {
        if (this.d == null) {
            this.d = new ReferenceQueue<>();
            this.e = new Thread(new Runnable() {
                public final void run() {
                    Process.setThreadPriority(10);
                    a aVar = a.this;
                    while (!aVar.f) {
                        try {
                            aVar.f1007a.obtainMessage(1, (b) aVar.d.remove()).sendToTarget();
                            C0011a aVar2 = aVar.g;
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }, "glide-active-resources");
            this.e.start();
        }
        b put = this.f1008b.put(gVar, new b(gVar, oVar, this.d, this.i));
        if (put != null) {
            put.a();
        }
    }
}
