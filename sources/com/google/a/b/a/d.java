package com.google.a.b.a;

public final class d extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f3021a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f3022b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3023c;
    private final String[] d;
    private final String[] e;
    private final String[] f;
    private final String[] g;
    private final String h;
    private final String i;
    private final String[] j;
    private final String[] k;
    private final String l;
    private final String m;
    private final String n;
    private final String[] o;
    private final String[] p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(r.ADDRESSBOOK$3fc7421e);
        String[] strArr11 = strArr3;
        String[] strArr12 = strArr4;
        String[] strArr13 = strArr5;
        String[] strArr14 = strArr6;
        String[] strArr15 = strArr7;
        String[] strArr16 = strArr8;
        if (strArr11 != null && strArr12 != null && strArr11.length != strArr12.length) {
            throw new IllegalArgumentException("Phone numbers and types lengths differ");
        } else if (strArr13 != null && strArr14 != null && strArr13.length != strArr14.length) {
            throw new IllegalArgumentException("Emails and types lengths differ");
        } else if (strArr15 == null || strArr16 == null || strArr15.length == strArr16.length) {
            this.f3021a = strArr;
            this.f3022b = strArr2;
            this.f3023c = str;
            this.d = strArr11;
            this.e = strArr12;
            this.f = strArr13;
            this.g = strArr14;
            this.h = str2;
            this.i = str3;
            this.j = strArr15;
            this.k = strArr16;
            this.l = str4;
            this.m = str5;
            this.n = str6;
            this.o = strArr9;
            this.p = strArr10;
        } else {
            throw new IllegalArgumentException("Addresses and types lengths differ");
        }
    }

    private d(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, (String[]) null, (String) null, strArr2, strArr3, strArr4, strArr5, (String) null, (String) null, strArr6, strArr7, (String) null, (String) null, (String) null, (String[]) null, (String[]) null);
    }

    private String[] b() {
        return this.f3021a;
    }

    private String[] c() {
        return this.f3022b;
    }

    private String d() {
        return this.f3023c;
    }

    private String[] e() {
        return this.d;
    }

    private String[] f() {
        return this.e;
    }

    private String[] g() {
        return this.f;
    }

    private String[] h() {
        return this.g;
    }

    private String i() {
        return this.h;
    }

    private String j() {
        return this.i;
    }

    private String[] k() {
        return this.j;
    }

    private String[] l() {
        return this.k;
    }

    private String m() {
        return this.n;
    }

    private String n() {
        return this.l;
    }

    private String[] o() {
        return this.o;
    }

    private String p() {
        return this.m;
    }

    private String[] q() {
        return this.p;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f3021a, sb);
        a(this.f3022b, sb);
        a(this.f3023c, sb);
        a(this.n, sb);
        a(this.l, sb);
        a(this.j, sb);
        a(this.d, sb);
        a(this.f, sb);
        a(this.h, sb);
        a(this.o, sb);
        a(this.m, sb);
        a(this.p, sb);
        a(this.i, sb);
        return sb.toString();
    }
}
