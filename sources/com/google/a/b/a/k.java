package com.google.a.b.a;

import java.util.Map;

public final class k extends q {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3032a = "KG";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3033b = "LB";

    /* renamed from: c  reason: collision with root package name */
    private final String f3034c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final Map<String, String> q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(r.PRODUCT$3fc7421e);
        this.f3034c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.k = str9;
        this.l = str10;
        this.m = str11;
        this.n = str12;
        this.o = str13;
        this.p = str14;
        this.q = map;
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private String b() {
        return this.f3034c;
    }

    private String c() {
        return this.d;
    }

    private String d() {
        return this.e;
    }

    private String e() {
        return this.f;
    }

    private String f() {
        return this.g;
    }

    private String g() {
        return this.h;
    }

    private String h() {
        return this.i;
    }

    private String i() {
        return this.j;
    }

    private String j() {
        return this.k;
    }

    private String k() {
        return this.l;
    }

    private String l() {
        return this.m;
    }

    private String m() {
        return this.n;
    }

    private String n() {
        return this.o;
    }

    private String o() {
        return this.p;
    }

    private Map<String, String> p() {
        return this.q;
    }

    public final String a() {
        return String.valueOf(this.f3034c);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return a(this.d, kVar.d) && a(this.e, kVar.e) && a(this.f, kVar.f) && a(this.g, kVar.g) && a(this.i, kVar.i) && a(this.j, kVar.j) && a(this.k, kVar.k) && a(this.l, kVar.l) && a(this.m, kVar.m) && a(this.n, kVar.n) && a(this.o, kVar.o) && a(this.p, kVar.p) && a(this.q, kVar.q);
    }

    public final int hashCode() {
        return ((((((((((((a(this.d) ^ 0) ^ a(this.e)) ^ a(this.f)) ^ a(this.g)) ^ a(this.i)) ^ a(this.j)) ^ a(this.k)) ^ a(this.l)) ^ a(this.m)) ^ a(this.n)) ^ a(this.o)) ^ a(this.p)) ^ a(this.q);
    }
}
