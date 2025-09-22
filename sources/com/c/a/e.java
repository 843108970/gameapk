package com.c.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import java.net.HttpURLConnection;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import org.apache.http.HttpRequest;

public final class e extends a {
    private static final String g = "https://api.twitter.com/oauth/request_token";
    private static final String h = "https://api.twitter.com/oauth/access_token";
    private static final String i = "https://api.twitter.com/oauth/authorize";
    private static final String j = "twitter://callback";
    private static final String k = "twitter://cancel";
    private static final String l = "aq.tw.token";
    private static final String m = "aq.tw.secret";
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f1527a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public com.c.c f1528b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public CommonsHttpOAuthConsumer f1529c;
    /* access modifiers changed from: package-private */
    public CommonsHttpOAuthProvider d;
    /* access modifiers changed from: package-private */
    public String e = c(l);
    /* access modifiers changed from: package-private */
    public String f = c(m);

    private class a extends AsyncTask<String, String, String> implements DialogInterface.OnCancelListener, Runnable {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public com.c.b.a<?, ?> f1531b;

        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        private String a() {
            try {
                return e.this.d.retrieveRequestToken(e.this.f1529c, e.j);
            } catch (Exception e) {
                com.c.d.a.b((Throwable) e);
                return null;
            }
        }

        private void a(String str) {
            if (str != null) {
                e.this.f1528b = new com.c.c(e.this.f1527a, str, new c(e.this, (byte) 0));
                e.this.f1528b.setOnCancelListener(this);
                e.a(e.this);
                e.this.f1528b.a();
                return;
            }
            e.b(e.this);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object... objArr) {
            return a();
        }

        public final void onCancel(DialogInterface dialogInterface) {
            e.b(e.this);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (str != null) {
                e.this.f1528b = new com.c.c(e.this.f1527a, str, new c(e.this, (byte) 0));
                e.this.f1528b.setOnCancelListener(this);
                e.a(e.this);
                e.this.f1528b.a();
                return;
            }
            e.b(e.this);
        }

        public final void run() {
            e.this.a(this.f1531b);
        }
    }

    private class b extends AsyncTask<String, String, String> {
        private b() {
        }

        /* synthetic */ b(e eVar, byte b2) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            try {
                e.this.d.retrieveAccessToken(e.this.f1529c, strArr[0]);
                return "";
            } catch (Exception e) {
                com.c.d.a.b((Throwable) e);
                return null;
            }
        }

        private void a(String str) {
            if (str != null) {
                e.this.e = e.this.f1529c.getToken();
                e.this.f = e.this.f1529c.getTokenSecret();
                com.c.d.a.b((Object) "token", (Object) e.this.e);
                com.c.d.a.b((Object) "secret", (Object) e.this.f);
                e.this.a(e.l, e.this.e, e.m, e.this.f);
                e.this.d();
                e.this.a((Context) e.this.f1527a);
                return;
            }
            e.b(e.this);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            if (((String) obj) != null) {
                e.this.e = e.this.f1529c.getToken();
                e.this.f = e.this.f1529c.getTokenSecret();
                com.c.d.a.b((Object) "token", (Object) e.this.e);
                com.c.d.a.b((Object) "secret", (Object) e.this.f);
                e.this.a(e.l, e.this.e, e.m, e.this.f);
                e.this.d();
                e.this.a((Context) e.this.f1527a);
                return;
            }
            e.b(e.this);
        }
    }

    private class c extends WebViewClient {
        private c() {
        }

        /* synthetic */ c(e eVar, byte b2) {
            this();
        }

        private boolean a(String str) {
            if (str.startsWith(e.j)) {
                String queryParameter = Uri.parse(str).getQueryParameter("oauth_verifier");
                e.this.d();
                new b(e.this, (byte) 0).execute(new String[]{queryParameter});
                return true;
            } else if (!str.startsWith(e.k)) {
                return false;
            } else {
                e.b(e.this);
                return true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            com.c.d.a.b((Object) "finished", (Object) str);
            super.onPageFinished(webView, str);
            e.a(e.this);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            com.c.d.a.b((Object) "started", (Object) str);
            if (!a(str)) {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            e.b(e.this);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(str);
        }
    }

    private e(Activity activity, String str, String str2) {
        this.f1527a = activity;
        this.f1529c = new CommonsHttpOAuthConsumer(str, str2);
        if (!(this.e == null || this.f == null)) {
            this.f1529c.setTokenWithSecret(this.e, this.f);
        }
        this.d = new CommonsHttpOAuthProvider(g, h, i);
    }

    private static String a(String str, String str2) {
        return Uri.parse(str).getQueryParameter(str2);
    }

    static /* synthetic */ void a(e eVar) {
        if (eVar.f1528b != null) {
            new com.c.a(eVar.f1527a).a((Dialog) eVar.f1528b);
        }
    }

    private void a(boolean z) {
        if (z || this.e == null || this.f == null) {
            b();
        }
    }

    static /* synthetic */ void b(e eVar) {
        eVar.d();
        eVar.a((int) UiMessage.CommandToUi.Command_Type.GET_ENABLED_VALUE, "cancel");
    }

    private String c(String str) {
        return PreferenceManager.getDefaultSharedPreferences(this.f1527a).getString(str, (String) null);
    }

    private String e() {
        return this.e;
    }

    private String f() {
        return this.f;
    }

    private void g() {
        if (this.f1528b != null) {
            new com.c.a(this.f1527a).a((Dialog) this.f1528b);
        }
    }

    private void h() {
        d();
        a((int) UiMessage.CommandToUi.Command_Type.GET_ENABLED_VALUE, "cancel");
    }

    private static void i() {
    }

    public final void a(com.c.b.a<?, ?> aVar, HttpURLConnection httpURLConnection) {
        com.c.d.a.b((Object) "apply token multipart", (Object) aVar.f1539c);
        DefaultOAuthConsumer defaultOAuthConsumer = new DefaultOAuthConsumer(this.f1529c.getConsumerKey(), this.f1529c.getConsumerSecret());
        defaultOAuthConsumer.setTokenWithSecret(this.f1529c.getToken(), this.f1529c.getTokenSecret());
        try {
            defaultOAuthConsumer.sign(httpURLConnection);
        } catch (Exception e2) {
            com.c.d.a.b((Throwable) e2);
        }
    }

    public final void a(com.c.b.a<?, ?> aVar, HttpRequest httpRequest) {
        com.c.d.a.b((Object) "apply token", (Object) aVar.f1539c);
        try {
            this.f1529c.sign(httpRequest);
        } catch (Exception e2) {
            com.c.d.a.b((Throwable) e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2, String str3, String str4) {
        PreferenceManager.getDefaultSharedPreferences(this.f1527a).edit().putString(str, str2).putString(str3, str4).commit();
    }

    public final boolean a() {
        return (this.e == null || this.f == null) ? false : true;
    }

    public final boolean a(com.c.b.a<?, ?> aVar, com.c.b.c cVar) {
        int i2 = cVar.i;
        return i2 == 400 || i2 == 401;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        new a(this, (byte) 0).execute(new String[0]);
    }

    public final boolean b(com.c.b.a<?, ?> aVar) {
        this.e = null;
        this.f = null;
        a(l, (String) null, m, (String) null);
        new a(this, (byte) 0).f1531b = aVar;
        com.c.d.a.a((Runnable) aVar);
        return false;
    }

    public final void c() {
        this.e = null;
        this.f = null;
        CookieSyncManager.createInstance(this.f1527a);
        CookieManager.getInstance().removeAllCookie();
        a(l, (String) null, m, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        if (this.f1528b != null) {
            new com.c.a(this.f1527a).b((Dialog) this.f1528b);
            this.f1528b = null;
        }
    }
}
