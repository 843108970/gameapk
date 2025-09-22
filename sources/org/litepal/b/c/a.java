package org.litepal.b.c;

import java.lang.reflect.Field;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f4695a;

    /* renamed from: b  reason: collision with root package name */
    public String f4696b;

    /* renamed from: c  reason: collision with root package name */
    public String f4697c;
    public Field d;
    public Field e;
    public int f;

    private String a() {
        return this.f4695a;
    }

    private void a(int i) {
        this.f = i;
    }

    private void a(String str) {
        this.f4695a = str;
    }

    private void a(Field field) {
        this.d = field;
    }

    private String b() {
        return this.f4696b;
    }

    private void b(String str) {
        this.f4696b = str;
    }

    private void b(Field field) {
        this.e = field;
    }

    private String c() {
        return this.f4697c;
    }

    private void c(String str) {
        this.f4697c = str;
    }

    private Field d() {
        return this.d;
    }

    private Field e() {
        return this.e;
    }

    private int f() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (obj == null || aVar == null || aVar.f != this.f || !aVar.f4697c.equals(this.f4697c)) {
            return false;
        }
        if (!aVar.f4695a.equals(this.f4695a) || !aVar.f4696b.equals(this.f4696b)) {
            return aVar.f4695a.equals(this.f4696b) && aVar.f4696b.equals(this.f4695a);
        }
        return true;
    }
}
