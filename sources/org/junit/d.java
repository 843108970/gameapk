package org.junit;

import java.util.Arrays;
import org.a.a.e;
import org.a.a.f;
import org.a.a.i;
import org.a.a.l;
import org.a.k;

public final class d {
    private static <T> void a(T t, k<T> kVar) {
        if (!kVar.a(t)) {
            throw new e(t, kVar);
        }
    }

    private static <T> void a(String str, T t, k<T> kVar) {
        if (!kVar.a(t)) {
            throw new e(str, t, kVar);
        }
    }

    private static void a(String str, Throwable th) {
        l lVar = new l();
        if (!lVar.a(th)) {
            throw new e(str, th, lVar);
        }
    }

    private static void a(String str, boolean z) {
        if (!z) {
            throw new e(str);
        }
    }

    private static void a(Throwable th) {
        a(th, new l());
    }

    public static void a(boolean z) {
        a(Boolean.valueOf(z), f.a(i.b(true)));
    }

    public static void a(Object... objArr) {
        a(Arrays.asList(objArr), e.a(org.a.a.k.a(new l())));
    }

    private static void b(String str, boolean z) {
        if (!(!z)) {
            throw new e(str);
        }
    }

    private static void b(boolean z) {
        a(!z);
    }
}
