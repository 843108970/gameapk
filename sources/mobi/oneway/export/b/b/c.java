package mobi.oneway.export.b.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mobi.oneway.export.AdListener.feed.OWFeedAdListener;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.OnewayAdCloseType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.f.a;
import mobi.oneway.export.f.d;
import mobi.oneway.export.feed.IFeedAd;

public class c extends b<OWFeedAdListener> {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<IFeedAd>> f4142c = new HashMap();
    private List<String> d;
    private List<a> e;

    public c(AdType adType, List<a> list, List<String> list2, long j) {
        super(adType, list2, j);
        this.e = list;
        this.d = list2;
    }

    private List<IFeedAd> f() {
        a aVar;
        List arrayList = new ArrayList();
        Iterator<String> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            String next = it.next();
            List list = this.f4142c.get(next);
            if (list != null) {
                aVar = d.a(this.e, next);
                arrayList = list;
                break;
            }
            arrayList = list;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, new mobi.oneway.export.feed.a((IFeedAd) arrayList.get(i), aVar));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.f4137a != null) {
            ((OWFeedAdListener) this.f4137a).onAdLoad(f());
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        if (this.f4137a != null) {
            ((OWFeedAdListener) this.f4137a).onError(OnewaySdkError.LOAD_ERROR, str);
        }
    }

    public void a(String str, List<IFeedAd> list) {
        f(str);
        this.f4142c.put(str, list);
        if (d() && this.f4137a != null) {
            ((OWFeedAdListener) this.f4137a).onAdLoad(f());
        }
    }

    public void a(String str, OnewayAdCloseType onewayAdCloseType) {
    }

    public void a(String str, OnewayAdCloseType onewayAdCloseType, String str2) {
    }

    public void a(String str, OnewaySdkError onewaySdkError, String str2) {
        g(str);
        if (e() && this.f4137a != null) {
            ((OWFeedAdListener) this.f4137a).onError(onewaySdkError, str2);
        }
    }

    public void b(String str) {
    }

    public void c() {
        super.c();
        this.f4142c.clear();
    }

    public void c(String str) {
    }

    public void d(String str) {
    }

    public void e(String str) {
    }
}
