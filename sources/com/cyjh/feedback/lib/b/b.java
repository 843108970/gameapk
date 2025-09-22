package com.cyjh.feedback.lib.b;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.cyjh.feedback.libraryfeedbackinfo.R;
import com.cyjh.http.bean.request.FeedbackRequestInfo;
import com.cyjh.http.c.c.i;
import com.cyjh.http.c.c.k;
import com.cyjh.http.c.d.c;
import com.cyjh.http.oss.MyOSSUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class b extends com.cyjh.feedback.lib.base.a implements View.OnClickListener, c {
    private static final String d = "0";
    private static final int e = 1;
    private static final int f = 2;
    private static final int r = 1;
    private static final int s = 0;

    /* renamed from: c  reason: collision with root package name */
    public a f2390c;
    private Button g;
    private Button h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private FeedbackRequestInfo m;
    private c n;
    private Context o;
    private i p;
    private List<String> q;
    private volatile int t = 0;

    public interface a {
        void a(int i);
    }

    public b(Context context, FeedbackRequestInfo feedbackRequestInfo, List<String> list) {
        super(context, R.style.Theme_Dialog);
        this.m = feedbackRequestInfo;
        this.o = context;
        this.q = list;
    }

    private static SpannableStringBuilder a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#3c7ac5")), indexOf, str2.length() + indexOf, 34);
        return spannableStringBuilder;
    }

    private void a(a aVar) {
        this.f2390c = aVar;
    }

    static /* synthetic */ void a(b bVar, List list) {
        bVar.t++;
        if (bVar.t == bVar.q.size()) {
            if (list.size() > 0) {
                bVar.m.FreebackImages = (String[]) list.toArray(new String[list.size()]);
            }
            bVar.p.a(bVar.o, bVar.m);
        }
    }

    private void a(List<String> list) {
        this.t++;
        if (this.t == this.q.size()) {
            if (list.size() > 0) {
                this.m.FreebackImages = (String[]) list.toArray(new String[list.size()]);
            }
            this.p.a(this.o, this.m);
        }
    }

    private void c() {
        this.i = (TextView) findViewById(R.id.id_tv_device_name);
        this.j = (TextView) findViewById(R.id.id_tv_device_system);
        this.k = (TextView) findViewById(R.id.id_tv_device_root);
        this.l = (TextView) findViewById(R.id.id_tv_feedback_content);
        this.g = (Button) findViewById(R.id.id_btn_back);
        this.h = (Button) findViewById(R.id.id_btn_commit_feedback_info);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r6 = this;
            android.content.Context r0 = r6.o
            int r1 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_name
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.cyjh.http.bean.request.FeedbackRequestInfo r4 = r6.m
            java.lang.String r4 = r4.DeviceModel
            r5 = 0
            r3[r5] = r4
            java.lang.String r0 = r0.getString(r1, r3)
            android.widget.TextView r1 = r6.i
            com.cyjh.http.bean.request.FeedbackRequestInfo r3 = r6.m
            java.lang.String r3 = r3.DeviceModel
            android.text.SpannableStringBuilder r0 = a((java.lang.String) r0, (java.lang.String) r3)
            r1.setText(r0)
            android.content.Context r0 = r6.o
            int r1 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_use_system
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.cyjh.http.bean.request.FeedbackRequestInfo r4 = r6.m
            java.lang.String r4 = r4.AndoridVersion
            r3[r5] = r4
            java.lang.String r0 = r0.getString(r1, r3)
            android.widget.TextView r1 = r6.j
            com.cyjh.http.bean.request.FeedbackRequestInfo r3 = r6.m
            java.lang.String r3 = r3.AndoridVersion
            android.text.SpannableStringBuilder r0 = a((java.lang.String) r0, (java.lang.String) r3)
            r1.setText(r0)
            com.cyjh.http.bean.request.FeedbackRequestInfo r0 = r6.m
            int r0 = r0.RootStatus
            switch(r0) {
                case 1: goto L_0x005f;
                case 2: goto L_0x0044;
                default: goto L_0x0043;
            }
        L_0x0043:
            goto L_0x0084
        L_0x0044:
            android.content.Context r0 = r6.o
            int r1 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_is_root
            java.lang.Object[] r2 = new java.lang.Object[r2]
            android.content.Context r3 = r6.o
            int r4 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_no_root
            java.lang.String r3 = r3.getString(r4)
            r2[r5] = r3
            java.lang.String r0 = r0.getString(r1, r2)
            android.widget.TextView r1 = r6.k
            android.content.Context r2 = r6.o
            int r3 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_no_root
            goto L_0x0079
        L_0x005f:
            android.content.Context r0 = r6.o
            int r1 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_is_root
            java.lang.Object[] r2 = new java.lang.Object[r2]
            android.content.Context r3 = r6.o
            int r4 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_yes_root
            java.lang.String r3 = r3.getString(r4)
            r2[r5] = r3
            java.lang.String r0 = r0.getString(r1, r2)
            android.widget.TextView r1 = r6.k
            android.content.Context r2 = r6.o
            int r3 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_yes_root
        L_0x0079:
            java.lang.String r2 = r2.getString(r3)
            android.text.SpannableStringBuilder r0 = a((java.lang.String) r0, (java.lang.String) r2)
            r1.setText(r0)
        L_0x0084:
            com.cyjh.http.bean.request.FeedbackRequestInfo r0 = r6.m
            java.lang.String r0 = r0.Content
            java.lang.String r1 = d
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0099
            android.widget.TextView r0 = r6.l
            com.cyjh.http.bean.request.FeedbackRequestInfo r1 = r6.m
            java.lang.String r1 = r1.Content
            r0.setText(r1)
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.feedback.lib.b.b.d():void");
    }

    private void e() {
        this.h.setOnClickListener(this);
        this.g.setOnClickListener(this);
    }

    public final void a() {
        this.n.dismiss();
        if (this.f2390c != null) {
            this.f2390c.a(1);
        }
        dismiss();
    }

    public final void b() {
        this.n.dismiss();
        if (this.f2390c != null) {
            this.f2390c.a(0);
        }
        dismiss();
    }

    public final void dismiss() {
        super.dismiss();
        this.m = null;
        this.t = 0;
        if (this.p != null) {
            com.cyjh.http.d.b.c.a().a((Object) this.p.getClass().getCanonicalName());
        }
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.id_btn_back) {
            dismiss();
        } else if (id == R.id.id_btn_commit_feedback_info) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.o.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z = false;
                if (!(activeNetworkInfo != null && activeNetworkInfo.getType() == 0)) {
                    Context context = this.o;
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if ((connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || telephonyManager.getNetworkType() == 3) {
                        z = true;
                    }
                    if (!z) {
                        Toast.makeText(this.o, this.o.getString(R.string.is_net_open), 1).show();
                        return;
                    }
                }
                MyOSSUtils build = new MyOSSUtils.Builder(this.o, com.cyjh.http.b.a.a().d).build();
                if (build.isTokenExpireTime()) {
                    Toast.makeText(this.o, "阿里云Token过期，稍后再试！", 1).show();
                    new k().a(this.o);
                    return;
                }
                if (this.n == null) {
                    this.n = new c(this.o);
                }
                this.n.show();
                this.p = new i(this);
                if (this.q.size() <= 0 || com.cyjh.http.b.a.a().d == null) {
                    this.p.a(this.o, this.m);
                    return;
                }
                final ArrayList arrayList = new ArrayList();
                for (String next : this.q) {
                    File file = new File(next);
                    build.uploadFile(next, com.cyjh.http.b.a.a().d.OssStoragePath + file.getName(), new MyOSSUtils.UploadFileCallBack() {
                        public final void uploadFail(String str) {
                            b.a(b.this, arrayList);
                        }

                        public final void uploadProgress(long j, long j2) {
                        }

                        public final void uploadSuc(String str, String str2) {
                            arrayList.add(str2);
                            b.a(b.this, arrayList);
                        }
                    });
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("zzz", "FeedBackDialog--提交数据给后台：" + e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            int r6 = com.cyjh.feedback.libraryfeedbackinfo.R.layout.dialog_feedback_info
            r5.setContentView(r6)
            r6 = 1050253722(0x3e99999a, float:0.3)
            r5.a(r6)
            r6 = 1061997773(0x3f4ccccd, float:0.8)
            r0 = 1058642330(0x3f19999a, float:0.6)
            r5.a(r6, r0)
            int r6 = com.cyjh.feedback.libraryfeedbackinfo.R.id.id_tv_device_name
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.i = r6
            int r6 = com.cyjh.feedback.libraryfeedbackinfo.R.id.id_tv_device_system
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.j = r6
            int r6 = com.cyjh.feedback.libraryfeedbackinfo.R.id.id_tv_device_root
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.k = r6
            int r6 = com.cyjh.feedback.libraryfeedbackinfo.R.id.id_tv_feedback_content
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.l = r6
            int r6 = com.cyjh.feedback.libraryfeedbackinfo.R.id.id_btn_back
            android.view.View r6 = r5.findViewById(r6)
            android.widget.Button r6 = (android.widget.Button) r6
            r5.g = r6
            int r6 = com.cyjh.feedback.libraryfeedbackinfo.R.id.id_btn_commit_feedback_info
            android.view.View r6 = r5.findViewById(r6)
            android.widget.Button r6 = (android.widget.Button) r6
            r5.h = r6
            android.content.Context r6 = r5.o
            int r0 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_name
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.cyjh.http.bean.request.FeedbackRequestInfo r3 = r5.m
            java.lang.String r3 = r3.DeviceModel
            r4 = 0
            r2[r4] = r3
            java.lang.String r6 = r6.getString(r0, r2)
            android.widget.TextView r0 = r5.i
            com.cyjh.http.bean.request.FeedbackRequestInfo r2 = r5.m
            java.lang.String r2 = r2.DeviceModel
            android.text.SpannableStringBuilder r6 = a((java.lang.String) r6, (java.lang.String) r2)
            r0.setText(r6)
            android.content.Context r6 = r5.o
            int r0 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_use_system
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.cyjh.http.bean.request.FeedbackRequestInfo r3 = r5.m
            java.lang.String r3 = r3.AndoridVersion
            r2[r4] = r3
            java.lang.String r6 = r6.getString(r0, r2)
            android.widget.TextView r0 = r5.j
            com.cyjh.http.bean.request.FeedbackRequestInfo r2 = r5.m
            java.lang.String r2 = r2.AndoridVersion
            android.text.SpannableStringBuilder r6 = a((java.lang.String) r6, (java.lang.String) r2)
            r0.setText(r6)
            com.cyjh.http.bean.request.FeedbackRequestInfo r6 = r5.m
            int r6 = r6.RootStatus
            switch(r6) {
                case 1: goto L_0x00b2;
                case 2: goto L_0x0097;
                default: goto L_0x0096;
            }
        L_0x0096:
            goto L_0x00d7
        L_0x0097:
            android.content.Context r6 = r5.o
            int r0 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_is_root
            java.lang.Object[] r1 = new java.lang.Object[r1]
            android.content.Context r2 = r5.o
            int r3 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_no_root
            java.lang.String r2 = r2.getString(r3)
            r1[r4] = r2
            java.lang.String r6 = r6.getString(r0, r1)
            android.widget.TextView r0 = r5.k
            android.content.Context r1 = r5.o
            int r2 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_no_root
            goto L_0x00cc
        L_0x00b2:
            android.content.Context r6 = r5.o
            int r0 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_is_root
            java.lang.Object[] r1 = new java.lang.Object[r1]
            android.content.Context r2 = r5.o
            int r3 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_yes_root
            java.lang.String r2 = r2.getString(r3)
            r1[r4] = r2
            java.lang.String r6 = r6.getString(r0, r1)
            android.widget.TextView r0 = r5.k
            android.content.Context r1 = r5.o
            int r2 = com.cyjh.feedback.libraryfeedbackinfo.R.string.devices_yes_root
        L_0x00cc:
            java.lang.String r1 = r1.getString(r2)
            android.text.SpannableStringBuilder r6 = a((java.lang.String) r6, (java.lang.String) r1)
            r0.setText(r6)
        L_0x00d7:
            com.cyjh.http.bean.request.FeedbackRequestInfo r6 = r5.m
            java.lang.String r6 = r6.Content
            java.lang.String r0 = d
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ec
            android.widget.TextView r6 = r5.l
            com.cyjh.http.bean.request.FeedbackRequestInfo r0 = r5.m
            java.lang.String r0 = r0.Content
            r6.setText(r0)
        L_0x00ec:
            android.widget.Button r6 = r5.h
            r6.setOnClickListener(r5)
            android.widget.Button r6 = r5.g
            r6.setOnClickListener(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.feedback.lib.b.b.onCreate(android.os.Bundle):void");
    }
}
