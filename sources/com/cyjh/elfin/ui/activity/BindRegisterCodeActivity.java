package com.cyjh.elfin.ui.activity;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyjh.common.base.activity.BaseModelActivity;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.x;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.ui.a.b;
import com.cyjh.elfin.ui.a.g;
import com.cyjh.elfin.ui.model.RegCodeModel;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.cyjh.http.bean.response.BaseResponseInfo;
import com.cyjh.http.bean.response.BuyRegCodeConfigInfo;
import com.cyjh.http.bean.response.QueryRegCodeInfo;
import com.cyjh.http.bean.response.RegCodeInfoResponse;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;
import org.greenrobot.eventbus.c;

public class BindRegisterCodeActivity extends BaseModelActivity<RegCodeModel> implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f2131c = {"android.permission.CAMERA"};
    public static final int d = 1003;
    /* access modifiers changed from: private */
    public String e;
    private EditText f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private TextView k;
    private View l;
    private View m;
    private View n;
    private TextView o;
    private final Handler p = new Handler();
    /* access modifiers changed from: private */
    public boolean q;

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(BindRegisterCodeActivity bindRegisterCodeActivity, byte b2) {
            this();
        }

        public final void a() {
            BindRegisterCodeActivity.this.finish();
        }
    }

    static /* synthetic */ void a(BindRegisterCodeActivity bindRegisterCodeActivity, QueryRegCodeInfo queryRegCodeInfo) {
        if (queryRegCodeInfo.IsSuperposeConfirm == 1) {
            b.a();
            final AlertDialog a2 = b.a((Context) bindRegisterCodeActivity, (int) R.layout.dialog_overlay_regcode);
            a2.setCancelable(false);
            a2.show();
            ((TextView) a2.findViewById(R.id.id_tv_no_superimposed)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    r4.dismiss();
                    ((RegCodeModel) BindRegisterCodeActivity.this.f1628b).a(BindRegisterCodeActivity.this.e, 0);
                }
            });
            ((TextView) a2.findViewById(R.id.id_tv_superimposed)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    r4.dismiss();
                    ((RegCodeModel) BindRegisterCodeActivity.this.f1628b).a(BindRegisterCodeActivity.this.e, 1);
                }
            });
            return;
        }
        ((RegCodeModel) bindRegisterCodeActivity.f1628b).a(bindRegisterCodeActivity.e, 0);
    }

    private void a(QueryRegCodeInfo queryRegCodeInfo) {
        if (queryRegCodeInfo.IsSuperposeConfirm == 1) {
            b.a();
            final AlertDialog a2 = b.a((Context) this, (int) R.layout.dialog_overlay_regcode);
            a2.setCancelable(false);
            a2.show();
            ((TextView) a2.findViewById(R.id.id_tv_no_superimposed)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a2.dismiss();
                    ((RegCodeModel) BindRegisterCodeActivity.this.f1628b).a(BindRegisterCodeActivity.this.e, 0);
                }
            });
            ((TextView) a2.findViewById(R.id.id_tv_superimposed)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a2.dismiss();
                    ((RegCodeModel) BindRegisterCodeActivity.this.f1628b).a(BindRegisterCodeActivity.this.e, 1);
                }
            });
            return;
        }
        ((RegCodeModel) this.f1628b).a(this.e, 0);
    }

    static /* synthetic */ boolean a(Context context, Intent intent) {
        return !com.cyjh.elfin.a.b.f1842b.equals(context.getPackageManager().resolveActivity(intent, 65536).activityInfo.packageName);
    }

    private static boolean b(Context context, Intent intent) {
        return !com.cyjh.elfin.a.b.f1842b.equals(context.getPackageManager().resolveActivity(intent, 65536).activityInfo.packageName);
    }

    private void f() {
        if (Build.VERSION.SDK_INT < 23) {
            g();
        } else if (ContextCompat.checkSelfPermission(getApplication(), "android.permission.CAMERA") == 0) {
            ActivityCompat.requestPermissions(this, f2131c, 1000);
        } else {
            g();
        }
    }

    private void g() {
        startActivityForResult(new Intent(this, SweepCodeZbarActivity.class), 1003);
    }

    private void h() {
        if (ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos == null || ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.size() <= 0) {
            this.g.setVisibility(0);
            return;
        }
        TextView[] textViewArr = {this.i, this.j, this.k, this.o};
        View[] viewArr = {this.l, this.m, this.n};
        this.h.setVisibility(0);
        this.g.setVisibility(8);
        for (int i2 = 0; i2 < ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.size(); i2++) {
            final BuyRegCodeConfigInfo buyRegCodeConfigInfo = ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.get(i2);
            TextView textView = textViewArr[i2];
            textView.setVisibility(0);
            textView.setText(buyRegCodeConfigInfo.ButtonName);
            if (3 < ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.size() - 1) {
                viewArr[i2].setVisibility(0);
            }
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(r6.BuyLinkUrl));
                        if (!BindRegisterCodeActivity.a((Context) AppContext.a(), intent)) {
                            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                        }
                        BindRegisterCodeActivity.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        ag.b((Context) AppContext.a(), BindRegisterCodeActivity.this.getString(R.string.invalid_url_address));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final Class<RegCodeModel> b() {
        return RegCodeModel.class;
    }

    /* access modifiers changed from: protected */
    public final void c() {
        ((RegCodeModel) this.f1628b).f2280a.observe(this, new Observer<BaseResponseInfo>() {
            private void a(@Nullable BaseResponseInfo baseResponseInfo) {
                if (baseResponseInfo.Code == 200) {
                    ag.b((Context) BindRegisterCodeActivity.this, BindRegisterCodeActivity.this.getString(R.string.activation_code_suc));
                    return;
                }
                int i = baseResponseInfo.Code;
                if (1100 != i && 1200 != i && 1201 != i && 1202 != i && 1300 != i) {
                    ag.b((Context) AppContext.a(), baseResponseInfo.Message);
                } else if (!g.f2117a) {
                    final g gVar = new g(BindRegisterCodeActivity.this, false, baseResponseInfo.Message);
                    gVar.f2119b = new View.OnClickListener() {
                        public final void onClick(View view) {
                            r0.dismiss();
                        }
                    };
                    gVar.show();
                } else {
                    c.a().c((Object) new MsgItem.UpdateMessageToDialog(baseResponseInfo.Message));
                }
            }

            public final /* synthetic */ void onChanged(@Nullable Object obj) {
                BaseResponseInfo baseResponseInfo = (BaseResponseInfo) obj;
                if (baseResponseInfo.Code == 200) {
                    ag.b((Context) BindRegisterCodeActivity.this, BindRegisterCodeActivity.this.getString(R.string.activation_code_suc));
                    return;
                }
                int i = baseResponseInfo.Code;
                if (1100 != i && 1200 != i && 1201 != i && 1202 != i && 1300 != i) {
                    ag.b((Context) AppContext.a(), baseResponseInfo.Message);
                } else if (!g.f2117a) {
                    final g gVar = new g(BindRegisterCodeActivity.this, false, baseResponseInfo.Message);
                    gVar.f2119b = new View.OnClickListener() {
                        public final void onClick(View view) {
                            gVar.dismiss();
                        }
                    };
                    gVar.show();
                } else {
                    c.a().c((Object) new MsgItem.UpdateMessageToDialog(baseResponseInfo.Message));
                }
            }
        });
        ((RegCodeModel) this.f1628b).f2281b.observe(this, new Observer<RegCodeInfoResponse>() {
            private void a(@Nullable RegCodeInfoResponse regCodeInfoResponse) {
                if (regCodeInfoResponse.Code == 200) {
                    BindRegisterCodeActivity.a(BindRegisterCodeActivity.this, regCodeInfoResponse.Data);
                    return;
                }
                String str = regCodeInfoResponse.Message;
                if (TextUtils.isEmpty(str)) {
                    str = String.valueOf(regCodeInfoResponse.Code);
                }
                ag.b((Context) AppContext.a(), str);
            }

            public final /* synthetic */ void onChanged(@Nullable Object obj) {
                RegCodeInfoResponse regCodeInfoResponse = (RegCodeInfoResponse) obj;
                if (regCodeInfoResponse.Code == 200) {
                    BindRegisterCodeActivity.a(BindRegisterCodeActivity.this, regCodeInfoResponse.Data);
                    return;
                }
                String str = regCodeInfoResponse.Message;
                if (TextUtils.isEmpty(str)) {
                    str = String.valueOf(regCodeInfoResponse.Code);
                }
                ag.b((Context) AppContext.a(), str);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void d() {
        TitleView titleView = (TitleView) findViewById(R.id.id_title);
        titleView.setTitleText(getString(R.string.activation_code));
        titleView.setVisibilityRightImage(4);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setRightTvText((int) R.string.register_code_unbind);
        titleView.setVisibilityTvRight(0);
        this.f = (EditText) findViewById(R.id.register_number);
        this.g = (TextView) findViewById(R.id.tv_empty_msg);
        this.h = (LinearLayout) findViewById(R.id.ll_registration_buy);
        this.i = (TextView) findViewById(R.id.tv_day);
        this.j = (TextView) findViewById(R.id.tv_week);
        this.k = (TextView) findViewById(R.id.tv_month);
        this.l = findViewById(R.id.line_day);
        this.m = findViewById(R.id.line_week);
        this.n = findViewById(R.id.line_month);
        this.o = (TextView) findViewById(R.id.tv_permanent_card);
        ((Button) findViewById(R.id.btn_activation)).setOnClickListener(this);
        this.f.setText(com.cyjh.elfin.d.c.a().b());
        findViewById(R.id.btn_sweep_activation).setOnClickListener(this);
        titleView.setOnRightTextViewListener(new TitleView.c() {
            public final void a() {
                BindRegisterCodeActivity bindRegisterCodeActivity = BindRegisterCodeActivity.this;
                String b2 = com.cyjh.elfin.d.c.a().b();
                Intent intent = new Intent(bindRegisterCodeActivity, UnbindRegistrationCodeActivity.class);
                intent.addFlags(268435456);
                intent.putExtra(UnbindRegistrationCodeActivity.class.getCanonicalName(), b2);
                bindRegisterCodeActivity.startActivity(intent);
            }
        });
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        if (ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos == null || ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.size() <= 0) {
            this.g.setVisibility(0);
            return;
        }
        TextView[] textViewArr = {this.i, this.j, this.k, this.o};
        View[] viewArr = {this.l, this.m, this.n};
        this.h.setVisibility(0);
        this.g.setVisibility(8);
        for (int i2 = 0; i2 < ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.size(); i2++) {
            final BuyRegCodeConfigInfo buyRegCodeConfigInfo = ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.get(i2);
            TextView textView = textViewArr[i2];
            textView.setVisibility(0);
            textView.setText(buyRegCodeConfigInfo.ButtonName);
            if (3 < ParamsWrap.getParamsWrap().mBuyRegCodeConfigInfos.size() - 1) {
                viewArr[i2].setVisibility(0);
            }
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(buyRegCodeConfigInfo.BuyLinkUrl));
                        if (!BindRegisterCodeActivity.a((Context) AppContext.a(), intent)) {
                            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                        }
                        BindRegisterCodeActivity.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        ag.b((Context) AppContext.a(), BindRegisterCodeActivity.this.getString(R.string.invalid_url_address));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final int e() {
        return R.layout.activity_register_code;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1003 && i3 == -1 && intent != null) {
            this.e = intent.getStringExtra("SWEEP_RESULT_BACK");
            if (!TextUtils.isEmpty(this.e)) {
                this.f.setText(this.e);
                ((RegCodeModel) this.f1628b).a(this.e);
                return;
            }
            ag.b((Context) this, getString(R.string.regcode_sweep_result_null));
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_activation /*2131755223*/:
                this.e = this.f.getText().toString().trim();
                if (TextUtils.isEmpty(this.e)) {
                    ag.b((Context) AppContext.a(), (int) R.string.input_register_number);
                    return;
                } else if (!x.a(AppContext.a())) {
                    ag.b((Context) AppContext.a(), AppContext.a().getString(R.string.network_off));
                    return;
                } else if (!this.q) {
                    this.q = true;
                    ((RegCodeModel) this.f1628b).a(this.e);
                    this.p.removeCallbacksAndMessages((Object) null);
                    this.p.postDelayed(new Runnable() {
                        public final void run() {
                            boolean unused = BindRegisterCodeActivity.this.q = false;
                        }
                    }, 3000);
                    return;
                } else {
                    return;
                }
            case R.id.btn_sweep_activation /*2131755224*/:
                if (Build.VERSION.SDK_INT < 23) {
                    g();
                    return;
                } else if (ContextCompat.checkSelfPermission(getApplication(), "android.permission.CAMERA") == 0) {
                    ActivityCompat.requestPermissions(this, f2131c, 1000);
                    return;
                } else {
                    g();
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 1000) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            finish();
        } else {
            g();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
}
