package com.android.volley.toolbox;

import com.android.volley.l;
import com.android.volley.n;
import com.android.volley.s;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class r<T> implements n.a, n.b<T>, Future<T> {

    /* renamed from: a  reason: collision with root package name */
    private l<?> f559a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f560b = false;

    /* renamed from: c  reason: collision with root package name */
    private T f561c;
    private s d;

    private r() {
    }

    private static <E> r<E> a() {
        return new r<>();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized T a(java.lang.Long r6) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r5 = this;
            monitor-enter(r5)
            com.android.volley.s r0 = r5.d     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x000d
            java.util.concurrent.ExecutionException r6 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x0044 }
            com.android.volley.s r0 = r5.d     // Catch:{ all -> 0x0044 }
            r6.<init>(r0)     // Catch:{ all -> 0x0044 }
            throw r6     // Catch:{ all -> 0x0044 }
        L_0x000d:
            boolean r0 = r5.f560b     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0015
            T r6 = r5.f561c     // Catch:{ all -> 0x0044 }
            monitor-exit(r5)
            return r6
        L_0x0015:
            r0 = 0
            if (r6 != 0) goto L_0x001d
        L_0x0019:
            r5.wait(r0)     // Catch:{ all -> 0x0044 }
            goto L_0x002a
        L_0x001d:
            long r2 = r6.longValue()     // Catch:{ all -> 0x0044 }
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x002a
            long r0 = r6.longValue()     // Catch:{ all -> 0x0044 }
            goto L_0x0019
        L_0x002a:
            com.android.volley.s r6 = r5.d     // Catch:{ all -> 0x0044 }
            if (r6 == 0) goto L_0x0036
            java.util.concurrent.ExecutionException r6 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x0044 }
            com.android.volley.s r0 = r5.d     // Catch:{ all -> 0x0044 }
            r6.<init>(r0)     // Catch:{ all -> 0x0044 }
            throw r6     // Catch:{ all -> 0x0044 }
        L_0x0036:
            boolean r6 = r5.f560b     // Catch:{ all -> 0x0044 }
            if (r6 != 0) goto L_0x0040
            java.util.concurrent.TimeoutException r6 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0044 }
            r6.<init>()     // Catch:{ all -> 0x0044 }
            throw r6     // Catch:{ all -> 0x0044 }
        L_0x0040:
            T r6 = r5.f561c     // Catch:{ all -> 0x0044 }
            monitor-exit(r5)
            return r6
        L_0x0044:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.r.a(java.lang.Long):java.lang.Object");
    }

    private void a(l<?> lVar) {
        this.f559a = lVar;
    }

    public final synchronized void a(s sVar) {
        this.d = sVar;
        notifyAll();
    }

    public final synchronized void a(T t) {
        this.f560b = true;
        this.f561c = t;
        notifyAll();
    }

    public final synchronized boolean cancel(boolean z) {
        if (this.f559a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f559a.h = true;
        return true;
    }

    public final T get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    public final boolean isCancelled() {
        if (this.f559a == null) {
            return false;
        }
        return this.f559a.a();
    }

    public final synchronized boolean isDone() {
        return this.f560b || this.d != null || isCancelled();
    }
}
