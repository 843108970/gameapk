package com.bumptech.glide.load.b.d;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.i;

public final class d {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final Bitmap.Config f1116a = Bitmap.Config.RGB_565;

    /* renamed from: b  reason: collision with root package name */
    public final int f1117b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1118c;
    public final Bitmap.Config d;
    public final int e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f1119a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1120b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap.Config f1121c;
        public int d;

        private a(int i) {
            this(i, i);
        }

        private a(int i, int i2) {
            this.d = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            } else if (i2 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            } else {
                this.f1119a = i;
                this.f1120b = i2;
            }
        }

        private Bitmap.Config a() {
            return this.f1121c;
        }

        private a a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.d = i;
            return this;
        }

        private a a(@Nullable Bitmap.Config config) {
            this.f1121c = config;
            return this;
        }

        private d b() {
            return new d(this.f1119a, this.f1120b, this.f1121c, this.d);
        }
    }

    public d(int i, int i2, Bitmap.Config config, int i3) {
        this.d = (Bitmap.Config) i.a(config, "Config must not be null");
        this.f1117b = i;
        this.f1118c = i2;
        this.e = i3;
    }

    private int a() {
        return this.f1117b;
    }

    private int b() {
        return this.f1118c;
    }

    private Bitmap.Config c() {
        return this.d;
    }

    private int d() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f1118c == dVar.f1118c && this.f1117b == dVar.f1117b && this.e == dVar.e && this.d == dVar.d;
        }
    }

    public final int hashCode() {
        return (((((this.f1117b * 31) + this.f1118c) * 31) + this.d.hashCode()) * 31) + this.e;
    }

    public final String toString() {
        return "PreFillSize{width=" + this.f1117b + ", height=" + this.f1118c + ", config=" + this.d + ", weight=" + this.e + '}';
    }
}
