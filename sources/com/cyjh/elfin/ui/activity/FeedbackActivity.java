package com.cyjh.elfin.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.cyjh.feedback.lib.e.e;
import com.cyjh.feedback.lib.fragment.FeedBackInfoFragment;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;

public class FeedbackActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    TitleView f2154b;

    private void b() {
        this.f2154b = (TitleView) findViewById(R.id.titleview_feedback);
        this.f2154b.setTitleText((int) R.string.feedback);
        this.f2154b.setVisibilityLeftImage(0);
        this.f2154b.setleftImage(R.drawable.ic_back);
        this.f2154b.setOnLeftImageViewListener(new TitleView.a() {
            public final void a() {
                FeedbackActivity.this.onBackPressed();
            }
        });
        this.f2154b.setVisibilityRightImage(4);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_feedback);
        this.f2154b = (TitleView) findViewById(R.id.titleview_feedback);
        this.f2154b.setTitleText((int) R.string.feedback);
        this.f2154b.setVisibilityLeftImage(0);
        this.f2154b.setleftImage(R.drawable.ic_back);
        this.f2154b.setOnLeftImageViewListener(new TitleView.a() {
            public final void a() {
                FeedbackActivity.this.onBackPressed();
            }
        });
        this.f2154b.setVisibilityRightImage(4);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frameLayout_feedback, FeedBackInfoFragment.a(getIntent().getStringExtra(FeedbackActivity.class.getCanonicalName()), e.a()));
        beginTransaction.commit();
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
