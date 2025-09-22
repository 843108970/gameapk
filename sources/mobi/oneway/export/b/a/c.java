package mobi.oneway.export.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.List;
import mobi.oneway.export.AdListener.OWSplashAdListener;
import mobi.oneway.export.b.b.i;
import mobi.oneway.export.enums.AdType;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.f.a;
import mobi.oneway.export.f.d;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final AdType f4135a = AdType.splash;

    /* renamed from: b  reason: collision with root package name */
    private String f4136b;

    public c(String str) {
        this.f4136b = str;
    }

    public void a(Activity activity, ViewGroup viewGroup, OWSplashAdListener oWSplashAdListener, long j) {
        List<a> a2 = d.a(this.f4136b, this.f4135a);
        if (a2 == null) {
            if (oWSplashAdListener != null) {
                OnewaySdkError onewaySdkError = OnewaySdkError.INITIALIZE_FAILED;
                oWSplashAdListener.onAdError(onewaySdkError, this.f4135a.name() + mobi.oneway.export.a.a.m);
            }
        } else if (a2.size() > 0) {
            i iVar = new i(this.f4135a, Collections.singletonList(a2.get(0).f()), j);
            iVar.a(oWSplashAdListener);
            iVar.c();
            a2.get(0).a(activity, viewGroup, iVar, j);
        }
    }
}
