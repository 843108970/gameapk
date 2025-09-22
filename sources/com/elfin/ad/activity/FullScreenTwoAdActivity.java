package com.elfin.ad.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.request.g;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ae;
import com.cyjh.common.util.f;
import com.cyjh.common.util.q;
import com.cyjh.http.c.c.c;
import com.elfin.ad.R;
import com.iflytek.voiceads.IFLYNativeAd;
import com.iflytek.voiceads.config.AdError;
import com.iflytek.voiceads.config.AdKeys;
import com.iflytek.voiceads.conn.NativeDataRef;
import com.umeng.analytics.MobclickAgent;
import java.lang.ref.WeakReference;

public class FullScreenTwoAdActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final int f2835b = 8;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2836c = 200;
    public static final int d = 1000;
    public static final int e = 3;
    public static final int f = 1001;
    public static final int g = 1002;
    public static final int h = 1003;
    /* access modifiers changed from: private */
    public static final String i = "FullScreenTwoAdActivity";
    private static final int q = 5;
    private static final int u = 100;
    private static final int v = 101;
    private static final int w = 102;
    private static final int x = 103;
    private ImageView j;
    private TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    /* access modifiers changed from: private */
    public NativeDataRef m;
    private int n = 0;
    private int o = 0;
    private b p;
    /* access modifiers changed from: private */
    public boolean r = false;
    /* access modifiers changed from: private */
    public a s = new a(this, (byte) 0);
    private boolean t = false;
    private int y = 100;
    private com.elfin.ad.d.a z = new com.elfin.ad.d.a() {
        public final void onAdFailed(AdError adError) {
            String b2 = FullScreenTwoAdActivity.i;
            ad.c(b2, "IFLYADListener --> adError message=" + adError.getMessage());
            FullScreenTwoAdActivity fullScreenTwoAdActivity = FullScreenTwoAdActivity.this;
            ae.a((Context) fullScreenTwoAdActivity, "讯飞广告加载失败 message=" + adError.getMessage());
            FullScreenTwoAdActivity.this.s.obtainMessage(1002).sendToTarget();
        }

        public final void onAdLoaded(NativeDataRef nativeDataRef) {
            ae.a((Context) FullScreenTwoAdActivity.this, "讯飞广告加载成功");
            NativeDataRef unused = FullScreenTwoAdActivity.this.m = nativeDataRef;
            FullScreenTwoAdActivity.this.a(FullScreenTwoAdActivity.this.m.getImgUrl());
        }
    };

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<FullScreenTwoAdActivity> f2841a;

        private a(FullScreenTwoAdActivity fullScreenTwoAdActivity) {
            this.f2841a = new WeakReference<>(fullScreenTwoAdActivity);
        }

        /* synthetic */ a(FullScreenTwoAdActivity fullScreenTwoAdActivity, byte b2) {
            this(fullScreenTwoAdActivity);
        }

        public final void handleMessage(Message message) {
            FullScreenTwoAdActivity fullScreenTwoAdActivity = (FullScreenTwoAdActivity) this.f2841a.get();
            if (fullScreenTwoAdActivity != null) {
                switch (message.what) {
                    case 1001:
                        c.a().a((Context) fullScreenTwoAdActivity, 2, 2, 2);
                        return;
                    case 1002:
                        FullScreenTwoAdActivity.b(fullScreenTwoAdActivity);
                        return;
                    case 1003:
                        c.a().a((Context) fullScreenTwoAdActivity, 1, 2, com.elfin.ad.e.a.a().f2863b.Id);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private class b extends com.cyjh.common.c.a {
        private b(int i) {
            super(i);
        }

        /* synthetic */ b(FullScreenTwoAdActivity fullScreenTwoAdActivity, int i, byte b2) {
            this(i);
        }

        /* access modifiers changed from: protected */
        public final void a(int i) {
            FullScreenTwoAdActivity.c(FullScreenTwoAdActivity.this);
            if (FullScreenTwoAdActivity.this.r) {
                FullScreenTwoAdActivity.this.l.setText(FullScreenTwoAdActivity.this.getString(R.string.countdown_time, new Object[]{Integer.valueOf(i)}));
                FullScreenTwoAdActivity.this.l.setVisibility(0);
            }
        }

        public final void onFinish() {
            FullScreenTwoAdActivity.this.n();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (str.endsWith(".gif")) {
            g a2 = q.a();
            a2.b(i.f1144c);
            q.a((Context) this, str, this.j, a2);
        } else {
            g a3 = q.a();
            a3.b(i.f1143b);
            q.b(this, str, this.j, a3);
        }
        if (this.m != null) {
            this.m.onExposure(this.j);
            if (!TextUtils.isEmpty(this.m.getAdSourceMark())) {
                this.k.setText(String.format(getString(R.string.ad_source_mark), new Object[]{this.m.getAdSourceMark()}));
                this.k.setVisibility(0);
            }
            this.n = this.m.getActionType();
        }
        this.r = true;
        m();
        if (this.p == null) {
            this.p = new b(this, 5, (byte) 0);
        }
        this.p.start();
        this.j.setOnClickListener(this);
        if (this.y == 100 && this.m != null) {
            this.s.obtainMessage(1001).sendToTarget();
        } else if (this.y == 102) {
            this.s.obtainMessage(1003).sendToTarget();
        }
    }

    static /* synthetic */ void b(FullScreenTwoAdActivity fullScreenTwoAdActivity) {
        if (com.elfin.ad.e.a.a().a(2)) {
            fullScreenTwoAdActivity.p = new b(fullScreenTwoAdActivity, 8, (byte) 0);
            fullScreenTwoAdActivity.p.start();
            String str = com.elfin.ad.e.a.a().f2863b.ImageUrl;
            if (!TextUtils.isEmpty(str)) {
                ae.a((Context) fullScreenTwoAdActivity, "后台广告加载成功");
                fullScreenTwoAdActivity.y = 102;
                fullScreenTwoAdActivity.a(str);
                return;
            }
            fullScreenTwoAdActivity.n();
            return;
        }
        fullScreenTwoAdActivity.n();
    }

    static /* synthetic */ int c(FullScreenTwoAdActivity fullScreenTwoAdActivity) {
        int i2 = fullScreenTwoAdActivity.o;
        fullScreenTwoAdActivity.o = i2 + 1;
        return i2;
    }

    private void c() {
        this.l.setOnClickListener(this);
    }

    private void d() {
        this.j = (ImageView) findViewById(R.id.iv_splash_ad_fullscreen);
        this.k = (TextView) findViewById(R.id.tv_splash_ad_mark);
        this.l = (TextView) findViewById(R.id.tv_close_ad);
    }

    private void e() {
        boolean a2 = f.a((Context) this);
        String a3 = f.a();
        boolean z2 = true;
        boolean z3 = a3.contains("intel") || a3.contains("amd");
        if (a2 && !z3) {
            z2 = false;
        }
        if (z2) {
            this.s.obtainMessage(1002).sendToTarget();
            return;
        }
        com.elfin.ad.b.b a4 = com.elfin.ad.e.a.a().a(2, com.elfin.ad.d.a.g);
        String str = i;
        ad.c(str, "loadIFLYAd --> ilfyAd.isDisplay=" + a4.f2849a);
        if (a4.f2849a) {
            IFLYNativeAd iFLYNativeAd = new IFLYNativeAd(this, a4.f2850b, this.z);
            iFLYNativeAd.setParameter(AdKeys.APP_VER, com.cyjh.common.util.a.c(this));
            iFLYNativeAd.loadAd();
            return;
        }
        this.s.obtainMessage(1002).sendToTarget();
    }

    private void f() {
        boolean a2 = f.a((Context) this);
        String a3 = f.a();
        boolean z2 = true;
        boolean z3 = a3.contains("intel") || a3.contains("amd");
        if (a2 && !z3) {
            z2 = false;
        }
        if (z2) {
            this.s.obtainMessage(1002).sendToTarget();
            return;
        }
        com.elfin.ad.b.b a4 = com.elfin.ad.e.a.a().a(2, com.elfin.ad.d.a.g);
        String str = i;
        ad.c(str, "loadIFLYAd --> ilfyAd.isDisplay=" + a4.f2849a);
        if (a4.f2849a) {
            IFLYNativeAd iFLYNativeAd = new IFLYNativeAd(this, a4.f2850b, this.z);
            iFLYNativeAd.setParameter(AdKeys.APP_VER, com.cyjh.common.util.a.c(this));
            iFLYNativeAd.loadAd();
            return;
        }
        this.s.obtainMessage(1002).sendToTarget();
    }

    private void g() {
        com.elfin.ad.b.b a2 = com.elfin.ad.e.a.a().a(2, com.elfin.ad.d.a.g);
        String str = i;
        ad.c(str, "loadIFLYAd --> ilfyAd.isDisplay=" + a2.f2849a);
        if (a2.f2849a) {
            IFLYNativeAd iFLYNativeAd = new IFLYNativeAd(this, a2.f2850b, this.z);
            iFLYNativeAd.setParameter(AdKeys.APP_VER, com.cyjh.common.util.a.c(this));
            iFLYNativeAd.loadAd();
            return;
        }
        this.s.obtainMessage(1002).sendToTarget();
    }

    private void h() {
        this.y = 102;
    }

    private void i() {
        m();
        if (this.m != null) {
            this.t = this.m.onClick(this.j);
            if (this.n == 3) {
                this.s.postDelayed(new Runnable() {
                    public final void run() {
                        FullScreenTwoAdActivity.this.n();
                    }
                }, 1000);
                return;
            }
            return;
        }
        this.t = true;
        c a2 = c.a();
        a2.f2486b = new c.a() {
            public final void a() {
                c.a().d();
                com.elfin.ad.e.a.a().a((Context) FullScreenTwoAdActivity.this);
            }
        };
        a2.a((Context) this, 1, 3, com.elfin.ad.e.a.a().f2863b.Id);
    }

    private void j() {
        if (com.elfin.ad.e.a.a().a(2)) {
            this.p = new b(this, 8, (byte) 0);
            this.p.start();
            String str = com.elfin.ad.e.a.a().f2863b.ImageUrl;
            if (!TextUtils.isEmpty(str)) {
                ae.a((Context) this, "后台广告加载成功");
                this.y = 102;
                a(str);
                return;
            }
            n();
            return;
        }
        n();
    }

    private void k() {
        if (this.m != null) {
            this.m.onExposure(this.j);
            if (!TextUtils.isEmpty(this.m.getAdSourceMark())) {
                this.k.setText(String.format(getString(R.string.ad_source_mark), new Object[]{this.m.getAdSourceMark()}));
                this.k.setVisibility(0);
            }
            this.n = this.m.getActionType();
        }
        this.r = true;
        m();
        if (this.p == null) {
            this.p = new b(this, 5, (byte) 0);
        }
        this.p.start();
        this.j.setOnClickListener(this);
        if (this.y == 100 && this.m != null) {
            this.s.obtainMessage(1001).sendToTarget();
        } else if (this.y == 102) {
            this.s.obtainMessage(1003).sendToTarget();
        }
    }

    private void l() {
        if (this.p == null) {
            this.p = new b(this, 5, (byte) 0);
        }
        this.p.start();
    }

    private void m() {
        if (this.p != null) {
            this.p.cancel();
            this.o = 0;
            this.p = null;
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        try {
            Intent intent = new Intent(this, Class.forName("com.cyjh.elfin.ui.activity.ElfinFreeActivity"));
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        finish();
    }

    private void o() {
        this.t = this.m.onClick(this.j);
        if (this.n == 3) {
            this.s.postDelayed(new Runnable() {
                public final void run() {
                    FullScreenTwoAdActivity.this.n();
                }
            }, 1000);
        }
    }

    private void p() {
        this.t = true;
        c a2 = c.a();
        a2.f2486b = new c.a() {
            public final void a() {
                c.a().d();
                com.elfin.ad.e.a.a().a((Context) FullScreenTwoAdActivity.this);
            }
        };
        a2.a((Context) this, 1, 3, com.elfin.ad.e.a.a().f2863b.Id);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_close_ad) {
            if (this.o < 3) {
                i();
            } else {
                n();
            }
        } else if (id == R.id.iv_splash_ad_fullscreen) {
            i();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z2 = true;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_fullscreen_ad_two);
        this.j = (ImageView) findViewById(R.id.iv_splash_ad_fullscreen);
        this.k = (TextView) findViewById(R.id.tv_splash_ad_mark);
        this.l = (TextView) findViewById(R.id.tv_close_ad);
        boolean a2 = f.a((Context) this);
        String a3 = f.a();
        boolean z3 = a3.contains("intel") || a3.contains("amd");
        if (a2 && !z3) {
            z2 = false;
        }
        if (!z2) {
            com.elfin.ad.b.b a4 = com.elfin.ad.e.a.a().a(2, com.elfin.ad.d.a.g);
            String str = i;
            ad.c(str, "loadIFLYAd --> ilfyAd.isDisplay=" + a4.f2849a);
            if (a4.f2849a) {
                IFLYNativeAd iFLYNativeAd = new IFLYNativeAd(this, a4.f2850b, this.z);
                iFLYNativeAd.setParameter(AdKeys.APP_VER, com.cyjh.common.util.a.c(this));
                iFLYNativeAd.loadAd();
                this.l.setOnClickListener(this);
            }
        }
        this.s.obtainMessage(1002).sendToTarget();
        this.l.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m();
        this.s.removeCallbacksAndMessages((Object) null);
        this.r = false;
        this.t = false;
        this.m = null;
        c.a().b();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return i2 == 4;
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        if (this.t) {
            this.s.postDelayed(new Runnable() {
                public final void run() {
                    FullScreenTwoAdActivity.this.n();
                }
            }, 200);
        }
    }
}
