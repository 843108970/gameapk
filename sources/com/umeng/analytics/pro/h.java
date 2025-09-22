package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.b;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.i;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static String f3616a;
    private static JSONObject f = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    boolean f3617b = false;

    /* renamed from: c  reason: collision with root package name */
    boolean f3618c = false;
    Application.ActivityLifecycleCallbacks d = new Application.ActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            h.this.c(activity);
            h.this.f3618c = false;
        }

        public void onActivityResumed(Activity activity) {
            if (h.this.f3618c) {
                h.this.f3618c = false;
                String str = h.f3616a;
                if (str.equals(activity.getPackageName() + "." + activity.getLocalClassName())) {
                    return;
                }
            }
            h.this.b(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    };
    private final Map<String, Long> e = new HashMap();
    private Application g = null;

    public h(Activity activity) {
        synchronized (this) {
            if (this.g == null && activity != null) {
                this.g = activity.getApplication();
                a(activity);
            }
        }
    }

    private void a(Activity activity) {
        if (!this.f3617b) {
            this.f3617b = true;
            this.g.registerActivityLifecycleCallbacks(this.d);
            if (f3616a == null) {
                this.f3618c = true;
                b(activity);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(Activity activity) {
        f3616a = activity.getPackageName() + "." + activity.getLocalClassName();
        if (AnalyticsConfig.FLAG_DPLUS) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(b.ai, f3616a);
                jSONObject.put("_$!ts", System.currentTimeMillis());
                JSONObject i = b.a().i();
                if (i.length() > 0) {
                    jSONObject.put(b.ab, i);
                }
                String c2 = o.a().c();
                if (TextUtils.isEmpty(c2)) {
                    c2 = "-1";
                }
                jSONObject.put("__ii", c2);
                if (o.a().b()) {
                    jSONObject.put("__ii", "-1");
                }
                UMWorkDispatch.sendEvent(activity.getApplicationContext(), i.a.k, CoreProtocol.getInstance(activity.getApplicationContext()), jSONObject);
            } catch (JSONException unused) {
            }
        }
        synchronized (this.e) {
            this.e.put(f3616a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void b(Context context) {
        try {
            synchronized (f) {
                if (context != null) {
                    if (f.length() > 0) {
                        g.a(context).a(o.a().d(), f, g.a.AUTOPAGE);
                        f = new JSONObject();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(android.app.Activity r7) {
        /*
            r6 = this;
            r0 = 0
            java.util.Map<java.lang.String, java.lang.Long> r7 = r6.e     // Catch:{ Throwable -> 0x004f }
            monitor-enter(r7)     // Catch:{ Throwable -> 0x004f }
            java.util.Map<java.lang.String, java.lang.Long> r2 = r6.e     // Catch:{ all -> 0x004c }
            java.lang.String r3 = f3616a     // Catch:{ all -> 0x004c }
            boolean r2 = r2.containsKey(r3)     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x002c
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004c }
            java.util.Map<java.lang.String, java.lang.Long> r2 = r6.e     // Catch:{ all -> 0x004c }
            java.lang.String r3 = f3616a     // Catch:{ all -> 0x004c }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x004c }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x004c }
            long r2 = r2.longValue()     // Catch:{ all -> 0x004c }
            r4 = 0
            long r4 = r0 - r2
            java.util.Map<java.lang.String, java.lang.Long> r0 = r6.e     // Catch:{ all -> 0x004c }
            java.lang.String r1 = f3616a     // Catch:{ all -> 0x004c }
            r0.remove(r1)     // Catch:{ all -> 0x004c }
            r0 = r4
        L_0x002c:
            monitor-exit(r7)     // Catch:{ all -> 0x004c }
            org.json.JSONObject r7 = f     // Catch:{ Throwable -> 0x004f }
            monitor-enter(r7)     // Catch:{ Throwable -> 0x004f }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0048 }
            r2.<init>()     // Catch:{ Throwable -> 0x0048 }
            f = r2     // Catch:{ Throwable -> 0x0048 }
            java.lang.String r3 = "page_name"
            java.lang.String r4 = f3616a     // Catch:{ Throwable -> 0x0048 }
            r2.put(r3, r4)     // Catch:{ Throwable -> 0x0048 }
            org.json.JSONObject r2 = f     // Catch:{ Throwable -> 0x0048 }
            java.lang.String r3 = "duration"
            r2.put(r3, r0)     // Catch:{ Throwable -> 0x0048 }
            goto L_0x0048
        L_0x0046:
            r0 = move-exception
            goto L_0x004a
        L_0x0048:
            monitor-exit(r7)     // Catch:{ all -> 0x0046 }
            return
        L_0x004a:
            monitor-exit(r7)     // Catch:{ all -> 0x0046 }
            throw r0     // Catch:{ Throwable -> 0x004f }
        L_0x004c:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ Throwable -> 0x004f }
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.h.c(android.app.Activity):void");
    }

    public void a() {
        this.f3617b = false;
        if (this.g != null) {
            this.g.unregisterActivityLifecycleCallbacks(this.d);
            this.g = null;
        }
    }

    public void a(Context context) {
        c((Activity) null);
        a();
    }
}
