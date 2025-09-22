package com.cyjh.common.util.toast;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.CallSuper;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cyjh.common.R;
import com.cyjh.common.util.toast.q;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1751a = "TAG_TOAST";

    /* renamed from: b  reason: collision with root package name */
    private static final int f1752b = -16777217;

    /* renamed from: c  reason: collision with root package name */
    private static final String f1753c = "toast null";
    private static final String d = "toast nothing";
    private static final p e = new p();
    /* access modifiers changed from: private */
    public static WeakReference<c> f;
    private String g;
    /* access modifiers changed from: private */
    public int h = -1;
    /* access modifiers changed from: private */
    public int i = -1;
    /* access modifiers changed from: private */
    public int j = -1;
    /* access modifiers changed from: private */
    public int k = f1752b;
    /* access modifiers changed from: private */
    public int l = -1;
    /* access modifiers changed from: private */
    public int m = f1752b;
    /* access modifiers changed from: private */
    public int n = -1;
    private boolean o = false;
    private Drawable[] p = new Drawable[4];
    private boolean q = false;

    static abstract class a implements c {

        /* renamed from: a  reason: collision with root package name */
        protected Toast f1757a = new Toast(q.a());

        /* renamed from: b  reason: collision with root package name */
        protected p f1758b;

        /* renamed from: c  reason: collision with root package name */
        protected View f1759c;

        a(p pVar) {
            this.f1758b = pVar;
            if (this.f1758b.h != -1 || this.f1758b.i != -1 || this.f1758b.j != -1) {
                this.f1757a.setGravity(this.f1758b.h, this.f1758b.i, this.f1758b.j);
            }
        }

        private void a(TextView textView) {
            if (this.f1758b.l != -1) {
                this.f1759c.setBackgroundResource(this.f1758b.l);
                textView.setBackgroundColor(0);
            } else if (this.f1758b.k != p.f1752b) {
                Drawable background = this.f1759c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f1758b.k, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f1758b.k, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.f1758b.k, PorterDuff.Mode.SRC_IN));
                } else {
                    this.f1759c.setBackgroundColor(this.f1758b.k);
                }
            }
        }

        private void b() {
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 17) {
                if (TextUtils.getLayoutDirectionFromLocale(Build.VERSION.SDK_INT >= 24 ? q.a().getResources().getConfiguration().getLocales().get(0) : q.a().getResources().getConfiguration().locale) == 1) {
                    z = true;
                }
            }
            if (z) {
                a(a(-1));
            }
        }

        /* access modifiers changed from: package-private */
        public final View a(int i) {
            Bitmap a2 = s.a(this.f1759c);
            ImageView imageView = new ImageView(q.a());
            imageView.setTag(p.f1751a + i);
            imageView.setImageBitmap(a2);
            return imageView;
        }

        @CallSuper
        public void a() {
            if (this.f1757a != null) {
                this.f1757a.cancel();
            }
            this.f1757a = null;
            this.f1759c = null;
        }

        public final void a(View view) {
            this.f1759c = view;
            this.f1757a.setView(this.f1759c);
        }

        public final void a(CharSequence charSequence) {
            Drawable mutate;
            PorterDuffColorFilter porterDuffColorFilter;
            View a2 = p.a(this.f1758b, charSequence);
            if (a2 != null) {
                a(a2);
                b();
                return;
            }
            this.f1759c = this.f1757a.getView();
            if (this.f1759c == null || this.f1759c.findViewById(16908299) == null) {
                a(s.a(R.layout.utils_toast_view));
            }
            TextView textView = (TextView) this.f1759c.findViewById(16908299);
            textView.setText(charSequence);
            if (this.f1758b.m != p.f1752b) {
                textView.setTextColor(this.f1758b.m);
            }
            if (this.f1758b.n != -1) {
                textView.setTextSize((float) this.f1758b.n);
            }
            if (this.f1758b.l != -1) {
                this.f1759c.setBackgroundResource(this.f1758b.l);
            } else {
                if (this.f1758b.k != p.f1752b) {
                    Drawable background = this.f1759c.getBackground();
                    Drawable background2 = textView.getBackground();
                    if (background == null || background2 == null) {
                        if (background != null) {
                            mutate = background.mutate();
                            porterDuffColorFilter = new PorterDuffColorFilter(this.f1758b.k, PorterDuff.Mode.SRC_IN);
                        } else if (background2 != null) {
                            mutate = background2.mutate();
                            porterDuffColorFilter = new PorterDuffColorFilter(this.f1758b.k, PorterDuff.Mode.SRC_IN);
                        } else {
                            this.f1759c.setBackgroundColor(this.f1758b.k);
                        }
                        mutate.setColorFilter(porterDuffColorFilter);
                    } else {
                        background.mutate().setColorFilter(new PorterDuffColorFilter(this.f1758b.k, PorterDuff.Mode.SRC_IN));
                    }
                }
                b();
            }
            textView.setBackgroundColor(0);
            b();
        }
    }

    static final class b extends a {
        private static int d;
        private q.a e;
        private c f;

        b(p pVar) {
            super(pVar);
        }

        private c a(Activity activity, int i) {
            f fVar = new f(this.f1758b, activity.getWindowManager());
            fVar.f1759c = a(-1);
            fVar.f1757a = this.f1757a;
            fVar.b(i);
            return fVar;
        }

        /* access modifiers changed from: private */
        public void a(Activity activity, int i, boolean z) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.f1757a.getGravity();
                layoutParams.bottomMargin = this.f1757a.getYOffset() + s.c();
                layoutParams.topMargin = this.f1757a.getYOffset() + s.b();
                layoutParams.leftMargin = this.f1757a.getXOffset();
                View a2 = a(i);
                if (z) {
                    a2.setAlpha(0.0f);
                    a2.animate().alpha(1.0f).setDuration(200).start();
                }
                viewGroup.addView(a2, layoutParams);
            }
        }

        private void b() {
            final int i = d;
            this.e = new q.a() {
                public final void a(@NonNull Activity activity) {
                    if (b.this.d()) {
                        b.this.a(activity, r0, false);
                    }
                }
            };
            s.a(this.e);
        }

        private c c(int i) {
            e eVar = new e(this.f1758b);
            eVar.f1757a = this.f1757a;
            eVar.b(i);
            return eVar;
        }

        private void c() {
            s.b(this.e);
            this.e = null;
        }

        /* access modifiers changed from: private */
        public boolean d() {
            return this.e != null;
        }

        public final void a() {
            Window window;
            if (d()) {
                s.b(this.e);
                this.e = null;
                for (Activity next : r.f1768a.a()) {
                    if (a.a(next) && (window = next.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb = new StringBuilder(p.f1751a);
                        sb.append(d - 1);
                        View findViewWithTag = viewGroup.findViewWithTag(sb.toString());
                        if (findViewWithTag != null) {
                            try {
                                viewGroup.removeView(findViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (this.f != null) {
                this.f.a();
                this.f = null;
            }
            super.a();
        }

        public final void b(int i) {
            if (this.f1757a != null) {
                if (!s.a()) {
                    this.f = c(i);
                    return;
                }
                boolean z = false;
                for (Activity next : r.f1768a.a()) {
                    if (a.a(next)) {
                        if (!z) {
                            f fVar = new f(this.f1758b, next.getWindowManager());
                            fVar.f1759c = a(-1);
                            fVar.f1757a = this.f1757a;
                            fVar.b(i);
                            this.f = fVar;
                            z = true;
                        } else {
                            a(next, d, true);
                        }
                    }
                }
                if (z) {
                    final int i2 = d;
                    this.e = new q.a() {
                        public final void a(@NonNull Activity activity) {
                            if (b.this.d()) {
                                b.this.a(activity, i2, false);
                            }
                        }
                    };
                    s.a(this.e);
                    o.a((Runnable) new Runnable() {
                        public final void run() {
                            b.this.a();
                        }
                    }, i == 0 ? 2000 : 3500);
                    d++;
                    return;
                }
                this.f = c(i);
            }
        }
    }

    interface c {
        void a();

        void a(View view);

        void a(CharSequence charSequence);

        void b(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface d {

        /* renamed from: a  reason: collision with root package name */
        public static final String f1763a = "light";

        /* renamed from: b  reason: collision with root package name */
        public static final String f1764b = "dark";
    }

    static final class e extends a {

        static class a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            private Handler f1765a;

            a(Handler handler) {
                this.f1765a = handler;
            }

            public final void dispatchMessage(@NonNull Message message) {
                try {
                    this.f1765a.dispatchMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public final void handleMessage(@NonNull Message message) {
                this.f1765a.handleMessage(message);
            }
        }

        e(p pVar) {
            super(pVar);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.f1757a);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new a((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        public final void b(int i) {
            if (this.f1757a != null) {
                this.f1757a.setDuration(i);
                this.f1757a.show();
            }
        }
    }

    static final class f extends a {
        private WindowManager d;
        private WindowManager.LayoutParams e;

        f(p pVar, int i) {
            super(pVar);
            this.e = new WindowManager.LayoutParams();
            this.d = (WindowManager) q.a().getSystemService("window");
            this.e.type = i;
        }

        f(p pVar, WindowManager windowManager) {
            super(pVar);
            this.e = new WindowManager.LayoutParams();
            this.d = windowManager;
            this.e.type = 99;
        }

        public final void a() {
            try {
                if (this.d != null) {
                    this.d.removeViewImmediate(this.f1759c);
                    this.d = null;
                }
            } catch (Exception unused) {
            }
            super.a();
        }

        public final void b(int i) {
            if (this.f1757a != null) {
                this.e.height = -2;
                this.e.width = -2;
                this.e.format = -3;
                this.e.windowAnimations = 16973828;
                this.e.setTitle("ToastWithoutNotification");
                this.e.flags = 152;
                this.e.packageName = q.a().getPackageName();
                this.e.gravity = this.f1757a.getGravity();
                if ((this.e.gravity & 7) == 7) {
                    this.e.horizontalWeight = 1.0f;
                }
                if ((this.e.gravity & 112) == 112) {
                    this.e.verticalWeight = 1.0f;
                }
                this.e.x = this.f1757a.getXOffset();
                this.e.y = this.f1757a.getYOffset();
                this.e.horizontalMargin = this.f1757a.getHorizontalMargin();
                this.e.verticalMargin = this.f1757a.getVerticalMargin();
                try {
                    if (this.d != null) {
                        this.d.addView(this.f1759c, this.e);
                    }
                } catch (Exception unused) {
                }
                o.a((Runnable) new Runnable() {
                    public final void run() {
                        f.this.a();
                    }
                }, i == 0 ? 2000 : 3500);
            }
        }
    }

    static /* synthetic */ View a(p pVar, CharSequence charSequence) {
        if (!d.f1764b.equals(pVar.g) && !d.f1763a.equals(pVar.g) && pVar.p[0] == null && pVar.p[1] == null && pVar.p[2] == null && pVar.p[3] == null) {
            return null;
        }
        View a2 = s.a(R.layout.utils_toast_view);
        TextView textView = (TextView) a2.findViewById(16908299);
        if (d.f1764b.equals(pVar.g)) {
            ((GradientDrawable) a2.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (pVar.p[0] != null) {
            View findViewById = a2.findViewById(R.id.utvLeftIconView);
            ViewCompat.setBackground(findViewById, pVar.p[0]);
            findViewById.setVisibility(0);
        }
        if (pVar.p[1] != null) {
            View findViewById2 = a2.findViewById(R.id.utvTopIconView);
            ViewCompat.setBackground(findViewById2, pVar.p[1]);
            findViewById2.setVisibility(0);
        }
        if (pVar.p[2] != null) {
            View findViewById3 = a2.findViewById(R.id.utvRightIconView);
            ViewCompat.setBackground(findViewById3, pVar.p[2]);
            findViewById3.setVisibility(0);
        }
        if (pVar.p[3] != null) {
            View findViewById4 = a2.findViewById(R.id.utvBottomIconView);
            ViewCompat.setBackground(findViewById4, pVar.p[3]);
            findViewById4.setVisibility(0);
        }
        return a2;
    }

    static /* synthetic */ c a(p pVar) {
        if (!pVar.q && NotificationManagerCompat.from(q.a()).areNotificationsEnabled()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new e(pVar);
            }
            if (!Settings.canDrawOverlays(q.a())) {
                return new e(pVar);
            }
        }
        return Build.VERSION.SDK_INT < 25 ? new f(pVar, 2005) : Settings.canDrawOverlays(q.a()) ? Build.VERSION.SDK_INT >= 26 ? new f(pVar, 2038) : new f(pVar, 2002) : new b(pVar);
    }

    @NonNull
    private p a(@ColorInt int i2) {
        this.k = i2;
        return this;
    }

    @NonNull
    private p a(int i2, int i3, int i4) {
        this.h = i2;
        this.i = i3;
        this.j = i4;
        return this;
    }

    @NonNull
    private p a(@Nullable Drawable drawable) {
        this.p[0] = drawable;
        return this;
    }

    @NonNull
    private p a(String str) {
        this.g = str;
        return this;
    }

    @NonNull
    private p a(boolean z) {
        this.o = z;
        return this;
    }

    public static void a() {
        o.a((Runnable) new Runnable() {
            public final void run() {
                if (p.f != null) {
                    c cVar = (c) p.f.get();
                    if (cVar != null) {
                        cVar.a();
                    }
                    WeakReference unused = p.f = null;
                }
            }
        });
    }

    private void a(@StringRes int i2, Object... objArr) {
        a((CharSequence) n.a(i2, objArr), f(), this);
    }

    private void a(@NonNull View view) {
        a(view, (CharSequence) null, f(), this);
    }

    private static void a(@NonNull View view, int i2, p pVar) {
        a(view, (CharSequence) null, i2, pVar);
    }

    private static void a(@Nullable final View view, @Nullable final CharSequence charSequence, final int i2, @NonNull p pVar) {
        o.a((Runnable) new Runnable(pVar) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ p f1754a;

            {
                this.f1754a = r1;
            }

            public final void run() {
                p.a();
                c a2 = p.a(this.f1754a);
                WeakReference unused = p.f = new WeakReference(a2);
                if (view != null) {
                    a2.a(view);
                } else {
                    a2.a(charSequence);
                }
                a2.b(i2);
            }
        });
    }

    public static void a(@Nullable CharSequence charSequence) {
        a(charSequence, 0, e);
    }

    private static void a(@Nullable CharSequence charSequence, int i2, p pVar) {
        if (charSequence == null) {
            charSequence = f1753c;
        } else if (charSequence.length() == 0) {
            charSequence = d;
        }
        a((View) null, charSequence, i2, pVar);
    }

    private void a(@Nullable String str, Object... objArr) {
        a((CharSequence) n.a(str, objArr), f(), this);
    }

    @NonNull
    private p b(@DrawableRes int i2) {
        this.l = i2;
        return this;
    }

    @NonNull
    private p b(@Nullable Drawable drawable) {
        this.p[1] = drawable;
        return this;
    }

    private static void b(@StringRes int i2, Object... objArr) {
        a((CharSequence) n.a(i2, objArr), 0, e);
    }

    public static void b(@Nullable CharSequence charSequence) {
        a(charSequence, 1, e);
    }

    private static void b(@Nullable String str, Object... objArr) {
        a((CharSequence) n.a(str, objArr), 0, e);
    }

    @NonNull
    private static p c() {
        return new p();
    }

    @NonNull
    private p c(@ColorInt int i2) {
        this.m = i2;
        return this;
    }

    @NonNull
    private p c(@Nullable Drawable drawable) {
        this.p[2] = drawable;
        return this;
    }

    private static void c(@StringRes int i2, Object... objArr) {
        a((CharSequence) n.a(i2, objArr), 1, e);
    }

    private void c(@Nullable CharSequence charSequence) {
        a(charSequence, f(), this);
    }

    private static void c(@Nullable String str, Object... objArr) {
        a((CharSequence) n.a(str, objArr), 1, e);
    }

    private View d(CharSequence charSequence) {
        if (!d.f1764b.equals(this.g) && !d.f1763a.equals(this.g) && this.p[0] == null && this.p[1] == null && this.p[2] == null && this.p[3] == null) {
            return null;
        }
        View a2 = s.a(R.layout.utils_toast_view);
        TextView textView = (TextView) a2.findViewById(16908299);
        if (d.f1764b.equals(this.g)) {
            ((GradientDrawable) a2.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.p[0] != null) {
            View findViewById = a2.findViewById(R.id.utvLeftIconView);
            ViewCompat.setBackground(findViewById, this.p[0]);
            findViewById.setVisibility(0);
        }
        if (this.p[1] != null) {
            View findViewById2 = a2.findViewById(R.id.utvTopIconView);
            ViewCompat.setBackground(findViewById2, this.p[1]);
            findViewById2.setVisibility(0);
        }
        if (this.p[2] != null) {
            View findViewById3 = a2.findViewById(R.id.utvRightIconView);
            ViewCompat.setBackground(findViewById3, this.p[2]);
            findViewById3.setVisibility(0);
        }
        if (this.p[3] != null) {
            View findViewById4 = a2.findViewById(R.id.utvBottomIconView);
            ViewCompat.setBackground(findViewById4, this.p[3]);
            findViewById4.setVisibility(0);
        }
        return a2;
    }

    @NonNull
    private p d() {
        this.q = true;
        return this;
    }

    @NonNull
    private p d(int i2) {
        this.n = i2;
        return this;
    }

    @NonNull
    private p d(@Nullable Drawable drawable) {
        this.p[3] = drawable;
        return this;
    }

    @NonNull
    private static p e() {
        return e;
    }

    @NonNull
    private p e(@DrawableRes int i2) {
        this.p[0] = ContextCompat.getDrawable(q.a(), i2);
        return this;
    }

    private static CharSequence e(CharSequence charSequence) {
        return charSequence == null ? f1753c : charSequence.length() == 0 ? d : charSequence;
    }

    private int f() {
        return this.o ? 1 : 0;
    }

    @NonNull
    private p f(@DrawableRes int i2) {
        this.p[1] = ContextCompat.getDrawable(q.a(), i2);
        return this;
    }

    @NonNull
    private p g(@DrawableRes int i2) {
        this.p[2] = ContextCompat.getDrawable(q.a(), i2);
        return this;
    }

    @NonNull
    private p h(int i2) {
        this.p[3] = ContextCompat.getDrawable(q.a(), i2);
        return this;
    }

    private static c i(p pVar) {
        if (!pVar.q && NotificationManagerCompat.from(q.a()).areNotificationsEnabled()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new e(pVar);
            }
            if (!Settings.canDrawOverlays(q.a())) {
                return new e(pVar);
            }
        }
        return Build.VERSION.SDK_INT < 25 ? new f(pVar, 2005) : Settings.canDrawOverlays(q.a()) ? Build.VERSION.SDK_INT >= 26 ? new f(pVar, 2038) : new f(pVar, 2002) : new b(pVar);
    }

    private void i(@StringRes int i2) {
        a((CharSequence) n.a(i2, (Object[]) null), f(), this);
    }

    private static void j(@StringRes int i2) {
        a((CharSequence) n.a(i2, (Object[]) null), 0, e);
    }

    private static void k(@StringRes int i2) {
        a((CharSequence) n.a(i2, (Object[]) null), 1, e);
    }
}
