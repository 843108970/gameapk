package mobi.oneway.export.Ad;

import android.content.Context;
import mobi.oneway.export.AdListener.feed.OWFeedAdListener;
import mobi.oneway.export.b.a.b;

public class OWFeedAd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f4053a;

    public OWFeedAd(Context context, String str) {
        OnewaySdk.checkSdkConfigured();
        this.f4053a = new b(context, str);
    }

    public void load(final OWFeedAdListener oWFeedAdListener) {
        mobi.oneway.export.e.b.a().a(new Runnable() {
            public void run() {
                OWFeedAd.this.f4053a.a(oWFeedAdListener);
            }
        });
    }
}
