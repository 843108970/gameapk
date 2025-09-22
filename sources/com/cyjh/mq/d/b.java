package com.cyjh.mq.d;

import android.content.Context;
import android.support.annotation.NonNull;

public final class b {
    private static int a(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static int b(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    private static int c(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }
}
