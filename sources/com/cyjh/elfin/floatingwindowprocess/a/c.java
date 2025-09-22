package com.cyjh.elfin.floatingwindowprocess.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.floatingwindowprocess.c.b;
import com.cyjh.elfin.ui.a.a;
import com.cyjh.mobileanjian.ipc.uip.UisScriptRunner;
import com.elfin.engin.d;
import com.ywfzjbcy.R;
import java.io.File;

public final class c extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f1984a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f1985b;

    /* renamed from: c  reason: collision with root package name */
    private Button f1986c;
    private ScrollView e;
    private LinearLayout f;
    private com.elfin.engin.b.a.a g;

    public c(Context context) {
        super(context);
        Window window;
        int i;
        Script script = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a;
        if (!(script == null || script.getLcFile() == null || !script.getLcFile().exists())) {
            d.a(script.getLcFile().getPath(), ParamsWrap.getParamsWrap().getScriptEncryptKey());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            window = getWindow();
            i = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            window = getWindow();
            i = 2002;
        } else {
            window = getWindow();
            i = 2005;
        }
        window.setType(i);
    }

    private void a() {
        this.f1985b = (ImageView) findViewById(R.id.scriptui_imageview_setting);
        this.f1986c = (Button) findViewById(R.id.scriptui_button_savesetting);
        this.e = (ScrollView) findViewById(R.id.scriptui_scrollview);
        this.f1985b.setOnClickListener(this);
        this.f1986c.setOnClickListener(this);
        this.f = (LinearLayout) findViewById(R.id.ll_dialog_ui_parent);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.width = (int) (((float) com.cyjh.common.util.a.a(getContext()).x) * 0.9f);
        this.f.setLayoutParams(layoutParams);
    }

    private void a(float f2, float f3, int i, boolean z) {
        if (isShowing()) {
            dismiss();
            final float f4 = f2;
            final float f5 = f3;
            final int i2 = i;
            final boolean z2 = z;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    c.this.a(0.9f, r4);
                    c.this.c();
                    c.this.show();
                }
            }, 500);
        }
    }

    static /* synthetic */ void a(c cVar, float f2, int i) {
        if (cVar.isShowing()) {
            cVar.dismiss();
            final float f3 = f2;
            final int i2 = i;
            new Handler().postDelayed(new Runnable(0.9f, false) {
                public final void run() {
                    c.this.a(0.9f, f3);
                    c.this.c();
                    c.this.show();
                }
            }, 500);
        }
    }

    private void b() {
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                new Thread(new Runnable() {
                    public final void run() {
                        UisScriptRunner.getInstance().stopLoop();
                    }
                }).start();
            }
        });
        b.a().f2009b = new b.a() {
            public final void a() {
                c.a(c.this, 0.8f, 2);
            }

            public final void b() {
                c.a(c.this, 0.6f, 1);
            }
        };
    }

    /* access modifiers changed from: private */
    public void c() {
        try {
            Script script = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a;
            if (this.g == null) {
                this.g = d.a(getContext(), script.getUiFile().getPath(), script.getUipFile().getPath(), script.getCfgFile().getPath());
            }
            LinearLayout a2 = this.g.a();
            this.g.c();
            this.g.d();
            File file = new File(script.getUipFile().getPath());
            if (!file.exists() || file.length() <= 0) {
                this.e.removeViewAt(0);
                this.e.addView(a2);
                return;
            }
            this.f.removeAllViews();
            this.f.addView(a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() throws Exception {
        if (this.g != null) {
            this.g.d();
        }
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.scriptui_imageview_setting) {
            final d dVar = new d(getContext());
            dVar.f1996b = this.f1984a;
            dVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (dVar.f1997c) {
                        c.this.dismiss();
                    }
                }
            });
            dVar.show();
            dismiss();
        } else if (id == R.id.scriptui_button_savesetting) {
            try {
                com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getCfgFile();
                if (this.g != null) {
                    this.g.d();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            org.greenrobot.eventbus.c.a().c((Object) new MsgItem(1008));
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_scriptui);
        a(0.1f);
        a(0.9f, b.a().f2008a ? 0.8f : 0.6f);
        this.f1985b = (ImageView) findViewById(R.id.scriptui_imageview_setting);
        this.f1986c = (Button) findViewById(R.id.scriptui_button_savesetting);
        this.e = (ScrollView) findViewById(R.id.scriptui_scrollview);
        this.f1985b.setOnClickListener(this);
        this.f1986c.setOnClickListener(this);
        this.f = (LinearLayout) findViewById(R.id.ll_dialog_ui_parent);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.width = (int) (((float) com.cyjh.common.util.a.a(getContext()).x) * 0.9f);
        this.f.setLayoutParams(layoutParams);
        c();
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                new Thread(new Runnable() {
                    public final void run() {
                        UisScriptRunner.getInstance().stopLoop();
                    }
                }).start();
            }
        });
        b.a().f2009b = new b.a() {
            public final void a() {
                c.a(c.this, 0.8f, 2);
            }

            public final void b() {
                c.a(c.this, 0.6f, 1);
            }
        };
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b.a().f2009b = null;
    }
}
