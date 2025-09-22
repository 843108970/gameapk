package com.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.b;
import com.android.volley.i;
import com.android.volley.l;
import com.android.volley.n;

public final class e extends l<Object> {
    private final b m;
    private final Runnable n;

    private e(b bVar, Runnable runnable) {
        super(0, (String) null, (n.a) null);
        this.m = bVar;
        this.n = runnable;
    }

    /* access modifiers changed from: protected */
    public final n<Object> a(i iVar) {
        return null;
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj) {
    }

    public final boolean a() {
        this.m.b();
        if (this.n == null) {
            return true;
        }
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.n);
        return true;
    }

    public final l.b h() {
        return l.b.IMMEDIATE;
    }
}
