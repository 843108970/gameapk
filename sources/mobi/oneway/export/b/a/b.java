package mobi.oneway.export.b.a;

import android.content.Context;
import java.util.List;
import mobi.oneway.export.AdListener.feed.OWFeedAdListener;
import mobi.oneway.export.b.b.c;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.f.a;
import mobi.oneway.export.f.d;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final AdType f4132a = AdType.feed;

    /* renamed from: b  reason: collision with root package name */
    private String f4133b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4134c;

    public b(Context context, String str) {
        this.f4133b = str;
        this.f4134c = context;
    }

    public void a(OWFeedAdListener oWFeedAdListener) {
        List<a> a2 = d.a(this.f4133b, this.f4132a);
        if (a2 != null) {
            List<a> list = a2;
            c cVar = new c(this.f4132a, list, d.a(a2), mobi.oneway.export.b.a.a().c());
            cVar.a(oWFeedAdListener);
            cVar.c();
            for (a a3 : a2) {
                a3.a(this.f4134c, cVar);
            }
        } else if (oWFeedAdListener != null) {
            OnewaySdkError onewaySdkError = OnewaySdkError.INITIALIZE_FAILED;
            oWFeedAdListener.onError(onewaySdkError, this.f4132a.name() + mobi.oneway.export.a.a.m);
        }
    }
}
