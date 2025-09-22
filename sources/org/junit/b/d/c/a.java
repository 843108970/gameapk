package org.junit.b.d.c;

import org.junit.b.b;
import org.junit.e.a.j;

public final class a extends j {

    /* renamed from: a  reason: collision with root package name */
    private final j f4485a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<? extends Throwable> f4486b;

    public a(j jVar, Class<? extends Throwable> cls) {
        this.f4485a = jVar;
        this.f4486b = cls;
    }

    public final void a() throws Exception {
        boolean z;
        try {
            this.f4485a.a();
            z = true;
        } catch (b e) {
            throw e;
        } catch (Throwable th) {
            if (!this.f4486b.isAssignableFrom(th.getClass())) {
                throw new Exception("Unexpected exception, expected<" + this.f4486b.getName() + "> but was<" + th.getClass().getName() + ">", th);
            }
            z = false;
        }
        if (z) {
            throw new AssertionError("Expected exception: " + this.f4486b.getName());
        }
    }
}
