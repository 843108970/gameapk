package com.c.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Picture;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public final class h extends WebViewClient {
    private static String g = null;
    private static final String h = "WebViewSettings";
    private static final String i = "double_tap_toast_count";

    /* renamed from: a  reason: collision with root package name */
    public Object f1577a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f1578b;

    /* renamed from: c  reason: collision with root package name */
    public String f1579c;
    public boolean d = true;
    public boolean e = false;
    public int f = -16777216;

    public h(WebView webView, String str, Object obj) {
        this.f1578b = webView;
        this.f1579c = str;
        this.f1577a = obj;
    }

    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(h, 0);
        if (sharedPreferences.getInt(i, 1) > 0) {
            sharedPreferences.edit().putInt(i, 0).commit();
        }
    }

    public static void a(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            a.a((Object) webView.getSettings(), "setDisplayZoomControls", false, false, (Class<?>[]) new Class[]{Boolean.TYPE}, false);
        }
    }

    private static String b(Context context) {
        if (g == null) {
            try {
                g = new String(a.a(context.getClassLoader().getResourceAsStream("com/androidquery/util/web_image.html")));
            } catch (Exception e2) {
                a.a((Throwable) e2);
            }
        }
        return g;
    }

    private void b() {
        if (!this.f1579c.equals(this.f1578b.getTag(d.y))) {
            this.f1578b.setTag(d.y, this.f1579c);
            if (Build.VERSION.SDK_INT <= 10) {
                this.f1578b.setDrawingCacheEnabled(true);
            }
            SharedPreferences sharedPreferences = this.f1578b.getContext().getSharedPreferences(h, 0);
            if (sharedPreferences.getInt(i, 1) > 0) {
                sharedPreferences.edit().putInt(i, 0).commit();
            }
            WebSettings settings = this.f1578b.getSettings();
            settings.setSupportZoom(this.d);
            settings.setBuiltInZoomControls(this.d);
            if (!this.e) {
                WebView webView = this.f1578b;
                if (Build.VERSION.SDK_INT >= 11) {
                    a.a((Object) webView.getSettings(), "setDisplayZoomControls", false, false, (Class<?>[]) new Class[]{Boolean.TYPE}, false);
                }
            }
            settings.setJavaScriptEnabled(true);
            this.f1578b.setBackgroundColor(this.f);
            if (this.f1577a != null) {
                c.a(this.f1577a, this.f1579c, true);
            }
            if (this.f1578b.getWidth() > 0) {
                a();
                return;
            }
            this.f1578b.setPictureListener(new WebView.PictureListener() {
                public final void onNewPicture(WebView webView, Picture picture) {
                    h.this.f1578b.setPictureListener((WebView.PictureListener) null);
                    h.this.a();
                }
            });
            this.f1578b.loadData("<html></html>", "text/html", "utf-8");
            this.f1578b.setBackgroundColor(this.f);
        }
    }

    private void b(WebView webView) {
        if (this.f1577a != null) {
            webView.setVisibility(0);
            c.a(this.f1577a, this.f1579c, false);
        }
        webView.setWebViewClient((WebViewClient) null);
    }

    private void c() {
        this.f1578b.setPictureListener(new WebView.PictureListener() {
            public final void onNewPicture(WebView webView, Picture picture) {
                h.this.f1578b.setPictureListener((WebView.PictureListener) null);
                h.this.a();
            }
        });
        this.f1578b.loadData("<html></html>", "text/html", "utf-8");
        this.f1578b.setBackgroundColor(this.f);
    }

    public final void a() {
        String replace = b(this.f1578b.getContext()).replace("@src", this.f1579c).replace("@color", Integer.toHexString(this.f));
        this.f1578b.setWebViewClient(this);
        this.f1578b.loadDataWithBaseURL((String) null, replace, "text/html", "utf-8", (String) null);
        this.f1578b.setBackgroundColor(this.f);
    }

    public final void onPageFinished(WebView webView, String str) {
        b(webView);
    }

    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        b(webView);
    }

    public final void onScaleChanged(WebView webView, float f2, float f3) {
    }
}
