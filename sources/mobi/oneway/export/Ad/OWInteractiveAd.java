package mobi.oneway.export.Ad;

import android.app.Activity;
import mobi.oneway.export.AdListener.OWInteractiveAdListener;
import mobi.oneway.export.b.a.a;
import mobi.oneway.export.e.b;
import mobi.oneway.export.enums.AdType;

public class OWInteractiveAd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f4056a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AdType f4057b = AdType.interactive;

    public OWInteractiveAd(final Activity activity, final String str, final OWInteractiveAdListener oWInteractiveAdListener) {
        OnewaySdk.checkSdkConfigured();
        b.a().a(new Runnable() {
            public void run() {
                a unused = OWInteractiveAd.this.f4056a = new a(OWInteractiveAd.this.f4057b, str);
                OWInteractiveAd.this.f4056a.a(activity, (Object) oWInteractiveAdListener);
            }
        });
    }

    public void destory() {
        if (this.f4056a != null) {
            this.f4056a.c();
            this.f4056a = null;
        }
    }

    public boolean isReady() {
        if (this.f4056a == null) {
            return false;
        }
        return this.f4056a.b();
    }

    public void loadAd() {
        b.a().a(new Runnable() {
            public void run() {
                if (OWInteractiveAd.this.f4056a != null) {
                    OWInteractiveAd.this.f4056a.a();
                }
            }
        });
    }

    public void setListener(final OWInteractiveAdListener oWInteractiveAdListener) {
        b.a().a(new Runnable() {
            public void run() {
                if (OWInteractiveAd.this.f4056a != null) {
                    OWInteractiveAd.this.f4056a.a(oWInteractiveAdListener);
                }
            }
        });
    }

    public void show(Activity activity) {
        show(activity, (String) null);
    }

    public void show(Activity activity, String str) {
        if (this.f4056a != null) {
            this.f4056a.a(activity, str);
        }
    }
}
