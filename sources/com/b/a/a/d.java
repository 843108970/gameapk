package com.b.a.a;

import java.util.concurrent.ThreadFactory;

final class d implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f623a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f624b;

    d(String str, boolean z) {
        this.f623a = str;
        this.f624b = z;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f623a);
        thread.setDaemon(this.f624b);
        return thread;
    }
}
