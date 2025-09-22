package mobi.oneway.export.Ad;

import android.app.Activity;
import mobi.oneway.export.AdListener.OWRewardedAdListener;
import mobi.oneway.export.b.a.a;
import mobi.oneway.export.e.b;
import mobi.oneway.export.enums.AdType;

public class OWRewardedAd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f4080a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AdType f4081b = AdType.rewarded;

    public OWRewardedAd(final Activity activity, final String str, final OWRewardedAdListener oWRewardedAdListener) {
        OnewaySdk.checkSdkConfigured();
        b.a().a(new Runnable() {
            public void run() {
                a unused = OWRewardedAd.this.f4080a = new a(OWRewardedAd.this.f4081b, str);
                OWRewardedAd.this.f4080a.a(activity, (Object) oWRewardedAdListener);
            }
        });
    }

    public void destory() {
        if (this.f4080a != null) {
            this.f4080a.c();
            this.f4080a = null;
        }
    }

    public boolean isReady() {
        if (this.f4080a == null) {
            return false;
        }
        return this.f4080a.b();
    }

    public void loadAd() {
        b.a().a(new Runnable() {
            public void run() {
                if (OWRewardedAd.this.f4080a != null) {
                    OWRewardedAd.this.f4080a.a();
                }
            }
        });
    }

    public void setListener(final OWRewardedAdListener oWRewardedAdListener) {
        b.a().a(new Runnable() {
            public void run() {
                if (OWRewardedAd.this.f4080a != null) {
                    OWRewardedAd.this.f4080a.a(oWRewardedAdListener);
                }
            }
        });
    }

    public void show(Activity activity) {
        show(activity, (String) null);
    }

    public void show(Activity activity, String str) {
        if (this.f4080a != null) {
            this.f4080a.a(activity, str);
        }
    }
}
