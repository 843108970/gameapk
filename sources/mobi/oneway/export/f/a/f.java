package mobi.oneway.export.f.a;

import mobi.oneway.export.AdListener.OWInterstitialAdListener;
import mobi.oneway.export.b.a;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.EventType;
import mobi.oneway.export.enums.OnewayAdCloseType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.f.a;

public class f extends a implements OWInterstitialAdListener {
    public f(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public AdType c() {
        return AdType.interstitial;
    }

    public void onAdClick(String str) {
        a(EventType.click);
        if (this.e != null) {
            this.e.d(str);
        }
    }

    public void onAdClose(String str, OnewayAdCloseType onewayAdCloseType) {
        a(EventType.close);
        if (this.e != null) {
            this.e.a(str, onewayAdCloseType);
        }
    }

    public void onAdFinish(String str, OnewayAdCloseType onewayAdCloseType, String str2) {
        a(onewayAdCloseType == OnewayAdCloseType.SKIPPED ? EventType.skip : EventType.end);
        if (this.e != null) {
            this.e.a(str, onewayAdCloseType, str2);
        }
    }

    public void onAdReady() {
        a(EventType.ready);
        if (this.e != null) {
            this.e.b(this.f4183b);
        }
    }

    public void onAdShow(String str) {
        mobi.oneway.export.b.a.a().a(a.C0064a.TYPE_SHOW, b(), a());
        a(EventType.show);
        if (this.e != null) {
            this.e.c(str);
        }
    }

    public void onSdkError(OnewaySdkError onewaySdkError, String str) {
        a(onewaySdkError, str);
        if (this.e != null) {
            this.e.a(this.f4183b, onewaySdkError, str);
        }
    }
}
