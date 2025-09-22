package com.cyjh.common.util;

import android.content.Context;
import android.os.Build;

public final class ai {
    private static boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29;
    }
}
