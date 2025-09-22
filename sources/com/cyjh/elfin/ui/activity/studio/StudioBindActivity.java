package com.cyjh.elfin.ui.activity.studio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.ab;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.u;
import com.cyjh.elfin.a.a;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.o;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.cyjh.http.bean.response.ProjectNumberInfo;
import com.cyjh.http.c.c.h;
import com.elf.studio.a.b;
import com.ywfzjbcy.R;

public class StudioBindActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static String f2223b = "StudioBindActivity";

    /* renamed from: c  reason: collision with root package name */
    private Handler f2224c = new Handler();
    private FrameLayout d;
    private TextView e;
    private EditText f;
    /* access modifiers changed from: private */
    public TitleView g;
    private String h;
    /* access modifiers changed from: private */
    public String i;
    private String j;
    private String k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public boolean m = true;
    /* access modifiers changed from: private */
    public boolean n;

    public static void a(Context context) {
        context.startActivity(new Intent(context, StudioBindActivity.class));
    }

    private void b() {
        this.g = (TitleView) findViewById(R.id.titleView);
        this.g.setVisibilityTvRight(0);
        this.e = (TextView) findViewById(R.id.tv_studio_bind);
        this.f = (EditText) findViewById(R.id.et_studio_project_key);
    }

    public static void b(Context context) {
        Intent intent = new Intent(context, StudioBindActivity.class);
        intent.putExtra("is_change", true);
        context.startActivity(intent);
    }

    private void c() {
        this.g.setTitleText((int) R.string.already_bind_project_number);
        this.g.setVisibilityLeftImage(0);
        this.g.setleftImage(R.drawable.ic_back);
        this.g.setOnLeftImageViewListener(new a(this));
        this.g.setVisibilityRightImage(4);
    }

    private static void c(Context context) {
        Intent intent = new Intent(context, StudioBindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void d() {
        this.n = getIntent().getBooleanExtra("is_change", false);
        String str = f2223b;
        ad.c(str, "studioProjectNumber:" + AppContext.a().e);
        Script script = c.f().f2011a;
        if (script != null) {
            try {
                org.greenrobot.eventbus.c.a().c((Object) new MsgItem(MsgItem.SCRIPT_UI_SAVE_CFG));
                this.h = script.getId();
                this.i = AppContext.a().e;
                this.j = o.b(this, c.f().f2012c);
                this.k = o.a(this, c.f().f2012c);
                this.l = o.b(this);
                String str2 = f2223b;
                ad.c(str2, "initData --> scriptUIPContent=" + this.k + ",mScriptCFGContent=" + this.l);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void e() {
        this.e.setOnClickListener(this);
    }

    private void f() {
        this.i = this.f.getText().toString().trim();
        if (TextUtils.isEmpty(this.i)) {
            ag.a(getApplicationContext(), (int) R.string.project_number_number_can_not_empty);
        } else if (this.m) {
            this.m = false;
            String str = f2223b;
            ad.c(str, "bindStudioProject --> scriptCFGContent=" + this.l + ",scriptUIPContent=" + this.k);
            if (!TextUtils.isEmpty(this.h)) {
                h.a().a(this, this.i, this.h, this.j, this.k, this.l, new h.a() {
                    public final void a(final ProjectNumberInfo projectNumberInfo) {
                        boolean unused = StudioBindActivity.this.m = true;
                        StudioBindActivity.this.g.post(new Runnable() {
                            public final void run() {
                                ag.a(StudioBindActivity.this.getApplicationContext(), "绑定成功！");
                            }
                        });
                        AppContext.a().e = StudioBindActivity.this.i;
                        h.a().f2497b = null;
                        ab.a().a(a.H, u.a(StudioBindActivity.this.l));
                        String str = projectNumberInfo.IMServerHost;
                        int i = projectNumberInfo.IMServerPort;
                        if (StudioBindActivity.this.n) {
                            StudioBindActivity.this.g.postDelayed(new Runnable() {
                                public final void run() {
                                    org.greenrobot.eventbus.c.a().c((Object) new b(10002, projectNumberInfo.IMToken));
                                }
                            }, 500);
                        } else {
                            org.greenrobot.eventbus.c.a().c((Object) new b(10001, projectNumberInfo.IMToken));
                        }
                        StudioBindActivity.this.finish();
                    }

                    public final void a(final String str) {
                        h.a().f2497b = null;
                        boolean unused = StudioBindActivity.this.m = true;
                        StudioBindActivity.this.g.post(new Runnable() {
                            public final void run() {
                                ag.a((Context) StudioBindActivity.this, str);
                            }
                        });
                    }
                });
            }
        }
    }

    private /* synthetic */ void g() {
        finish();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_studio_bind) {
            this.i = this.f.getText().toString().trim();
            if (TextUtils.isEmpty(this.i)) {
                ag.a(getApplicationContext(), (int) R.string.project_number_number_can_not_empty);
            } else if (this.m) {
                this.m = false;
                String str = f2223b;
                ad.c(str, "bindStudioProject --> scriptCFGContent=" + this.l + ",scriptUIPContent=" + this.k);
                if (!TextUtils.isEmpty(this.h)) {
                    h.a().a(this, this.i, this.h, this.j, this.k, this.l, new h.a() {
                        public final void a(final ProjectNumberInfo projectNumberInfo) {
                            boolean unused = StudioBindActivity.this.m = true;
                            StudioBindActivity.this.g.post(new Runnable() {
                                public final void run() {
                                    ag.a(StudioBindActivity.this.getApplicationContext(), "绑定成功！");
                                }
                            });
                            AppContext.a().e = StudioBindActivity.this.i;
                            h.a().f2497b = null;
                            ab.a().a(a.H, u.a(StudioBindActivity.this.l));
                            String str = projectNumberInfo.IMServerHost;
                            int i = projectNumberInfo.IMServerPort;
                            if (StudioBindActivity.this.n) {
                                StudioBindActivity.this.g.postDelayed(new Runnable() {
                                    public final void run() {
                                        org.greenrobot.eventbus.c.a().c((Object) new b(10002, projectNumberInfo.IMToken));
                                    }
                                }, 500);
                            } else {
                                org.greenrobot.eventbus.c.a().c((Object) new b(10001, projectNumberInfo.IMToken));
                            }
                            StudioBindActivity.this.finish();
                        }

                        public final void a(final String str) {
                            h.a().f2497b = null;
                            boolean unused = StudioBindActivity.this.m = true;
                            StudioBindActivity.this.g.post(new Runnable() {
                                public final void run() {
                                    ag.a((Context) StudioBindActivity.this, str);
                                }
                            });
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_studio_bind);
        this.g = (TitleView) findViewById(R.id.titleView);
        this.g.setVisibilityTvRight(0);
        this.e = (TextView) findViewById(R.id.tv_studio_bind);
        this.f = (EditText) findViewById(R.id.et_studio_project_key);
        this.g.setTitleText((int) R.string.already_bind_project_number);
        this.g.setVisibilityLeftImage(0);
        this.g.setleftImage(R.drawable.ic_back);
        this.g.setOnLeftImageViewListener(new a(this));
        this.g.setVisibilityRightImage(4);
        this.n = getIntent().getBooleanExtra("is_change", false);
        String str = f2223b;
        ad.c(str, "studioProjectNumber:" + AppContext.a().e);
        Script script = c.f().f2011a;
        if (script != null) {
            try {
                org.greenrobot.eventbus.c.a().c((Object) new MsgItem(MsgItem.SCRIPT_UI_SAVE_CFG));
                this.h = script.getId();
                this.i = AppContext.a().e;
                this.j = o.b(this, c.f().f2012c);
                this.k = o.a(this, c.f().f2012c);
                this.l = o.b(this);
                String str2 = f2223b;
                ad.c(str2, "initData --> scriptUIPContent=" + this.k + ",mScriptCFGContent=" + this.l);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.e.setOnClickListener(this);
    }
}
