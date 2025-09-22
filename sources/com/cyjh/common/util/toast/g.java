package com.cyjh.common.util.toast;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.lang.reflect.Field;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1711a = -8;

    /* renamed from: b  reason: collision with root package name */
    private static long f1712b;

    /* renamed from: c  reason: collision with root package name */
    private static int f1713c;

    public interface a {
        void a();
    }

    private g() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a() {
        InputMethodManager inputMethodManager = (InputMethodManager) q.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
    }

    public static void a(@NonNull Activity activity) {
        Window window = activity.getWindow();
        InputMethodManager inputMethodManager = (InputMethodManager) q.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
            for (int i = 0; i < 4; i++) {
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj instanceof View) {
                        if (((View) obj).getRootView() == window.getDecorView().getRootView()) {
                            declaredField.set(inputMethodManager, (Object) null);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static void a(@NonNull Activity activity, @NonNull final a aVar) {
        final Window window = activity.getWindow();
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(16908290);
        final int[] iArr = {d(window)};
        AnonymousClass1 r2 = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                int a2 = g.d(r4);
                if (r1[0] != a2) {
                    r1[0] = a2;
                }
            }
        };
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(r2);
        frameLayout.setTag(f1711a, r2);
    }

    private static void a(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) q.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            inputMethodManager.showSoftInput(view, 0, new KeyboardUtils$1(new Handler()));
            inputMethodManager.toggleSoftInput(2, 1);
        }
    }

    private static void a(@NonNull final Window window, @NonNull final a aVar) {
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(16908290);
        final int[] iArr = {d(window)};
        AnonymousClass1 r2 = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                int a2 = g.d(window);
                if (iArr[0] != a2) {
                    iArr[0] = a2;
                }
            }
        };
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(r2);
        frameLayout.setTag(f1711a, r2);
    }

    private static void b() {
        InputMethodManager inputMethodManager = (InputMethodManager) q.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 1);
        }
    }

    private static void b(@Nullable Activity activity) {
        if (activity != null && !e(activity)) {
            a();
        }
    }

    private static void b(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) q.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            inputMethodManager.showSoftInput(view, 0, new KeyboardUtils$1(new Handler()));
            inputMethodManager.toggleSoftInput(2, 1);
        }
    }

    private static void c() {
        Log.i("KeyboardUtils", "Please refer to the following code.");
    }

    private static void c(@Nullable Activity activity) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            View currentFocus = window.getCurrentFocus();
            if (currentFocus == null) {
                View decorView = window.getDecorView();
                View findViewWithTag = decorView.findViewWithTag("keyboardTagView");
                if (findViewWithTag == null) {
                    findViewWithTag = new EditText(window.getContext());
                    findViewWithTag.setTag("keyboardTagView");
                    ((ViewGroup) decorView).addView(findViewWithTag, 0, 0);
                }
                currentFocus = findViewWithTag;
                currentFocus.requestFocus();
            }
            InputMethodManager inputMethodManager = (InputMethodManager) q.a().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    private static void c(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) q.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private static void c(@Nullable Window window) {
        if (window != null) {
            View currentFocus = window.getCurrentFocus();
            if (currentFocus == null) {
                View decorView = window.getDecorView();
                View findViewWithTag = decorView.findViewWithTag("keyboardTagView");
                if (findViewWithTag == null) {
                    findViewWithTag = new EditText(window.getContext());
                    findViewWithTag.setTag("keyboardTagView");
                    ((ViewGroup) decorView).addView(findViewWithTag, 0, 0);
                }
                currentFocus = findViewWithTag;
                currentFocus.requestFocus();
            }
            InputMethodManager inputMethodManager = (InputMethodManager) q.a().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static int d(@NonNull Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getDecorViewInvisibleHeight: " + (decorView.getBottom() - rect.bottom));
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs > s.c() + s.b()) {
            return abs - f1713c;
        }
        f1713c = abs;
        return 0;
    }

    private static void d(@Nullable Activity activity) {
        if (activity != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(elapsedRealtime - f1712b) > 500 && e(activity)) {
                a();
            }
            f1712b = elapsedRealtime;
        }
    }

    private static void e(@NonNull Window window) {
        View findViewById = window.findViewById(16908290);
        if (findViewById != null) {
            Object tag = findViewById.getTag(f1711a);
            if ((tag instanceof ViewTreeObserver.OnGlobalLayoutListener) && Build.VERSION.SDK_INT >= 16) {
                findViewById.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) tag);
            }
        }
    }

    private static boolean e(@NonNull Activity activity) {
        return d(activity.getWindow()) > 0;
    }

    private static void f(@NonNull Activity activity) {
        final Window window = activity.getWindow();
        window.setSoftInputMode(window.getAttributes().softInputMode & -17);
        FrameLayout frameLayout = (FrameLayout) window.findViewById(16908290);
        final View childAt = frameLayout.getChildAt(0);
        final int paddingBottom = childAt.getPaddingBottom();
        final int[] iArr = {g(window)};
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                int b2 = g.g(r6);
                if (r4[0] != b2) {
                    r2.setPadding(r2.getPaddingLeft(), r2.getPaddingTop(), r2.getPaddingRight(), r3 + g.d(r6));
                    r4[0] = b2;
                }
            }
        });
    }

    private static void f(@NonNull final Window window) {
        window.setSoftInputMode(window.getAttributes().softInputMode & -17);
        FrameLayout frameLayout = (FrameLayout) window.findViewById(16908290);
        final View childAt = frameLayout.getChildAt(0);
        final int paddingBottom = childAt.getPaddingBottom();
        final int[] iArr = {g(window)};
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                int b2 = g.g(window);
                if (iArr[0] != b2) {
                    childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop(), childAt.getPaddingRight(), paddingBottom + g.d(window));
                    iArr[0] = b2;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static int g(Window window) {
        View findViewById = window.findViewById(16908290);
        if (findViewById == null) {
            return 0;
        }
        Rect rect = new Rect();
        findViewById.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getContentViewInvisibleHeight: " + (findViewById.getBottom() - rect.bottom));
        int abs = Math.abs(findViewById.getBottom() - rect.bottom);
        if (abs <= s.b() + s.c()) {
            return 0;
        }
        return abs;
    }

    private static void h(@NonNull Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) q.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
            for (int i = 0; i < 4; i++) {
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj instanceof View) {
                        if (((View) obj).getRootView() == window.getDecorView().getRootView()) {
                            declaredField.set(inputMethodManager, (Object) null);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
