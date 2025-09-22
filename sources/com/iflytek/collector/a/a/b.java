package com.iflytek.collector.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iflytek.collector.device.IDeviceInfo;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f3492a;

    /* renamed from: b  reason: collision with root package name */
    private IDeviceInfo f3493b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f3494c;
    private volatile String d;
    private volatile boolean e;
    private volatile String f;

    private b(Context context) {
        boolean z;
        try {
            this.f3494c = context.getApplicationContext();
            this.f3493b = (IDeviceInfo) new DexClassLoader(c(), g(), (String) null, this.f3494c.getClassLoader()).loadClass("com.iflytek.collector.device.DeviceInfo").newInstance();
            new c(this).start();
            z = false;
        } catch (Throwable unused) {
            this.f3493b = null;
            z = true;
        }
        a(z);
    }

    public static b a(Context context) {
        if (f3492a == null) {
            synchronized (b.class) {
                if (f3492a == null) {
                    f3492a = new b(context);
                }
            }
        }
        return f3492a;
    }

    private static void a(File file) {
        if (file.isDirectory()) {
            for (File a2 : file.listFiles()) {
                a(a2);
            }
            file.delete();
            return;
        }
        file.delete();
    }

    private void a(boolean z) {
        try {
            if (!this.e) {
                new Thread(new d(this.f3494c, z)).start();
                this.e = true;
            }
        } catch (Throwable unused) {
        }
    }

    private void c(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i] != null) {
                    a(listFiles[i]);
                }
            }
        }
    }

    private String g() {
        String str = this.f3494c.getFilesDir().getAbsolutePath() + File.separator + "dex/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public JSONObject a() {
        try {
            if (this.f3493b != null) {
                return this.f3493b.getHeart(this.f3494c);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            SharedPreferences b2 = k.b(this.f3494c);
            if (b2 != null && !str.equals(b2.getString("appid", ""))) {
                SharedPreferences.Editor edit = b2.edit();
                edit.putString("appid", str);
                edit.apply();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String b() {
        try {
            return this.f3493b != null ? this.f3493b.getVersion() : "-1";
        } catch (Throwable unused) {
            return "-1";
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f = str;
            SharedPreferences b2 = k.b(this.f3494c);
            if (b2 != null) {
                if (!this.f.equals(b2.getString("subid", ""))) {
                    SharedPreferences.Editor edit = b2.edit();
                    edit.putString("subid", str);
                    edit.apply();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return (this.f3494c.getFilesDir().getAbsolutePath() + File.separator + "jar/") + "iflytek_device_info.zip";
    }

    /* access modifiers changed from: package-private */
    public void d() {
        String absolutePath = this.f3494c.getFilesDir().getAbsolutePath();
        c(absolutePath + File.separator + "jar/");
        c(absolutePath + File.separator + "dex/");
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.f;
    }
}
