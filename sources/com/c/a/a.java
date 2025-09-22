package com.c.a;

import android.content.Context;
import com.c.b.c;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.apache.http.HttpRequest;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashSet<com.c.b.a<?, ?>> f1514a;

    public String a(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    public final synchronized void a(int i, String str) {
        if (this.f1514a != null) {
            Iterator it = this.f1514a.iterator();
            while (it.hasNext()) {
                ((com.c.b.a) it.next()).a(i, str);
            }
            this.f1514a = null;
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void a(Context context) {
        if (this.f1514a != null) {
            Iterator it = this.f1514a.iterator();
            while (it.hasNext()) {
                ((com.c.b.a) it.next()).a(context);
            }
            this.f1514a = null;
        }
    }

    public final synchronized void a(com.c.b.a<?, ?> aVar) {
        if (this.f1514a == null) {
            this.f1514a = new LinkedHashSet<>();
            this.f1514a.add(aVar);
            b();
            return;
        }
        this.f1514a.add(aVar);
    }

    public void a(com.c.b.a<?, ?> aVar, HttpURLConnection httpURLConnection) {
    }

    public void a(com.c.b.a<?, ?> aVar, HttpRequest httpRequest) {
    }

    public abstract boolean a();

    public abstract boolean a(com.c.b.a<?, ?> aVar, c cVar);

    public String b(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    public abstract boolean b(com.c.b.a<?, ?> aVar);

    public void c() {
    }
}
