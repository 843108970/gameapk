package com.google.a.b.a;

public final class aj extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f3018a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3019b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3020c;
    private final boolean d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;

    private aj(String str, String str2, String str3) {
        this(str, str2, str3, (byte) 0);
    }

    private aj(String str, String str2, String str3, byte b2) {
        this(str, str2, str3, false, (String) null, (String) null, (String) null, (String) null);
    }

    public aj(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7) {
        super(r.WIFI$3fc7421e);
        this.f3018a = str2;
        this.f3019b = str;
        this.f3020c = str3;
        this.d = z;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
    }

    private String b() {
        return this.f3018a;
    }

    private String c() {
        return this.f3019b;
    }

    private String d() {
        return this.f3020c;
    }

    private boolean e() {
        return this.d;
    }

    private String f() {
        return this.e;
    }

    private String g() {
        return this.f;
    }

    private String h() {
        return this.g;
    }

    private String i() {
        return this.h;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(80);
        a(this.f3018a, sb);
        a(this.f3019b, sb);
        a(this.f3020c, sb);
        a(Boolean.toString(this.d), sb);
        return sb.toString();
    }
}
