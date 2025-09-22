package com.cyjh.common.util.toast;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static List<Field> f1707a;

    private b() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static int a(float f) {
        return (int) (((double) ((f * q.a().getResources().getDisplayMetrics().xdpi) / 72.0f)) + 0.5d);
    }

    private static int a(@NonNull Resources resources) {
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", com.cyjh.elfin.a.b.f1842b);
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @NonNull
    private static Resources a(@NonNull Resources resources, int i) {
        a(resources, (((float) resources.getDisplayMetrics().widthPixels) * 72.0f) / ((float) i));
        return resources;
    }

    private static DisplayMetrics a(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Runnable a() {
        return new Runnable() {
            public final void run() {
                b.a(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static void a(@NonNull Resources resources, float f) {
        resources.getDisplayMetrics().xdpi = f;
        q.a().getResources().getDisplayMetrics().xdpi = f;
        if (f1707a == null) {
            f1707a = new ArrayList();
            Class cls = resources.getClass();
            do {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    for (Field field : declaredFields) {
                        if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                            field.setAccessible(true);
                            DisplayMetrics a2 = a(resources, field);
                            if (a2 != null) {
                                f1707a.add(field);
                                a2.xdpi = f;
                            }
                        }
                    }
                    cls = cls.getSuperclass();
                } else {
                    return;
                }
            } while (cls != null);
            return;
        }
        c(resources, f);
    }

    private static int b(float f) {
        return (int) (((double) ((f * 72.0f) / q.a().getResources().getDisplayMetrics().xdpi)) + 0.5d);
    }

    @NonNull
    private static Resources b(@NonNull Resources resources) {
        a(resources, Resources.getSystem().getDisplayMetrics().density * 72.0f);
        return resources;
    }

    @NonNull
    private static Resources b(@NonNull Resources resources, int i) {
        a(resources, (((float) (resources.getDisplayMetrics().heightPixels + 0)) * 72.0f) / ((float) i));
        return resources;
    }

    private static void b() {
        a(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }

    private static void b(Resources resources, float f) {
        if (f1707a == null) {
            f1707a = new ArrayList();
            Class cls = resources.getClass();
            do {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    for (Field field : declaredFields) {
                        if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                            field.setAccessible(true);
                            DisplayMetrics a2 = a(resources, field);
                            if (a2 != null) {
                                f1707a.add(field);
                                a2.xdpi = f;
                            }
                        }
                    }
                    cls = cls.getSuperclass();
                } else {
                    return;
                }
            } while (cls != null);
            return;
        }
        c(resources, f);
    }

    @NonNull
    private static Resources c(@NonNull Resources resources, int i) {
        a(resources, (((float) (resources.getDisplayMetrics().heightPixels + 0)) * 72.0f) / ((float) i));
        return resources;
    }

    private static void c(Resources resources, float f) {
        for (Field field : f1707a) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) field.get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
