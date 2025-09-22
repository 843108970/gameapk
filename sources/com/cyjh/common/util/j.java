package com.cyjh.common.util;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.cyjh.elfin.a.b;
import com.umeng.commonsdk.proguard.v;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class j {
    private static Boolean a(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(v.W);
        boolean z = false;
        if (sensorManager == null) {
            return false;
        }
        if (sensorManager.getDefaultSensor(5) == null) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static String a() {
        String str = "";
        try {
            Process start = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start();
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    String lowerCase = sb.toString().toLowerCase();
                    try {
                        Log.e("zzz", "readCpuInfo:" + lowerCase);
                        return lowerCase;
                    } catch (IOException e) {
                        String str2 = lowerCase;
                        e = e;
                        str = str2;
                        e.printStackTrace();
                        return str;
                    }
                }
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            return str;
        }
    }

    private static boolean b() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return true;
        }
        String name = defaultAdapter.getName();
        Log.e("zzz", "notHasBlueTooth:" + name);
        return TextUtils.isEmpty(name);
    }

    private static boolean b(Context context) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("tel:123456"));
        intent.setAction("android.intent.action.DIAL");
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.toLowerCase().contains("vbox") || Build.FINGERPRINT.toLowerCase().contains("test-keys") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.SERIAL.equalsIgnoreCase(EnvironmentCompat.MEDIA_UNKNOWN) || Build.SERIAL.equalsIgnoreCase(b.f1842b) || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT) || b.f1842b.equals(((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().toLowerCase()) || !(intent.resolveActivity(context.getPackageManager()) != null);
    }

    private static boolean c() {
        String a2 = a();
        Log.e("zzz", "EmulatorUtils--checkIsNotRealPhone--" + a2);
        return a2.contains("intel") || a2.contains("amd");
    }

    private static boolean c(Context context) {
        boolean z;
        Boolean bool;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            z = true;
        } else {
            String name = defaultAdapter.getName();
            Log.e("zzz", "notHasBlueTooth:" + name);
            z = TextUtils.isEmpty(name);
        }
        if (!z) {
            SensorManager sensorManager = (SensorManager) context.getSystemService(v.W);
            if (sensorManager != null) {
                bool = Boolean.valueOf(sensorManager.getDefaultSensor(5) == null);
            } else {
                bool = false;
            }
            if (!bool.booleanValue()) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("tel:123456"));
                intent.setAction("android.intent.action.DIAL");
                if (!(Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.toLowerCase().contains("vbox") || Build.FINGERPRINT.toLowerCase().contains("test-keys") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.SERIAL.equalsIgnoreCase(EnvironmentCompat.MEDIA_UNKNOWN) || Build.SERIAL.equalsIgnoreCase(b.f1842b) || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT) || b.f1842b.equals(((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().toLowerCase()) || !(intent.resolveActivity(context.getPackageManager()) != null))) {
                    String a2 = a();
                    Log.e("zzz", "EmulatorUtils--checkIsNotRealPhone--" + a2);
                    return a2.contains("intel") || a2.contains("amd");
                }
            }
        }
        return true;
    }
}
