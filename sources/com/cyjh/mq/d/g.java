package com.cyjh.mq.d;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;

public final class g {
    public static String a(@NonNull Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "" : connectionInfo.getMacAddress();
    }

    private static String b(@NonNull Context context) {
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        return (deviceId == null || deviceId.equals("")) ? a(context) : deviceId;
    }
}
