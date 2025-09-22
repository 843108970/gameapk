package com.google.a.b.a;

public final class m extends q {

    /* renamed from: a  reason: collision with root package name */
    private final double f3035a;

    /* renamed from: b  reason: collision with root package name */
    private final double f3036b;

    /* renamed from: c  reason: collision with root package name */
    private final double f3037c;
    private final String d;

    m(double d2, double d3, double d4, String str) {
        super(r.GEO$3fc7421e);
        this.f3035a = d2;
        this.f3036b = d3;
        this.f3037c = d4;
        this.d = str;
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.f3035a);
        sb.append(',');
        sb.append(this.f3036b);
        if (this.f3037c > 0.0d) {
            sb.append(',');
            sb.append(this.f3037c);
        }
        if (this.d != null) {
            sb.append('?');
            sb.append(this.d);
        }
        return sb.toString();
    }

    private double c() {
        return this.f3035a;
    }

    private double d() {
        return this.f3036b;
    }

    private double e() {
        return this.f3037c;
    }

    private String f() {
        return this.d;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f3035a);
        sb.append(", ");
        sb.append(this.f3036b);
        if (this.f3037c > 0.0d) {
            sb.append(", ");
            sb.append(this.f3037c);
            sb.append('m');
        }
        if (this.d != null) {
            sb.append(" (");
            sb.append(this.d);
            sb.append(')');
        }
        return sb.toString();
    }
}
