package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import org.greenrobot.eventbus.util.ErrorDialogFragments;

public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final b f4359a;

    @TargetApi(11)
    public static class a extends c<Fragment> {
        private a(b bVar) {
            super(bVar);
        }

        private static Fragment b(Bundle bundle) {
            ErrorDialogFragments.Honeycomb honeycomb = new ErrorDialogFragments.Honeycomb();
            honeycomb.setArguments(bundle);
            return honeycomb;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object a(Bundle bundle) {
            ErrorDialogFragments.Honeycomb honeycomb = new ErrorDialogFragments.Honeycomb();
            honeycomb.setArguments(bundle);
            return honeycomb;
        }
    }

    public static class b extends c<android.support.v4.app.Fragment> {
        private b(b bVar) {
            super(bVar);
        }

        private static android.support.v4.app.Fragment b(Bundle bundle) {
            ErrorDialogFragments.Support support = new ErrorDialogFragments.Support();
            support.setArguments(bundle);
            return support;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object a(Bundle bundle) {
            ErrorDialogFragments.Support support = new ErrorDialogFragments.Support();
            support.setArguments(bundle);
            return support;
        }
    }

    protected c(b bVar) {
        this.f4359a = bVar;
    }

    private String a() {
        return this.f4359a.f4356a.getString(this.f4359a.f4357b);
    }

    private String a(f fVar) {
        int i;
        b bVar = this.f4359a;
        Throwable th = fVar.f4361a;
        Integer a2 = bVar.d.a(th);
        if (a2 != null) {
            i = a2.intValue();
        } else {
            String str = org.greenrobot.eventbus.c.f4301a;
            Log.d(str, "No specific message ressource ID found for " + th);
            i = bVar.f4358c;
        }
        return this.f4359a.f4356a.getString(i);
    }

    /* access modifiers changed from: protected */
    public abstract T a(Bundle bundle);

    /* access modifiers changed from: protected */
    public final T a(f fVar, boolean z, Bundle bundle) {
        int i;
        if (fVar.b()) {
            return null;
        }
        Bundle bundle2 = bundle != null ? (Bundle) bundle.clone() : new Bundle();
        if (!bundle2.containsKey(ErrorDialogManager.d)) {
            bundle2.putString(ErrorDialogManager.d, this.f4359a.f4356a.getString(this.f4359a.f4357b));
        }
        if (!bundle2.containsKey(ErrorDialogManager.e)) {
            b bVar = this.f4359a;
            Throwable th = fVar.f4361a;
            Integer a2 = bVar.d.a(th);
            if (a2 != null) {
                i = a2.intValue();
            } else {
                String str = org.greenrobot.eventbus.c.f4301a;
                Log.d(str, "No specific message ressource ID found for " + th);
                i = bVar.f4358c;
            }
            bundle2.putString(ErrorDialogManager.e, this.f4359a.f4356a.getString(i));
        }
        if (!bundle2.containsKey(ErrorDialogManager.f)) {
            bundle2.putBoolean(ErrorDialogManager.f, z);
        }
        if (!bundle2.containsKey(ErrorDialogManager.h) && this.f4359a.i != null) {
            bundle2.putSerializable(ErrorDialogManager.h, this.f4359a.i);
        }
        if (!bundle2.containsKey(ErrorDialogManager.g) && this.f4359a.h != 0) {
            bundle2.putInt(ErrorDialogManager.g, this.f4359a.h);
        }
        return a(bundle2);
    }
}
