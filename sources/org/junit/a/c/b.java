package org.junit.a.c;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.b.j;
import org.junit.runner.JUnitCore;
import org.junit.runner.b.a;
import org.junit.runner.h;
import org.junit.runner.i;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    i f4437a;

    private b(List<a> list) {
        this(new a(list).a());
    }

    private b(i iVar) {
        this.f4437a = iVar;
    }

    private int a() {
        return this.f4437a.getFailures().size();
    }

    private static b a(Class<?> cls) {
        return new b(new JUnitCore().a(h.a(cls)));
    }

    private static b a(h hVar) {
        return new b(new JUnitCore().a(hVar));
    }

    public final String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new j(new PrintStream(byteArrayOutputStream)).a(this.f4437a);
        return byteArrayOutputStream.toString();
    }
}
