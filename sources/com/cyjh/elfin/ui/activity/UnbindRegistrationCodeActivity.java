package com.cyjh.elfin.ui.activity;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.cyjh.common.base.activity.BaseModelActivity;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.x;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.ui.model.UnRegCodeModel;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.cyjh.http.bean.response.RegCodeInfoResponse;
import com.cyjh.http.c.c.p;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;

public class UnbindRegistrationCodeActivity extends BaseModelActivity<UnRegCodeModel> implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final int f2201c = 1002;
    private static final int d = 2;
    private Handler e = new Handler();
    private String f;
    private String g;
    private EditText h;
    /* access modifiers changed from: private */
    public boolean i = false;
    private TextView j;
    private Button k;
    private Button l;

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(UnbindRegistrationCodeActivity unbindRegistrationCodeActivity, byte b2) {
            this();
        }

        public final void a() {
            UnbindRegistrationCodeActivity.this.finish();
        }
    }

    private void f() {
        if (!TextUtils.isEmpty(this.f)) {
            this.h.setText(this.f);
        }
        String valueOf = String.valueOf(ParamsWrap.getParamsWrap().unbindDeductHours);
        String format = String.format(getString(R.string.unbind_app_buckle_time), new Object[]{valueOf});
        SpannableString spannableString = new SpannableString(format);
        int indexOf = format.indexOf(valueOf);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4948")), indexOf, valueOf.length() + indexOf + 2, 17);
        this.j.setText(spannableString);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public final Class<UnRegCodeModel> b() {
        return UnRegCodeModel.class;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        ((UnRegCodeModel) this.f1628b).f2307c.observe(this, new Observer<RegCodeInfoResponse>() {
            private void a(@Nullable RegCodeInfoResponse regCodeInfoResponse) {
                String str = regCodeInfoResponse.Message;
                if (regCodeInfoResponse.Code == 200) {
                    str = UnbindRegistrationCodeActivity.this.getString(R.string.unbind_reg_code_suc);
                }
                if (TextUtils.isEmpty(str)) {
                    str = UnbindRegistrationCodeActivity.this.getString(R.string.status_code_text) + regCodeInfoResponse.Code;
                }
                ag.b((Context) AppContext.a(), str);
            }

            public final /* synthetic */ void onChanged(@Nullable Object obj) {
                RegCodeInfoResponse regCodeInfoResponse = (RegCodeInfoResponse) obj;
                String str = regCodeInfoResponse.Message;
                if (regCodeInfoResponse.Code == 200) {
                    str = UnbindRegistrationCodeActivity.this.getString(R.string.unbind_reg_code_suc);
                }
                if (TextUtils.isEmpty(str)) {
                    str = UnbindRegistrationCodeActivity.this.getString(R.string.status_code_text) + regCodeInfoResponse.Code;
                }
                ag.b((Context) AppContext.a(), str);
            }
        });
    }

    public final void d() {
        TitleView titleView = (TitleView) findViewById(R.id.id_title);
        titleView.setTitleText(getString(R.string.register_code_unbind));
        titleView.setVisibilityRightImage(4);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.h = (EditText) findViewById(R.id.register_number);
        this.j = (TextView) findViewById(R.id.tv_buckle_time);
        this.k = (Button) findViewById(R.id.btn_unbind);
        this.l = (Button) findViewById(R.id.btn_sweep_unbind);
        if (!TextUtils.isEmpty(this.f)) {
            this.h.setText(this.f);
        }
        String valueOf = String.valueOf(ParamsWrap.getParamsWrap().unbindDeductHours);
        String format = String.format(getString(R.string.unbind_app_buckle_time), new Object[]{valueOf});
        SpannableString spannableString = new SpannableString(format);
        int indexOf = format.indexOf(valueOf);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4948")), indexOf, valueOf.length() + indexOf + 2, 17);
        this.j.setText(spannableString);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public final int e() {
        return R.layout.activity_unregister_code;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_unbind) {
            this.g = this.h.getText().toString().trim();
            if (TextUtils.isEmpty(this.g)) {
                ag.b((Context) AppContext.a(), (int) R.string.input_register_number);
            } else if (!x.a(view.getContext())) {
                ag.b((Context) AppContext.a(), AppContext.a().getResources().getString(R.string.network_off));
            } else if (!this.i) {
                this.i = true;
                UnRegCodeModel unRegCodeModel = (UnRegCodeModel) this.f1628b;
                String str = this.g;
                if (unRegCodeModel.f2305a == null) {
                    unRegCodeModel.f2305a = new p(unRegCodeModel);
                }
                unRegCodeModel.f2306b = str;
                unRegCodeModel.f2305a.a(str, AppContext.a());
                this.e.removeCallbacksAndMessages((Object) null);
                this.e.postDelayed(new Runnable() {
                    public final void run() {
                        boolean unused = UnbindRegistrationCodeActivity.this.i = false;
                    }
                }, 3000);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.e != null) {
            this.e.removeCallbacksAndMessages((Object) null);
        }
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
}
