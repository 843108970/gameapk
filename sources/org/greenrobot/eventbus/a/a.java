package org.greenrobot.eventbus.a;

import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.e;
import org.greenrobot.eventbus.l;

public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Class f4291a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<? extends c> f4292b = null;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4293c;

    protected a(Class cls, boolean z) {
        this.f4291a = cls;
        this.f4293c = z;
    }

    private l a(String str, Class<?> cls) {
        return a(str, cls, ThreadMode.POSTING, 0, false);
    }

    private l a(String str, Class<?> cls, ThreadMode threadMode) {
        return a(str, cls, threadMode, 0, false);
    }

    public final Class a() {
        return this.f4291a;
    }

    /* access modifiers changed from: protected */
    public final l a(String str, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        try {
            return new l(this.f4291a.getDeclaredMethod(str, new Class[]{cls}), cls, threadMode, i, z);
        } catch (NoSuchMethodException e) {
            throw new e("Could not find subscriber method in " + this.f4291a + ". Maybe a missing ProGuard rule?", e);
        }
    }

    public final c b() {
        if (this.f4292b == null) {
            return null;
        }
        try {
            return (c) this.f4292b.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean c() {
        return this.f4293c;
    }
}
