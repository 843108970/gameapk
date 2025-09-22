package mobi.oneway.export.b.b;

import java.util.List;
import mobi.oneway.export.AdListener.AdMonitor;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.OnewayAdCloseType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.feed.IFeedAd;

public abstract class a extends b<AdMonitor> {
    public a(AdType adType, List<String> list, long j) {
        super(adType, list, j);
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.f4137a != null) {
            ((AdMonitor) this.f4137a).onAdReady();
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        if (this.f4137a != null) {
            ((AdMonitor) this.f4137a).onSdkError(OnewaySdkError.LOAD_ERROR, str);
        }
    }

    public void a(String str, List<IFeedAd> list) {
    }

    public void a(String str, OnewayAdCloseType onewayAdCloseType) {
        if (this.f4137a != null) {
            ((AdMonitor) this.f4137a).onAdClose(str, onewayAdCloseType);
        }
    }

    public void a(String str, OnewayAdCloseType onewayAdCloseType, String str2) {
        if (this.f4137a != null) {
            ((AdMonitor) this.f4137a).onAdFinish(str, onewayAdCloseType, str2);
        }
    }

    public void a(String str, OnewaySdkError onewaySdkError, String str2) {
        g(str);
        if (e() && this.f4137a != null) {
            ((AdMonitor) this.f4137a).onSdkError(onewaySdkError, str2);
        }
    }

    public void b(String str) {
        f(str);
        if (d() && this.f4137a != null) {
            ((AdMonitor) this.f4137a).onAdReady();
        }
    }

    public void c(String str) {
        a(false);
        if (this.f4137a != null) {
            ((AdMonitor) this.f4137a).onAdShow(str);
        }
    }

    public void d(String str) {
        if (this.f4137a != null) {
            ((AdMonitor) this.f4137a).onAdClick(str);
        }
    }

    public void e(String str) {
    }
}
