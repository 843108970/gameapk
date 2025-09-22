package com.c;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public final class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public String f1550a;

    /* renamed from: b  reason: collision with root package name */
    private String f1551b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public WebViewClient f1552c;
    private WebView d;
    private LinearLayout e;

    private class a extends WebViewClient {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final void onPageFinished(WebView webView, String str) {
            c.a(c.this);
            c.this.f1552c.onPageFinished(webView, str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            c.this.f1552c.onPageStarted(webView, str, bitmap);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            c.this.f1552c.onReceivedError(webView, i, str, str2);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return c.this.f1552c.shouldOverrideUrlLoading(webView, str);
        }
    }

    public c(Context context, String str, WebViewClient webViewClient) {
        super(context, 16973830);
        this.f1551b = str;
        this.f1552c = webViewClient;
    }

    private void a(RelativeLayout relativeLayout) {
        Context context = getContext();
        this.e = new LinearLayout(context);
        ProgressBar progressBar = new ProgressBar(context);
        int a2 = com.c.d.a.a(context, 30.0f);
        this.e.addView(progressBar, new LinearLayout.LayoutParams(a2, a2));
        if (this.f1550a != null) {
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = com.c.d.a.a(context, 5.0f);
            layoutParams.gravity = 16;
            textView.setText(this.f1550a);
            this.e.addView(textView, layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.addView(this.e, layoutParams2);
    }

    static /* synthetic */ void a(c cVar) {
        if (cVar.e != null) {
            cVar.e.setVisibility(8);
        }
    }

    private void a(String str) {
        this.f1550a = str;
    }

    private void a(boolean z) {
        if (this.e == null) {
            return;
        }
        if (z) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
    }

    private void b(RelativeLayout relativeLayout) {
        this.d = new WebView(getContext());
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        if (this.f1552c == null) {
            this.f1552c = new WebViewClient();
        }
        this.d.setWebViewClient(new a(this, (byte) 0));
        this.d.getSettings().setJavaScriptEnabled(true);
        relativeLayout.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
    }

    public final void a() {
        if (this.d != null) {
            this.d.loadUrl(this.f1551b);
        }
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(-1);
        this.d = new WebView(getContext());
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        if (this.f1552c == null) {
            this.f1552c = new WebViewClient();
        }
        this.d.setWebViewClient(new a(this, (byte) 0));
        this.d.getSettings().setJavaScriptEnabled(true);
        relativeLayout.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
        Context context = getContext();
        this.e = new LinearLayout(context);
        ProgressBar progressBar = new ProgressBar(context);
        int a2 = com.c.d.a.a(context, 30.0f);
        this.e.addView(progressBar, new LinearLayout.LayoutParams(a2, a2));
        if (this.f1550a != null) {
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = com.c.d.a.a(context, 5.0f);
            layoutParams.gravity = 16;
            textView.setText(this.f1550a);
            this.e.addView(textView, layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.addView(this.e, layoutParams2);
        addContentView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
    }
}
