package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.o;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    private static final String e = "SupportRMFragment";

    /* renamed from: a  reason: collision with root package name */
    final a f1400a;

    /* renamed from: b  reason: collision with root package name */
    final l f1401b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    o f1402c;
    @Nullable
    Fragment d;
    private final Set<SupportRequestManagerFragment> f;
    @Nullable
    private SupportRequestManagerFragment g;

    private class a implements l {
        a() {
        }

        @NonNull
        public final Set<o> a() {
            Set<SupportRequestManagerFragment> a2 = SupportRequestManagerFragment.this.a();
            HashSet hashSet = new HashSet(a2.size());
            for (SupportRequestManagerFragment next : a2) {
                if (next.f1402c != null) {
                    hashSet.add(next.f1402c);
                }
            }
            return hashSet;
        }

        public final String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new a());
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    private SupportRequestManagerFragment(@NonNull a aVar) {
        this.f1401b = new a();
        this.f = new HashSet();
        this.f1400a = aVar;
    }

    private void a(@Nullable Fragment fragment) {
        this.d = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    private void a(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f.add(supportRequestManagerFragment);
    }

    private void a(@Nullable o oVar) {
        this.f1402c = oVar;
    }

    @NonNull
    private a b() {
        return this.f1400a;
    }

    private void b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f.remove(supportRequestManagerFragment);
    }

    private boolean b(@NonNull Fragment fragment) {
        Fragment e2 = e();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(e2)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @Nullable
    private o c() {
        return this.f1402c;
    }

    @NonNull
    private l d() {
        return this.f1401b;
    }

    @Nullable
    private Fragment e() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.d;
    }

    private void f() {
        if (this.g != null) {
            this.g.f.remove(this);
            this.g = null;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final Set<SupportRequestManagerFragment> a() {
        if (this.g == null) {
            return Collections.emptySet();
        }
        if (equals(this.g)) {
            return Collections.unmodifiableSet(this.f);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment next : this.g.a()) {
            if (b(next.e())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public final void a(@NonNull FragmentActivity fragmentActivity) {
        f();
        this.g = f.b((Context) fragmentActivity).e.a(fragmentActivity.getSupportFragmentManager(), (Fragment) null, k.b((Activity) fragmentActivity));
        if (!equals(this.g)) {
            this.g.f.add(this);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            a(getActivity());
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(e, 5)) {
                Log.w(e, "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1400a.c();
        f();
    }

    public void onDetach() {
        super.onDetach();
        this.d = null;
        f();
    }

    public void onStart() {
        super.onStart();
        this.f1400a.a();
    }

    public void onStop() {
        super.onStop();
        this.f1400a.b();
    }

    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }
}
