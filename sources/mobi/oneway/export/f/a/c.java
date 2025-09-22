package mobi.oneway.export.f.a;

import java.util.List;
import mobi.oneway.export.AdListener.feed.OWFeedAdListener;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.EventType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.f.a;
import mobi.oneway.export.feed.IFeedAd;

public class c extends a implements OWFeedAdListener {
    public c(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public AdType c() {
        return AdType.feed;
    }

    public void onAdLoad(List<IFeedAd> list) {
        a(EventType.ready);
        if (this.e != null) {
            this.e.a(this.f4183b, list);
        }
    }

    public void onError(OnewaySdkError onewaySdkError, String str) {
        a(onewaySdkError, str);
        if (this.e != null) {
            this.e.a(this.f4183b, onewaySdkError, str);
        }
    }
}
