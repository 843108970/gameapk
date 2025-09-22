package mobi.oneway.export.c;

import android.content.Context;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f4146a;

    private c() {
    }

    public static c a() {
        if (f4146a == null) {
            f4146a = new c();
        }
        return f4146a;
    }

    public void a(Context context) {
        a aVar = new a(context);
        aVar.a();
        Thread.setDefaultUncaughtExceptionHandler(new d(aVar));
    }
}
