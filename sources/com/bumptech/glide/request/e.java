package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.request.a.f;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.k;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class e<R> implements b<R>, f<R>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final a f1459a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1460b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1461c;
    private final int d;
    private final boolean e;
    private final a f;
    @Nullable
    private R g;
    @Nullable
    private c h;
    private boolean i;
    private boolean j;
    private boolean k;
    @Nullable
    private p l;

    @VisibleForTesting
    static class a {
        a() {
        }

        private static void a(Object obj) {
            obj.notifyAll();
        }

        private static void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public e(Handler handler, int i2, int i3) {
        this(handler, i2, i3, f1459a);
    }

    private e(Handler handler, int i2, int i3, a aVar) {
        this.f1460b = handler;
        this.f1461c = i2;
        this.d = i3;
        this.e = true;
        this.f = aVar;
    }

    private synchronized R a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.e && !isDone()) {
            k.b();
        }
        if (this.i) {
            throw new CancellationException();
        } else if (this.k) {
            throw new ExecutionException(this.l);
        } else if (this.j) {
            return this.g;
        } else {
            if (l2 == null) {
                wait(0);
            } else if (l2.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = currentTimeMillis + l2.longValue();
                while (!isDone() && currentTimeMillis < longValue) {
                    wait(longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.k) {
                throw new ExecutionException(this.l);
            } else if (this.i) {
                throw new CancellationException();
            } else if (!this.j) {
                throw new TimeoutException();
            } else {
                return this.g;
            }
        }
    }

    private void a() {
        this.f1460b.post(this);
    }

    public final synchronized boolean a(@Nullable p pVar, Object obj, Target<R> target, boolean z) {
        this.k = true;
        this.l = pVar;
        notifyAll();
        return false;
    }

    public final synchronized boolean a(R r, Object obj, Target<R> target, com.bumptech.glide.load.a aVar, boolean z) {
        this.j = true;
        this.g = r;
        notifyAll();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean cancel(boolean r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDone()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000a
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000a:
            r0 = 1
            r1.i = r0     // Catch:{ all -> 0x0019 }
            r1.notifyAll()     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x0017
            android.os.Handler r2 = r1.f1460b     // Catch:{ all -> 0x0019 }
            r2.post(r1)     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return r0
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.e.cancel(boolean):boolean");
    }

    public final R get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public final R get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }

    @Nullable
    public final c getRequest() {
        return this.h;
    }

    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.f1461c, this.d);
    }

    public final synchronized boolean isCancelled() {
        return this.i;
    }

    public final synchronized boolean isDone() {
        return this.i || this.j || this.k;
    }

    public final void onDestroy() {
    }

    public final void onLoadCleared(@Nullable Drawable drawable) {
    }

    public final synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    public final void onLoadStarted(@Nullable Drawable drawable) {
    }

    public final synchronized void onResourceReady(@NonNull R r, @Nullable f<? super R> fVar) {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public final void run() {
        if (this.h != null) {
            this.h.b();
            this.h = null;
        }
    }

    public final void setRequest(@Nullable c cVar) {
        this.h = cVar;
    }
}
