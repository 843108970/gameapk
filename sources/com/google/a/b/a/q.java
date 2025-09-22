package com.google.a.b.a;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private final int f3040a;

    protected q(int i) {
        this.f3040a = i;
    }

    public static void a(String str, StringBuilder sb) {
        if (str != null && !str.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(10);
            }
            sb.append(str);
        }
    }

    public static void a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String a2 : strArr) {
                a(a2, sb);
            }
        }
    }

    private int b() {
        return this.f3040a;
    }

    public abstract String a();

    public final String toString() {
        return a();
    }
}
