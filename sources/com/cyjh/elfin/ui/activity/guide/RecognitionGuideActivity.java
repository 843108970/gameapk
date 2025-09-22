package com.cyjh.elfin.ui.activity.guide;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.n;
import com.cyjh.http.b.a;
import com.cyjh.http.bean.response.PhoneConfig;
import com.ywfzjbcy.R;

public class RecognitionGuideActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    public static final String f2210b = "PhoneConfig";

    /* renamed from: c  reason: collision with root package name */
    private static final String f2211c = "RecognitionGuideActivity";
    private ImageView d;
    private String e;

    public static void a(Context context, PhoneConfig phoneConfig) {
        Intent intent = new Intent(context, RecognitionGuideActivity.class);
        intent.putExtra(f2210b, phoneConfig);
        context.startActivity(intent);
    }

    static /* synthetic */ void a(RecognitionGuideActivity recognitionGuideActivity) {
        if (TextUtils.isEmpty(recognitionGuideActivity.e)) {
            ag.a((Context) recognitionGuideActivity, "跳转链接为空！");
            return;
        }
        recognitionGuideActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a.a().b(recognitionGuideActivity.e, a.a().b(recognitionGuideActivity)))));
        recognitionGuideActivity.finish();
    }

    private void b() {
        this.d = (ImageView) findViewById(R.id.iv_bg);
    }

    private void c() {
        PhoneConfig phoneConfig = (PhoneConfig) getIntent().getParcelableExtra(f2210b);
        if (phoneConfig != null) {
            String imageUrl = phoneConfig.getImageUrl();
            this.e = phoneConfig.getLinkUrl();
            String str = f2211c;
            ad.c(str, "initData --> imageUrl=" + imageUrl);
            Bitmap c2 = n.c(imageUrl);
            if (c2 != null) {
                this.d.setImageBitmap(c2);
            }
            this.d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    RecognitionGuideActivity.a(RecognitionGuideActivity.this);
                }
            });
        }
    }

    private void d() {
        if (TextUtils.isEmpty(this.e)) {
            ag.a((Context) this, "跳转链接为空！");
            return;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a.a().b(this.e, a.a().b(this)))));
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_recognition_guide);
        this.d = (ImageView) findViewById(R.id.iv_bg);
        PhoneConfig phoneConfig = (PhoneConfig) getIntent().getParcelableExtra(f2210b);
        if (phoneConfig != null) {
            String imageUrl = phoneConfig.getImageUrl();
            this.e = phoneConfig.getLinkUrl();
            String str = f2211c;
            ad.c(str, "initData --> imageUrl=" + imageUrl);
            Bitmap c2 = n.c(imageUrl);
            if (c2 != null) {
                this.d.setImageBitmap(c2);
            }
            this.d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    RecognitionGuideActivity.a(RecognitionGuideActivity.this);
                }
            });
        }
    }
}
