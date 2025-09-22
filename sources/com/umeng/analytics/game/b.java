package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.game.a;
import com.umeng.analytics.pro.r;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class b implements r {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3561a = true;
    private Context A;

    /* renamed from: b  reason: collision with root package name */
    private com.umeng.analytics.b f3562b = MobclickAgent.getAgent();

    /* renamed from: c  reason: collision with root package name */
    private a f3563c = null;
    private final int d = 100;
    private final int e = 1;
    private final int f = 0;
    private final int g = -1;
    private final int h = 1;
    private final String i = "level";
    private final String j = "pay";
    private final String k = "buy";
    private final String l = "use";
    private final String m = "bonus";
    private final String n = "item";
    private final String o = "cash";
    private final String p = "coin";
    private final String q = "source";
    private final String r = "amount";
    private final String s = "user_level";
    private final String t = "bonus_source";
    private final String u = "level";
    private final String v = NotificationCompat.CATEGORY_STATUS;
    private final String w = "duration";
    private final String x = "curtype";
    private final String y = "orderid";
    private final String z = "UMGameAgent.init(Context) should be called before any game api";

    public b() {
        f3561a = true;
    }

    private void a(String str, int i2) {
        if (this.A == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
        } else {
            a.C0052a b2 = this.f3563c.b(str);
            if (b2 != null) {
                long e2 = b2.e();
                if (e2 <= 0) {
                    MLog.d("level duration is 0");
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("level", str);
                hashMap.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i2));
                hashMap.put("duration", Long.valueOf(e2));
                if (this.f3563c.f3556b != null) {
                    hashMap.put("user_level", this.f3563c.f3556b);
                }
                this.f3562b.a(this.A, "level", (HashMap<String, Object>) hashMap);
                return;
            }
            MLog.w(String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
        }
    }

    public void a() {
        String str;
        MLog.d("App resume from background");
        if (this.A == null) {
            str = "UMGameAgent.init(Context) should be called before any game api";
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            str = "UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ";
        } else if (f3561a) {
            this.f3563c.b();
            return;
        } else {
            return;
        }
        MLog.e(str);
    }

    /* access modifiers changed from: package-private */
    public void a(double d2, double d3, int i2) {
        if (this.A == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("cash", Long.valueOf((long) (d2 * 100.0d)));
            hashMap.put("coin", Long.valueOf((long) (d3 * 100.0d)));
            hashMap.put("source", Integer.valueOf(i2));
            if (this.f3563c.f3556b != null) {
                hashMap.put("user_level", this.f3563c.f3556b);
            }
            if (this.f3563c.f3555a != null) {
                hashMap.put("level", this.f3563c.f3555a);
            }
            this.f3562b.a(this.A, "pay", (HashMap<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(double d2, int i2) {
        if (this.A == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("coin", Long.valueOf((long) (d2 * 100.0d)));
            hashMap.put("bonus_source", Integer.valueOf(i2));
            if (this.f3563c.f3556b != null) {
                hashMap.put("user_level", this.f3563c.f3556b);
            }
            if (this.f3563c.f3555a != null) {
                hashMap.put("level", this.f3563c.f3555a);
            }
            this.f3562b.a(this.A, "bonus", (HashMap<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(double d2, String str, double d3, int i2, String str2) {
        String str3;
        if (this.A == null) {
            str3 = "UMGameAgent.init(Context) should be called before any game api";
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            str3 = "UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ";
        } else if (d2 >= 0.0d && d3 >= 0.0d) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && str.length() > 0 && str.length() <= 3) {
                hashMap.put("curtype", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    int length = str2.getBytes("UTF-8").length;
                    if (length > 0 && length <= 1024) {
                        hashMap.put("orderid", str2);
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            hashMap.put("cash", Long.valueOf((long) (d2 * 100.0d)));
            hashMap.put("coin", Long.valueOf((long) (d3 * 100.0d)));
            hashMap.put("source", Integer.valueOf(i2));
            if (this.f3563c.f3556b != null) {
                hashMap.put("user_level", this.f3563c.f3556b);
            }
            if (this.f3563c.f3555a != null) {
                hashMap.put("level", this.f3563c.f3555a);
            }
            this.f3562b.a(this.A, "pay", (HashMap<String, Object>) hashMap);
            return;
        } else {
            return;
        }
        MLog.e(str3);
    }

    /* access modifiers changed from: package-private */
    public void a(double d2, String str, int i2, double d3, int i3) {
        if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
            return;
        }
        a(d2, d3 * ((double) i2), i3);
        a(str, i2, d3);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        if (context == null) {
            MLog.e("Context is null, can't init GameAgent");
            return;
        }
        this.A = context.getApplicationContext();
        this.f3562b.a((r) this);
        this.f3563c = new a(this.A);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        try {
            if (this.A == null) {
                MLog.e("UMGameAgent.init(Context) should be called before any game api");
                return;
            }
            this.f3563c.f3556b = str;
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.A);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("userlevel", str).commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, int i2, double d2) {
        if (this.A == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item", str);
            hashMap.put("amount", Integer.valueOf(i2));
            hashMap.put("coin", Long.valueOf((long) (((double) i2) * d2 * 100.0d)));
            if (this.f3563c.f3556b != null) {
                hashMap.put("user_level", this.f3563c.f3556b);
            }
            if (this.f3563c.f3555a != null) {
                hashMap.put("level", this.f3563c.f3555a);
            }
            this.f3562b.a(this.A, "buy", (HashMap<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, int i2, double d2, int i3) {
        if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
            return;
        }
        a(((double) i2) * d2, i3);
        a(str, i2, d2);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        MLog.d(String.format("Trace sleep time : %b", new Object[]{Boolean.valueOf(z2)}));
        f3561a = z2;
    }

    public void b() {
        String str;
        if (this.A == null) {
            str = "UMGameAgent.init(Context) should be called before any game api";
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            str = "UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ";
        } else if (f3561a) {
            this.f3563c.a();
            return;
        } else {
            return;
        }
        MLog.e(str);
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        if (this.A == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
        } else {
            this.f3563c.f3555a = str;
            this.f3563c.a(str);
            HashMap hashMap = new HashMap();
            hashMap.put("level", str);
            hashMap.put(NotificationCompat.CATEGORY_STATUS, 0);
            if (this.f3563c.f3556b != null) {
                hashMap.put("user_level", this.f3563c.f3556b);
            }
            this.f3562b.a(this.A, "level", (HashMap<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(String str, int i2, double d2) {
        if (this.A == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("item", str);
            hashMap.put("amount", Integer.valueOf(i2));
            hashMap.put("coin", Long.valueOf((long) (((double) i2) * d2 * 100.0d)));
            if (this.f3563c.f3556b != null) {
                hashMap.put("user_level", this.f3563c.f3556b);
            }
            if (this.f3563c.f3555a != null) {
                hashMap.put("level", this.f3563c.f3555a);
            }
            this.f3562b.a(this.A, "use", (HashMap<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        if (this.A == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
        } else {
            a(str, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        if (this.A == null) {
            MLog.e("UMGameAgent.init(Context) should be called before any game api");
        } else if (AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_DUM_NORMAL.toValue() || AnalyticsConfig.getVerticalType(this.A) == MobclickAgent.EScenarioType.E_UM_NORMAL.toValue()) {
            MLog.e("UMGameAgent class is UMGameAgent API, can't be use in no-game scenario. ");
        } else {
            a(str, -1);
        }
    }
}
