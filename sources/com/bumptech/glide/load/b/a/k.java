package com.bumptech.glide.load.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1035a = "LruBitmapPool";

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config f1036b = Bitmap.Config.ARGB_8888;

    /* renamed from: c  reason: collision with root package name */
    private final l f1037c;
    private final Set<Bitmap.Config> d;
    private final long e;
    private final a f;
    private long g;
    private long h;
    private int i;
    private int j;
    private int k;
    private int l;

    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static final class b implements a {
        b() {
        }

        public final void a(Bitmap bitmap) {
        }

        public final void b(Bitmap bitmap) {
        }
    }

    private static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Bitmap> f1038a = Collections.synchronizedSet(new HashSet());

        private c() {
        }

        public final void a(Bitmap bitmap) {
            if (this.f1038a.contains(bitmap)) {
                throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
            }
            this.f1038a.add(bitmap);
        }

        public final void b(Bitmap bitmap) {
            if (!this.f1038a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.f1038a.remove(bitmap);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k(long r5) {
        /*
            r4 = this;
            com.bumptech.glide.load.b.a.l r0 = f()
            java.util.HashSet r1 = new java.util.HashSet
            android.graphics.Bitmap$Config[] r2 = android.graphics.Bitmap.Config.values()
            java.util.List r2 = java.util.Arrays.asList(r2)
            r1.<init>(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            if (r2 < r3) goto L_0x001b
            r2 = 0
            r1.add(r2)
        L_0x001b:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 < r3) goto L_0x0026
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.HARDWARE
            r1.remove(r2)
        L_0x0026:
            java.util.Set r1 = java.util.Collections.unmodifiableSet(r1)
            r4.<init>(r5, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.k.<init>(long):void");
    }

    private k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.e = j2;
        this.g = j2;
        this.f1037c = lVar;
        this.d = set;
        this.f = new b();
    }

    private k(long j2, Set<Bitmap.Config> set) {
        this(j2, f(), set);
    }

    private synchronized void a(long j2) {
        while (this.h > j2) {
            Bitmap a2 = this.f1037c.a();
            if (a2 == null) {
                if (Log.isLoggable(f1035a, 5)) {
                    Log.w(f1035a, "Size mismatch, resetting");
                    e();
                }
                this.h = 0;
                return;
            }
            this.f.b(a2);
            this.h -= (long) this.f1037c.c(a2);
            this.l++;
            if (Log.isLoggable(f1035a, 3)) {
                Log.d(f1035a, "Evicting bitmap=" + this.f1037c.b(a2));
            }
            d();
            a2.recycle();
        }
    }

    @TargetApi(26)
    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static void b(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @NonNull
    private static Bitmap c(int i2, int i3, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f1036b;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void c() {
        a(this.g);
    }

    @TargetApi(19)
    private static void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Nullable
    private synchronized Bitmap d(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap a2;
        if (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.HARDWARE) {
            a2 = this.f1037c.a(i2, i3, config != null ? config : f1036b);
            if (a2 == null) {
                if (Log.isLoggable(f1035a, 3)) {
                    Log.d(f1035a, "Missing bitmap=" + this.f1037c.b(i2, i3, config));
                }
                this.j++;
            } else {
                this.i++;
                this.h -= (long) this.f1037c.c(a2);
                this.f.b(a2);
                a2.setHasAlpha(true);
                if (Build.VERSION.SDK_INT >= 19) {
                    a2.setPremultiplied(true);
                }
            }
            if (Log.isLoggable(f1035a, 2)) {
                Log.v(f1035a, "Get bitmap=" + this.f1037c.b(i2, i3, config));
            }
            d();
        } else {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
        return a2;
    }

    private void d() {
        if (Log.isLoggable(f1035a, 2)) {
            e();
        }
    }

    private void e() {
        Log.v(f1035a, "Hits=" + this.i + ", misses=" + this.j + ", puts=" + this.k + ", evictions=" + this.l + ", currentSize=" + this.h + ", maxSize=" + this.g + "\nStrategy=" + this.f1037c);
    }

    private static l f() {
        return Build.VERSION.SDK_INT >= 19 ? new o() : new c();
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> g() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add((Object) null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public final long a() {
        return this.g;
    }

    @NonNull
    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap d2 = d(i2, i3, config);
        if (d2 == null) {
            return c(i2, i3, config);
        }
        d2.eraseColor(0);
        return d2;
    }

    public final synchronized void a(float f2) {
        this.g = (long) Math.round(((float) this.e) * f2);
        c();
    }

    @SuppressLint({"InlinedApi"})
    public final void a(int i2) {
        if (Log.isLoggable(f1035a, 3)) {
            Log.d(f1035a, "trimMemory, level=" + i2);
        }
        if (i2 >= 40) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            a(this.g / 2);
        }
    }

    public final synchronized void a(Bitmap bitmap) {
        if (bitmap == null) {
            try {
                throw new NullPointerException("Bitmap must not be null");
            } catch (Throwable th) {
                throw th;
            }
        } else if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        } else {
            if (bitmap.isMutable() && ((long) this.f1037c.c(bitmap)) <= this.g) {
                if (this.d.contains(bitmap.getConfig())) {
                    int c2 = this.f1037c.c(bitmap);
                    this.f1037c.a(bitmap);
                    this.f.a(bitmap);
                    this.k++;
                    this.h += (long) c2;
                    if (Log.isLoggable(f1035a, 2)) {
                        Log.v(f1035a, "Put bitmap in pool=" + this.f1037c.b(bitmap));
                    }
                    d();
                    c();
                    return;
                }
            }
            if (Log.isLoggable(f1035a, 2)) {
                Log.v(f1035a, "Reject bitmap from pool, bitmap: " + this.f1037c.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.d.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        }
    }

    @NonNull
    public final Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap d2 = d(i2, i3, config);
        return d2 == null ? c(i2, i3, config) : d2;
    }

    public final void b() {
        if (Log.isLoggable(f1035a, 3)) {
            Log.d(f1035a, "clearMemory");
        }
        a(0);
    }
}
