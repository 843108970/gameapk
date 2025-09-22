package com.b.a.a.h;

import javax.security.auth.x500.X500Principal;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f740a;

    /* renamed from: b  reason: collision with root package name */
    private final int f741b = this.f740a.length();

    /* renamed from: c  reason: collision with root package name */
    private int f742c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    public c(X500Principal x500Principal) {
        this.f740a = x500Principal.getName("RFC2253");
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.f741b) {
            throw new IllegalStateException("Malformed DN: " + this.f740a);
        }
        char c2 = this.g[i];
        if (c2 >= '0' && c2 <= '9') {
            i2 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i2 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f740a);
        } else {
            i2 = c2 - '7';
        }
        char c3 = this.g[i4];
        if (c3 >= '0' && c3 <= '9') {
            i3 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i3 = c3 - 'W';
        } else if (c3 < 'A' || c3 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f740a);
        } else {
            i3 = c3 - '7';
        }
        return (i2 << 4) + i3;
    }

    private String a() {
        while (this.f742c < this.f741b && this.g[this.f742c] == ' ') {
            this.f742c++;
        }
        if (this.f742c == this.f741b) {
            return null;
        }
        this.d = this.f742c;
        do {
            this.f742c++;
            if (this.f742c >= this.f741b || this.g[this.f742c] == '=' || this.g[this.f742c] == ' ') {
            }
            this.f742c++;
            break;
        } while (this.g[this.f742c] == ' ');
        if (this.f742c >= this.f741b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f740a);
        }
        this.e = this.f742c;
        if (this.g[this.f742c] == ' ') {
            while (this.f742c < this.f741b && this.g[this.f742c] != '=' && this.g[this.f742c] == ' ') {
                this.f742c++;
            }
            if (this.g[this.f742c] != '=' || this.f742c == this.f741b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f740a);
            }
        }
        do {
            this.f742c++;
            if (this.f742c >= this.f741b || this.g[this.f742c] != ' ') {
            }
            this.f742c++;
            break;
        } while (this.g[this.f742c] != ' ');
        if (this.e - this.d > 4 && this.g[this.d + 3] == '.' && ((this.g[this.d] == 'O' || this.g[this.d] == 'o') && ((this.g[this.d + 1] == 'I' || this.g[this.d + 1] == 'i') && (this.g[this.d + 2] == 'D' || this.g[this.d + 2] == 'd')))) {
            this.d += 4;
        }
        return new String(this.g, this.d, this.e - this.d);
    }

    private String b() {
        if (this.f742c + 4 >= this.f741b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f740a);
        }
        this.d = this.f742c;
        int i = this.f742c;
        while (true) {
            this.f742c = i + 1;
            if (this.f742c == this.f741b || this.g[this.f742c] == '+' || this.g[this.f742c] == ',' || this.g[this.f742c] == ';') {
                this.e = this.f742c;
            } else if (this.g[this.f742c] == ' ') {
                this.e = this.f742c;
                do {
                    this.f742c++;
                    if (this.f742c >= this.f741b) {
                        break;
                    }
                } while (this.g[this.f742c] != ' ');
            } else {
                if (this.g[this.f742c] >= 'A' && this.g[this.f742c] <= 'F') {
                    char[] cArr = this.g;
                    int i2 = this.f742c;
                    cArr[i2] = (char) (cArr[i2] + ' ');
                }
                i = this.f742c;
            }
        }
        this.e = this.f742c;
        int i3 = this.e - this.d;
        if (i3 < 5 || (i3 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f740a);
        }
        byte[] bArr = new byte[(i3 / 2)];
        int i4 = this.d + 1;
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr[i5] = (byte) a(i4);
            i4 += 2;
        }
        return new String(this.g, this.d, i3);
    }

    private String c() {
        this.d = this.f742c;
        this.e = this.f742c;
        while (this.f742c < this.f741b) {
            char c2 = this.g[this.f742c];
            if (c2 != ' ') {
                if (c2 != ';') {
                    if (c2 != '\\') {
                        switch (c2) {
                            case '+':
                            case ',':
                                break;
                            default:
                                char[] cArr = this.g;
                                int i = this.e;
                                this.e = i + 1;
                                cArr[i] = this.g[this.f742c];
                                break;
                        }
                    } else {
                        char[] cArr2 = this.g;
                        int i2 = this.e;
                        this.e = i2 + 1;
                        cArr2[i2] = d();
                    }
                    this.f742c++;
                }
                return new String(this.g, this.d, this.e - this.d);
            }
            this.f = this.e;
            this.f742c++;
            char[] cArr3 = this.g;
            int i3 = this.e;
            this.e = i3 + 1;
            cArr3[i3] = ' ';
            while (this.f742c < this.f741b && this.g[this.f742c] == ' ') {
                char[] cArr4 = this.g;
                int i4 = this.e;
                this.e = i4 + 1;
                cArr4[i4] = ' ';
                this.f742c++;
            }
            if (this.f742c == this.f741b || this.g[this.f742c] == ',' || this.g[this.f742c] == '+' || this.g[this.f742c] == ';') {
                return new String(this.g, this.d, this.f - this.d);
            }
        }
        return new String(this.g, this.d, this.e - this.d);
    }

    private char d() {
        this.f742c++;
        if (this.f742c == this.f741b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f740a);
        }
        char c2 = this.g[this.f742c];
        if (!(c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_')) {
            switch (c2) {
                case '\"':
                case '#':
                    break;
                default:
                    switch (c2) {
                        case '*':
                        case '+':
                        case ',':
                            break;
                        default:
                            switch (c2) {
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                    break;
                                default:
                                    return e();
                            }
                    }
            }
        }
        return this.g[this.f742c];
    }

    private char e() {
        int i;
        int i2;
        int a2 = a(this.f742c);
        this.f742c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i2 = a2 & 31;
            i = 1;
        } else if (a2 <= 239) {
            i = 2;
            i2 = a2 & 15;
        } else {
            i = 3;
            i2 = a2 & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f742c++;
            if (this.f742c == this.f741b || this.g[this.f742c] != '\\') {
                return '?';
            }
            this.f742c++;
            int a3 = a(this.f742c);
            this.f742c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
        }
        return (char) i2;
    }

    public final String a(String str) {
        this.f742c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.f740a.toCharArray();
        String a2 = a();
        if (a2 == null) {
            return null;
        }
        do {
            String str2 = "";
            if (this.f742c == this.f741b) {
                return null;
            }
            switch (this.g[this.f742c]) {
                case '\"':
                    this.f742c++;
                    this.d = this.f742c;
                    int i = this.d;
                    while (true) {
                        this.e = i;
                        if (this.f742c == this.f741b) {
                            throw new IllegalStateException("Unexpected end of DN: " + this.f740a);
                        } else if (this.g[this.f742c] == '\"') {
                            do {
                                this.f742c++;
                                if (this.f742c >= this.f741b || this.g[this.f742c] != ' ') {
                                    str2 = new String(this.g, this.d, this.e - this.d);
                                    break;
                                }
                                this.f742c++;
                                str2 = new String(this.g, this.d, this.e - this.d);
                            } while (this.g[this.f742c] != ' ');
                            str2 = new String(this.g, this.d, this.e - this.d);
                        } else {
                            if (this.g[this.f742c] == '\\') {
                                this.g[this.e] = d();
                            } else {
                                this.g[this.e] = this.g[this.f742c];
                            }
                            this.f742c++;
                            i = this.e + 1;
                        }
                    }
                case '#':
                    str2 = b();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    str2 = c();
                    break;
            }
            if (str.equalsIgnoreCase(a2)) {
                return str2;
            }
            if (this.f742c >= this.f741b) {
                return null;
            }
            if (this.g[this.f742c] == ',' || this.g[this.f742c] == ';' || this.g[this.f742c] == '+') {
                this.f742c++;
                a2 = a();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f740a);
            }
        } while (a2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f740a);
    }
}
