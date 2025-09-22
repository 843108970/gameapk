package com.bumptech.glide.load.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1321a = 128;

    /* renamed from: b  reason: collision with root package name */
    private static final File f1322b = new File("/proc/self/fd");

    /* renamed from: c  reason: collision with root package name */
    private static final int f1323c = 50;
    private static final int d = 700;
    private static volatile t g;
    private volatile int e;
    private volatile boolean f = true;

    private t() {
    }

    static t a() {
        if (g == null) {
            synchronized (t.class) {
                if (g == null) {
                    g = new t();
                }
            }
        }
        return g;
    }

    @TargetApi(26)
    private boolean a(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean b() {
        int i = this.e + 1;
        this.e = i;
        if (i >= 50) {
            boolean z = false;
            this.e = 0;
            int length = f1322b.list().length;
            if (length < d) {
                z = true;
            }
            this.f = z;
            if (!this.f && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f;
    }
}
