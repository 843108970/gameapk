package com.cyjh.elfin.sweepcode;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public final class c {
    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    private static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int c(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return f(context) ? displayMetrics.heightPixels : displayMetrics.widthPixels;
    }

    private static int d(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return f(context) ? displayMetrics.widthPixels : displayMetrics.heightPixels;
    }

    private static DisplayMetrics e(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    private static boolean f(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private static float g(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static int[] h(Context context) {
        int[] iArr = new int[2];
        if (iArr[0] != 0) {
            return iArr;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        iArr[0] = displayMetrics.widthPixels;
        iArr[1] = displayMetrics.heightPixels;
        return iArr;
    }

    private static String i(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        return i + "x" + i2;
    }
}
