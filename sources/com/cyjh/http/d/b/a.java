package com.cyjh.http.d.b;

import android.content.Context;
import android.util.Log;
import com.android.volley.n;
import com.android.volley.s;
import com.cyjh.http.d.a.b;
import java.util.Map;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public String f2516a;

    /* renamed from: b  reason: collision with root package name */
    private b f2517b;

    /* renamed from: c  reason: collision with root package name */
    private com.cyjh.http.d.a.a f2518c;

    private a(b bVar) {
        this.f2517b = bVar;
    }

    public a(b bVar, com.cyjh.http.d.a.a aVar) {
        this.f2517b = bVar;
        this.f2518c = aVar;
    }

    private void a() {
        c.a().a((Object) this);
    }

    private void a(Context context, String str) {
        a(context, (Object) this, str);
    }

    private void a(Context context, String str, Map<String, String> map) {
        a(context, this, str, map);
    }

    private void a(Object obj, String str) {
        a((Context) null, obj, str);
    }

    private void a(Object obj, String str, Map<String, String> map) {
        a((Context) null, obj, str, map);
    }

    private static void b(Object obj) {
        c.a().a(obj);
    }

    public final void a(Context context, Object obj, String str) {
        this.f2516a = str;
        c.a().a(context, obj, new d(str, this, this, this.f2518c));
    }

    public final void a(Context context, Object obj, String str, Map<String, String> map) {
        this.f2516a = str;
        Log.d("ActivithHttpHelper", "url:" + str);
        c.a().a(context, obj, new d(str, map, (n.b<Object>) this, (n.a) this, this.f2518c));
    }

    public final void a(s sVar) {
        if (this.f2517b != null) {
            this.f2517b.a(sVar);
        }
    }

    public final void a(Object obj) {
        if (this.f2517b != null) {
            this.f2517b.a(obj);
        }
    }
}
