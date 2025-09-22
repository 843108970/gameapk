package mobi.oneway.export.Ad;

import android.app.Activity;
import android.view.ViewGroup;
import mobi.oneway.export.AdListener.OWSplashAdListener;
import mobi.oneway.export.b.a.c;
import mobi.oneway.export.e.b;
import mobi.oneway.export.e.d;
import mobi.oneway.export.enums.OnewaySdkError;

public class OWSplashAd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public c f4088a;

    public OWSplashAd(String str) {
        this.f4088a = new c(str);
    }

    public void show(Activity activity, ViewGroup viewGroup, OWSplashAdListener oWSplashAdListener) {
        show(activity, viewGroup, oWSplashAdListener, 0);
    }

    public void show(Activity activity, ViewGroup viewGroup, final OWSplashAdListener oWSplashAdListener, long j) {
        OnewaySdk.checkSdkConfigured();
        final Activity activity2 = activity;
        final ViewGroup viewGroup2 = viewGroup;
        final OWSplashAdListener oWSplashAdListener2 = oWSplashAdListener;
        final long j2 = j;
        final AnonymousClass1 r0 = new Runnable() {
            public void run() {
                OWSplashAd.this.f4088a.a(activity2, viewGroup2, oWSplashAdListener2, j2);
            }
        };
        b.a().a(r0);
        new d(new d.a() {
            public void timeout() {
                oWSplashAdListener.onAdError(OnewaySdkError.SHOW_ERROR, "Show splash ad timeout");
                b.a().b(r0);
            }
        }, j).start();
    }
}
