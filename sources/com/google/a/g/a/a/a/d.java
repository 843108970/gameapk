package com.google.a.g.a.a.a;

import com.google.a.c.a;
import com.google.a.h;
import com.google.a.m;

public final class d extends h {
    private static final int d = 8;
    private static final int e = 2;
    private static final int f = 10;

    public d(a aVar) {
        super(aVar);
    }

    public final String a() throws m, h {
        if (this.f3155b.f3055b < 48) {
            throw m.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        int a2 = this.f3156c.a(48, 2);
        sb.append("(393");
        sb.append(a2);
        sb.append(')');
        int a3 = this.f3156c.a(50, 10);
        if (a3 / 100 == 0) {
            sb.append('0');
        }
        if (a3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(a3);
        sb.append(this.f3156c.a(60, (String) null).f3164a);
        return sb.toString();
    }
}
