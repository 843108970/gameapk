package mobi.oneway.export.f;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.Map;
import mobi.oneway.export.b.a;
import mobi.oneway.export.b.b.b;
import mobi.oneway.export.b.b.e;
import mobi.oneway.export.b.b.f;
import mobi.oneway.export.b.b.i;
import mobi.oneway.export.e.c;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.enums.PluginErrorType;
import mobi.oneway.export.f.a.d;
import mobi.oneway.export.f.a.h;
import mobi.oneway.export.g.g;
import mobi.oneway.export.g.m;
import mobi.oneway.export.plugin.BaseAd;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f4178a;

    /* renamed from: b  reason: collision with root package name */
    private BaseAd f4179b;

    /* renamed from: c  reason: collision with root package name */
    private Class f4180c;
    private long d = -1;
    private long e;
    private String f;
    private ClassLoader g;
    private String h;
    private String i;
    private String j;
    private String k;
    private mobi.oneway.export.f.a.a l;

    public a(g gVar, String str, String str2) {
        this.f4178a = gVar.a();
        this.f4180c = gVar.b();
        this.f = gVar.d();
        this.g = gVar.c();
        this.e = gVar.e();
        this.j = gVar.f();
        this.h = str2;
        this.i = str;
        if (TextUtils.isEmpty(str2) || str.equals(str2)) {
            this.k = str;
        } else {
            this.k = str + "-" + str2;
        }
        a(this.j, (Map<String, String>) null);
        a(m.a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private mobi.oneway.export.f.a.a a(mobi.oneway.export.enums.AdType r2, mobi.oneway.export.b.b.b r3) {
        /*
            r1 = this;
            int[] r0 = mobi.oneway.export.f.a.AnonymousClass1.f4181a
            int r2 = r2.ordinal()
            r2 = r0[r2]
            switch(r2) {
                case 1: goto L_0x002a;
                case 2: goto L_0x0024;
                case 3: goto L_0x001e;
                case 4: goto L_0x0018;
                case 5: goto L_0x0012;
                case 6: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0031
        L_0x000c:
            mobi.oneway.export.f.a.h r2 = new mobi.oneway.export.f.a.h
            r2.<init>(r1)
            goto L_0x002f
        L_0x0012:
            mobi.oneway.export.f.a.c r2 = new mobi.oneway.export.f.a.c
            r2.<init>(r1)
            goto L_0x002f
        L_0x0018:
            mobi.oneway.export.f.a.d r2 = new mobi.oneway.export.f.a.d
            r2.<init>(r1)
            goto L_0x002f
        L_0x001e:
            mobi.oneway.export.f.a.e r2 = new mobi.oneway.export.f.a.e
            r2.<init>(r1)
            goto L_0x002f
        L_0x0024:
            mobi.oneway.export.f.a.f r2 = new mobi.oneway.export.f.a.f
            r2.<init>(r1)
            goto L_0x002f
        L_0x002a:
            mobi.oneway.export.f.a.g r2 = new mobi.oneway.export.f.a.g
            r2.<init>(r1)
        L_0x002f:
            r1.l = r2
        L_0x0031:
            mobi.oneway.export.f.a.a r2 = r1.l
            if (r2 == 0) goto L_0x003a
            mobi.oneway.export.f.a.a r2 = r1.l
            r2.a((mobi.oneway.export.b.b.d) r3)
        L_0x003a:
            mobi.oneway.export.f.a.a r2 = r1.l
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.oneway.export.f.a.a(mobi.oneway.export.enums.AdType, mobi.oneway.export.b.b.b):mobi.oneway.export.f.a.a");
    }

    private void a(Exception exc) {
        c.a(PluginErrorType.shell_error_reflectMethod, g.a((Throwable) exc));
    }

    private void a(String str, Map<String, String> map) {
        try {
            this.f4179b = (BaseAd) this.f4180c.getConstructor(new Class[]{String.class, Map.class}).newInstance(new Object[]{str, map});
            this.f4179b.setAdConfig(i());
        } catch (Exception e2) {
            e2.printStackTrace();
            a(e2);
        }
    }

    private boolean h() {
        if (!mobi.oneway.export.b.a.a().a(this.i, this.h)) {
            mobi.oneway.export.b.a.a().a(a.C0064a.TYPE_REQUEST, this.i, this.h);
            return false;
        } else if (this.l == null) {
            return true;
        } else {
            this.l.b(OnewaySdkError.LOAD_ERROR, mobi.oneway.export.a.a.n);
            return true;
        }
    }

    private String i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cacheAd", mobi.oneway.export.b.a.a().b());
            jSONObject.put("placements", new JSONArray(d.a()));
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public int a() {
        return this.f4178a;
    }

    public void a(Activity activity, ViewGroup viewGroup, i iVar, long j2) {
        if (this.f4179b != null) {
            h hVar = (h) a(AdType.splash, (b) iVar);
            if (!h()) {
                this.f4179b.showSplashAd(activity, this.k, viewGroup, hVar, j2);
            }
        }
    }

    public void a(Activity activity, e eVar) {
        if (this.f4179b != null) {
            this.f4179b.initInteractiveAd(activity, this.k, (d) a(AdType.interactive, (b) eVar));
        }
    }

    public void a(Activity activity, f fVar) {
        if (this.f4179b != null) {
            this.f4179b.initInterstitialAd(activity, this.k, (mobi.oneway.export.f.a.f) a(AdType.interstitial, (b) fVar));
        }
    }

    public void a(Activity activity, mobi.oneway.export.b.b.g gVar) {
        if (this.f4179b != null) {
            this.f4179b.initInterstitialImageAd(activity, this.k, (mobi.oneway.export.f.a.e) a(AdType.interstitialimage, (b) gVar));
        }
    }

    public void a(Activity activity, mobi.oneway.export.b.b.h hVar) {
        if (this.f4179b != null) {
            this.f4179b.initRewardAd(activity, this.k, (mobi.oneway.export.f.a.g) a(AdType.rewarded, (b) hVar));
        }
    }

    public void a(Context context, mobi.oneway.export.b.b.c cVar) {
        if (this.f4179b != null) {
            mobi.oneway.export.f.a.c cVar2 = (mobi.oneway.export.f.a.c) a(AdType.feed, (b) cVar);
            if (!h()) {
                this.f4179b.loadFeedAd(context, this.k, cVar2);
            }
        }
    }

    public void a(e eVar) {
        if (this.f4179b != null) {
            this.f4179b.setInteractiveAdListener(this.k, (d) a(AdType.interactive, (b) eVar));
        }
    }

    public void a(f fVar) {
        if (this.f4179b != null) {
            this.f4179b.setInterstitialAdListener(this.k, (mobi.oneway.export.f.a.f) a(AdType.interstitial, (b) fVar));
        }
    }

    public void a(mobi.oneway.export.b.b.g gVar) {
        if (this.f4179b != null) {
            this.f4179b.setInterstitialImageAdListener(this.k, (mobi.oneway.export.f.a.e) a(AdType.interstitialimage, (b) gVar));
        }
    }

    public void a(mobi.oneway.export.b.b.h hVar) {
        if (this.f4179b != null) {
            this.f4179b.setRewardAdListener(this.k, (mobi.oneway.export.f.a.g) a(AdType.rewarded, (b) hVar));
        }
    }

    public void a(AdType adType) {
        if (this.f4179b != null && !h()) {
            switch (adType) {
                case rewarded:
                    this.f4179b.loadRewardAd(this.k);
                    return;
                case interstitial:
                    this.f4179b.loadInterstitialAd(this.k);
                    return;
                case interstitialimage:
                    this.f4179b.loadInterstitialImageAd(this.k);
                    return;
                case interactive:
                    this.f4179b.loadInteractiveAd(this.k);
                    return;
                default:
                    return;
            }
        }
    }

    public void a(AdType adType, Activity activity, String str) {
        if (this.f4179b != null) {
            switch (adType) {
                case rewarded:
                    this.f4179b.showRewardAd(activity, this.k, str);
                    return;
                case interstitial:
                    this.f4179b.showInterstitialAd(activity, this.k, str);
                    return;
                case interstitialimage:
                    this.f4179b.showInterstitialImageAd(activity, this.k, str);
                    return;
                case interactive:
                    this.f4179b.showInteractiveAd(activity, this.k, str);
                    return;
                default:
                    return;
            }
        }
    }

    public void a(boolean z) {
        if (this.f4179b != null) {
            this.f4179b.setDebugMode(z);
        }
    }

    public long b() {
        if (this.d != -1 || this.f4179b == null) {
            return 0;
        }
        return this.f4179b.getCrc();
    }

    public boolean b(AdType adType) {
        if (this.f4179b == null) {
            return false;
        }
        switch (adType) {
            case rewarded:
                return this.f4179b.isRewardAdReady(this.k);
            case interstitial:
                return this.f4179b.isInterstitialAdReady(this.k);
            case interstitialimage:
                return this.f4179b.isInterstitialImageAdReady(this.k);
            case interactive:
                return this.f4179b.isInteractiveAdReady(this.k);
            default:
                return false;
        }
    }

    public long c() {
        return this.e;
    }

    public void c(AdType adType) {
        if (this.f4179b != null) {
            this.f4179b.destoryAd(adType, this.k);
            if (this.l != null) {
                this.l.a((mobi.oneway.export.b.b.d) null);
                this.l = null;
            }
        }
    }

    public String d() {
        return this.f;
    }

    public boolean d(AdType adType) {
        if (adType == AdType.splash) {
            return true;
        }
        String str = "";
        switch (adType) {
            case rewarded:
                str = "hasRewardAd";
                break;
            case interstitial:
                str = "hasInterstitialAd";
                break;
            case interstitialimage:
                str = "hasInterstitialImageAd";
                break;
            case interactive:
                str = "hasInteractiveAd";
                break;
            case feed:
                str = "hasFeedAd";
                break;
        }
        try {
            if (this.f4179b != null) {
                Field declaredField = this.f4179b.getClass().getSuperclass().getDeclaredField(str);
                declaredField.setAccessible(true);
                return ((Boolean) declaredField.get(this.f4179b)).booleanValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            a(e2);
        }
        return false;
    }

    public ClassLoader e() {
        return this.g;
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }
}
