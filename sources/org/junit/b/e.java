package org.junit.b;

import org.junit.c;
import org.junit.i;

public final class e extends d {
    /* access modifiers changed from: protected */
    public final void a(Object obj, Object obj2) {
        if (c.a(obj, obj2)) {
            return;
        }
        if (!(obj instanceof String) || !(obj2 instanceof String)) {
            c.b(obj, obj2);
            return;
        }
        throw new i("", (String) obj, (String) obj2);
    }
}
