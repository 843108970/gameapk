package com.cyjh.mobileanjian.ipc.rpc;

public class RestartScriptHelper {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f2572a = false;

    public static Boolean isNeedRestart() {
        return f2572a;
    }

    public static void setNeedRestart() {
        f2572a = true;
    }

    public static void setNeedRestartValue(Boolean bool) {
        f2572a = bool;
    }
}
