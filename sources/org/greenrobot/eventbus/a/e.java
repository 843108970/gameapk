package org.greenrobot.eventbus.a;

import org.greenrobot.eventbus.ThreadMode;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    final String f4295a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f4296b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f4297c;
    final int d;
    final boolean e;

    private e(String str, Class<?> cls) {
        this(str, cls, ThreadMode.POSTING);
    }

    private e(String str, Class<?> cls, ThreadMode threadMode) {
        this.f4295a = str;
        this.f4296b = threadMode;
        this.f4297c = cls;
        this.d = 0;
        this.e = false;
    }

    private e(String str, Class<?> cls, ThreadMode threadMode, byte b2) {
        this(str, cls, threadMode);
    }
}
