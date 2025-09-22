package org.litepal;

import android.app.Application;
import android.content.Context;
import org.litepal.c.c;

public class LitePalApplication extends Application {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4125a;

    public LitePalApplication() {
        f4125a = this;
    }

    public static Context a() {
        if (f4125a != null) {
            return f4125a;
        }
        throw new c(c.APPLICATION_CONTEXT_IS_NULL);
    }
}
