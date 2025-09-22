package com.google.a.b.a;

public final class w extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f3046a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f3047b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3048c;
    private final String d;

    public w(String str, String str2) {
        super(r.SMS$3fc7421e);
        this.f3046a = new String[]{str};
        this.f3047b = new String[]{null};
        this.f3048c = null;
        this.d = str2;
    }

    public w(String[] strArr, String[] strArr2, String str, String str2) {
        super(r.SMS$3fc7421e);
        this.f3046a = strArr;
        this.f3047b = strArr2;
        this.f3048c = str;
        this.d = str2;
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        sb.append("sms:");
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < this.f3046a.length; i++) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(',');
            }
            sb.append(this.f3046a[i]);
            if (!(this.f3047b == null || this.f3047b[i] == null)) {
                sb.append(";via=");
                sb.append(this.f3047b[i]);
            }
        }
        boolean z3 = this.d != null;
        if (this.f3048c != null) {
            z = true;
        }
        if (z3 || z) {
            sb.append('?');
            if (z3) {
                sb.append("body=");
                sb.append(this.d);
            }
            if (z) {
                if (z3) {
                    sb.append('&');
                }
                sb.append("subject=");
                sb.append(this.f3048c);
            }
        }
        return sb.toString();
    }

    private String[] c() {
        return this.f3046a;
    }

    private String[] d() {
        return this.f3047b;
    }

    private String e() {
        return this.f3048c;
    }

    private String f() {
        return this.d;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f3046a, sb);
        a(this.f3048c, sb);
        a(this.d, sb);
        return sb.toString();
    }
}
