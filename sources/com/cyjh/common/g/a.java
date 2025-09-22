package com.cyjh.common.g;

import android.app.Activity;
import java.util.Iterator;
import java.util.Stack;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Stack<Activity> f1636a;

    /* renamed from: b  reason: collision with root package name */
    private static a f1637b;

    private a() {
    }

    private static Activity a(Class<?> cls) {
        Iterator it = f1636a.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (activity.getClass().equals(cls)) {
                return activity;
            }
        }
        return null;
    }

    public static a a() {
        if (f1637b == null) {
            f1637b = new a();
        }
        return f1637b;
    }

    public static void a(Activity activity) {
        if (f1636a == null) {
            f1636a = new Stack<>();
        }
        f1636a.add(activity);
    }

    public static void b() {
        int size = f1636a.size();
        for (int i = 0; i < size; i++) {
            if (f1636a.get(i) != null && !((Activity) f1636a.get(i)).isFinishing()) {
                ((Activity) f1636a.get(i)).finish();
            }
        }
        f1636a.clear();
    }

    public static void b(Activity activity) {
        if (activity != null) {
            f1636a.remove(activity);
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    private static void b(Class<?> cls) {
        Iterator it = f1636a.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (activity.getClass().equals(cls)) {
                b(activity);
            }
        }
    }

    private static Activity c() {
        if (f1636a == null || f1636a.isEmpty()) {
            return null;
        }
        return (Activity) f1636a.lastElement();
    }

    private static void c(Class<?> cls) {
        Iterator it = f1636a.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (!activity.getClass().equals(cls)) {
                b(activity);
            }
        }
    }

    private static void d() {
        b((Activity) f1636a.lastElement());
    }
}
