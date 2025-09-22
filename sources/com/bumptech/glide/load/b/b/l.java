package com.bumptech.glide.load.b.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.VisibleForTesting;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.i;

public final class l {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final int f1077a = 4;
    private static final String e = "MemorySizeCalculator";
    private static final int f = 2;

    /* renamed from: b  reason: collision with root package name */
    public final int f1078b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1079c;
    public final int d;
    private final Context g;

    public static final class a {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        static final int f1080a = 2;

        /* renamed from: b  reason: collision with root package name */
        static final int f1081b = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: c  reason: collision with root package name */
        static final float f1082c = 0.4f;
        static final float d = 0.33f;
        static final int e = 4194304;
        final Context f;
        ActivityManager g;
        c h;
        float i = 2.0f;
        float j = ((float) f1081b);
        float k = f1082c;
        float l = d;
        int m = 4194304;

        public a(Context context) {
            this.f = context;
            this.g = (ActivityManager) context.getSystemService("activity");
            this.h = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && l.a(this.g)) {
                this.j = 0.0f;
            }
        }

        private a a(float f2) {
            i.a(f2 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.i = f2;
            return this;
        }

        private a a(int i2) {
            this.m = i2;
            return this;
        }

        @VisibleForTesting
        private a a(ActivityManager activityManager) {
            this.g = activityManager;
            return this;
        }

        @VisibleForTesting
        private a a(c cVar) {
            this.h = cVar;
            return this;
        }

        private a b(float f2) {
            i.a(f2 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.j = f2;
            return this;
        }

        private a c(float f2) {
            i.a(f2 >= 0.0f && f2 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.k = f2;
            return this;
        }

        private a d(float f2) {
            i.a(f2 >= 0.0f && f2 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.l = f2;
            return this;
        }

        public final l a() {
            return new l(this);
        }
    }

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f1083a;

        b(DisplayMetrics displayMetrics) {
            this.f1083a = displayMetrics;
        }

        public final int a() {
            return this.f1083a.widthPixels;
        }

        public final int b() {
            return this.f1083a.heightPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    l(a aVar) {
        this.g = aVar.f;
        this.d = a(aVar.g) ? aVar.m / 2 : aVar.m;
        ActivityManager activityManager = aVar.g;
        float f2 = aVar.k;
        int round = Math.round(((float) (activityManager.getMemoryClass() * 1024 * 1024)) * (a(activityManager) ? aVar.l : f2));
        float a2 = (float) (aVar.h.a() * aVar.h.b() * 4);
        int round2 = Math.round(aVar.j * a2);
        int round3 = Math.round(a2 * aVar.i);
        int i = round - this.d;
        int i2 = round3 + round2;
        if (i2 <= i) {
            this.f1079c = round3;
            this.f1078b = round2;
        } else {
            float f3 = ((float) i) / (aVar.j + aVar.i);
            this.f1079c = Math.round(aVar.i * f3);
            this.f1078b = Math.round(f3 * aVar.j);
        }
        if (Log.isLoggable(e, 3)) {
            StringBuilder sb = new StringBuilder("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f1079c));
            sb.append(", pool size: ");
            sb.append(a(this.f1078b));
            sb.append(", byte array size: ");
            sb.append(a(this.d));
            sb.append(", memory class limited? ");
            sb.append(i2 > round);
            sb.append(", max size: ");
            sb.append(a(round));
            sb.append(", memoryClass: ");
            sb.append(aVar.g.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.g));
            Log.d(e, sb.toString());
        }
    }

    private int a() {
        return this.f1079c;
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        boolean a2 = a(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (a2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.g, (long) i);
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private int b() {
        return this.f1078b;
    }

    private int c() {
        return this.d;
    }
}
