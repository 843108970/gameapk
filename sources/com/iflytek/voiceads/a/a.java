package com.iflytek.voiceads.a;

import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Locale f3506a = Locale.US;

    public static String a(int i) {
        String[] strArr = b.f3507a;
        if (f3506a.equals(Locale.US)) {
            strArr = c.f3509a;
        }
        return (i <= 0 || i >= strArr.length) ? b(1) : strArr[i];
    }

    public static String b(int i) {
        String[] strArr = b.f3508b;
        if (f3506a.equals(Locale.US)) {
            strArr = c.f3510b;
        }
        return (i < 0 || i >= strArr.length) ? "" : strArr[i];
    }
}
