package com.cyjh.http.d.b;

import android.content.Context;
import android.util.Log;
import com.android.volley.l;
import com.android.volley.m;
import com.android.volley.toolbox.t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2519a = "VollerHttpManager";

    /* renamed from: c  reason: collision with root package name */
    private static c f2520c;

    /* renamed from: b  reason: collision with root package name */
    public m f2521b;
    private Map<Context, HashSet<l>> d = new HashMap();

    private c() {
    }

    public static c a() {
        if (f2520c == null) {
            f2520c = new c();
        }
        return f2520c;
    }

    private void a(Context context) {
        if (this.f2521b == null) {
            this.f2521b = t.a(context);
        }
    }

    private void a(Object obj, l lVar) {
        if (this.f2521b != null) {
            a(obj);
            lVar.l = obj;
            this.f2521b.a(lVar);
            this.f2521b.a();
            return;
        }
        Log.i(f2519a, "你应该在 application中初始化队列");
    }

    private void b(Context context) {
        if (this.f2521b != null) {
            HashSet hashSet = this.d.get(context);
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    this.f2521b.a(((l) it.next()).l);
                }
                return;
            }
            return;
        }
        Log.i(f2519a, "你应该在 application中初始化队列");
    }

    public final void a(Context context, Object obj, l lVar) {
        if (this.f2521b != null) {
            if (context != null) {
                HashSet hashSet = this.d.get(context);
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                hashSet.add(lVar);
            }
            a(obj);
            lVar.l = obj;
            this.f2521b.a(lVar);
            return;
        }
        Log.i(f2519a, "你应该在 application中初始化队列");
    }

    public final void a(Object obj) {
        if (this.f2521b != null) {
            this.f2521b.a(obj);
        } else {
            Log.i(f2519a, "你应该在 application中初始化队列");
        }
    }
}
