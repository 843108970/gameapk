package mobi.oneway.export.b.b;

import java.util.List;
import mobi.oneway.export.AdListener.OWSplashAdListener;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.OnewayAdCloseType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.feed.IFeedAd;

public class i extends b<OWSplashAdListener> {
    public i(AdType adType, List<String> list, long j) {
        super(adType, list, j);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
    }

    public void a(String str, List<IFeedAd> list) {
    }

    public void a(String str, OnewayAdCloseType onewayAdCloseType) {
    }

    public void a(String str, OnewayAdCloseType onewayAdCloseType, String str2) {
        if (this.f4137a != null) {
            ((OWSplashAdListener) this.f4137a).onAdFinish();
        }
    }

    public void a(String str, OnewaySdkError onewaySdkError, String str2) {
        if (this.f4137a != null) {
            ((OWSplashAdListener) this.f4137a).onAdError(onewaySdkError, str2);
        }
    }

    public void b(String str) {
    }

    public void c(String str) {
        if (this.f4137a != null) {
            ((OWSplashAdListener) this.f4137a).onAdShow();
        }
    }

    public void d(String str) {
        if (this.f4137a != null) {
            ((OWSplashAdListener) this.f4137a).onAdClick();
        }
    }

    public void e(String str) {
    }
}
