package mobi.oneway.export.f;

import android.os.Build;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mobi.oneway.export.a.b;
import mobi.oneway.export.d.f;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.EventType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.g.l;
import mobi.oneway.export.g.n;
import org.json.JSONObject;

public class e {
    private static ExecutorService g = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    private Long f4197a = 0L;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AdType f4198b;

    /* renamed from: c  reason: collision with root package name */
    private String f4199c;
    private a d;
    private String e;
    private String f;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public EventType f4201a;

        public a(EventType eventType) {
            this.f4201a = eventType;
        }

        public void run() {
            try {
                f a2 = new f(mobi.oneway.export.a.a.e, mobi.oneway.export.a.a.d).a("eventName", (Object) this.f4201a.toString()).a("publishId", (Object) b.b()).a("token", (Object) b.d()).a("adType", (Object) Integer.valueOf(e.this.f4198b.value())).a("dmd", (Object) Build.MODEL).a("dmk", (Object) Build.BRAND).a("ip", (Object) n.a(b.a())).a("osv", (Object) Build.VERSION.RELEASE);
                if (b.c()) {
                    a2.a("e", (Object) Boolean.valueOf(b.c()));
                }
                a2.c("POST").a(e.this.a()).n();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public e(AdType adType, a aVar) {
        this.f4198b = adType;
        this.d = aVar;
        this.e = aVar.g();
        this.f = aVar.f();
    }

    /* access modifiers changed from: private */
    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cid", b.a(this.d.a(), this.e, this.f));
            jSONObject.put("v", this.d.d());
            jSONObject.put("sv", mobi.oneway.export.a.f);
            jSONObject.put("ssv", mobi.oneway.export.g.f.c());
            jSONObject.put("wv", "");
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("did", mobi.oneway.export.g.f.a());
            jSONObject.put("bdid", mobi.oneway.export.g.f.b());
            jSONObject.put("dos", "Android");
            jSONObject.put("ua", mobi.oneway.export.g.f.d());
            jSONObject.put("ct", mobi.oneway.export.g.f.f());
            jSONObject.put("nt", mobi.oneway.export.g.f.g());
            jSONObject.put("osv", Build.VERSION.RELEASE);
            jSONObject.put("dmd", Build.MODEL);
            jSONObject.put("dmk", Build.BRAND);
            jSONObject.put("aid", mobi.oneway.export.g.f.e());
            jSONObject.put("bssid", mobi.oneway.export.g.f.i());
            jSONObject.put("ssid", mobi.oneway.export.g.f.h());
            jSONObject.put("simopt", mobi.oneway.export.g.f.j());
            jSONObject.put("simoptn", mobi.oneway.export.g.f.k());
            jSONObject.put("lng", l.b());
            jSONObject.put("lat", l.a());
            jSONObject.put("adp", this.d.a());
            jSONObject.put("ip", n.a(b.a()));
            jSONObject.put("adts", this.f4197a);
            jSONObject.put("crc", this.d.b());
            jSONObject.put("sc", b.e());
            jSONObject.put("slt", this.d.c());
            jSONObject.put("dt", this.f4199c);
            jSONObject.put("pid", this.e);
            jSONObject.put("thirdPid", this.f);
            jSONObject.put("oaid", c());
            return b.c() ? mobi.oneway.export.g.a.a(jSONObject.toString(), b.d(), b.b()) : jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void b() {
        this.f4197a = Long.valueOf(System.currentTimeMillis());
        b.a(this.d.a(), this.e, this.f, mobi.oneway.export.g.e.a(b.b() + "-" + this.f4198b.value() + "-" + this.f4197a).longValue());
        this.f4199c = "";
    }

    private String c() {
        try {
            Field declaredField = this.d.e().loadClass("mobi.oneway.third_common.util.oaid.OaidHolder").getDeclaredField("oaid");
            declaredField.setAccessible(true);
            return (String) declaredField.get((Object) null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (r2.f4198b.equals(mobi.oneway.export.enums.AdType.splash) != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(mobi.oneway.export.enums.EventType r3, java.lang.String r4) {
        /*
            r2 = this;
            mobi.oneway.export.f.a r0 = r2.d
            int r0 = r0.a()
            r1 = 1
            if (r0 != r1) goto L_0x000a
            return
        L_0x000a:
            int[] r0 = mobi.oneway.export.f.e.AnonymousClass1.f4200a
            int r1 = r3.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0026;
                case 2: goto L_0x001c;
                case 3: goto L_0x0029;
                case 4: goto L_0x0029;
                case 5: goto L_0x0029;
                case 6: goto L_0x0029;
                case 7: goto L_0x0029;
                case 8: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0029
        L_0x0016:
            r2.b()
            r2.f4199c = r4
            goto L_0x0029
        L_0x001c:
            mobi.oneway.export.enums.AdType r4 = r2.f4198b
            mobi.oneway.export.enums.AdType r0 = mobi.oneway.export.enums.AdType.splash
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0029
        L_0x0026:
            r2.b()
        L_0x0029:
            java.util.concurrent.ExecutorService r4 = g
            mobi.oneway.export.f.e$a r0 = new mobi.oneway.export.f.e$a
            r0.<init>(r3)
            r4.execute(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.oneway.export.f.e.a(mobi.oneway.export.enums.EventType, java.lang.String):void");
    }

    public void a(EventType eventType, OnewaySdkError onewaySdkError, String str) {
        a(eventType, onewaySdkError + "--" + str);
    }
}
