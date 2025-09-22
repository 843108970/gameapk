package com.cyjh.elfin.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;

public class H5LinkJumpPageActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f2156b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f2157c;

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(H5LinkJumpPageActivity h5LinkJumpPageActivity, byte b2) {
            this();
        }

        public final void a() {
            H5LinkJumpPageActivity.this.finish();
        }
    }

    private void a(String str) {
        TitleView titleView = (TitleView) findViewById(R.id.title_view);
        titleView.setTitleText(str);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setVisibilityRightImage(8);
        titleView.setVisibilityTvRight(0);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2156b = (LinearLayout) findViewById(R.id.ll_root);
        this.f2157c = new WebView(getApplicationContext());
        this.f2156b.addView(this.f2157c, new LinearLayout.LayoutParams(-1, -1));
    }

    private void b(String str) {
        WebSettings settings = this.f2157c.getSettings();
        this.f2157c.loadUrl(str);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDatabaseEnabled(true);
        settings.setBuiltInZoomControls(true);
        this.f2157c.setWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith("http://") || str.startsWith("https://")) {
                    webView.loadUrl(str);
                    return true;
                }
                try {
                    H5LinkJumpPageActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_h5_link_page);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(H5LinkJumpPageActivity.class.getCanonicalName());
        String stringExtra2 = intent.getStringExtra(H5LinkJumpPageActivity.class.getSimpleName());
        TitleView titleView = (TitleView) findViewById(R.id.title_view);
        titleView.setTitleText(stringExtra);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setVisibilityRightImage(8);
        titleView.setVisibilityTvRight(0);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2156b = (LinearLayout) findViewById(R.id.ll_root);
        this.f2157c = new WebView(getApplicationContext());
        this.f2156b.addView(this.f2157c, new LinearLayout.LayoutParams(-1, -1));
        WebSettings settings = this.f2157c.getSettings();
        this.f2157c.loadUrl(stringExtra2);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDatabaseEnabled(true);
        settings.setBuiltInZoomControls(true);
        this.f2157c.setWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith("http://") || str.startsWith("https://")) {
                    webView.loadUrl(str);
                    return true;
                }
                try {
                    H5LinkJumpPageActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f2157c != null) {
            this.f2156b.removeView(this.f2157c);
            this.f2157c.removeAllViews();
            this.f2157c.destroy();
            this.f2157c = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
}
