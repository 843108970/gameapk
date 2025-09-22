package com.b.a.a.a;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    final h f579a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f580b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f581c;

    public final void a() {
        synchronized (this.f580b) {
            if (this.f581c) {
                throw new IllegalStateException();
            }
            if (this.f579a.f == this) {
                this.f580b.a(this);
            }
            this.f581c = true;
        }
    }
}
