package com.cyjh.common.util;

import android.content.Context;
import android.widget.Toast;

public final class ag {
    public static void a(Context context, int i) {
        Toast.makeText(context, i, 0).show();
    }

    private static void a(Context context, int i, int i2, int i3) {
        Toast makeText = Toast.makeText(context, i, 0);
        makeText.setGravity(17, i2, i3);
        makeText.show();
    }

    public static void a(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static void b(Context context, int i) {
        Toast.makeText(context, i, 1).show();
    }

    public static void b(Context context, String str) {
        Toast.makeText(context, str, 1).show();
    }
}
