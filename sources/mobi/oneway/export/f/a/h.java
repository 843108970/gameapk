package mobi.oneway.export.f.a;

import mobi.oneway.export.AdListener.OWSplashAdListener;
import mobi.oneway.export.b.a;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.EventType;
import mobi.oneway.export.enums.OnewayAdCloseType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.f.a;

public class h extends a implements OWSplashAdListener {
    public h(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public AdType c() {
        return AdType.splash;
    }

    public void onAdClick() {
        a(EventType.click);
        if (this.e != null) {
            this.e.d((String) null);
        }
    }

    public void onAdError(OnewaySdkError onewaySdkError, String str) {
        a(onewaySdkError, str);
        if (this.e != null) {
            this.e.a(this.f4183b, onewaySdkError, str);
        }
    }

    public void onAdFinish() {
        a(EventType.end);
        if (this.e != null) {
            this.e.a((String) null, (OnewayAdCloseType) null, (String) null);
        }
    }

    public void onAdShow() {
        mobi.oneway.export.b.a.a().a(a.C0064a.TYPE_SHOW, b(), a());
        a(EventType.show);
        if (this.e != null) {
            this.e.c((String) null);
        }
    }
}
