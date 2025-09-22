package com.cyjh.elfin.floatingwindowprocess.c;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import com.cyjh.common.util.ab;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.floatingwindowprocess.b.a;
import com.cyjh.elfin.floatingwindowprocess.d.b;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f2013b;

    /* renamed from: a  reason: collision with root package name */
    Vibrator f2014a;

    public static d a() {
        if (f2013b == null) {
            synchronized (d.class) {
                if (f2013b == null) {
                    f2013b = new d();
                }
            }
        }
        return f2013b;
    }

    private void a(Context context) {
        a aVar = new a(AppContext.a());
        aVar.f2003b = new e(this, (Vibrator) context.getSystemService("vibrator"), aVar);
    }

    private /* synthetic */ void a(final Vibrator vibrator, final a aVar) {
        if (ab.a().b(com.cyjh.elfin.a.a.z, (Boolean) true) && vibrator != null) {
            b.j();
            b.d();
            aVar.f2002a.unregisterListener(aVar);
            b.j();
            if (b.b()) {
                vibrator.vibrate(new long[]{500, 200, 500, 200}, -1);
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        vibrator.cancel();
                        aVar.a();
                    }
                }, 1500);
            }
        }
    }

    public static void b() {
        Vibrator vibrator = (Vibrator) AppContext.a().getSystemService("vibrator");
        if (ab.a().b(com.cyjh.elfin.a.a.B, (Boolean) true)) {
            vibrator.vibrate(1000);
        }
    }
}
