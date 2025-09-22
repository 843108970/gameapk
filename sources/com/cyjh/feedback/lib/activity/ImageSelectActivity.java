package com.cyjh.feedback.lib.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyjh.common.g.a;
import com.cyjh.feedback.lib.fragment.ImageSelectFragment;
import com.cyjh.feedback.libraryfeedbackinfo.R;
import com.umeng.analytics.MobclickAgent;

public class ImageSelectActivity extends FragmentActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f2388a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f2389b;

    private void a() {
        this.f2388a = (ImageView) findViewById(R.id.id_img_left_back_arrow);
        this.f2389b = (TextView) findViewById(R.id.id_tv_title);
    }

    private void a(Fragment fragment, String str) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.id_fl_replace_fragment, fragment, str);
        beginTransaction.commit();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.id_img_left_back_arrow) {
            onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_img_select);
        a.a();
        a.a((Activity) this);
        this.f2388a = (ImageView) findViewById(R.id.id_img_left_back_arrow);
        this.f2389b = (TextView) findViewById(R.id.id_tv_title);
        this.f2389b.setText(getString(R.string.img_select_title));
        this.f2389b.setVisibility(0);
        this.f2388a.setOnClickListener(this);
        ImageSelectFragment b2 = ImageSelectFragment.b();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.id_fl_replace_fragment, b2, "ImageSelectFragment");
        beginTransaction.commit();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Log.e("elfin", "ImageSelectActivity-- onDestroy");
        a.a();
        a.b((Activity) this);
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
