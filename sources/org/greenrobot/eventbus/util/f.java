package org.greenrobot.eventbus.util;

public class f implements e {

    /* renamed from: a  reason: collision with root package name */
    protected final Throwable f4361a;

    /* renamed from: b  reason: collision with root package name */
    protected final boolean f4362b;

    /* renamed from: c  reason: collision with root package name */
    Object f4363c;

    private f(Throwable th) {
        this.f4361a = th;
        this.f4362b = false;
    }

    private f(Throwable th, boolean z) {
        this.f4361a = th;
        this.f4362b = z;
    }

    private Throwable c() {
        return this.f4361a;
    }

    public final Object a() {
        return this.f4363c;
    }

    public final void a(Object obj) {
        this.f4363c = obj;
    }

    public final boolean b() {
        return this.f4362b;
    }
}
