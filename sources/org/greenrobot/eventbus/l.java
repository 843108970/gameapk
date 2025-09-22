package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    final Method f4325a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f4326b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f4327c;
    final int d;
    final boolean e;
    String f;

    public l(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f4325a = method;
        this.f4326b = threadMode;
        this.f4327c = cls;
        this.d = i;
        this.e = z;
    }

    private synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f4325a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f4325a.getName());
            sb.append('(');
            sb.append(this.f4327c.getName());
            this.f = sb.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        a();
        l lVar = (l) obj;
        lVar.a();
        return this.f.equals(lVar.f);
    }

    public final int hashCode() {
        return this.f4325a.hashCode();
    }
}
