package org.jdeferred.android;

import android.annotation.SuppressLint;
import android.os.Build;
import java.util.concurrent.ExecutorService;
import org.jdeferred.a.c;
import org.jdeferred.b.e;
import org.jdeferred.d;
import org.jdeferred.e;
import org.jdeferred.p;

public final class b extends c {
    private static Void[] e = new Void[0];

    public b() {
    }

    private b(ExecutorService executorService) {
        super(executorService);
    }

    private p<org.jdeferred.b.c, e, org.jdeferred.b.b> a(int i, i<Void, ?, ?>... iVarArr) {
        a((Object[]) iVarArr);
        p[] pVarArr = new p[iVarArr.length];
        for (int i2 = 0; i2 < iVarArr.length; i2++) {
            pVarArr[i2] = a(iVarArr[i2]);
        }
        return new c(super.a(pVarArr), i);
    }

    private p<org.jdeferred.b.c, e, org.jdeferred.b.b> a(int i, p... pVarArr) {
        return new c(super.a(pVarArr), i);
    }

    @SuppressLint({"NewApi"})
    private <Progress, Result> p<Result, Throwable, Progress> a(i<Void, Progress, Result> iVar) {
        if (iVar.f4395c == e.a.AUTO$273301ba || (iVar.f4395c == e.a.DEFAULT$273301ba && this.d)) {
            if (Build.VERSION.SDK_INT >= 11) {
                iVar.executeOnExecutor(this.f4369c, e);
            } else {
                iVar.execute(e);
            }
        }
        return iVar.f4394b;
    }

    private static <D, F, P> p<D, F, P> a(p<D, F, P> pVar, int i) {
        return pVar instanceof c ? pVar : new c(pVar, i);
    }

    private p<org.jdeferred.b.c, org.jdeferred.b.e, org.jdeferred.b.b> a(i<Void, ?, ?>... iVarArr) {
        a((Object[]) iVarArr);
        p[] pVarArr = new p[iVarArr.length];
        for (int i = 0; i < iVarArr.length; i++) {
            pVarArr[i] = a(iVarArr[i]);
        }
        return a(pVarArr);
    }

    public final <D, P> p<D, Throwable, P> a(d<D, P> dVar) {
        return new c(super.a(dVar));
    }

    public final <D, F, P> p<D, F, P> a(p<D, F, P> pVar) {
        return pVar instanceof c ? pVar : new c(pVar);
    }

    public final p<org.jdeferred.b.c, org.jdeferred.b.e, org.jdeferred.b.b> a(p... pVarArr) {
        return new c(super.a(pVarArr));
    }
}
