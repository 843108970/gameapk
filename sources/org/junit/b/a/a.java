package org.junit.b.a;

import java.util.Arrays;
import org.junit.e.a.h;
import org.junit.runner.k;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4457a;

    public a(boolean z) {
        this.f4457a = z;
    }

    private static f a() {
        return new f();
    }

    private static e b() {
        return new e();
    }

    private b c() {
        return new b(this);
    }

    private static c d() {
        return new c();
    }

    private h e() {
        return this.f4457a ? new h() : new g();
    }

    public final k a(Class<?> cls) throws Throwable {
        h[] hVarArr = new h[5];
        hVarArr[0] = new c();
        hVarArr[1] = new b(this);
        hVarArr[2] = this.f4457a ? new h() : new g();
        hVarArr[3] = new e();
        hVarArr[4] = new f();
        for (h b2 : Arrays.asList(hVarArr)) {
            k b3 = b2.b(cls);
            if (b3 != null) {
                return b3;
            }
        }
        return null;
    }
}
