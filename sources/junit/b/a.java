package junit.b;

import com.cyjh.common.util.s;

@Deprecated
public class a {
    protected a() {
    }

    private static void a(byte b2, byte b3) {
        a((String) null, b2, b3);
    }

    private static void a(char c2, char c3) {
        a((String) null, c2, c3);
    }

    private static void a(double d, double d2, double d3) {
        a((String) null, d, d2, d3);
    }

    private static void a(float f, float f2, float f3) {
        a((String) null, f, f2, f3);
    }

    private static void a(int i, int i2) {
        a((String) null, i, i2);
    }

    private static void a(long j, long j2) {
        a((String) null, j, j2);
    }

    private static void a(Object obj) {
        a((String) null, obj);
    }

    private static void a(Object obj, Object obj2) {
        a((String) null, obj, obj2);
    }

    public static void a(String str) {
        if (str == null) {
            throw new b();
        }
        throw new b(str);
    }

    public static void a(String str, byte b2, byte b3) {
        a(str, (Object) Byte.valueOf(b2), (Object) Byte.valueOf(b3));
    }

    public static void a(String str, char c2, char c3) {
        a(str, (Object) Character.valueOf(c2), (Object) Character.valueOf(c3));
    }

    public static void a(String str, double d, double d2, double d3) {
        if (Double.compare(d, d2) != 0 && Math.abs(d - d2) > d3) {
            e(str, new Double(d), new Double(d2));
        }
    }

    public static void a(String str, float f, float f2, float f3) {
        if (Float.compare(f, f2) != 0 && Math.abs(f - f2) > f3) {
            e(str, new Float(f), new Float(f2));
        }
    }

    public static void a(String str, int i, int i2) {
        a(str, (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
    }

    public static void a(String str, long j, long j2) {
        a(str, (Object) Long.valueOf(j), (Object) Long.valueOf(j2));
    }

    public static void a(String str, Object obj) {
        a(str, obj != null);
    }

    public static void a(String str, Object obj, Object obj2) {
        if (obj != null || obj2 != null) {
            if (obj == null || !obj.equals(obj2)) {
                e(str, obj, obj2);
            }
        }
    }

    private static void a(String str, String str2) {
        a((String) null, str, str2);
    }

    public static void a(String str, String str2, String str3) {
        if (str2 != null || str3 != null) {
            if (str2 == null || !str2.equals(str3)) {
                if (str == null) {
                    str = "";
                }
                throw new d(str, str2, str3);
            }
        }
    }

    public static void a(String str, short s, short s2) {
        a(str, (Object) Short.valueOf(s), (Object) Short.valueOf(s2));
    }

    public static void a(String str, boolean z) {
        if (!z) {
            a(str);
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        a(str, (Object) Boolean.valueOf(z), (Object) Boolean.valueOf(z2));
    }

    private static void a(short s, short s2) {
        a((String) null, s, s2);
    }

    private static void a(boolean z) {
        a((String) null, z);
    }

    private static void a(boolean z, boolean z2) {
        a((String) null, z, z2);
    }

    private static void b() {
        a((String) null);
    }

    private static void b(Object obj) {
        if (obj != null) {
            b("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    private static void b(Object obj, Object obj2) {
        b((String) null, obj, obj2);
    }

    public static void b(String str) {
        String str2;
        if (str != null) {
            str2 = str + s.a.f1696a;
        } else {
            str2 = "";
        }
        a(str2 + "expected not same");
    }

    public static void b(String str, Object obj) {
        a(str, obj == null);
    }

    public static void b(String str, Object obj, Object obj2) {
        if (obj != obj2) {
            d(str, obj, obj2);
        }
    }

    public static void b(String str, boolean z) {
        a(str, !z);
    }

    private static void b(boolean z) {
        b((String) null, z);
    }

    private static void c(Object obj, Object obj2) {
        c((String) null, obj, obj2);
    }

    public static void c(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            b(str);
        }
    }

    public static void d(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + s.a.f1696a;
        } else {
            str2 = "";
        }
        a(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    public static void e(String str, Object obj, Object obj2) {
        a(f(str, obj, obj2));
    }

    public static String f(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && str.length() > 0) {
            str2 = str + s.a.f1696a;
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }
}
