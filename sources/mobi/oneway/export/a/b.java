package mobi.oneway.export.a;

import android.content.Context;
import mobi.oneway.export.g.m;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f4102a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f4103b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4104c = false;
    private static String d;
    private static String e;

    public static Context a() {
        if (f4102a == null) {
            m.d("OnewaySdk.init method must invoke first and paramter context must not be null");
        }
        return f4102a;
    }

    public static void a(Context context) {
        f4102a = context;
    }

    public static void a(String str) {
        f4103b = str;
    }

    public static void a(boolean z) {
        f4104c = z;
    }

    public static String b() {
        return f4103b;
    }

    public static void b(String str) {
        d = str;
    }

    public static void c(String str) {
        e = str;
    }

    public static boolean c() {
        return f4104c;
    }

    public static String d() {
        return d;
    }

    public static String e() {
        return e;
    }
}
