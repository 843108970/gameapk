package com.cyjh.elfin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyjh.common.base.fragment.BaseFragement;
import com.cyjh.http.bean.response.NoticeBean;
import com.cyjh.http.c.c.l;
import com.cyjh.http.c.d.e;
import com.cyjh.http.e.a;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;

public class MsgDetailFragment extends BaseFragement implements e {

    /* renamed from: a  reason: collision with root package name */
    private TextView f2253a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f2254b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f2255c;
    private LinearLayout d;
    private l e;

    public static MsgDetailFragment a(long j) {
        MsgDetailFragment msgDetailFragment = new MsgDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(MsgDetailFragment.class.getCanonicalName(), j);
        msgDetailFragment.setArguments(bundle);
        return msgDetailFragment;
    }

    private void a(View view) {
        this.f2253a = (TextView) view.findViewById(R.id.id_tv_msg_title);
        this.f2254b = (TextView) view.findViewById(R.id.id_tv_msg_time);
        this.f2255c = (WebView) view.findViewById(R.id.id_msg_web_view);
        this.d = (LinearLayout) view.findViewById(R.id.incl_loading);
    }

    private void b(NoticeBean noticeBean) {
        this.f2253a.setText(noticeBean.NoticeTitle);
        this.f2254b.setText(a.a(noticeBean.NoticeTime, "yyyy-MM-dd HH:mm:ss"));
        this.f2255c.loadDataWithBaseURL((String) null, noticeBean.NoticeContent, "text/html", "utf-8", (String) null);
        this.f2255c.getSettings().setJavaScriptEnabled(true);
        this.f2255c.setWebChromeClient(new WebChromeClient());
    }

    public final int a() {
        return R.layout.fragment_msg_detail;
    }

    public final void a(NoticeBean noticeBean) {
        this.f2253a.setText(noticeBean.NoticeTitle);
        this.f2254b.setText(a.a(noticeBean.NoticeTime, "yyyy-MM-dd HH:mm:ss"));
        this.f2255c.loadDataWithBaseURL((String) null, noticeBean.NoticeContent, "text/html", "utf-8", (String) null);
        this.f2255c.getSettings().setJavaScriptEnabled(true);
        this.f2255c.setWebChromeClient(new WebChromeClient());
        this.d.setVisibility(8);
    }

    public final void b() {
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            long j = getArguments().getLong(MsgDetailFragment.class.getCanonicalName());
            if (j != 0) {
                this.e = new l(this);
                this.e.a(getActivity(), j);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.e != null) {
            this.e.a();
        }
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(MsgDetailFragment.class.getCanonicalName());
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(MsgDetailFragment.class.getCanonicalName());
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f2253a = (TextView) view.findViewById(R.id.id_tv_msg_title);
        this.f2254b = (TextView) view.findViewById(R.id.id_tv_msg_time);
        this.f2255c = (WebView) view.findViewById(R.id.id_msg_web_view);
        this.d = (LinearLayout) view.findViewById(R.id.incl_loading);
    }
}
