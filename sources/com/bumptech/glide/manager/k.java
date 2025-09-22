package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.f;
import com.bumptech.glide.o;
import com.bumptech.glide.util.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class k implements Handler.Callback {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final String f1413a = "com.bumptech.glide.manager";
    private static final String f = "RMRetriever";
    private static final int g = 1;
    private static final int h = 2;
    private static final String i = "key";
    private static final a n = new a() {
        @NonNull
        public final o a(@NonNull f fVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
            return new o(fVar, hVar, lVar, context);
        }
    };
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final Map<FragmentManager, RequestManagerFragment> f1414b = new HashMap();
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> f1415c = new HashMap();
    public final ArrayMap<View, Fragment> d = new ArrayMap<>();
    public final ArrayMap<View, android.app.Fragment> e = new ArrayMap<>();
    private volatile o j;
    private final Handler k;
    private final a l;
    private final Bundle m = new Bundle();

    public interface a {
        @NonNull
        o a(@NonNull f fVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context);
    }

    public k(@Nullable a aVar) {
        this.l = aVar == null ? n : aVar;
        this.k = new Handler(Looper.getMainLooper(), this);
    }

    @Nullable
    @Deprecated
    private android.app.Fragment a(@NonNull View view, @NonNull Activity activity) {
        this.e.clear();
        a(activity.getFragmentManager(), this.e);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.e.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.e.clear();
        return fragment;
    }

    @Nullable
    private Fragment a(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.d.clear();
        a((Collection<Fragment>) fragmentActivity.getSupportFragmentManager().getFragments(), (Map<View, Fragment>) this.d);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.d.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.d.clear();
        return fragment;
    }

    @Deprecated
    @NonNull
    private o a(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment a2 = a(fragmentManager, fragment, z);
        o oVar = a2.f1398c;
        if (oVar != null) {
            return oVar;
        }
        o a3 = this.l.a(f.b(context), a2.f1396a, a2.f1397b, context);
        a2.f1398c = a3;
        return a3;
    }

    @NonNull
    private o a(@NonNull Context context, @NonNull android.support.v4.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment a2 = a(fragmentManager, fragment, z);
        o oVar = a2.f1402c;
        if (oVar != null) {
            return oVar;
        }
        o a3 = this.l.a(f.b(context), a2.f1400a, a2.f1401b, context);
        a2.f1402c = a3;
        return a3;
    }

    /* JADX WARNING: type inference failed for: r3v6, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r3v8, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006d, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006d, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b0, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.o a(@android.support.annotation.NonNull android.view.View r7) {
        /*
            r6 = this;
            boolean r0 = com.bumptech.glide.util.k.d()
            if (r0 == 0) goto L_0x0013
        L_0x0006:
            android.content.Context r7 = r7.getContext()
            android.content.Context r7 = r7.getApplicationContext()
            com.bumptech.glide.o r7 = r6.a((android.content.Context) r7)
            return r7
        L_0x0013:
            java.lang.String r0 = "Argument must not be null"
            com.bumptech.glide.util.i.a(r7, (java.lang.String) r0)
            android.content.Context r0 = r7.getContext()
            java.lang.String r1 = "Unable to obtain a request manager for a view without a Context"
            com.bumptech.glide.util.i.a(r0, (java.lang.String) r1)
            android.content.Context r0 = r7.getContext()
            android.app.Activity r0 = b((android.content.Context) r0)
            if (r0 != 0) goto L_0x002c
            goto L_0x0006
        L_0x002c:
            boolean r1 = r0 instanceof android.support.v4.app.FragmentActivity
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            r3 = 0
            if (r1 == 0) goto L_0x007e
            r1 = r0
            android.support.v4.app.FragmentActivity r1 = (android.support.v4.app.FragmentActivity) r1
            android.support.v4.util.ArrayMap<android.view.View, android.support.v4.app.Fragment> r4 = r6.d
            r4.clear()
            android.support.v4.app.FragmentManager r4 = r1.getSupportFragmentManager()
            java.util.List r4 = r4.getFragments()
            android.support.v4.util.ArrayMap<android.view.View, android.support.v4.app.Fragment> r5 = r6.d
            a((java.util.Collection<android.support.v4.app.Fragment>) r4, (java.util.Map<android.view.View, android.support.v4.app.Fragment>) r5)
            android.view.View r1 = r1.findViewById(r2)
        L_0x004d:
            boolean r2 = r7.equals(r1)
            if (r2 != 0) goto L_0x006d
            android.support.v4.util.ArrayMap<android.view.View, android.support.v4.app.Fragment> r2 = r6.d
            java.lang.Object r2 = r2.get(r7)
            r3 = r2
            android.support.v4.app.Fragment r3 = (android.support.v4.app.Fragment) r3
            if (r3 != 0) goto L_0x006d
            android.view.ViewParent r2 = r7.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x006d
            android.view.ViewParent r7 = r7.getParent()
            android.view.View r7 = (android.view.View) r7
            goto L_0x004d
        L_0x006d:
            android.support.v4.util.ArrayMap<android.view.View, android.support.v4.app.Fragment> r7 = r6.d
            r7.clear()
            if (r3 == 0) goto L_0x0079
            com.bumptech.glide.o r7 = r6.a((android.support.v4.app.Fragment) r3)
            return r7
        L_0x0079:
            com.bumptech.glide.o r7 = r6.a((android.app.Activity) r0)
            return r7
        L_0x007e:
            android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment> r1 = r6.e
            r1.clear()
            android.app.FragmentManager r1 = r0.getFragmentManager()
            android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment> r4 = r6.e
            r6.a((android.app.FragmentManager) r1, (android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment>) r4)
            android.view.View r1 = r0.findViewById(r2)
        L_0x0090:
            boolean r2 = r7.equals(r1)
            if (r2 != 0) goto L_0x00b0
            android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment> r2 = r6.e
            java.lang.Object r2 = r2.get(r7)
            r3 = r2
            android.app.Fragment r3 = (android.app.Fragment) r3
            if (r3 != 0) goto L_0x00b0
            android.view.ViewParent r2 = r7.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x00b0
            android.view.ViewParent r7 = r7.getParent()
            android.view.View r7 = (android.view.View) r7
            goto L_0x0090
        L_0x00b0:
            android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment> r7 = r6.e
            r7.clear()
            if (r3 != 0) goto L_0x00bc
            com.bumptech.glide.o r7 = r6.a((android.app.Activity) r0)
            return r7
        L_0x00bc:
            com.bumptech.glide.o r7 = r6.a((android.app.Fragment) r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.k.a(android.view.View):com.bumptech.glide.o");
    }

    public static void a(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment next : collection) {
                if (!(next == null || next.getView() == null)) {
                    map.put(next.getView(), next);
                    a((Collection<Fragment>) next.getChildFragmentManager().getFragments(), map);
                }
            }
        }
    }

    @Nullable
    public static Activity b(@NonNull Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    @NonNull
    private SupportRequestManagerFragment b(FragmentActivity fragmentActivity) {
        return a(fragmentActivity.getSupportFragmentManager(), (Fragment) null, b((Activity) fragmentActivity));
    }

    @Deprecated
    private void b(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.m.putInt(i, i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.m, i);
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    if (Build.VERSION.SDK_INT >= 17) {
                        a(fragment.getChildFragmentManager(), arrayMap);
                    }
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    static boolean b(Activity activity) {
        return !activity.isFinishing();
    }

    @NonNull
    private o c(@NonNull Context context) {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = this.l.a(f.b(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.j;
    }

    @TargetApi(17)
    private static void c(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Deprecated
    @NonNull
    private RequestManagerFragment d(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null, b(activity));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final RequestManagerFragment a(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(f1413a);
        if (requestManagerFragment == null && (requestManagerFragment = this.f1414b.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.d = fragment;
            if (!(fragment == null || fragment.getActivity() == null)) {
                requestManagerFragment.a(fragment.getActivity());
            }
            if (z) {
                requestManagerFragment.f1396a.a();
            }
            this.f1414b.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, f1413a).commitAllowingStateLoss();
            this.k.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final SupportRequestManagerFragment a(@NonNull android.support.v4.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(f1413a);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f1415c.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.d = fragment;
            if (!(fragment == null || fragment.getActivity() == null)) {
                supportRequestManagerFragment.a(fragment.getActivity());
            }
            if (z) {
                supportRequestManagerFragment.f1400a.a();
            }
            this.f1415c.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add((Fragment) supportRequestManagerFragment, f1413a).commitAllowingStateLoss();
            this.k.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    @NonNull
    public final o a(@NonNull Activity activity) {
        if (com.bumptech.glide.util.k.d()) {
            return a(activity.getApplicationContext());
        }
        c(activity);
        return a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null, b(activity));
    }

    @TargetApi(17)
    @Deprecated
    @NonNull
    public final o a(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (com.bumptech.glide.util.k.d() || Build.VERSION.SDK_INT < 17) {
            return a(fragment.getActivity().getApplicationContext());
        } else {
            return a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }

    @NonNull
    public final o a(@NonNull Context context) {
        while (context != null) {
            if (com.bumptech.glide.util.k.c() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return a((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            return c(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public final o a(@NonNull Fragment fragment) {
        i.a(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.util.k.d()) {
            return a(fragment.getActivity().getApplicationContext());
        }
        return a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public final o a(@NonNull FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.util.k.d()) {
            return a(fragmentActivity.getApplicationContext());
        }
        c((Activity) fragmentActivity);
        return a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, b((Activity) fragmentActivity));
    }

    @TargetApi(26)
    @Deprecated
    public final void a(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment next : fragmentManager.getFragments()) {
                if (next.getView() != null) {
                    arrayMap.put(next.getView(), next);
                    a(next.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.m.putInt(i, i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.m, i);
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    if (Build.VERSION.SDK_INT >= 17) {
                        a(fragment.getChildFragmentManager(), arrayMap);
                    }
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        Map map;
        Object obj2 = null;
        boolean z = true;
        switch (message.what) {
            case 1:
                obj2 = (FragmentManager) message.obj;
                map = this.f1414b;
                break;
            case 2:
                obj2 = (android.support.v4.app.FragmentManager) message.obj;
                map = this.f1415c;
                break;
            default:
                z = false;
                obj = null;
                break;
        }
        obj = map.remove(obj2);
        if (z && obj == null && Log.isLoggable(f, 5)) {
            Log.w(f, "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }
}
