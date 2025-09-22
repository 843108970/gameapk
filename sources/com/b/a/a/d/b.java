package com.b.a.a.d;

import com.b.a.a.c.c;
import com.b.b.k;
import com.b.b.x;
import com.b.b.y;

abstract class b implements x {

    /* renamed from: a  reason: collision with root package name */
    protected final k f628a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f629b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f630c;

    private b(a aVar) {
        this.f630c = aVar;
        this.f628a = new k(this.f630c.f627c.a());
    }

    /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    public final y a() {
        return this.f628a;
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        if (this.f630c.e != 6) {
            if (this.f630c.e != 5) {
                throw new IllegalStateException("state: " + this.f630c.e);
            }
            a.a(this.f628a);
            this.f630c.e = 6;
            if (this.f630c.f626b != null) {
                this.f630c.f626b.a(!z, (c) this.f630c);
            }
        }
    }
}
