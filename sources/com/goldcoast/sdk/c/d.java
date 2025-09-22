package com.goldcoast.sdk.c;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.cyjh.common.util.s;
import com.goldcoast.sdk.a.a;
import com.goldcoast.sdk.a.b;
import com.goldcoast.sdk.a.e;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f2939a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f2940b;

    private d() {
    }

    public static b a() {
        String str;
        b bVar = new b();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        String str2 = "";
        e c2 = c();
        try {
            hashMap2.put("MemTotal", "");
            f.a(new FileInputStream("/proc/meminfo"), hashMap2);
            str = (String) hashMap2.get("MemTotal");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        a aVar = null;
        try {
            str2 = f.a(new FileInputStream("/proc/version"), (Map) null).split(s.a.f1696a)[2];
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        try {
            f.a(new FileInputStream("/proc/cpuinfo"), hashMap);
            aVar = new a(hashMap);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
        bVar.a(aVar);
        bVar.a(c2);
        bVar.b(str2);
        bVar.a(str);
        bVar.c(d());
        bVar.e(b());
        bVar.d(e());
        bVar.g(b.a());
        bVar.f(String.valueOf(System.currentTimeMillis()));
        return bVar;
    }

    public static d a(Context context) {
        f2940b = context;
        if (f2939a == null) {
            f2939a = new d();
        }
        return f2939a;
    }

    public static String b() {
        try {
            return Settings.Secure.getString(f2940b.getContentResolver(), com.cyjh.common.b.a.aM);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public static e c() {
        HashMap hashMap = new HashMap();
        String[] strArr = {"ro.product.brand", "ro.product.name", "ro.product.model", "ro.build.fingerprint", "ro.build.version.sdk", "ro.build.version.release", "ro.build.date", "ro.build.date.utc", "ro.boot.cpuid", "ro.btconfig.vendor", "persist.sys.timezone", "persist.sys.country", "persist.sys.language", "persist.sys.dalvik.vm.lib", "ro.build.description", "ro.runtime.firstboot", "ro.serialno", "ro.hardware", "ro.product.board", "ro.product.locale.language", "ro.product.locale.region", "ro.product.cpu.abi", "ro.board.platform", "ro.build.selinux", "ro.build.selinux.enforce"};
        for (int i = 0; i < 25; i++) {
            hashMap.put(strArr[i], "");
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            hashMap.put(entry.getKey(), i.a((String) entry.getKey()));
        }
        return new e(hashMap);
    }

    private static String d() {
        try {
            return ((TelephonyManager) f2940b.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    private static String e() {
        try {
            return ((WifiManager) f2940b.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }
}
