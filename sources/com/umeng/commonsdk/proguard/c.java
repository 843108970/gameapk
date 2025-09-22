package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.os.Build;
import com.umeng.analytics.pro.b;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.e;
import org.json.JSONArray;
import org.json.JSONObject;

public class c implements UMLogDataProtocol {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3759b = "info";

    /* renamed from: c  reason: collision with root package name */
    private static final String f3760c = "stat";

    /* renamed from: a  reason: collision with root package name */
    private Context f3761a;

    public c(Context context) {
        if (context != null) {
            this.f3761a = context.getApplicationContext();
        }
    }

    private static void a(Context context) {
        WifiInfo c2;
        if (context != null && (c2 = j.c(context)) != null) {
            j.c cVar = new j.c();
            cVar.f3783a = c2.describeContents();
            cVar.f3784b = c2.getBSSID();
            cVar.f3785c = c2.getSSID();
            cVar.d = Build.VERSION.SDK_INT >= 21 ? c2.getFrequency() : -1;
            boolean z = false;
            if (c2.getHiddenSSID()) {
                cVar.e = 1;
            } else {
                cVar.e = 0;
            }
            cVar.f = c2.getIpAddress();
            cVar.g = c2.getLinkSpeed();
            cVar.h = DeviceConfig.getMac(context);
            cVar.i = c2.getNetworkId();
            cVar.j = c2.getRssi();
            cVar.k = j.g(context);
            cVar.l = System.currentTimeMillis();
            if (c2 != null) {
                try {
                    JSONArray b2 = n.b(context);
                    if (b2 != null && b2.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i < b2.length()) {
                                String optString = b2.optJSONObject(i).optString("ssid", (String) null);
                                if (optString != null && optString.equals(cVar.f3785c)) {
                                    z = true;
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    }
                    if (!z) {
                        n.a(context, cVar);
                    }
                } catch (Exception e) {
                    e.e("wifiChange:" + e.getMessage());
                }
            }
        }
    }

    public void removeCacheData(Object obj) {
    }

    public JSONObject setupReportData(long j) {
        return null;
    }

    public void workEvent(Object obj, int i) {
        e.a("walle", "[internal] workEvent");
        switch (i) {
            case a.e:
                try {
                    e.a("walle", "[internal] workEvent send envelope");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(v.aq, a.d);
                    JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.f3761a, jSONObject, d.d(this.f3761a));
                    if (buildEnvelopeWithExtHeader != null && !buildEnvelopeWithExtHeader.has(b.ao)) {
                        e.a("walle", "[internal] workEvent send envelope back, result is ok");
                        j.f(this.f3761a);
                        r.d(this.f3761a);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.a(this.f3761a, e);
                    return;
                }
            case a.f:
                try {
                    e.a("walle", "[internal] workEvent cache location, event is " + obj.toString());
                    SharedPreferences sharedPreferences = this.f3761a.getSharedPreferences(h.f3772a, 0);
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.f3773b, obj.toString());
                        edit.commit();
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e.a(this.f3761a, e2);
                    return;
                }
            case a.g:
                try {
                    e.a("walle", "[internal] workEvent cache battery, event is " + obj.toString());
                    s.b(this.f3761a, obj.toString());
                    return;
                } catch (Exception e3) {
                    e.a(this.f3761a, e3);
                    return;
                }
            case a.h:
                try {
                    e.a("walle", "[internal] workEvent cache station, event is " + obj.toString());
                    s.a(this.f3761a, obj.toString());
                    return;
                } catch (Exception e4) {
                    e.a(this.f3761a, e4);
                    return;
                }
            case a.i:
                n.a(this.f3761a, (j.b) obj);
                return;
            case a.j:
                try {
                    a(this.f3761a);
                    return;
                } catch (Exception e5) {
                    e.e("UM_INTERNAL_CACHE_WIFICHANGE_KEY:" + e5.getMessage());
                    e.a(this.f3761a, e5);
                    return;
                }
            case a.k:
                n.a(this.f3761a, (String) obj);
                return;
            case a.l:
                SharedPreferences sharedPreferences2 = this.f3761a.getApplicationContext().getSharedPreferences(f3759b, 0);
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putString(f3760c, (String) obj).commit();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
