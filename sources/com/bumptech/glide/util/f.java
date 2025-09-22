package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class f<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f1499a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f1500b;

    /* renamed from: c  reason: collision with root package name */
    private long f1501c;
    private long d;

    public f(long j) {
        this.f1500b = j;
        this.f1501c = j;
    }

    private synchronized int d() {
        return this.f1499a.size();
    }

    private synchronized boolean d(@NonNull T t) {
        return this.f1499a.containsKey(t);
    }

    private void e() {
        a(this.f1501c);
    }

    /* access modifiers changed from: protected */
    public int a(@Nullable Y y) {
        return 1;
    }

    public final synchronized long a() {
        return this.d;
    }

    public final synchronized void a(float f) {
        if (f < 0.0f) {
            try {
                throw new IllegalArgumentException("Multiplier must be >= 0");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            this.f1501c = (long) Math.round(((float) this.f1500b) * f);
            e();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void a(long j) {
        while (this.d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f1499a.entrySet().iterator();
            Map.Entry next = it.next();
            Object value = next.getValue();
            this.d -= (long) a(value);
            Object key = next.getKey();
            it.remove();
            a(key, value);
        }
    }

    public void a(@NonNull T t, @Nullable Y y) {
    }

    public final synchronized long b() {
        return this.f1501c;
    }

    @Nullable
    public final synchronized Y b(@NonNull T t) {
        return this.f1499a.get(t);
    }

    @Nullable
    public final synchronized Y b(@NonNull T t, @Nullable Y y) {
        long a2 = (long) a(y);
        if (a2 >= this.f1501c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.d += a2;
        }
        Y put = this.f1499a.put(t, y);
        if (put != null) {
            this.d -= (long) a(put);
            if (!put.equals(y)) {
                a(t, put);
            }
        }
        e();
        return put;
    }

    @Nullable
    public final synchronized Y c(@NonNull T t) {
        Y remove;
        remove = this.f1499a.remove(t);
        if (remove != null) {
            this.d -= (long) a(remove);
        }
        return remove;
    }

    public final void c() {
        a(0);
    }
}
