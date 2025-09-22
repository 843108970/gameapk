package com.cyjh.elfin.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cyjh.common.base.fragment.BaseFragement;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ae;
import com.cyjh.elfin.a.a;
import com.cyjh.elfin.a.b;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;
import java.io.File;
import java.io.IOException;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class DescriptionFragment extends BaseFragement {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2250a = "DescriptionFragment";

    /* renamed from: b  reason: collision with root package name */
    private ScrollView f2251b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f2252c;
    private TextView d;

    private void b() {
        if (getView() != null) {
            View view = getView();
            this.f2251b = (ScrollView) view.findViewById(R.id.scrollview_scriptdescription);
            this.f2252c = (WebView) view.findViewById(R.id.webview_scriptdescription);
            this.d = (TextView) view.findViewById(R.id.tv_description);
            this.f2252c.getSettings().setJavaScriptEnabled(true);
            try {
                AppContext.a().getAssets().open(a.s);
                this.f2252c.setVisibility(0);
                this.f2251b.setVisibility(8);
                c();
            } catch (IOException unused) {
                this.f2251b.setVisibility(0);
                this.f2252c.setVisibility(8);
            }
        }
    }

    private void c() {
        String str;
        File file = new File(getContext().getFilesDir() + File.separator + b.au, a.s);
        String str2 = f2250a;
        StringBuilder sb = new StringBuilder("webViewLoad --> sdCardRtdFile path =");
        sb.append(file.getAbsolutePath());
        ad.c(str2, sb.toString());
        if (c.f().f2012c) {
            str = "file://" + file.getAbsolutePath();
        } else {
            str = "file:///android_asset/script.rtd";
        }
        Log.e("TAG", str);
        if (!c.f().f2012c || file.exists()) {
            this.f2252c.loadUrl(str);
        }
    }

    public final int a() {
        return R.layout.fragment_scriptdescription;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getView() != null) {
            View view = getView();
            this.f2251b = (ScrollView) view.findViewById(R.id.scrollview_scriptdescription);
            this.f2252c = (WebView) view.findViewById(R.id.webview_scriptdescription);
            this.d = (TextView) view.findViewById(R.id.tv_description);
            this.f2252c.getSettings().setJavaScriptEnabled(true);
            try {
                AppContext.a().getAssets().open(a.s);
                this.f2252c.setVisibility(0);
                this.f2251b.setVisibility(8);
                c();
            } catch (IOException unused) {
                this.f2251b.setVisibility(0);
                this.f2252c.setVisibility(8);
            }
        }
        org.greenrobot.eventbus.c.a().a((Object) this);
    }

    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b((Object) this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(DescriptionFragment.class.getCanonicalName());
    }

    @j(a = ThreadMode.MAIN)
    public void onReceiveRTDFileUIEvent(com.cyjh.common.e.a aVar) {
        ae.b((Context) getActivity(), "onReceiveRTDFileUIEvent --> 更新RTDFileUI");
        ad.c(f2250a, "onReceiveRTDFileUIEvent --> 更新RTDFileUI");
        c();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(DescriptionFragment.class.getCanonicalName());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        setUserVisibleHint(true);
    }
}
