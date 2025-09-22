package com.cyjh.elfin.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Environment;
import android.os.Process;
import android.os.Vibrator;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.toolbox.t;
import com.cyjh.common.util.ab;
import com.cyjh.common.util.af;
import com.cyjh.common.util.ah;
import com.cyjh.common.util.o;
import com.cyjh.common.util.toast.q;
import com.cyjh.elfin.a.a;
import com.cyjh.elfin.a.c;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.floatingwindowprocess.c.e;
import com.cyjh.elfin.floatingwindowprocess.d.b;
import com.cyjh.elfin.services.PhoneStateService;
import com.cyjh.http.a.d;
import com.elfin.engin.a.c;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.ywfzjbcy.R;
import java.io.File;
import org.litepal.f;

public class AppContext extends Application implements a {
    private static final String K = "AppContext";
    protected static AppContext d;
    private String L;
    private String M;

    /* renamed from: a  reason: collision with root package name */
    public String f1854a;

    /* renamed from: b  reason: collision with root package name */
    public String f1855b;

    /* renamed from: c  reason: collision with root package name */
    public String f1856c;
    public String e;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = true;
    public boolean j = false;
    public boolean k = false;
    public String l;
    public boolean m = false;

    public static AppContext a() {
        return d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[SYNTHETIC, Splitter:B:20:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d A[SYNTHETIC, Splitter:B:29:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(int r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.String r4 = "/proc/"
            r3.<init>(r4)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            r3.append(r5)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.String r5 = "/cmdline"
            r3.append(r5)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.String r5 = r3.toString()     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            r2.<init>(r5)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0039, all -> 0x0037 }
            java.lang.String r5 = r1.readLine()     // Catch:{ Throwable -> 0x0035 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x0035 }
            if (r2 != 0) goto L_0x002c
            java.lang.String r5 = r5.trim()     // Catch:{ Throwable -> 0x0035 }
        L_0x002c:
            r1.close()     // Catch:{ IOException -> 0x0030 }
            return r5
        L_0x0030:
            r0 = move-exception
            r0.printStackTrace()
            return r5
        L_0x0035:
            r5 = move-exception
            goto L_0x003b
        L_0x0037:
            r5 = move-exception
            goto L_0x004b
        L_0x0039:
            r5 = move-exception
            r1 = r0
        L_0x003b:
            r5.printStackTrace()     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0048
            r1.close()     // Catch:{ IOException -> 0x0044 }
            return r0
        L_0x0044:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0048:
            return r0
        L_0x0049:
            r5 = move-exception
            r0 = r1
        L_0x004b:
            if (r0 == 0) goto L_0x0055
            r0.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0055:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.base.AppContext.b(int):java.lang.String");
    }

    private void b() {
        this.L = b(Process.myPid());
        this.M = getPackageName();
        Log.i("TAG", "initProcess: " + this.M);
        if (getPackageName().equals(this.L)) {
            this.j = true;
        }
        if (this.L.endsWith(":enginfloat")) {
            this.k = true;
        }
    }

    private void c() {
        File file = new File(this.f1856c);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private void d() {
        a.a().a(this);
        System.loadLibrary("mqm");
        f.a((Context) this);
        com.cyjh.common.a.a.a(c.f, Long.parseLong(getResources().getString(R.string.elfin_appid)), getResources().getString(R.string.pay_vsersion), "6.1.1", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQ6aF1yXQM2dS6Wl5IUkpIAPadPpyt8qkhWSFw0OpmDxTPBOnnF/3V0HUbcu0E+xO542sbHX1PYZD1OStHBYOcvc2IuKa7dl/A/uywHZ4fVxSKXrge3MuvDZ6kefbJEcDaCLuc+TOtj7/HlDpblJE7sRVtCYxNQp0T3b3OokyDnwIDAQAB", "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJU0ITFmX5JkBA2GRHUpd1p+3rigbzwWPKY/6Ir2XlNW3v5WlTBsnj+GX1ReqsUxCysCb13b/g03ctrP4q2FY4KM1ENaAyDTGFdGDqezSEpEVkIRqxwxfmKhbQgV/9aoWRpgScy2Cclas688VL8U80iTzhNkAN8CS3NJEnD5o3MXAgMBAAECgYAh0Je5P29nmR1GB2kaeJRhQSGvDEVJg+yo7REB9YY5MxYE5JCZUfSnhwex8maXnF7gl4Ov7Pzt9+Qi7Tx9gR6lDhjl4w0nxPg7dXwyWGooCkk/JXAs3N3Z8Jdve8mORQLT4IkHrvrt4cahG+U9PZORQ6yww0+uIzRcri32I8rPOQJBAM4ri71N7bczshAx/dJBMG3BP5KKM4c/HpBJo56a8a87yDGbSxrftHV9NSQzll5XNq9nlKcsadgOK1zG8K1DoE0CQQC5Q99FpnL28KaykTn1OBxu402zam49caGu1lkfHOIaK7KKSlRPk2kdDBi9GjpdoCy5S4OL2yMo/WQB91oBUHLzAkEAqr6dqFXVvZfurEL6txqOBRe6kp4qNqQrp8uU2lHwPvP/xDWcadFDHtpnHGgs7EzGWVYrYpgBwJFbkCaiRJxxMQJAbffortonQYcFG9dyVKlyzytjMs1JFHW/qB0Zl4s4dppbhxSpyPZSHWjRwmWwIWTzRyWYtspjq3AFDdm59i+/mwJAJpafiQO32OOG4/T49uPNyXvkyLF+dk8tKNaSGqC/RM44ZbiI7EqkMXtDUwGIxyTKbOK1pvcYHLg7B3dAL/CeTQ==", getString(R.string.elfin_appinfo));
        com.cyjh.http.b.a.a().a(this);
        com.elfin.ad.a.a().a(this);
        g();
        f();
        com.cyjh.elfin.floatingwindowprocess.c.a.a().f2006b = this;
        com.cyjh.elfin.floatingwindowprocess.c.c.f().b();
        b.j().a();
        d.a().f2465a = this;
    }

    private void e() {
        a.a().a(this);
        System.loadLibrary("mqm");
        com.cyjh.common.a.a.a(c.f, Long.parseLong(getResources().getString(R.string.elfin_appid)), getResources().getString(R.string.pay_vsersion), "6.1.1", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQ6aF1yXQM2dS6Wl5IUkpIAPadPpyt8qkhWSFw0OpmDxTPBOnnF/3V0HUbcu0E+xO542sbHX1PYZD1OStHBYOcvc2IuKa7dl/A/uywHZ4fVxSKXrge3MuvDZ6kefbJEcDaCLuc+TOtj7/HlDpblJE7sRVtCYxNQp0T3b3OokyDnwIDAQAB", "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJU0ITFmX5JkBA2GRHUpd1p+3rigbzwWPKY/6Ir2XlNW3v5WlTBsnj+GX1ReqsUxCysCb13b/g03ctrP4q2FY4KM1ENaAyDTGFdGDqezSEpEVkIRqxwxfmKhbQgV/9aoWRpgScy2Cclas688VL8U80iTzhNkAN8CS3NJEnD5o3MXAgMBAAECgYAh0Je5P29nmR1GB2kaeJRhQSGvDEVJg+yo7REB9YY5MxYE5JCZUfSnhwex8maXnF7gl4Ov7Pzt9+Qi7Tx9gR6lDhjl4w0nxPg7dXwyWGooCkk/JXAs3N3Z8Jdve8mORQLT4IkHrvrt4cahG+U9PZORQ6yww0+uIzRcri32I8rPOQJBAM4ri71N7bczshAx/dJBMG3BP5KKM4c/HpBJo56a8a87yDGbSxrftHV9NSQzll5XNq9nlKcsadgOK1zG8K1DoE0CQQC5Q99FpnL28KaykTn1OBxu402zam49caGu1lkfHOIaK7KKSlRPk2kdDBi9GjpdoCy5S4OL2yMo/WQB91oBUHLzAkEAqr6dqFXVvZfurEL6txqOBRe6kp4qNqQrp8uU2lHwPvP/xDWcadFDHtpnHGgs7EzGWVYrYpgBwJFbkCaiRJxxMQJAbffortonQYcFG9dyVKlyzytjMs1JFHW/qB0Zl4s4dppbhxSpyPZSHWjRwmWwIWTzRyWYtspjq3AFDdm59i+/mwJAJpafiQO32OOG4/T49uPNyXvkyLF+dk8tKNaSGqC/RM44ZbiI7EqkMXtDUwGIxyTKbOK1pvcYHLg7B3dAL/CeTQ==", getString(R.string.elfin_appinfo));
        com.cyjh.http.b.a.a().a(this);
        com.elfin.ad.a.a().a(this);
        g();
        f();
        com.cyjh.elfin.floatingwindowprocess.c.a.a().f2006b = this;
        com.cyjh.elfin.floatingwindowprocess.c.c.f().b();
        b.j().a();
        d.a().f2465a = this;
    }

    private void f() {
        ab.a().f1648a = new ah(this);
        af.a().f1661a = getSharedPreferences(com.cyjh.elfin.a.b.f, 0);
        com.cyjh.http.d.b.c a2 = com.cyjh.http.d.b.c.a();
        if (a2.f2521b == null) {
            a2.f2521b = t.a(this);
        }
        ParamsWrap.getParamsWrap().init(this);
        this.f1854a = getFilesDir().getAbsolutePath();
        this.f1855b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f1856c = o.a(o.a(this.f1855b, getPackageName()), "log");
    }

    private void g() {
        UMConfigure.init(this, "579ad79de0f55a8b3c001633", "Umeng", 1, (String) null);
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.openActivityDurationTrack(false);
    }

    private void h() {
        File file = new File(this.f1856c);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private void i() {
        File file = new File(this.f1856c);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private void j() {
        startService(new Intent(this, PhoneStateService.class));
    }

    private void k() {
        MobclickAgent.onKillProcess(this);
    }

    public final void a(int i2) {
        Toast.makeText(this, i2, 0).show();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        d = this;
        this.L = b(Process.myPid());
        this.M = getPackageName();
        Log.i("TAG", "initProcess: " + this.M);
        if (getPackageName().equals(this.L)) {
            this.j = true;
        }
        if (this.L.endsWith(":enginfloat")) {
            this.k = true;
        }
        MultiDex.install(this);
        com.elfin.engin.a.c unused = c.a.f2893a;
        getPackageName();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (com.cyjh.elfin.floatingwindowprocess.c.a.a().f2005a != null) {
            com.cyjh.elfin.floatingwindowprocess.c.a.a().f2005a.c();
        }
        com.cyjh.elfin.floatingwindowprocess.c.b a2 = com.cyjh.elfin.floatingwindowprocess.c.b.a();
        int i2 = configuration.orientation;
        if (i2 == 2) {
            a2.f2008a = true;
            if (a2.f2009b != null) {
                a2.f2009b.a();
            }
        } else if (i2 == 1) {
            a2.f2008a = false;
            if (a2.f2009b != null) {
                a2.f2009b.b();
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        Log.i(K, "onCreate process: " + b(Process.myPid()));
        c.a.f2893a.a((Context) this);
        if (this.j) {
            a.a().a(this);
            System.loadLibrary("mqm");
            f.a((Context) this);
        } else if (this.k) {
            a.a().a(this);
            System.loadLibrary("mqm");
        } else {
            startService(new Intent(this, PhoneStateService.class));
            com.cyjh.elfin.floatingwindowprocess.b.a aVar = new com.cyjh.elfin.floatingwindowprocess.b.a(d);
            aVar.f2003b = new e(com.cyjh.elfin.floatingwindowprocess.c.d.a(), (Vibrator) getSystemService("vibrator"), aVar);
            b.j();
            b.a((Application) this);
            q.a(this);
        }
        com.cyjh.common.a.a.a(com.cyjh.elfin.a.c.f, Long.parseLong(getResources().getString(R.string.elfin_appid)), getResources().getString(R.string.pay_vsersion), "6.1.1", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQ6aF1yXQM2dS6Wl5IUkpIAPadPpyt8qkhWSFw0OpmDxTPBOnnF/3V0HUbcu0E+xO542sbHX1PYZD1OStHBYOcvc2IuKa7dl/A/uywHZ4fVxSKXrge3MuvDZ6kefbJEcDaCLuc+TOtj7/HlDpblJE7sRVtCYxNQp0T3b3OokyDnwIDAQAB", "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJU0ITFmX5JkBA2GRHUpd1p+3rigbzwWPKY/6Ir2XlNW3v5WlTBsnj+GX1ReqsUxCysCb13b/g03ctrP4q2FY4KM1ENaAyDTGFdGDqezSEpEVkIRqxwxfmKhbQgV/9aoWRpgScy2Cclas688VL8U80iTzhNkAN8CS3NJEnD5o3MXAgMBAAECgYAh0Je5P29nmR1GB2kaeJRhQSGvDEVJg+yo7REB9YY5MxYE5JCZUfSnhwex8maXnF7gl4Ov7Pzt9+Qi7Tx9gR6lDhjl4w0nxPg7dXwyWGooCkk/JXAs3N3Z8Jdve8mORQLT4IkHrvrt4cahG+U9PZORQ6yww0+uIzRcri32I8rPOQJBAM4ri71N7bczshAx/dJBMG3BP5KKM4c/HpBJo56a8a87yDGbSxrftHV9NSQzll5XNq9nlKcsadgOK1zG8K1DoE0CQQC5Q99FpnL28KaykTn1OBxu402zam49caGu1lkfHOIaK7KKSlRPk2kdDBi9GjpdoCy5S4OL2yMo/WQB91oBUHLzAkEAqr6dqFXVvZfurEL6txqOBRe6kp4qNqQrp8uU2lHwPvP/xDWcadFDHtpnHGgs7EzGWVYrYpgBwJFbkCaiRJxxMQJAbffortonQYcFG9dyVKlyzytjMs1JFHW/qB0Zl4s4dppbhxSpyPZSHWjRwmWwIWTzRyWYtspjq3AFDdm59i+/mwJAJpafiQO32OOG4/T49uPNyXvkyLF+dk8tKNaSGqC/RM44ZbiI7EqkMXtDUwGIxyTKbOK1pvcYHLg7B3dAL/CeTQ==", getString(R.string.elfin_appinfo));
        com.cyjh.http.b.a.a().a(this);
        com.elfin.ad.a.a().a(this);
        g();
        f();
        com.cyjh.elfin.floatingwindowprocess.c.a.a().f2006b = this;
        com.cyjh.elfin.floatingwindowprocess.c.c.f().b();
        b.j().a();
        d.a().f2465a = this;
        q.a(this);
    }

    public void onTerminate() {
        super.onTerminate();
        com.cyjh.http.a.b.a().b();
    }
}
