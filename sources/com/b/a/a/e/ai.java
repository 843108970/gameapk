package com.b.a.a.e;

import java.util.concurrent.CountDownLatch;

final class ai {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f656a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private long f657b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f658c = -1;

    ai() {
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.f657b != -1) {
            throw new IllegalStateException();
        }
        this.f657b = System.nanoTime();
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (this.f658c != -1 || this.f657b == -1) {
            throw new IllegalStateException();
        }
        this.f658c = System.nanoTime();
        this.f656a.countDown();
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (this.f658c != -1 || this.f657b == -1) {
            throw new IllegalStateException();
        }
        this.f658c = this.f657b - 1;
        this.f656a.countDown();
    }
}
