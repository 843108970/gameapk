package mobi.oneway.export.Ad;

import android.app.Activity;
import mobi.oneway.export.AdListener.OWInterstitialAdListener;
import mobi.oneway.export.b.a.a;
import mobi.oneway.export.e.b;
import mobi.oneway.export.enums.AdType;

public class OWInterstitialAd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f4064a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AdType f4065b = AdType.interstitial;

    public OWInterstitialAd(final Activity activity, final String str, final OWInterstitialAdListener oWInterstitialAdListener) {
        OnewaySdk.checkSdkConfigured();
        b.a().a(new Runnable() {
            public void run() {
                a unused = OWInterstitialAd.this.f4064a = new a(OWInterstitialAd.this.f4065b, str);
                OWInterstitialAd.this.f4064a.a(activity, (Object) oWInterstitialAdListener);
            }
        });
    }

    public void destory() {
        if (this.f4064a != null) {
            this.f4064a.c();
            this.f4064a = null;
        }
    }

    public boolean isReady() {
        if (this.f4064a == null) {
            return false;
        }
        return this.f4064a.b();
    }

    public void loadAd() {
        b.a().a(new Runnable() {
            public void run() {
                if (OWInterstitialAd.this.f4064a != null) {
                    OWInterstitialAd.this.f4064a.a();
                }
            }
        });
    }

    public void setListener(final OWInterstitialAdListener oWInterstitialAdListener) {
        b.a().a(new Runnable() {
            public void run() {
                if (OWInterstitialAd.this.f4064a != null) {
                    OWInterstitialAd.this.f4064a.a(oWInterstitialAdListener);
                }
            }
        });
    }

    public void show(Activity activity) {
        show(activity, (String) null);
    }

    public void show(Activity activity, String str) {
        if (this.f4064a != null) {
            this.f4064a.a(activity, str);
        }
    }
}
