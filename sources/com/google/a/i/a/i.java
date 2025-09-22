package com.google.a.i.a;

import com.google.a.t;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3307a = true;

    i() {
    }

    private boolean a() {
        return this.f3307a;
    }

    public final void a(t[] tVarArr) {
        if (this.f3307a && tVarArr != null && tVarArr.length >= 3) {
            t tVar = tVarArr[0];
            tVarArr[0] = tVarArr[2];
            tVarArr[2] = tVar;
        }
    }
}
