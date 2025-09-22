package com.cyjh.common.util.toast;

import android.os.Build;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class t {
    private static View a(@LayoutRes int i) {
        return ((LayoutInflater) q.a().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
    }

    private static void a(View view) {
        view.setFocusable(false);
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                childAt.setFocusable(false);
                if (childAt instanceof ViewGroup) {
                    a(childAt);
                }
            }
        }
    }

    private static void a(View view, boolean z) {
        a(view, z, null);
    }

    private static void a(View view, boolean z, View... viewArr) {
        if (view != null) {
            if (viewArr != null) {
                int length = viewArr.length;
                int i = 0;
                while (i < length) {
                    if (view != viewArr[i]) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(viewGroup.getChildAt(i2), z, viewArr);
                }
            }
            view.setEnabled(z);
        }
    }

    private static void a(Runnable runnable) {
        o.a(runnable);
    }

    private static void a(Runnable runnable, long j) {
        o.a(runnable, j);
    }

    private static boolean a() {
        if (Build.VERSION.SDK_INT >= 17) {
            if (TextUtils.getLayoutDirectionFromLocale(Build.VERSION.SDK_INT >= 24 ? q.a().getResources().getConfiguration().getLocales().get(0) : q.a().getResources().getConfiguration().locale) == 1) {
                return true;
            }
        }
        return false;
    }
}
