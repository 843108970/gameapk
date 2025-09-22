package com.cyjh.elfin.floatingwindowprocess.a;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.webkit.WebView;
import android.widget.TextView;
import com.cyjh.elfin.floatingwindowprocess.c.b;
import com.cyjh.elfin.ui.a.a;
import com.ywfzjbcy.R;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private WebView f1978a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1979b;

    public b(Context context) {
        super(context);
        Window window;
        int i;
        if (Build.VERSION.SDK_INT >= 26) {
            window = getWindow();
            i = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            window = getWindow();
            i = 2002;
        } else {
            window = getWindow();
            i = 2005;
        }
        window.setType(i);
    }

    private void a() {
        this.f1979b = (TextView) findViewById(R.id.scriptrtd_textview_nortd);
        this.f1978a = (WebView) findViewById(R.id.scriptrtd_webview);
        this.f1978a.getSettings().setJavaScriptEnabled(true);
        try {
            this.d.getAssets().open(com.cyjh.elfin.a.a.s);
            this.f1978a.loadUrl("file:///android_asset/script.rtd");
        } catch (Exception unused) {
            this.f1978a.setVisibility(8);
            this.f1979b.setVisibility(0);
        }
    }

    static /* synthetic */ void a(b bVar, final float f) {
        if (bVar.isShowing()) {
            bVar.dismiss();
            new Handler().postDelayed(new Runnable(0.9f) {
                public final void run() {
                    b.this.a(r3, r4);
                    b.this.show();
                }
            }, 500);
        }
    }

    private void b() {
        com.cyjh.elfin.floatingwindowprocess.c.b.a().f2009b = new b.a() {
            public final void a() {
                b.a(b.this, 0.8f);
            }

            public final void b() {
                b.a(b.this, 0.6f);
            }
        };
    }

    private void b(final float f, final float f2) {
        if (isShowing()) {
            dismiss();
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    b.this.a(f, f2);
                    b.this.show();
                }
            }, 500);
        }
    }

    private void c() {
        this.f1979b = (TextView) findViewById(R.id.scriptrtd_textview_nortd);
        this.f1978a = (WebView) findViewById(R.id.scriptrtd_webview);
        this.f1978a.getSettings().setJavaScriptEnabled(true);
        try {
            this.d.getAssets().open(com.cyjh.elfin.a.a.s);
            this.f1978a.loadUrl("file:///android_asset/script.rtd");
        } catch (Exception unused) {
            this.f1978a.setVisibility(8);
            this.f1979b.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_scriptrtd);
        a(0.1f);
        a(0.9f, com.cyjh.elfin.floatingwindowprocess.c.b.a().f2008a ? 0.8f : 0.6f);
        this.f1979b = (TextView) findViewById(R.id.scriptrtd_textview_nortd);
        this.f1978a = (WebView) findViewById(R.id.scriptrtd_webview);
        this.f1978a.getSettings().setJavaScriptEnabled(true);
        try {
            this.d.getAssets().open(com.cyjh.elfin.a.a.s);
            this.f1978a.loadUrl("file:///android_asset/script.rtd");
        } catch (Exception unused) {
            this.f1978a.setVisibility(8);
            this.f1979b.setVisibility(0);
        }
        com.cyjh.elfin.floatingwindowprocess.c.b.a().f2009b = new b.a() {
            public final void a() {
                b.a(b.this, 0.8f);
            }

            public final void b() {
                b.a(b.this, 0.6f);
            }
        };
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.cyjh.elfin.floatingwindowprocess.c.b.a().f2009b = null;
    }
}
