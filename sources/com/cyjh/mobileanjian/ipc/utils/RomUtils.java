package com.cyjh.mobileanjian.ipc.utils;

import android.os.Build;
import java.io.File;
import java.io.FileInputStream;

public class RomUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final b f2703a = new b();

    public static String getEmuiVersion() {
        return f2703a.a("ro.build.version.emui");
    }

    public static String getFlymeVersion() {
        return Build.DISPLAY;
    }

    public static String getKnownRomVersion() {
        return isMIUI() ? getMUIUDetailVersion() : isFlyme() ? getFlymeVersion() : isEmui() ? getEmuiVersion() : isHaimawanVM() ? "海马玩模拟器" : isTiantianVM() ? "天天模拟器" : isNoxVM() ? "夜神模拟器" : isXiaoyaoVM() ? "逍遥模拟器" : isXXZS() ? "猩猩助手" : "undefined";
    }

    public static String getMUIUDetailVersion() {
        if (!isMIUI()) {
            return "";
        }
        return String.format("MIUI %s %s", new Object[]{f2703a.a("ro.miui.ui.version.name"), Build.VERSION.INCREMENTAL});
    }

    public static int getMUIUVersion() {
        if (!isMIUI()) {
            return -1;
        }
        String a2 = f2703a.a("ro.miui.ui.version.name", "V0");
        if (a2.equals("V8")) {
            return 8;
        }
        if (a2.equals("V7")) {
            return 7;
        }
        if (a2.equals("V6")) {
            return 6;
        }
        return a2.equals("V5") ? 5 : 0;
    }

    public static boolean isARMCpu() {
        byte[] bArr = new byte[20];
        try {
            if (new FileInputStream(new File("/system/lib/libc.so")).read(bArr) != -1 && bArr[18] == 3) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isEmui() {
        return f2703a.a((Object) "ro.build.version.emui");
    }

    public static boolean isEmulator() {
        return isHaimawanVM() || isTiantianVM() || isNoxVM() || isXiaoyaoVM() || isXXZS();
    }

    public static boolean isFlyme() {
        return f2703a.a((Object) "ro.flyme.published");
    }

    public static boolean isHaimawanVM() {
        return f2703a.a((Object) "droid4x.inited") || f2703a.a((Object) "ro.droid4x.host.mac") || f2703a.a((Object) "droid4x.battery.status") || f2703a.a((Object) "persist.droid4x.op_alpha");
    }

    public static boolean isMIUI() {
        return f2703a.a((Object) "ro.miui.ui.version.name");
    }

    public static boolean isNoxVM() {
        return f2703a.a((Object) "nox.inited") || f2703a.a((Object) "nox.vbox_dpi") || f2703a.a((Object) "ro.nox.host.mac") || f2703a.a((Object) "nox.battery.status");
    }

    public static boolean isOppoR9S() {
        String a2 = f2703a.a("ro.product.name", "");
        String a3 = f2703a.a("ro.product.model", "");
        return a2 != null && a2.contains("R9s") && a3 != null && a3.contains("R9s");
    }

    public static boolean isTiantianVM() {
        return f2703a.a((Object) "ttVM.inited") || f2703a.a((Object) "ttvmd.battery.status") || f2703a.a((Object) "ttVM.vbox_dpi") || f2703a.a((Object) "ttvmd.battery.mode");
    }

    public static boolean isXXZS() {
        return f2703a.a((Object) "ro.xxzs.DeviceId") || f2703a.a((Object) "ro.xxzs.origDeviceId");
    }

    public static boolean isXiaoyaoVM() {
        return f2703a.a((Object) "microvirt.inited") || f2703a.a((Object) "microvirt.channel") || f2703a.a((Object) "ro.microvirt.hmac") || f2703a.a((Object) "microvirt.vbox_dpi");
    }
}
