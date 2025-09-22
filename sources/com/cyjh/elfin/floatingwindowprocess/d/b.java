package com.cyjh.elfin.floatingwindowprocess.d;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.cyjh.common.util.ab;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ae;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.aj;
import com.cyjh.common.util.l;
import com.cyjh.common.util.w;
import com.cyjh.common.util.x;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.o;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.floatingwindowprocess.c.a;
import com.cyjh.elfin.floatingwindowprocess.c.d;
import com.cyjh.elfin.floatingwindowprocess.d.a;
import com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView;
import com.cyjh.http.a.b;
import com.cyjh.http.bean.request.DeviceInfo;
import com.cyjh.http.c.c.c;
import com.cyjh.http.c.c.f;
import com.cyjh.http.c.c.r;
import com.cyjh.mobileanjian.ipc.interfaces.RootProgressListener;
import com.cyjh.mobileanjian.ipc.rpc.RestartScriptHelper;
import com.cyjh.mq.sdk.MqBridge;
import com.cyjh.mq.sdk.entity.Script4Run;
import com.elfin.engin.a.c;
import com.elfin.engin.e;
import com.elfin.engin.g;
import com.goldcoast.sdk.domain.AnalyseResult;
import com.goldcoast.sdk.domain.EntryPoint;
import com.rck.yt.ten.cn.Orcck;
import com.ywfzjbcy.R;
import java.io.File;
import java.io.PrintStream;
import java.util.Timer;
import org.json.JSONObject;

public final class b {
    private static final int i = 3000;
    private static final String j = "ScriptRunnerManager";
    private static final b l = new b();

    /* renamed from: a  reason: collision with root package name */
    public String f2027a;

    /* renamed from: b  reason: collision with root package name */
    public int f2028b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final Handler f2029c = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1 && i != 2) {
                if (i == 3) {
                    Object obj = message.obj;
                    c unused = c.a.f2893a;
                    int i2 = b.this.f2028b;
                } else if (message.what == 1000) {
                    f.a().a((Context) AppContext.a());
                }
            }
        }
    };
    /* access modifiers changed from: package-private */
    public boolean d = true;
    public boolean e = true;
    boolean f = true;
    private boolean g;
    private final e h = new e() {
        public final void a() {
            b.i();
        }

        public final void a(float f, int i, int i2) {
            ImageView imageView;
            int i3;
            b.h();
            ElfinFloatView elfinFloatView = a.a().f2005a;
            String str = ElfinFloatView.f2041a;
            ad.c(str, "posControlBar --> position=" + f + ",lockState=" + i + ",isRight=" + i2);
            elfinFloatView.n = i;
            if (elfinFloatView.n != 0) {
                elfinFloatView.f2043c.setOnTouchListener((View.OnTouchListener) null);
            }
            if (elfinFloatView.k.getVisibility() == 0) {
                elfinFloatView.k.setVisibility(8);
                elfinFloatView.k.a();
            }
            elfinFloatView.a(i2 == 0 ? 0 : com.cyjh.common.util.a.a(elfinFloatView.getContext()).x, (int) ((((float) com.cyjh.common.util.a.a(elfinFloatView.getContext()).y) * f) - ((float) elfinFloatView.getHeight())));
            elfinFloatView.d.removeView(elfinFloatView.e);
            elfinFloatView.d.addView(elfinFloatView.e, 0);
            if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2) {
                imageView = elfinFloatView.f2043c;
                i3 = R.drawable.elfin_run1;
            } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
                imageView = elfinFloatView.f2043c;
                i3 = R.drawable.elfin_pause1;
            } else {
                imageView = elfinFloatView.f2043c;
                i3 = R.drawable.elfin_normal1;
            }
            imageView.setImageResource(i3);
        }

        public final void a(int i) {
            PrintStream printStream = System.out;
            printStream.println("onSetControlBarVisiable:" + i);
            b.a(i);
        }

        public final void a(int i, String str) {
            b bVar = b.this;
            if (i == 31) {
                try {
                    bVar.a(AppContext.a().getString(R.string.check_heartbeat_failed));
                } catch (Exception e) {
                    Log.e("zzz", "ElfinFreeActivity--initListener e:" + e.getMessage());
                    e.printStackTrace();
                    ag.b((Context) AppContext.a(), e.getMessage());
                }
            } else if (i == 32) {
                bVar.a(new JSONObject(str).getString(com.cyjh.elfin.a.b.d));
            } else if (i == 33) {
                bVar.a(AppContext.a().getString(R.string.no_get_heartbeat_time));
            } else if (i == 36) {
                ad.c(b.j, "initElf --> ENUM_SCRIPT_NEED_UPGRADE");
                com.cyjh.elfin.e.c.f.a();
                com.cyjh.elfin.e.c.f.a(AppContext.a(), "initElf --> ENUM_SCRIPT_NEED_UPGRADE");
                org.greenrobot.eventbus.c.a().c((Object) new MsgItem(2000));
            } else if (i == 34) {
                bVar.a(new JSONObject(str).getString(com.cyjh.elfin.a.b.d));
            } else if (i == 37) {
                com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 4;
            }
        }

        public final void a(String str) {
            ad.c(b.j, "launchApp --> packageName=" + str);
            Message obtainMessage = b.this.f2029c.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.obj = str;
            b.this.f2029c.sendMessage(obtainMessage);
        }

        public final void b() {
            b bVar = b.this;
            ad.c(b.j, "onStartScript");
            com.cyjh.elfin.floatingwindowprocess.service.a.a().a(4);
            com.cyjh.elfin.d.c a2 = com.cyjh.elfin.d.c.a();
            if (com.cyjh.elfin.d.c.d) {
                long currentTimeMillis = (a2.f1865b - (System.currentTimeMillis() / 1000)) / 60;
                if (currentTimeMillis > 0) {
                    AppContext a3 = AppContext.a();
                    ag.b((Context) a3, "注册码" + l.a(AppContext.a(), currentTimeMillis));
                }
            }
            com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 2;
            bVar.e = false;
            com.cyjh.elfin.e.c.f.a();
            com.cyjh.elfin.e.c.f.a(AppContext.a(), "AppContext  onStartScript --> ");
            a.a((com.cyjh.common.f.a<Boolean>) new com.cyjh.common.f.a<Boolean>() {
                private void a(Boolean bool) {
                    boolean unused = b.this.d = false;
                    b.this.e = bool.booleanValue();
                }

                public final void a() {
                    boolean unused = b.this.d = true;
                }

                public final /* synthetic */ void a(Object obj) {
                    boolean unused = b.this.d = false;
                    b.this.e = ((Boolean) obj).booleanValue();
                }
            });
            d.a();
            d.b();
            b.h();
            ad.c(b.j, "ddyStaticsJudgeOperate --> 1");
            com.cyjh.http.a.a.a();
            boolean b2 = com.cyjh.http.a.a.b();
            AppContext a4 = AppContext.a();
            ae.a((Context) a4, "是否是多多云环境：" + b2);
            ad.c(b.j, "ddyStaticsJudgeOperate --> 2 isDdyEnvironment=" + b2);
            if (b2) {
                com.cyjh.http.a.b.a().f2458b = new b.a() {
                    public final void a(Message message) {
                        ad.c(b.j, "ddyStaticsJudgeOperate --> 3");
                        b.this.f2029c.sendMessage(message);
                    }
                };
                com.cyjh.http.a.b a5 = com.cyjh.http.a.b.a();
                ad.a(com.cyjh.http.a.b.f2457a, "startTimer --> ");
                if (a5.f2459c == null) {
                    a5.f2459c = new Timer();
                    a5.d = new b.C0038b(a5, (byte) 0);
                }
                a5.f2459c.schedule(a5.d, 180000, 7200000);
            }
        }

        public final void b(int i) {
            AppContext a2;
            int i2;
            b bVar = b.this;
            if (ab.a().b(com.cyjh.elfin.a.a.y, (Boolean) true) && i == 114) {
                if (!x.a(AppContext.a())) {
                    a2 = AppContext.a();
                    i2 = R.string.network_off;
                } else if (AppContext.a().f) {
                    a2 = AppContext.a();
                    i2 = R.string.version_too_low;
                } else if (!AppContext.a().g) {
                    a2 = AppContext.a();
                    i2 = R.string.volume_run_script_tips;
                } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f2010b) {
                    a2 = AppContext.a();
                    i2 = R.string.volume_click_hips;
                } else {
                    com.cyjh.elfin.floatingwindowprocess.c.c.f2010b = true;
                    b.j();
                    if (!b.b()) {
                        com.cyjh.elfin.floatingwindowprocess.service.a a3 = com.cyjh.elfin.floatingwindowprocess.service.a.a();
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putInt(com.cyjh.elfin.e.b.a.f1892c, com.cyjh.elfin.e.b.a.n);
                        obtain.setData(bundle);
                        try {
                            a3.f2064b.send(obtain);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        b.d();
                        com.cyjh.elfin.floatingwindowprocess.c.c.f2010b = false;
                    }
                    bVar.f2029c.removeCallbacksAndMessages((Object) null);
                    bVar.f2029c.postDelayed(new Runnable() {
                        public final void run() {
                            com.cyjh.elfin.floatingwindowprocess.c.c.f2010b = false;
                        }
                    }, 3000);
                    return;
                }
                ag.a((Context) a2, i2);
            }
        }

        public final void b(int i, String str) {
            b bVar = b.this;
            ad.c(b.j, "onStopScript");
            com.cyjh.elfin.floatingwindowprocess.service.a.a().a(1);
            com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 1;
            com.cyjh.http.a.b.a().b();
            bVar.e = true;
            com.cyjh.elfin.e.c.f.a();
            AppContext a2 = AppContext.a();
            com.cyjh.elfin.e.c.f.a(a2, "AppContext  onStopScript --> returnCode=" + i + ",msg=" + str);
            AppContext a3 = AppContext.a();
            StringBuilder sb = new StringBuilder("callback code:");
            sb.append(i);
            String sb2 = sb.toString();
            try {
                File file = new File(com.cyjh.http.e.a.a((Context) a3), "heartbeatCheckFree.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                com.cyjh.http.e.a.a(file, sb2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(com.cyjh.http.b.a.a().f2477c.DeviceId) || TextUtils.isEmpty(com.cyjh.http.b.a.a().f2477c.DeviceCode)) {
                DeviceInfo c2 = com.cyjh.http.e.a.c(AppContext.a());
                com.cyjh.http.b.a.a().f2477c.DeviceId = c2.DeviceId;
                com.cyjh.http.b.a.a().f2477c.DeviceCode = c2.DeviceCode;
            }
            if (!bVar.d && ParamsWrap.getParamsWrap().mStartRunResponseInfo != null) {
                a.a((c.a) null);
            }
            d.a();
            d.b();
            b.h();
            if (i == 1003) {
                Toast.makeText(AppContext.a(), R.string.toast_run_no_permission, 0).show();
            } else if (i == 1002) {
                Log.d("zzz", "AppContext--onStopScript--MqmCode.MQM_RUNNER_EXCEPTION");
            }
            if (RestartScriptHelper.isNeedRestart().booleanValue()) {
                a.a((a.C0028a) null);
            }
        }

        public final void b(String str) {
            ad.c(b.j, "killApp --> packageName=" + str);
            c.a.f2893a.c().a(str, b.this.f2028b);
        }

        public final void c() {
            b bVar = b.this;
            Log.i("IPC_ANDROID", "onPause:" + com.cyjh.elfin.floatingwindowprocess.c.c.f().d + ",flag:" + bVar.f);
            if (4 == com.cyjh.elfin.floatingwindowprocess.c.c.f().d) {
                w.a(AppContext.a(), AppContext.a().getString(R.string.script_run_pausing));
                return;
            }
            com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 3;
            if (bVar.f) {
                b.h();
                bVar.f = false;
            }
        }

        public final void c(int i) {
            ad.c(b.j, "keyPress --> i=" + i);
            Intent intent = new Intent("_VA_" + b.this.f2027a);
            intent.putExtra(com.core.a.a.f1582a, 2);
            intent.putExtra(com.core.a.a.d, i);
            AppContext.a().sendBroadcast(intent);
        }

        public final void c(String str) {
            ad.c(b.j, "inputText --> s=" + str);
            Intent intent = new Intent("_VA_" + b.this.f2027a);
            intent.putExtra(com.core.a.a.f1582a, 1);
            intent.putExtra(com.core.a.a.e, str);
            AppContext.a().sendBroadcast(intent);
        }

        public final void d() {
            b bVar = b.this;
            com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 2;
            b.h();
            bVar.f = true;
        }

        public final void d(String str) {
            Script script;
            if (o.a() && (script = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a) != null) {
                r.a().a(AppContext.a(), script.getId(), str, new r.a() {
                    public final void a() {
                        ad.c(b.j, "doSpecialFuction --> uploadInstanceData onSuccess");
                    }

                    public final void a(String str) {
                        ad.c(b.j, "doSpecialFuction --> uploadInstanceData onFailure message=" + str);
                    }
                });
            }
        }

        public final void e() {
            b.g();
        }

        public final String f() {
            return b.this.f2027a;
        }

        public final String g() {
            return c.a.f2893a.c().b();
        }
    };
    private int k;

    private static void a(float f2, int i2, int i3) {
        ImageView imageView;
        int i4;
        h();
        ElfinFloatView elfinFloatView = com.cyjh.elfin.floatingwindowprocess.c.a.a().f2005a;
        String str = ElfinFloatView.f2041a;
        ad.c(str, "posControlBar --> position=" + f2 + ",lockState=" + i2 + ",isRight=" + i3);
        elfinFloatView.n = i2;
        if (elfinFloatView.n != 0) {
            elfinFloatView.f2043c.setOnTouchListener((View.OnTouchListener) null);
        }
        if (elfinFloatView.k.getVisibility() == 0) {
            elfinFloatView.k.setVisibility(8);
            elfinFloatView.k.a();
        }
        elfinFloatView.a(i3 == 0 ? 0 : com.cyjh.common.util.a.a(elfinFloatView.getContext()).x, (int) ((((float) com.cyjh.common.util.a.a(elfinFloatView.getContext()).y) * f2) - ((float) elfinFloatView.getHeight())));
        elfinFloatView.d.removeView(elfinFloatView.e);
        elfinFloatView.d.addView(elfinFloatView.e, 0);
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2) {
            imageView = elfinFloatView.f2043c;
            i4 = R.drawable.elfin_run1;
        } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
            imageView = elfinFloatView.f2043c;
            i4 = R.drawable.elfin_pause1;
        } else {
            imageView = elfinFloatView.f2043c;
            i4 = R.drawable.elfin_normal1;
        }
        imageView.setImageResource(i4);
    }

    public static void a(int i2) {
        com.cyjh.elfin.floatingwindowprocess.c.a.a().f2005a.setControlbarVisiable(i2);
    }

    private void a(int i2, String str) {
        ad.c(j, "onStopScript");
        com.cyjh.elfin.floatingwindowprocess.service.a.a().a(1);
        com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 1;
        com.cyjh.http.a.b.a().b();
        this.e = true;
        com.cyjh.elfin.e.c.f.a();
        AppContext a2 = AppContext.a();
        com.cyjh.elfin.e.c.f.a(a2, "AppContext  onStopScript --> returnCode=" + i2 + ",msg=" + str);
        AppContext a3 = AppContext.a();
        StringBuilder sb = new StringBuilder("callback code:");
        sb.append(i2);
        String sb2 = sb.toString();
        try {
            File file = new File(com.cyjh.http.e.a.a((Context) a3), "heartbeatCheckFree.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            com.cyjh.http.e.a.a(file, sb2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(com.cyjh.http.b.a.a().f2477c.DeviceId) || TextUtils.isEmpty(com.cyjh.http.b.a.a().f2477c.DeviceCode)) {
            DeviceInfo c2 = com.cyjh.http.e.a.c(AppContext.a());
            com.cyjh.http.b.a.a().f2477c.DeviceId = c2.DeviceId;
            com.cyjh.http.b.a.a().f2477c.DeviceCode = c2.DeviceCode;
        }
        if (!this.d && ParamsWrap.getParamsWrap().mStartRunResponseInfo != null) {
            a.a((c.a) null);
        }
        d.a();
        d.b();
        h();
        if (i2 == 1003) {
            Toast.makeText(AppContext.a(), R.string.toast_run_no_permission, 0).show();
        } else if (i2 == 1002) {
            Log.d("zzz", "AppContext--onStopScript--MqmCode.MQM_RUNNER_EXCEPTION");
        }
        if (RestartScriptHelper.isNeedRestart().booleanValue()) {
            a.a((a.C0028a) null);
        }
    }

    public static void a(Application application) {
        com.elfin.engin.c a2 = com.elfin.engin.c.a();
        EntryPoint.init(application, "", (AnalyseResult) null, 10, (byte) 0);
        a2.d = new com.elfin.engin.f();
        a2.f2902b = a2.d;
    }

    public static void a(String str, String str2, String str3) {
        com.elfin.engin.c a2 = com.elfin.engin.c.a();
        a2.f2902b.a(str, str2, str3, a2.j);
    }

    public static void a(String str, String str2, String str3, long j2, String str4, String str5, String str6) {
        com.elfin.engin.c a2 = com.elfin.engin.c.a();
        Script4Run script4Run = new Script4Run();
        script4Run.setLcPath(str);
        script4Run.setAtcPath(str2);
        script4Run.setConfigPath(str3);
        script4Run.setScriptEncryptKey(str4);
        script4Run.trialTime = 0;
        script4Run.encryptKey = j2;
        Log.e("zzz", "runScript--script4Run.scripyEncryptKey:" + script4Run.getScriptEncryptKey());
        script4Run.appId = str5;
        script4Run.username = str6;
        script4Run.encrypt = true;
        if (a2.f2902b != null) {
            a2.f2902b.a(script4Run);
        }
    }

    private static void a(String str, String str2, String str3, String str4) {
        com.elfin.engin.c a2 = com.elfin.engin.c.a();
        Script4Run script4Run = new Script4Run();
        script4Run.setLcPath(str);
        script4Run.setAtcPath(str2);
        script4Run.setConfigPath(str3);
        script4Run.setScriptEncryptKey(str4);
        if (a2.f2902b != null) {
            a2.f2902b.a(script4Run);
        }
    }

    private void b(int i2) {
        AppContext a2;
        int i3;
        if (ab.a().b(com.cyjh.elfin.a.a.y, (Boolean) true) && i2 == 114) {
            if (!x.a(AppContext.a())) {
                a2 = AppContext.a();
                i3 = R.string.network_off;
            } else if (AppContext.a().f) {
                a2 = AppContext.a();
                i3 = R.string.version_too_low;
            } else if (!AppContext.a().g) {
                a2 = AppContext.a();
                i3 = R.string.volume_run_script_tips;
            } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f2010b) {
                a2 = AppContext.a();
                i3 = R.string.volume_click_hips;
            } else {
                com.cyjh.elfin.floatingwindowprocess.c.c.f2010b = true;
                if (!com.elfin.engin.d.a()) {
                    com.cyjh.elfin.floatingwindowprocess.service.a a3 = com.cyjh.elfin.floatingwindowprocess.service.a.a();
                    Message obtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putInt(com.cyjh.elfin.e.b.a.f1892c, com.cyjh.elfin.e.b.a.n);
                    obtain.setData(bundle);
                    try {
                        a3.f2064b.send(obtain);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    d();
                    com.cyjh.elfin.floatingwindowprocess.c.c.f2010b = false;
                }
                this.f2029c.removeCallbacksAndMessages((Object) null);
                this.f2029c.postDelayed(new Runnable() {
                    public final void run() {
                        com.cyjh.elfin.floatingwindowprocess.c.c.f2010b = false;
                    }
                }, 3000);
                return;
            }
            ag.a((Context) a2, i3);
        }
    }

    private void b(int i2, String str) {
        if (i2 == 31) {
            try {
                a(AppContext.a().getString(R.string.check_heartbeat_failed));
            } catch (Exception e2) {
                Log.e("zzz", "ElfinFreeActivity--initListener e:" + e2.getMessage());
                e2.printStackTrace();
                ag.b((Context) AppContext.a(), e2.getMessage());
            }
        } else if (i2 == 32) {
            a(new JSONObject(str).getString(com.cyjh.elfin.a.b.d));
        } else if (i2 == 33) {
            a(AppContext.a().getString(R.string.no_get_heartbeat_time));
        } else if (i2 == 36) {
            ad.c(j, "initElf --> ENUM_SCRIPT_NEED_UPGRADE");
            com.cyjh.elfin.e.c.f.a();
            com.cyjh.elfin.e.c.f.a(AppContext.a(), "initElf --> ENUM_SCRIPT_NEED_UPGRADE");
            org.greenrobot.eventbus.c.a().c((Object) new MsgItem(2000));
        } else if (i2 == 34) {
            a(new JSONObject(str).getString(com.cyjh.elfin.a.b.d));
        } else if (i2 == 37) {
            com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 4;
        }
    }

    private void b(String str) {
        this.f2027a = str;
    }

    public static boolean b() {
        return com.elfin.engin.d.a();
    }

    public static void c() {
        com.elfin.engin.d.a(com.cyjh.elfin.d.c.a().b());
        com.cyjh.elfin.floatingwindowprocess.c.c.f().a();
        com.elfin.engin.c a2 = com.elfin.engin.c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a(a2.k);
            a2.f2902b.a().start();
        }
    }

    private void c(int i2) {
        this.f2028b = i2;
    }

    public static void d() {
        RestartScriptHelper.setNeedRestartValue(false);
        com.elfin.engin.c a2 = com.elfin.engin.c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a().stop();
        }
    }

    public static void e() {
        com.elfin.engin.c a2 = com.elfin.engin.c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a().pause();
        }
    }

    public static void f() {
        com.elfin.engin.c a2 = com.elfin.engin.c.a();
        if (a2.f2902b != null) {
            a2.f2902b.a().resume();
        }
    }

    public static void g() {
        com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 2;
    }

    static void h() {
        ImageView imageView;
        int i2;
        if (com.cyjh.elfin.floatingwindowprocess.c.a.a().f2005a != null) {
            com.cyjh.elfin.floatingwindowprocess.c.a.a().f2005a.a();
            ElfinFloatView elfinFloatView = com.cyjh.elfin.floatingwindowprocess.c.a.a().f2005a;
            if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 2) {
                imageView = elfinFloatView.f2043c;
                i2 = R.drawable.elfin_run1;
            } else if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 3) {
                imageView = elfinFloatView.f2043c;
                i2 = R.drawable.elfin_pause1;
            } else {
                imageView = elfinFloatView.f2043c;
                i2 = R.drawable.elfin_normal1;
            }
            imageView.setImageResource(i2);
            elfinFloatView.b();
            elfinFloatView.m.start();
        }
    }

    public static void i() {
    }

    public static b j() {
        return l;
    }

    private void k() {
        AppContext a2 = AppContext.a();
        String string = AppContext.a().getString(R.string.pay_appid);
        String string2 = AppContext.a().getString(R.string.pay_vsersion);
        e eVar = this.h;
        com.elfin.engin.c a3 = com.elfin.engin.c.a();
        a3.f = eVar;
        MqBridge.init(a2, string, string2, a3.g, new RootProgressListener(a2) {
            public final void onRootProgress(String str, int i) {
                if (i == 6) {
                    aj.INSTANCE.copyWebInjectFile(r7);
                }
            }
        }, a3.h);
        a3.f2902b.a(a3.k);
        com.elfin.engin.b bVar = a3.f2902b;
        bVar.a().setOnScriptListener(a3.i);
        Orcck.init();
    }

    private static void l() {
        if (!com.elfin.engin.d.a()) {
            com.cyjh.elfin.floatingwindowprocess.service.a a2 = com.cyjh.elfin.floatingwindowprocess.service.a.a();
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putInt(com.cyjh.elfin.e.b.a.f1892c, com.cyjh.elfin.e.b.a.n);
            obtain.setData(bundle);
            try {
                a2.f2064b.send(obtain);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            d();
            com.cyjh.elfin.floatingwindowprocess.c.c.f2010b = false;
        }
    }

    private void m() {
        ad.c(j, "onStartScript");
        com.cyjh.elfin.floatingwindowprocess.service.a.a().a(4);
        com.cyjh.elfin.d.c a2 = com.cyjh.elfin.d.c.a();
        if (com.cyjh.elfin.d.c.d) {
            long currentTimeMillis = (a2.f1865b - (System.currentTimeMillis() / 1000)) / 60;
            if (currentTimeMillis > 0) {
                AppContext a3 = AppContext.a();
                ag.b((Context) a3, "注册码" + l.a(AppContext.a(), currentTimeMillis));
            }
        }
        com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 2;
        this.e = false;
        com.cyjh.elfin.e.c.f.a();
        com.cyjh.elfin.e.c.f.a(AppContext.a(), "AppContext  onStartScript --> ");
        a.a((com.cyjh.common.f.a<Boolean>) new com.cyjh.common.f.a<Boolean>() {
            private void a(Boolean bool) {
                boolean unused = b.this.d = false;
                b.this.e = bool.booleanValue();
            }

            public final void a() {
                boolean unused = b.this.d = true;
            }

            public final /* synthetic */ void a(Object obj) {
                boolean unused = b.this.d = false;
                b.this.e = ((Boolean) obj).booleanValue();
            }
        });
        d.a();
        d.b();
        h();
        ad.c(j, "ddyStaticsJudgeOperate --> 1");
        com.cyjh.http.a.a.a();
        boolean b2 = com.cyjh.http.a.a.b();
        AppContext a4 = AppContext.a();
        ae.a((Context) a4, "是否是多多云环境：" + b2);
        ad.c(j, "ddyStaticsJudgeOperate --> 2 isDdyEnvironment=" + b2);
        if (b2) {
            com.cyjh.http.a.b.a().f2458b = new b.a() {
                public final void a(Message message) {
                    ad.c(b.j, "ddyStaticsJudgeOperate --> 3");
                    b.this.f2029c.sendMessage(message);
                }
            };
            com.cyjh.http.a.b a5 = com.cyjh.http.a.b.a();
            ad.a(com.cyjh.http.a.b.f2457a, "startTimer --> ");
            if (a5.f2459c == null) {
                a5.f2459c = new Timer();
                a5.d = new b.C0038b(a5, (byte) 0);
            }
            a5.f2459c.schedule(a5.d, 180000, 7200000);
        }
    }

    private void n() {
        ad.c(j, "ddyStaticsJudgeOperate --> 1");
        com.cyjh.http.a.a.a();
        boolean b2 = com.cyjh.http.a.a.b();
        AppContext a2 = AppContext.a();
        ae.a((Context) a2, "是否是多多云环境：" + b2);
        ad.c(j, "ddyStaticsJudgeOperate --> 2 isDdyEnvironment=" + b2);
        if (b2) {
            com.cyjh.http.a.b.a().f2458b = new b.a() {
                public final void a(Message message) {
                    ad.c(b.j, "ddyStaticsJudgeOperate --> 3");
                    b.this.f2029c.sendMessage(message);
                }
            };
            com.cyjh.http.a.b a3 = com.cyjh.http.a.b.a();
            ad.a(com.cyjh.http.a.b.f2457a, "startTimer --> ");
            if (a3.f2459c == null) {
                a3.f2459c = new Timer();
                a3.d = new b.C0038b(a3, (byte) 0);
            }
            a3.f2459c.schedule(a3.d, 180000, 7200000);
        }
    }

    private void o() {
        Log.i("IPC_ANDROID", "onPause:" + com.cyjh.elfin.floatingwindowprocess.c.c.f().d + ",flag:" + this.f);
        if (4 == com.cyjh.elfin.floatingwindowprocess.c.c.f().d) {
            w.a(AppContext.a(), AppContext.a().getString(R.string.script_run_pausing));
            return;
        }
        com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 3;
        if (this.f) {
            h();
            this.f = false;
        }
    }

    private void p() {
        com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 2;
        h();
        this.f = true;
    }

    private String q() {
        return this.f2027a;
    }

    private int r() {
        return this.f2028b;
    }

    private static void s() {
        if (com.elfin.engin.d.a()) {
            return;
        }
        if (com.core.util.a.a(AppContext.a(), "common_shared_file", com.core.a.c.f) == 0) {
            int a2 = com.core.util.a.a(AppContext.a(), com.core.a.c.h, com.core.a.c.j);
            int a3 = com.core.util.a.a(AppContext.a(), com.core.a.c.h, com.core.a.c.i);
            com.elfin.engin.d.a(true, com.core.util.a.a(AppContext.a(), com.core.a.c.h, com.core.a.c.l), com.core.util.a.a(AppContext.a(), com.core.a.c.h, com.core.a.c.k), a2, a3);
            return;
        }
        com.elfin.engin.d.a(false, 0, 0, 0, 0);
    }

    public final void a() {
        com.elfin.engin.b bVar;
        this.k = 0;
        com.elfin.engin.c a2 = com.elfin.engin.c.a();
        a2.f2903c = 0;
        if (a2.f2903c == 0) {
            if (a2.d == null) {
                a2.d = new com.elfin.engin.f();
            }
            bVar = a2.d;
        } else {
            if (a2.e == null) {
                a2.e = new g();
            }
            bVar = a2.e;
        }
        a2.f2902b = bVar;
        AppContext a3 = AppContext.a();
        String string = AppContext.a().getString(R.string.pay_appid);
        String string2 = AppContext.a().getString(R.string.pay_vsersion);
        e eVar = this.h;
        com.elfin.engin.c a4 = com.elfin.engin.c.a();
        a4.f = eVar;
        MqBridge.init(a3, string, string2, a4.g, new RootProgressListener(a3) {
            public final void onRootProgress(String str, int i) {
                if (i == 6) {
                    aj.INSTANCE.copyWebInjectFile(r7);
                }
            }
        }, a4.h);
        a4.f2902b.a(a4.k);
        com.elfin.engin.b bVar2 = a4.f2902b;
        bVar2.a().setOnScriptListener(a4.i);
        Orcck.init();
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        if (com.cyjh.elfin.ui.a.g.f2117a && !com.cyjh.elfin.ui.a.g.f2118c) {
            org.greenrobot.eventbus.c.a().c((Object) new MsgItem(1005));
        }
        if (!com.cyjh.elfin.ui.a.g.f2117a) {
            final com.cyjh.elfin.ui.a.g gVar = new com.cyjh.elfin.ui.a.g(AppContext.a(), true, str);
            gVar.f2119b = new View.OnClickListener() {
                public final void onClick(View view) {
                    gVar.dismiss();
                }
            };
            gVar.show();
            return;
        }
        org.greenrobot.eventbus.c.a().c((Object) new MsgItem.UpdateMessageToDialog(str));
    }
}
