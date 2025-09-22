package com.bumptech.glide.load.b.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.b.j;
import com.bumptech.glide.load.d.a.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.k;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class a implements Runnable {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final String f1107a = "PreFillRunner";

    /* renamed from: b  reason: collision with root package name */
    static final long f1108b = 32;

    /* renamed from: c  reason: collision with root package name */
    static final long f1109c = 40;
    static final int d = 4;
    static final long e = TimeUnit.SECONDS.toMillis(1);
    private static final C0014a g = new C0014a();
    public boolean f;
    private final e h;
    private final j i;
    private final c j;
    private final C0014a k;
    private final Set<d> l;
    private final Handler m;
    private long n;

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.b.d.a$a  reason: collision with other inner class name */
    static class C0014a {
        C0014a() {
        }

        private static long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    private static final class b implements g {
        b() {
        }

        public final void a(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public a(e eVar, j jVar, c cVar) {
        this(eVar, jVar, cVar, g, new Handler(Looper.getMainLooper()));
    }

    @VisibleForTesting
    private a(e eVar, j jVar, c cVar, C0014a aVar, Handler handler) {
        this.l = new HashSet();
        this.n = f1109c;
        this.h = eVar;
        this.i = jVar;
        this.j = cVar;
        this.k = aVar;
        this.m = handler;
    }

    private void a() {
        this.f = true;
    }

    private static boolean a(long j2) {
        return SystemClock.currentThreadTimeMillis() - j2 >= 32;
    }

    @VisibleForTesting
    private boolean b() {
        Bitmap bitmap;
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        while (true) {
            int i2 = 0;
            if (!this.j.a()) {
                if (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis >= 32) {
                    break;
                }
                c cVar = this.j;
                d dVar = cVar.f1114b.get(cVar.d);
                Integer num = cVar.f1113a.get(dVar);
                if (num.intValue() == 1) {
                    cVar.f1113a.remove(dVar);
                    cVar.f1114b.remove(cVar.d);
                } else {
                    cVar.f1113a.put(dVar, Integer.valueOf(num.intValue() - 1));
                }
                cVar.f1115c--;
                if (!cVar.f1114b.isEmpty()) {
                    i2 = (cVar.d + 1) % cVar.f1114b.size();
                }
                cVar.d = i2;
                if (!this.l.contains(dVar)) {
                    this.l.add(dVar);
                    bitmap = this.h.b(dVar.f1117b, dVar.f1118c, dVar.d);
                } else {
                    bitmap = Bitmap.createBitmap(dVar.f1117b, dVar.f1118c, dVar.d);
                }
                int a2 = k.a(bitmap);
                if (this.i.b() - this.i.a() >= ((long) a2)) {
                    this.i.a(new b(), f.a(bitmap, this.h));
                } else {
                    this.h.a(bitmap);
                }
                if (Log.isLoggable(f1107a, 3)) {
                    Log.d(f1107a, "allocated [" + dVar.f1117b + "x" + dVar.f1118c + "] " + dVar.d + " size: " + a2);
                }
            } else {
                break;
            }
        }
        return !this.f && !this.j.a();
    }

    private long c() {
        return this.i.b() - this.i.a();
    }

    private long d() {
        long j2 = this.n;
        this.n = Math.min(this.n * 4, e);
        return j2;
    }

    public final void run() {
        int i2;
        Bitmap bitmap;
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        while (true) {
            i2 = 0;
            if (!this.j.a()) {
                if (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis >= 32) {
                    break;
                }
                c cVar = this.j;
                d dVar = cVar.f1114b.get(cVar.d);
                Integer num = cVar.f1113a.get(dVar);
                if (num.intValue() == 1) {
                    cVar.f1113a.remove(dVar);
                    cVar.f1114b.remove(cVar.d);
                } else {
                    cVar.f1113a.put(dVar, Integer.valueOf(num.intValue() - 1));
                }
                cVar.f1115c--;
                if (!cVar.f1114b.isEmpty()) {
                    i2 = (cVar.d + 1) % cVar.f1114b.size();
                }
                cVar.d = i2;
                if (!this.l.contains(dVar)) {
                    this.l.add(dVar);
                    bitmap = this.h.b(dVar.f1117b, dVar.f1118c, dVar.d);
                } else {
                    bitmap = Bitmap.createBitmap(dVar.f1117b, dVar.f1118c, dVar.d);
                }
                int a2 = k.a(bitmap);
                if (this.i.b() - this.i.a() >= ((long) a2)) {
                    this.i.a(new b(), f.a(bitmap, this.h));
                } else {
                    this.h.a(bitmap);
                }
                if (Log.isLoggable(f1107a, 3)) {
                    Log.d(f1107a, "allocated [" + dVar.f1117b + "x" + dVar.f1118c + "] " + dVar.d + " size: " + a2);
                }
            } else {
                break;
            }
        }
        if (!this.f && !this.j.a()) {
            i2 = 1;
        }
        if (i2 != 0) {
            Handler handler = this.m;
            long j2 = this.n;
            this.n = Math.min(this.n * 4, e);
            handler.postDelayed(this, j2);
        }
    }
}
