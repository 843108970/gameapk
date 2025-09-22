package org.greenrobot.eventbus.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<? extends Throwable>, Integer> f4360a = new HashMap();

    private d a(Class<? extends Throwable> cls, int i) {
        this.f4360a.put(cls, Integer.valueOf(i));
        return this;
    }

    private Integer b(Throwable th) {
        Class<?> cls = th.getClass();
        Integer num = this.f4360a.get(cls);
        if (num == null) {
            Class cls2 = null;
            for (Map.Entry next : this.f4360a.entrySet()) {
                Class cls3 = (Class) next.getKey();
                if (cls3.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(cls3))) {
                    num = (Integer) next.getValue();
                    cls2 = cls3;
                }
            }
        }
        return num;
    }

    public final Integer a(Throwable th) {
        Throwable th2 = th;
        int i = 20;
        do {
            Class<?> cls = th2.getClass();
            Integer num = this.f4360a.get(cls);
            if (num == null) {
                Class cls2 = null;
                for (Map.Entry next : this.f4360a.entrySet()) {
                    Class cls3 = (Class) next.getKey();
                    if (cls3.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(cls3))) {
                        num = (Integer) next.getValue();
                        cls2 = cls3;
                    }
                }
            }
            if (num != null) {
                return num;
            }
            th2 = th2.getCause();
            i--;
            if (i <= 0 || th2 == th) {
                Log.d(c.f4301a, "No specific message ressource ID found for " + th);
            }
        } while (th2 != null);
        Log.d(c.f4301a, "No specific message ressource ID found for " + th);
        return null;
    }
}
