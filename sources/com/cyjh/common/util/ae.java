package com.cyjh.common.util;

import android.content.Context;
import android.widget.Toast;

public final class ae {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1658a = false;

    private static void a(Context context, int i) {
        if (f1658a) {
            Toast.makeText(context, i, 0).show();
        }
    }

    public static void a(Context context, String str) {
        if (f1658a) {
            Toast.makeText(context, str, 0).show();
        }
    }

    private static void b(Context context, int i) {
        if (f1658a) {
            Toast.makeText(context, i, 1).show();
        }
    }

    public static void b(Context context, String str) {
        if (f1658a) {
            Toast.makeText(context, str, 1).show();
        }
    }
}
