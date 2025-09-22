package com.cyjh.mobileanjian.ipc;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.cyjh.mobileanjian.ipc.interfaces.OnRootApplyCallback;
import com.cyjh.mobileanjian.ipc.stuff.IntentActions;
import com.cyjh.mobileanjian.ipc.utils.RootUtil;
import com.cyjh.mobileanjian.ipc.view.ExToast;
import com.cyjh.mq.a.a;
import com.cyjh.mq.sdk.MqRunner;
import com.cyjh.mqsdk.R;
import com.goldcoast.sdk.domain.AnalyseResult;
import com.goldcoast.sdk.domain.EntryPoint;
import com.umeng.commonsdk.amap.UMAmapConfig;
import java.io.File;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2546a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2547b = 2;
    private static c g = null;
    private static final String j = "3rd.need.or.not.m";
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public Handler f2548c = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (a.i != null) {
                a.i.onRootProgress((String) message.obj, message.what);
            }
        }
    };
    /* access modifiers changed from: package-private */
    public boolean d = false;
    /* access modifiers changed from: package-private */
    public boolean e = false;
    /* access modifiers changed from: package-private */
    public boolean f = false;
    private boolean h = false;
    private int i;

    private c() {
    }

    static /* synthetic */ void a() {
        Intent intent = new Intent(IntentActions.TRY_ACTIVE_RUNNER);
        intent.putExtra(IntentActions.EXTRA_ACTIVITE_TYPE, "2");
        intent.putExtra(IntentActions.EXTRA_ACTIVE_RESULT, "0");
        LocalBroadcastManager.getInstance(a.g).sendBroadcast(intent);
    }

    private void a(int i2) {
        this.i = i2;
    }

    private void a(String str) {
        this.f2548c.obtainMessage(2, str).sendToTarget();
        this.f2548c.removeMessages(3);
    }

    private static void a(boolean z) {
        Intent intent = new Intent(IntentActions.TRY_ACTIVE_RUNNER);
        intent.putExtra(IntentActions.EXTRA_ACTIVITE_TYPE, "2");
        intent.putExtra(IntentActions.EXTRA_ACTIVE_RESULT, z ? "1" : "0");
        LocalBroadcastManager.getInstance(a.g).sendBroadcast(intent);
    }

    private static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (g == null) {
                g = new c();
            }
            cVar = g;
        }
        return cVar;
    }

    private void b(String str) {
        this.f2548c.obtainMessage(3, str).sendToTarget();
    }

    private boolean c() {
        return this.f && this.e;
    }

    private void d() {
        String str;
        Handler handler;
        Message obtainMessage;
        if (!this.h) {
            this.h = true;
            if (RootUtil.isRoot()) {
                d.a().a((OnRootApplyCallback) MqRunner.getInstance());
            } else {
                new StringBuilder("check EntryPoint ").append(EntryPoint.instance());
                if (!(EntryPoint.instance() == null || a.i == null)) {
                    if (this.d) {
                        Handler handler2 = this.f2548c;
                        obtainMessage = handler2.obtainMessage(1, "3rd root is going on now." + EntryPoint.class.getSimpleName());
                    } else {
                        final File file = new File(a.g.getFilesDir(), j);
                        if (!file.exists()) {
                            NetworkInfo activeNetworkInfo = ((ConnectivityManager) a.g.getSystemService("connectivity")).getActiveNetworkInfo();
                            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                                if (!this.f) {
                                    this.d = true;
                                    Handler handler3 = this.f2548c;
                                    handler3.obtainMessage(1, "Now start 3rd root using " + EntryPoint.class.getSimpleName()).sendToTarget();
                                    new Thread("third_root_request") {
                                        public final void run() {
                                            try {
                                                if (!r0.exists()) {
                                                    r0.createNewFile();
                                                }
                                                EntryPoint.instance().analyse(new AnalyseResult() {
                                                    public final void onException(String str) {
                                                        c.this.d = false;
                                                        if (!c.this.f) {
                                                            c.this.f2548c.obtainMessage(3, str).sendToTarget();
                                                        }
                                                        c.this.f = true;
                                                        c.a();
                                                    }

                                                    public final void onFailed(String str) {
                                                        c.this.d = false;
                                                        if (!c.this.f) {
                                                            c.this.f2548c.obtainMessage(3, str).sendToTarget();
                                                        }
                                                        c.this.f = true;
                                                        c.a();
                                                    }

                                                    public final void onProgress(String str) {
                                                    }

                                                    public final void onSuccess(String str) {
                                                        if (r0.exists()) {
                                                            r0.delete();
                                                        }
                                                        c.this.d = false;
                                                        c.this.f = true;
                                                        c.this.e = true;
                                                        EntryPoint.instance().exec(new String[]{"chmod 677 /dev/input/*", a.a().getAbsolutePath()});
                                                        c.this.f2548c.sendMessageDelayed(c.this.f2548c.obtainMessage(3, str), UMAmapConfig.AMAP_CACHE_WRITE_TIME);
                                                    }
                                                });
                                            } catch (Exception unused) {
                                                c.this.d = false;
                                                c.this.f = true;
                                                c.this.f2548c.obtainMessage(3, "Exception occurs when startThirdRoot()").sendToTarget();
                                            }
                                        }
                                    }.start();
                                } else if (this.e) {
                                    this.f2548c.post(new Runnable() {
                                        public final void run() {
                                            ExToast.makeText(a.g.getApplicationContext(), (CharSequence) a.g.getApplicationContext().getString(R.string.toast_script_engine_failed_start), (int) ExToast.LENGTH_LONG).show();
                                        }
                                    });
                                } else {
                                    handler = this.f2548c;
                                    str = "result";
                                    obtainMessage = handler.obtainMessage(5, str);
                                }
                            }
                        }
                        handler = this.f2548c;
                        str = "failed because mark file";
                        obtainMessage = handler.obtainMessage(5, str);
                    }
                    obtainMessage.sendToTarget();
                }
            }
            this.h = false;
        }
    }

    private void e() {
        if (this.d) {
            Handler handler = this.f2548c;
            handler.obtainMessage(1, "3rd root is going on now." + EntryPoint.class.getSimpleName()).sendToTarget();
            return;
        }
        final File file = new File(a.g.getFilesDir(), j);
        if (!file.exists()) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) a.g.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (!this.f) {
                    this.d = true;
                    Handler handler2 = this.f2548c;
                    handler2.obtainMessage(1, "Now start 3rd root using " + EntryPoint.class.getSimpleName()).sendToTarget();
                    new Thread("third_root_request") {
                        public final void run() {
                            try {
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                EntryPoint.instance().analyse(new AnalyseResult() {
                                    public final void onException(String str) {
                                        c.this.d = false;
                                        if (!c.this.f) {
                                            c.this.f2548c.obtainMessage(3, str).sendToTarget();
                                        }
                                        c.this.f = true;
                                        c.a();
                                    }

                                    public final void onFailed(String str) {
                                        c.this.d = false;
                                        if (!c.this.f) {
                                            c.this.f2548c.obtainMessage(3, str).sendToTarget();
                                        }
                                        c.this.f = true;
                                        c.a();
                                    }

                                    public final void onProgress(String str) {
                                    }

                                    public final void onSuccess(String str) {
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        c.this.d = false;
                                        c.this.f = true;
                                        c.this.e = true;
                                        EntryPoint.instance().exec(new String[]{"chmod 677 /dev/input/*", a.a().getAbsolutePath()});
                                        c.this.f2548c.sendMessageDelayed(c.this.f2548c.obtainMessage(3, str), UMAmapConfig.AMAP_CACHE_WRITE_TIME);
                                    }
                                });
                            } catch (Exception unused) {
                                c.this.d = false;
                                c.this.f = true;
                                c.this.f2548c.obtainMessage(3, "Exception occurs when startThirdRoot()").sendToTarget();
                            }
                        }
                    }.start();
                    return;
                } else if (this.e) {
                    this.f2548c.post(new Runnable() {
                        public final void run() {
                            ExToast.makeText(a.g.getApplicationContext(), (CharSequence) a.g.getApplicationContext().getString(R.string.toast_script_engine_failed_start), (int) ExToast.LENGTH_LONG).show();
                        }
                    });
                    return;
                } else {
                    this.f2548c.obtainMessage(5, "result").sendToTarget();
                    return;
                }
            }
        }
        this.f2548c.obtainMessage(5, "failed because mark file").sendToTarget();
    }
}
