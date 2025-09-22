package mobi.oneway.export.Ad;

import android.app.Activity;
import mobi.oneway.export.AdListener.OWInterstitialImageAdListener;
import mobi.oneway.export.b.a.a;
import mobi.oneway.export.e.b;
import mobi.oneway.export.enums.AdType;

public class OWInterstitialImageAd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f4072a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AdType f4073b = AdType.interstitialimage;

    public OWInterstitialImageAd(final Activity activity, final String str, final OWInterstitialImageAdListener oWInterstitialImageAdListener) {
        OnewaySdk.checkSdkConfigured();
        b.a().a(new Runnable() {
            public void run() {
                a unused = OWInterstitialImageAd.this.f4072a = new a(OWInterstitialImageAd.this.f4073b, str);
                OWInterstitialImageAd.this.f4072a.a(activity, (Object) oWInterstitialImageAdListener);
            }
        });
    }

    public void destory() {
        if (this.f4072a != null) {
            this.f4072a.c();
            this.f4072a = null;
        }
    }

    public boolean isReady() {
        if (this.f4072a == null) {
            return false;
        }
        return this.f4072a.b();
    }

    public void loadAd() {
        b.a().a(new Runnable() {
            public void run() {
                if (OWInterstitialImageAd.this.f4072a != null) {
                    OWInterstitialImageAd.this.f4072a.a();
                }
            }
        });
    }

    public void setListener(final OWInterstitialImageAdListener oWInterstitialImageAdListener) {
        b.a().a(new Runnable() {
            public void run() {
                if (OWInterstitialImageAd.this.f4072a != null) {
                    OWInterstitialImageAd.this.f4072a.a(oWInterstitialImageAdListener);
                }
            }
        });
    }

    public void show(Activity activity) {
        show(activity, (String) null);
    }

    public void show(Activity activity, String str) {
        if (this.f4072a != null) {
            this.f4072a.a(activity, str);
        }
    }
}
