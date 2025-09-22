package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import org.greenrobot.eventbus.c;

public final class ErrorDialogManager {

    /* renamed from: a  reason: collision with root package name */
    public static c<?> f4339a = null;

    /* renamed from: b  reason: collision with root package name */
    protected static final String f4340b = "de.greenrobot.eventbus.error_dialog";

    /* renamed from: c  reason: collision with root package name */
    protected static final String f4341c = "de.greenrobot.eventbus.error_dialog_manager";
    public static final String d = "de.greenrobot.eventbus.errordialog.title";
    public static final String e = "de.greenrobot.eventbus.errordialog.message";
    public static final String f = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
    public static final String g = "de.greenrobot.eventbus.errordialog.icon_id";
    public static final String h = "de.greenrobot.eventbus.errordialog.event_type_on_close";

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f4342a;

        /* renamed from: b  reason: collision with root package name */
        protected Bundle f4343b;

        /* renamed from: c  reason: collision with root package name */
        private c f4344c;
        private Object d;

        public static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            HoneycombManagerFragment honeycombManagerFragment = (HoneycombManagerFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f4341c);
            if (honeycombManagerFragment == null) {
                honeycombManagerFragment = new HoneycombManagerFragment();
                fragmentManager.beginTransaction().add(honeycombManagerFragment, ErrorDialogManager.f4341c).commit();
                fragmentManager.executePendingTransactions();
            }
            honeycombManagerFragment.f4342a = z;
            honeycombManagerFragment.f4343b = bundle;
            honeycombManagerFragment.d = obj;
        }

        private void a(f fVar) {
            if (ErrorDialogManager.a(this.d, fVar)) {
                ErrorDialogManager.a(fVar);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f4340b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                DialogFragment dialogFragment2 = (DialogFragment) ErrorDialogManager.f4339a.a(fVar, this.f4342a, this.f4343b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.f4340b);
                }
            }
        }

        public void onPause() {
            this.f4344c.b((Object) this);
            super.onPause();
        }

        public void onResume() {
            super.onResume();
            this.f4344c = ErrorDialogManager.f4339a.f4359a.a();
            this.f4344c.a((Object) this);
        }
    }

    public static class SupportManagerFragment extends android.support.v4.app.Fragment {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f4345a;

        /* renamed from: b  reason: collision with root package name */
        protected Bundle f4346b;

        /* renamed from: c  reason: collision with root package name */
        private c f4347c;
        private boolean d;
        private Object e;

        public static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
            android.support.v4.app.FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            SupportManagerFragment supportManagerFragment = (SupportManagerFragment) supportFragmentManager.findFragmentByTag(ErrorDialogManager.f4341c);
            if (supportManagerFragment == null) {
                supportManagerFragment = new SupportManagerFragment();
                supportFragmentManager.beginTransaction().add((android.support.v4.app.Fragment) supportManagerFragment, ErrorDialogManager.f4341c).commit();
                supportFragmentManager.executePendingTransactions();
            }
            supportManagerFragment.f4345a = z;
            supportManagerFragment.f4346b = bundle;
            supportManagerFragment.e = obj;
        }

        private void a(f fVar) {
            if (ErrorDialogManager.a(this.e, fVar)) {
                ErrorDialogManager.a(fVar);
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                android.support.v4.app.DialogFragment dialogFragment = (android.support.v4.app.DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f4340b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                android.support.v4.app.DialogFragment dialogFragment2 = (android.support.v4.app.DialogFragment) ErrorDialogManager.f4339a.a(fVar, this.f4345a, this.f4346b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.f4340b);
                }
            }
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f4347c = ErrorDialogManager.f4339a.f4359a.a();
            this.f4347c.a((Object) this);
            this.d = true;
        }

        public void onPause() {
            this.f4347c.b((Object) this);
            super.onPause();
        }

        public void onResume() {
            super.onResume();
            if (this.d) {
                this.d = false;
                return;
            }
            this.f4347c = ErrorDialogManager.f4339a.f4359a.a();
            this.f4347c.a((Object) this);
        }
    }

    private static void a(Activity activity) {
        b(activity, false);
    }

    private static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
        if (f4339a == null) {
            throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
        } else if (b(activity)) {
            SupportManagerFragment.a(activity, obj, z, bundle);
        } else {
            HoneycombManagerFragment.a(activity, obj, z, bundle);
        }
    }

    private static void a(Activity activity, boolean z) {
        b(activity, z);
    }

    protected static void a(f fVar) {
        if (f4339a.f4359a.f) {
            String str = f4339a.f4359a.g;
            if (str == null) {
                str = c.f4301a;
            }
            Log.i(str, "Error dialog manager received exception", fVar.f4361a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.f4363c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean a(java.lang.Object r0, org.greenrobot.eventbus.util.f r1) {
        /*
            if (r1 == 0) goto L_0x000e
            java.lang.Object r1 = r1.f4363c
            if (r1 == 0) goto L_0x000e
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x000e
            r0 = 0
            return r0
        L_0x000e:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.util.ErrorDialogManager.a(java.lang.Object, org.greenrobot.eventbus.util.f):boolean");
    }

    private static void b(Activity activity, boolean z) {
        Class<?> cls = activity.getClass();
        if (f4339a == null) {
            throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
        } else if (b(activity)) {
            SupportManagerFragment.a(activity, cls, z, (Bundle) null);
        } else {
            HoneycombManagerFragment.a(activity, cls, z, (Bundle) null);
        }
    }

    private static boolean b(Activity activity) {
        String name;
        Class cls = activity.getClass();
        do {
            cls = cls.getSuperclass();
            if (cls == null) {
                throw new RuntimeException("Illegal activity type: " + activity.getClass());
            }
            name = cls.getName();
            if (name.equals("android.support.v4.app.FragmentActivity")) {
                return true;
            }
            if (name.startsWith("com.actionbarsherlock.app") && (name.endsWith(".SherlockActivity") || name.endsWith(".SherlockListActivity") || name.endsWith(".SherlockPreferenceActivity"))) {
                throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + name);
            }
        } while (!name.equals("android.app.Activity"));
        if (Build.VERSION.SDK_INT >= 11) {
            return false;
        }
        throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.f4363c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(java.lang.Object r0, org.greenrobot.eventbus.util.f r1) {
        /*
            if (r1 == 0) goto L_0x000e
            java.lang.Object r1 = r1.f4363c
            if (r1 == 0) goto L_0x000e
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x000e
            r0 = 0
            return r0
        L_0x000e:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.util.ErrorDialogManager.b(java.lang.Object, org.greenrobot.eventbus.util.f):boolean");
    }
}
