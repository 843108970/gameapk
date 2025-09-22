package com.google.a.g.a.a.a;

import com.google.a.c.a;
import com.google.a.m;

public final class e extends i {
    private static final int d = 8;
    private static final int e = 20;
    private static final int f = 16;
    private final String g;
    private final String h;

    public e(a aVar, String str, String str2) {
        super(aVar);
        this.g = str2;
        this.h = str;
    }

    private void a(StringBuilder sb) {
        int a2 = this.f3156c.a(68, 16);
        if (a2 != 38400) {
            sb.append('(');
            sb.append(this.g);
            sb.append(')');
            int i = a2 % 32;
            int i2 = a2 / 32;
            int i3 = (i2 % 12) + 1;
            int i4 = i2 / 12;
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i3);
            if (i / 10 == 0) {
                sb.append('0');
            }
            sb.append(i);
        }
    }

    /* access modifiers changed from: protected */
    public final int a(int i) {
        return i % 100000;
    }

    public final String a() throws m {
        if (this.f3155b.f3055b != 84) {
            throw m.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        b(sb, 48, 20);
        int a2 = this.f3156c.a(68, 16);
        if (a2 != 38400) {
            sb.append('(');
            sb.append(this.g);
            sb.append(')');
            int i = a2 % 32;
            int i2 = a2 / 32;
            int i3 = (i2 % 12) + 1;
            int i4 = i2 / 12;
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i3);
            if (i / 10 == 0) {
                sb.append('0');
            }
            sb.append(i);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final void a(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.h);
        sb.append(i / 100000);
        sb.append(')');
    }
}
