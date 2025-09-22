package com.cyjh.elfin.ui.activity;

import android.os.Bundle;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.elfin.ui.fragment.MsgDetailFragment;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;

public class MessageDetailActivity extends BaseActivity {

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(MessageDetailActivity messageDetailActivity, byte b2) {
            this();
        }

        public final void a() {
            MessageDetailActivity.this.finish();
        }
    }

    private void b() {
        TitleView titleView = (TitleView) findViewById(R.id.id_msg_detail_head);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setTitleText((int) R.string.msg_notify);
        titleView.setVisibilityRightImage(4);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_msg_detail);
        TitleView titleView = (TitleView) findViewById(R.id.id_msg_detail_head);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setTitleText((int) R.string.msg_notify);
        titleView.setVisibilityRightImage(4);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        getSupportFragmentManager().beginTransaction().replace(R.id.id_fl_fragment, MsgDetailFragment.a(getIntent().getLongExtra(MessageDetailActivity.class.getCanonicalName(), 0))).commit();
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
