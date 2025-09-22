package com.cyjh.elfin.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.ab;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.elfin.ui.fragment.MsgPushFragment;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.cyjh.http.bean.NotifyMsgBean;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;
import java.util.ArrayList;
import org.greenrobot.eventbus.c;

public class MessagePushActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private TitleView f2161b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<NotifyMsgBean> f2162c;

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(MessagePushActivity messagePushActivity, byte b2) {
            this();
        }

        public final void a() {
            MessagePushActivity.this.finish();
        }
    }

    private class b implements TitleView.c {
        private b() {
        }

        /* synthetic */ b(MessagePushActivity messagePushActivity, byte b2) {
            this();
        }

        public final void a() {
            c.a().c((Object) new MsgItem(1002));
        }
    }

    private void b() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.id_fl_fragment, MsgPushFragment.a(this.f2162c));
        beginTransaction.commit();
    }

    private void c() {
        this.f2161b = (TitleView) findViewById(R.id.id_msg_push_head);
        this.f2161b.setleftImage(R.drawable.ic_back);
        this.f2161b.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2161b.setTitleText((int) R.string.msg_notify);
        this.f2161b.setRightTvText((int) R.string.clear_msg);
        this.f2161b.setVisibilityRightImage(8);
        this.f2161b.setVisibilityTvRight(0);
        this.f2161b.setOnRightTextViewListener(new b(this, (byte) 0));
        ab.a().a(com.cyjh.elfin.a.b.e, (Boolean) false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_msg_push);
        this.f2162c = getIntent().getParcelableArrayListExtra(com.cyjh.elfin.a.b.f1843c);
        c.a().c((Object) new MsgItem(1001));
        this.f2161b = (TitleView) findViewById(R.id.id_msg_push_head);
        this.f2161b.setleftImage(R.drawable.ic_back);
        this.f2161b.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.f2161b.setTitleText((int) R.string.msg_notify);
        this.f2161b.setRightTvText((int) R.string.clear_msg);
        this.f2161b.setVisibilityRightImage(8);
        this.f2161b.setVisibilityTvRight(0);
        this.f2161b.setOnRightTextViewListener(new b(this, (byte) 0));
        ab.a().a(com.cyjh.elfin.a.b.e, (Boolean) false);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.id_fl_fragment, MsgPushFragment.a(this.f2162c));
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
