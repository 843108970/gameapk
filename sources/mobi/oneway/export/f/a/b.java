package mobi.oneway.export.f.a;

import java.util.HashSet;
import java.util.Set;
import mobi.oneway.export.AdListener.feed.OWFeedAdEventListener;
import mobi.oneway.export.b.a;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.EventType;
import mobi.oneway.export.f.a;
import mobi.oneway.export.f.e;
import mobi.oneway.export.feed.IFeedAd;

public class b implements OWFeedAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    private static Set<String> f4185a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private static Set<String> f4186b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private e f4187c;
    private OWFeedAdEventListener d;
    private String e;
    private String f;

    public b(a aVar, OWFeedAdEventListener oWFeedAdEventListener) {
        this.f4187c = new e(AdType.feed, aVar);
        this.d = oWFeedAdEventListener;
        this.e = aVar.g();
        this.f = aVar.f();
    }

    public void onClicked(IFeedAd iFeedAd) {
        String obj = iFeedAd.toString();
        if (!f4186b.contains(obj)) {
            this.f4187c.a(EventType.click, (String) null);
            f4186b.add(obj);
        }
        if (this.d != null) {
            this.d.onClicked(iFeedAd);
        }
    }

    public void onExposured(IFeedAd iFeedAd) {
        String obj = iFeedAd.toString();
        if (!f4185a.contains(obj)) {
            mobi.oneway.export.b.a.a().a(a.C0064a.TYPE_SHOW, this.e, this.f);
            this.f4187c.a(EventType.show, (String) null);
            f4185a.add(obj);
        }
        if (this.d != null) {
            this.d.onExposured(iFeedAd);
        }
    }
}
