package com.hlzn.socketclient;

import android.content.Context;
import com.hlzn.socketclient.bean.ServiceParam;
import com.hlzn.socketclient.d.a;
import com.hlzn.socketclient.f.c;
import com.hlzn.socketclient.f.d;

public class f {

    /* renamed from: c  reason: collision with root package name */
    private static f f3444c;

    /* renamed from: a  reason: collision with root package name */
    public Context f3445a;

    /* renamed from: b  reason: collision with root package name */
    private a f3446b;

    private f() {
    }

    public static f a() {
        if (f3444c == null) {
            synchronized (f.class) {
                if (f3444c == null) {
                    f3444c = new f();
                }
            }
        }
        return f3444c;
    }

    private void a(int i, String str, String str2) {
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.d = str2;
        serviceParam.l = i;
        serviceParam.m = str;
        c.a(this.f3445a, com.hlzn.socketclient.b.a.g, serviceParam);
    }

    private void a(Context context) {
        this.f3445a = context;
    }

    private void a(a aVar) {
        this.f3446b = aVar;
    }

    private void a(String str) {
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.h = -1;
        serviceParam.i = str;
        c.a(this.f3445a, com.hlzn.socketclient.b.a.e, serviceParam);
    }

    private a b() {
        return this.f3446b;
    }

    private void b(String str) {
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.j = -1;
        serviceParam.k = str;
        c.a(this.f3445a, com.hlzn.socketclient.b.a.f, serviceParam);
    }

    private void c() {
        c.a(this.f3445a, com.hlzn.socketclient.b.a.f3428b);
    }

    private void c(String str) {
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.d = str;
        serviceParam.l = -1;
        serviceParam.m = str;
        c.a(this.f3445a, com.hlzn.socketclient.b.a.g, serviceParam);
    }

    private void d() {
        d.b("TAG", "scriptStart:" + com.hlzn.socketclient.b.a.v);
        if (com.hlzn.socketclient.b.a.v) {
            ServiceParam serviceParam = new ServiceParam();
            serviceParam.g = true;
            c.a(this.f3445a, com.hlzn.socketclient.b.a.f3429c, serviceParam);
        }
    }

    private void d(String str) {
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.n = -1;
        serviceParam.o = str;
        c.a(this.f3445a, com.hlzn.socketclient.b.a.h, serviceParam);
    }

    private void e() {
        d.b("TAG", "scriptStop:" + com.hlzn.socketclient.b.a.v);
        if (com.hlzn.socketclient.b.a.v) {
            ServiceParam serviceParam = new ServiceParam();
            serviceParam.g = false;
            c.a(this.f3445a, com.hlzn.socketclient.b.a.d, serviceParam);
        }
    }

    private void e(String str) {
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.p = -1;
        serviceParam.q = str;
        c.a(this.f3445a, com.hlzn.socketclient.b.a.i, serviceParam);
    }

    private void f() {
        c.a(this.f3445a, com.hlzn.socketclient.b.a.l);
    }

    private void f(String str) {
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.r = -1;
        serviceParam.s = str;
        c.a(this.f3445a, com.hlzn.socketclient.b.a.j, serviceParam);
    }

    private void g(String str) {
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.t = -1;
        serviceParam.u = str;
        c.a(this.f3445a, com.hlzn.socketclient.b.a.k, serviceParam);
    }
}
