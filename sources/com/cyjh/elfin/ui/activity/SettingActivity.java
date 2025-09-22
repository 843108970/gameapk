package com.cyjh.elfin.ui.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.ab;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.e;
import com.cyjh.common.util.m;
import com.cyjh.common.util.o;
import com.cyjh.common.util.x;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.g;
import com.cyjh.elfin.e.c.k;
import com.cyjh.elfin.e.c.l;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.entity.ScriptLog;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.elfin.services.PhoneStateService;
import com.cyjh.elfin.ui.a.h;
import com.cyjh.elfin.ui.activity.studio.EditDeviceNameActivity;
import com.cyjh.elfin.ui.activity.studio.StudioBindActivity;
import com.cyjh.elfin.ui.activity.studio.StudioBindClearActivity;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.cyjh.http.a.d;
import com.cyjh.http.bean.request.UpdateRequestInfo;
import com.cyjh.http.bean.response.VersionUpdateInfo;
import com.cyjh.http.c.b.a;
import com.elf.studio.enity.IMResultInfo;
import com.elfin.engin.d;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;
import java.io.File;
import java.util.Arrays;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class SettingActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public static final String f2173b = "SettingActivity";

    /* renamed from: c  reason: collision with root package name */
    public static final int f2174c = 3000;
    public static final int d = 1000;
    private static final int p = 1;
    private Switch e;
    private Switch f;
    private Switch g;
    private Switch h;
    private Switch i;
    private Switch j;
    /* access modifiers changed from: private */
    public Switch k;
    private Switch l;
    private LinearLayout m;
    private b n;
    /* access modifiers changed from: private */
    public com.cyjh.feedback.lib.b.a o;
    private Button q;
    private Button r;
    private Button s;
    private Button t;
    private TextView u;
    private TextView v;
    private LinearLayout w;
    private LinearLayout x;

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(SettingActivity settingActivity, byte b2) {
            this();
        }

        public final void a() {
            SettingActivity.this.finish();
        }
    }

    class b extends CountDownTimer {
        private b() {
            super(3000, 1000);
        }

        /* synthetic */ b(SettingActivity settingActivity, byte b2) {
            this();
        }

        public final void onFinish() {
            if (SettingActivity.this.o.isShowing()) {
                SettingActivity.this.o.dismiss();
            }
        }

        public final void onTick(long j) {
        }
    }

    private void a(String str) {
        Script script = c.f().f2011a;
        new IMResultInfo().IMToken = str;
        getString(R.string.elfin_appid);
        script.getId();
        String str2 = com.cyjh.http.b.a.a().f2477c.DeviceId;
        d.a();
    }

    private void b() {
        TitleView titleView = (TitleView) findViewById(R.id.titleview_setting);
        titleView.setTitleText((int) R.string.setting);
        titleView.setVisibilityLeftImage(0);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        titleView.setVisibilityRightImage(4);
        this.e = (Switch) findViewById(R.id.swtich_setting_call_stop);
        this.f = (Switch) findViewById(R.id.swtich_setting_volume_key_ctrl);
        this.g = (Switch) findViewById(R.id.swtich_setting_script_pause_and_resume);
        this.h = (Switch) findViewById(R.id.swtich_setting_waggle_stop);
        this.i = (Switch) findViewById(R.id.swtich_setting_floatview_ctrl);
        this.j = (Switch) findViewById(R.id.swtich_setting_vibration);
        this.k = (Switch) findViewById(R.id.switch_setting_word_recognition_library);
        this.q = (Button) findViewById(R.id.btn_setting_scriptlog);
        this.r = (Button) findViewById(R.id.setting_button_update);
        this.s = (Button) findViewById(R.id.setting_button_exitapp);
        this.t = (Button) findViewById(R.id.button_setting_feedback);
        this.l = (Switch) findViewById(R.id.setting_swtich_open_run);
        this.m = (LinearLayout) findViewById(R.id.layout_boot_script);
        this.w = (LinearLayout) findViewById(R.id.ll_device_name);
        this.x = (LinearLayout) findViewById(R.id.ll_project_number);
        this.u = (TextView) findViewById(R.id.tv_project_number);
        this.v = (TextView) findViewById(R.id.tv_device_name);
        this.v.setText(e.a((Context) this));
        c();
        if (com.cyjh.http.a.d.a().b()) {
            this.k.setChecked(true);
            this.k.setClickable(false);
        } else {
            this.k.setChecked(false);
            this.k.setOnCheckedChangeListener(this);
        }
        this.e.setChecked(ab.a().b(com.cyjh.elfin.a.a.x, (Boolean) true));
        this.f.setChecked(ab.a().b(com.cyjh.elfin.a.a.y, (Boolean) true));
        this.h.setChecked(ab.a().b(com.cyjh.elfin.a.a.z, (Boolean) true));
        this.i.setChecked(ab.a().b(com.cyjh.elfin.a.a.A, (Boolean) true));
        this.j.setChecked(ab.a().b(com.cyjh.elfin.a.a.B, (Boolean) true));
        this.l.setChecked(ab.a().b(com.cyjh.elfin.a.a.D, (Boolean) false));
        this.e.setOnCheckedChangeListener(this);
        this.f.setOnCheckedChangeListener(this);
        this.g.setOnCheckedChangeListener(this);
        this.h.setOnCheckedChangeListener(this);
        this.i.setOnCheckedChangeListener(this);
        this.j.setOnCheckedChangeListener(this);
        this.l.setOnCheckedChangeListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.x.setVisibility(8);
        this.w.setVisibility(8);
        this.m.setVisibility(0);
        org.greenrobot.eventbus.c.a().a((Object) this);
    }

    private void c() {
        this.u.setText(getString(TextUtils.isEmpty(AppContext.a().e) ? R.string.not_binding : R.string.already_binding));
    }

    private void d() {
        this.e.setOnCheckedChangeListener(this);
        this.f.setOnCheckedChangeListener(this);
        this.g.setOnCheckedChangeListener(this);
        this.h.setOnCheckedChangeListener(this);
        this.i.setOnCheckedChangeListener(this);
        this.j.setOnCheckedChangeListener(this);
        this.l.setOnCheckedChangeListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
    }

    private void e() {
        TitleView titleView = (TitleView) findViewById(R.id.titleview_setting);
        titleView.setTitleText((int) R.string.setting);
        titleView.setVisibilityLeftImage(0);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        titleView.setVisibilityRightImage(4);
    }

    private void f() {
        this.e.setChecked(ab.a().b(com.cyjh.elfin.a.a.x, (Boolean) true));
        this.f.setChecked(ab.a().b(com.cyjh.elfin.a.a.y, (Boolean) true));
        this.h.setChecked(ab.a().b(com.cyjh.elfin.a.a.z, (Boolean) true));
        this.i.setChecked(ab.a().b(com.cyjh.elfin.a.a.A, (Boolean) true));
        this.j.setChecked(ab.a().b(com.cyjh.elfin.a.a.B, (Boolean) true));
        this.l.setChecked(ab.a().b(com.cyjh.elfin.a.a.D, (Boolean) false));
    }

    private void g() {
        if (com.cyjh.http.a.d.a().b()) {
            this.k.setChecked(true);
            this.k.setClickable(false);
            return;
        }
        this.k.setChecked(false);
        this.k.setOnCheckedChangeListener(this);
    }

    private void h() {
        final com.cyjh.common.d.b bVar = new com.cyjh.common.d.b(this);
        bVar.show();
        com.cyjh.http.a.d.a().a(com.cyjh.common.b.a.aR, new d.c() {
            private /* synthetic */ void a(com.cyjh.common.d.b bVar) {
                bVar.dismiss();
                ag.a(SettingActivity.this.getApplicationContext(), "文字识别库下载失败！");
                SettingActivity.this.k.setClickable(true);
                SettingActivity.this.k.setChecked(false);
            }

            public final void a() {
                r3.dismiss();
                ag.a(SettingActivity.this.getApplicationContext(), "文字识别库已下载！");
            }

            public final void b() {
                r3.dismiss();
                ag.a(SettingActivity.this.getApplicationContext(), "文字识别库下载成功！");
                SettingActivity.this.k.setClickable(false);
            }

            public final void c() {
                SettingActivity.this.runOnUiThread(new b(this, r3));
            }
        });
    }

    private void i() {
        m.a();
        if (!m.b()) {
            if (!x.a(this)) {
                ag.b(getApplicationContext(), (int) R.string.network_off);
                return;
            }
            String a2 = l.a(this, com.cyjh.elfin.a.a.u);
            String a3 = e.a((Context) this);
            UpdateRequestInfo updateRequestInfo = new UpdateRequestInfo();
            updateRequestInfo.ScriptId = c.f().f2011a.getId();
            updateRequestInfo.DeviceName = a3;
            updateRequestInfo.ScriptVersion = Integer.parseInt(a2);
            String str = f2173b;
            ad.c(str, "updateVersionRequest --> 1 ScriptId=" + updateRequestInfo.ScriptId + ",DeviceName=" + updateRequestInfo.DeviceName + ",ScriptVersion=" + updateRequestInfo.ScriptVersion);
            com.cyjh.http.c.b.a a4 = com.cyjh.http.c.b.a.a();
            a4.f2481c = new a.C0039a() {
                public final void a(VersionUpdateInfo versionUpdateInfo) {
                    if (versionUpdateInfo != null) {
                        new h(SettingActivity.this, versionUpdateInfo, false).show();
                    }
                }

                public final void b(VersionUpdateInfo versionUpdateInfo) {
                }

                public final void c(VersionUpdateInfo versionUpdateInfo) {
                }
            };
            a4.a(true, this, updateRequestInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            this.o = new com.cyjh.feedback.lib.b.a(this);
            this.o.show();
            this.n = new b(this, (byte) 0);
            this.n.start();
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.swtich_setting_volume_key_ctrl /*2131755246*/:
                if (z || this.i.isChecked()) {
                    ab.a().a(com.cyjh.elfin.a.a.y, Boolean.valueOf(z));
                    return;
                }
                AppContext.a().a(R.string.setting_illegal);
                this.f.setChecked(true);
                return;
            case R.id.swtich_setting_script_pause_and_resume /*2131755247*/:
                if (z) {
                    com.cyjh.elfin.floatingwindowprocess.d.b.j();
                    com.cyjh.elfin.floatingwindowprocess.d.b.e();
                    return;
                }
                com.cyjh.elfin.floatingwindowprocess.d.b.j();
                com.cyjh.elfin.floatingwindowprocess.d.b.f();
                return;
            case R.id.swtich_setting_floatview_ctrl /*2131755248*/:
                if (z || this.f.isChecked()) {
                    k.a(101);
                    ab.a().a(com.cyjh.elfin.a.a.A, Boolean.valueOf(z));
                    return;
                }
                AppContext.a().a(R.string.setting_illegal);
                this.i.setChecked(true);
                return;
            case R.id.swtich_setting_waggle_stop /*2131755249*/:
                ab.a().a(com.cyjh.elfin.a.a.z, Boolean.valueOf(z));
                return;
            case R.id.swtich_setting_call_stop /*2131755250*/:
                ab.a().a(com.cyjh.elfin.a.a.x, Boolean.valueOf(z));
                return;
            case R.id.swtich_setting_vibration /*2131755251*/:
                ab.a().a(com.cyjh.elfin.a.a.B, Boolean.valueOf(z));
                return;
            case R.id.setting_swtich_open_run /*2131755253*/:
                ab.a().a(com.cyjh.elfin.a.a.D, Boolean.valueOf(z));
                e.a((Context) this, z);
                return;
            case R.id.switch_setting_word_recognition_library /*2131755254*/:
                if (z) {
                    final com.cyjh.common.d.b bVar = new com.cyjh.common.d.b(this);
                    bVar.show();
                    com.cyjh.http.a.d.a().a(com.cyjh.common.b.a.aR, new d.c() {
                        private /* synthetic */ void a(com.cyjh.common.d.b bVar) {
                            bVar.dismiss();
                            ag.a(SettingActivity.this.getApplicationContext(), "文字识别库下载失败！");
                            SettingActivity.this.k.setClickable(true);
                            SettingActivity.this.k.setChecked(false);
                        }

                        public final void a() {
                            bVar.dismiss();
                            ag.a(SettingActivity.this.getApplicationContext(), "文字识别库已下载！");
                        }

                        public final void b() {
                            bVar.dismiss();
                            ag.a(SettingActivity.this.getApplicationContext(), "文字识别库下载成功！");
                            SettingActivity.this.k.setClickable(false);
                        }

                        public final void c() {
                            SettingActivity.this.runOnUiThread(new b(this, bVar));
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_device_name) {
            Intent intent = new Intent(this, EditDeviceNameActivity.class);
            intent.putExtra("device_name", this.v.getText().toString());
            startActivity(intent);
        } else if (id != R.id.ll_project_number) {
            switch (id) {
                case R.id.btn_setting_scriptlog /*2131755255*/:
                    File[] listFiles = new File(AppContext.a().f1856c).listFiles(new o.a(com.cyjh.elfin.a.a.E));
                    if (listFiles == null || listFiles.length == 0) {
                        AppContext.a().a(R.string.No_ScriptLog);
                        return;
                    }
                    Arrays.sort(listFiles, new g());
                    File file = listFiles[0];
                    ScriptLog scriptLog = new ScriptLog();
                    scriptLog.setName(file.getName());
                    scriptLog.setSize(o.a(file.length()));
                    scriptLog.setFile(file);
                    Intent intent2 = new Intent(this, ScriptLogDetailActivity.class);
                    intent2.putExtra(com.cyjh.elfin.a.a.F, true);
                    intent2.putExtra(com.cyjh.elfin.a.a.G, scriptLog);
                    startActivity(intent2);
                    return;
                case R.id.setting_button_update /*2131755256*/:
                    m.a();
                    if (m.b()) {
                        return;
                    }
                    if (!x.a(this)) {
                        ag.b(getApplicationContext(), (int) R.string.network_off);
                        return;
                    }
                    String a2 = l.a(this, com.cyjh.elfin.a.a.u);
                    String a3 = e.a((Context) this);
                    UpdateRequestInfo updateRequestInfo = new UpdateRequestInfo();
                    updateRequestInfo.ScriptId = c.f().f2011a.getId();
                    updateRequestInfo.DeviceName = a3;
                    updateRequestInfo.ScriptVersion = Integer.parseInt(a2);
                    String str = f2173b;
                    ad.c(str, "updateVersionRequest --> 1 ScriptId=" + updateRequestInfo.ScriptId + ",DeviceName=" + updateRequestInfo.DeviceName + ",ScriptVersion=" + updateRequestInfo.ScriptVersion);
                    com.cyjh.http.c.b.a a4 = com.cyjh.http.c.b.a.a();
                    a4.f2481c = new a.C0039a() {
                        public final void a(VersionUpdateInfo versionUpdateInfo) {
                            if (versionUpdateInfo != null) {
                                new h(SettingActivity.this, versionUpdateInfo, false).show();
                            }
                        }

                        public final void b(VersionUpdateInfo versionUpdateInfo) {
                        }

                        public final void c(VersionUpdateInfo versionUpdateInfo) {
                        }
                    };
                    a4.a(true, this, updateRequestInfo);
                    return;
                case R.id.button_setting_feedback /*2131755257*/:
                    Intent intent3 = new Intent(this, FeedbackActivity.class);
                    intent3.putExtra(FeedbackActivity.class.getCanonicalName(), ParamsWrap.getParamsWrap().feedbackTips);
                    startActivityForResult(intent3, 1);
                    return;
                case R.id.setting_button_exitapp /*2131755258*/:
                    stopService(new Intent(this, PhoneStateService.class));
                    com.elfin.engin.d.a((Context) this);
                    MobclickAgent.onKillProcess(AppContext.a());
                    ActivityManager activityManager = (ActivityManager) getSystemService("activity");
                    if (activityManager != null) {
                        activityManager.killBackgroundProcesses("com.cyjh.elfin:download_server");
                    }
                    Process.killProcess(Process.myPid());
                    return;
                default:
                    return;
            }
        } else if (TextUtils.isEmpty(AppContext.a().e)) {
            StudioBindActivity.a((Context) this);
        } else {
            StudioBindClearActivity.a(this, AppContext.a().e);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting);
        TitleView titleView = (TitleView) findViewById(R.id.titleview_setting);
        titleView.setTitleText((int) R.string.setting);
        titleView.setVisibilityLeftImage(0);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        titleView.setVisibilityRightImage(4);
        this.e = (Switch) findViewById(R.id.swtich_setting_call_stop);
        this.f = (Switch) findViewById(R.id.swtich_setting_volume_key_ctrl);
        this.g = (Switch) findViewById(R.id.swtich_setting_script_pause_and_resume);
        this.h = (Switch) findViewById(R.id.swtich_setting_waggle_stop);
        this.i = (Switch) findViewById(R.id.swtich_setting_floatview_ctrl);
        this.j = (Switch) findViewById(R.id.swtich_setting_vibration);
        this.k = (Switch) findViewById(R.id.switch_setting_word_recognition_library);
        this.q = (Button) findViewById(R.id.btn_setting_scriptlog);
        this.r = (Button) findViewById(R.id.setting_button_update);
        this.s = (Button) findViewById(R.id.setting_button_exitapp);
        this.t = (Button) findViewById(R.id.button_setting_feedback);
        this.l = (Switch) findViewById(R.id.setting_swtich_open_run);
        this.m = (LinearLayout) findViewById(R.id.layout_boot_script);
        this.w = (LinearLayout) findViewById(R.id.ll_device_name);
        this.x = (LinearLayout) findViewById(R.id.ll_project_number);
        this.u = (TextView) findViewById(R.id.tv_project_number);
        this.v = (TextView) findViewById(R.id.tv_device_name);
        this.v.setText(e.a((Context) this));
        c();
        if (com.cyjh.http.a.d.a().b()) {
            this.k.setChecked(true);
            this.k.setClickable(false);
        } else {
            this.k.setChecked(false);
            this.k.setOnCheckedChangeListener(this);
        }
        this.e.setChecked(ab.a().b(com.cyjh.elfin.a.a.x, (Boolean) true));
        this.f.setChecked(ab.a().b(com.cyjh.elfin.a.a.y, (Boolean) true));
        this.h.setChecked(ab.a().b(com.cyjh.elfin.a.a.z, (Boolean) true));
        this.i.setChecked(ab.a().b(com.cyjh.elfin.a.a.A, (Boolean) true));
        this.j.setChecked(ab.a().b(com.cyjh.elfin.a.a.B, (Boolean) true));
        this.l.setChecked(ab.a().b(com.cyjh.elfin.a.a.D, (Boolean) false));
        this.e.setOnCheckedChangeListener(this);
        this.f.setOnCheckedChangeListener(this);
        this.g.setOnCheckedChangeListener(this);
        this.h.setOnCheckedChangeListener(this);
        this.i.setOnCheckedChangeListener(this);
        this.j.setOnCheckedChangeListener(this);
        this.l.setOnCheckedChangeListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.x.setVisibility(8);
        this.w.setVisibility(8);
        this.m.setVisibility(0);
        org.greenrobot.eventbus.c.a().a((Object) this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.n != null) {
            this.n.cancel();
        }
        com.cyjh.http.c.b.a.a().d();
        org.greenrobot.eventbus.c.a().b((Object) this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(SettingActivity.class.getCanonicalName());
        MobclickAgent.onPause(this);
    }

    @j(a = ThreadMode.MAIN)
    public void onReceiveStudioProjectStatusEvent(com.elf.studio.a.b bVar) {
        switch (bVar.e) {
            case 10001:
            case 10002:
                c();
                String str = bVar.f;
                Script script = c.f().f2011a;
                new IMResultInfo().IMToken = str;
                getString(R.string.elfin_appid);
                script.getId();
                String str2 = com.cyjh.http.b.a.a().f2477c.DeviceId;
                com.elfin.engin.d.a();
                this.u.postDelayed(new Runnable() {
                    public final void run() {
                    }
                }, 500);
                return;
            case 10003:
                c();
                return;
            case 10004:
                this.v.setText(bVar.f);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(SettingActivity.class.getCanonicalName());
        MobclickAgent.onResume(this);
    }
}
