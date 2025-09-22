package com.google.a.d.c;

final class a implements g {
    a() {
    }

    private static char a(char c2, char c3) {
        if (j.a(c2) && j.a(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }

    public final int a() {
        return 0;
    }

    public final void a(h hVar) {
        int i;
        String str = hVar.f3116a;
        int i2 = hVar.f;
        int length = str.length();
        if (i2 < length) {
            char charAt = str.charAt(i2);
            i = 0;
            while (j.a(charAt) && i2 < length) {
                i++;
                i2++;
                if (i2 < length) {
                    charAt = str.charAt(i2);
                }
            }
        } else {
            i = 0;
        }
        if (i >= 2) {
            char charAt2 = hVar.f3116a.charAt(hVar.f);
            char charAt3 = hVar.f3116a.charAt(hVar.f + 1);
            if (!j.a(charAt2) || !j.a(charAt3)) {
                throw new IllegalArgumentException("not digits: " + charAt2 + charAt3);
            }
            hVar.a((char) (((charAt2 - '0') * 10) + (charAt3 - '0') + 130));
            hVar.f += 2;
            return;
        }
        char a2 = hVar.a();
        int a3 = j.a(hVar.f3116a, hVar.f, 0);
        if (a3 != 0) {
            switch (a3) {
                case 1:
                    hVar.a(230);
                    hVar.g = 1;
                    return;
                case 2:
                    hVar.a(239);
                    hVar.g = 2;
                    return;
                case 3:
                    hVar.a(238);
                    hVar.g = 3;
                    return;
                case 4:
                    hVar.a(240);
                    hVar.g = 4;
                    return;
                case 5:
                    hVar.a(231);
                    hVar.g = 5;
                    return;
                default:
                    throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(a3)));
            }
        } else if (j.b(a2)) {
            hVar.a(235);
            hVar.a((char) ((a2 - 128) + 1));
            hVar.f++;
        } else {
            hVar.a((char) (a2 + 1));
            hVar.f++;
        }
    }
}
