package org.junit.d;

import org.junit.e.a.j;
import org.junit.runner.c;

public abstract class e implements l {
    private j a(final j jVar) {
        return new j() {
            public final void a() throws Throwable {
                e.this.a();
                try {
                    r1.a();
                } finally {
                    e.this.b();
                }
            }
        };
    }

    public final j a(final j jVar, c cVar) {
        return new j() {
            public final void a() throws Throwable {
                e.this.a();
                try {
                    jVar.a();
                } finally {
                    e.this.b();
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void a() throws Throwable {
    }

    /* access modifiers changed from: protected */
    public void b() {
    }
}
