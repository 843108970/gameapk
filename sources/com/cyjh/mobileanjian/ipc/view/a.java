package com.cyjh.mobileanjian.ipc.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2729a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2730b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2731c = 4;
    private Toast d;
    private Context e;
    private boolean f = false;
    private int g = -1;
    private int h = 2;
    private final int i;
    private final int j;
    private final int k;
    private int l;
    private int m;
    private Object n;
    private Method o;
    private Method p;
    private WindowManager q;
    private WindowManager.LayoutParams r;
    private WindowManager.LayoutParams s = null;
    private View t;
    private Handler u = new Handler();
    private Timer v = new Timer("hideTimer");
    private C0044a w = new C0044a(this, (byte) 0);
    private Runnable x = new Runnable() {
        public final void run() {
            a.this.a();
        }
    };

    /* renamed from: com.cyjh.mobileanjian.ipc.view.a$a  reason: collision with other inner class name */
    private class C0044a extends TimerTask {
        private C0044a() {
        }

        /* synthetic */ C0044a(a aVar, byte b2) {
            this();
        }

        public final void run() {
            a.this.a();
        }
    }

    private a(Context context) {
        this.e = context;
        Toast toast = new Toast(context);
        this.i = toast.getGravity();
        this.j = toast.getXOffset();
        this.k = toast.getYOffset();
        this.l = this.j;
        this.m = this.k;
    }

    private static a a(Context context, int i2, int i3) {
        Toast makeText = Toast.makeText(context, i2, i3);
        a aVar = new a(context);
        aVar.d = makeText;
        aVar.h = i3;
        return aVar;
    }

    private static a a(Context context, CharSequence charSequence, int i2) {
        Toast makeText = Toast.makeText(context, charSequence, i2);
        a aVar = new a(context);
        aVar.d = makeText;
        aVar.h = i2;
        return aVar;
    }

    private void a(int i2) {
        this.h = i2;
    }

    private void a(int i2, int i3, int i4) {
        this.d.setGravity(i2, i3, i4);
    }

    private void a(View view) {
        this.d.setView(view);
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        try {
            Field declaredField = this.d.getClass().getDeclaredField("mTN");
            declaredField.setAccessible(true);
            this.n = declaredField.get(this.d);
            Field declaredField2 = this.n.getClass().getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            declaredField2.set(this.n, layoutParams);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    private void a(CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    private void a(CharSequence charSequence, int i2, int i3) {
        Toast.makeText(this.e, charSequence, 0).show();
        boolean z = (i2 < 0 && this.l < 0) || (i3 < 0 && this.m < 0) || (i2 == this.l && i3 == this.m);
        boolean z2 = i2 < 0 || i3 < 0;
        this.l = i2;
        this.m = i3;
        if (z) {
            a(charSequence);
        } else {
            a();
            this.d = Toast.makeText(this.e, charSequence, 0);
            if (z2) {
                this.d.setGravity(this.i, this.j, this.k);
            } else {
                this.d.setGravity(51, i2, i3);
            }
        }
        try {
            if (this.f) {
                this.w.cancel();
                this.w = new C0044a(this, (byte) 0);
                this.v.schedule(this.w, (long) (this.h * 1000));
                return;
            }
            try {
                Field declaredField = this.d.getClass().getDeclaredField("mTN");
                declaredField.setAccessible(true);
                this.n = declaredField.get(this.d);
                this.o = this.n.getClass().getMethod("show", new Class[0]);
                this.p = this.n.getClass().getMethod("hide", new Class[0]);
                Field declaredField2 = this.n.getClass().getDeclaredField("mParams");
                declaredField2.setAccessible(true);
                this.r = (WindowManager.LayoutParams) declaredField2.get(this.n);
                if (this.s != null) {
                    this.r.flags = this.s.flags;
                    this.r.width = this.s.width;
                    this.r.height = this.s.height;
                    this.r.gravity = this.s.gravity;
                    this.r.windowAnimations = this.s.windowAnimations;
                }
                if (this.g != -1) {
                    this.r.windowAnimations = this.g;
                }
                Field declaredField3 = this.n.getClass().getDeclaredField("mNextView");
                declaredField3.setAccessible(true);
                declaredField3.set(this.n, this.d.getView());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.o.invoke(this.n, new Object[0]);
            this.f = true;
            if (this.h > 0) {
                this.w.cancel();
                this.w = new C0044a(this, (byte) 0);
                this.v.schedule(this.w, (long) (this.h * 1000));
            }
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (IllegalStateException e5) {
            e5.printStackTrace();
            a();
            this.v.cancel();
            this.v = new Timer();
        }
    }

    private void b() {
        try {
            if (this.f) {
                this.w.cancel();
                this.w = new C0044a(this, (byte) 0);
                this.v.schedule(this.w, (long) (this.h * 1000));
                return;
            }
            try {
                Field declaredField = this.d.getClass().getDeclaredField("mTN");
                declaredField.setAccessible(true);
                this.n = declaredField.get(this.d);
                this.o = this.n.getClass().getMethod("show", new Class[0]);
                this.p = this.n.getClass().getMethod("hide", new Class[0]);
                Field declaredField2 = this.n.getClass().getDeclaredField("mParams");
                declaredField2.setAccessible(true);
                this.r = (WindowManager.LayoutParams) declaredField2.get(this.n);
                if (this.s != null) {
                    this.r.flags = this.s.flags;
                    this.r.width = this.s.width;
                    this.r.height = this.s.height;
                    this.r.gravity = this.s.gravity;
                    this.r.windowAnimations = this.s.windowAnimations;
                }
                if (this.g != -1) {
                    this.r.windowAnimations = this.g;
                }
                Field declaredField3 = this.n.getClass().getDeclaredField("mNextView");
                declaredField3.setAccessible(true);
                declaredField3.set(this.n, this.d.getView());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.o.invoke(this.n, new Object[0]);
            this.f = true;
            if (this.h > 0) {
                this.w.cancel();
                this.w = new C0044a(this, (byte) 0);
                this.v.schedule(this.w, (long) (this.h * 1000));
            }
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (IllegalStateException e5) {
            e5.printStackTrace();
            a();
            this.v.cancel();
            this.v = new Timer();
        }
    }

    private void b(int i2) {
        a(this.e.getText(i2));
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        this.s = layoutParams;
    }

    private View c() {
        return this.d.getView();
    }

    private void c(int i2) {
        this.g = i2;
    }

    private int d() {
        return this.g;
    }

    private void e() {
        try {
            Field declaredField = this.d.getClass().getDeclaredField("mTN");
            declaredField.setAccessible(true);
            this.n = declaredField.get(this.d);
            this.o = this.n.getClass().getMethod("show", new Class[0]);
            this.p = this.n.getClass().getMethod("hide", new Class[0]);
            Field declaredField2 = this.n.getClass().getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            this.r = (WindowManager.LayoutParams) declaredField2.get(this.n);
            if (this.s != null) {
                this.r.flags = this.s.flags;
                this.r.width = this.s.width;
                this.r.height = this.s.height;
                this.r.gravity = this.s.gravity;
                this.r.windowAnimations = this.s.windowAnimations;
            }
            if (this.g != -1) {
                this.r.windowAnimations = this.g;
            }
            Field declaredField3 = this.n.getClass().getDeclaredField("mNextView");
            declaredField3.setAccessible(true);
            declaredField3.set(this.n, this.d.getView());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        if (this.f) {
            try {
                this.p.invoke(this.n, new Object[0]);
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
            this.f = false;
        }
    }
}
