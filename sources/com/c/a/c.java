package com.c.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.umeng.analytics.pro.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;
import org.litepal.g.b;

public final class c extends a {
    public static final String e = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
    private static final String i = "https://graph.facebook.com/oauth/authorize";
    private static final String j = "https://www.facebook.com/connect/login_success.html";
    private static final String k = "fbconnect:cancel";
    private static final String n = "aq.fb.token";
    private static final String o = "aq.fb.permission";
    private static Boolean p;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f1517a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public String f1518b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public String f1519c;
    /* access modifiers changed from: package-private */
    public boolean d;
    private String f;
    private com.c.c g;
    private String h;
    private boolean l;
    private int m;

    private class a extends WebViewClient implements DialogInterface.OnCancelListener {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        private boolean a(String str) {
            if (str.startsWith(c.j)) {
                String string = c.c(str).getString("error_reason");
                com.c.d.a.b((Object) b.J, (Object) string);
                if (string == null) {
                    c cVar = c.this;
                    String queryParameter = Uri.parse(str.replace('#', '?')).getQueryParameter("access_token");
                    com.c.d.a.b((Object) "token", (Object) queryParameter);
                    cVar.f1518b = queryParameter;
                }
                if (c.this.f1518b != null) {
                    c.this.d();
                    c.this.a(c.this.f1518b, c.this.f1519c);
                    c.this.d = false;
                    c.this.a((Context) c.this.f1517a);
                    return true;
                }
                c.this.e("cancel");
                return true;
            } else if (!str.startsWith(c.k)) {
                return false;
            } else {
                com.c.d.a.a((Object) "cancelled");
                c.this.e("cancel");
                return true;
            }
        }

        public final void onCancel(DialogInterface dialogInterface) {
            c.this.e("cancel");
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c.this.e();
            com.c.d.a.b((Object) "finished", (Object) str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            com.c.d.a.b((Object) "started", (Object) str);
            if (!a(str)) {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            c.this.e("cancel");
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.c.d.a.a((Object) "return url: " + str);
            return a(str);
        }
    }

    private c(Activity activity, String str, String str2) {
        this(activity, str, str2, (byte) 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private c(android.app.Activity r4, java.lang.String r5, java.lang.String r6, byte r7) {
        /*
            r3 = this;
            r3.<init>()
            r3.f = r5
            r3.f1517a = r4
            r3.f1519c = r6
            r4 = 0
            r3.f1518b = r4
            java.lang.String r5 = r3.f1518b
            r7 = 0
            r0 = 1
            if (r5 != 0) goto L_0x0062
            android.app.Activity r5 = r3.f1517a
            android.content.SharedPreferences r5 = android.preference.PreferenceManager.getDefaultSharedPreferences(r5)
            java.lang.String r1 = "aq.fb.permission"
            java.lang.String r5 = r5.getString(r1, r4)
            if (r6 != 0) goto L_0x0022
        L_0x0020:
            r5 = 1
            goto L_0x004e
        L_0x0022:
            if (r5 != 0) goto L_0x0026
        L_0x0024:
            r5 = 0
            goto L_0x004e
        L_0x0026:
            java.lang.String r1 = "[,\\s]+"
            java.lang.String[] r5 = r5.split(r1)
            java.util.HashSet r1 = new java.util.HashSet
            java.util.List r5 = java.util.Arrays.asList(r5)
            r1.<init>(r5)
            java.lang.String r5 = "[,\\s]+"
            java.lang.String[] r5 = r6.split(r5)
            r6 = 0
        L_0x003c:
            int r2 = r5.length
            if (r6 < r2) goto L_0x0040
            goto L_0x0020
        L_0x0040:
            r2 = r5[r6]
            boolean r2 = r1.contains(r2)
            if (r2 != 0) goto L_0x005f
            java.lang.String r5 = "perm mismatch"
            com.c.d.a.a((java.lang.Object) r5)
            goto L_0x0024
        L_0x004e:
            if (r5 == 0) goto L_0x0062
            android.app.Activity r5 = r3.f1517a
            android.content.SharedPreferences r5 = android.preference.PreferenceManager.getDefaultSharedPreferences(r5)
            java.lang.String r6 = "aq.fb.token"
            java.lang.String r4 = r5.getString(r6, r4)
            r3.f1518b = r4
            goto L_0x0062
        L_0x005f:
            int r6 = r6 + 1
            goto L_0x003c
        L_0x0062:
            java.lang.String r4 = r3.f1518b
            if (r4 != 0) goto L_0x0067
            r7 = 1
        L_0x0067:
            r3.d = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.<init>(android.app.Activity, java.lang.String, java.lang.String, byte):void");
    }

    private c a(int i2) {
        this.l = true;
        this.m = i2;
        return this;
    }

    private static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(String.valueOf(str) + "=" + bundle.getString(str));
        }
        return sb.toString();
    }

    private void a(int i2, Intent intent) {
        com.c.d.a.b((Object) "on result", (Object) Integer.valueOf(i2));
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra(b.J);
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra != null) {
                com.c.d.a.b((Object) b.J, (Object) stringExtra);
                if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                    j();
                    return;
                }
                String stringExtra2 = intent.getStringExtra("error_description");
                com.c.d.a.b((Object) "fb error", (Object) stringExtra2);
                Log.e("fb error", stringExtra2);
                e(stringExtra2);
                return;
            }
            this.f1518b = intent.getStringExtra("access_token");
            com.c.d.a.b((Object) "onComplete", (Object) this.f1518b);
            if (this.f1518b != null) {
                a(this.f1518b, this.f1519c);
                this.d = false;
                a((Context) this.f1517a);
                return;
            }
            e("cancel");
        } else if (i2 == 0) {
            e("cancel");
        }
    }

    private void a(com.c.b.b<JSONObject> bVar) {
        ((com.c.a) new com.c.a(this.f1517a).a((a) this)).a("https://graph.facebook.com/me", JSONObject.class, bVar);
    }

    private static boolean a(Activity activity, String str, String str2, int i2) {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", str);
        if (str2 != null) {
            intent.putExtra("scope", str2);
        }
        if (!a((Context) activity, intent)) {
            return false;
        }
        try {
            activity.startActivityForResult(intent, i2);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private static boolean a(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            for (Signature charsString : packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures) {
                if (charsString.toCharsString().equals(e)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private c b(int i2) {
        this.h = this.f1517a.getString(i2);
        return this;
    }

    private static String b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(n, (String) null);
    }

    private void b(com.c.b.b<JSONObject> bVar) {
        ((com.c.a) new com.c.a(this.f1517a).a((a) this)).a("https://graph.facebook.com/me", JSONObject.class, bVar);
    }

    private static boolean b(String str, String str2) {
        if (str == null) {
            return true;
        }
        if (str2 == null) {
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(str2.split("[,\\s]+")));
        String[] split = str.split("[,\\s]+");
        for (String contains : split) {
            if (!hashSet.contains(contains)) {
                com.c.d.a.a((Object) "perm mismatch");
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public static Bundle c(String str) {
        try {
            URL url = new URL(str);
            Bundle g2 = g(url.getQuery());
            g2.putAll(g(url.getRef()));
            return g2;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    private c d(String str) {
        this.h = str;
        return this;
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        d();
        a((int) com.c.b.c.g, str);
    }

    private String f() {
        return this.f1518b;
    }

    private static String f(String str) {
        String queryParameter = Uri.parse(str.replace('#', '?')).getQueryParameter("access_token");
        com.c.d.a.b((Object) "token", (Object) queryParameter);
        return queryParameter;
    }

    private static Bundle g(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        for (String split : str.split("&")) {
            String[] split2 = split.split("=");
            bundle.putString(split2[0], split2[1]);
        }
        return bundle;
    }

    private void g() {
        if (this.g != null) {
            try {
                this.g.hide();
            } catch (Exception e2) {
                com.c.d.a.a((Throwable) e2);
            }
        }
    }

    private void h() {
        e("cancel");
    }

    private static /* synthetic */ String i(String str) {
        String queryParameter = Uri.parse(str.replace('#', '?')).getQueryParameter("access_token");
        com.c.d.a.b((Object) "token", (Object) queryParameter);
        return queryParameter;
    }

    private boolean i() {
        if (!this.l) {
            return false;
        }
        return a(this.f1517a, this.f, this.f1519c, this.m);
    }

    private void j() {
        com.c.d.a.a((Object) "web auth");
        Bundle bundle = new Bundle();
        bundle.putString("client_id", this.f);
        bundle.putString(b.c.f4839c, "user_agent");
        if (this.f1519c != null) {
            bundle.putString("scope", this.f1519c);
        }
        bundle.putString("redirect_uri", j);
        a aVar = new a(this, (byte) 0);
        this.g = new com.c.c(this.f1517a, "https://graph.facebook.com/oauth/authorize?" + a(bundle), aVar);
        this.g.f1550a = this.h;
        this.g.setOnCancelListener(aVar);
        e();
        if (!this.d || this.f1518b != null) {
            com.c.d.a.a((Object) "auth hide");
            if (this.g != null) {
                try {
                    this.g.hide();
                } catch (Exception e2) {
                    com.c.d.a.a((Throwable) e2);
                }
            }
        }
        this.g.a();
        com.c.d.a.a((Object) "auth started");
    }

    private String k() {
        return PreferenceManager.getDefaultSharedPreferences(this.f1517a).getString(n, (String) null);
    }

    private String l() {
        return PreferenceManager.getDefaultSharedPreferences(this.f1517a).getString(o, (String) null);
    }

    private boolean m() {
        if (p == null) {
            Intent intent = new Intent();
            intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
            p = Boolean.valueOf(a((Context) this.f1517a, intent));
        }
        return p.booleanValue();
    }

    private static void n() {
    }

    public final String a(String str) {
        StringBuilder sb;
        String str2;
        if (str.indexOf(63) == -1) {
            sb = new StringBuilder(String.valueOf(str));
            str2 = "?";
        } else {
            sb = new StringBuilder(String.valueOf(str));
            str2 = "&";
        }
        sb.append(str2);
        return String.valueOf(sb.toString()) + "access_token=" + this.f1518b;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f1517a).edit();
        edit.putString(n, str).putString(o, str2);
        com.c.d.a.a(edit);
    }

    public final boolean a() {
        return this.f1518b != null;
    }

    public final boolean a(com.c.b.a<?, ?> aVar, com.c.b.c cVar) {
        int i2 = cVar.i;
        if (i2 == 200) {
            return false;
        }
        String str = cVar.w;
        if (str == null || !str.contains("OAuthException")) {
            String str2 = aVar.f1539c;
            if (i2 == 400 && (str2.endsWith("/likes") || str2.endsWith("/comments") || str2.endsWith("/checkins"))) {
                return false;
            }
            if (i2 != 403 || (!str2.endsWith("/feed") && !str2.contains("method=delete"))) {
                return i2 == 400 || i2 == 401 || i2 == 403;
            }
            return false;
        }
        com.c.d.a.a((Object) "fb token expired");
        return true;
    }

    public final String b(String str) {
        return a(str);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (!this.f1517a.isFinishing()) {
            boolean a2 = !this.l ? false : a(this.f1517a, this.f, this.f1519c, this.m);
            com.c.d.a.b((Object) "authing", (Object) Boolean.valueOf(a2));
            if (!a2) {
                j();
            }
        }
    }

    public final boolean b(final com.c.b.a<?, ?> aVar) {
        com.c.d.a.a((Object) "reauth requested");
        this.f1518b = null;
        com.c.d.a.a((Runnable) new Runnable() {
            public final void run() {
                c.this.a((com.c.b.a<?, ?>) aVar);
            }
        });
        return false;
    }

    public final void c() {
        this.f1518b = null;
        CookieSyncManager.createInstance(this.f1517a);
        CookieManager.getInstance().removeAllCookie();
        a((String) null, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        if (this.g != null) {
            new com.c.a(this.f1517a).b((Dialog) this.g);
            this.g = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (this.g != null) {
            new com.c.a(this.f1517a).a((Dialog) this.g);
        }
    }
}
