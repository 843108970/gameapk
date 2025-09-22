package com.cyjh.common.util.toast;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import mobi.oneway.export.d.e;

public final class m {

    public interface a {
        void a();
    }

    private m() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static float a(float f, int i) {
        float f2;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        switch (i) {
            case 0:
                return f;
            case 1:
                f2 = displayMetrics.density;
                break;
            case 2:
                f2 = displayMetrics.scaledDensity;
                break;
            case 3:
                f *= displayMetrics.xdpi;
                f2 = 0.013888889f;
                break;
            case 4:
                f2 = displayMetrics.xdpi;
                break;
            case 5:
                f *= displayMetrics.xdpi;
                f2 = 0.03937008f;
                break;
            default:
                return 0.0f;
        }
        return f * f2;
    }

    private static int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    private static int a(View view) {
        return c(view)[0];
    }

    private static void a(final View view, final a aVar) {
        view.post(new Runnable() {
            public final void run() {
            }
        });
    }

    private static int b(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    private static int b(View view) {
        return c(view)[1];
    }

    private static int c(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private static int[] c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, e.e) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    private static int d(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
