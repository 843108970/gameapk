package org.junit.e.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.e.a.k;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    final String f4576a;

    /* renamed from: b  reason: collision with root package name */
    final k f4577b;

    /* renamed from: c  reason: collision with root package name */
    final List<Object> f4578c;

    public d(String str, k kVar, List<Object> list) {
        a(str, "The name is missing.");
        a(kVar, "The test class is missing.");
        a(list, "The parameters are missing.");
        this.f4576a = str;
        this.f4577b = kVar;
        this.f4578c = Collections.unmodifiableList(new ArrayList(list));
    }

    private String a() {
        return this.f4576a;
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    private k b() {
        return this.f4577b;
    }

    private List<Object> c() {
        return this.f4578c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f4576a.equals(dVar.f4576a) && this.f4578c.equals(dVar.f4578c) && this.f4577b.equals(dVar.f4577b);
    }

    public final int hashCode() {
        return ((((this.f4576a.hashCode() + 14747) * 14747) + this.f4577b.hashCode()) * 14747) + this.f4578c.hashCode();
    }

    public final String toString() {
        return this.f4577b.b() + " '" + this.f4576a + "' with parameters " + this.f4578c;
    }
}
