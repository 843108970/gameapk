package mobi.oneway.export.e;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.delegate.RemoteContentProvider;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mobi.oneway.export.a.b;
import mobi.oneway.export.d.f;
import mobi.oneway.export.enums.PluginErrorType;
import mobi.oneway.export.f.c;
import mobi.oneway.export.f.d;
import mobi.oneway.export.f.g;
import mobi.oneway.export.g.h;
import mobi.oneway.export.g.n;
import mobi.oneway.export.g.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f4165a;

    /* renamed from: b  reason: collision with root package name */
    private PluginManager f4166b;

    /* renamed from: c  reason: collision with root package name */
    private g f4167c;
    private boolean d = false;
    /* access modifiers changed from: private */
    public CountDownLatch e;
    private final long f = 5000;
    private Timer g;
    private TimerTask h;

    public a(String str) {
        this.f4165a = str;
        this.e = new CountDownLatch(1);
        try {
            c();
            this.f4166b = PluginManager.getInstance(b.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String a(String str) {
        return b.a().getDir("plugin", 0).getPath() + File.separator + str;
    }

    private String a(JSONArray jSONArray, int i) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (i == jSONObject.optInt("adp")) {
                            return jSONObject.getString("appId");
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    private g a() {
        d();
        if (this.f4167c == null && !this.d) {
            this.d = true;
            ClassLoader a2 = mobi.oneway.export.b.a();
            if (a2 != null) {
                try {
                    Class<?> loadClass = a2.loadClass(mobi.oneway.export.a.a.l);
                    this.f4167c = new g();
                    this.f4167c.a((Class) loadClass);
                    this.f4167c.a(1);
                    this.f4167c.a(a2);
                    this.f4167c.b(b.b());
                } catch (Exception e2) {
                    c.a(PluginErrorType.shell_error_reflectClass, mobi.oneway.export.g.g.a((Throwable) e2));
                }
            }
        }
        e();
        return this.f4167c;
    }

    private g a(JSONObject jSONObject, JSONArray jSONArray) {
        return jSONObject.optInt("adp") == 1 ? a() : b(jSONObject, jSONArray);
    }

    private void a(JSONArray jSONArray) {
        d.a(jSONArray.toString());
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    d.a(new c(optJSONObject));
                }
            }
        }
    }

    private void a(JSONObject jSONObject) {
        mobi.oneway.export.b.a a2 = mobi.oneway.export.b.a.a();
        a2.a(jSONObject.optBoolean("cacheAd"));
        a2.a((long) jSONObject.optInt("reqExpireTime"));
    }

    private g b(JSONObject jSONObject, JSONArray jSONArray) {
        d();
        int optInt = jSONObject.optInt("adp");
        String optString = jSONObject.optString("apkpkg");
        String optString2 = jSONObject.optString("verison");
        String optString3 = jSONObject.optString("adcl");
        try {
            this.f4166b.loadPlugin(new File(a(optInt + ".apk")));
            ClassLoader classLoader = this.f4166b.getLoadedPlugin(optString).getClassLoader();
            Class<?> loadClass = classLoader.loadClass(optString3);
            String a2 = a(jSONArray, optInt);
            g gVar = new g();
            gVar.a(classLoader);
            gVar.a(optInt);
            gVar.a((Class) loadClass);
            gVar.a(optString2);
            gVar.a(System.currentTimeMillis());
            gVar.b(a2);
            return gVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            e();
            return null;
        }
    }

    private void b() {
        g a2 = a();
        if (a2 != null) {
            d.a(a2);
        }
        b.a().c();
    }

    private void c() {
        b.a().c(new Runnable() {
            public void run() {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        try {
                            int myPid = Process.myPid();
                            Context a2 = b.a();
                            String str = a2.getPackageName() + myPid;
                            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) a2.getSystemService("activity")).getRunningAppProcesses()) {
                                if (next.pid == myPid) {
                                    str = next.processName;
                                }
                            }
                            WebView.setDataDirectorySuffix(str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    new WebView(b.a());
                    if (a.this.e == null) {
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (a.this.e == null) {
                        return;
                    }
                } catch (Throwable th) {
                    if (a.this.e != null) {
                        a.this.e.countDown();
                    }
                    throw th;
                }
                a.this.e.countDown();
            }
        });
    }

    private void d() {
        e();
        this.h = new TimerTask() {
            public void run() {
                b.a().c();
            }
        };
        this.g = new Timer();
        this.g.schedule(this.h, 5000);
    }

    private void e() {
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
    }

    public void run() {
        String str;
        super.run();
        try {
            if (this.e != null) {
                this.e.await(5000, TimeUnit.MILLISECONDS);
            }
            JSONObject m = new f(mobi.oneway.export.a.a.f, mobi.oneway.export.a.a.f4099a).a("publishId", (Object) this.f4165a).a("shellVersion", (Object) mobi.oneway.export.a.f).a("dmd", (Object) Build.MODEL).a("dmk", (Object) Build.BRAND).a("ip", (Object) n.a(b.a())).a("osv", (Object) Build.VERSION.RELEASE).a("osl", (Object) Integer.valueOf(Build.VERSION.SDK_INT)).a("ts", (Object) Long.valueOf(System.currentTimeMillis())).a("osi", (Object) mobi.oneway.export.f.f.a()).a(RemoteContentProvider.KEY_PKG, (Object) b.a().getPackageName()).a("did", (Object) mobi.oneway.export.g.f.a()).a("aid", (Object) mobi.oneway.export.g.f.e()).m();
            boolean optBoolean = m.optBoolean("upgrade");
            boolean optBoolean2 = m.optBoolean("e");
            String optString = m.optString("appToken");
            String optString2 = m.optString("sc");
            JSONArray optJSONArray = m.optJSONArray("plugins");
            JSONArray optJSONArray2 = m.optJSONArray("appIdConfigs");
            JSONArray optJSONArray3 = m.optJSONArray("placements");
            b.b(optString);
            b.a(optBoolean2);
            b.c(optString2);
            if (optBoolean) {
                if (optJSONArray.length() != 0) {
                    a(optJSONArray3);
                    a(m);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        String optString3 = jSONObject.optString("hash");
                        int optInt = jSONObject.optInt("adp");
                        String optString4 = jSONObject.optString("url");
                        if (optInt == 1) {
                            str = mobi.oneway.export.a.a.j;
                        } else {
                            str = optInt + ".apk";
                        }
                        File file = new File(a(str));
                        String upperCase = h.e(file) ? p.a(file).toUpperCase() : null;
                        if (upperCase == null || !upperCase.equalsIgnoreCase(optString3)) {
                            byte[] l = new f(optString4).a(2000).l();
                            if (p.a(l).toUpperCase().equalsIgnoreCase(optString3)) {
                                h.a(file, l);
                            }
                        }
                        g a2 = a(jSONObject, optJSONArray2);
                        if (a2 != null) {
                            d.a(a2);
                        }
                    }
                    b.a().c();
                    return;
                }
            }
            b();
        } catch (IOException e2) {
            e2.printStackTrace();
            b();
        } catch (JSONException e3) {
            e3.printStackTrace();
            b();
        } catch (Exception e4) {
            e4.printStackTrace();
            b();
        }
    }
}
