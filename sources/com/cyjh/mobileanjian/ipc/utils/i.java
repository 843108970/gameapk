package com.cyjh.mobileanjian.ipc.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.NetworkInterface;
import java.util.Collections;

public final class i {
    private i() {
        throw new RuntimeException();
    }

    private static String a() {
        String str = "";
        String str2 = "";
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream()));
            while (true) {
                if (str != null) {
                    str = lineNumberReader.readLine();
                    if (str != null) {
                        str2 = str.trim();
                        break;
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str2 != null && !"".equals(str2)) {
            return str2;
        }
        try {
            FileReader fileReader = new FileReader("/sys/class/net/eth0/address");
            String a2 = a((Reader) fileReader);
            fileReader.close();
            return a2.toUpperCase().substring(0, 17);
        } catch (Exception e2) {
            e2.printStackTrace();
            return b();
        }
    }

    private static String a(Context context) {
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return deviceId == null ? "" : deviceId;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String a(Reader reader) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        while (true) {
            int read = reader.read(cArr);
            if (read < 0) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    private static String a(String str) throws Exception {
        FileReader fileReader = new FileReader(str);
        String a2 = a((Reader) fileReader);
        fileReader.close();
        return a2;
    }

    private static String b() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String b(Context context) {
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            return subscriberId == null ? "" : subscriberId;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String c(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a();
        }
        try {
            String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return macAddress == null ? "" : macAddress;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
