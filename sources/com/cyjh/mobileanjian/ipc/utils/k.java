package com.cyjh.mobileanjian.ipc.utils;

import android.content.Context;

public final class k {
    private static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "layout", context.getPackageName());
    }

    private static int b(Context context, String str) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    private static int c(Context context, String str) {
        return context.getResources().getIdentifier(str, "bool", context.getPackageName());
    }

    private static int d(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    private static int e(Context context, String str) {
        return context.getResources().getIdentifier(str, "style", context.getPackageName());
    }

    private static Object f(Context context, String str) {
        return Integer.valueOf(context.getResources().getIdentifier(str, "styleable", context.getPackageName()));
    }

    private static int g(Context context, String str) {
        return context.getResources().getIdentifier(str, "anim", context.getPackageName());
    }

    private static int h(Context context, String str) {
        return context.getResources().getIdentifier(str, "id", context.getPackageName());
    }

    private static int i(Context context, String str) {
        return context.getResources().getIdentifier(str, "color", context.getPackageName());
    }
}
