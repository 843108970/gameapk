package com.cyjh.elfin.ui.fragment;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.request.g;
import com.cyjh.common.base.fragment.BaseFragement;
import com.cyjh.common.util.ab;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ae;
import com.cyjh.common.util.e;
import com.cyjh.common.util.l;
import com.cyjh.common.util.n;
import com.cyjh.common.util.o;
import com.cyjh.common.util.q;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.f;
import com.cyjh.elfin.e.c.k;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.elfin.ui.a.d;
import com.cyjh.elfin.ui.activity.BindRegisterCodeActivity;
import com.cyjh.elfin.ui.model.ScriptUipSetModel;
import com.cyjh.http.c.c.c;
import com.cyjh.http.c.c.s;
import com.cyjh.mq.sdk.MqRunner;
import com.elfin.ad.e.b;
import com.elfin.engin.a.c;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;
import java.io.File;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;
import org.json.JSONException;

public class ScriptUipSetFragment extends BaseFragement implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2260a = 10;
    /* access modifiers changed from: private */
    public static final String d = "ScriptUipSetFragment";
    private static final int e = 5;
    private static final int q = 20150617;

    /* renamed from: b  reason: collision with root package name */
    boolean f2261b = false;

    /* renamed from: c  reason: collision with root package name */
    public ScriptUipSetModel f2262c;
    private View f;
    private LinearLayout g;
    private Button h;
    private Button i;
    private TextView j;
    /* access modifiers changed from: private */
    public RelativeLayout k;
    /* access modifiers changed from: private */
    public ImageView l;
    /* access modifiers changed from: private */
    public TextView m;
    /* access modifiers changed from: private */
    public TextView n;
    /* access modifiers changed from: private */
    public int o = 0;
    private a p;
    private Handler r = new Handler();
    /* access modifiers changed from: private */
    public com.elfin.engin.b.a.a s;
    private b t;

    private class a extends com.cyjh.common.c.a {
        private a() {
            super(10);
        }

        /* synthetic */ a(ScriptUipSetFragment scriptUipSetFragment, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void a(int i) {
            if (ScriptUipSetFragment.this.isAdded()) {
                ScriptUipSetFragment.h(ScriptUipSetFragment.this);
                SpannableString spannableString = new SpannableString(String.format(ScriptUipSetFragment.this.getString(R.string.ad_delete_btn), new Object[]{Integer.valueOf(i)}));
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ff7900")), 0, "点击关闭".length(), 17);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), "点击关闭".length() + 1, "点击关闭".length() + 2, 17);
                if (ScriptUipSetFragment.this.m != null) {
                    ScriptUipSetFragment.this.m.setText(spannableString);
                }
            }
        }

        public final void onFinish() {
            int unused = ScriptUipSetFragment.this.o = 0;
            ScriptUipSetFragment.this.k.setVisibility(8);
        }
    }

    private /* synthetic */ void a(int i2) {
        if (101 == i2) {
            this.f2261b = false;
        }
    }

    private void a(String str) {
        if (!MqRunner.getInstance().isScriptStarted() && !TextUtils.isEmpty(str)) {
            String a2 = e.a(str);
            String str2 = d;
            ad.c(str2, "updateScriptSettings --> 1 服务端命令:脚本设置更新 encoding=" + a2 + ",scriptSetting=" + str);
            try {
                String a3 = n.a(str);
                File file = new File(o.a(getActivity().getFilesDir().getAbsolutePath(), com.cyjh.elfin.a.a.t));
                Script script = c.f().f2011a;
                boolean a4 = n.a(script.getCfgFile(), a3, "UTF-8");
                script.setCfgFile(file.getAbsoluteFile());
                String str3 = d;
                ad.c(str3, "updateScriptSettings --> 2 服务端命令:脚本设置更新 toUtf8Result=" + a3 + "\ncfgFile=" + file.getAbsolutePath() + ",result=" + a4);
                long length = script.getUipFile().length();
                if (script.getUipFile().exists() && length > 0) {
                    LinearLayout a5 = this.s.a();
                    this.s.b();
                    this.g.removeAllViews();
                    this.g.addView(a5);
                }
                if (this.s != null) {
                    this.s.d();
                    this.s.b(a3);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static /* synthetic */ void b(ScriptUipSetFragment scriptUipSetFragment) {
        if (scriptUipSetFragment.p == null) {
            scriptUipSetFragment.p = new a(scriptUipSetFragment, (byte) 0);
        }
        scriptUipSetFragment.p.start();
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                boolean canDrawOverlays = Settings.canDrawOverlays(getActivity());
                if (Build.VERSION.SDK_INT >= 26) {
                    canDrawOverlays = !ab.a().b(com.cyjh.elfin.ui.a.e.e, (Boolean) true);
                }
                ad.c(d, "showRunFloatJudgeOperate --> canDrawOverlays=" + canDrawOverlays);
                if (canDrawOverlays) {
                    d();
                } else {
                    new com.cyjh.elfin.ui.a.e(getActivity(), new a(this)).show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            d();
        }
    }

    private void d() {
        ad.c(d, "showRunFloat -->");
        ScriptUipSetModel scriptUipSetModel = this.f2262c;
        boolean z = false;
        scriptUipSetModel.f2283a = new ScriptUipSetModel.b(scriptUipSetModel, (byte) 0);
        com.cyjh.feedback.lib.d.b.a().a(scriptUipSetModel.f2283a);
        if (!c.a.f2893a.c().a()) {
            if (com.cyjh.feedback.lib.e.e.a() && com.cyjh.feedback.lib.e.e.b()) {
                z = true;
            }
            String str = d;
            ad.c(str, "showRunFloat isRoot：" + z);
            if (z) {
                e();
            } else {
                c.a.f2893a.c().a((Activity) getActivity());
            }
        } else if (!com.cyjh.feedback.lib.e.e.a()) {
            new d(getActivity()).show();
        } else {
            e();
        }
    }

    private void e() {
        com.cyjh.elfin.e.a.a.a();
        if (!com.cyjh.elfin.e.a.a.a((Context) AppContext.a())) {
            com.cyjh.elfin.e.a.a.a().b(getActivity());
            return;
        }
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().d == 0) {
            com.cyjh.elfin.floatingwindowprocess.c.c.f().d = 1;
        }
        k.a(10);
        getActivity().moveTaskToBack(true);
    }

    private void f() {
        this.t = new b(getActivity(), this.k);
        this.t.a(3, (com.elfin.ad.c.a) new com.elfin.ad.c.a<String>() {
            private void c(String str) {
                if (!TextUtils.isEmpty(str)) {
                    Context context = ScriptUipSetFragment.this.getContext();
                    ImageView a2 = ScriptUipSetFragment.this.l;
                    if (str.endsWith(".gif")) {
                        g a3 = q.a();
                        a3.b(i.f1144c);
                        q.a(context, str, a2, a3);
                    } else {
                        g a4 = q.a();
                        a4.b(i.f1143b);
                        q.b(context, str, a2, a4);
                    }
                    ScriptUipSetFragment.b(ScriptUipSetFragment.this);
                    ScriptUipSetFragment.this.m.setVisibility(0);
                    ScriptUipSetFragment.this.k.setVisibility(0);
                }
            }

            public final void a() {
            }

            public final /* synthetic */ void a(Object obj) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    Context context = ScriptUipSetFragment.this.getContext();
                    ImageView a2 = ScriptUipSetFragment.this.l;
                    if (str.endsWith(".gif")) {
                        g a3 = q.a();
                        a3.b(i.f1144c);
                        q.a(context, str, a2, a3);
                    } else {
                        g a4 = q.a();
                        a4.b(i.f1143b);
                        q.b(context, str, a2, a4);
                    }
                    ScriptUipSetFragment.b(ScriptUipSetFragment.this);
                    ScriptUipSetFragment.this.m.setVisibility(0);
                    ScriptUipSetFragment.this.k.setVisibility(0);
                }
            }

            public final void a(String str) {
            }

            public final void b() {
            }

            public final void b(String str) {
                if (!TextUtils.isEmpty(str)) {
                    ScriptUipSetFragment.this.n.setText(String.format(ScriptUipSetFragment.this.getString(R.string.ad_source_mark), new Object[]{str}));
                    ScriptUipSetFragment.this.n.setVisibility(0);
                }
            }
        });
        this.t.b();
    }

    private void g() {
        this.f2262c.f2284b.observe(this, new Observer<Integer>() {
            private void a(@Nullable Integer num) {
                if (num != null) {
                    if (num.intValue() == 0) {
                        ScriptUipSetFragment.this.l();
                    } else if (1 == num.intValue()) {
                        try {
                            ScriptUipSetFragment.this.s.d();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            public final /* synthetic */ void onChanged(@Nullable Object obj) {
                Integer num = (Integer) obj;
                if (num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    ScriptUipSetFragment.this.l();
                } else if (1 == num.intValue()) {
                    try {
                        ScriptUipSetFragment.this.s.d();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    static /* synthetic */ int h(ScriptUipSetFragment scriptUipSetFragment) {
        int i2 = scriptUipSetFragment.o;
        scriptUipSetFragment.o = i2 + 1;
        return i2;
    }

    private void h() {
        this.h.setOnClickListener(this);
        this.f.findViewById(R.id.btn_option_getmoretime).setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.l.setOnClickListener(this);
    }

    private void i() {
        ScriptUipSetModel scriptUipSetModel = this.f2262c;
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().f2012c) {
            n.b(new File("/sdcard/elf11.txt"), "sdCardScriptFiles\n", "UTF-8");
            scriptUipSetModel.a();
        } else {
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles\n", "UTF-8");
            scriptUipSetModel.b();
        }
        org.greenrobot.eventbus.c.a().a((Object) this);
    }

    private void j() {
        Button button;
        int i2;
        this.g = (LinearLayout) this.f.findViewById(R.id.uip_linearlayout);
        this.h = (Button) this.f.findViewById(R.id.btn_option_start);
        this.i = (Button) this.f.findViewById(R.id.btn_option_getmoretime);
        this.j = (TextView) this.f.findViewById(R.id.tv_option_duetime);
        this.k = (RelativeLayout) this.f.findViewById(R.id.rl_bottom_content_ad);
        this.l = (ImageView) this.f.findViewById(R.id.id_img_ad);
        this.m = (TextView) this.f.findViewById(R.id.tv_delete_ad);
        this.n = (TextView) this.f.findViewById(R.id.tv_ilfyad_mark);
        this.m.setTextColor(Color.parseColor("#ffffff"));
        if (com.cyjh.elfin.d.c.d) {
            button = this.i;
            i2 = 0;
        } else {
            button = this.i;
            i2 = 8;
        }
        button.setVisibility(i2);
        this.j.setVisibility(i2);
        k();
        Point a2 = com.cyjh.common.util.a.a(getContext());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        int i3 = ((int) (((float) a2.x) - (((float) a2.x) * 0.9f))) / 2;
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.g.setLayoutParams(layoutParams);
    }

    private void k() {
        String str;
        SpannableString spannableString;
        if (com.cyjh.elfin.d.c.d) {
            TextView textView = this.j;
            com.cyjh.elfin.d.c a2 = com.cyjh.elfin.d.c.a();
            if (!TextUtils.isEmpty(a2.f1864a) && a2.f1865b != -1) {
                long currentTimeMillis = (a2.f1865b - (System.currentTimeMillis() / 1000)) / 60;
                str = currentTimeMillis > 0 ? l.a(AppContext.a(), currentTimeMillis) : "";
            } else if (ParamsWrap.getParamsWrap().onceTryMinute <= 0) {
                a2.f1866c = 3;
                str = AppContext.a().getString(R.string.optionfragment_duetime_no);
            } else {
                a2.f1866c = 1;
                String format = String.format(AppContext.a().getString(R.string.optionfragment_unpaid), new Object[]{Integer.valueOf(ParamsWrap.getParamsWrap().onceTryMinute)});
                String str2 = ParamsWrap.getParamsWrap().onceTryMinute + "分钟";
                if (TextUtils.isEmpty(str2)) {
                    spannableString = null;
                } else {
                    int indexOf = format.indexOf(str2);
                    int length = (str2.length() + indexOf) - 2;
                    SpannableString spannableString2 = new SpannableString(format);
                    spannableString2.setSpan(new StyleSpan(1), indexOf, length, 17);
                    spannableString2.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf, length, 17);
                    if (!TextUtils.isEmpty("")) {
                        int indexOf2 = format.indexOf("");
                        int length2 = ("".length() + indexOf2) - 2;
                        spannableString2.setSpan(new StyleSpan(1), indexOf2, length2, 17);
                        spannableString2.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf2, length2, 17);
                        if (!TextUtils.isEmpty("")) {
                            int indexOf3 = format.indexOf("");
                            int length3 = ("".length() + indexOf3) - 1;
                            spannableString2.setSpan(new StyleSpan(1), indexOf3, length3, 17);
                            spannableString2.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf3, length3, 17);
                        }
                    }
                    spannableString = spannableString2;
                }
                str = spannableString.toString();
            }
            textView.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        Script script = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a;
        this.s = com.elfin.engin.d.a(getContext(), script.getUiFile().getPath(), script.getUipFile().getPath(), script.getCfgFile().getPath());
        try {
            LinearLayout a2 = this.s.a();
            this.s.c();
            this.s.d();
            this.g.removeAllViews();
            this.g.addView(a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void m() throws Exception {
        if (this.f2262c != null) {
            this.f2262c.c();
        }
    }

    private void n() {
        try {
            this.h.performClick();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void o() {
        if (this.p == null) {
            this.p = new a(this, (byte) 0);
        }
        this.p.start();
    }

    private void p() {
        if (this.p != null) {
            this.o = 0;
            this.p.cancel();
            this.p = null;
        }
    }

    public final int a() {
        return R.layout.fragment_scriptuip_set;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ScriptUipSetModel scriptUipSetModel = this.f2262c;
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().f2012c) {
            n.b(new File("/sdcard/elf11.txt"), "sdCardScriptFiles\n", "UTF-8");
            scriptUipSetModel.a();
        } else {
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles\n", "UTF-8");
            scriptUipSetModel.b();
        }
        org.greenrobot.eventbus.c.a().a((Object) this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 2) {
            c.a.f2893a.c().a((Context) getActivity());
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.id_img_ad) {
            this.t.d();
            p();
        } else if (id == R.id.btn_option_start) {
            this.f2261b = true;
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    boolean canDrawOverlays = Settings.canDrawOverlays(getActivity());
                    if (Build.VERSION.SDK_INT >= 26) {
                        canDrawOverlays = !ab.a().b(com.cyjh.elfin.ui.a.e.e, (Boolean) true);
                    }
                    ad.c(d, "showRunFloatJudgeOperate --> canDrawOverlays=" + canDrawOverlays);
                    if (canDrawOverlays) {
                        d();
                    } else {
                        new com.cyjh.elfin.ui.a.e(getActivity(), new a(this)).show();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                d();
            }
        } else if (id == R.id.btn_option_getmoretime) {
            FragmentActivity activity = getActivity();
            String b2 = com.cyjh.elfin.d.c.a().b();
            Intent intent = new Intent(activity, BindRegisterCodeActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(BindRegisterCodeActivity.class.getCanonicalName(), b2);
            activity.startActivity(intent);
        } else if (id == R.id.tv_delete_ad) {
            if (this.o < 5) {
                this.t.d();
                p();
                return;
            }
            p();
            this.k.setVisibility(8);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b((Object) this);
        this.r.removeCallbacksAndMessages((Object) null);
        if (this.t != null) {
            this.t.e();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    @j(a = ThreadMode.MAIN)
    public void onMessageMainThread(MsgItem msgItem) {
        int msgType = msgItem.getMsgType();
        if (msgType == 1008) {
            l();
            com.cyjh.http.c.c.c a2 = com.cyjh.http.c.c.c.a();
            a2.f2487c = new c.b() {
                public final void a(
/*
Method generation error in method: com.cyjh.elfin.floatingwindowprocess.d.a.3.a():void, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cyjh.elfin.floatingwindowprocess.d.a.3.a():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/

                public final void a(
/*
Method generation error in method: com.cyjh.elfin.floatingwindowprocess.d.a.3.a(java.lang.Object):void, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cyjh.elfin.floatingwindowprocess.d.a.3.a(java.lang.Object):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            };
            a2.a((Context) AppContext.a(), com.cyjh.elfin.d.c.a().b(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), com.cyjh.common.b.a.S);
        } else if (msgType == 10081) {
            try {
                this.s.c();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @j(a = ThreadMode.MAIN)
    public void onMessageThreadMain(MsgItem.BindRegCodeBus bindRegCodeBus) {
        if (bindRegCodeBus.getExpireTime() > 0) {
            com.elfin.engin.d.a(com.cyjh.elfin.d.c.a().b());
            com.cyjh.elfin.d.c.a().f1865b = bindRegCodeBus.getExpireTime();
            com.cyjh.elfin.d.c.a().f1866c = 0;
        } else if (bindRegCodeBus.getExpireTime() == -1) {
            com.cyjh.elfin.d.c.a().f1865b = bindRegCodeBus.getExpireTime();
        }
        k();
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(ScriptUipSetFragment.class.getCanonicalName());
    }

    @j(a = ThreadMode.MAIN)
    public void onReceiveScriptUIEvent(com.cyjh.common.e.b bVar) {
        f.a();
        f.a(AppContext.a(), "ScriptUipSetFragment onReceiveScriptUIEvent -->");
        ae.b((Context) getActivity(), "onReceiveScriptUIEvent --> 更新Script UI");
        ad.c(d, "onReceiveScriptUIEvent --> 更新Script UI");
        l();
        if (bVar.f1635a == com.cyjh.elfin.e.c.n.f1929a) {
            String a2 = com.cyjh.elfin.e.c.o.a(getActivity(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2012c);
            String b2 = com.cyjh.elfin.e.c.o.b(getActivity());
            String a3 = e.a(a2);
            String a4 = e.a(b2);
            String str = d;
            ad.c(str, "onReceiveScriptUIEvent -->scriptCFGContent=" + b2 + ",scriptUIPContent=" + a2);
            String str2 = d;
            ad.c(str2, "onReceiveScriptUIEvent -->scriptUIPContentEncoding=" + a3 + ",scriptCFGContentEncoding=" + a4);
            s.a().a(getActivity(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getId(), a2, b2, new s.a() {
                public final void a(String str) {
                    String b2 = ScriptUipSetFragment.d;
                    ad.c(b2, "onReceiveScriptUIEvent --> onSuccess=" + str);
                }

                public final void b(String str) {
                    String b2 = ScriptUipSetFragment.d;
                    ad.c(b2, "onReceiveScriptUIEvent --> onFailure=" + str + str);
                }
            });
            ab.a().a(com.cyjh.elfin.e.c.o.f1944b, com.cyjh.elfin.e.c.o.b(getActivity(), com.cyjh.elfin.floatingwindowprocess.c.c.f().f2012c));
        } else if (bVar.f1635a == com.cyjh.elfin.e.c.n.d) {
            this.r.postDelayed(new Runnable() {
                public final void run() {
                    com.cyjh.elfin.services.a.a().a(4);
                }
            }, 1000);
        }
    }

    @j(a = ThreadMode.MAIN)
    public void onReceiveSocketMessage(com.elf.studio.a.a aVar) {
        com.cyjh.elfin.services.a a2;
        int i2;
        int i3 = aVar.f2819a;
        if (i3 == 10101) {
            ad.c(d, "onReceiveSocketMessage --> 服务端命令:脚本启动");
            this.h.performClick();
            a2 = com.cyjh.elfin.services.a.a();
            i2 = 2;
        } else if (i3 == 10103) {
            ad.c(d, "onReceiveSocketMessage --> 服务端命令:脚本停止");
            this.h.performClick();
            a2 = com.cyjh.elfin.services.a.a();
            i2 = 3;
        } else if (i3 == 10107) {
            ad.c(d, "onReceiveSocketMessage --> 服务端命令:脚本设置更新");
            String str = aVar.d;
            if (!MqRunner.getInstance().isScriptStarted() && !TextUtils.isEmpty(str)) {
                String a3 = e.a(str);
                String str2 = d;
                ad.c(str2, "updateScriptSettings --> 1 服务端命令:脚本设置更新 encoding=" + a3 + ",scriptSetting=" + str);
                try {
                    String a4 = n.a(str);
                    File file = new File(o.a(getActivity().getFilesDir().getAbsolutePath(), com.cyjh.elfin.a.a.t));
                    Script script = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a;
                    boolean a5 = n.a(script.getCfgFile(), a4, "UTF-8");
                    script.setCfgFile(file.getAbsoluteFile());
                    String str3 = d;
                    ad.c(str3, "updateScriptSettings --> 2 服务端命令:脚本设置更新 toUtf8Result=" + a4 + "\ncfgFile=" + file.getAbsolutePath() + ",result=" + a5);
                    long length = script.getUipFile().length();
                    if (script.getUipFile().exists() && length > 0) {
                        LinearLayout a6 = this.s.a();
                        this.s.b();
                        this.g.removeAllViews();
                        this.g.addView(a6);
                    }
                    if (this.s != null) {
                        this.s.d();
                        this.s.b(a4);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            } else {
                return;
            }
        } else {
            return;
        }
        a2.a(i2);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(ScriptUipSetFragment.class.getCanonicalName());
        this.f2261b = false;
        k();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        setUserVisibleHint(true);
    }

    public void onStart() {
        super.onStart();
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        Button button;
        int i2;
        super.onViewCreated(view, bundle);
        if (getView() != null) {
            this.f = getView();
            this.f2262c = (ScriptUipSetModel) ViewModelProviders.of((Fragment) this).get(ScriptUipSetModel.class);
            this.f2262c.f2284b.observe(this, new Observer<Integer>() {
                private void a(@Nullable Integer num) {
                    if (num != null) {
                        if (num.intValue() == 0) {
                            ScriptUipSetFragment.this.l();
                        } else if (1 == num.intValue()) {
                            try {
                                ScriptUipSetFragment.this.s.d();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                public final /* synthetic */ void onChanged(@Nullable Object obj) {
                    Integer num = (Integer) obj;
                    if (num == null) {
                        return;
                    }
                    if (num.intValue() == 0) {
                        ScriptUipSetFragment.this.l();
                    } else if (1 == num.intValue()) {
                        try {
                            ScriptUipSetFragment.this.s.d();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            this.g = (LinearLayout) this.f.findViewById(R.id.uip_linearlayout);
            this.h = (Button) this.f.findViewById(R.id.btn_option_start);
            this.i = (Button) this.f.findViewById(R.id.btn_option_getmoretime);
            this.j = (TextView) this.f.findViewById(R.id.tv_option_duetime);
            this.k = (RelativeLayout) this.f.findViewById(R.id.rl_bottom_content_ad);
            this.l = (ImageView) this.f.findViewById(R.id.id_img_ad);
            this.m = (TextView) this.f.findViewById(R.id.tv_delete_ad);
            this.n = (TextView) this.f.findViewById(R.id.tv_ilfyad_mark);
            this.m.setTextColor(Color.parseColor("#ffffff"));
            if (com.cyjh.elfin.d.c.d) {
                button = this.i;
                i2 = 0;
            } else {
                button = this.i;
                i2 = 8;
            }
            button.setVisibility(i2);
            this.j.setVisibility(i2);
            k();
            Point a2 = com.cyjh.common.util.a.a(getContext());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            int i3 = ((int) (((float) a2.x) - (((float) a2.x) * 0.9f))) / 2;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
            this.g.setLayoutParams(layoutParams);
            if (!com.elfin.ad.e.a.a().b()) {
                this.t = new b(getActivity(), this.k);
                this.t.a(3, (com.elfin.ad.c.a) new com.elfin.ad.c.a<String>() {
                    private void c(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            Context context = ScriptUipSetFragment.this.getContext();
                            ImageView a2 = ScriptUipSetFragment.this.l;
                            if (str.endsWith(".gif")) {
                                g a3 = q.a();
                                a3.b(i.f1144c);
                                q.a(context, str, a2, a3);
                            } else {
                                g a4 = q.a();
                                a4.b(i.f1143b);
                                q.b(context, str, a2, a4);
                            }
                            ScriptUipSetFragment.b(ScriptUipSetFragment.this);
                            ScriptUipSetFragment.this.m.setVisibility(0);
                            ScriptUipSetFragment.this.k.setVisibility(0);
                        }
                    }

                    public final void a() {
                    }

                    public final /* synthetic */ void a(Object obj) {
                        String str = (String) obj;
                        if (!TextUtils.isEmpty(str)) {
                            Context context = ScriptUipSetFragment.this.getContext();
                            ImageView a2 = ScriptUipSetFragment.this.l;
                            if (str.endsWith(".gif")) {
                                g a3 = q.a();
                                a3.b(i.f1144c);
                                q.a(context, str, a2, a3);
                            } else {
                                g a4 = q.a();
                                a4.b(i.f1143b);
                                q.b(context, str, a2, a4);
                            }
                            ScriptUipSetFragment.b(ScriptUipSetFragment.this);
                            ScriptUipSetFragment.this.m.setVisibility(0);
                            ScriptUipSetFragment.this.k.setVisibility(0);
                        }
                    }

                    public final void a(String str) {
                    }

                    public final void b() {
                    }

                    public final void b(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            ScriptUipSetFragment.this.n.setText(String.format(ScriptUipSetFragment.this.getString(R.string.ad_source_mark), new Object[]{str}));
                            ScriptUipSetFragment.this.n.setVisibility(0);
                        }
                    }
                });
                this.t.b();
            }
            this.h.setOnClickListener(this);
            this.f.findViewById(R.id.btn_option_getmoretime).setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.l.setOnClickListener(this);
        }
    }
}
