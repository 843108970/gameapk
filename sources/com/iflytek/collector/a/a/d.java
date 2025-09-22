package com.iflytek.collector.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.didi.virtualapk.internal.Constants;
import com.hlzn.socketclient.b.a;
import com.iflytek.collector.a.a.g;
import com.iflytek.voiceads.config.SDKLogger;
import com.umeng.commonsdk.amap.UMAmapConfig;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected Context f3496a;

    /* renamed from: b  reason: collision with root package name */
    private g.a f3497b = new e(this);

    /* renamed from: c  reason: collision with root package name */
    private boolean f3498c;

    public d(Context context, boolean z) {
        this.f3496a = context;
        this.f3498c = z;
    }

    private void a() {
        try {
            SystemClock.sleep(UMAmapConfig.AMAP_CACHE_WRITE_TIME);
            if (b() && k.a(this.f3496a)) {
                g gVar = new g();
                gVar.b((int) a.r);
                gVar.a(1);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", b.a(this.f3496a).e());
                jSONObject.put("ver", b.a(this.f3496a).b());
                gVar.a("https://logconf.iflytek.com/hotupdate", (String) null, jSONObject.toString().getBytes("utf-8"));
                gVar.b(this.f3497b);
            }
        } catch (Exception unused) {
            SDKLogger.e("Collector", "exception occur while update dex");
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if ("yes".equalsIgnoreCase(jSONObject.optString("update"))) {
            String optString = jSONObject.optString(Constants.OPTIMIZE_DIR);
            if (!TextUtils.isEmpty(optString)) {
                a(Base64.decode(optString, 0));
            }
        } else {
            SDKLogger.d("Collector", "no need to update");
        }
        SharedPreferences.Editor edit = k.b(this.f3496a).edit();
        edit.putLong("last_check_time", System.currentTimeMillis());
        edit.apply();
    }

    private void a(byte[] bArr) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        b a2 = b.a(this.f3496a);
        a2.d();
        File file = new File(a2.c());
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (IOException e) {
                e = e;
                try {
                    e.printStackTrace();
                    a((Closeable) bufferedOutputStream2);
                    a((Closeable) fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    a((Closeable) bufferedOutputStream2);
                    a((Closeable) fileOutputStream);
                    throw th;
                }
            }
            try {
                bufferedOutputStream.write(bArr);
                a((Closeable) bufferedOutputStream);
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream2 = bufferedOutputStream;
                e.printStackTrace();
                a((Closeable) bufferedOutputStream2);
                a((Closeable) fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                a((Closeable) bufferedOutputStream2);
                a((Closeable) fileOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            e.printStackTrace();
            a((Closeable) bufferedOutputStream2);
            a((Closeable) fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            a((Closeable) bufferedOutputStream2);
            a((Closeable) fileOutputStream);
            throw th;
        }
        a((Closeable) fileOutputStream);
    }

    private boolean b() {
        SharedPreferences b2;
        if (this.f3498c || (b2 = k.b(this.f3496a)) == null) {
            return true;
        }
        return System.currentTimeMillis() - b2.getLong("last_check_time", 0) > 604800000;
    }

    public void run() {
        a();
    }
}
