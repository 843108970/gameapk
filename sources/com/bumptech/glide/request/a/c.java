package com.bumptech.glide.request.a;

import android.graphics.drawable.Drawable;

public final class c implements g<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f1441a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1442b;

    /* renamed from: c  reason: collision with root package name */
    private d f1443c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final int f1444a = 300;

        /* renamed from: b  reason: collision with root package name */
        private final int f1445b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1446c;

        public a() {
            this(f1444a);
        }

        public a(int i) {
            this.f1445b = i;
        }

        private a a(boolean z) {
            this.f1446c = z;
            return this;
        }

        public final c a() {
            return new c(this.f1445b, this.f1446c);
        }
    }

    protected c(int i, boolean z) {
        this.f1441a = i;
        this.f1442b = z;
    }

    private f<Drawable> a() {
        if (this.f1443c == null) {
            this.f1443c = new d(this.f1441a, this.f1442b);
        }
        return this.f1443c;
    }

    public final f<Drawable> a(com.bumptech.glide.load.a aVar, boolean z) {
        if (aVar == com.bumptech.glide.load.a.MEMORY_CACHE) {
            return e.b();
        }
        if (this.f1443c == null) {
            this.f1443c = new d(this.f1441a, this.f1442b);
        }
        return this.f1443c;
    }
}
