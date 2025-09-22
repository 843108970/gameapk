package com.cyjh.elfin.floatingwindowprocess.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import com.cyjh.common.d.b;
import com.cyjh.common.util.ab;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.e;
import com.cyjh.common.util.m;
import com.cyjh.common.util.o;
import com.cyjh.common.util.x;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.g;
import com.cyjh.elfin.e.c.l;
import com.cyjh.elfin.entity.ScriptLog;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.elfin.services.PhoneStateService;
import com.cyjh.elfin.ui.a.a;
import com.cyjh.elfin.ui.a.h;
import com.cyjh.elfin.ui.activity.ScriptLogDetailActivity;
import com.cyjh.http.a.d;
import com.cyjh.http.bean.request.UpdateRequestInfo;
import com.cyjh.http.bean.response.VersionUpdateInfo;
import com.cyjh.http.c.b.a;
import com.cyjh.mq.sdk.MqBridge;
import com.ywfzjbcy.R;
import java.io.File;
import java.util.Arrays;

public class d extends a implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int K = 24;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1995a = "d";
    private static final int m = 19;

    /* renamed from: b  reason: collision with root package name */
    public Context f1996b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1997c;
    private Switch e;
    private Switch f;
    private Switch g;
    private Switch h;
    private Switch i;
    /* access modifiers changed from: private */
    public Switch j;
    private Switch k;
    private LinearLayout l;

    protected d(Context context) {
        super(context);
        Window window;
        int i2;
        this.d = (AppContext) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 26) {
            window = getWindow();
            i2 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            if (getWindow() != null) {
                getWindow().setType(2002);
                return;
            }
            return;
        } else if (getWindow() != null) {
            window = getWindow();
            i2 = 2005;
        } else {
            return;
        }
        window.setType(i2);
    }

    private void a() {
        this.e = (Switch) findViewById(R.id.setting_swtich_call_stop);
        this.f = (Switch) findViewById(R.id.setting_swtich_volume_key_ctrl);
        this.g = (Switch) findViewById(R.id.setting_swtich_waggle_stop);
        this.h = (Switch) findViewById(R.id.setting_swtich_floatview_ctrl);
        this.i = (Switch) findViewById(R.id.setting_swtich_vibration);
        this.j = (Switch) findViewById(R.id.switch_setting_word_recognition_library);
        this.k = (Switch) findViewById(R.id.setting_swtich_open_run);
        this.l = (LinearLayout) findViewById(R.id.layout_boot_script);
        this.l.setVisibility(0);
        this.e.setOnCheckedChangeListener(this);
        this.f.setOnCheckedChangeListener(this);
        this.g.setOnCheckedChangeListener(this);
        this.h.setOnCheckedChangeListener(this);
        this.i.setOnCheckedChangeListener(this);
        this.k.setOnCheckedChangeListener(this);
        ((Button) findViewById(R.id.setting_button_scriptlog)).setOnClickListener(this);
        ((Button) findViewById(R.id.setting_button_exitapp)).setOnClickListener(this);
        ((Button) findViewById(R.id.setting_button_update)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.setting_dialog_imageview_back)).setOnClickListener(this);
        if (com.cyjh.http.a.d.a().b()) {
            this.j.setChecked(true);
            this.j.setClickable(false);
        } else {
            this.j.setChecked(false);
            this.j.setOnCheckedChangeListener(this);
        }
        this.e.setChecked(ab.a().b(com.cyjh.elfin.a.a.x, (Boolean) true));
        this.f.setChecked(ab.a().b(com.cyjh.elfin.a.a.y, (Boolean) true));
        this.g.setChecked(ab.a().b(com.cyjh.elfin.a.a.z, (Boolean) true));
        this.h.setChecked(ab.a().b(com.cyjh.elfin.a.a.A, (Boolean) true));
        this.i.setChecked(ab.a().b(com.cyjh.elfin.a.a.B, (Boolean) true));
        this.k.setChecked(ab.a().b(com.cyjh.elfin.a.a.D, (Boolean) false));
    }

    private void b() {
        this.e.setChecked(ab.a().b(com.cyjh.elfin.a.a.x, (Boolean) true));
        this.f.setChecked(ab.a().b(com.cyjh.elfin.a.a.y, (Boolean) true));
        this.g.setChecked(ab.a().b(com.cyjh.elfin.a.a.z, (Boolean) true));
        this.h.setChecked(ab.a().b(com.cyjh.elfin.a.a.A, (Boolean) true));
        this.i.setChecked(ab.a().b(com.cyjh.elfin.a.a.B, (Boolean) true));
        this.k.setChecked(ab.a().b(com.cyjh.elfin.a.a.D, (Boolean) false));
    }

    private void c() {
        if (com.cyjh.http.a.d.a().b()) {
            this.j.setChecked(true);
            this.j.setClickable(false);
            return;
        }
        this.j.setChecked(false);
        this.j.setOnCheckedChangeListener(this);
    }

    private void d() {
        m.a();
        if (!m.b()) {
            if (!x.a(getContext())) {
                ag.b(getContext().getApplicationContext(), (int) R.string.network_off);
                return;
            }
            this.f1997c = false;
            String a2 = l.a(getContext(), com.cyjh.elfin.a.a.u);
            String a3 = e.a(getContext());
            UpdateRequestInfo updateRequestInfo = new UpdateRequestInfo();
            updateRequestInfo.ScriptId = c.f().f2011a.getId();
            updateRequestInfo.DeviceName = a3;
            updateRequestInfo.ScriptVersion = Integer.parseInt(a2);
            String str = f1995a;
            ad.c(str, "updateVersionRequest --> 1 ScriptId=" + updateRequestInfo.ScriptId + ",DeviceName=" + updateRequestInfo.DeviceName + ",ScriptVersion=" + updateRequestInfo.ScriptVersion);
            com.cyjh.http.c.b.a a4 = com.cyjh.http.c.b.a.a();
            a4.f2481c = new a.C0039a() {
                public final void a(VersionUpdateInfo versionUpdateInfo) {
                    ad.c(d.f1995a, "onUpdateHas --> ");
                    if (versionUpdateInfo != null) {
                        new h(d.this.getContext(), versionUpdateInfo, true).show();
                    }
                }

                public final void b(VersionUpdateInfo versionUpdateInfo) {
                }

                public final void c(VersionUpdateInfo versionUpdateInfo) {
                }
            };
            a4.a(true, getContext(), updateRequestInfo);
        }
    }

    private void e() {
        final b bVar = new b(getContext());
        bVar.show();
        com.cyjh.http.a.d.a().a(com.cyjh.common.b.a.aR, new d.c() {
            public final void a() {
                r3.dismiss();
                ag.a(d.this.getContext().getApplicationContext(), "文字识别库已下载！");
            }

            public final void b() {
                r3.dismiss();
                ag.a(d.this.getContext().getApplicationContext(), "文字识别库下载成功！");
                d.this.j.setClickable(false);
            }

            public final void c() {
                r3.dismiss();
                ag.a(d.this.getContext().getApplicationContext(), "文字识别库下载失败！");
                d.this.j.setClickable(true);
                d.this.j.setChecked(false);
            }
        });
    }

    private boolean f() {
        return this.f1997c;
    }

    public void dismiss() {
        super.dismiss();
        com.cyjh.http.c.b.a.a().d();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        switch (id) {
            case R.id.setting_swtich_open_run /*2131755253*/:
                ab.a().a(com.cyjh.elfin.a.a.D, Boolean.valueOf(z));
                e.a(getContext(), z);
                return;
            case R.id.switch_setting_word_recognition_library /*2131755254*/:
                if (z) {
                    final b bVar = new b(getContext());
                    bVar.show();
                    com.cyjh.http.a.d.a().a(com.cyjh.common.b.a.aR, new d.c() {
                        public final void a() {
                            bVar.dismiss();
                            ag.a(d.this.getContext().getApplicationContext(), "文字识别库已下载！");
                        }

                        public final void b() {
                            bVar.dismiss();
                            ag.a(d.this.getContext().getApplicationContext(), "文字识别库下载成功！");
                            d.this.j.setClickable(false);
                        }

                        public final void c() {
                            bVar.dismiss();
                            ag.a(d.this.getContext().getApplicationContext(), "文字识别库下载失败！");
                            d.this.j.setClickable(true);
                            d.this.j.setChecked(false);
                        }
                    });
                    return;
                }
                return;
            default:
                switch (id) {
                    case R.id.setting_swtich_volume_key_ctrl /*2131755496*/:
                        if (z || this.h.isChecked()) {
                            ab.a().a(com.cyjh.elfin.a.a.y, Boolean.valueOf(z));
                            return;
                        }
                        this.d.a(R.string.setting_illegal);
                        this.f.setChecked(true);
                        return;
                    case R.id.setting_swtich_floatview_ctrl /*2131755497*/:
                        if (z || this.f.isChecked()) {
                            ab.a().a(com.cyjh.elfin.a.a.A, Boolean.valueOf(z));
                            com.cyjh.elfin.floatingwindowprocess.c.a.a().f2005a.d();
                            return;
                        }
                        this.d.a(R.string.setting_illegal);
                        this.h.setChecked(true);
                        return;
                    case R.id.setting_swtich_waggle_stop /*2131755498*/:
                        ab.a().a(com.cyjh.elfin.a.a.z, Boolean.valueOf(z));
                        return;
                    case R.id.setting_swtich_call_stop /*2131755499*/:
                        ab.a().a(com.cyjh.elfin.a.a.x, Boolean.valueOf(z));
                        return;
                    case R.id.setting_swtich_vibration /*2131755500*/:
                        ab.a().a(com.cyjh.elfin.a.a.B, Boolean.valueOf(z));
                        return;
                    default:
                        return;
                }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.setting_button_update) {
            m.a();
            if (m.b()) {
                return;
            }
            if (!x.a(getContext())) {
                ag.b(getContext().getApplicationContext(), (int) R.string.network_off);
                return;
            }
            this.f1997c = false;
            String a2 = l.a(getContext(), com.cyjh.elfin.a.a.u);
            String a3 = e.a(getContext());
            UpdateRequestInfo updateRequestInfo = new UpdateRequestInfo();
            updateRequestInfo.ScriptId = c.f().f2011a.getId();
            updateRequestInfo.DeviceName = a3;
            updateRequestInfo.ScriptVersion = Integer.parseInt(a2);
            String str = f1995a;
            ad.c(str, "updateVersionRequest --> 1 ScriptId=" + updateRequestInfo.ScriptId + ",DeviceName=" + updateRequestInfo.DeviceName + ",ScriptVersion=" + updateRequestInfo.ScriptVersion);
            com.cyjh.http.c.b.a a4 = com.cyjh.http.c.b.a.a();
            a4.f2481c = new a.C0039a() {
                public final void a(VersionUpdateInfo versionUpdateInfo) {
                    ad.c(d.f1995a, "onUpdateHas --> ");
                    if (versionUpdateInfo != null) {
                        new h(d.this.getContext(), versionUpdateInfo, true).show();
                    }
                }

                public final void b(VersionUpdateInfo versionUpdateInfo) {
                }

                public final void c(VersionUpdateInfo versionUpdateInfo) {
                }
            };
            a4.a(true, getContext(), updateRequestInfo);
        } else if (id == R.id.setting_button_exitapp) {
            this.f1997c = false;
            if (this.f1996b != null && (this.f1996b instanceof Activity)) {
                ((Activity) this.f1996b).finish();
            }
            getContext().stopService(new Intent(getContext(), PhoneStateService.class));
            MqBridge.exit();
            Process.killProcess(Process.myPid());
            ActivityManager activityManager = (ActivityManager) getContext().getSystemService("activity");
            if (activityManager != null) {
                activityManager.killBackgroundProcesses("com.cyjh.elfin:download_server");
            }
        } else if (id == R.id.setting_dialog_imageview_back) {
            this.f1997c = false;
            dismiss();
            new c(getContext()).show();
        } else if (id == R.id.setting_button_scriptlog) {
            File[] listFiles = new File(this.d.f1856c).listFiles(new o.a(com.cyjh.elfin.a.a.E));
            if (listFiles == null || listFiles.length == 0) {
                this.d.a(R.string.No_ScriptLog);
                return;
            }
            Arrays.sort(listFiles, new g());
            File file = listFiles[0];
            ScriptLog scriptLog = new ScriptLog();
            scriptLog.setName(file.getName());
            scriptLog.setSize(o.a(file.length()));
            scriptLog.setFile(file);
            Intent intent = new Intent(getContext(), ScriptLogDetailActivity.class);
            intent.putExtra(com.cyjh.elfin.a.a.F, true);
            intent.putExtra(com.cyjh.elfin.a.a.G, scriptLog);
            intent.addFlags(268435456);
            getContext().startActivity(intent);
            this.f1997c = true;
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.setting_dialog);
        a(0.1f);
        a(0.9f, 0.6f);
        this.e = (Switch) findViewById(R.id.setting_swtich_call_stop);
        this.f = (Switch) findViewById(R.id.setting_swtich_volume_key_ctrl);
        this.g = (Switch) findViewById(R.id.setting_swtich_waggle_stop);
        this.h = (Switch) findViewById(R.id.setting_swtich_floatview_ctrl);
        this.i = (Switch) findViewById(R.id.setting_swtich_vibration);
        this.j = (Switch) findViewById(R.id.switch_setting_word_recognition_library);
        this.k = (Switch) findViewById(R.id.setting_swtich_open_run);
        this.l = (LinearLayout) findViewById(R.id.layout_boot_script);
        this.l.setVisibility(0);
        this.e.setOnCheckedChangeListener(this);
        this.f.setOnCheckedChangeListener(this);
        this.g.setOnCheckedChangeListener(this);
        this.h.setOnCheckedChangeListener(this);
        this.i.setOnCheckedChangeListener(this);
        this.k.setOnCheckedChangeListener(this);
        ((Button) findViewById(R.id.setting_button_scriptlog)).setOnClickListener(this);
        ((Button) findViewById(R.id.setting_button_exitapp)).setOnClickListener(this);
        ((Button) findViewById(R.id.setting_button_update)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.setting_dialog_imageview_back)).setOnClickListener(this);
        if (com.cyjh.http.a.d.a().b()) {
            this.j.setChecked(true);
            this.j.setClickable(false);
        } else {
            this.j.setChecked(false);
            this.j.setOnCheckedChangeListener(this);
        }
        this.e.setChecked(ab.a().b(com.cyjh.elfin.a.a.x, (Boolean) true));
        this.f.setChecked(ab.a().b(com.cyjh.elfin.a.a.y, (Boolean) true));
        this.g.setChecked(ab.a().b(com.cyjh.elfin.a.a.z, (Boolean) true));
        this.h.setChecked(ab.a().b(com.cyjh.elfin.a.a.A, (Boolean) true));
        this.i.setChecked(ab.a().b(com.cyjh.elfin.a.a.B, (Boolean) true));
        this.k.setChecked(ab.a().b(com.cyjh.elfin.a.a.D, (Boolean) false));
    }
}
