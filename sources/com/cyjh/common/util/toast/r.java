package com.cyjh.common.util.toast;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import com.cyjh.common.util.toast.q;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class r implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    static final r f1768a = new r();
    static final Activity d = new Activity();

    /* renamed from: b  reason: collision with root package name */
    final LinkedList<Activity> f1769b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    final List<q.d> f1770c = new CopyOnWriteArrayList();
    boolean e = false;
    /* access modifiers changed from: private */
    public final Map<Activity, List<q.a>> f = new ConcurrentHashMap();
    private int g = 0;
    private int h = 0;

    r() {
    }

    private void a(final Activity activity) {
        if (activity != null) {
            o.a((Runnable) new Runnable() {
                public final void run() {
                    r.this.f.remove(activity);
                }
            });
        }
    }

    private void a(Activity activity, Lifecycle.Event event) {
        a(activity, event, this.f.get(activity));
        a(activity, event, this.f.get(d));
    }

    private void a(Activity activity, Lifecycle.Event event, List<q.a> list) {
        if (list != null) {
            for (q.a next : list) {
                if (event.equals(Lifecycle.Event.ON_CREATE)) {
                    next.a(activity);
                } else if (!event.equals(Lifecycle.Event.ON_START) && !event.equals(Lifecycle.Event.ON_RESUME) && !event.equals(Lifecycle.Event.ON_PAUSE) && !event.equals(Lifecycle.Event.ON_STOP)) {
                    event.equals(Lifecycle.Event.ON_DESTROY);
                }
            }
            if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                this.f.remove(activity);
            }
        }
    }

    private void a(final Activity activity, boolean z) {
        if (z) {
            try {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } catch (Exception unused) {
            }
        } else {
            final Object tag = activity.getWindow().getDecorView().getTag(-123);
            if (tag instanceof Integer) {
                o.a((Runnable) new Runnable() {
                    public final void run() {
                        try {
                            Window window = activity.getWindow();
                            if (window != null) {
                                window.setSoftInputMode(((Integer) tag).intValue());
                            }
                        } catch (Exception unused) {
                        }
                    }
                }, 100);
            }
        }
    }

    private void a(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    private void a(q.a aVar) {
        a(d, aVar);
    }

    private void a(q.d dVar) {
        this.f1770c.add(dVar);
    }

    static /* synthetic */ void a(r rVar, Activity activity, q.a aVar) {
        List list = rVar.f.get(activity);
        if (list == null) {
            list = new CopyOnWriteArrayList();
            rVar.f.put(activity, list);
        } else if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    static Application b() {
        Object invoke;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object g2 = g();
            if (g2 == null || (invoke = cls.getMethod("getApplication", new Class[0]).invoke(g2, new Object[0])) == null) {
                return null;
            }
            return (Application) invoke;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void b(Activity activity) {
        if (this.f1769b.contains(activity)) {
            if (!this.f1769b.getFirst().equals(activity)) {
                this.f1769b.remove(activity);
            } else {
                return;
            }
        }
        this.f1769b.addFirst(activity);
    }

    private void b(Application application) {
        this.f1769b.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }

    private void b(q.a aVar) {
        b(d, aVar);
    }

    private void b(q.d dVar) {
        this.f1770c.remove(dVar);
    }

    static /* synthetic */ void b(r rVar, Activity activity, q.a aVar) {
        List list = rVar.f.get(activity);
        if (list != null && !list.isEmpty()) {
            list.remove(aVar);
        }
    }

    private Activity c() {
        for (Activity next : a()) {
            if (a.a(next)) {
                return next;
            }
        }
        return null;
    }

    private void c(Activity activity, q.a aVar) {
        List list = this.f.get(activity);
        if (list == null) {
            list = new CopyOnWriteArrayList();
            this.f.put(activity, list);
        } else if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    private void d(Activity activity, q.a aVar) {
        List list = this.f.get(activity);
        if (list != null && !list.isEmpty()) {
            list.remove(aVar);
        }
    }

    private boolean d() {
        return !this.e;
    }

    private void e() {
        if (!this.f1770c.isEmpty()) {
            Iterator<q.d> it = this.f1770c.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private static List<Activity> f() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object g2 = g();
            if (g2 == null) {
                return linkedList;
            }
            Field declaredField = g2.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(g2);
            if (!(obj instanceof Map)) {
                return linkedList;
            }
            for (Object next : ((Map) obj).values()) {
                Class<?> cls = next.getClass();
                Field declaredField2 = cls.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(next);
                if (activity == null) {
                    Field declaredField3 = cls.getDeclaredField("paused");
                    declaredField3.setAccessible(true);
                    if (!declaredField3.getBoolean(next)) {
                        activity = activity2;
                    }
                }
                linkedList.addFirst(activity2);
            }
            if (activity != null) {
                linkedList.addFirst(activity);
            }
            return linkedList;
        } catch (Exception e2) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e2.getMessage());
        }
    }

    private static Object g() {
        Object h2 = h();
        return h2 != null ? h2 : i();
    }

    private static Object h() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception e2) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e2.getMessage());
            return null;
        }
    }

    private static Object i() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e2) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e2.getMessage());
            return null;
        }
    }

    private static void j() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get((Object) null)).floatValue() == 0.0f) {
                    declaredField.set((Object) null, Float.valueOf(1.0f));
                    Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final List<Activity> a() {
        if (!this.f1769b.isEmpty()) {
            return new LinkedList(this.f1769b);
        }
        this.f1769b.addAll(f());
        return new LinkedList(this.f1769b);
    }

    /* access modifiers changed from: package-private */
    public final void a(final Activity activity, final q.a aVar) {
        if (activity != null && aVar != null) {
            o.a((Runnable) new Runnable() {
                public final void run() {
                    r.a(r.this, activity, aVar);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(final Activity activity, final q.a aVar) {
        if (activity != null && aVar != null) {
            o.a((Runnable) new Runnable() {
                public final void run() {
                    r.b(r.this, activity, aVar);
                }
            });
        }
    }

    public final void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        Locale locale;
        if (this.f1769b.size() == 0) {
            e();
        }
        String string = k.a("Utils").f1723a.getString("KEY_LOCALE", "");
        if (!TextUtils.isEmpty(string)) {
            if ("VALUE_FOLLOW_SYSTEM".equals(string)) {
                Configuration configuration = Resources.getSystem().getConfiguration();
                locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
            } else {
                Locale a2 = h.a(string);
                if (a2 == null) {
                    Log.e("LanguageUtils", "The string of " + string + " is not in the correct format.");
                    k.a("Utils").f1723a.edit().remove("KEY_LOCALE").apply();
                }
                locale = a2;
            }
            if (locale != null) {
                h.a((Context) activity, locale);
                h.a((Context) q.a(), locale);
            }
        }
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get((Object) null)).floatValue() == 0.0f) {
                    declaredField.set((Object) null, Float.valueOf(1.0f));
                    Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        }
        b(activity);
        a(activity, Lifecycle.Event.ON_CREATE);
    }

    public final void onActivityDestroyed(@NonNull Activity activity) {
        this.f1769b.remove(activity);
        g.a(activity);
        a(activity, Lifecycle.Event.ON_DESTROY);
    }

    public final void onActivityPaused(@NonNull Activity activity) {
        a(activity, Lifecycle.Event.ON_PAUSE);
    }

    public final void onActivityResumed(@NonNull Activity activity) {
        b(activity);
        if (this.e) {
            this.e = false;
            e();
        }
        a(activity, false);
        a(activity, Lifecycle.Event.ON_RESUME);
    }

    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public final void onActivityStarted(@NonNull Activity activity) {
        if (!this.e) {
            b(activity);
        }
        if (this.h < 0) {
            this.h++;
        } else {
            this.g++;
        }
        a(activity, Lifecycle.Event.ON_START);
    }

    public final void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.h--;
        } else {
            this.g--;
            if (this.g <= 0) {
                this.e = true;
                e();
            }
        }
        a(activity, true);
        a(activity, Lifecycle.Event.ON_STOP);
    }
}
