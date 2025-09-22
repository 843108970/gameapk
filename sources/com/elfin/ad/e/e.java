package com.elfin.ad.e;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebView;
import com.android.volley.m;
import com.android.volley.n;
import com.android.volley.toolbox.s;
import com.android.volley.toolbox.t;
import com.cyjh.common.util.f;
import com.cyjh.common.util.p;
import com.cyjh.common.util.x;
import com.elfin.ad.bean.response.FengLingAdInfo;
import com.elfin.ad.c.a;
import com.github.kevinsawicki.http.HttpRequest;
import com.umeng.commonsdk.proguard.v;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.litepal.g.b;
import org.slf4j.Marker;

public class e {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f2880a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static final int f2881b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2882c = 2;
    public static final String d = "__EVENT_TIME__";
    public static final String e = "__CLICK_DOWN_X__";
    public static final String f = "_CLICK_DOWN_Y__";
    public static final String g = "__CLICK_UP_X__";
    public static final String h = "__CLICK_UP_Y__";
    public static String n = "0.0.0.0";
    int i;
    /* access modifiers changed from: package-private */
    public a<FengLingAdInfo> j;
    Context k;
    String l;
    /* access modifiers changed from: package-private */
    public String m;

    static String a() {
        return "true";
    }

    static String a(Context context) {
        return com.cyjh.common.util.a.a(context).x + Marker.ANY_MARKER + com.cyjh.common.util.a.a(context).y;
    }

    private Map<String, Object> a(Context context, int i2, String str) {
        String str2;
        int i3;
        int i4;
        int i5 = 2;
        if (i2 == 2) {
            str2 = "101478";
            i4 = 640;
            i3 = 960;
        } else {
            str2 = "101477";
            i4 = 600;
            i3 = 300;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("id", "5e1f6df6cc024c80b7e8b86dc670c100");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("adPid", str2);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("width", Integer.valueOf(i4));
        hashMap4.put("height", Integer.valueOf(i3));
        hashMap3.put("banner", hashMap4);
        hashMap3.put("usingHttps", "true");
        hashMap3.put("isSupportDeeplink", "false");
        HashMap hashMap5 = new HashMap();
        hashMap5.put("imei", com.cyjh.common.util.a.b(context));
        hashMap5.put("androidId", com.cyjh.common.util.a.g(context));
        hashMap5.put("ip", str);
        int b2 = x.b(context);
        if (b2 != -1) {
            switch (b2) {
                case 1:
                    i5 = 1;
                    break;
                case 2:
                    break;
                case 3:
                    i5 = 3;
                    break;
                case 4:
                    i5 = 4;
                    break;
                default:
                    i5 = 0;
                    break;
            }
        } else {
            i5 = 5;
        }
        hashMap5.put("nt", String.valueOf(i5));
        hashMap5.put("platform", "4");
        hashMap5.put("lan", "zh_CN");
        hashMap5.put("rslt", com.cyjh.common.util.a.a(context).x + Marker.ANY_MARKER + com.cyjh.common.util.a.a(context).y);
        hashMap5.put("osv", com.cyjh.common.util.a.a());
        hashMap5.put(v.K, com.cyjh.common.util.a.h(context));
        hashMap5.put("sendtime", String.valueOf(System.currentTimeMillis()));
        hashMap5.put(v.H, "480");
        hashMap5.put("mac", com.cyjh.common.util.a.i(context));
        hashMap5.put("appVer", com.cyjh.common.util.a.f(context));
        hashMap5.put("cc", "CN");
        hashMap5.put("orientation", "1");
        String str3 = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
            str3 = telephonyManager.getSubscriberId();
        }
        hashMap5.put("imsi", str3);
        hashMap5.put("brand", d());
        hashMap5.put("dm", e());
        hashMap5.put("ua", this.m);
        HashMap hashMap6 = new HashMap();
        String[] a2 = p.a(context).a();
        hashMap6.put("lon", a2[0]);
        hashMap6.put("lat", a2[1]);
        hashMap5.put("geo", hashMap6);
        hashMap.put("site", hashMap2);
        hashMap.put("imp", hashMap3);
        hashMap.put("device", hashMap5);
        return hashMap;
    }

    private void a(Context context, String str, final a<FengLingAdInfo> aVar) {
        this.j = aVar;
        String str2 = f2880a;
        Log.d(str2, "reportLogInfo params -> " + str);
        t.a(context).a(new s(str, new n.b<String>() {
            private void a(String str) {
                String f = e.f2880a;
                Log.d(f, "onResponse -> " + str.toString());
                try {
                    if ("OK".equals(str)) {
                        aVar.a(new FengLingAdInfo());
                        return;
                    }
                    aVar.a("请求数据失败！");
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar.a("解析数据失败！");
                }
            }

            public final /* synthetic */ void a(Object obj) {
                String str = (String) obj;
                String f = e.f2880a;
                Log.d(f, "onResponse -> " + str.toString());
                try {
                    if ("OK".equals(str)) {
                        aVar.a(new FengLingAdInfo());
                        return;
                    }
                    aVar.a("请求数据失败！");
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar.a("解析数据失败！");
                }
            }
        }, new n.a() {
            public final void a(com.android.volley.s sVar) {
                Log.e(e.f2880a, sVar.getMessage(), sVar);
                aVar.a(sVar.getMessage());
            }
        }) {
            public final Map<String, String> b() {
                HashMap hashMap = new HashMap();
                hashMap.put("Charset", "UTF-8");
                hashMap.put("Content-Type", "application/x-javascript");
                hashMap.put(HttpRequest.HEADER_ACCEPT_ENCODING, "gzip,deflate");
                hashMap.put("User-Agent", e.this.m);
                return hashMap;
            }
        });
    }

    private void a(a<FengLingAdInfo> aVar, Context context, String str) {
        int i2;
        int i3;
        String str2;
        int i4 = 2;
        this.i = 2;
        this.j = aVar;
        this.k = context;
        this.l = str;
        this.m = f.b(context);
        String str3 = n;
        m a2 = t.a(this.k);
        Context context2 = this.k;
        if (this.i == 2) {
            str2 = "101478";
            i3 = 640;
            i2 = 960;
        } else {
            str2 = "101477";
            i3 = 600;
            i2 = 300;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("id", "5e1f6df6cc024c80b7e8b86dc670c100");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("adPid", str2);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("width", Integer.valueOf(i3));
        hashMap4.put("height", Integer.valueOf(i2));
        hashMap3.put("banner", hashMap4);
        hashMap3.put("usingHttps", "true");
        hashMap3.put("isSupportDeeplink", "false");
        HashMap hashMap5 = new HashMap();
        hashMap5.put("imei", com.cyjh.common.util.a.b(context2));
        hashMap5.put("androidId", com.cyjh.common.util.a.g(context2));
        hashMap5.put("ip", str3);
        int b2 = x.b(context2);
        if (b2 != -1) {
            switch (b2) {
                case 1:
                    i4 = 1;
                    break;
                case 2:
                    break;
                case 3:
                    i4 = 3;
                    break;
                case 4:
                    i4 = 4;
                    break;
                default:
                    i4 = 0;
                    break;
            }
        } else {
            i4 = 5;
        }
        hashMap5.put("nt", String.valueOf(i4));
        hashMap5.put("platform", "4");
        hashMap5.put("lan", "zh_CN");
        hashMap5.put("rslt", com.cyjh.common.util.a.a(context2).x + Marker.ANY_MARKER + com.cyjh.common.util.a.a(context2).y);
        hashMap5.put("osv", com.cyjh.common.util.a.a());
        hashMap5.put(v.K, com.cyjh.common.util.a.h(context2));
        hashMap5.put("sendtime", String.valueOf(System.currentTimeMillis()));
        hashMap5.put(v.H, "480");
        hashMap5.put("mac", com.cyjh.common.util.a.i(context2));
        hashMap5.put("appVer", com.cyjh.common.util.a.f(context2));
        hashMap5.put("cc", "CN");
        hashMap5.put("orientation", "1");
        String str4 = "";
        TelephonyManager telephonyManager = (TelephonyManager) context2.getSystemService("phone");
        if (ActivityCompat.checkSelfPermission(context2, "android.permission.READ_PHONE_STATE") == 0) {
            str4 = telephonyManager.getSubscriberId();
        }
        hashMap5.put("imsi", str4);
        hashMap5.put("brand", d());
        hashMap5.put("dm", e());
        hashMap5.put("ua", this.m);
        HashMap hashMap6 = new HashMap();
        String[] a3 = p.a(context2).a();
        hashMap6.put("lon", a3[0]);
        hashMap6.put("lat", a3[1]);
        hashMap5.put("geo", hashMap6);
        hashMap.put("site", hashMap2);
        hashMap.put("imp", hashMap3);
        hashMap.put("device", hashMap5);
        JSONObject jSONObject = new JSONObject(hashMap);
        String str5 = f2880a;
        Log.d(str5, "getFengLingAdInfo params -> " + jSONObject.toString());
        a2.a(new com.android.volley.toolbox.n(this.l, jSONObject, new n.b<JSONObject>() {
            private void a(JSONObject jSONObject) {
                String f = e.f2880a;
                Log.d(f, "onResponse -> " + jSONObject.toString());
                try {
                    if (jSONObject.getInt("code") == 0) {
                        JSONArray jSONArray = jSONObject.getJSONArray("ads");
                        FengLingAdInfo fengLingAdInfo = new FengLingAdInfo();
                        if (jSONArray.length() > 0) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
                            fengLingAdInfo.f2851a = jSONObject2.getInt("creativeType");
                            fengLingAdInfo.f2852b = jSONObject2.getInt("drawType");
                            fengLingAdInfo.f2853c = jSONObject2.getInt("actionName");
                            fengLingAdInfo.d = jSONObject2.getInt("width");
                            fengLingAdInfo.e = jSONObject2.getInt("height");
                            fengLingAdInfo.f = jSONObject2.getString("title");
                            fengLingAdInfo.g = jSONObject2.getInt("rating");
                            JSONObject jSONObject3 = (JSONObject) jSONObject2.getJSONArray("imgs").get(0);
                            fengLingAdInfo.getClass();
                            FengLingAdInfo.a aVar = new FengLingAdInfo.a();
                            aVar.f2854a = jSONObject3.getInt("height");
                            aVar.f2855b = jSONObject3.getInt("width");
                            aVar.f2856c = jSONObject3.getString("src");
                            fengLingAdInfo.h = aVar;
                            fengLingAdInfo.i = jSONObject2.getString("adPlatformIcon");
                            fengLingAdInfo.j = jSONObject2.getInt("adId");
                            fengLingAdInfo.k = jSONObject2.getString("clickUrl");
                            JSONObject jSONObject4 = jSONObject2.getJSONObject("webTracks");
                            fengLingAdInfo.getClass();
                            FengLingAdInfo.b bVar = new FengLingAdInfo.b();
                            bVar.f2857a = jSONObject4.getInt(b.c.f4839c);
                            JSONArray jSONArray2 = jSONObject4.getJSONArray("imptrackUrls");
                            if (jSONArray2.length() > 0) {
                                bVar.f2858b = com.cyjh.common.util.e.a(jSONArray2);
                            }
                            JSONArray jSONArray3 = jSONObject4.getJSONArray("ctrackUrls");
                            if (jSONArray3.length() > 0) {
                                bVar.f2859c = com.cyjh.common.util.e.a(jSONArray3);
                            }
                            JSONArray jSONArray4 = jSONObject4.getJSONArray("dstrackUrls");
                            if (jSONArray4.length() > 0) {
                                bVar.d = com.cyjh.common.util.e.a(jSONArray4);
                            }
                            JSONArray jSONArray5 = jSONObject4.getJSONArray("istrackUrls");
                            if (jSONArray5.length() > 0) {
                                bVar.e = com.cyjh.common.util.e.a(jSONArray5);
                            }
                            fengLingAdInfo.l = bVar;
                            fengLingAdInfo.m = jSONObject2.getInt("adPlatformId");
                            e.this.j.a(fengLingAdInfo);
                            return;
                        }
                        e.this.j.a("无有效广告数据！");
                        return;
                    }
                    e.this.j.a("请求数据失败！");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.this.j.a("解析数据失败！");
                }
            }

            public final /* synthetic */ void a(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                String f = e.f2880a;
                Log.d(f, "onResponse -> " + jSONObject.toString());
                try {
                    if (jSONObject.getInt("code") == 0) {
                        JSONArray jSONArray = jSONObject.getJSONArray("ads");
                        FengLingAdInfo fengLingAdInfo = new FengLingAdInfo();
                        if (jSONArray.length() > 0) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
                            fengLingAdInfo.f2851a = jSONObject2.getInt("creativeType");
                            fengLingAdInfo.f2852b = jSONObject2.getInt("drawType");
                            fengLingAdInfo.f2853c = jSONObject2.getInt("actionName");
                            fengLingAdInfo.d = jSONObject2.getInt("width");
                            fengLingAdInfo.e = jSONObject2.getInt("height");
                            fengLingAdInfo.f = jSONObject2.getString("title");
                            fengLingAdInfo.g = jSONObject2.getInt("rating");
                            JSONObject jSONObject3 = (JSONObject) jSONObject2.getJSONArray("imgs").get(0);
                            fengLingAdInfo.getClass();
                            FengLingAdInfo.a aVar = new FengLingAdInfo.a();
                            aVar.f2854a = jSONObject3.getInt("height");
                            aVar.f2855b = jSONObject3.getInt("width");
                            aVar.f2856c = jSONObject3.getString("src");
                            fengLingAdInfo.h = aVar;
                            fengLingAdInfo.i = jSONObject2.getString("adPlatformIcon");
                            fengLingAdInfo.j = jSONObject2.getInt("adId");
                            fengLingAdInfo.k = jSONObject2.getString("clickUrl");
                            JSONObject jSONObject4 = jSONObject2.getJSONObject("webTracks");
                            fengLingAdInfo.getClass();
                            FengLingAdInfo.b bVar = new FengLingAdInfo.b();
                            bVar.f2857a = jSONObject4.getInt(b.c.f4839c);
                            JSONArray jSONArray2 = jSONObject4.getJSONArray("imptrackUrls");
                            if (jSONArray2.length() > 0) {
                                bVar.f2858b = com.cyjh.common.util.e.a(jSONArray2);
                            }
                            JSONArray jSONArray3 = jSONObject4.getJSONArray("ctrackUrls");
                            if (jSONArray3.length() > 0) {
                                bVar.f2859c = com.cyjh.common.util.e.a(jSONArray3);
                            }
                            JSONArray jSONArray4 = jSONObject4.getJSONArray("dstrackUrls");
                            if (jSONArray4.length() > 0) {
                                bVar.d = com.cyjh.common.util.e.a(jSONArray4);
                            }
                            JSONArray jSONArray5 = jSONObject4.getJSONArray("istrackUrls");
                            if (jSONArray5.length() > 0) {
                                bVar.e = com.cyjh.common.util.e.a(jSONArray5);
                            }
                            fengLingAdInfo.l = bVar;
                            fengLingAdInfo.m = jSONObject2.getInt("adPlatformId");
                            e.this.j.a(fengLingAdInfo);
                            return;
                        }
                        e.this.j.a("无有效广告数据！");
                        return;
                    }
                    e.this.j.a("请求数据失败！");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.this.j.a("解析数据失败！");
                }
            }
        }, new n.a() {
            public final void a(com.android.volley.s sVar) {
                Log.e(e.f2880a, sVar.getMessage(), sVar);
                e.this.j.a(sVar.getMessage());
            }
        }) {
            public final Map<String, String> b() {
                HashMap hashMap = new HashMap();
                hashMap.put(HttpRequest.HEADER_ACCEPT, "application/json");
                hashMap.put("Content-Type", "application/json; charset=UTF-8");
                hashMap.put("User-Agent", e.this.m);
                return hashMap;
            }
        });
    }

    private void a(String str) {
        int i2;
        int i3;
        String str2;
        m a2 = t.a(this.k);
        Context context = this.k;
        int i4 = 2;
        if (this.i == 2) {
            str2 = "101478";
            i3 = 640;
            i2 = 960;
        } else {
            str2 = "101477";
            i3 = 600;
            i2 = 300;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("id", "5e1f6df6cc024c80b7e8b86dc670c100");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("adPid", str2);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("width", Integer.valueOf(i3));
        hashMap4.put("height", Integer.valueOf(i2));
        hashMap3.put("banner", hashMap4);
        hashMap3.put("usingHttps", "true");
        hashMap3.put("isSupportDeeplink", "false");
        HashMap hashMap5 = new HashMap();
        hashMap5.put("imei", com.cyjh.common.util.a.b(context));
        hashMap5.put("androidId", com.cyjh.common.util.a.g(context));
        hashMap5.put("ip", str);
        int b2 = x.b(context);
        if (b2 != -1) {
            switch (b2) {
                case 1:
                    i4 = 1;
                    break;
                case 2:
                    break;
                case 3:
                    i4 = 3;
                    break;
                case 4:
                    i4 = 4;
                    break;
                default:
                    i4 = 0;
                    break;
            }
        } else {
            i4 = 5;
        }
        hashMap5.put("nt", String.valueOf(i4));
        hashMap5.put("platform", "4");
        hashMap5.put("lan", "zh_CN");
        hashMap5.put("rslt", com.cyjh.common.util.a.a(context).x + Marker.ANY_MARKER + com.cyjh.common.util.a.a(context).y);
        hashMap5.put("osv", com.cyjh.common.util.a.a());
        hashMap5.put(v.K, com.cyjh.common.util.a.h(context));
        hashMap5.put("sendtime", String.valueOf(System.currentTimeMillis()));
        hashMap5.put(v.H, "480");
        hashMap5.put("mac", com.cyjh.common.util.a.i(context));
        hashMap5.put("appVer", com.cyjh.common.util.a.f(context));
        hashMap5.put("cc", "CN");
        hashMap5.put("orientation", "1");
        String str3 = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
            str3 = telephonyManager.getSubscriberId();
        }
        hashMap5.put("imsi", str3);
        hashMap5.put("brand", d());
        hashMap5.put("dm", e());
        hashMap5.put("ua", this.m);
        HashMap hashMap6 = new HashMap();
        String[] a3 = p.a(context).a();
        hashMap6.put("lon", a3[0]);
        hashMap6.put("lat", a3[1]);
        hashMap5.put("geo", hashMap6);
        hashMap.put("site", hashMap2);
        hashMap.put("imp", hashMap3);
        hashMap.put("device", hashMap5);
        JSONObject jSONObject = new JSONObject(hashMap);
        String str4 = f2880a;
        Log.d(str4, "getFengLingAdInfo params -> " + jSONObject.toString());
        a2.a(new com.android.volley.toolbox.n(this.l, jSONObject, new n.b<JSONObject>() {
            private void a(JSONObject jSONObject) {
                String f = e.f2880a;
                Log.d(f, "onResponse -> " + jSONObject.toString());
                try {
                    if (jSONObject.getInt("code") == 0) {
                        JSONArray jSONArray = jSONObject.getJSONArray("ads");
                        FengLingAdInfo fengLingAdInfo = new FengLingAdInfo();
                        if (jSONArray.length() > 0) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
                            fengLingAdInfo.f2851a = jSONObject2.getInt("creativeType");
                            fengLingAdInfo.f2852b = jSONObject2.getInt("drawType");
                            fengLingAdInfo.f2853c = jSONObject2.getInt("actionName");
                            fengLingAdInfo.d = jSONObject2.getInt("width");
                            fengLingAdInfo.e = jSONObject2.getInt("height");
                            fengLingAdInfo.f = jSONObject2.getString("title");
                            fengLingAdInfo.g = jSONObject2.getInt("rating");
                            JSONObject jSONObject3 = (JSONObject) jSONObject2.getJSONArray("imgs").get(0);
                            fengLingAdInfo.getClass();
                            FengLingAdInfo.a aVar = new FengLingAdInfo.a();
                            aVar.f2854a = jSONObject3.getInt("height");
                            aVar.f2855b = jSONObject3.getInt("width");
                            aVar.f2856c = jSONObject3.getString("src");
                            fengLingAdInfo.h = aVar;
                            fengLingAdInfo.i = jSONObject2.getString("adPlatformIcon");
                            fengLingAdInfo.j = jSONObject2.getInt("adId");
                            fengLingAdInfo.k = jSONObject2.getString("clickUrl");
                            JSONObject jSONObject4 = jSONObject2.getJSONObject("webTracks");
                            fengLingAdInfo.getClass();
                            FengLingAdInfo.b bVar = new FengLingAdInfo.b();
                            bVar.f2857a = jSONObject4.getInt(b.c.f4839c);
                            JSONArray jSONArray2 = jSONObject4.getJSONArray("imptrackUrls");
                            if (jSONArray2.length() > 0) {
                                bVar.f2858b = com.cyjh.common.util.e.a(jSONArray2);
                            }
                            JSONArray jSONArray3 = jSONObject4.getJSONArray("ctrackUrls");
                            if (jSONArray3.length() > 0) {
                                bVar.f2859c = com.cyjh.common.util.e.a(jSONArray3);
                            }
                            JSONArray jSONArray4 = jSONObject4.getJSONArray("dstrackUrls");
                            if (jSONArray4.length() > 0) {
                                bVar.d = com.cyjh.common.util.e.a(jSONArray4);
                            }
                            JSONArray jSONArray5 = jSONObject4.getJSONArray("istrackUrls");
                            if (jSONArray5.length() > 0) {
                                bVar.e = com.cyjh.common.util.e.a(jSONArray5);
                            }
                            fengLingAdInfo.l = bVar;
                            fengLingAdInfo.m = jSONObject2.getInt("adPlatformId");
                            e.this.j.a(fengLingAdInfo);
                            return;
                        }
                        e.this.j.a("无有效广告数据！");
                        return;
                    }
                    e.this.j.a("请求数据失败！");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.this.j.a("解析数据失败！");
                }
            }

            public final /* synthetic */ void a(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                String f = e.f2880a;
                Log.d(f, "onResponse -> " + jSONObject.toString());
                try {
                    if (jSONObject.getInt("code") == 0) {
                        JSONArray jSONArray = jSONObject.getJSONArray("ads");
                        FengLingAdInfo fengLingAdInfo = new FengLingAdInfo();
                        if (jSONArray.length() > 0) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
                            fengLingAdInfo.f2851a = jSONObject2.getInt("creativeType");
                            fengLingAdInfo.f2852b = jSONObject2.getInt("drawType");
                            fengLingAdInfo.f2853c = jSONObject2.getInt("actionName");
                            fengLingAdInfo.d = jSONObject2.getInt("width");
                            fengLingAdInfo.e = jSONObject2.getInt("height");
                            fengLingAdInfo.f = jSONObject2.getString("title");
                            fengLingAdInfo.g = jSONObject2.getInt("rating");
                            JSONObject jSONObject3 = (JSONObject) jSONObject2.getJSONArray("imgs").get(0);
                            fengLingAdInfo.getClass();
                            FengLingAdInfo.a aVar = new FengLingAdInfo.a();
                            aVar.f2854a = jSONObject3.getInt("height");
                            aVar.f2855b = jSONObject3.getInt("width");
                            aVar.f2856c = jSONObject3.getString("src");
                            fengLingAdInfo.h = aVar;
                            fengLingAdInfo.i = jSONObject2.getString("adPlatformIcon");
                            fengLingAdInfo.j = jSONObject2.getInt("adId");
                            fengLingAdInfo.k = jSONObject2.getString("clickUrl");
                            JSONObject jSONObject4 = jSONObject2.getJSONObject("webTracks");
                            fengLingAdInfo.getClass();
                            FengLingAdInfo.b bVar = new FengLingAdInfo.b();
                            bVar.f2857a = jSONObject4.getInt(b.c.f4839c);
                            JSONArray jSONArray2 = jSONObject4.getJSONArray("imptrackUrls");
                            if (jSONArray2.length() > 0) {
                                bVar.f2858b = com.cyjh.common.util.e.a(jSONArray2);
                            }
                            JSONArray jSONArray3 = jSONObject4.getJSONArray("ctrackUrls");
                            if (jSONArray3.length() > 0) {
                                bVar.f2859c = com.cyjh.common.util.e.a(jSONArray3);
                            }
                            JSONArray jSONArray4 = jSONObject4.getJSONArray("dstrackUrls");
                            if (jSONArray4.length() > 0) {
                                bVar.d = com.cyjh.common.util.e.a(jSONArray4);
                            }
                            JSONArray jSONArray5 = jSONObject4.getJSONArray("istrackUrls");
                            if (jSONArray5.length() > 0) {
                                bVar.e = com.cyjh.common.util.e.a(jSONArray5);
                            }
                            fengLingAdInfo.l = bVar;
                            fengLingAdInfo.m = jSONObject2.getInt("adPlatformId");
                            e.this.j.a(fengLingAdInfo);
                            return;
                        }
                        e.this.j.a("无有效广告数据！");
                        return;
                    }
                    e.this.j.a("请求数据失败！");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.this.j.a("解析数据失败！");
                }
            }
        }, new n.a() {
            public final void a(com.android.volley.s sVar) {
                Log.e(e.f2880a, sVar.getMessage(), sVar);
                e.this.j.a(sVar.getMessage());
            }
        }) {
            public final Map<String, String> b() {
                HashMap hashMap = new HashMap();
                hashMap.put(HttpRequest.HEADER_ACCEPT, "application/json");
                hashMap.put("Content-Type", "application/json; charset=UTF-8");
                hashMap.put("User-Agent", e.this.m);
                return hashMap;
            }
        });
    }

    static String b() {
        return "false";
    }

    static String b(Context context) {
        return ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0 ? "" : ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    static String c() {
        return "1";
    }

    private static String c(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    static String d() {
        try {
            return Build.BRAND;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    static String e() {
        try {
            return Build.MODEL;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String g() {
        return Locale.getDefault().getLanguage();
    }
}
