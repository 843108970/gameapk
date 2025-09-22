package org.greenrobot.eventbus.a;

import org.greenrobot.eventbus.l;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final e[] f4294a;

    private b(Class cls, boolean z, e[] eVarArr) {
        super(cls, z);
        this.f4294a = eVarArr;
    }

    public final synchronized l[] d() {
        l[] lVarArr;
        int length = this.f4294a.length;
        lVarArr = new l[length];
        for (int i = 0; i < length; i++) {
            e eVar = this.f4294a[i];
            lVarArr[i] = a(eVar.f4295a, eVar.f4297c, eVar.f4296b, eVar.d, eVar.e);
        }
        return lVarArr;
    }
}
