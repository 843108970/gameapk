package mobi.oneway.export.b.a;

import android.app.Activity;
import java.util.List;
import mobi.oneway.export.AdListener.AdMonitor;
import mobi.oneway.export.AdListener.OWInteractiveAdListener;
import mobi.oneway.export.b.b.b;
import mobi.oneway.export.b.b.e;
import mobi.oneway.export.b.b.f;
import mobi.oneway.export.b.b.g;
import mobi.oneway.export.b.b.h;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.f.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Object f4128a;

    /* renamed from: b  reason: collision with root package name */
    private AdType f4129b;

    /* renamed from: c  reason: collision with root package name */
    private List<mobi.oneway.export.f.a> f4130c;
    private b d;

    public a(AdType adType, String str) {
        this.f4129b = adType;
        this.f4130c = d.a(str, adType);
    }

    private void a(OnewaySdkError onewaySdkError, String str) {
        if (this.f4128a != null) {
            switch (this.f4129b) {
                case rewarded:
                case interstitial:
                case interstitialimage:
                    ((AdMonitor) this.f4128a).onSdkError(onewaySdkError, str);
                    return;
                case interactive:
                    ((OWInteractiveAdListener) this.f4128a).onSdkError(onewaySdkError, str);
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        b hVar;
        List<String> a2 = d.a(this.f4130c);
        long c2 = mobi.oneway.export.b.a.a().c();
        switch (this.f4129b) {
            case rewarded:
                hVar = new h(this.f4129b, a2, c2);
                break;
            case interstitial:
                hVar = new f(this.f4129b, a2, c2);
                break;
            case interactive:
                this.d = new e(this.f4129b, a2, c2);
                return;
            case interstitialimage:
                hVar = new g(this.f4129b, a2, c2);
                break;
            default:
                return;
        }
        this.d = hVar;
    }

    public void a() {
        if (this.f4130c == null) {
            OnewaySdkError onewaySdkError = OnewaySdkError.LOAD_ERROR;
            a(onewaySdkError, this.f4129b.name() + mobi.oneway.export.a.a.m);
            return;
        }
        if (this.d != null) {
            this.d.c();
        }
        for (mobi.oneway.export.f.a a2 : this.f4130c) {
            a2.a(this.f4129b);
        }
    }

    public void a(Activity activity, Object obj) {
        this.f4128a = obj;
        if (this.f4130c != null) {
            d();
            if (this.d != null) {
                this.d.a(obj);
            }
            for (mobi.oneway.export.f.a next : this.f4130c) {
                switch (this.f4129b) {
                    case rewarded:
                        next.a(activity, (h) this.d);
                        break;
                    case interstitial:
                        next.a(activity, (f) this.d);
                        break;
                    case interactive:
                        next.a(activity, (e) this.d);
                        break;
                    case interstitialimage:
                        next.a(activity, (g) this.d);
                        break;
                }
            }
        }
    }

    public void a(Activity activity, String str) {
        if (str == null) {
            str = "";
        }
        if (this.f4130c != null) {
            for (mobi.oneway.export.f.a next : this.f4130c) {
                if (next.b(this.f4129b)) {
                    next.a(this.f4129b, activity, str);
                    return;
                }
            }
        }
    }

    public void a(Object obj) {
        this.f4128a = obj;
        if (this.f4130c != null) {
            if (this.d != null) {
                this.d.a(obj);
            }
            for (mobi.oneway.export.f.a next : this.f4130c) {
                switch (this.f4129b) {
                    case rewarded:
                        next.a((h) this.d);
                        break;
                    case interstitial:
                        next.a((f) this.d);
                        break;
                    case interactive:
                        next.a((e) this.d);
                        break;
                    case interstitialimage:
                        next.a((g) this.d);
                        break;
                }
            }
        }
    }

    public boolean b() {
        if (this.f4130c == null || this.d == null || !this.d.b()) {
            return false;
        }
        for (mobi.oneway.export.f.a b2 : this.f4130c) {
            if (b2.b(this.f4129b)) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        this.f4128a = null;
        if (this.d != null) {
            this.d.a(null);
            this.d = null;
        }
        if (this.f4130c != null) {
            for (mobi.oneway.export.f.a c2 : this.f4130c) {
                c2.c(this.f4129b);
            }
        }
    }
}
