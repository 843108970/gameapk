package com.elfin.ad;

import android.content.Context;
import com.iflytek.voiceads.dex.DexLoader;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f2830b;

    /* renamed from: a  reason: collision with root package name */
    public Context f2831a;

    public static a a() {
        if (f2830b == null) {
            synchronized (a.class) {
                if (f2830b == null) {
                    f2830b = new a();
                }
            }
        }
        return f2830b;
    }

    private Context b() {
        return this.f2831a;
    }

    public final void a(Context context) {
        this.f2831a = context;
        DexLoader.initIFLYADModule(context);
    }
}
