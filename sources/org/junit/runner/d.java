package org.junit.runner;

import org.junit.b.c;
import org.junit.runner.a.a;
import org.junit.runner.e;

final class d {
    d() {
    }

    private static a a(Class<? extends e> cls, f fVar) throws e.a {
        return a(cls).a(fVar);
    }

    private static a a(String str, f fVar) throws e.a {
        return a(str).a(fVar);
    }

    private static a a(h hVar, String str) throws e.a {
        String[] strArr;
        c b2 = hVar.a().b();
        if (str.contains("=")) {
            strArr = str.split("=", 2);
        } else {
            strArr = new String[]{str, ""};
        }
        String str2 = strArr[0];
        return a(str2).a(new f(b2, strArr[1]));
    }

    private static e a(Class<? extends e> cls) throws e.a {
        try {
            return (e) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new e.a(e);
        }
    }

    static e a(String str) throws e.a {
        try {
            return a((Class<? extends e>) c.a(str).asSubclass(e.class));
        } catch (Exception e) {
            throw new e.a(e);
        }
    }
}
