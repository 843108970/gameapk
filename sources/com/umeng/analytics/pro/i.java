package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.noise.ImLatent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import net.grandcentrix.tray.provider.ContentProviderStorage;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {
    private static boolean A = false;
    private static final String B = "n_sess_dp";
    private static final String C = "n_sess_dp_type";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Context f3620a = null;
    private static final String q = "first_activate_time";
    private static final String r = "ana_is_f";
    private static final String s = "thtstart";
    private static final String t = "dstk_last_time";
    private static final String u = "dstk_cnt";
    private static final String v = "gkvc";
    private static final String w = "ekvc";
    private static final String y = "-1";
    private static boolean z = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ABTest f3621b;

    /* renamed from: c  reason: collision with root package name */
    private ImLatent f3622c;
    private c d;
    private SharedPreferences e;
    private String f;
    private String g;
    private String h;
    private String i;
    private long j;
    private int k;
    private JSONArray l;
    private final int m;
    private int n;
    private int o;
    private long p;
    private final long x;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3623a = 4097;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3624b = 4098;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3625c = 4099;
        public static final int d = 4100;
        public static final int e = 4101;
        public static final int f = 4102;
        public static final int g = 4103;
        public static final int h = 4104;
        public static final int i = 4105;
        public static final int j = 4106;
        public static final int k = 8193;
        public static final int l = 8194;
        public static final int m = 8195;
        public static final int n = 8196;
        public static final int o = 8197;
    }

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final i f3626a = new i();

        private b() {
        }
    }

    public class c {

        /* renamed from: b  reason: collision with root package name */
        private ReportPolicy.ReportStrategy f3628b = null;

        /* renamed from: c  reason: collision with root package name */
        private int f3629c = -1;
        private int d = -1;
        private int e = -1;
        private int f = -1;

        public c() {
        }

        private ReportPolicy.ReportStrategy b(int i, int i2) {
            switch (i) {
                case 0:
                    if (!(this.f3628b instanceof ReportPolicy.ReportRealtime)) {
                        return new ReportPolicy.ReportRealtime();
                    }
                    break;
                case 1:
                    if (!(this.f3628b instanceof ReportPolicy.ReportAtLaunch)) {
                        return new ReportPolicy.ReportAtLaunch();
                    }
                    break;
                case 4:
                    if (!(this.f3628b instanceof ReportPolicy.ReportDaily)) {
                        return new ReportPolicy.ReportDaily(StatTracer.getInstance(i.f3620a));
                    }
                    break;
                case 5:
                    if (!(this.f3628b instanceof ReportPolicy.ReportWifiOnly)) {
                        return new ReportPolicy.ReportWifiOnly(i.f3620a);
                    }
                    break;
                case 6:
                    if (!(this.f3628b instanceof ReportPolicy.ReportByInterval)) {
                        return new ReportPolicy.ReportByInterval(StatTracer.getInstance(i.f3620a), (long) i2);
                    }
                    ReportPolicy.ReportStrategy reportStrategy = this.f3628b;
                    ((ReportPolicy.ReportByInterval) reportStrategy).setReportInterval((long) i2);
                    return reportStrategy;
                case 8:
                    if (!(this.f3628b instanceof ReportPolicy.SmartPolicy)) {
                        return new ReportPolicy.SmartPolicy(StatTracer.getInstance(i.f3620a));
                    }
                    break;
                default:
                    if (!(this.f3628b instanceof ReportPolicy.ReportAtLaunch)) {
                        return new ReportPolicy.ReportAtLaunch();
                    }
                    break;
            }
            return this.f3628b;
        }

        public int a(int i) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(i.f3620a, "test_report_interval", i.y)).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i : intValue * 1000;
        }

        public void a() {
            try {
                int[] a2 = a(-1, -1);
                this.f3629c = a2[0];
                this.d = a2[1];
            } catch (Throwable unused) {
            }
        }

        public int[] a(int i, int i2) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(i.f3620a, "report_policy", i.y)).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(i.f3620a, "report_interval", i.y)).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i, i2};
            }
            int i3 = 90;
            if (intValue2 != -1 && intValue2 >= 90 && intValue2 <= 86400) {
                i3 = intValue2;
            }
            return new int[]{intValue, i3 * 1000};
        }

        /* access modifiers changed from: protected */
        public void b() {
            int i;
            ReportPolicy.ReportStrategy b2;
            Defcon service = Defcon.getService(i.f3620a);
            int i2 = 0;
            if (service.isOpen()) {
                if ((this.f3628b instanceof ReportPolicy.DefconPolicy) && this.f3628b.isValid()) {
                    i2 = 1;
                }
                b2 = i2 != 0 ? this.f3628b : new ReportPolicy.DefconPolicy(StatTracer.getInstance(i.f3620a), service);
            } else {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(i.f3620a, "integrated_test", i.y)).intValue() == 1;
                if (!MLog.DEBUG || !z) {
                    if (!i.this.f3621b.isInTest() || !"RPT".equals(i.this.f3621b.getTestName())) {
                        i = this.e;
                        i2 = this.f;
                        if (this.f3629c != -1) {
                            i = this.f3629c;
                            i2 = this.d;
                        }
                    } else {
                        if (i.this.f3621b.getTestPolicy() == 6) {
                            if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(i.f3620a, "test_report_interval", i.y)).intValue() != -1) {
                                i2 = 1;
                            }
                            i2 = i2 != 0 ? a(90000) : this.d > 0 ? this.d : this.f;
                        }
                        i = i.this.f3621b.getTestPolicy();
                    }
                    b2 = b(i, i2);
                } else {
                    b2 = new ReportPolicy.DebugPolicy(StatTracer.getInstance(i.f3620a));
                }
            }
            this.f3628b = b2;
            MLog.d("Report policy : " + this.f3628b.getClass().getSimpleName());
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f3628b;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Object> f3630a = null;

        /* renamed from: b  reason: collision with root package name */
        private String f3631b = null;

        /* renamed from: c  reason: collision with root package name */
        private String f3632c = null;
        private long d = 0;

        private d() {
        }

        public d(String str, Map<String, Object> map, String str2, long j) {
            this.f3630a = map;
            this.f3631b = str;
            this.d = j;
            this.f3632c = str2;
        }

        public Map<String, Object> a() {
            return this.f3630a;
        }

        public String b() {
            return this.f3632c;
        }

        public String c() {
            return this.f3631b;
        }

        public long d() {
            return this.d;
        }
    }

    private i() {
        this.f3621b = null;
        this.f3622c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = 10;
        this.l = new JSONArray();
        this.m = com.hlzn.socketclient.b.a.t;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.x = 28800000;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3620a);
            this.p = sharedPreferences.getLong(s, 0);
            this.n = sharedPreferences.getInt(v, 0);
            this.o = sharedPreferences.getInt(w, 0);
            this.d = new c();
            this.f3621b = ABTest.getService(f3620a);
            this.f3622c = ImLatent.getService(f3620a, StatTracer.getInstance(f3620a));
        } catch (Throwable unused) {
        }
    }

    public static i a(Context context) {
        if (f3620a == null && context != null) {
            f3620a = context.getApplicationContext();
        }
        return b.f3626a;
    }

    private JSONObject a(JSONObject jSONObject, long j2) {
        try {
            if (k.a(jSONObject) <= j2) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(b.an, k.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return k.a(f3620a, j2, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j2, int i2) {
        if (j2 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j2 <= 28800000) {
            return i2 < 5000;
        }
        j();
        return true;
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("analytics")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("analytics");
                        if (jSONObject3.has(b.N)) {
                            jSONObject2.put(b.N, jSONObject3.getJSONArray(b.N));
                        }
                        if (jSONObject3.has(b.O)) {
                            jSONObject2.put(b.O, jSONObject3.getJSONArray(b.O));
                        }
                        if (jSONObject3.has(b.J)) {
                            jSONObject2.put(b.J, jSONObject3.getJSONArray(b.J));
                        }
                        if (jSONObject3.has(b.n)) {
                            JSONArray jSONArray = jSONObject3.getJSONArray(b.n);
                            JSONArray jSONArray2 = new JSONArray();
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
                                if (jSONObject4 != null && jSONObject4.length() > 0) {
                                    if (jSONObject4.has(b.t)) {
                                        jSONObject4.remove(b.t);
                                    }
                                    jSONArray2.put(jSONObject4);
                                }
                            }
                            jSONObject2.put(b.n, jSONArray2);
                        }
                        if (jSONObject3.has(b.D)) {
                            jSONObject2.put(b.D, jSONObject3.getJSONObject(b.D));
                        }
                        if (jSONObject3.has(b.G)) {
                            jSONObject2.put(b.G, jSONObject3.getJSONObject(b.G));
                        }
                    }
                    if (jSONObject.has("dplus")) {
                        jSONObject2.put("dplus", jSONObject.getJSONObject("dplus"));
                    }
                    if (jSONObject.has("header")) {
                        JSONObject jSONObject5 = jSONObject.getJSONObject("header");
                        jSONObject2.put("sdk_version", jSONObject5.getString("sdk_version"));
                        jSONObject2.put("device_id", jSONObject5.getString("device_id"));
                        jSONObject2.put("device_model", jSONObject5.getString("device_model"));
                        jSONObject2.put(ContentProviderStorage.VERSION, jSONObject5.getString("version_code"));
                        jSONObject2.put("appkey", jSONObject5.getString("appkey"));
                        jSONObject2.put("channel", jSONObject5.getString("channel"));
                    }
                    if (jSONObject2.length() > 0) {
                        MLog.d("constructMessage:" + jSONObject2.toString());
                    }
                }
            } catch (Throwable th) {
                MLog.e(th);
            }
        }
    }

    private void c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject("header").has(b.an)) {
                if (jSONObject.has(b.W)) {
                    jSONObject = jSONObject.getJSONObject(b.W);
                }
                if (jSONObject.has("analytics")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("analytics");
                    if (jSONObject2.has(b.n)) {
                        JSONObject jSONObject3 = jSONObject2.getJSONArray(b.n).getJSONObject(0);
                        if (jSONObject3 != null) {
                            g.a(f3620a).a(true, jSONObject3.getString("id"));
                        }
                    } else {
                        g.a(f3620a).g();
                    }
                } else if (jSONObject.has("dplus")) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject("dplus");
                    if (jSONObject4.has(b.Y)) {
                        g.a(f3620a).b(0);
                    }
                    if (jSONObject4.has(b.ac)) {
                        g.a(f3620a).b(4);
                    }
                    if (jSONObject4.has(b.ah)) {
                        g.a(f3620a).b(1);
                    }
                }
                g.a(f3620a).a();
                return;
            }
            if (jSONObject.has(b.W)) {
                jSONObject = jSONObject.getJSONObject(b.W);
            }
            if (jSONObject.has("analytics") && (optJSONObject = jSONObject.optJSONObject("analytics")) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(b.n)) {
                    g.a(f3620a).a(true, false);
                }
                if (optJSONObject.has(b.N) || optJSONObject.has(b.O)) {
                    g.a(f3620a).d();
                }
                if (optJSONObject.has(b.J)) {
                    g.a(f3620a).e();
                }
            }
            if (jSONObject.has("dplus")) {
                g.a(f3620a).f();
            }
            g.a(f3620a).a();
        } catch (Exception unused) {
        }
    }

    private void c(boolean z2) {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject jSONObject = new JSONObject();
        if (!z2) {
            jSONObject = a(UMEnvelopeBuild.maxDataSpace(f3620a));
        } else if (AnalyticsConfig.FLAG_DPLUS) {
            jSONObject = b(UMEnvelopeBuild.maxDataSpace(f3620a));
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = (JSONObject) jSONObject.opt("header");
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(b.W);
            if (f3620a != null && jSONObject2 != null && jSONObject3 != null && (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f3620a, jSONObject2, jSONObject3)) != null) {
                b(buildEnvelopeWithExtHeader);
                a((Object) buildEnvelopeWithExtHeader);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f A[Catch:{ Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[Catch:{ Throwable -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0115 A[Catch:{ Throwable -> 0x01b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject d(boolean r8) {
        /*
            r7 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.mWrapperType     // Catch:{ Throwable -> 0x01b3 }
            if (r1 == 0) goto L_0x001b
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.mWrapperVersion     // Catch:{ Throwable -> 0x01b3 }
            if (r1 == 0) goto L_0x001b
            java.lang.String r1 = "wrapper_version"
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.mWrapperVersion     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r1, r2)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "wrapper_type"
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.mWrapperType     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r1, r2)     // Catch:{ Throwable -> 0x01b3 }
        L_0x001b:
            android.content.Context r1 = f3620a     // Catch:{ Throwable -> 0x01b3 }
            int r1 = com.umeng.analytics.AnalyticsConfig.getVerticalType(r1)     // Catch:{ Throwable -> 0x01b3 }
            com.umeng.analytics.MobclickAgent$EScenarioType r2 = com.umeng.analytics.MobclickAgent.EScenarioType.E_DUM_NORMAL     // Catch:{ Throwable -> 0x01b3 }
            int r2 = r2.toValue()     // Catch:{ Throwable -> 0x01b3 }
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x0034
            com.umeng.analytics.AnalyticsConfig.FLAG_DPLUS = r3     // Catch:{ Throwable -> 0x01b3 }
            com.umeng.analytics.MobclickAgent$EScenarioType r1 = com.umeng.analytics.MobclickAgent.EScenarioType.E_UM_NORMAL     // Catch:{ Throwable -> 0x01b3 }
        L_0x002f:
            int r1 = r1.toValue()     // Catch:{ Throwable -> 0x01b3 }
            goto L_0x0043
        L_0x0034:
            com.umeng.analytics.MobclickAgent$EScenarioType r2 = com.umeng.analytics.MobclickAgent.EScenarioType.E_DUM_GAME     // Catch:{ Throwable -> 0x01b3 }
            int r2 = r2.toValue()     // Catch:{ Throwable -> 0x01b3 }
            if (r1 != r2) goto L_0x0041
            com.umeng.analytics.AnalyticsConfig.FLAG_DPLUS = r3     // Catch:{ Throwable -> 0x01b3 }
            com.umeng.analytics.MobclickAgent$EScenarioType r1 = com.umeng.analytics.MobclickAgent.EScenarioType.E_UM_GAME     // Catch:{ Throwable -> 0x01b3 }
            goto L_0x002f
        L_0x0041:
            com.umeng.analytics.AnalyticsConfig.FLAG_DPLUS = r4     // Catch:{ Throwable -> 0x01b3 }
        L_0x0043:
            java.lang.String r2 = "vertical_type"
            r0.put(r2, r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "sdk_version"
            java.lang.String r2 = "7.3.2"
            r0.put(r1, r2)     // Catch:{ Throwable -> 0x01b3 }
            android.content.Context r1 = f3620a     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = com.umeng.analytics.AnalyticsConfig.getSecretKey(r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = com.umeng.commonsdk.statistics.common.HelperUtils.MD5(r1)     // Catch:{ Throwable -> 0x01b3 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x01b3 }
            if (r2 != 0) goto L_0x0064
            java.lang.String r2 = "secret"
            r0.put(r2, r1)     // Catch:{ Throwable -> 0x01b3 }
        L_0x0064:
            android.content.Context r1 = f3620a     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r2 = "pr_ve"
            r3 = 0
            java.lang.String r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r1, r2, r3)     // Catch:{ Throwable -> 0x01b3 }
            android.content.Context r2 = f3620a     // Catch:{ Throwable -> 0x01b3 }
            android.content.SharedPreferences r2 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(r2)     // Catch:{ Throwable -> 0x01b3 }
            if (r8 == 0) goto L_0x0115
            java.lang.String r8 = "$pr_ve"
            java.lang.String r3 = r7.h()     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r8, r3)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r8 = "$ud_da"
            java.lang.String r3 = r7.i()     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r8, r3)     // Catch:{ Throwable -> 0x01b3 }
            if (r2 == 0) goto L_0x01b7
            java.lang.String r8 = "dp_vers_name"
            java.lang.String r3 = ""
            java.lang.String r8 = r2.getString(r8, r3)     // Catch:{ Throwable -> 0x01b3 }
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Throwable -> 0x01b3 }
            if (r3 != 0) goto L_0x01b7
            java.lang.String r3 = "app_version"
            r0.put(r3, r8)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r3 = "version_code"
            java.lang.String r5 = "dp_vers_code"
            int r4 = r2.getInt(r5, r4)     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x01b3 }
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r4 = "yyyy-MM-dd"
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ Throwable -> 0x01b3 }
            r3.<init>(r4, r5)     // Catch:{ Throwable -> 0x01b3 }
            java.util.Date r4 = new java.util.Date     // Catch:{ Throwable -> 0x01b3 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x01b3 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r3 = r3.format(r4)     // Catch:{ Throwable -> 0x01b3 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x01b3 }
            if (r1 == 0) goto L_0x00dd
            java.lang.String r1 = "$pr_ve"
            java.lang.String r4 = "dp_vers_pre_version"
            java.lang.String r5 = "0"
            java.lang.String r4 = r2.getString(r4, r5)     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r1, r4)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "$ud_da"
            java.lang.String r4 = "dp_vers_date"
            java.lang.String r4 = r2.getString(r4, r3)     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r1, r4)     // Catch:{ Throwable -> 0x01b3 }
        L_0x00dd:
            android.content.Context r1 = f3620a     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(r1)     // Catch:{ Throwable -> 0x01b3 }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r4 = "dp_pre_version"
            android.content.SharedPreferences$Editor r8 = r2.putString(r4, r8)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r2 = "dp_cur_version"
            android.content.SharedPreferences$Editor r8 = r8.putString(r2, r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "dp_pre_date"
            android.content.SharedPreferences$Editor r8 = r8.putString(r1, r3)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "dp_vers_name"
            android.content.SharedPreferences$Editor r8 = r8.remove(r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "dp_vers_code"
            android.content.SharedPreferences$Editor r8 = r8.remove(r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "dp_vers_date"
            android.content.SharedPreferences$Editor r8 = r8.remove(r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "dp_vers_pre_version"
            android.content.SharedPreferences$Editor r8 = r8.remove(r1)     // Catch:{ Throwable -> 0x01b3 }
        L_0x0111:
            r8.commit()     // Catch:{ Throwable -> 0x01b3 }
            return r0
        L_0x0115:
            java.lang.String r8 = "$pr_ve"
            java.lang.String r3 = r7.f()     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r8, r3)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r8 = "$ud_da"
            java.lang.String r3 = r7.g()     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r8, r3)     // Catch:{ Throwable -> 0x01b3 }
            if (r2 == 0) goto L_0x01b7
            java.lang.String r8 = "vers_name"
            java.lang.String r3 = ""
            java.lang.String r8 = r2.getString(r8, r3)     // Catch:{ Throwable -> 0x01b3 }
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Throwable -> 0x01b3 }
            if (r3 != 0) goto L_0x01b7
            java.lang.String r3 = "app_version"
            r0.put(r3, r8)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r3 = "version_code"
            java.lang.String r5 = "vers_code"
            int r4 = r2.getInt(r5, r4)     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x01b3 }
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r4 = "yyyy-MM-dd"
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ Throwable -> 0x01b3 }
            r3.<init>(r4, r5)     // Catch:{ Throwable -> 0x01b3 }
            java.util.Date r4 = new java.util.Date     // Catch:{ Throwable -> 0x01b3 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x01b3 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r3 = r3.format(r4)     // Catch:{ Throwable -> 0x01b3 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x01b3 }
            if (r1 == 0) goto L_0x017d
            java.lang.String r1 = "$pr_ve"
            java.lang.String r4 = "vers_pre_version"
            java.lang.String r5 = "0"
            java.lang.String r4 = r2.getString(r4, r5)     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r1, r4)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "$ud_da"
            java.lang.String r4 = "vers_date"
            java.lang.String r4 = r2.getString(r4, r3)     // Catch:{ Throwable -> 0x01b3 }
            r0.put(r1, r4)     // Catch:{ Throwable -> 0x01b3 }
        L_0x017d:
            android.content.Context r1 = f3620a     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(r1)     // Catch:{ Throwable -> 0x01b3 }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r4 = "pre_version"
            android.content.SharedPreferences$Editor r8 = r2.putString(r4, r8)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r2 = "cur_version"
            android.content.SharedPreferences$Editor r8 = r8.putString(r2, r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "pre_date"
            android.content.SharedPreferences$Editor r8 = r8.putString(r1, r3)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "vers_name"
            android.content.SharedPreferences$Editor r8 = r8.remove(r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "vers_code"
            android.content.SharedPreferences$Editor r8 = r8.remove(r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "vers_date"
            android.content.SharedPreferences$Editor r8 = r8.remove(r1)     // Catch:{ Throwable -> 0x01b3 }
            java.lang.String r1 = "vers_pre_version"
            android.content.SharedPreferences$Editor r8 = r8.remove(r1)     // Catch:{ Throwable -> 0x01b3 }
            goto L_0x0111
        L_0x01b3:
            r8 = move-exception
            r8.printStackTrace()
        L_0x01b7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.d(boolean):org.json.JSONObject");
    }

    private void d(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (a(this.p, this.n)) {
                    this.n++;
                } else {
                    return;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (a(this.p, this.o)) {
                    this.o++;
                } else {
                    return;
                }
            }
            if (this.l.length() >= this.k) {
                g.a(f3620a).a(this.l);
                this.l = new JSONArray();
            }
            if (this.p == 0) {
                this.p = System.currentTimeMillis();
            }
            this.l.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void e(Object obj) {
        try {
            b(f3620a);
            a();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(b.H);
                String string2 = jSONObject.getString("uid");
                String[] a2 = com.umeng.analytics.c.a(f3620a);
                if (a2 == null || !string.equals(a2[0]) || !string2.equals(a2[1])) {
                    boolean a3 = o.a().a(f3620a, System.currentTimeMillis());
                    com.umeng.analytics.c.a(f3620a, string, string2);
                    if (a3) {
                        o.a().b(f3620a, System.currentTimeMillis());
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private boolean e(boolean z2) {
        if (n()) {
            return true;
        }
        if (this.d == null) {
            this.d = new c();
        }
        this.d.a();
        ReportPolicy.ReportStrategy c2 = this.d.c();
        boolean shouldSendMessage = c2.shouldSendMessage(z2);
        if (shouldSendMessage && (((c2 instanceof ReportPolicy.ReportByInterval) || (c2 instanceof ReportPolicy.DebugPolicy)) && k())) {
            a();
        }
        return shouldSendMessage;
    }

    private String f() {
        String str = null;
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f3620a, "pr_ve", (String) null);
            try {
                if (TextUtils.isEmpty(imprintProperty)) {
                    if (!TextUtils.isEmpty(this.f)) {
                        return this.f;
                    }
                    if (this.e == null) {
                        this.e = PreferenceWrapper.getDefault(f3620a);
                    }
                    str = this.e.getString("pre_version", "");
                    String appVersionName = DeviceConfig.getAppVersionName(f3620a);
                    if (TextUtils.isEmpty(str)) {
                        this.e.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                        str = "0";
                    } else {
                        String string = this.e.getString("cur_version", "");
                        if (!appVersionName.equals(string)) {
                            this.e.edit().putString("pre_version", string).putString("cur_version", appVersionName).commit();
                            str = string;
                        }
                    }
                    this.f = str;
                    return str;
                }
            } catch (Throwable unused) {
            }
            str = imprintProperty;
        } catch (Throwable unused2) {
        }
        this.f = str;
        return str;
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0 && jSONObject.has("__ii")) {
                String optString = jSONObject.optString("__ii");
                jSONObject.remove("__ii");
                if (!TextUtils.isEmpty(optString)) {
                    g.a(f3620a).a(optString, obj.toString(), 2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private String g() {
        String str = null;
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f3620a, "ud_da", (String) null);
            try {
                if (TextUtils.isEmpty(imprintProperty)) {
                    if (!TextUtils.isEmpty(this.g)) {
                        return this.g;
                    }
                    if (this.e == null) {
                        this.e = PreferenceWrapper.getDefault(f3620a);
                    }
                    str = this.e.getString("pre_date", "");
                    if (TextUtils.isEmpty(str)) {
                        str = new SimpleDateFormat(com.cyjh.http.e.a.f2523b, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                        this.e.edit().putString("pre_date", str).commit();
                    } else {
                        String format = new SimpleDateFormat(com.cyjh.http.e.a.f2523b, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                        if (!str.equals(format)) {
                            this.e.edit().putString("pre_date", format).commit();
                            str = format;
                        }
                    }
                    this.g = str;
                    return str;
                }
            } catch (Throwable unused) {
            }
            str = imprintProperty;
        } catch (Throwable unused2) {
        }
        this.g = str;
        return str;
    }

    private String h() {
        String str = null;
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f3620a, "pr_ve", (String) null);
            try {
                if (TextUtils.isEmpty(imprintProperty)) {
                    if (!TextUtils.isEmpty(this.h)) {
                        return this.h;
                    }
                    if (this.e == null) {
                        this.e = PreferenceWrapper.getDefault(f3620a);
                    }
                    str = this.e.getString("dp_pre_version", "");
                    String appVersionName = DeviceConfig.getAppVersionName(f3620a);
                    if (TextUtils.isEmpty(str)) {
                        this.e.edit().putString("dp_pre_version", "0").putString("dp_cur_version", appVersionName).commit();
                        str = "0";
                    } else {
                        String string = this.e.getString("dp_cur_version", "");
                        if (!appVersionName.equals(string)) {
                            this.e.edit().putString("dp_pre_version", string).putString("dp_cur_version", appVersionName).commit();
                            str = string;
                        }
                    }
                    this.h = str;
                    return str;
                }
            } catch (Throwable unused) {
            }
            str = imprintProperty;
        } catch (Throwable unused2) {
        }
        this.h = str;
        return str;
    }

    private String i() {
        String str = null;
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f3620a, "ud_da", (String) null);
            try {
                if (TextUtils.isEmpty(imprintProperty)) {
                    if (!TextUtils.isEmpty(this.i)) {
                        return this.i;
                    }
                    if (this.e == null) {
                        this.e = PreferenceWrapper.getDefault(f3620a);
                    }
                    str = this.e.getString("dp_pre_date", "");
                    if (TextUtils.isEmpty(str)) {
                        str = new SimpleDateFormat(com.cyjh.http.e.a.f2523b, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                        this.e.edit().putString("dp_pre_date", str).commit();
                    } else {
                        String format = new SimpleDateFormat(com.cyjh.http.e.a.f2523b, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                        if (!str.equals(format)) {
                            this.e.edit().putString("dp_pre_date", format).commit();
                            str = format;
                        }
                    }
                    this.i = str;
                    return str;
                }
            } catch (Throwable unused) {
            }
            str = imprintProperty;
        } catch (Throwable unused2) {
        }
        this.i = str;
        return str;
    }

    private void j() {
        try {
            this.n = 0;
            this.o = 0;
            this.p = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f3620a).edit().putLong(t, System.currentTimeMillis()).putInt(u, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean k() {
        try {
            if (!TextUtils.isEmpty(o.a().c())) {
                b(f3620a);
            }
            if (this.l.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.l.length(); i2++) {
                JSONObject optJSONObject = this.l.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || y.equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void l() {
        if (this.l.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.l.length(); i2++) {
                try {
                    JSONObject jSONObject = this.l.getJSONObject(i2);
                    if (jSONObject != null && jSONObject.length() > 0) {
                        String optString = jSONObject.optString("__i");
                        if (TextUtils.isEmpty(optString) || y.equals(optString)) {
                            String c2 = o.a().c();
                            if (TextUtils.isEmpty(c2)) {
                                c2 = y;
                            }
                            jSONObject.put("__i", c2);
                        }
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            this.l = jSONArray;
        }
    }

    private void m() {
        SharedPreferences sharedPreferences;
        try {
            if (n() && f3620a != null && (sharedPreferences = PreferenceWrapper.getDefault(f3620a)) != null && sharedPreferences.getLong(q, 0) == 0) {
                sharedPreferences.edit().putLong(q, System.currentTimeMillis()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r0 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(f3620a);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean n() {
        /*
            r5 = this;
            android.content.Context r0 = f3620a     // Catch:{ Throwable -> 0x001c }
            if (r0 == 0) goto L_0x001c
            android.content.Context r0 = f3620a     // Catch:{ Throwable -> 0x001c }
            android.content.SharedPreferences r0 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(r0)     // Catch:{ Throwable -> 0x001c }
            if (r0 == 0) goto L_0x001c
            java.lang.String r1 = "ana_is_f"
            r2 = -1
            long r0 = r0.getLong(r1, r2)     // Catch:{ Throwable -> 0x001c }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x001c
            r0 = 1
            return r0
        L_0x001c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.n():boolean");
    }

    private void o() {
        try {
            b(f3620a);
            a();
            String[] a2 = com.umeng.analytics.c.a(f3620a);
            if (a2 != null && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
                boolean a3 = o.a().a(f3620a, System.currentTimeMillis());
                com.umeng.analytics.c.b(f3620a);
                if (a3) {
                    o.a().b(f3620a, System.currentTimeMillis());
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public JSONObject a(long j2) {
        if (TextUtils.isEmpty(o.a().c(f3620a))) {
            return null;
        }
        JSONObject b2 = b(false);
        int a2 = l.a().a(f3620a);
        if (b2.length() <= 0) {
            return null;
        }
        if (b2.length() == 1) {
            if (b2.optJSONObject(b.G) != null && a2 != 3) {
                return null;
            }
            if (!TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
                return null;
            }
        } else if (b2.length() == 2 && b2.optJSONObject(b.G) != null && !TextUtils.isEmpty(b2.optString("userlevel")) && a2 != 3) {
            return null;
        }
        JSONObject d2 = d(false);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a2 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b2 != null && b2.length() > 0) {
                jSONObject2.put("analytics", b2);
            }
            if (d2 != null && d2.length() > 0) {
                jSONObject.put("header", d2);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put(b.W, jSONObject2);
            }
            return a(jSONObject, j2);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public void a() {
        try {
            if (this.l.length() > 0) {
                g.a(f3620a).a(this.l);
                this.l = new JSONArray();
            }
            PreferenceWrapper.getDefault(f3620a).edit().putLong(s, this.p).putInt(v, this.n).putInt(w, this.o).commit();
        } catch (Throwable unused) {
        }
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() <= 0) {
                    return;
                }
                if (!jSONObject.has(b.ao)) {
                    c(jSONObject);
                } else if (101 != jSONObject.getInt(b.ao)) {
                    c(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, int i2) {
        switch (i2) {
            case 4097:
                if (obj != null) {
                    try {
                        d(obj);
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (!y.equals(((JSONObject) obj).optString("__i"))) {
                    a(false);
                    return;
                }
                return;
            case 4098:
                if (obj != null) {
                    try {
                        d(obj);
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                if (!y.equals(((JSONObject) obj).optString("__i"))) {
                    a(false);
                    return;
                }
                return;
            case 4099:
                p.a(f3620a);
                return;
            case a.d /*4100*/:
                h.b(f3620a);
                return;
            case a.e /*4101*/:
                e(obj);
                return;
            case a.f /*4102*/:
                o();
                return;
            case a.g /*4103*/:
                o.a().a(f3620a, obj);
                return;
            case a.h /*4104*/:
                o.a().b(f3620a, obj);
                return;
            case a.i /*4105*/:
                a();
                return;
            case a.j /*4106*/:
                f(obj);
                return;
            default:
                switch (i2) {
                    case a.k /*8193*/:
                        a(obj, 1, false);
                        return;
                    case 8194:
                        m.a(f3620a).a(obj);
                        return;
                    case a.m /*8195*/:
                        com.umeng.analytics.b.a().a(obj);
                        return;
                    case a.n /*8196*/:
                        com.umeng.analytics.b.a().j();
                        return;
                    case a.o /*8197*/:
                        com.umeng.analytics.b.a().h();
                        return;
                    default:
                        return;
                }
        }
    }

    public void a(Object obj, int i2, boolean z2) {
        String str;
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String optString = jSONObject.optString("__ii");
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3620a);
                if (i2 == 0) {
                    long j2 = sharedPreferences.getLong(t, 0);
                    int i3 = sharedPreferences.getInt(u, 0);
                    if (a(j2, i3)) {
                        sharedPreferences.edit().putLong(t, System.currentTimeMillis()).putInt(u, i3 == 5000 ? 0 : i3 + 1).commit();
                    } else {
                        return;
                    }
                }
                String string = sharedPreferences.getString(B, "");
                JSONArray jSONArray = TextUtils.isEmpty(string) ? new JSONArray() : new JSONArray(string);
                JSONObject i4 = com.umeng.analytics.b.a().i();
                if (y.equals(optString)) {
                    jSONObject.put(C, i2);
                    if (!jSONObject.has(b.ab) && i4.length() > 0) {
                        jSONObject.put(b.ab, i4);
                    }
                    jSONArray.put(jSONObject);
                    sharedPreferences.edit().putString(B, jSONArray.toString()).commit();
                    return;
                }
                if (i2 != 3 && jSONArray.length() > 0) {
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                        if (jSONObject2 != null && jSONObject2.length() > 0) {
                            int i6 = jSONObject2.getInt(C);
                            if (!jSONObject2.has(b.ab) && i4.length() > 0) {
                                jSONObject2.put(b.ab, i4);
                            }
                            switch (i6) {
                                case 0:
                                    str = "_$!ts";
                                    break;
                                case 1:
                                    str = "_$!ts";
                                    break;
                            }
                            jSONObject2.put(str, System.currentTimeMillis());
                            jSONObject2.put("__ii", optString);
                            jSONObject2.remove(C);
                            g.a(f3620a).a(jSONObject2, i6);
                        }
                    }
                    com.umeng.analytics.b.a().d();
                    sharedPreferences.edit().remove(B).commit();
                }
                g.a(f3620a).a(jSONObject, i2);
                if (z2) {
                    c(true);
                } else if (UMEnvelopeBuild.isReadyBuild(f3620a, UMLogDataProtocol.UMBusinessType.U_DPLUS)) {
                    Defcon service = Defcon.getService(f3620a);
                    if (!service.isOpen()) {
                        c(true);
                    } else if (new ReportPolicy.DefconPolicy(StatTracer.getInstance(f3620a), service).shouldSendMessage(false)) {
                        c(true);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(JSONObject jSONObject) {
        JSONObject d2;
        try {
            if (UMEnvelopeBuild.isReadyBuild(f3620a, UMLogDataProtocol.UMBusinessType.U_DPLUS) && jSONObject != null && (d2 = d(true)) != null && d2.length() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(b.ac, jSONArray);
                jSONObject2.put("dplus", jSONObject3);
                if (f3620a != null && d2 != null) {
                    UMEnvelopeBuild.buildEnvelopeWithExtHeader(f3620a, d2, jSONObject2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z2) {
        if (e(z2) && UMEnvelopeBuild.isReadyBuild(f3620a, UMLogDataProtocol.UMBusinessType.U_APP)) {
            c(false);
        }
    }

    public JSONObject b(long j2) {
        if (!AnalyticsConfig.FLAG_DPLUS || TextUtils.isEmpty(o.a().c(f3620a))) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (AnalyticsConfig.FLAG_DPLUS) {
            jSONObject = g.a(f3620a).c();
            l.a().a(jSONObject, f3620a);
            Defcon service = Defcon.getService(f3620a);
            if (service.isOpen() && !new ReportPolicy.DefconPolicy(StatTracer.getInstance(f3620a), service).shouldSendMessage(false)) {
                jSONObject = new JSONObject();
            }
        }
        if (jSONObject.length() <= 0) {
            return null;
        }
        JSONObject d2 = d(true);
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject != null && jSONObject.length() > 0) {
                jSONObject3.put("dplus", jSONObject);
            }
            if (d2 != null && d2.length() > 0) {
                jSONObject2.put("header", d2);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put(b.W, jSONObject3);
            }
            return a(jSONObject2, j2);
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    public JSONObject b(boolean z2) {
        try {
            JSONObject a2 = g.a(f3620a).a(z2);
            if (a2 == null) {
                try {
                    a2 = new JSONObject();
                } catch (Throwable unused) {
                    return a2;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3620a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    a2.put("userlevel", string);
                }
            }
            if (n()) {
                this.j = c();
                if (this.j != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", this.j);
                    a2.put(b.D, jSONObject);
                    sharedPreferences.edit().putLong(r, 0).commit();
                }
            }
            String[] a3 = com.umeng.analytics.c.a(f3620a);
            if (a3 != null && !TextUtils.isEmpty(a3[0]) && !TextUtils.isEmpty(a3[1])) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(b.H, a3[0]);
                jSONObject2.put(b.I, a3[1]);
                if (jSONObject2.length() > 0) {
                    a2.put(b.G, jSONObject2);
                }
            }
            if (ABTest.getService(f3620a).isInTest()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(ABTest.getService(f3620a).getTestName(), ABTest.getService(f3620a).getGroupInfo());
                a2.put(b.F, jSONObject3);
            }
            l.a().b(a2, f3620a);
            if (a2.length() <= 0) {
                return a2;
            }
            new JSONObject().put("analytics", a2);
            return a2;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void b() {
        z = true;
        c(false);
    }

    public void b(Context context) {
        try {
            g.a(context).b();
            l();
        } catch (Throwable unused) {
        }
    }

    public void b(Object obj) {
        z = true;
        b(f3620a);
        a();
        c(false);
        if (AnalyticsConfig.FLAG_DPLUS) {
            a(obj, 2, false);
        }
    }

    public long c() {
        SharedPreferences sharedPreferences;
        long j2 = 0;
        try {
            if (f3620a == null || (sharedPreferences = PreferenceWrapper.getDefault(f3620a)) == null) {
                return 0;
            }
            long j3 = sharedPreferences.getLong(q, 0);
            if (j3 == 0) {
                try {
                    j2 = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(q, j2).commit();
                    return j2;
                } catch (Throwable unused) {
                }
            }
            return j3;
        } catch (Throwable unused2) {
            return j2;
        }
    }

    public void c(Object obj) {
        m();
        A = true;
        f();
        g();
        h();
        i();
        a(true);
        if (AnalyticsConfig.FLAG_DPLUS) {
            a(obj, 2, false);
        }
    }

    public void d() {
        String str;
        try {
            String c2 = o.a().c();
            if (!TextUtils.isEmpty(c2)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3620a);
                String string = sharedPreferences.getString(B, "");
                JSONArray jSONArray = TextUtils.isEmpty(string) ? new JSONArray() : new JSONArray(string);
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null && jSONObject.length() > 0) {
                            int i3 = jSONObject.getInt(C);
                            switch (i3) {
                                case 0:
                                    str = "_$!ts";
                                    break;
                                case 1:
                                    str = "_$!ts";
                                    break;
                            }
                            jSONObject.put(str, System.currentTimeMillis());
                            jSONObject.put("__ii", c2);
                            jSONObject.remove(C);
                            g.a(f3620a).a(jSONObject, i3);
                        }
                    }
                    sharedPreferences.edit().remove(B).commit();
                    if (UMEnvelopeBuild.isReadyBuild(f3620a, UMLogDataProtocol.UMBusinessType.U_DPLUS)) {
                        c(true);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
