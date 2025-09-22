package com.google.a.b.a;

public final class h extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f3027a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f3028b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f3029c;
    private final String d;
    private final String e;

    h(String str) {
        this(new String[]{str}, (String[]) null, (String[]) null, (String) null, (String) null);
    }

    h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(r.EMAIL_ADDRESS$3fc7421e);
        this.f3027a = strArr;
        this.f3028b = strArr2;
        this.f3029c = strArr3;
        this.d = str;
        this.e = str2;
    }

    @Deprecated
    private String b() {
        if (this.f3027a == null || this.f3027a.length == 0) {
            return null;
        }
        return this.f3027a[0];
    }

    private String[] c() {
        return this.f3027a;
    }

    private String[] d() {
        return this.f3028b;
    }

    private String[] e() {
        return this.f3029c;
    }

    private String f() {
        return this.d;
    }

    private String g() {
        return this.e;
    }

    @Deprecated
    private static String h() {
        return "mailto:";
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(30);
        a(this.f3027a, sb);
        a(this.f3028b, sb);
        a(this.f3029c, sb);
        a(this.d, sb);
        a(this.e, sb);
        return sb.toString();
    }
}
