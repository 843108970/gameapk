package com.cyjh.mobileanjian.ipc.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyjh.mobileanjian.ipc.view.ExToast;
import com.cyjh.mqsdk.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class k {
    private static final int d = 4096;
    private static final String e = "first_row_tag";
    private static final String f = "row_mark";
    private static final int v = 256;
    private static int x;

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f2656a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f2657b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2658c = false;
    private WindowManager g;
    private WindowManager.LayoutParams h;
    private ExToast i;
    private Context j;
    /* access modifiers changed from: private */
    public LinearLayout k;
    private String l = null;
    private Set<String> m = new HashSet();
    private Set<String> n = new HashSet();
    private HashMap<String, String> o = new HashMap<>();
    private HashMap<String, String> p = new HashMap<>();
    private g q;
    private LinearLayout r;
    private LinearLayout s;
    private TextView t;
    private ArrayList<SlidingTabLayout> u = new ArrayList<>();
    private Handler w = new Handler() {
        public final void handleMessage(Message message) {
            if (message.what == 256) {
                k.this.k.invalidate();
            }
        }
    };

    public k(Context context, String str, int i2, int i3) {
        WindowManager.LayoutParams layoutParams;
        int i4;
        this.j = context;
        this.q = g.a(context);
        this.g = (WindowManager) this.j.getSystemService("window");
        this.h = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.h;
            i4 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.h;
            i4 = 2002;
        } else {
            layoutParams = this.h;
            i4 = 2005;
        }
        layoutParams.type = i4;
        this.h.format = 1;
        this.h.gravity = 16;
        this.h.x = 0;
        this.h.y = 0;
        this.h.alpha = 1.0f;
        this.h.width = -1;
        this.h.height = -1;
        DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
        if (c(40) + i2 >= displayMetrics.widthPixels) {
            i2 = -1;
        } else if (i2 < -2 || (i2 >= 0 && i2 < c(200))) {
            i2 = c(200);
        }
        if (c(40) + i3 >= displayMetrics.heightPixels) {
            i3 = -2;
        } else if (i3 < -2 || (i3 >= 0 && i3 < c(200))) {
            i3 = c(200);
        }
        LayoutInflater from = LayoutInflater.from(this.j);
        this.s = (LinearLayout) from.inflate(R.layout.layout_ui_show, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.layout_display, (ViewGroup) null);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(i2, i3));
        this.s.setGravity(17);
        this.s.addView(linearLayout);
        this.t = (TextView) this.s.findViewById(R.id.title);
        this.k = (LinearLayout) this.s.findViewById(R.id.layout_user);
        this.s.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (k.this.f2656a != null) {
                    k.this.f2656a.onClick(view);
                }
            }
        });
        this.s.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (k.this.f2657b != null) {
                    k.this.f2657b.onClick(view);
                }
            }
        });
        this.l = str;
        a(str);
        a(f, str, -1, -2);
    }

    private void a(int i2, int i3) {
        DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
        if (c(40) + i2 >= displayMetrics.widthPixels) {
            i2 = -1;
        } else if (i2 < -2 || (i2 >= 0 && i2 < c(200))) {
            i2 = c(200);
        }
        if (c(40) + i3 >= displayMetrics.heightPixels) {
            i3 = -2;
        } else if (i3 < -2 || (i3 >= 0 && i3 < c(200))) {
            i3 = c(200);
        }
        LayoutInflater from = LayoutInflater.from(this.j);
        this.s = (LinearLayout) from.inflate(R.layout.layout_ui_show, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.layout_display, (ViewGroup) null);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(i2, i3));
        this.s.setGravity(17);
        this.s.addView(linearLayout);
        this.t = (TextView) this.s.findViewById(R.id.title);
        this.k = (LinearLayout) this.s.findViewById(R.id.layout_user);
        this.s.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (k.this.f2656a != null) {
                    k.this.f2656a.onClick(view);
                }
            }
        });
        this.s.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (k.this.f2657b != null) {
                    k.this.f2657b.onClick(view);
                }
            }
        });
    }

    private int c(int i2) {
        return (int) (((float) i2) * (((float) this.j.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    private void c(String str) {
        this.l = str;
        a(str);
    }

    private String f() {
        return this.l;
    }

    private void g() {
        WindowManager.LayoutParams layoutParams;
        int i2;
        this.g = (WindowManager) this.j.getSystemService("window");
        this.h = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.h;
            i2 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.h;
            i2 = 2002;
        } else {
            layoutParams = this.h;
            i2 = 2005;
        }
        layoutParams.type = i2;
        this.h.format = 1;
        this.h.gravity = 16;
        this.h.x = 0;
        this.h.y = 0;
        this.h.alpha = 1.0f;
        this.h.width = -1;
        this.h.height = -1;
    }

    private static String h() {
        StringBuilder sb = new StringBuilder("first_row_");
        int i2 = x;
        x = i2 + 1;
        sb.append(i2);
        return sb.toString();
    }

    public final String a() {
        return this.t.getText().toString();
    }

    public final void a(int i2) {
        this.t.setTextColor(i2);
    }

    public final void a(Typeface typeface, int i2) {
        this.t.setTypeface(typeface);
        this.t.setTextSize(2, (float) i2);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f2656a = onClickListener;
    }

    public final void a(View view, String str) {
        new StringBuilder("row tag: ").append(this.o.get(str));
        if (str.equals(this.l)) {
            this.r.addView(view);
        } else if (this.m.contains(str)) {
            ((l) ((SlidingTabLayout) this.k.findViewWithTag(this.p.get(str))).getViewPager().getAdapter()).a(view, str, this.o.get(str));
        }
    }

    public final void a(String str) {
        this.t.setText(str);
    }

    public final void a(String str, int i2) {
        this.n.add(str);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.j).inflate(R.layout.ui_show_sliding_layout, (ViewGroup) null);
        final SlidingTabLayout slidingTabLayout = (SlidingTabLayout) linearLayout.findViewById(R.id.slidingTabLayout);
        slidingTabLayout.setTag(str);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(this.j.getResources().getColor(R.color.ui_show_blue));
        slidingTabLayout.setBackgroundResource(R.drawable.bg_tab_host);
        slidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                slidingTabLayout.setFocusable(true);
                slidingTabLayout.setFocusableInTouchMode(true);
                slidingTabLayout.getViewPager().requestFocus();
            }
        });
        if (i2 == -2) {
            i2 = c(200);
        }
        ViewPager viewPager = (ViewPager) linearLayout.findViewById(R.id.viewPager);
        viewPager.setLayoutParams(new LinearLayout.LayoutParams(-1, i2));
        viewPager.setAdapter(new l(new ArrayList(), new ArrayList()));
        slidingTabLayout.setViewPager(viewPager);
        this.k.addView(linearLayout);
        this.u.add(slidingTabLayout);
    }

    public final void a(String str, String str2, int i2, int i3) {
        if (str2.equals(this.l)) {
            this.r = this.q.c(f, i2, i3);
            this.k.addView(this.r);
            this.o.put(str2, str);
        } else if (this.m.contains(str2)) {
            for (LinearLayout next : ((l) ((SlidingTabLayout) this.k.findViewWithTag(this.p.get(str2))).getViewPager().getAdapter()).f2664a) {
                if (next.getTag().equals(str2)) {
                    next.addView(g.a(next.getContext()).c(str, i2, i3));
                }
            }
            this.o.put(str2, str);
        }
    }

    public final boolean a(int i2, String str, String str2, String str3) {
        if (!this.n.contains(str2)) {
            return false;
        }
        StringBuilder sb = new StringBuilder("first_row_");
        int i3 = x;
        x = i3 + 1;
        sb.append(i3);
        String sb2 = sb.toString();
        this.m.add(str);
        this.o.put(str, sb2);
        this.p.put(str, str2);
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) this.k.findViewWithTag(str2);
        LinearLayout linearLayout = (LinearLayout) this.q.f2618a.inflate(R.layout.ui_show_tab_layout, (ViewGroup) null);
        linearLayout.setId(i2);
        linearLayout.setTag(str);
        linearLayout.setId(i2);
        this.r = this.q.c(sb2, -1, -2);
        linearLayout.addView(this.r);
        l lVar = (l) slidingTabLayout.f2594a.getAdapter();
        lVar.f2664a.add(linearLayout);
        lVar.f2665b.add(str3);
        lVar.notifyDataSetChanged();
        slidingTabLayout.f2594a.setAdapter(lVar);
        slidingTabLayout.setViewPager(slidingTabLayout.f2594a);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x002b A[LOOP:1: B:6:0x002b->B:9:0x003b, LOOP_START, PHI: r2 
      PHI: (r2v2 android.view.View) = (r2v1 android.view.View), (r2v6 android.view.View) binds: [B:5:0x0014, B:9:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View b(java.lang.String r5) {
        /*
            r4 = this;
            android.widget.LinearLayout r0 = r4.k
            android.view.View r0 = r0.findViewWithTag(r5)
            if (r0 != 0) goto L_0x0040
            java.util.ArrayList<com.cyjh.mobileanjian.ipc.ui.SlidingTabLayout> r1 = r4.u
            java.util.Iterator r1 = r1.iterator()
        L_0x000e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0040
            java.lang.Object r0 = r1.next()
            com.cyjh.mobileanjian.ipc.ui.SlidingTabLayout r0 = (com.cyjh.mobileanjian.ipc.ui.SlidingTabLayout) r0
            android.support.v4.view.ViewPager r0 = r0.getViewPager()
            android.support.v4.view.PagerAdapter r0 = r0.getAdapter()
            com.cyjh.mobileanjian.ipc.ui.l r0 = (com.cyjh.mobileanjian.ipc.ui.l) r0
            r2 = 0
            java.util.List<android.widget.LinearLayout> r0 = r0.f2664a
            java.util.Iterator r0 = r0.iterator()
        L_0x002b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x003d
            java.lang.Object r2 = r0.next()
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            android.view.View r2 = r2.findViewWithTag(r5)
            if (r2 == 0) goto L_0x002b
        L_0x003d:
            r0 = r2
            if (r0 == 0) goto L_0x000e
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.ui.k.b(java.lang.String):android.view.View");
    }

    public final void b() {
        this.w.sendEmptyMessageDelayed(256, 10);
    }

    public final void b(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(new float[]{(float) c(4), (float) c(4), (float) c(4), (float) c(4), 0.0f, 0.0f, 0.0f, 0.0f});
        this.t.setBackground(gradientDrawable);
    }

    public final void b(View.OnClickListener onClickListener) {
        this.f2657b = onClickListener;
    }

    public final void c() {
        this.f2658c = true;
        this.g.addView(this.s, this.h);
    }

    public final boolean d() {
        return this.f2658c;
    }

    public final void e() {
        this.f2658c = false;
        this.g.removeView(this.s);
    }
}
