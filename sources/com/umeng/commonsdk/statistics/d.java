package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.a;
import com.umeng.commonsdk.framework.b;
import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ad;
import com.umeng.commonsdk.proguard.as;
import com.umeng.commonsdk.proguard.q;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.idtracking.g;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.c;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.noise.ImLatent;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static final int f3888b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3889c = 2;
    private static final int d = 3;
    private static final String p = "thtstart";
    private static final String q = "gkvc";
    private static final String r = "ekvc";

    /* renamed from: a  reason: collision with root package name */
    String f3890a = null;
    private final int e = 1;
    private c f;
    private g g;
    private e h;
    private g.a i = null;
    /* access modifiers changed from: private */
    public ABTest j = null;
    /* access modifiers changed from: private */
    public ImLatent k = null;
    /* access modifiers changed from: private */
    public Defcon l = null;
    private long m = 0;
    private int n = 0;
    private int o = 0;
    /* access modifiers changed from: private */
    public Context s;
    private ReportPolicy.ReportStrategy t = null;

    public d(Context context) {
        this.s = context;
        this.i = g.a(this.s).b();
        this.j = ABTest.getService(this.s);
        this.l = Defcon.getService(this.s);
        this.k = ImLatent.getService(this.s, StatTracer.getInstance(this.s));
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.s);
        this.m = sharedPreferences.getLong(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.o = sharedPreferences.getInt(r, 0);
        this.f3890a = UMEnvelopeBuild.imprintProperty(this.s, "track_list", (String) null);
        this.g = g.a(this.s);
        this.g.a((com.umeng.commonsdk.statistics.internal.d) new com.umeng.commonsdk.statistics.internal.d() {
            public void onImprintChanged(g.a aVar) {
                d.this.j.onImprintChanged(aVar);
                d.this.l.onImprintChanged(aVar);
                d.this.k.onImprintChanged(aVar);
                d.this.f3890a = UMEnvelopeBuild.imprintProperty(d.this.s, "track_list", (String) null);
                try {
                    q qVar = new q(d.this.s);
                    String a2 = a.a(d.this.s, v.d, (String) null);
                    String g = qVar.g();
                    if (TextUtils.isEmpty(a2)) {
                        return;
                    }
                    if (TextUtils.isEmpty(g) || !a2.equals(g)) {
                        qVar.a(a2);
                    }
                } catch (Throwable unused) {
                }
            }
        });
        this.h = e.a(this.s);
        this.f = new c(this.s);
        this.f.a(StatTracer.getInstance(this.s));
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new ad(new as.a()).a((aa) response, bArr);
            if (response.resp_code == 1) {
                this.g.b(response.getImprint());
                this.g.c();
            }
            MLog.i("send log:" + response.getMsg());
        } catch (Throwable th) {
            com.umeng.commonsdk.proguard.e.a(this.s, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }

    public boolean a() {
        if (!this.l.isOpen()) {
            if (!((this.t instanceof ReportPolicy.LatentPolicy) && this.t.isValid()) && this.k.shouldStartLatency()) {
                this.t = new ReportPolicy.LatentPolicy((int) this.k.getDelayTime());
                return true;
            }
        }
        return false;
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] a2 = b.a(file.getPath());
            if (a2 == null) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a.a(this.s).b(file.getName());
            byte[] a3 = this.f.a(a2, com.umeng.commonsdk.statistics.internal.a.a(this.s).a(file.getName()));
            int a4 = a3 == null ? 1 : a(a3);
            switch (a4) {
                case 2:
                    this.h.d();
                    break;
                case 3:
                    break;
            }
            StatTracer.getInstance(this.s).saveSate();
            return a4 == 2;
        } catch (Throwable th) {
            com.umeng.commonsdk.proguard.e.a(this.s, th);
            return false;
        }
    }

    public int b() {
        this.k.getDelayTime();
        return (int) (System.currentTimeMillis() - StatTracer.getInstance(this.s).getLastReqTime());
    }
}
