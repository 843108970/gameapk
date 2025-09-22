package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.statistics.common.e;
import org.json.JSONArray;
import org.json.JSONObject;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3799a = "info";

    /* renamed from: b  reason: collision with root package name */
    private static final String f3800b = "a_na";

    /* renamed from: c  reason: collision with root package name */
    private static final String f3801c = "a_st";
    private static final String d = "a_ad";
    private static final String e = "blueinfo";
    private static final String f = "a_dc";
    private static final String g = "bssid";
    private static final String h = "ssid";
    private static final String i = "a_fcy";
    private static final String j = "a_hssid";
    private static final String k = "a_ip";
    private static final String l = "a_ls";
    private static final String m = "a_mac";
    private static final String n = "a_nid";
    private static final String o = "rssi";
    private static final String p = "sta";
    private static final String q = "ts";
    private static final String r = "wifiinfo";
    private static final String s = "ua";

    public static JSONObject a(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f3799a, 0);
        if (sharedPreferences != null) {
            try {
                String string = sharedPreferences.getString(e, (String) null);
                if (string != null) {
                    return new JSONObject(string);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void a(Context context, j.b bVar) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f3799a, 0);
            String str = null;
            if (sharedPreferences != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f3800b, bVar.f3782c);
                jSONObject.put(f3801c, bVar.f3781b);
                jSONObject.put(d, bVar.f3780a);
                jSONObject.put("ts", System.currentTimeMillis());
                str = jSONObject.toString();
            }
            if (str != null) {
                sharedPreferences.edit().putString(e, str).commit();
            }
        } catch (Exception e2) {
            e.e("saveBluetoothInfo:" + e2.getMessage());
        }
    }

    public static void a(Context context, j.c cVar) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f3799a, 0);
            String str = null;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(r, (String) null);
                JSONArray jSONArray = string == null ? new JSONArray() : new JSONArray(string);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f, cVar.f3783a);
                jSONObject.put(g, cVar.f3784b);
                jSONObject.put(h, cVar.f3785c);
                jSONObject.put(i, cVar.d);
                jSONObject.put(j, cVar.e);
                jSONObject.put(k, cVar.f);
                jSONObject.put(l, cVar.g);
                jSONObject.put(m, cVar.h);
                jSONObject.put(n, cVar.i);
                jSONObject.put(o, cVar.j);
                jSONObject.put(p, cVar.k);
                jSONObject.put("ts", cVar.l);
                jSONArray.put(jSONObject);
                str = jSONArray.toString();
            }
            if (str != null) {
                sharedPreferences.edit().putString(r, str).commit();
            }
        } catch (Exception e2) {
            e.e(e2.getMessage());
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f3799a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(s, str).commit();
        }
    }

    public static JSONArray b(Context context) {
        String string;
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f3799a, 0);
            if (!(sharedPreferences == null || (string = sharedPreferences.getString(r, (String) null)) == null)) {
                return new JSONArray(string);
            }
        } catch (Exception e2) {
            e.e(e2.getMessage());
        }
        return null;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f3799a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(r).commit();
        }
    }

    public static String d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f3799a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(s, (String) null);
        }
        return null;
    }
}
