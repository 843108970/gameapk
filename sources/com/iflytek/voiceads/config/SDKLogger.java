package com.iflytek.voiceads.config;

import android.util.Log;

public class SDKLogger {
    public static boolean dev = false;

    public static void d(String str) {
        if (dev) {
            Log.d(SDKConstants.TAG, str);
        }
    }

    public static void d(String str, String str2) {
        if (dev) {
            Log.d(str, str2);
        }
    }

    public static void e(String str) {
        if (dev) {
            Log.e(SDKConstants.TAG, str);
        }
    }

    public static void e(String str, String str2) {
        if (dev) {
            Log.e(str, str2);
        }
    }

    public static void setDebug(boolean z) {
        dev = z;
    }
}
