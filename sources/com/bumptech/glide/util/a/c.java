package com.bumptech.glide.util.a;

import android.support.annotation.NonNull;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f1488a = false;

    private static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private volatile RuntimeException f1489a;

        a() {
            super((byte) 0);
        }

        public final void a() {
            if (this.f1489a != null) {
                throw new IllegalStateException("Already released", this.f1489a);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(boolean z) {
            this.f1489a = z ? new RuntimeException("Released") : null;
        }
    }

    private static class b extends c {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f1490a;

        public b() {
            super((byte) 0);
        }

        public final void a() {
            if (this.f1490a) {
                throw new IllegalStateException("Already released");
            }
        }

        public final void a(boolean z) {
            this.f1490a = z;
        }
    }

    private c() {
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    @NonNull
    private static c b() {
        return new b();
    }

    public abstract void a();

    /* access modifiers changed from: package-private */
    public abstract void a(boolean z);
}
