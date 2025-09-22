package com.cyjh.mobileanjian.ipc.utils;

import android.content.Context;

public class Util {
    static {
        System.loadLibrary("mqm");
    }

    public static native String getAppSinature(Context context);
}
