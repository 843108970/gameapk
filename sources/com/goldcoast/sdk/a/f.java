package com.goldcoast.sdk.a;

import android.os.Build;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends c<f> {

    /* renamed from: a  reason: collision with root package name */
    private String f2927a;

    /* renamed from: b  reason: collision with root package name */
    private String f2928b;

    /* renamed from: c  reason: collision with root package name */
    private String f2929c;
    private String d;
    private String e;

    public f() {
    }

    public f(String[] strArr) {
        if (strArr != null) {
            Map a2 = a(strArr);
            Iterator it = a2.keySet().iterator();
            if (it != null && it.hasNext()) {
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str.equals(".vendor")) {
                        this.f2927a = (String) a2.get(str);
                    } else if (str.equals(".product")) {
                        this.f2928b = (String) a2.get(str);
                    } else if (str.equals(".uname_r")) {
                        this.f2929c = (String) a2.get(str);
                    } else if (str.equals(".uname_v")) {
                        this.d = (String) a2.get(str);
                    }
                }
            }
        }
    }

    private static Map a(String[] strArr) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < strArr.length) {
            try {
                String str = strArr[i];
                if (str.contains("=")) {
                    String[] split = str.split("=");
                    hashMap.put(split[0].trim(), split[1].trim());
                }
                i++;
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public static String[] a() {
        String[] strArr = new String[4];
        strArr[0] = ".vendor=" + Build.BRAND;
        strArr[1] = ".product=" + Build.MODEL;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 8192);
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split("\\s+");
            strArr[2] = ".uname_v=" + readLine.substring(readLine.lastIndexOf("#"), readLine.length());
            strArr[3] = ".uname_r=" + split[2];
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return strArr;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(".vendor", this.f2927a);
            jSONObject.put(".product", this.f2928b);
            jSONObject.put(".uname_r", this.f2929c);
            jSONObject.put(".uname_v", this.d);
            jSONObject.put(".uname_v_utc", this.e);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }
}
