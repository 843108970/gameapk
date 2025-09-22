package com.google.a.d.c;

final class m extends c {
    m() {
    }

    public final int a() {
        return 2;
    }

    /* access modifiers changed from: package-private */
    public final int a(char c2, StringBuilder sb) {
        int i;
        int i2;
        char c3;
        if (c2 == ' ') {
            c3 = 3;
        } else {
            if (c2 >= '0' && c2 <= '9') {
                i2 = (c2 - '0') + 4;
            } else if (c2 < 'a' || c2 > 'z') {
                if (c2 < ' ') {
                    sb.append(0);
                } else {
                    char c4 = '!';
                    if (c2 >= '!' && c2 <= '/') {
                        sb.append(1);
                    } else if (c2 >= ':' && c2 <= '@') {
                        sb.append(1);
                        i = (c2 - ':') + 15;
                        c2 = (char) i;
                    } else if (c2 < '[' || c2 > '_') {
                        c4 = '`';
                        if (c2 == '`') {
                            sb.append(2);
                        } else if (c2 >= 'A' && c2 <= 'Z') {
                            sb.append(2);
                            i = (c2 - 'A') + 1;
                            c2 = (char) i;
                        } else if (c2 < '{' || c2 > 127) {
                            sb.append("\u0001\u001e");
                            return a((char) (c2 - 128), sb) + 2;
                        } else {
                            sb.append(2);
                            i = (c2 - '{') + 27;
                            c2 = (char) i;
                        }
                    } else {
                        sb.append(1);
                        i = (c2 - '[') + 22;
                        c2 = (char) i;
                    }
                    i = c2 - c4;
                    c2 = (char) i;
                }
                sb.append(c2);
                return 2;
            } else {
                i2 = (c2 - 'a') + 14;
            }
            c3 = (char) i2;
        }
        sb.append(c3);
        return 1;
    }
}
