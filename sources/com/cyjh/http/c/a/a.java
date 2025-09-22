package com.cyjh.http.c.a;

import android.util.Log;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.r;
import com.cyjh.http.bean.SignaClass;
import com.cyjh.http.bean.response.BaseInfo;
import com.cyjh.http.d.a.b;
import com.cyjh.http.e.c;

public abstract class a implements com.cyjh.http.d.a.a, b {

    /* renamed from: a  reason: collision with root package name */
    protected com.cyjh.http.d.b.a f2478a = new com.cyjh.http.d.b.a(this, this);

    protected a() {
    }

    public final Object a(String str) {
        try {
            ad.c("AbstractHttpPresenter", "getData = " + str);
            BaseInfo baseInfo = (BaseInfo) r.a(str, BaseInfo.class);
            String a2 = c.a(this.f2478a.f2516a, baseInfo.Data, baseInfo.R);
            Log.i("AbstractHttpPresenter", "decodeRes:" + a2);
            SignaClass signaClass = (SignaClass) r.a(a2, SignaClass.class);
            if (signaClass == null || !c.a(signaClass.SignContent, signaClass.Signature)) {
                return null;
            }
            return signaClass.SignContent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.android.volley.s r5) {
        /*
            r4 = this;
            com.cyjh.http.b.a r0 = com.cyjh.http.b.a.a()
            android.content.Context r0 = r0.f2476a
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0078
            boolean r1 = r5 instanceof com.android.volley.q
            if (r1 == 0) goto L_0x0017
            int r1 = com.cyjh.http.R.string.network_server_error
        L_0x0012:
            java.lang.String r1 = r0.getString(r1)
            goto L_0x003b
        L_0x0017:
            boolean r1 = r5 instanceof com.android.volley.j
            if (r1 == 0) goto L_0x001e
            int r1 = com.cyjh.http.R.string.network_no_connection_error
            goto L_0x0012
        L_0x001e:
            boolean r1 = r5 instanceof com.android.volley.h
            if (r1 == 0) goto L_0x0025
            int r1 = com.cyjh.http.R.string.network_network_error
            goto L_0x0012
        L_0x0025:
            boolean r1 = r5 instanceof com.android.volley.k
            if (r1 == 0) goto L_0x002c
            int r1 = com.cyjh.http.R.string.network_parse_error
            goto L_0x0012
        L_0x002c:
            boolean r1 = r5 instanceof com.android.volley.a
            if (r1 == 0) goto L_0x0033
            int r1 = com.cyjh.http.R.string.network_auth_failure_error
            goto L_0x0012
        L_0x0033:
            boolean r1 = r5 instanceof com.android.volley.r
            if (r1 == 0) goto L_0x003a
            int r1 = com.cyjh.http.R.string.network_timeout_error
            goto L_0x0012
        L_0x003a:
            r1 = 0
        L_0x003b:
            com.android.volley.i r2 = r5.networkResponse
            if (r2 == 0) goto L_0x006d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.android.volley.i r3 = r5.networkResponse
            int r3 = r3.f483a
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x006d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.android.volley.i r5 = r5.networkResponse
            int r5 = r5.f483a
            r2.append(r5)
            java.lang.String r5 = "\t\t"
            r2.append(r5)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x006d:
            if (r1 != 0) goto L_0x0075
            int r5 = com.cyjh.http.R.string.network_again_error
            java.lang.String r1 = r0.getString(r5)
        L_0x0075:
            r4.b(r1)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.http.c.a.a.a(com.android.volley.s):void");
    }

    public abstract void b(String str);
}
