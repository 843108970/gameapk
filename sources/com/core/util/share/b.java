package com.core.util.share;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1601a = "method_contain_key";

    /* renamed from: b  reason: collision with root package name */
    public static String f1602b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Uri f1603c = null;
    public static final String d = "method_query_value";
    public static final String e = "method_edit";
    public static final String f = "method_query_pid";
    public static final String g = "key_result";

    private static SharedPreferences a(@NonNull Context context, String str) {
        return c.a(context, str);
    }

    private static void a(Context context) {
        f1602b = context.getPackageName() + ".preference";
        StringBuilder sb = new StringBuilder("content://");
        sb.append(f1602b);
        f1603c = Uri.parse(sb.toString());
    }
}
