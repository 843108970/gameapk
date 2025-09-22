package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.os.EnvironmentCompat;
import com.umeng.commonsdk.statistics.common.e;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3819a = "UM_PROBE_DATA";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3820b = "_dsk_s";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3821c = "_thm_z";
    public static final String d = "_gdf_r";
    private static Object e = new Object();

    public static String a() {
        boolean z;
        try {
            z = a("ls /sys/class/thermal", "thermal_zone");
        } catch (IOException unused) {
            z = false;
        }
        return z ? "thermal_zone" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f3819a, 0);
            if (sharedPreferences != null) {
                JSONObject jSONObject = new JSONObject();
                synchronized (e) {
                    jSONObject.put(f3820b, sharedPreferences.getString(f3820b, ""));
                    jSONObject.put(f3821c, sharedPreferences.getString(f3821c, ""));
                    jSONObject.put(d, sharedPreferences.getString(d, ""));
                }
                return jSONObject.toString();
            }
        } catch (Exception e2) {
            e.a(context, e2);
        }
        return null;
    }

    public static boolean a(String str, String str2) throws IOException {
        boolean z;
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (readLine.contains(str2)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        try {
            exec.waitFor();
        } catch (InterruptedException unused) {
        }
        return z;
    }

    public static String b() {
        boolean z;
        try {
            z = a("ls /", "goldfish");
        } catch (IOException unused) {
            z = false;
        }
        return z ? "goldfish" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static void b(final Context context) {
        if (!c(context)) {
            final String[] strArr = {EnvironmentCompat.MEDIA_UNKNOWN, EnvironmentCompat.MEDIA_UNKNOWN, EnvironmentCompat.MEDIA_UNKNOWN};
            new Thread() {
                public final void run() {
                    super.run();
                    strArr[0] = t.c();
                    strArr[1] = t.a();
                    strArr[2] = t.b();
                    e.c("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    t.b(context, strArr);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getApplicationContext().getSharedPreferences(f3819a, 0)) != null) {
            synchronized (e) {
                sharedPreferences.edit().putString(f3820b, strArr[0]).putString(f3821c, strArr[1]).putString(d, strArr[2]).commit();
            }
        }
    }

    public static String c() {
        BufferedReader bufferedReader;
        String str;
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/diskstats"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!readLine.contains("mmcblk")) {
                            if (!readLine.contains("sda")) {
                                if (readLine.contains("mtd")) {
                                    str = "mtd";
                                    break;
                                }
                            } else {
                                str = "sda";
                                break;
                            }
                        } else {
                            str = "mmcblk";
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception unused) {
                }
            }
            str2 = str;
        } catch (Exception unused2) {
            bufferedReader = null;
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        }
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r3 = r3.getApplicationContext().getSharedPreferences(f3819a, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x001e
            android.content.Context r3 = r3.getApplicationContext()
            java.lang.String r1 = "UM_PROBE_DATA"
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r1, r0)
            if (r3 == 0) goto L_0x001e
            java.lang.String r1 = "_dsk_s"
            java.lang.String r2 = ""
            java.lang.String r3 = r3.getString(r1, r2)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x001e
            r0 = 1
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.t.c(android.content.Context):boolean");
    }
}
