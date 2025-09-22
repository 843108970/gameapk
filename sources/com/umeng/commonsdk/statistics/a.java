package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f3864a;

    /* renamed from: b  reason: collision with root package name */
    private static String f3865b;

    public static String a(Context context) {
        if (TextUtils.isEmpty(f3865b)) {
            f3865b = d.a(context).b();
        }
        return f3865b;
    }
}
