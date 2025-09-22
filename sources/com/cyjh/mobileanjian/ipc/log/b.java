package com.cyjh.mobileanjian.ipc.log;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.cyjh.mobileanjian.ipc.utils.RomUtils;
import com.cyjh.mq.d.e;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.io.FileUtils;

public final class b {
    private static b n = null;
    private static final File o = new File(Environment.getExternalStorageDirectory(), ".oldmarkuser");
    private static final String p = "com.cyjh.mobileanjian";

    /* renamed from: a  reason: collision with root package name */
    public final String f2566a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2567b = Build.VERSION.RELEASE;

    /* renamed from: c  reason: collision with root package name */
    public final String f2568c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final String j;
    public final String k;
    public final boolean l;
    public final boolean m;

    private b(Context context, String str, String str2) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        this.f2568c = a((connectionInfo == null || connectionInfo.getMacAddress() == null) ? "UNKNOWN" : connectionInfo.getMacAddress());
        this.d = RomUtils.getKnownRomVersion();
        this.f2566a = RomUtils.isEmulator() ? this.d : String.format("%s %s", new Object[]{Build.BRAND, Build.MODEL});
        this.g = e.a(context);
        this.k = e.b(context);
        this.f = context.getPackageName();
        this.m = "com.cyjh.mobileanjian".equals(this.f);
        this.i = false;
        this.h = str;
        this.j = str2;
        boolean z = !o.exists();
        this.l = z;
        if (z) {
            try {
                o.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        String str3 = null;
        try {
            File file = new File("/proc/version");
            if (file.exists() && file.canRead()) {
                str3 = FileUtils.readFileToString(file);
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        this.e = TextUtils.isEmpty(str3) ? "Unknown" : str3;
    }

    public static b a() {
        return n;
    }

    private static String a(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        return (connectionInfo == null || connectionInfo.getMacAddress() == null) ? "UNKNOWN" : connectionInfo.getMacAddress();
    }

    private static final String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static void a(Context context, String str, String str2) {
        if (n == null) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            b bVar = new b(context, str, str2);
            n = bVar;
            bVar.toString();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("手机型号: ");
        sb.append(this.f2566a);
        sb.append("\nLinux: ");
        sb.append(this.e);
        sb.append("\nMAC的MD5: ");
        sb.append(this.f2568c);
        sb.append("\n安卓版本: ");
        sb.append(this.f2567b);
        sb.append("\n定制安卓: ");
        sb.append(this.d);
        sb.append("\n应用名称: ");
        sb.append(this.g);
        sb.append("\n应用包名: ");
        sb.append(this.f);
        sb.append("\n应用版本: ");
        sb.append(this.k);
        sb.append("\n唯一标识: ");
        sb.append(this.h);
        sb.append("\n精灵版本: ");
        sb.append(this.j);
        sb.append("\n产品形态: UNKNOWN\n是否付费: ");
        sb.append(this.i ? "免费" : "收费");
        sb.append("\n");
        return sb.toString();
    }
}
