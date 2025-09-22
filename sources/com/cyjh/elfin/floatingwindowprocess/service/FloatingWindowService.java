package com.cyjh.elfin.floatingwindowprocess.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.internal.view.SupportMenu;
import com.cyjh.elfin.floatingwindowprocess.c.a;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.elfin.floatingwindowprocess.d.b;
import com.ywfzjbcy.R;

public class FloatingWindowService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2058a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2059b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2060c = 8;
    public static final int d = 11;
    public static final int e = 102;
    public static final int f = 101;
    public static final int g = 201;
    public static final int h = 202;
    public static final String i = "script_service_key_bundle";
    public static final String j = "PARAM_V";
    public static final String k = "script_service_key_type";
    public static final String l = "script_service_key_encrypt_value";
    public static final int m = 0;
    public static final int n = 1;
    public static final String o = "PARAM_APP_2_DOMAIN_NAME";
    public static final String p = "PARAM_AUTH_KEYS";
    private static final String q = "FloatingWindowService";
    private final Handler r = new Handler();

    private void a() {
        Notification.Builder builder;
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            Resources resources = getResources();
            long currentTimeMillis = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("createRecordingNotification", "Channel1", 3);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
                notificationChannel.setShowBadge(true);
                notificationChannel.enableVibration(false);
                notificationChannel.setVibrationPattern(new long[]{0});
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                    builder = new Notification.Builder(this, "createRecordingNotification");
                } else {
                    builder = new Notification.Builder(this);
                }
            } else {
                builder = new Notification.Builder(this);
            }
            builder.setTicker(resources.getString(R.string.app_name));
            builder.setSmallIcon(R.drawable.ic_launcher);
            builder.setWhen(currentTimeMillis);
            Notification build = builder.build();
            build.icon = R.drawable.ic_launcher;
            build.flags = 2;
            build.flags |= 32;
            build.flags |= 64;
            startForeground(getResources().getInteger(R.integer.notification_id), build);
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    private static void b() {
        b.j();
        String e2 = c.f().e();
        c.f();
        String c2 = c.c();
        c.f();
        b.a(e2, c2, c.d());
    }

    private void c() {
        b();
        a.a().f2006b = this;
        c.f().b();
    }

    public IBinder onBind(Intent intent) {
        return a.a().f2063a.getBinder();
    }

    public void onCreate() {
        Notification.Builder builder;
        super.onCreate();
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            Resources resources = getResources();
            long currentTimeMillis = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("createRecordingNotification", "Channel1", 3);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
                notificationChannel.setShowBadge(true);
                notificationChannel.enableVibration(false);
                notificationChannel.setVibrationPattern(new long[]{0});
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                    builder = new Notification.Builder(this, "createRecordingNotification");
                } else {
                    builder = new Notification.Builder(this);
                }
            } else {
                builder = new Notification.Builder(this);
            }
            builder.setTicker(resources.getString(R.string.app_name));
            builder.setSmallIcon(R.drawable.ic_launcher);
            builder.setWhen(currentTimeMillis);
            Notification build = builder.build();
            build.icon = R.drawable.ic_launcher;
            build.flags = 2;
            build.flags |= 32;
            build.flags |= 64;
            startForeground(getResources().getInteger(R.integer.notification_id), build);
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0074, code lost:
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 0) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ef, code lost:
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 0) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f1, code lost:
        com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r5, int r6, int r7) {
        /*
            r4 = this;
            r6 = 0
            if (r5 == 0) goto L_0x000a
            java.lang.String r7 = "script_service_key"
            int r7 = r5.getIntExtra(r7, r6)
            goto L_0x000b
        L_0x000a:
            r7 = 0
        L_0x000b:
            r0 = 1
            switch(r7) {
                case 1: goto L_0x0143;
                case 2: goto L_0x00ff;
                case 3: goto L_0x00e2;
                case 8: goto L_0x00c9;
                case 9: goto L_0x0078;
                case 10: goto L_0x006e;
                case 11: goto L_0x0053;
                case 101: goto L_0x0032;
                case 102: goto L_0x002a;
                case 201: goto L_0x0021;
                case 202: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0153
        L_0x0011:
            java.lang.String r6 = "tokenKey"
            r0 = 0
            long r5 = r5.getLongExtra(r6, r0)
            com.cyjh.elfin.floatingwindowprocess.c.c r7 = com.cyjh.elfin.floatingwindowprocess.c.c.f()
            r7.e = r5
            goto L_0x0153
        L_0x0021:
            com.cyjh.elfin.d.c r5 = com.cyjh.elfin.d.c.a()
            r5.c()
            goto L_0x0153
        L_0x002a:
            com.cyjh.elfin.base.AppContext r5 = com.cyjh.elfin.base.AppContext.a()
            r5.g = r0
            goto L_0x0153
        L_0x0032:
            com.cyjh.elfin.floatingwindowprocess.c.a r5 = com.cyjh.elfin.floatingwindowprocess.c.a.a()
            com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r6 = r5.f2005a
            if (r6 == 0) goto L_0x0153
            com.cyjh.common.util.ab r6 = com.cyjh.common.util.ab.a()
            java.lang.String r7 = "com.cyjh.elfin.ui.activity.SettingActivity.swtFloatviewCtrl"
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r6 = r6.b((java.lang.String) r7, (java.lang.Boolean) r0)
            if (r6 != 0) goto L_0x0153
            com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r5 = r5.f2005a
            r6 = 8
            r5.setVisibility(r6)
            goto L_0x0153
        L_0x0053:
            com.cyjh.elfin.floatingwindowprocess.c.a r5 = com.cyjh.elfin.floatingwindowprocess.c.a.a()
            r5.b()
            com.cyjh.elfin.floatingwindowprocess.c.c r5 = com.cyjh.elfin.floatingwindowprocess.c.c.f()
            r5.d = r0
            android.os.Handler r5 = r4.r
            com.cyjh.elfin.floatingwindowprocess.service.FloatingWindowService$1 r6 = new com.cyjh.elfin.floatingwindowprocess.service.FloatingWindowService$1
            r6.<init>()
            r0 = 4250(0x109a, double:2.1E-320)
            r5.postDelayed(r6, r0)
            goto L_0x0153
        L_0x006e:
            com.cyjh.elfin.floatingwindowprocess.c.c r5 = com.cyjh.elfin.floatingwindowprocess.c.c.f()
            int r5 = r5.d
            if (r5 != 0) goto L_0x00f7
            goto L_0x00f1
        L_0x0078:
            com.cyjh.elfin.floatingwindowprocess.d.b.j()
            boolean r5 = com.cyjh.elfin.floatingwindowprocess.d.b.b()
            if (r5 != 0) goto L_0x0153
            com.cyjh.elfin.base.AppContext r5 = com.cyjh.elfin.base.AppContext.a()
            java.lang.String r7 = "common_shared_file"
            java.lang.String r1 = "type_resolution"
            int r5 = com.core.util.a.a(r5, r7, r1)
            if (r5 != 0) goto L_0x00c4
            com.cyjh.elfin.base.AppContext r5 = com.cyjh.elfin.base.AppContext.a()
            java.lang.String r6 = "app_share_comm_file"
            java.lang.String r7 = "AJXJL_DISY"
            int r5 = com.core.util.a.a(r5, r6, r7)
            com.cyjh.elfin.base.AppContext r6 = com.cyjh.elfin.base.AppContext.a()
            java.lang.String r7 = "app_share_comm_file"
            java.lang.String r1 = "AJXJL_DISX"
            int r6 = com.core.util.a.a(r6, r7, r1)
            com.cyjh.elfin.base.AppContext r7 = com.cyjh.elfin.base.AppContext.a()
            java.lang.String r1 = "app_share_comm_file"
            java.lang.String r2 = "screen_x_key"
            int r7 = com.core.util.a.a(r7, r1, r2)
            com.cyjh.elfin.base.AppContext r1 = com.cyjh.elfin.base.AppContext.a()
            java.lang.String r2 = "app_share_comm_file"
            java.lang.String r3 = "screen_y_key"
            int r1 = com.core.util.a.a(r1, r2, r3)
            com.elfin.engin.d.a(r0, r1, r7, r5, r6)
            goto L_0x0153
        L_0x00c4:
            com.elfin.engin.d.a(r6, r6, r6, r6, r6)
            goto L_0x0153
        L_0x00c9:
            java.lang.String r7 = "localGamePackage"
            java.lang.String r7 = r5.getStringExtra(r7)
            java.lang.String r0 = "userId"
            int r5 = r5.getIntExtra(r0, r6)
            com.cyjh.elfin.floatingwindowprocess.d.b r6 = com.cyjh.elfin.floatingwindowprocess.d.b.j()
            r6.f2027a = r7
            com.cyjh.elfin.floatingwindowprocess.d.b r6 = com.cyjh.elfin.floatingwindowprocess.d.b.j()
            r6.f2028b = r5
            goto L_0x0153
        L_0x00e2:
            java.lang.String r5 = "Service"
            java.lang.String r6 = "run no root"
            android.util.Log.d(r5, r6)
            com.cyjh.elfin.floatingwindowprocess.c.c r5 = com.cyjh.elfin.floatingwindowprocess.c.c.f()
            int r5 = r5.d
            if (r5 != 0) goto L_0x00f7
        L_0x00f1:
            com.cyjh.elfin.floatingwindowprocess.c.c r5 = com.cyjh.elfin.floatingwindowprocess.c.c.f()
            r5.d = r0
        L_0x00f7:
            com.cyjh.elfin.floatingwindowprocess.c.a r5 = com.cyjh.elfin.floatingwindowprocess.c.a.a()
            r5.b()
            goto L_0x0153
        L_0x00ff:
            java.lang.String r7 = "script_service_key_bundle"
            android.os.Bundle r5 = r5.getBundleExtra(r7)
            if (r5 == 0) goto L_0x0153
            java.lang.String r7 = "script_service_key_type"
            int r6 = r5.getInt(r7, r6)
            if (r6 != 0) goto L_0x012c
            java.lang.String r6 = "PARAM_APP_2_DOMAIN_NAME"
            java.lang.String r6 = r5.getString(r6)
            com.cyjh.common.a.a.c(r6)
            java.lang.String r6 = "PARAM_V"
            java.lang.String r6 = r5.getString(r6)
            com.cyjh.common.a.a.f1619b = r6
            java.lang.String r6 = "PARAM_AUTH_KEYS"
            java.lang.String[] r5 = r5.getStringArray(r6)
            com.cyjh.common.a.a.f1620c = r5
            b()
            goto L_0x0153
        L_0x012c:
            if (r6 != r0) goto L_0x0153
            java.io.PrintStream r6 = java.lang.System.out
            java.lang.String r7 = "SCRIPT_SERVICE_KEY_ENCRYPT"
            r6.println(r7)
            com.cyjh.elfin.entity.ParamsWrap r6 = com.cyjh.elfin.entity.ParamsWrap.getParamsWrap()
            java.lang.String r7 = "script_service_key_encrypt_value"
            java.lang.String r5 = r5.getString(r7)
            r6.setScriptEncryptKey(r5)
            goto L_0x0153
        L_0x0143:
            b()
            com.cyjh.elfin.floatingwindowprocess.c.a r5 = com.cyjh.elfin.floatingwindowprocess.c.a.a()
            r5.f2006b = r4
            com.cyjh.elfin.floatingwindowprocess.c.c r5 = com.cyjh.elfin.floatingwindowprocess.c.c.f()
            r5.b()
        L_0x0153:
            r5 = 2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.floatingwindowprocess.service.FloatingWindowService.onStartCommand(android.content.Intent, int, int):int");
    }
}
