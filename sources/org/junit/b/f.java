package org.junit.b;

import org.junit.c;

public final class f extends d {

    /* renamed from: a  reason: collision with root package name */
    public Object f4524a;

    public f(double d) {
        this.f4524a = Double.valueOf(d);
    }

    public f(float f) {
        this.f4524a = Float.valueOf(f);
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj, Object obj2) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            double doubleValue2 = ((Double) obj2).doubleValue();
            if (c.a(doubleValue, doubleValue2, ((Double) this.f4524a).doubleValue())) {
                c.b((Object) Double.valueOf(doubleValue), (Object) Double.valueOf(doubleValue2));
                return;
            }
            return;
        }
        float floatValue = ((Float) obj).floatValue();
        float floatValue2 = ((Float) obj2).floatValue();
        if (c.a(floatValue, floatValue2, ((Float) this.f4524a).floatValue())) {
            c.b((Object) Float.valueOf(floatValue), (Object) Float.valueOf(floatValue2));
        }
    }
}
