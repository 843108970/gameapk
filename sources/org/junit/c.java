package org.junit;

import com.cyjh.common.util.s;
import org.a.k;
import org.a.l;
import org.junit.b.a;
import org.junit.b.e;
import org.junit.b.f;

public final class c {
    protected c() {
    }

    private static String a(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        return name + "<" + str + ">";
    }

    static String a(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str.equals("")) {
            str2 = str + s.a.f1696a;
        }
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        if (valueOf.equals(valueOf2)) {
            return str2 + "expected: " + a(obj, valueOf) + " but was: " + a(obj2, valueOf2);
        }
        return str2 + "expected:<" + valueOf + "> but was:<" + valueOf2 + ">";
    }

    private static void a() {
        a((String) null);
    }

    private static void a(long j) {
        if (1 != j) {
            b((Object) 1L, (Object) Long.valueOf(j));
        }
    }

    private static void a(long j, long j2) {
        if (j == j2) {
            a((Object) Long.valueOf(j2));
        }
    }

    private static void a(Object obj) {
        a("Values should be different. " + "Actual: " + obj);
    }

    private static <T> void a(T t, k<? super T> kVar) {
        l.a("", t, kVar);
    }

    public static void a(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    private static void a(String str, Object obj) {
        String str2 = "";
        if (str != null) {
            str2 = str + s.a.f1696a;
        }
        a(str2 + "expected null, but was:<" + obj + ">");
    }

    private static <T> void a(String str, T t, k<? super T> kVar) {
        l.a(str, t, kVar);
    }

    private static void a(String str, Object[] objArr, Object[] objArr2) throws a {
        b(str, (Object) objArr, (Object) objArr2);
    }

    private static void a(boolean z) {
        if (!z) {
            a((String) null);
        }
    }

    private static void a(byte[] bArr, byte[] bArr2) throws a {
        b((String) null, (Object) bArr, (Object) bArr2);
    }

    private static void a(char[] cArr, char[] cArr2) throws a {
        b((String) null, (Object) cArr, (Object) cArr2);
    }

    private static void a(double[] dArr, double[] dArr2, double d) throws a {
        new f(d).a((String) null, (Object) dArr, (Object) dArr2);
    }

    private static void a(float[] fArr, float[] fArr2, float f) throws a {
        new f(f).a((String) null, (Object) fArr, (Object) fArr2);
    }

    private static void a(int[] iArr, int[] iArr2) throws a {
        b((String) null, (Object) iArr, (Object) iArr2);
    }

    private static void a(long[] jArr, long[] jArr2) throws a {
        b((String) null, (Object) jArr, (Object) jArr2);
    }

    private static void a(Object[] objArr, Object[] objArr2) {
        b((String) null, (Object) objArr, (Object) objArr2);
    }

    private static void a(short[] sArr, short[] sArr2) throws a {
        b((String) null, (Object) sArr, (Object) sArr2);
    }

    private static void a(boolean[] zArr, boolean[] zArr2) throws a {
        b((String) null, (Object) zArr, (Object) zArr2);
    }

    public static boolean a(double d, double d2, double d3) {
        return Double.compare(d, d2) != 0 && Math.abs(d - d2) > d3;
    }

    public static boolean a(float f, float f2, float f3) {
        return Float.compare(f, f2) != 0 && Math.abs(f - f2) > f3;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Deprecated
    private static void b() {
        a("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    private static void b(double d, double d2, double d3) {
        if (!a(d, d2, d3)) {
            a((Object) Double.valueOf(d2));
        }
    }

    private static void b(float f, float f2, float f3) {
        if (!a(f, f2, f3)) {
            a((Object) Float.valueOf(f2));
        }
    }

    private static void b(long j, long j2) {
        if (j == j2) {
            a((Object) Long.valueOf(j2));
        }
    }

    private static void b(Object obj) {
        a(obj != null);
    }

    public static void b(Object obj, Object obj2) {
        a(a((String) null, obj, obj2));
    }

    private static void b(String str) {
        String str2 = "";
        if (str != null) {
            str2 = str + s.a.f1696a;
        }
        a(str2 + "expected not same");
    }

    private static void b(String str, Object obj, Object obj2) throws a {
        new e().a(str, obj, obj2);
    }

    @Deprecated
    private static void b(String str, Object[] objArr, Object[] objArr2) {
        b(str, (Object) objArr, (Object) objArr2);
    }

    private static void b(boolean z) {
        a(z);
    }

    private static void b(byte[] bArr, byte[] bArr2) {
        b((String) null, (Object) bArr, (Object) bArr2);
    }

    private static void b(char[] cArr, char[] cArr2) {
        b((String) null, (Object) cArr, (Object) cArr2);
    }

    private static void b(double[] dArr, double[] dArr2, double d) {
        new f(d).a((String) null, (Object) dArr, (Object) dArr2);
    }

    private static void b(float[] fArr, float[] fArr2, float f) {
        new f(f).a((String) null, (Object) fArr, (Object) fArr2);
    }

    private static void b(int[] iArr, int[] iArr2) {
        b((String) null, (Object) iArr, (Object) iArr2);
    }

    private static void b(long[] jArr, long[] jArr2) {
        b((String) null, (Object) jArr, (Object) jArr2);
    }

    @Deprecated
    private static void b(Object[] objArr, Object[] objArr2) {
        b((String) null, (Object) objArr, (Object) objArr2);
    }

    private static void b(short[] sArr, short[] sArr2) {
        b((String) null, (Object) sArr, (Object) sArr2);
    }

    private static void b(boolean[] zArr, boolean[] zArr2) {
        b((String) null, (Object) zArr, (Object) zArr2);
    }

    @Deprecated
    private static void c() {
        a("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    private static void c(double d, double d2, double d3) {
        if (!a(d, d2, d3)) {
            a((Object) Double.valueOf(d2));
        }
    }

    private static void c(float f, float f2, float f3) {
        if (a(f, f2, f3)) {
            b((Object) Float.valueOf(f), (Object) Float.valueOf(f2));
        }
    }

    private static void c(long j, long j2) {
        if (j != j2) {
            b((Object) Long.valueOf(j), (Object) Long.valueOf(j2));
        }
    }

    private static void c(Object obj) {
        a(obj != null);
    }

    private static void c(Object obj, Object obj2) {
        if (!a(obj, obj2)) {
            if (!(obj instanceof String) || !(obj2 instanceof String)) {
                b(obj, obj2);
                return;
            }
            throw new i("", (String) obj, (String) obj2);
        }
    }

    private static void c(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null) {
            str2 = str + s.a.f1696a;
        }
        a(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    private static void c(boolean z) {
        a(!z);
    }

    private static void d(double d, double d2, double d3) {
        if (a(d, d2, d3)) {
            b((Object) Double.valueOf(d), (Object) Double.valueOf(d2));
        }
    }

    private static void d(float f, float f2, float f3) {
        if (!a(f, f2, f3)) {
            a((Object) Float.valueOf(f2));
        }
    }

    private static void d(Object obj) {
        if (obj != null) {
            a("" + "expected null, but was:<" + obj + ">");
        }
    }

    private static void d(boolean z) {
        a(!z);
    }

    private static boolean d(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    private static void e(double d, double d2, double d3) {
        if (a(d, d2, d3)) {
            b((Object) Double.valueOf(d), (Object) Double.valueOf(d2));
        }
    }

    private static void e(float f, float f2, float f3) {
        if (a(f, f2, f3)) {
            b((Object) Float.valueOf(f), (Object) Float.valueOf(f2));
        }
    }

    private static void e(Object obj) {
        if (obj != null) {
            a("" + "expected null, but was:<" + obj + ">");
        }
    }

    private static void e(Object obj, Object obj2) {
        if (a(obj, obj2)) {
            return;
        }
        if (!(obj instanceof String) || !(obj2 instanceof String)) {
            b(obj, obj2);
            return;
        }
        throw new i("", (String) obj, (String) obj2);
    }

    private static void f(Object obj, Object obj2) {
        if (a(obj, obj2)) {
            a(obj2);
        }
    }

    private static void g(Object obj, Object obj2) {
        if (a(obj, obj2)) {
            a(obj2);
        }
    }

    private static void h(Object obj, Object obj2) {
        if (obj != obj2) {
            a("" + "expected same:<" + obj + "> was not:<" + obj2 + ">");
        }
    }

    private static void i(Object obj, Object obj2) {
        if (obj != obj2) {
            a("" + "expected same:<" + obj + "> was not:<" + obj2 + ">");
        }
    }

    private static void j(Object obj, Object obj2) {
        if (obj == obj2) {
            a("" + "expected not same");
        }
    }

    private static void k(Object obj, Object obj2) {
        if (obj == obj2) {
            a("" + "expected not same");
        }
    }
}
