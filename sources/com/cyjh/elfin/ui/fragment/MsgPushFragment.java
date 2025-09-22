package com.cyjh.elfin.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.f;
import com.cyjh.common.base.fragment.BaseFragement;
import com.cyjh.elfin.a.b;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.elfin.ui.activity.MessageDetailActivity;
import com.cyjh.elfin.ui.adpter.MsgNotifyAdapter;
import com.cyjh.http.bean.NotifyMsgBean;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public class MsgPushFragment extends BaseFragement {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f2256a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public BGARecyclerViewAdapter f2257b;

    /* renamed from: c  reason: collision with root package name */
    private List<NotifyMsgBean> f2258c;
    private TextView d;
    private f e = new f() {
        public final void a(int i) {
            Intent intent = new Intent(MsgPushFragment.this.getActivity(), MessageDetailActivity.class);
            intent.putExtra(MessageDetailActivity.class.getCanonicalName(), Long.parseLong(((NotifyMsgBean) MsgPushFragment.this.f2257b.a(i)).ID));
            MsgPushFragment.this.startActivity(intent);
        }
    };

    public static MsgPushFragment a(ArrayList<NotifyMsgBean> arrayList) {
        MsgPushFragment msgPushFragment = new MsgPushFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(b.f1843c, arrayList);
        msgPushFragment.setArguments(bundle);
        return msgPushFragment;
    }

    private void a(View view) {
        this.f2256a = (RecyclerView) view.findViewById(R.id.id_recycler_view);
        this.f2256a.setItemAnimator(new DefaultItemAnimator());
        this.f2256a.setHasFixedSize(true);
        this.f2256a.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f2257b = new MsgNotifyAdapter(this.f2256a);
        this.f2257b.a(this.e);
        this.d = (TextView) view.findViewById(R.id.id_tv_no_msg);
    }

    private void b() {
        if (this.f2258c == null || this.f2258c.size() <= 0) {
            this.d.setVisibility(0);
            this.f2256a.setVisibility(8);
            return;
        }
        this.d.setVisibility(8);
        this.f2256a.setVisibility(0);
        this.f2257b.a(this.f2258c);
        this.f2256a.setAdapter(this.f2257b);
    }

    public final int a() {
        return R.layout.fragment_msg_push;
    }

    public void onDestroy() {
        super.onDestroy();
        c.a().b((Object) this);
    }

    @j(a = ThreadMode.MAIN)
    public void onMessageMainThread(MsgItem msgItem) {
        if (msgItem.getMsgType() == 1002) {
            this.f2257b.a();
            this.d.setVisibility(0);
            this.f2256a.setVisibility(8);
            c.a().c((Object) new MsgItem(1003));
        }
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(MsgPushFragment.class.getCanonicalName());
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(MsgPushFragment.class.getCanonicalName());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        c.a().a((Object) this);
        if (arguments != null) {
            this.f2258c = arguments.getParcelableArrayList(b.f1843c);
        }
        this.f2256a = (RecyclerView) view.findViewById(R.id.id_recycler_view);
        this.f2256a.setItemAnimator(new DefaultItemAnimator());
        this.f2256a.setHasFixedSize(true);
        this.f2256a.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f2257b = new MsgNotifyAdapter(this.f2256a);
        this.f2257b.a(this.e);
        this.d = (TextView) view.findViewById(R.id.id_tv_no_msg);
        if (this.f2258c == null || this.f2258c.size() <= 0) {
            this.d.setVisibility(0);
            this.f2256a.setVisibility(8);
            return;
        }
        this.d.setVisibility(8);
        this.f2256a.setVisibility(0);
        this.f2257b.a(this.f2258c);
        this.f2256a.setAdapter(this.f2257b);
    }
}
