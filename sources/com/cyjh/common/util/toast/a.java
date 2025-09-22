package com.cyjh.common.util.toast;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.cyjh.common.util.toast.q;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a {
    private a() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @Nullable
    private static Activity a(@Nullable Context context) {
        Activity activity;
        if (context == null) {
            return null;
        }
        if (context != null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                if (context instanceof ContextWrapper) {
                    if (!(context instanceof Activity)) {
                        Activity c2 = c(context);
                        if (c2 == null) {
                            arrayList.add(context);
                            context = ((ContextWrapper) context).getBaseContext();
                            if (context != null) {
                                if (arrayList.contains(context)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            activity = c2;
                            break;
                        }
                    } else {
                        activity = (Activity) context;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        activity = null;
        if (!a(activity)) {
            return null;
        }
        return activity;
    }

    @Nullable
    private static Drawable a(@NonNull ComponentName componentName) {
        try {
            return q.a().getPackageManager().getActivityIcon(componentName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Bundle a(Activity activity, View[] viewArr) {
        int length;
        if (Build.VERSION.SDK_INT < 21 || viewArr == null || (length = viewArr.length) <= 0) {
            return null;
        }
        Pair[] pairArr = new Pair[length];
        for (int i = 0; i < length; i++) {
            pairArr[i] = Pair.create(viewArr[i], viewArr[i].getTransitionName());
        }
        return ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairArr).toBundle();
    }

    private static Bundle a(Context context, int i, int i2) {
        return ActivityOptionsCompat.makeCustomAnimation(context, i, i2).toBundle();
    }

    private static Bundle a(Fragment fragment, int i, int i2) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return ActivityOptionsCompat.makeCustomAnimation(activity, i, i2).toBundle();
    }

    private static Bundle a(Fragment fragment, View[] viewArr) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return a((Activity) activity, viewArr);
    }

    public static String a(@NonNull String str) {
        if (s.b(str)) {
            return "";
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = q.a().getPackageManager().queryIntentActivities(intent, 0);
        return (queryIntentActivities == null || queryIntentActivities.size() == 0) ? "" : queryIntentActivities.get(0).activityInfo.name;
    }

    private static void a() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        a(intent, k(), (Bundle) null);
    }

    private static void a(@AnimRes int i, @AnimRes int i2) {
        for (Activity next : r.f1768a.a()) {
            next.finish();
            next.overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Activity activity, @AnimRes int i, @AnimRes int i2) {
        activity.finish();
        activity.overridePendingTransition(i, i2);
    }

    private static void a(@NonNull Activity activity, @NonNull Intent intent) {
        a(intent, (Context) activity, (Bundle) null);
    }

    private static void a(@NonNull Activity activity, @NonNull Intent intent, int i) {
        a(intent, activity, i, (Bundle) null);
    }

    private static void a(@NonNull Activity activity, @NonNull Intent intent, @AnimRes int i, @AnimRes int i2) {
        a(intent, (Context) activity, a((Context) activity, i, i2));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Activity activity, @NonNull Intent intent, int i, @AnimRes int i2, @AnimRes int i3) {
        a(intent, activity, i, a((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    private static void a(@NonNull Activity activity, @NonNull Intent intent, int i, @Nullable Bundle bundle) {
        a(intent, activity, i, bundle);
    }

    private static void a(@NonNull Activity activity, @NonNull Intent intent, int i, View... viewArr) {
        a(intent, activity, i, a(activity, viewArr));
    }

    private static void a(@NonNull Activity activity, @NonNull Intent intent, @Nullable Bundle bundle) {
        a(intent, (Context) activity, bundle);
    }

    private static void a(@NonNull Activity activity, @NonNull Intent intent, View... viewArr) {
        a(intent, (Context) activity, a(activity, viewArr));
    }

    private static void a(@Nullable Activity activity, @Nullable q.a aVar) {
        r.f1768a.a(activity, aVar);
    }

    private static void a(@NonNull Activity activity, @NonNull Class<? extends Activity> cls) {
        a((Context) activity, (Bundle) null, activity.getPackageName(), cls.getName(), (Bundle) null);
    }

    private static void a(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i) {
        a(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i, (Bundle) null);
    }

    private static void a(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        a((Context) activity, (Bundle) null, activity.getPackageName(), cls.getName(), a((Context) activity, i, i2));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, @AnimRes int i2, @AnimRes int i3) {
        a(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i, a((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    private static void a(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, @Nullable Bundle bundle) {
        a(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i, bundle);
    }

    private static void a(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, View... viewArr) {
        a(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i, a(activity, viewArr));
    }

    private static void a(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, @Nullable Bundle bundle) {
        a((Context) activity, (Bundle) null, activity.getPackageName(), cls.getName(), bundle);
    }

    private static void a(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, View... viewArr) {
        a((Context) activity, (Bundle) null, activity.getPackageName(), cls.getName(), a(activity, viewArr));
    }

    private static void a(@NonNull Activity activity, @NonNull String str, @NonNull String str2) {
        a((Context) activity, (Bundle) null, str, str2, (Bundle) null);
    }

    private static void a(@NonNull Activity activity, @NonNull String str, @NonNull String str2, @AnimRes int i, @AnimRes int i2) {
        a((Context) activity, (Bundle) null, str, str2, a((Context) activity, i, i2));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Activity activity, @NonNull String str, @NonNull String str2, @Nullable Bundle bundle) {
        a((Context) activity, (Bundle) null, str, str2, bundle);
    }

    private static void a(@NonNull Activity activity, @NonNull String str, @NonNull String str2, View... viewArr) {
        a((Context) activity, (Bundle) null, str, str2, a(activity, viewArr));
    }

    private static void a(@NonNull Activity activity, @NonNull Intent[] intentArr) {
        a(intentArr, (Context) activity, (Bundle) null);
    }

    private static void a(@NonNull Activity activity, @NonNull Intent[] intentArr, @AnimRes int i, @AnimRes int i2) {
        a(intentArr, (Context) activity, a((Context) activity, i, i2));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Activity activity, @NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        a(intentArr, (Context) activity, bundle);
    }

    private static void a(Context context, Bundle bundle, String str, String str2, @Nullable Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        a(intent, context, bundle2);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls) {
        a((Context) activity, bundle, activity.getPackageName(), cls.getName(), (Bundle) null);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i) {
        a(activity, bundle, activity.getPackageName(), cls.getName(), i, (Bundle) null);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        a((Context) activity, bundle, activity.getPackageName(), cls.getName(), a((Context) activity, i, i2));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, @AnimRes int i2, @AnimRes int i3) {
        a(activity, bundle, activity.getPackageName(), cls.getName(), i, a((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, @Nullable Bundle bundle2) {
        a(activity, bundle, activity.getPackageName(), cls.getName(), i, bundle2);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, View... viewArr) {
        a(activity, bundle, activity.getPackageName(), cls.getName(), i, a(activity, viewArr));
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, @Nullable Bundle bundle2) {
        a((Context) activity, bundle, activity.getPackageName(), cls.getName(), bundle2);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, View... viewArr) {
        a((Context) activity, bundle, activity.getPackageName(), cls.getName(), a(activity, viewArr));
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2) {
        a((Context) activity, bundle, str, str2, (Bundle) null);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, int i) {
        a(activity, bundle, str, str2, i, (Bundle) null);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, @AnimRes int i, @AnimRes int i2) {
        a((Context) activity, bundle, str, str2, a((Context) activity, i, i2));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, int i, @AnimRes int i2, @AnimRes int i3) {
        a(activity, bundle, str, str2, i, a((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, int i, @Nullable Bundle bundle2) {
        a(activity, bundle, str, str2, i, bundle2);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, int i, View... viewArr) {
        a(activity, bundle, str, str2, i, a(activity, viewArr));
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, @Nullable Bundle bundle2) {
        a((Context) activity, bundle, str, str2, bundle2);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, View... viewArr) {
        a((Context) activity, bundle, str, str2, a(activity, viewArr));
    }

    private static void a(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i) {
        a(fragment, bundle, q.a().getPackageName(), cls.getName(), i, (Bundle) null);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, @AnimRes int i2, @AnimRes int i3) {
        a(fragment, bundle, q.a().getPackageName(), cls.getName(), i, a(fragment, i2, i3));
    }

    private static void a(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, @Nullable Bundle bundle2) {
        a(fragment, bundle, q.a().getPackageName(), cls.getName(), i, bundle2);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, View... viewArr) {
        a(fragment, bundle, q.a().getPackageName(), cls.getName(), i, a(fragment, viewArr));
    }

    private static void a(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull String str, @NonNull String str2, int i) {
        a(fragment, bundle, str, str2, i, (Bundle) null);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull String str, @NonNull String str2, int i, @AnimRes int i2, @AnimRes int i3) {
        a(fragment, bundle, str, str2, i, a(fragment, i2, i3));
    }

    private static void a(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull String str, @NonNull String str2, int i, @Nullable Bundle bundle2) {
        a(fragment, bundle, str, str2, i, bundle2);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull String str, @NonNull String str2, int i, View... viewArr) {
        a(fragment, bundle, str, str2, i, a(fragment, viewArr));
    }

    private static void a(@NonNull Bundle bundle, @NonNull Class<? extends Activity> cls) {
        Context k = k();
        a(k, bundle, k.getPackageName(), cls.getName(), (Bundle) null);
    }

    private static void a(@NonNull Bundle bundle, @NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        Context k = k();
        a(k, bundle, k.getPackageName(), cls.getName(), a(k, i, i2));
        if (Build.VERSION.SDK_INT < 16 && (k instanceof Activity)) {
            ((Activity) k).overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Bundle bundle, @NonNull Class<? extends Activity> cls, @Nullable Bundle bundle2) {
        Context k = k();
        a(k, bundle, k.getPackageName(), cls.getName(), bundle2);
    }

    private static void a(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2) {
        a(k(), bundle, str, str2, (Bundle) null);
    }

    private static void a(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2, @AnimRes int i, @AnimRes int i2) {
        Context k = k();
        a(k, bundle, str, str2, a(k, i, i2));
        if (Build.VERSION.SDK_INT < 16 && (k instanceof Activity)) {
            ((Activity) k).overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2, @Nullable Bundle bundle2) {
        a(k(), bundle, str, str2, bundle2);
    }

    private static void a(@NonNull Fragment fragment, @NonNull Intent intent, int i) {
        a(intent, fragment, i, (Bundle) null);
    }

    private static void a(@NonNull Fragment fragment, @NonNull Intent intent, int i, @AnimRes int i2, @AnimRes int i3) {
        a(intent, fragment, i, a(fragment, i2, i3));
    }

    private static void a(@NonNull Fragment fragment, @NonNull Intent intent, int i, @Nullable Bundle bundle) {
        a(intent, fragment, i, bundle);
    }

    private static void a(@NonNull Fragment fragment, @NonNull Intent intent, int i, View... viewArr) {
        a(intent, fragment, i, a(fragment, viewArr));
    }

    private static void a(@NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i) {
        a(fragment, (Bundle) null, q.a().getPackageName(), cls.getName(), i, (Bundle) null);
    }

    private static void a(@NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, @AnimRes int i2, @AnimRes int i3) {
        a(fragment, (Bundle) null, q.a().getPackageName(), cls.getName(), i, a(fragment, i2, i3));
    }

    private static void a(@NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, @Nullable Bundle bundle) {
        a(fragment, (Bundle) null, q.a().getPackageName(), cls.getName(), i, bundle);
    }

    private static void a(@NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, View... viewArr) {
        a(fragment, (Bundle) null, q.a().getPackageName(), cls.getName(), i, a(fragment, viewArr));
    }

    private static void a(@Nullable q.a aVar) {
        s.a(aVar);
    }

    private static void a(@NonNull Class<? extends Activity> cls) {
        Context k = k();
        a(k, (Bundle) null, k.getPackageName(), cls.getName(), (Bundle) null);
    }

    private static void a(@NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        Context k = k();
        a(k, (Bundle) null, k.getPackageName(), cls.getName(), a(k, i, i2));
        if (Build.VERSION.SDK_INT < 16 && (k instanceof Activity)) {
            ((Activity) k).overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull Class<? extends Activity> cls, @Nullable Bundle bundle) {
        Context k = k();
        a(k, (Bundle) null, k.getPackageName(), cls.getName(), bundle);
    }

    private static void a(@NonNull String str, @NonNull String str2, @AnimRes int i, @AnimRes int i2) {
        Context k = k();
        a(k, (Bundle) null, str, str2, a(k, i, i2));
        if (Build.VERSION.SDK_INT < 16 && (k instanceof Activity)) {
            ((Activity) k).overridePendingTransition(i, i2);
        }
    }

    private static void a(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle) {
        a(k(), (Bundle) null, str, str2, bundle);
    }

    private static void a(@NonNull Intent[] intentArr) {
        a(intentArr, k(), (Bundle) null);
    }

    private static void a(@NonNull Intent[] intentArr, @AnimRes int i, @AnimRes int i2) {
        Context k = k();
        a(intentArr, k, a(k, i, i2));
        if (Build.VERSION.SDK_INT < 16 && (k instanceof Activity)) {
            ((Activity) k).overridePendingTransition(i, i2);
        }
    }

    private static void a(Intent[] intentArr, Context context, @Nullable Bundle bundle) {
        if (!(context instanceof Activity)) {
            for (Intent addFlags : intentArr) {
                addFlags.addFlags(268435456);
            }
        }
        if (bundle == null || Build.VERSION.SDK_INT < 16) {
            context.startActivities(intentArr);
        } else {
            context.startActivities(intentArr, bundle);
        }
    }

    private static void a(@NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        a(intentArr, k(), bundle);
    }

    public static boolean a(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return Build.VERSION.SDK_INT < 17 || !activity.isDestroyed();
    }

    private static boolean a(Activity activity, Bundle bundle, String str, String str2, int i, @Nullable Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return a(intent, activity, i, bundle2);
    }

    private static boolean a(@NonNull Activity activity, boolean z) {
        for (Activity next : r.f1768a.a()) {
            if (!next.equals(activity)) {
                e(next);
            } else if (!z) {
                return true;
            } else {
                e(next);
                return true;
            }
        }
        return false;
    }

    private static boolean a(@NonNull Activity activity, boolean z, @AnimRes int i, @AnimRes int i2) {
        for (Activity next : r.f1768a.a()) {
            if (!next.equals(activity)) {
                a(next, i, i2);
            } else if (!z) {
                return true;
            } else {
                a(next, i, i2);
                return true;
            }
        }
        return false;
    }

    private static boolean a(@NonNull Intent intent) {
        return a(intent, k(), (Bundle) null);
    }

    private static boolean a(@NonNull Intent intent, @AnimRes int i, @AnimRes int i2) {
        Context k = k();
        boolean a2 = a(intent, k, a(k, i, i2));
        if (a2 && Build.VERSION.SDK_INT < 16 && (k instanceof Activity)) {
            ((Activity) k).overridePendingTransition(i, i2);
        }
        return a2;
    }

    private static boolean a(Intent intent, Activity activity, int i, @Nullable Bundle bundle) {
        if (!b(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        } else if (bundle == null || Build.VERSION.SDK_INT < 16) {
            activity.startActivityForResult(intent, i);
            return true;
        } else {
            activity.startActivityForResult(intent, i, bundle);
            return true;
        }
    }

    private static boolean a(Intent intent, Context context, Bundle bundle) {
        if (!b(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (bundle == null || Build.VERSION.SDK_INT < 16) {
            context.startActivity(intent);
            return true;
        }
        context.startActivity(intent, bundle);
        return true;
    }

    private static boolean a(@NonNull Intent intent, @Nullable Bundle bundle) {
        return a(intent, k(), bundle);
    }

    private static boolean a(Intent intent, Fragment fragment, int i, @Nullable Bundle bundle) {
        String str;
        String str2;
        if (!b(intent)) {
            str = "ActivityUtils";
            str2 = "intent is unavailable";
        } else if (fragment.getActivity() == null) {
            str = "ActivityUtils";
            str2 = "Fragment " + fragment + " not attached to Activity";
        } else if (bundle == null || Build.VERSION.SDK_INT < 16) {
            fragment.startActivityForResult(intent, i);
            return true;
        } else {
            fragment.startActivityForResult(intent, i, bundle);
            return true;
        }
        Log.e(str, str2);
        return false;
    }

    private static boolean a(Fragment fragment, Bundle bundle, String str, String str2, int i, @Nullable Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return a(intent, fragment, i, bundle2);
    }

    private static boolean a(@NonNull Class<? extends Activity> cls, boolean z) {
        for (Activity next : r.f1768a.a()) {
            if (!next.getClass().equals(cls)) {
                e(next);
            } else if (!z) {
                return true;
            } else {
                e(next);
                return true;
            }
        }
        return false;
    }

    private static boolean a(@NonNull Class<? extends Activity> cls, boolean z, @AnimRes int i, @AnimRes int i2) {
        for (Activity next : r.f1768a.a()) {
            if (!next.getClass().equals(cls)) {
                a(next, i, i2);
            } else if (!z) {
                return true;
            } else {
                a(next, i, i2);
                return true;
            }
        }
        return false;
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        PackageManager packageManager = q.a().getPackageManager();
        return (packageManager.resolveActivity(intent, 0) == null || intent.resolveActivity(packageManager) == null || packageManager.queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    @Nullable
    private static Activity b(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Activity c2 = c(context);
            if (c2 != null) {
                return c2;
            }
            arrayList.add(context);
            context = ((ContextWrapper) context).getBaseContext();
            if (context != null) {
                if (arrayList.contains(context)) {
                    break;
                }
            } else {
                return null;
            }
        }
        return null;
    }

    @Nullable
    private static Drawable b(@NonNull ComponentName componentName) {
        try {
            return q.a().getPackageManager().getActivityLogo(componentName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void b() {
        String packageName = q.a().getPackageName();
        String a2 = a(packageName);
        if (!TextUtils.isEmpty(a2)) {
            a(k(), (Bundle) null, packageName, a2, (Bundle) null);
        }
    }

    private static void b(@AnimRes int i, @AnimRes int i2) {
        List<Activity> a2 = r.f1768a.a();
        for (int i3 = 1; i3 < a2.size(); i3++) {
            a(a2.get(i3), i, i2);
        }
    }

    private static void b(@Nullable Activity activity) {
        r rVar = r.f1768a;
        if (activity != null) {
            o.a((Runnable) new Runnable(activity) {
                /*  JADX ERROR: Method generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cyjh.common.util.toast.r.2.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    */
                public final void run(
/*
Method generation error in method: com.cyjh.common.util.toast.r.2.run():void, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cyjh.common.util.toast.r.2.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
        }
    }

    private static void b(@Nullable Activity activity, @Nullable q.a aVar) {
        r.f1768a.b(activity, aVar);
    }

    private static void b(@Nullable q.a aVar) {
        s.b(aVar);
    }

    private static void b(@NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        for (Activity next : r.f1768a.a()) {
            if (next.getClass().equals(cls)) {
                next.finish();
                next.overridePendingTransition(i, i2);
            }
        }
    }

    private static void b(@NonNull String str) {
        String a2 = a(str);
        if (!TextUtils.isEmpty(a2)) {
            a(k(), (Bundle) null, str, a2, (Bundle) null);
        }
    }

    private static void b(@NonNull String str, @NonNull String str2) {
        a(k(), (Bundle) null, str, str2, (Bundle) null);
    }

    private static boolean b(@NonNull Activity activity, boolean z) {
        for (Activity next : r.f1768a.a()) {
            if (!next.equals(activity)) {
                e(next);
            } else if (!z) {
                return true;
            } else {
                e(next);
                return true;
            }
        }
        return false;
    }

    private static boolean b(Intent intent) {
        return q.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private static boolean b(@NonNull Class<? extends Activity> cls) {
        for (Activity activity : r.f1768a.a()) {
            if (activity.getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(@NonNull Class<? extends Activity> cls, boolean z) {
        for (Activity next : r.f1768a.a()) {
            if (!next.getClass().equals(cls)) {
                e(next);
            } else if (!z) {
                return true;
            } else {
                e(next);
                return true;
            }
        }
        return false;
    }

    @Nullable
    private static Activity c(@Nullable Context context) {
        if (context != null && context.getClass().getName().equals("com.android.internal.policy.DecorContext")) {
            try {
                Field declaredField = context.getClass().getDeclaredField("mActivityContext");
                declaredField.setAccessible(true);
                return (Activity) ((WeakReference) declaredField.get(context)).get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static List<Activity> c() {
        return r.f1768a.a();
    }

    private static List<String> c(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = q.a().getPackageManager().queryIntentActivities(intent, 0);
        int size = queryIntentActivities.size();
        if (size == 0) {
            return arrayList;
        }
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo = queryIntentActivities.get(i);
            if (resolveInfo.activityInfo.processName.equals(str)) {
                arrayList.add(resolveInfo.activityInfo.name);
            }
        }
        return arrayList;
    }

    private static void c(@NonNull Class<? extends Activity> cls) {
        for (Activity next : r.f1768a.a()) {
            if (next.getClass().equals(cls)) {
                next.finish();
                next.overridePendingTransition(0, 0);
            }
        }
    }

    private static void c(@NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        for (Activity next : r.f1768a.a()) {
            if (!next.getClass().equals(cls)) {
                a(next, i, i2);
            }
        }
    }

    private static boolean c(@NonNull Activity activity) {
        for (Activity equals : r.f1768a.a()) {
            if (equals.equals(activity)) {
                return true;
            }
        }
        return false;
    }

    private static String d() {
        return a(q.a().getPackageName());
    }

    private static void d(@NonNull Activity activity) {
        e(activity);
    }

    private static void d(@NonNull Class<? extends Activity> cls) {
        for (Activity next : r.f1768a.a()) {
            if (next.getClass().equals(cls)) {
                next.finish();
                next.overridePendingTransition(0, 0);
            }
        }
    }

    private static boolean d(Context context) {
        Activity activity;
        Activity activity2 = null;
        if (context != null) {
            if (context != null) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    if (context instanceof ContextWrapper) {
                        if (!(context instanceof Activity)) {
                            Activity c2 = c(context);
                            if (c2 == null) {
                                arrayList.add(context);
                                context = ((ContextWrapper) context).getBaseContext();
                                if (context != null) {
                                    if (arrayList.contains(context)) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                activity = c2;
                                break;
                            }
                        } else {
                            activity = (Activity) context;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            activity = null;
            if (a(activity)) {
                activity2 = activity;
            }
        }
        return a(activity2);
    }

    private static List<String> e() {
        String packageName = q.a().getPackageName();
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.setPackage(packageName);
        List<ResolveInfo> queryIntentActivities = q.a().getPackageManager().queryIntentActivities(intent, 0);
        int size = queryIntentActivities.size();
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = queryIntentActivities.get(i);
                if (resolveInfo.activityInfo.processName.equals(packageName)) {
                    arrayList.add(resolveInfo.activityInfo.name);
                }
            }
        }
        return arrayList;
    }

    private static void e(@NonNull Activity activity) {
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    private static void e(@NonNull Class<? extends Activity> cls) {
        for (Activity next : r.f1768a.a()) {
            if (!next.getClass().equals(cls)) {
                e(next);
            }
        }
    }

    private static Activity f() {
        for (Activity next : r.f1768a.a()) {
            if (a(next)) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    private static Drawable f(@NonNull Activity activity) {
        return a(activity.getComponentName());
    }

    private static void f(@NonNull Class<? extends Activity> cls) {
        for (Activity next : r.f1768a.a()) {
            if (!next.getClass().equals(cls)) {
                e(next);
            }
        }
    }

    @Nullable
    private static Drawable g(@NonNull Activity activity) {
        return b(activity.getComponentName());
    }

    @Nullable
    private static Drawable g(@NonNull Class<? extends Activity> cls) {
        return a(new ComponentName(q.a(), cls));
    }

    private static void g() {
        for (Activity next : r.f1768a.a()) {
            next.finish();
            next.overridePendingTransition(0, 0);
        }
    }

    @Nullable
    private static Drawable h(@NonNull Class<? extends Activity> cls) {
        return b(new ComponentName(q.a(), cls));
    }

    private static void h() {
        for (Activity next : r.f1768a.a()) {
            next.finish();
            next.overridePendingTransition(0, 0);
        }
    }

    private static void i() {
        List<Activity> a2 = r.f1768a.a();
        for (int i = 1; i < a2.size(); i++) {
            e(a2.get(i));
        }
    }

    private static void j() {
        List<Activity> a2 = r.f1768a.a();
        for (int i = 1; i < a2.size(); i++) {
            e(a2.get(i));
        }
    }

    private static Context k() {
        Activity activity;
        if (!s.a()) {
            return q.a();
        }
        Iterator<Activity> it = r.f1768a.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                activity = null;
                break;
            }
            activity = it.next();
            if (a(activity)) {
                break;
            }
        }
        return activity == null ? q.a() : activity;
    }
}
