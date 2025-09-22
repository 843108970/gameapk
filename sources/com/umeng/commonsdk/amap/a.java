package com.umeng.commonsdk.amap;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.e;
import java.lang.reflect.Method;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f3658a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f3659b;

    /* renamed from: c  reason: collision with root package name */
    private Object f3660c;

    public a(Context context) {
        e.a("ContentValues", "new UMAmapLocation");
        if (context == null) {
            MLog.e("Context参数不能为null");
            return;
        }
        this.f3658a = context.getApplicationContext();
        try {
            this.f3659b = Class.forName("com.amap.api.netlocation.AMapNetworkLocationClient");
            if (this.f3659b != null) {
                this.f3660c = this.f3659b.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f3658a});
            }
        } catch (Exception e) {
            e.a("ContentValues", "new UMAmapLocation e is " + e);
        }
    }

    public Class<?> a() {
        return this.f3659b;
    }

    public synchronized byte[] b() {
        byte[] bArr;
        Method method;
        e.a("ContentValues", "UMAmapLocation getNetworkLocationParameter");
        bArr = null;
        try {
            if (!(this.f3659b == null || this.f3660c == null || (method = this.f3659b.getMethod("getNetworkLocationParameter", new Class[0])) == null)) {
                bArr = (byte[]) method.invoke(this.f3660c, new Object[0]);
            }
        } catch (Exception e) {
            e.a("ContentValues", "getNetworkLocationParameter e is " + e);
        }
        return bArr;
    }

    public synchronized void c() {
        Method method;
        e.a("ContentValues", "UMAmapLocation destory");
        try {
            if (!(this.f3659b == null || this.f3660c == null || (method = this.f3659b.getMethod("destroy", new Class[0])) == null)) {
                method.invoke(this.f3660c, new Object[0]);
            }
        } catch (Exception e) {
            e.a("ContentValues", "UMAmapLocation destory e is " + e);
        }
    }
}
