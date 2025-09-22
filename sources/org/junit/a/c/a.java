package org.junit.a.c;

import java.util.List;
import org.junit.runner.b.b;
import org.junit.runner.i;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<org.junit.runner.b.a> f4436a;

    public a(List<org.junit.runner.b.a> list) {
        this.f4436a = list;
    }

    public final i a() {
        i iVar = new i();
        b createListener = iVar.createListener();
        for (org.junit.runner.b.a a2 : this.f4436a) {
            try {
                createListener.a(a2);
            } catch (Exception unused) {
                throw new RuntimeException("I can't believe this happened");
            }
        }
        return iVar;
    }
}
