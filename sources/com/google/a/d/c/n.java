package com.google.a.d.c;

final class n extends c {
    n() {
    }

    public final int a() {
        return 3;
    }

    /* access modifiers changed from: package-private */
    public final int a(char c2, StringBuilder sb) {
        char c3;
        int i;
        if (c2 == 13) {
            c3 = 0;
        } else if (c2 == ' ') {
            c3 = 3;
        } else if (c2 == '*') {
            sb.append(1);
            return 1;
        } else if (c2 != '>') {
            if (c2 >= '0' && c2 <= '9') {
                i = (c2 - '0') + 4;
            } else if (c2 < 'A' || c2 > 'Z') {
                j.c(c2);
                return 1;
            } else {
                i = (c2 - 'A') + 14;
            }
            c3 = (char) i;
        } else {
            c3 = 2;
        }
        sb.append(c3);
        return 1;
    }

    public final void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.b()) {
                break;
            }
            char a2 = hVar.a();
            hVar.f++;
            a(a2, sb);
            if (sb.length() % 3 == 0) {
                a(hVar, sb);
                if (j.a(hVar.f3116a, hVar.f, 3) != 3) {
                    hVar.g = 0;
                    break;
                }
            }
        }
        b(hVar, sb);
    }

    /* access modifiers changed from: package-private */
    public final void b(h hVar, StringBuilder sb) {
        hVar.d();
        int length = hVar.h.f3126b - hVar.e.length();
        hVar.f -= sb.length();
        if (hVar.c() > 1 || length > 1 || hVar.c() != length) {
            hVar.a(254);
        }
        if (hVar.g < 0) {
            hVar.g = 0;
        }
    }
}
