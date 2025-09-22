package com.umeng.commonsdk.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.common.e;
import org.json.JSONObject;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3791a = "BatteryUtils";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3792b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Context f3793c;
    private BroadcastReceiver d;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final l f3795a = new l();

        private a() {
        }
    }

    private l() {
        this.d = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("le", intent.getIntExtra("level", 0));
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObject.put("vol", intent.getIntExtra("voltage", 0));
                        } catch (Exception unused2) {
                        }
                        try {
                            jSONObject.put("temp", intent.getIntExtra("temperature", 0));
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused3) {
                        }
                        int i = 2;
                        int i2 = -1;
                        switch (intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0)) {
                            case 2:
                                i2 = 1;
                                break;
                            case 4:
                                i2 = 0;
                                break;
                            case 5:
                                i2 = 2;
                                break;
                        }
                        try {
                            jSONObject.put("st", i2);
                        } catch (Exception unused4) {
                        }
                        switch (intent.getIntExtra("plugged", 0)) {
                            case 1:
                                i = 1;
                                break;
                            case 2:
                                break;
                            default:
                                i = 0;
                                break;
                        }
                        try {
                            jSONObject.put("ct", i);
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused5) {
                        }
                        e.a(l.f3791a, jSONObject.toString());
                        UMWorkDispatch.sendEvent(context, a.g, b.a(l.f3793c).a(), jSONObject.toString());
                        l.this.c();
                    }
                } catch (Throwable th) {
                    e.a(l.f3793c, th);
                }
            }
        };
    }

    public static l a(Context context) {
        if (f3793c == null && context != null) {
            f3793c = context.getApplicationContext();
        }
        return a.f3795a;
    }

    public synchronized boolean a() {
        return f3792b;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f3793c.registerReceiver(this.d, intentFilter);
            f3792b = true;
        } catch (Throwable th) {
            e.a(f3793c, th);
        }
    }

    public synchronized void c() {
        try {
            f3793c.unregisterReceiver(this.d);
            f3792b = false;
        } catch (Throwable th) {
            e.a(f3793c, th);
        }
    }
}
