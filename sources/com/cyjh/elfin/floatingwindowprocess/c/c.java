package com.cyjh.elfin.floatingwindowprocess.c;

import android.text.TextUtils;
import android.util.Base64;
import com.cyjh.common.a.a;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.af;
import com.cyjh.common.util.r;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.l;
import com.cyjh.elfin.e.c.o;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.floatingwindowprocess.d.b;
import com.cyjh.http.bean.request.EngineParams;
import com.ywfzjbcy.R;
import java.io.File;
import java.io.FileInputStream;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2010b = false;
    private static final String f = "RunScriptManager";
    private static final c g = new c();

    /* renamed from: a  reason: collision with root package name */
    public Script f2011a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2012c;
    public int d = 0;
    public long e;

    private void a(long j) {
        this.e = j;
    }

    public static String c() {
        return new String(Base64.decode("LS0tLS1CRUdJTiBSU0EgUFJJVkFURSBLRVktLS0tLQpNSUlDWEFJQkFBS0JnUUNWTkNFeFpsK1NaQVFOaGtSMUtYZGFmdDY0b0c4OEZqeW1QK2lLOWw1VFZ0NytWcFV3CmJKNC9obDlVWHFyRk1Rc3JBbTlkMi80Tk4zTGF6K0t0aFdPQ2pOUkRXZ01nMHhoWFJnNm5zMGhLUkZaQ0Vhc2MKTVg1aW9XMElGZi9XcUZrYVlFbk10Z25KV3JPdlBGUy9GUE5Jazg0VFpBRGZBa3R6U1JKdythTnpGd0lEQVFBQgpBb0dBSWRDWHVUOXZaNWtkUmdkcEduaVVZVUVocnd4RlNZUHNxTzBSQWZXR09UTVdCT1NRbVZIMHA0Y0hzZkptCmw1eGU0SmVEcit6ODdmZmtJdTA4ZllFZXBRNFk1ZU1OSjhUNE8zVjhNbGhxS0FwSlB5VndMTnpkMmZDWGIzdkoKamtVQzArQ0pCNjc2N2VIR29SdmxQVDJUa1VPc3NNTlByaU0wWEs0dDlpUEt6emtDUVFET0s0dTlUZTIzTTdJUQpNZjNTUVRCdHdUK1Npak9IUHg2UVNhT2Vtdkd2TzhneG0wc2EzN1IxZlRVa001WmVWemF2WjVTbkxHbllEaXRjCnh2Q3RRNkJOQWtFQXVVUGZSYVp5OXZDbXNwRTU5VGdjYnVOTnMycHVQWEdocnRaWkh4emlHaXV5aWtwVVQ1TnAKSFF3WXZSbzZYYUFzdVV1RGk5c2pLUDFrQWZkYUFWQnk4d0pCQUtxK25haFYxYjJYN3F4QytyY2FqZ1VYdXBLZQpLamFrSzZmTGxOcFI4RDd6LzhRMW5HblJReDdhWnh4b0xPeE14bGxXSzJLWUFjQ1JXNUFtb2tTY2NURUNRRzMzCjZLN2FKMEdIQlJ2WGNsU3BjczhyWXpMTlNSUjF2NmdkR1plTE9IYWFXNGNVcWNqMlVoMW8wY0psc0NGazgwY2wKbUxiS1k2dHdCUTNadWZZdnY1c0NRQ2FXbjRrRHQ5ampodVAwK1BianpjbDc1TWl4Zm5aUExTaldraHFndjBUTwpPR1c0aU94S3BERjdRMU1CaU1ja3lteml0YWIzR0J5NE93ZDNRQy93bmswPQotLS0tLUVORCBSU0EgUFJJVkFURSBLRVktLS0tLQo=", 0));
    }

    public static String d() {
        return new String(Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUlHZk1BMEdDU3FHU0liM0RRRUJBUVVBQTRHTkFEQ0JpUUtCZ1FEUTZhRjF5WFFNMmRTNldsNUlVa3BJQVBhZApQcHl0OHFraFdTRncwT3BtRHhUUEJPbm5GLzNWMEhVYmN1MEUreE81NDJzYkhYMVBZWkQxT1N0SEJZT2N2YzJJCnVLYTdkbC9BL3V5d0haNGZWeFNLWHJnZTNNdXZEWjZrZWZiSkVjRGFDTHVjK1RPdGo3L0hsRHBibEpFN3NSVnQKQ1l4TlFwMFQzYjNPb2t5RG53SURBUUFCCi0tLS0tRU5EIFBVQkxJQyBLRVktLS0tLQo=", 0));
    }

    public static c f() {
        return g;
    }

    private static void g() {
    }

    private Script h() {
        return this.f2011a;
    }

    private void i() {
        b();
    }

    private static String j() {
        if (a.i().endsWith("/")) {
            return a.i();
        }
        return a.i() + "/";
    }

    private boolean k() {
        if (this.f2011a == null || TextUtils.isEmpty(this.f2011a.getAppId())) {
            return this.f2011a != null && TextUtils.isEmpty(this.f2011a.getVersion());
        }
        return true;
    }

    private boolean l() {
        return o.c(AppContext.a(), this.f2012c);
    }

    public final void a() {
        if (this.f2011a != null) {
            ad.c(f, "initMQScript initScript4Run =" + this.f2011a.toString());
            b.j();
            b.a(this.f2011a.getLcFile().getAbsolutePath(), this.f2011a.getAtcFile().getAbsolutePath(), this.f2011a.getCfgFile().getAbsolutePath(), this.e, ParamsWrap.getParamsWrap().getScriptEncryptKey(), AppContext.a().getString(R.string.pay_appid), AppContext.a().getString(R.string.pay_vsersion));
            return;
        }
        throw new RuntimeException("script info not exist");
    }

    public final void b() {
        String str = AppContext.a().getFilesDir() + File.separator + com.cyjh.elfin.a.b.au;
        File file = new File(str, com.cyjh.elfin.a.a.n);
        File file2 = new File(str, com.cyjh.elfin.a.a.o);
        File file3 = new File(str, com.cyjh.elfin.a.a.p);
        File file4 = new File(str, com.cyjh.elfin.a.a.q);
        File file5 = new File(str, com.cyjh.elfin.a.a.r);
        File file6 = new File(str, com.cyjh.elfin.a.a.s);
        String absolutePath = AppContext.a().getFilesDir().getAbsolutePath();
        File file7 = new File(com.cyjh.common.util.o.a(absolutePath, com.cyjh.elfin.a.a.n));
        File file8 = new File(com.cyjh.common.util.o.a(absolutePath, com.cyjh.elfin.a.a.o));
        File file9 = new File(com.cyjh.common.util.o.a(absolutePath, com.cyjh.elfin.a.a.p));
        File file10 = new File(com.cyjh.common.util.o.a(absolutePath, com.cyjh.elfin.a.a.q));
        File file11 = new File(com.cyjh.common.util.o.a(absolutePath, com.cyjh.elfin.a.a.r));
        File file12 = new File(com.cyjh.common.util.o.a(absolutePath, com.cyjh.elfin.a.a.s));
        File file13 = file7;
        File file14 = new File(com.cyjh.common.util.o.a(absolutePath, com.cyjh.elfin.a.a.t));
        this.f2012c = file.exists() || file2.exists() || file3.exists() || file4.exists() || file5.exists() || file6.exists();
        File file15 = file;
        ad.c(f, "initMQScript --> 1 isUseSdcardScript=" + this.f2012c);
        if (this.f2012c) {
            if (1 == o.c(AppContext.a())) {
                this.f2012c = true;
            } else {
                this.f2012c = false;
            }
        }
        try {
            this.f2011a = l.a(this.f2012c ? new FileInputStream(file2) : AppContext.a().getAssets().open(com.cyjh.elfin.a.a.o));
            this.f2011a.setLcFile(this.f2012c ? file15 : file13);
            Script script = this.f2011a;
            if (!this.f2012c) {
                file2 = file8;
            }
            script.setPropFile(file2);
            Script script2 = this.f2011a;
            if (!this.f2012c) {
                file3 = file9;
            }
            script2.setAtcFile(file3);
            Script script3 = this.f2011a;
            if (!this.f2012c) {
                file4 = file10;
            }
            script3.setUiFile(file4);
            Script script4 = this.f2011a;
            if (this.f2012c) {
                file11 = file5;
            }
            script4.setUipFile(file11);
            Script script5 = this.f2011a;
            if (this.f2012c) {
                file12 = file6;
            }
            script5.setRtdFile(file12);
            this.f2011a.setCfgFile(file14);
            af.a().a(this.f2011a.getVersion());
            if (this.f2012c) {
                b.j();
                b.a(g.e(), c(), d());
            }
            ad.c(f, "initMQScript --> 3 cfgFile absolutePath = " + this.f2011a.getCfgFile().getAbsolutePath() + ",isUseSdcardScript=" + this.f2012c);
            ad.c(f, "initMQScript --> 4 AppId=" + this.f2011a.getAppId() + ",Version=" + this.f2011a.getVersion());
            StringBuilder sb = new StringBuilder("initMQScript --> 5 mScript=");
            sb.append(this.f2011a.toString());
            ad.c(f, sb.toString());
        } catch (Exception e2) {
            Exception exc = e2;
            exc.printStackTrace();
            ad.c(f, "initMQScript --> ex= " + exc.getMessage());
        }
    }

    public final String e() {
        String str;
        EngineParams engineParams = new EngineParams(com.cyjh.http.b.a.a().b(AppContext.a()));
        engineParams.PackageName = AppContext.a().getPackageName();
        if (a.i().endsWith("/")) {
            str = a.i();
        } else {
            str = a.i() + "/";
        }
        engineParams.BaseURL = str;
        engineParams.PayAppId = this.f2011a.getAppId();
        engineParams.ScriptType = (this.f2011a == null || !TextUtils.isEmpty(this.f2011a.getAppId())) && (this.f2011a == null || !TextUtils.isEmpty(this.f2011a.getVersion()));
        engineParams.AppVersion = (this.f2011a == null || !TextUtils.isEmpty(this.f2011a.getVersion())) ? this.f2011a.getVersion() : AppContext.a().getString(R.string.pay_vsersion);
        engineParams.authDesKeys = a.f1620c;
        return r.a((Object) engineParams);
    }
}
