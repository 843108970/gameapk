package com.b.a.a;

public abstract class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    protected final String f585b;

    public b(String str, Object... objArr) {
        this.f585b = c.a(str, objArr);
    }

    public abstract void b();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f585b);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
