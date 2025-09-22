package com.cyjh.elfin.ui.activity.studio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.ag;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.cyjh.http.bean.response.ProjectNumberInfo;
import com.cyjh.http.c.c.h;
import com.elf.studio.a.b;
import com.ywfzjbcy.R;

public class StudioBindClearActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static String f2231b = "StudioBindClearActivity";

    /* renamed from: c  reason: collision with root package name */
    public static String f2232c = "studio_project_key";
    private TextView d;
    private TextView e;
    private TextView f;
    /* access modifiers changed from: private */
    public boolean g = true;
    /* access modifiers changed from: private */
    public Handler h = new Handler();
    private String i;
    private FrameLayout j;
    private TitleView k;

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, StudioBindClearActivity.class);
        intent.putExtra(f2232c, str);
        context.startActivity(intent);
    }

    private void b() {
        this.k = (TitleView) findViewById(R.id.titleView);
        this.k.setVisibilityTvRight(0);
        this.d = (TextView) findViewById(R.id.tv_studio_bind_code);
        this.e = (TextView) findViewById(R.id.tv_studio_unbind);
        this.f = (TextView) findViewById(R.id.tv_studio_change);
    }

    private static void b(Context context, String str) {
        Intent intent = new Intent(context, StudioBindClearActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(f2232c, str);
        context.startActivity(intent);
    }

    private void c() {
        this.k.setTitleText((int) R.string.already_bind_project_number);
        this.k.setVisibilityLeftImage(0);
        this.k.setleftImage(R.drawable.ic_back);
        this.k.setOnLeftImageViewListener(new b(this));
        this.k.setVisibilityRightImage(4);
    }

    private void d() {
        this.d.setText(this.i);
    }

    private void e() {
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    private void f() {
        if (this.g) {
            this.g = false;
            Script script = c.f().f2011a;
            if (script != null) {
                h.a().a(this, script.getId(), new h.a() {
                    private /* synthetic */ void a() {
                        ag.a(StudioBindClearActivity.this.getApplicationContext(), "解绑成功！");
                    }

                    public final void a(ProjectNumberInfo projectNumberInfo) {
                        boolean unused = StudioBindClearActivity.this.g = true;
                        AppContext.a().e = null;
                        org.greenrobot.eventbus.c.a().c((Object) new b((byte) 0));
                        StudioBindClearActivity.this.finish();
                        StudioBindClearActivity.this.h.post(new c(this));
                    }

                    public final void a(String str) {
                        boolean unused = StudioBindClearActivity.this.g = true;
                        ag.a(StudioBindClearActivity.this.getApplicationContext(), (int) R.string.unbind_project_failure);
                    }
                });
            } else {
                ag.a(getApplicationContext(), (int) R.string.unbind_project_failure);
            }
        }
    }

    private /* synthetic */ void g() {
        finish();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_studio_unbind /*2131755269*/:
                if (this.g) {
                    this.g = false;
                    Script script = c.f().f2011a;
                    if (script != null) {
                        h.a().a(this, script.getId(), new h.a() {
                            private /* synthetic */ void a() {
                                ag.a(StudioBindClearActivity.this.getApplicationContext(), "解绑成功！");
                            }

                            public final void a(ProjectNumberInfo projectNumberInfo) {
                                boolean unused = StudioBindClearActivity.this.g = true;
                                AppContext.a().e = null;
                                org.greenrobot.eventbus.c.a().c((Object) new b((byte) 0));
                                StudioBindClearActivity.this.finish();
                                StudioBindClearActivity.this.h.post(new c(this));
                            }

                            public final void a(String str) {
                                boolean unused = StudioBindClearActivity.this.g = true;
                                ag.a(StudioBindClearActivity.this.getApplicationContext(), (int) R.string.unbind_project_failure);
                            }
                        });
                        return;
                    } else {
                        ag.a(getApplicationContext(), (int) R.string.unbind_project_failure);
                        return;
                    }
                } else {
                    return;
                }
            case R.id.tv_studio_change /*2131755270*/:
                StudioBindActivity.b((Context) this);
                finish();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_studio_bind_clear);
        this.i = getIntent().getStringExtra(f2232c);
        this.k = (TitleView) findViewById(R.id.titleView);
        this.k.setVisibilityTvRight(0);
        this.d = (TextView) findViewById(R.id.tv_studio_bind_code);
        this.e = (TextView) findViewById(R.id.tv_studio_unbind);
        this.f = (TextView) findViewById(R.id.tv_studio_change);
        this.k.setTitleText((int) R.string.already_bind_project_number);
        this.k.setVisibilityLeftImage(0);
        this.k.setleftImage(R.drawable.ic_back);
        this.k.setOnLeftImageViewListener(new b(this));
        this.k.setVisibilityRightImage(4);
        this.d.setText(this.i);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
