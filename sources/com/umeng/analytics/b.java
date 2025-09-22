package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.h;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.r;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements n {
    private static final String g = "sp";

    /* renamed from: a  reason: collision with root package name */
    private Context f3547a;

    /* renamed from: b  reason: collision with root package name */
    private r f3548b;

    /* renamed from: c  reason: collision with root package name */
    private j f3549c;
    private p d;
    private o e;
    private h f;
    private boolean h;
    private volatile JSONObject i;
    private volatile JSONObject j;
    private boolean k;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f3550a = new b();

        private a() {
        }
    }

    private b() {
        this.f3547a = null;
        this.f3549c = new j();
        this.d = new p();
        this.e = o.a();
        this.f = null;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = false;
        this.f3549c.a((n) this);
    }

    public static b a() {
        return a.f3550a;
    }

    private void a(String str, Object obj) {
        try {
            if (this.i == null) {
                this.i = new JSONObject();
            }
            new JSONObject();
            int i2 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    JSONArray jSONArray = new JSONArray();
                    while (i2 < strArr.length) {
                        jSONArray.put(strArr[i2]);
                        i2++;
                    }
                    this.i.put(str, jSONArray);
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i2 < jArr.length) {
                        jSONArray2.put(jArr[i2]);
                        i2++;
                    }
                    this.i.put(str, jSONArray2);
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i2 < iArr.length) {
                        jSONArray3.put(iArr[i2]);
                        i2++;
                    }
                    this.i.put(str, jSONArray3);
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i2 < fArr.length) {
                        jSONArray4.put((double) fArr[i2]);
                        i2++;
                    }
                    this.i.put(str, jSONArray4);
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i2 < dArr.length) {
                        jSONArray5.put(dArr[i2]);
                        i2++;
                    }
                    this.i.put(str, jSONArray5);
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i2 < sArr.length) {
                        jSONArray6.put(sArr[i2]);
                        i2++;
                    }
                    this.i.put(str, jSONArray6);
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i2 < list.size()) {
                    Object obj2 = list.get(i2);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i2));
                    }
                    i2++;
                }
                this.i.put(str, jSONArray7);
            } else if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.i.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject f(Context context) {
        if (context == null) {
            try {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return null;
            } catch (Throwable unused) {
            }
        } else {
            if (this.f3547a == null) {
                this.f3547a = context;
            }
            String string = PreferenceWrapper.getDefault(context).getString(g, (String) null);
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(string);
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(double d2, double d3) {
        if (AnalyticsConfig.f3534a == null) {
            AnalyticsConfig.f3534a = new double[2];
        }
        AnalyticsConfig.f3534a[0] = d2;
        AnalyticsConfig.f3534a[1] = d3;
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        AnalyticsConfig.kContinueSessionMillis = j2;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
            return;
        }
        if (this.f3547a == null) {
            this.f3547a = context;
        }
        try {
            if (!this.h || !this.k) {
                b();
            }
            if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
                this.d.a(context.getClass().getName());
            }
            e();
        } catch (Throwable th) {
            MLog.e("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    public void a(Context context, int i2) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (this.f3547a == null) {
            this.f3547a = context;
        }
        if (!this.h || !this.k) {
            b();
        }
        AnalyticsConfig.a(this.f3547a, i2);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (this.f3547a == null) {
            this.f3547a = context;
        }
        if (eScenarioType != null) {
            int value = eScenarioType.toValue();
            if (value == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || value == MobclickAgent.EScenarioType.E_DUM_GAME.toValue()) {
                AnalyticsConfig.FLAG_DPLUS = true;
            } else {
                AnalyticsConfig.FLAG_DPLUS = false;
            }
            a(this.f3547a, value);
        }
        if (!this.h || !this.k) {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                MLog.e("unexpected null context in reportError");
                return;
            }
            if (this.f3547a == null) {
                this.f3547a = context;
            }
            try {
                if (!this.h || !this.k) {
                    b();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(com.umeng.analytics.pro.b.L, 2);
                jSONObject.put(com.umeng.analytics.pro.b.M, str);
                jSONObject.put("__ii", this.e.d());
                UMWorkDispatch.sendEvent(this.f3547a, i.a.j, CoreProtocol.getInstance(this.f3547a), jSONObject);
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                }
            }
        }
    }

    public void a(Context context, String str, Object obj) {
        if (context == null) {
            try {
                MLog.e("unexpected null context in registerSuperProperty");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            if (this.f3547a == null) {
                this.f3547a = context;
            }
            if (!this.h || !this.k) {
                b();
            }
            if (!TextUtils.isEmpty(str)) {
                if (obj != null) {
                    String subStr = HelperUtils.subStr(str, 128);
                    if (!Arrays.asList(com.umeng.analytics.pro.b.aq).contains(subStr)) {
                        if (obj instanceof String) {
                            obj = HelperUtils.subStr(obj.toString(), 256);
                        }
                        a(subStr, obj);
                        UMWorkDispatch.sendEvent(this.f3547a, i.a.m, CoreProtocol.getInstance(this.f3547a), this.i.toString());
                        return;
                    }
                    MLog.e("SuperProperty  key is invalid.  ");
                    return;
                }
            }
            MLog.e("please check key or value, must not NULL!");
        }
    }

    public void a(Context context, String str, String str2, long j2, int i2) {
        if (context != null) {
            try {
                this.f3547a = context;
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                    return;
                }
                return;
            }
        }
        if (!this.h || !this.k) {
            b();
        }
        m.a(this.f3547a).a(str, str2, j2, i2);
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context != null) {
            try {
                if (this.f3547a == null) {
                    this.f3547a = context;
                }
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                    return;
                }
                return;
            }
        }
        if (!this.h || !this.k) {
            b();
        }
        m.a(this.f3547a).a(str, (Map<String, Object>) hashMap);
    }

    public void a(Context context, String str, Map<String, Object> map) {
        if (context != null) {
            try {
                if (this.f3547a == null) {
                    this.f3547a = context;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (!this.h || !this.k) {
            b();
        }
        if (TextUtils.isEmpty(str)) {
            MLog.e("the eventName is empty! please check~");
            return;
        }
        String str2 = "";
        if (this.i == null) {
            this.i = new JSONObject();
        } else {
            str2 = this.i.toString();
        }
        String str3 = str;
        Map<String, Object> map2 = map;
        UMWorkDispatch.sendEvent(this.f3547a, 8194, CoreProtocol.getInstance(this.f3547a), new i.d(str3, map2, str2, System.currentTimeMillis()));
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, String str, Map<String, Object> map, long j2) {
        if (context != null) {
            try {
                this.f3547a = context;
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                    return;
                }
                return;
            }
        }
        if (!this.h || !this.k) {
            b();
        }
        m.a(this.f3547a).a(str, map, j2);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (this.f3547a == null) {
                this.f3547a = context;
            }
            try {
                if (!this.h || !this.k) {
                    b();
                }
                a(this.f3547a, DataHelper.convertExceptionToString(th));
            } catch (Exception e2) {
                if (MLog.DEBUG) {
                    MLog.e((Throwable) e2);
                }
            }
        }
    }

    public void a(Context context, List<String> list) {
        if (context == null) {
            try {
                MLog.e("unexpected null context in setFirstLaunchEvent");
            } catch (Throwable th) {
                MLog.e(th);
            }
        } else {
            if (this.f3547a == null) {
                this.f3547a = context;
            }
            if (!this.h || !this.k) {
                b();
            }
            m.a(this.f3547a).a(list);
        }
    }

    public void a(r rVar) {
        this.f3548b = rVar;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                String str = (String) obj;
                SharedPreferences.Editor edit = PreferenceWrapper.getDefault(this.f3547a).edit();
                if (edit != null && !TextUtils.isEmpty(str)) {
                    edit.putString(g, this.i.toString()).commit();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.d.a(str);
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.analytics.pro.b.H, str);
            jSONObject.put("uid", str2);
            UMWorkDispatch.sendEvent(this.f3547a, i.a.e, CoreProtocol.getInstance(this.f3547a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    public void a(Throwable th) {
        try {
            this.d.a();
            if (this.f3547a != null) {
                this.f.a(this.f3547a);
                this.e.b(this.f3547a, (Object) Long.valueOf(System.currentTimeMillis()));
                i.a(this.f3547a).a();
                p.a(this.f3547a);
                h.b(this.f3547a);
                PreferenceWrapper.getDefault(this.f3547a).edit().commit();
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(com.umeng.analytics.pro.b.L, 1);
                    jSONObject.put(com.umeng.analytics.pro.b.M, DataHelper.convertExceptionToString(th));
                    g.a(this.f3547a).a(this.e.d(), jSONObject.toString(), 1);
                }
            }
            UMWorkDispatch.Quit();
        } catch (Exception e2) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", (Throwable) e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        AnalyticsConfig.CATCH_EXCEPTION = z;
    }

    public void b() {
        try {
            if (this.f3547a != null) {
                if (!this.h) {
                    this.h = true;
                    this.i = f(this.f3547a);
                    if (this.i == null) {
                        this.i = new JSONObject();
                    }
                    this.j = new JSONObject(this.i.toString());
                }
                if (Build.VERSION.SDK_INT > 13) {
                    synchronized (this) {
                        if (!this.k && (this.f3547a instanceof Activity)) {
                            this.f = new h((Activity) this.f3547a);
                            this.k = true;
                        }
                    }
                } else {
                    this.k = true;
                }
                this.f3547a = this.f3547a.getApplicationContext();
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onPause");
            return;
        }
        if (this.f3547a == null) {
            this.f3547a = context;
        }
        try {
            if (!this.h || !this.k) {
                b();
            }
            if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
                this.d.b(context.getClass().getName());
            }
            f();
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Context context, String str) {
        if (context == null) {
            MLog.e("unexpected null context in setSecret");
            return;
        }
        if (this.f3547a == null) {
            this.f3547a = context;
        }
        if (!this.h || !this.k) {
            b();
        }
        AnalyticsConfig.a(this.f3547a, str);
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.d.b(str);
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        AnalyticsConfig.ACTIVITY_DURATION_OPEN = z;
    }

    public JSONObject c() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public void c(Context context) {
        try {
            if (this.f3547a == null && context != null) {
                this.f3547a = context;
            }
            this.d.a();
            this.f.a(this.f3547a);
            this.e.b(this.f3547a, (Object) Long.valueOf(System.currentTimeMillis()));
            i.a(this.f3547a).a();
            p.a(this.f3547a);
            h.b(this.f3547a);
            PreferenceWrapper.getDefault(this.f3547a).edit().commit();
            UMWorkDispatch.Quit();
        } catch (Throwable unused) {
        }
    }

    public void c(Context context, String str) {
        if (context == null) {
            try {
                MLog.e("unexpected null context in unregisterSuperProperty");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            if (this.f3547a == null) {
                this.f3547a = context;
            }
            if (!this.h || !this.k) {
                b();
            }
            String subStr = HelperUtils.subStr(str, 128);
            if (this.i == null) {
                this.i = new JSONObject();
            }
            if (this.i.has(subStr)) {
                this.i.remove(subStr);
                UMWorkDispatch.sendEvent(this.f3547a, i.a.o, CoreProtocol.getInstance(this.f3547a), subStr);
            }
        }
    }

    public Object d(Context context, String str) {
        if (context == null) {
            try {
                MLog.e("unexpected null context in getSuperProperty");
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            if (this.f3547a == null) {
                this.f3547a = context;
            }
            if (this.i != null) {
                String subStr = HelperUtils.subStr(str, 128);
                if (this.i.has(subStr)) {
                    return this.i.opt(subStr);
                }
                return null;
            }
            this.i = new JSONObject();
            return null;
        }
    }

    public String d(Context context) {
        if (context == null) {
            try {
                MLog.e("unexpected null context in getSuperProperties");
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else {
            if (this.f3547a == null) {
                this.f3547a = context;
            }
            if (this.i != null) {
                return this.i.toString();
            }
            this.i = new JSONObject();
            return null;
        }
    }

    public void d() {
        this.j = null;
    }

    public void e() {
        UMWorkDispatch.sendEvent(this.f3547a, i.a.g, CoreProtocol.getInstance(this.f3547a), Long.valueOf(System.currentTimeMillis()));
        if (this.f3548b != null) {
            this.f3548b.a();
        }
    }

    public void e(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in clearSuperProperties");
            return;
        }
        if (this.f3547a == null) {
            this.f3547a = context;
        }
        if (!this.h || !this.k) {
            b();
        }
        this.i = new JSONObject();
        UMWorkDispatch.sendEvent(this.f3547a, i.a.n, CoreProtocol.getInstance(this.f3547a), (Object) null);
    }

    public void f() {
        try {
            UMWorkDispatch.sendEvent(this.f3547a, i.a.h, CoreProtocol.getInstance(this.f3547a), Long.valueOf(System.currentTimeMillis()));
            UMWorkDispatch.sendEvent(this.f3547a, i.a.d, CoreProtocol.getInstance(this.f3547a), (Object) null);
            UMWorkDispatch.sendEvent(this.f3547a, 4099, CoreProtocol.getInstance(this.f3547a), (Object) null);
            UMWorkDispatch.sendEvent(this.f3547a, i.a.i, CoreProtocol.getInstance(this.f3547a), (Object) null);
        } catch (Throwable unused) {
        }
        if (this.f3548b != null) {
            this.f3548b.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        UMWorkDispatch.sendEvent(this.f3547a, i.a.f, CoreProtocol.getInstance(this.f3547a), (Object) null);
    }

    public void h() {
        try {
            if (this.i != null) {
                SharedPreferences.Editor edit = PreferenceWrapper.getDefault(this.f3547a).edit();
                edit.putString(g, this.i.toString());
                edit.commit();
                return;
            }
            this.i = new JSONObject();
        } catch (Throwable unused) {
        }
    }

    public JSONObject i() {
        try {
            if (this.i == null) {
                this.i = new JSONObject();
            }
        } catch (Throwable unused) {
        }
        return this.i;
    }

    public void j() {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(this.f3547a).edit();
            edit.remove(g);
            edit.commit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
