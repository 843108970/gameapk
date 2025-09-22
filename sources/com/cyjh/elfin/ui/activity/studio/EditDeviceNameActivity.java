package com.cyjh.elfin.ui.activity.studio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.e;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.cyjh.http.c.c.g;
import com.ywfzjbcy.R;

public class EditDeviceNameActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static String f2213b = "EditDeviceNameActivity";

    /* renamed from: c  reason: collision with root package name */
    public static final String f2214c = "device_name";
    /* access modifiers changed from: private */
    public TitleView d;
    private EditText e;
    private Handler f = new Handler();
    private ImageView g;

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(EditDeviceNameActivity editDeviceNameActivity, byte b2) {
            this();
        }

        public final void a() {
            EditDeviceNameActivity.this.finish();
        }
    }

    private class b implements TitleView.c {
        private b() {
        }

        /* synthetic */ b(EditDeviceNameActivity editDeviceNameActivity, byte b2) {
            this();
        }

        public final void a() {
            EditDeviceNameActivity.a(EditDeviceNameActivity.this);
        }
    }

    private static void a(Context context) {
        context.startActivity(new Intent(context, EditDeviceNameActivity.class));
    }

    private static void a(Context context, String str) {
        Intent intent = new Intent(context, EditDeviceNameActivity.class);
        intent.putExtra("device_name", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    static /* synthetic */ void a(EditDeviceNameActivity editDeviceNameActivity) {
        final String obj = editDeviceNameActivity.e.getText().toString();
        e.a((Context) editDeviceNameActivity, obj);
        Script script = c.f().f2011a;
        if (script != null) {
            g.a().a(editDeviceNameActivity, script.getId(), obj, new g.a() {
                public final void a() {
                    org.greenrobot.eventbus.c.a().c((Object) new com.elf.studio.a.b(10004, r0));
                    EditDeviceNameActivity.this.d.post(new Runnable() {
                        public final void run() {
                            ag.a(EditDeviceNameActivity.this.getApplicationContext(), "修改成功！");
                        }
                    });
                    EditDeviceNameActivity.this.finish();
                }

                public final void a(final String str) {
                    EditDeviceNameActivity.this.d.post(new Runnable() {
                        public final void run() {
                            ag.a(EditDeviceNameActivity.this.getApplicationContext(), str);
                        }
                    });
                }
            });
        } else {
            editDeviceNameActivity.d.post(new Runnable() {
                public final void run() {
                    ag.a(EditDeviceNameActivity.this.getApplicationContext(), "脚本数据出错");
                }
            });
        }
    }

    private void b() {
        this.d = (TitleView) findViewById(R.id.titleView);
        this.d.setVisibilityTvRight(0);
        this.e = (EditText) findViewById(R.id.et_device_name);
        this.g = (ImageView) findViewById(R.id.iv_clear);
    }

    private void c() {
        this.d.setRightTvText((int) R.string.save);
        this.d.setVisibilityTvRight(0);
        String stringExtra = getIntent().getStringExtra("device_name");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.e.setText(stringExtra);
            this.e.setSelection(stringExtra.length());
        }
    }

    private void d() {
        this.g.setOnClickListener(this);
    }

    private void e() {
        this.d.setTitleText((int) R.string.edit_device_name_title);
        this.d.setVisibilityLeftImage(0);
        this.d.setleftImage(R.drawable.ic_back);
        this.d.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.d.setOnRightTextViewListener(new b(this, (byte) 0));
        this.d.setVisibilityRightImage(4);
    }

    private void f() {
        final String obj = this.e.getText().toString();
        e.a((Context) this, obj);
        Script script = c.f().f2011a;
        if (script != null) {
            g.a().a(this, script.getId(), obj, new g.a() {
                public final void a() {
                    org.greenrobot.eventbus.c.a().c((Object) new com.elf.studio.a.b(10004, obj));
                    EditDeviceNameActivity.this.d.post(new Runnable() {
                        public final void run() {
                            ag.a(EditDeviceNameActivity.this.getApplicationContext(), "修改成功！");
                        }
                    });
                    EditDeviceNameActivity.this.finish();
                }

                public final void a(final String str) {
                    EditDeviceNameActivity.this.d.post(new Runnable() {
                        public final void run() {
                            ag.a(EditDeviceNameActivity.this.getApplicationContext(), str);
                        }
                    });
                }
            });
        } else {
            this.d.post(new Runnable() {
                public final void run() {
                    ag.a(EditDeviceNameActivity.this.getApplicationContext(), "脚本数据出错");
                }
            });
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_clear) {
            this.e.setText("");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_edit_device_name);
        this.d = (TitleView) findViewById(R.id.titleView);
        this.d.setVisibilityTvRight(0);
        this.e = (EditText) findViewById(R.id.et_device_name);
        this.g = (ImageView) findViewById(R.id.iv_clear);
        this.d.setTitleText((int) R.string.edit_device_name_title);
        this.d.setVisibilityLeftImage(0);
        this.d.setleftImage(R.drawable.ic_back);
        this.d.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.d.setOnRightTextViewListener(new b(this, (byte) 0));
        this.d.setVisibilityRightImage(4);
        this.d.setRightTvText((int) R.string.save);
        this.d.setVisibilityTvRight(0);
        String stringExtra = getIntent().getStringExtra("device_name");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.e.setText(stringExtra);
            this.e.setSelection(stringExtra.length());
        }
        this.g.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f.removeCallbacksAndMessages((Object) null);
        this.f = null;
    }
}
