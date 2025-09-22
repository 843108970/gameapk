package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.i;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import org.json.JSONObject;

public class CoreProtocol implements UMLogDataProtocol {

    /* renamed from: a  reason: collision with root package name */
    private static Context f3537a;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final CoreProtocol f3538a = new CoreProtocol();

        private a() {
        }
    }

    private CoreProtocol() {
    }

    public static CoreProtocol getInstance(Context context) {
        if (f3537a == null && context != null) {
            f3537a = context.getApplicationContext();
        }
        return a.f3538a;
    }

    public void removeCacheData(Object obj) {
        i.a(f3537a).a(obj);
    }

    public JSONObject setupReportData(long j) {
        return i.a(f3537a).b(j);
    }

    public void workEvent(Object obj, int i) {
        i.a(f3537a).a(obj, i);
    }
}
