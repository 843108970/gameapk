package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.k;

final class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f1016a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f1017b = new h<>();

    @VisibleForTesting
    static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f1018a;

        /* renamed from: b  reason: collision with root package name */
        int f1019b;

        /* renamed from: c  reason: collision with root package name */
        Bitmap.Config f1020c;
        private final b d;

        public a(b bVar) {
            this.d = bVar;
        }

        private void a(int i, int i2, Bitmap.Config config) {
            this.f1018a = i;
            this.f1019b = i2;
            this.f1020c = config;
        }

        public final void a() {
            this.d.a(this);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f1018a == aVar.f1018a && this.f1019b == aVar.f1019b && this.f1020c == aVar.f1020c;
            }
        }

        public final int hashCode() {
            return (((this.f1018a * 31) + this.f1019b) * 31) + (this.f1020c != null ? this.f1020c.hashCode() : 0);
        }

        public final String toString() {
            return c.c(this.f1018a, this.f1019b, this.f1020c);
        }
    }

    @VisibleForTesting
    static class b extends d<a> {
        b() {
        }

        private a c() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        public final a a(int i, int i2, Bitmap.Config config) {
            a aVar = (a) b();
            aVar.f1018a = i;
            aVar.f1019b = i2;
            aVar.f1020c = config;
            return aVar;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ m a() {
            return new a(this);
        }
    }

    c() {
    }

    static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public final Bitmap a() {
        return this.f1017b.a();
    }

    public final Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f1017b.a(this.f1016a.a(i, i2, config));
    }

    public final void a(Bitmap bitmap) {
        this.f1017b.a(this.f1016a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public final String b(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
    }

    public final String b(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public final int c(Bitmap bitmap) {
        return k.a(bitmap);
    }

    public final String toString() {
        return "AttributeStrategy:\n  " + this.f1017b;
    }
}
