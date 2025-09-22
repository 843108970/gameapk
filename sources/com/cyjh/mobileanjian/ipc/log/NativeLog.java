package com.cyjh.mobileanjian.ipc.log;

public class NativeLog {

    /* renamed from: a  reason: collision with root package name */
    private static StringBuffer f2562a = new StringBuffer();

    public static void appendLog(String str) {
        if (f2562a.length() > 0) {
            f2562a.append("@_@");
        }
        f2562a.append(str);
    }

    public static String getExtraLog() {
        return f2562a.toString();
    }

    public static void reset() {
        f2562a.setLength(0);
    }
}
