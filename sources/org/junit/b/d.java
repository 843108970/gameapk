package org.junit.b;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.c;

public abstract class d {
    private static int a(Object obj, Object obj2, String str) {
        if (obj == null) {
            c.a(str + "expected array was null");
        }
        if (obj2 == null) {
            c.a(str + "actual array was null");
        }
        int length = Array.getLength(obj2);
        int length2 = Array.getLength(obj);
        if (length != length2) {
            c.a(str + "array lengths differed, expected.length=" + length2 + " actual.length=" + length);
        }
        return length2;
    }

    private static boolean a(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    /* access modifiers changed from: protected */
    public abstract void a(Object obj, Object obj2);

    public final void a(String str, Object obj, Object obj2) throws a {
        String str2;
        if (obj != obj2) {
            if (!Arrays.deepEquals(new Object[]{obj}, new Object[]{obj2})) {
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str + ": ";
                }
                if (obj == null) {
                    c.a(str2 + "expected array was null");
                }
                if (obj2 == null) {
                    c.a(str2 + "actual array was null");
                }
                int length = Array.getLength(obj2);
                int length2 = Array.getLength(obj);
                if (length != length2) {
                    c.a(str2 + "array lengths differed, expected.length=" + length2 + " actual.length=" + length);
                }
                for (int i = 0; i < length2; i++) {
                    Object obj3 = Array.get(obj, i);
                    Object obj4 = Array.get(obj2, i);
                    if (!a(obj3) || !a(obj4)) {
                        try {
                            a(obj3, obj4);
                        } catch (AssertionError e) {
                            throw new a(str2, e, i);
                        }
                    } else {
                        try {
                            a(str, obj3, obj4);
                        } catch (a e2) {
                            e2.addDimension(i);
                            throw e2;
                        }
                    }
                }
            }
        }
    }
}
