package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.o;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class RequestManagerFragment extends Fragment {
    private static final String e = "RMFragment";

    /* renamed from: a  reason: collision with root package name */
    final a f1396a;

    /* renamed from: b  reason: collision with root package name */
    final l f1397b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    o f1398c;
    @Nullable
    Fragment d;
    private final Set<RequestManagerFragment> f;
    @Nullable
    private RequestManagerFragment g;

    private class a implements l {
        a() {
        }

        @NonNull
        public final Set<o> a() {
            Set<RequestManagerFragment> a2 = RequestManagerFragment.this.a();
            HashSet hashSet = new HashSet(a2.size());
            for (RequestManagerFragment next : a2) {
                if (next.f1398c != null) {
                    hashSet.add(next.f1398c);
                }
            }
            return hashSet;
        }

        public final String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new a());
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    private RequestManagerFragment(@NonNull a aVar) {
        this.f1397b = new a();
        this.f = new HashSet();
        this.f1396a = aVar;
    }

    private void a(@Nullable Fragment fragment) {
        this.d = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f.add(requestManagerFragment);
    }

    private void a(@Nullable o oVar) {
        this.f1398c = oVar;
    }

    @NonNull
    private a b() {
        return this.f1396a;
    }

    private void b(RequestManagerFragment requestManagerFragment) {
        this.f.remove(requestManagerFragment);
    }

    @TargetApi(17)
    private boolean b(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @Nullable
    private o c() {
        return this.f1398c;
    }

    @NonNull
    private l d() {
        return this.f1397b;
    }

    @Nullable
    @TargetApi(17)
    private Fragment e() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.d;
    }

    private void f() {
        if (this.g != null) {
            this.g.f.remove(this);
            this.g = null;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(17)
    @NonNull
    public final Set<RequestManagerFragment> a() {
        if (equals(this.g)) {
            return Collections.unmodifiableSet(this.f);
        }
        if (this.g == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment next : this.g.a()) {
            if (b(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public final void a(@NonNull Activity activity) {
        f();
        this.g = f.b((Context) activity).e.a(activity.getFragmentManager(), (Fragment) null, k.b(activity));
        if (!equals(this.g)) {
            this.g.f.add(this);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(e, 5)) {
                Log.w(e, "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1396a.c();
        f();
    }

    public void onDetach() {
        super.onDetach();
        f();
    }

    public void onStart() {
        super.onStart();
        this.f1396a.a();
    }

    public void onStop() {
        super.onStop();
        this.f1396a.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        if (parentFragment == null) {
            parentFragment = this.d;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
